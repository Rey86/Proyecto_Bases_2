package front_end;

public class MainAdmin extends javax.swing.JDialog {
    private String username;

    public MainAdmin(java.awt.Frame parent, boolean modal, String username) {
        super(parent, modal);
        this.username = username;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegisterProduct = new javax.swing.JButton();
        btnViewProducts = new javax.swing.JButton();
        btnEditCatalogs = new javax.swing.JButton();
        btnQueries = new javax.swing.JButton();
        btnStatistics = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnEditProfile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnRegisterProduct.setText("Register Product");
        btnRegisterProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterProductActionPerformed(evt);
            }
        });

        btnViewProducts.setText("View Products");
        btnViewProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProductsActionPerformed(evt);
            }
        });

        btnEditCatalogs.setText("Edit Catalogs");
        btnEditCatalogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCatalogsActionPerformed(evt);
            }
        });

        btnQueries.setText("Queries");
        btnQueries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueriesActionPerformed(evt);
            }
        });

        btnStatistics.setText("Statistics");
        btnStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatisticsActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnEditProfile.setText("Edit Profile");
        btnEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnRegisterProduct)
                    .addComponent(btnEditCatalogs)
                    .addComponent(btnViewProducts)
                    .addComponent(btnQueries)
                    .addComponent(btnStatistics)
                    .addComponent(btnExit)
                    .addComponent(btnEditProfile))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegisterProduct)
                .addGap(18, 18, 18)
                .addComponent(btnViewProducts)
                .addGap(18, 18, 18)
                .addComponent(btnEditCatalogs)
                .addGap(18, 18, 18)
                .addComponent(btnQueries)
                .addGap(18, 18, 18)
                .addComponent(btnStatistics)
                .addGap(18, 18, 18)
                .addComponent(btnEditProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterProductActionPerformed
        RegisterProduct dialog = new RegisterProduct(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnRegisterProductActionPerformed

    private void btnViewProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewProductsActionPerformed

    private void btnEditCatalogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCatalogsActionPerformed
        EditCatalogs dialog = new EditCatalogs(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnEditCatalogsActionPerformed

    private void btnQueriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueriesActionPerformed
        QueriesAdmin dialog = new QueriesAdmin(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnQueriesActionPerformed

    private void btnStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticsActionPerformed
        Statistics dialog = new Statistics(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnStatisticsActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProfileActionPerformed
        Register dialog = new Register(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnEditProfileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditCatalogs;
    private javax.swing.JButton btnEditProfile;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnQueries;
    private javax.swing.JButton btnRegisterProduct;
    private javax.swing.JButton btnStatistics;
    private javax.swing.JButton btnViewProducts;
    // End of variables declaration//GEN-END:variables
}
