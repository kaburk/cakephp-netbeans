/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2013 Oracle and/or its affiliates. All rights reserved.
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
 * Portions Copyrighted 2013 Sun Microsystems, Inc.
 */
package org.cakephp.netbeans.ui.wizards;

/**
 *
 * @author junichi11
 */
public class DBConfigPanel extends javax.swing.JPanel {

    /**
     * Creates new form DBConfigPanel
     */
    public DBConfigPanel() {
        initComponents();
    }

    public String getDatabase() {
        return databaseTextField.getText().trim();
    }

    public String getDatasource() {
        return datasourceTextField.getText().trim();
    }

    public String getEncoding() {
        return encodingTextField.getText().trim();
    }

    public String getHost() {
        return hostTextField.getText().trim();
    }

    public String getLogin() {
        return loginTextField.getText();
    }

    public String getPassword() {
        return String.valueOf(passwordField.getPassword());
    }

    public boolean isPersistent() {
        return persistentCheckBox.isSelected();
    }

    public String getPrefix() {
        return prefixTextField.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datasourceLabel = new javax.swing.JLabel();
        datasourceTextField = new javax.swing.JTextField();
        persistentCheckBox = new javax.swing.JCheckBox();
        hostLabel = new javax.swing.JLabel();
        hostTextField = new javax.swing.JTextField();
        loginLabel = new javax.swing.JLabel();
        loginTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        databaseLabel = new javax.swing.JLabel();
        databaseTextField = new javax.swing.JTextField();
        prefixLabel = new javax.swing.JLabel();
        prefixTextField = new javax.swing.JTextField();
        encodingLabel = new javax.swing.JLabel();
        encodingTextField = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(datasourceLabel, org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.datasourceLabel.text")); // NOI18N

        datasourceTextField.setText(org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.datasourceTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(persistentCheckBox, org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.persistentCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(hostLabel, org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.hostLabel.text")); // NOI18N

        hostTextField.setText(org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.hostTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(loginLabel, org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.loginLabel.text")); // NOI18N

        loginTextField.setText(org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.loginTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(passwordLabel, org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.passwordLabel.text")); // NOI18N

        passwordField.setText(org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.passwordField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(databaseLabel, org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.databaseLabel.text")); // NOI18N

        databaseTextField.setText(org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.databaseTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(prefixLabel, org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.prefixLabel.text")); // NOI18N

        prefixTextField.setText(org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.prefixTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(encodingLabel, org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.encodingLabel.text")); // NOI18N

        encodingTextField.setText(org.openide.util.NbBundle.getMessage(DBConfigPanel.class, "DBConfigPanel.encodingTextField.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hostLabel)
                            .addComponent(loginLabel)
                            .addComponent(datasourceLabel)
                            .addComponent(passwordLabel)
                            .addComponent(databaseLabel)
                            .addComponent(prefixLabel)
                            .addComponent(encodingLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(prefixTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(databaseTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hostTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datasourceTextField)
                            .addComponent(encodingTextField))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(persistentCheckBox)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datasourceLabel)
                    .addComponent(datasourceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(persistentCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hostLabel)
                    .addComponent(hostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel)
                    .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(databaseLabel)
                    .addComponent(databaseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prefixLabel)
                    .addComponent(prefixTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encodingLabel)
                    .addComponent(encodingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel databaseLabel;
    private javax.swing.JTextField databaseTextField;
    private javax.swing.JLabel datasourceLabel;
    private javax.swing.JTextField datasourceTextField;
    private javax.swing.JLabel encodingLabel;
    private javax.swing.JTextField encodingTextField;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JTextField hostTextField;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JCheckBox persistentCheckBox;
    private javax.swing.JLabel prefixLabel;
    private javax.swing.JTextField prefixTextField;
    // End of variables declaration//GEN-END:variables
}
