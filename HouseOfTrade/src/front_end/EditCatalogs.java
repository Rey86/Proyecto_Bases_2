package front_end;

public class EditCatalogs extends javax.swing.JDialog {

    public EditCatalogs(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPaymentMethod = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnNationality = new javax.swing.JButton();
        btnCommunity = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnCanton = new javax.swing.JButton();
        btnProvince = new javax.swing.JButton();
        btnCountry = new javax.swing.JButton();
        btnGender = new javax.swing.JButton();
        btnCategory = new javax.swing.JButton();
        btnDeliveryType = new javax.swing.JButton();
        btnUserType = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnPaymentMethod.setText("Payment Method");
        btnPaymentMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentMethodActionPerformed(evt);
            }
        });

        jLabel1.setText("Catalogs ");

        btnNationality.setText("Nationality");
        btnNationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNationalityActionPerformed(evt);
            }
        });

        btnCommunity.setText("Community");
        btnCommunity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommunityActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnCanton.setText("Canton");
        btnCanton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantonActionPerformed(evt);
            }
        });

        btnProvince.setText("Province");
        btnProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvinceActionPerformed(evt);
            }
        });

        btnCountry.setText("Country");
        btnCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCountryActionPerformed(evt);
            }
        });

        btnGender.setText("Gender");
        btnGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenderActionPerformed(evt);
            }
        });

        btnCategory.setText("Category");
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });

        btnDeliveryType.setText("Delivery Type");
        btnDeliveryType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryTypeActionPerformed(evt);
            }
        });

        btnUserType.setText("User Type");
        btnUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProvince)
                    .addComponent(btnCountry)
                    .addComponent(jLabel1)
                    .addComponent(btnCommunity)
                    .addComponent(btnCanton)
                    .addComponent(btnNationality))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGender)
                    .addComponent(btnCategory)
                    .addComponent(btnDeliveryType)
                    .addComponent(btnUserType)
                    .addComponent(btnPaymentMethod))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCommunity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCanton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeliveryType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProvince, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCountry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPaymentMethod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNationality))
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPaymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentMethodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPaymentMethodActionPerformed

    private void btnNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNationalityActionPerformed

    private void btnCommunityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommunityActionPerformed
        /*ListCommunity dialog = new ListCommunity(new javax.swing.JFrame(), true);
        dialog.setVisible(true);*/
    }//GEN-LAST:event_btnCommunityActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantonActionPerformed
        /*ListCanton dialog = new ListCanton(new javax.swing.JFrame(), true);
        dialog.setVisible(true);*/
    }//GEN-LAST:event_btnCantonActionPerformed

    private void btnProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvinceActionPerformed
        /*ListProvince dialog = new ListProvince(new javax.swing.JFrame(), true);
        dialog.setVisible(true);*/
    }//GEN-LAST:event_btnProvinceActionPerformed

    private void btnCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCountryActionPerformed
        /*ListCountry dialog = new ListCountry(new javax.swing.JFrame(), true);
        dialog.setVisible(true);*/
    }//GEN-LAST:event_btnCountryActionPerformed

    private void btnGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenderActionPerformed
        /*ListGender dialog = new ListGender(new javax.swing.JFrame(), true);
        dialog.setVisible(true);*/
    }//GEN-LAST:event_btnGenderActionPerformed

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnDeliveryTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeliveryTypeActionPerformed

    private void btnUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanton;
    private javax.swing.JButton btnCategory;
    private javax.swing.JButton btnCommunity;
    private javax.swing.JButton btnCountry;
    private javax.swing.JButton btnDeliveryType;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGender;
    private javax.swing.JButton btnNationality;
    private javax.swing.JButton btnPaymentMethod;
    private javax.swing.JButton btnProvince;
    private javax.swing.JButton btnUserType;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
