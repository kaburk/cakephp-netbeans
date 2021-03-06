/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2012 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2012 Sun Microsystems, Inc.
 */
package org.cakephp.netbeans;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cakephp.netbeans.commands.CakePhpCommandSupport;
import org.cakephp.netbeans.editor.codecompletion.CakePhpEditorExtenderFactory;
import org.cakephp.netbeans.modules.CakePhpModule;
import org.cakephp.netbeans.modules.CakePhpModule.DIR_TYPE;
import org.cakephp.netbeans.options.CakePhpOptions;
import org.cakephp.netbeans.preferences.CakePreferences;
import org.cakephp.netbeans.versions.CakeVersion;
import org.netbeans.modules.php.api.framework.BadgeIcon;
import org.netbeans.modules.php.api.phpmodule.PhpModule;
import org.netbeans.modules.php.api.phpmodule.PhpModuleProperties;
import org.netbeans.modules.php.api.util.FileUtils;
import org.netbeans.modules.php.spi.editor.EditorExtender;
import org.netbeans.modules.php.spi.framework.PhpFrameworkProvider;
import org.netbeans.modules.php.spi.framework.PhpModuleActionsExtender;
import org.netbeans.modules.php.spi.framework.PhpModuleCustomizerExtender;
import org.netbeans.modules.php.spi.framework.PhpModuleExtender;
import org.netbeans.modules.php.spi.framework.PhpModuleIgnoredFilesExtender;
import org.netbeans.modules.php.spi.framework.commands.FrameworkCommandSupport;
import org.openide.awt.NotificationDisplayer;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

// TODO: in static block, consider registering *.ctp as a php mime-type (can be dangerous, do it only if it's not already set!)
public final class CakePhpFrameworkProvider extends PhpFrameworkProvider {

