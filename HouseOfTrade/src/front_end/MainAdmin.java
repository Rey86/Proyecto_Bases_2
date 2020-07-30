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

        btnListProducts = new javax.swing.JButton();
        btnPurchaseProducts = new javax.swing.JButton();
        btnEditCatalogs = new javax.swing.JButton();
        btnQueries = new javax.swing.JButton();
        btnStatistics = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnEditProfile = new javax.swing.JButton();
        jButtonReview = new javax.swing.JButton();
        jButtonConversation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnListProducts.setText("List Products");
        btnListProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListProductsActionPerformed(evt);
            }
        });

        btnPurchaseProducts.setText("Purchase Products");
        btnPurchaseProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseProductsActionPerformed(evt);
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

        jButtonReview.setText("Review Customers");
        jButtonReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReviewActionPerformed(evt);
            }
        });

        jButtonConversation.setText("Conversation Module");
        jButtonConversation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConversationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnListProducts)
                    .addComponent(jButtonConversation)
                    .addComponent(btnPurchaseProducts)
                    .addComponent(btnEditCatalogs)
                    .addComponent(btnQueries)
                    .addComponent(btnStatistics)
                    .addComponent(btnExit)
                    .addComponent(btnEditProfile)
                    .addComponent(jButtonReview))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListProducts)
                .addGap(18, 18, 18)
                .addComponent(btnPurchaseProducts)
                .addGap(18, 18, 18)
                .addComponent(btnEditCatalogs)
                .addGap(18, 18, 18)
                .addComponent(btnQueries)
                .addGap(18, 18, 18)
                .addComponent(btnStatistics)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonReview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConversation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListProductsActionPerformed
        ListProduct dialog = new ListProduct(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnListProductsActionPerformed

    private void btnPurchaseProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseProductsActionPerformed
        BuyProduct dialog = new BuyProduct(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnPurchaseProductsActionPerformed

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

    private void jButtonReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReviewActionPerformed
        Customers dialog = new Customers(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonReviewActionPerformed

    private void jButtonConversationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConversationActionPerformed
        ConversationList dialog = new ConversationList(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonConversationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditCatalogs;
    private javax.swing.JButton btnEditProfile;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnListProducts;
    private javax.swing.JButton btnPurchaseProducts;
    private javax.swing.JButton btnQueries;
    private javax.swing.JButton btnStatistics;
    private javax.swing.JButton jButtonConversation;
    private javax.swing.JButton jButtonReview;
    // End of variables declaration//GEN-END:variables
}
