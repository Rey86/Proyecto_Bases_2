package front_end;

public class MainUser extends javax.swing.JDialog {

    
    public MainUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegisterProduct = new javax.swing.JButton();
        btnViewProducts = new javax.swing.JButton();
        btnQueries = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

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

        btnQueries.setText("Queries");
        btnQueries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueriesActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnQueries)
                    .addComponent(btnExit)
                    .addComponent(btnRegisterProduct)
                    .addComponent(btnViewProducts))
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
                .addComponent(btnQueries)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegisterProductActionPerformed

    private void btnViewProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewProductsActionPerformed

    private void btnQueriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQueriesActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnQueries;
    private javax.swing.JButton btnRegisterProduct;
    private javax.swing.JButton btnViewProducts;
    // End of variables declaration//GEN-END:variables
}