    // TODO: provide better badge icon
    private static final String ICON_PATH = "org/cakephp/netbeans/ui/resources/cakephp_badge_8.png"; // NOI18N
    private static final CakePhpFrameworkProvider INSTANCE = new CakePhpFrameworkProvider();
    private static final Comparator<File> FILE_COMPARATOR = new Comparator<File>() {
        @Override
        public int compare(File o1, File o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    };
    private final BadgeIcon badgeIcon;
    private static final Logger LOGGER = Logger.getLogger(CakePhpFrameworkProvider.class.getName());

    private CakePhpFrameworkProvider() {
        super("cakephp", // NOI18N
                NbBundle.getMessage(CakePhpFrameworkProvider.class, "LBL_CakePhpFramework"),
                NbBundle.getMessage(CakePhpFrameworkProvider.class, "LBL_CakePhpDescription"));
        badgeIcon = new BadgeIcon(
                ImageUtilities.loadImage(ICON_PATH),
                CakePhpFrameworkProvider.class.getResource("/" + ICON_PATH)); // NOI18N
    }

    @PhpFrameworkProvider.Registration(position = 500)
    public static CakePhpFrameworkProvider getInstance() {
        return INSTANCE;
    }

    @Override
    public BadgeIcon getBadgeIcon() {
        return badgeIcon;
    }

    @Override
    public boolean isInPhpModule(PhpModule phpModule) {
        Boolean enabled = CakePreferences.isEnabled(phpModule);
        if (enabled != null) {
            // manually
            return enabled;
        }
        // automatically
        CakePhpModule cakeModule = CakePhpModule.forPhpModule(phpModule);
        return cakeModule == null ? false : cakeModule.isInCakePhp();
    }

    @NbBundle.Messages({
        "# {0} - name",
        "CakePhpFrameworkProvider.config.invalid=app config directory not found for CakePHP project {0}"
    })
    @Override
    public File[] getConfigurationFiles(PhpModule phpModule) {
        // return all php files from app/config
        CakePhpModule cakeModule = CakePhpModule.forPhpModule(phpModule);
        if (cakeModule == null) {
            return new File[0];
        }
        List<File> configFiles = new LinkedList<File>();
        FileObject config = cakeModule.getConfigDirectory(DIR_TYPE.APP);
        if (config == null) {
            LOGGER.log(Level.WARNING, Bundle.CakePhpFrameworkProvider_config_invalid(phpModule.getDisplayName()));
            return new File[0];
        }
        if (config.isFolder()) {
            Enumeration<? extends FileObject> children = config.getChildren(true);
            while (children.hasMoreElements()) {
                FileObject child = children.nextElement();
                if (child.isData() && FileUtils.isPhpFile(child)) {
                    configFiles.add(FileUtil.toFile(child));
                }
            }
        }
        if (!configFiles.isEmpty()) {
            Collections.sort(configFiles, FILE_COMPARATOR);
        }
        return configFiles.toArray(new File[configFiles.size()]);
    }

    @Override
    public PhpModuleExtender createPhpModuleExtender(PhpModule phpModule) {
        return new CakePhpModuleExtender();
    }

    @Override
    public PhpModuleCustomizerExtender createPhpModuleCustomizerExtender(PhpModule phpModule) {
        CakePhpModuleCustomizerExtender customizer = new CakePhpModuleCustomizerExtender(phpModule);
        CakePhpModule cakeModule = CakePhpModule.forPhpModule(phpModule);
        if (cakeModule != null) {
            customizer.addChangeListener(cakeModule);
        }
        return customizer;
    }

    @Override
    public PhpModuleProperties getPhpModuleProperties(PhpModule phpModule) {
        PhpModuleProperties properties = new PhpModuleProperties();
        CakePhpModule module = CakePhpModule.forPhpModule(phpModule);
        if (module == null) {
            return properties;
        }
        FileObject webroot = module.getWebrootDirectory(DIR_TYPE.APP);
        if (webroot != null) {
            properties = properties.setWebRoot(webroot);
        }
        FileObject test = module.getTestDirectory(DIR_TYPE.APP);
        if (test != null) {
            properties = properties.setTests(test);
        }
        return properties;
    }

    @Override
    public PhpModuleActionsExtender getActionsExtender(PhpModule phpModule) {
        return new CakePhpActionsExtender();
    }

    @Override
    public PhpModuleIgnoredFilesExtender getIgnoredFilesExtender(PhpModule phpModule) {
        return new CakePhpIgnoredFilesExtender(phpModule);
    }

    @Override
    public FrameworkCommandSupport getFrameworkCommandSupport(PhpModule phpModule) {
        return new CakePhpCommandSupport(phpModule);
    }

    @Override
    public EditorExtender getEditorExtender(PhpModule phpModule) {
        return CakePhpEditorExtenderFactory.create(phpModule);
    }

    @Override
    public void phpModuleOpened(PhpModule phpModule) {
        // check available new version
        if (CakePhpOptions.getInstance().isNotifyNewVersion()) {
            notificationNewVersion(phpModule);
        }
    }

    @NbBundle.Messages({
        "# {0} - project name",
        "# {1} - new version",
        "CakePhpFrameworkProvider.new.version.notification.title={0} : New version({1}) is available"
    })
    private void notificationNewVersion(PhpModule phpModule) {
        CakePhpModule cakeModule = CakePhpModule.forPhpModule(phpModule);
        if (cakeModule == null) {
            return;
        }
        CakeVersion version = cakeModule.getCakeVersion();
        if (version.hasUpdate()) {
            // Notification
            NotificationDisplayer notification = NotificationDisplayer.getDefault();
            String latestStableVersion = version.getLatestStableVersion();
            notification.notify(
                    Bundle.CakePhpFrameworkProvider_new_version_notification_title(phpModule.getDisplayName(), latestStableVersion),
                    ImageUtilities.loadImageIcon(CakePhp.CAKE_ICON_16, false),
                    Bundle.CakePhpFrameworkProvider_new_version_notification_title(phpModule.getDisplayName(), latestStableVersion),
                    null);
        }
    }

}
