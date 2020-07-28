package front_end;

public class QueriesAdmin extends javax.swing.JDialog {
    private String username;

    public QueriesAdmin(java.awt.Frame parent, boolean modal, String username) {
        super(parent, modal);
        this.username = username;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnTopUserSales = new javax.swing.JButton();
        btnTopUserPurchases = new javax.swing.JButton();
        btnBestReviewedUsers = new javax.swing.JButton();
        btnWorstReviewedUsers = new javax.swing.JButton();
        btnTopPricesPerCategory = new javax.swing.JButton();
        btnTopPurchaseAmountPerCategory = new javax.swing.JButton();
        btnSearchProducts = new javax.swing.JButton();
        btnPurchaseHistory = new javax.swing.JButton();
        btnViewsHistory = new javax.swing.JButton();
        btnSoldProduct = new javax.swing.JButton();
        btnPurchasesOver1000 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Queries Admin");

        btnTopUserSales.setText("Top Users Sales");
        btnTopUserSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopUserSalesActionPerformed(evt);
            }
        });

        btnTopUserPurchases.setText("Top Users Purchases");
        btnTopUserPurchases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopUserPurchasesActionPerformed(evt);
            }
        });

        btnBestReviewedUsers.setText("Best Reviewed Users");
        btnBestReviewedUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBestReviewedUsersActionPerformed(evt);
            }
        });

        btnWorstReviewedUsers.setText("Worst Reviewed Users");
        btnWorstReviewedUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWorstReviewedUsersActionPerformed(evt);
            }
        });

        btnTopPricesPerCategory.setText("Top Prices Per Category");
        btnTopPricesPerCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopPricesPerCategoryActionPerformed(evt);
            }
        });

        btnTopPurchaseAmountPerCategory.setText("Top Purchase Amount Per Category");
        btnTopPurchaseAmountPerCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopPurchaseAmountPerCategoryActionPerformed(evt);
            }
        });

        btnSearchProducts.setText("Search Products");
        btnSearchProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductsActionPerformed(evt);
            }
        });

        btnPurchaseHistory.setText("Purchase History");
        btnPurchaseHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseHistoryActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnTopUserSales)
                    .addComponent(jLabel1)
                    .addComponent(btnTopUserPurchases)
                    .addComponent(btnViewsHistory)
                    .addComponent(btnBestReviewedUsers)
                    .addComponent(btnSoldProduct)
                    .addComponent(btnWorstReviewedUsers)
                    .addComponent(btnTopPricesPerCategory)
                    .addComponent(btnTopPurchaseAmountPerCategory)
                    .addComponent(btnSearchProducts)
                    .addComponent(btnPurchasesOver1000)
                    .addComponent(btnExit)
                    .addComponent(btnPurchaseHistory))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnTopUserSales)
                .addGap(18, 18, 18)
                .addComponent(btnTopUserPurchases)
                .addGap(18, 18, 18)
                .addComponent(btnBestReviewedUsers)
                .addGap(18, 18, 18)
                .addComponent(btnWorstReviewedUsers)
                .addGap(18, 18, 18)
                .addComponent(btnTopPricesPerCategory)
                .addGap(18, 18, 18)
                .addComponent(btnTopPurchaseAmountPerCategory)
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

    private void btnTopUserSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopUserSalesActionPerformed
        TopUserSales dialog = new TopUserSales(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnTopUserSalesActionPerformed

    private void btnTopUserPurchasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopUserPurchasesActionPerformed
        TopUserPurchases dialog = new TopUserPurchases(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnTopUserPurchasesActionPerformed

    private void btnBestReviewedUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBestReviewedUsersActionPerformed
        BestReviewedUsers dialog = new BestReviewedUsers(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnBestReviewedUsersActionPerformed

    private void btnWorstReviewedUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorstReviewedUsersActionPerformed
        WorstReviewedUsers dialog = new WorstReviewedUsers(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnWorstReviewedUsersActionPerformed

    private void btnTopPricesPerCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopPricesPerCategoryActionPerformed
        TopPricesPerCategory dialog = new TopPricesPerCategory(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnTopPricesPerCategoryActionPerformed

    private void btnTopPurchaseAmountPerCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopPurchaseAmountPerCategoryActionPerformed
        MaxMinPurchaseAmountPerCategory dialog = new MaxMinPurchaseAmountPerCategory(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnTopPurchaseAmountPerCategoryActionPerformed

    private void btnSearchProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductsActionPerformed
        SearchProducts dialog = new SearchProducts(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnSearchProductsActionPerformed

    private void btnPurchaseHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseHistoryActionPerformed
        PurchaseHistory dialog = new PurchaseHistory(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnPurchaseHistoryActionPerformed

    private void btnViewsHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewsHistoryActionPerformed
        viewsHistory dialog = new viewsHistory(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnViewsHistoryActionPerformed

    private void btnSoldProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoldProductActionPerformed
        SoldProduct dialog = new SoldProduct(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnSoldProductActionPerformed

    private void btnPurchasesOver1000ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchasesOver1000ActionPerformed
        PurchasesOver1000 dialog = new PurchasesOver1000(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnPurchasesOver1000ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBestReviewedUsers;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPurchaseHistory;
    private javax.swing.JButton btnPurchasesOver1000;
    private javax.swing.JButton btnSearchProducts;
    private javax.swing.JButton btnSoldProduct;
    private javax.swing.JButton btnTopPricesPerCategory;
    private javax.swing.JButton btnTopPurchaseAmountPerCategory;
    private javax.swing.JButton btnTopUserPurchases;
    private javax.swing.JButton btnTopUserSales;
    private javax.swing.JButton btnViewsHistory;
    private javax.swing.JButton btnWorstReviewedUsers;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
