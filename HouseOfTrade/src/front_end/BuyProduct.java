package front_end;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuyProduct extends javax.swing.JDialog {

    public BuyProduct(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void ProductList() throws SQLException{
        ResultSet r = logic_connection.DataBaseConnection.getProducts();
        DefaultTableModel dtb = (DefaultTableModel) jTableProducts.getModel();
        while(r.next()){
            ResultSet s = logic_connection.DataBaseConnection.getProductStars(r.getInt("ID_PRODUCT"));
            while(s.next()){
                if (!String.valueOf(r.getInt("QUANTITY")).equals("0"))
                dtb.addRow(new Object[]{r.getInt("ID_PRODUCT"), r.getString("NAME_PRODUCT"), r.getInt("PRICE"), 
                    r.getInt("QUANTITY"), r.getString("DELIVERYTYPE_NAME"), r.getString("CATEGORY_NAME"), 
                    r.getString("USERNAME_SALESMAN"), s.getDouble("STARS")});
            }
        }
    }
    
    public void ProductCleanList(){
        DefaultTableModel dtb = (DefaultTableModel) jTableProducts.getModel();
        for (int i = dtb.getRowCount()-1;i>=0;i--) dtb.removeRow(i);
    }
    
    public void ProductCartList() throws SQLException{
        ResultSet r = logic_connection.DataBaseConnection.getCountries();
        DefaultTableModel dtb = (DefaultTableModel) jTableProductsCart.getModel();
        while(r.next()){
            dtb.addRow(new Object[]{r.getInt("ID_COUNTRY"), r.getString("NAME")});
        }
    }
    
    public void ProductCartCleanList(){
        DefaultTableModel dtb = (DefaultTableModel) jTableProductsCart.getModel();
        for (int i = dtb.getRowCount()-1;i>=0;i--) dtb.removeRow(i);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jButtonSearch = new javax.swing.JButton();
        jButtonAddToCart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableProductsCart = new javax.swing.JTable();
        jButtonRemove = new javax.swing.JButton();
        jTextFieldQuantity = new javax.swing.JTextField();
        jButtonPurchase = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonView = new javax.swing.JButton();
        jButtonWish = new javax.swing.JButton();
        jButtonWhised = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Buy product or add to cart");

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Product", "Name", "Price", "Stock", "Delivery Type", "Category", "Salesman", "Stars"
            }
        ));
        jScrollPane1.setViewportView(jTableProducts);

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonAddToCart.setText("Add to Cart");

        jLabel2.setText("Cart:");

        jTableProductsCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Product", "Name", "Price", "Delivery Type", "Category", "Salesman", "Stars", "Quantity"
            }
        ));
        jScrollPane3.setViewportView(jTableProductsCart);

        jButtonRemove.setText("Remove from cart");

        jButtonPurchase.setText("Purchase");

        jButtonClose.setText("Close");

        jLabel3.setText("Quantity:");

        jButtonView.setText("View");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });

        jButtonWish.setText("Add to Wish List");
        jButtonWish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWishActionPerformed(evt);
            }
        });

        jButtonWhised.setText("Wished");
        jButtonWhised.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWhisedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRemove)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPurchase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonWhised))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAddToCart)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonView)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonWish)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch)
                    .addComponent(jButtonWhised))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddToCart)
                    .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonView)
                    .addComponent(jButtonWish))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemove)
                    .addComponent(jButtonPurchase)
                    .addComponent(jButtonClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonViewActionPerformed

    private void jButtonWishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWishActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonWishActionPerformed

    private void jButtonWhisedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWhisedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonWhisedActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        
    }//GEN-LAST:event_jButtonSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddToCart;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonPurchase;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonView;
    private javax.swing.JButton jButtonWhised;
    private javax.swing.JButton jButtonWish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JTable jTableProductsCart;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldQuantity;
    // End of variables declaration//GEN-END:variables
}
