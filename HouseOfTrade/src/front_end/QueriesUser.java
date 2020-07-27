package front_end;

public class QueriesUser extends javax.swing.JDialog {
    private String username;
   
    public QueriesUser(java.awt.Frame parent, boolean modal, String username) {
        super(parent, modal);
        this.username = username;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnViewsHistory = new javax.swing.JButton();
        btnSoldProduct = new javax.swing.JButton();
        btnSearchProducts = new javax.swing.JButton();
        btnPurchasesOver1000 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnPurchaseHistory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Queries User");

        btnViewsHistory.setText("Views History");
        btnViewsHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewsHistoryActionPerformed(evt);
            }
        });

        btnSoldProduct.setText("Sold Products");
        btnSoldProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoldProductActionPerformed(evt);
            }
        });

        btnSearchProducts.setText("Search Products");
        btnSearchProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductsActionPerformed(evt);
            }
        });

        btnPurchasesOver1000.setText("Purchases Over 1000");
        btnPurchasesOver1000.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchasesOver1000ActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnPurchaseHistory.setText("Purchase History");
        btnPurchaseHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnViewsHistory)
                    .addComponent(btnSoldProduct)
                    .addComponent(btnSearchProducts)
                    .addComponent(btnPurchasesOver1000)
                    .addComponent(btnExit)
                    .addComponent(btnPurchaseHistory)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnSearchProducts)
                .addGap(18, 18, 18)
                .addComponent(btnPurchaseHistory)
                .addGap(18, 18, 18)
                .addComponent(btnViewsHistory)
                .addGap(18, 18, 18)
                .addComponent(btnSoldProduct)
                .addGap(18, 18, 18)
                .addComponent(btnPurchasesOver1000)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewsHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewsHistoryActionPerformed
        viewsHistory dialog = new viewsHistory(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnViewsHistoryActionPerformed

    private void btnSoldProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoldProductActionPerformed
        SoldProduct dialog = new SoldProduct(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnSoldProductActionPerformed

    private void btnSearchProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductsActionPerformed
        SearchProducts dialog = new SearchProducts(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnSearchProductsActionPerformed

    private void btnPurchasesOver1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchasesOver1000ActionPerformed
        PurchasesOver1000 dialog = new PurchasesOver1000(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnPurchasesOver1000ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPurchaseHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseHistoryActionPerformed
        PurchaseHistory dialog = new PurchaseHistory(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnPurchaseHistoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPurchaseHistory;
    private javax.swing.JButton btnPurchasesOver1000;
    private javax.swing.JButton btnSearchProducts;
    private javax.swing.JButton btnSoldProduct;
    private javax.swing.JButton btnViewsHistory;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
