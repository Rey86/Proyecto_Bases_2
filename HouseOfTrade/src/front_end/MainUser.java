package front_end;

public class MainUser extends javax.swing.JDialog {
    private String username;
    
    public MainUser(java.awt.Frame parent, boolean modal, String username) {
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
        btnQueries = new javax.swing.JButton();
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
                    .addComponent(btnExit)
                    .addComponent(btnEditProfile)
                    .addComponent(jButtonReview)
                    .addComponent(jButtonConversation)
                    .addComponent(btnListProducts)
                    .addComponent(btnPurchaseProducts)
                    .addComponent(btnQueries))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListProducts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPurchaseProducts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQueries)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonReview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConversation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnQueriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueriesActionPerformed
        QueriesUser dialog = new QueriesUser(new javax.swing.JFrame(), true, username);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnQueriesActionPerformed

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
    private javax.swing.JButton btnEditProfile;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnListProducts;
    private javax.swing.JButton btnPurchaseProducts;
    private javax.swing.JButton btnQueries;
    private javax.swing.JButton jButtonConversation;
    private javax.swing.JButton jButtonReview;
    // End of variables declaration//GEN-END:variables
}
