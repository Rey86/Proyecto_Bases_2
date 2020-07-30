package front_end;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuyProduct extends javax.swing.JDialog {
    private String username;
    
    public BuyProduct(java.awt.Frame parent, boolean modal, String username) {
        super(parent, modal);
        this.username = username;
        initComponents();
        initial();
        setLocationRelativeTo(null);
    }
    
    public void ProductList() throws SQLException{
        ResultSet r = logic_connection.DataBaseConnection.getSearchedProducts(jTextFieldFilter.getText());
        DefaultTableModel dtb = (DefaultTableModel) jTableProducts.getModel();
        while(r.next()){
            if (!String.valueOf(r.getInt("QUANTITY")).equals("0")){
                if (!String.valueOf(r.getString("SALESMAN")).equals(username)){
                    dtb.addRow(new Object[]{r.getInt("ID_PRODUCT"), r.getString("PRODUCT"), r.getInt("PRICE"), 
                        r.getInt("QUANTITY"), r.getString("DELIVERYTYPE"), r.getString("CATEGORY"), 
                        r.getString("SALESMAN")});
                }
            }
        }
    }
    
    public void ProductWishList() throws SQLException{
        ResultSet r = logic_connection.DataBaseConnection.getWishProducts(username);
        DefaultTableModel dtb = (DefaultTableModel) jTableProducts.getModel();
        while(r.next()){
            if (!String.valueOf(r.getInt("QUANTITY")).equals("0")){
                dtb.addRow(new Object[]{r.getInt("ID_PRODUCT"), r.getString("PRODUCT_NAME"), r.getInt("PRICE"), 
                    r.getInt("QUANTITY"), r.getString("DELIVERYTYPE_NAME"), r.getString("CATEGORY_NAME"), 
                    r.getString("USERNAME_SALESMAN")});
            }
        }
    }
    
    public void ProductCleanList(){
        DefaultTableModel dtb = (DefaultTableModel) jTableProducts.getModel();
        for (int i = dtb.getRowCount()-1;i>=0;i--) dtb.removeRow(i);
    }
    
    public void ProductCartList() throws SQLException{
        ResultSet r = logic_connection.DataBaseConnection.getCartProducts(username);
        DefaultTableModel dtb = (DefaultTableModel) jTableProductsCart.getModel();
        while(r.next()){
            if(!"".equals(jTextFieldQuantity.getText())){
                if (r.getInt("QUANTITY") >= Integer.parseInt(jTextFieldQuantity.getText())){
                    dtb.addRow(new Object[]{r.getInt("ID_PRODUCT"), r.getString("PRODUCT_NAME"), r.getInt("PRICE"),
                        r.getString("DELIVERYTYPE_NAME"), r.getString("CATEGORY_NAME"), 
                        r.getString("USERNAME_SALESMAN"), jTextFieldQuantity.getText()});
                }
                else {
                    JOptionPane.showMessageDialog(this, "There aren't enough products", "Warning", JOptionPane.ERROR_MESSAGE);
                    dtb.addRow(new Object[]{r.getInt("ID_PRODUCT"), r.getString("PRODUCT_NAME"), r.getInt("PRICE"),
                        r.getString("DELIVERYTYPE_NAME"), r.getString("CATEGORY_NAME"), 
                        r.getString("USERNAME_SALESMAN"), r.getInt("QUANTITY")});
                }
            } else {
                JOptionPane.showMessageDialog(this, "The quantity box is empty", "Warning", JOptionPane.ERROR_MESSAGE);
            }
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
        jTextFieldFilter = new javax.swing.JTextField();
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
        jButtonWished = new javax.swing.JButton();
        jButtonDeleteWish = new javax.swing.JButton();
        jComboBoxPaymentMethod = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

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
                "ID Product", "Name", "Price", "Stock", "Delivery Type", "Category", "Salesman"
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
        jButtonAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddToCartActionPerformed(evt);
            }
        });

        jLabel2.setText("Cart:");

        jTableProductsCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Product", "Name", "Price", "Delivery Type", "Category", "Salesman", "Quantity"
            }
        ));
        jScrollPane3.setViewportView(jTableProductsCart);

        jButtonRemove.setText("Remove from cart");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jButtonPurchase.setText("Purchase");
        jButtonPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPurchaseActionPerformed(evt);
            }
        });

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

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

        jButtonWished.setText("Wished");
        jButtonWished.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWishedActionPerformed(evt);
            }
        });

        jButtonDeleteWish.setText("Delete to Wish List");
        jButtonDeleteWish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteWishActionPerformed(evt);
            }
        });

        jLabel4.setText("Payment Method:");

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
                        .addComponent(jLabel4)
                        .addGap(13, 13, 13)
                        .addComponent(jComboBoxPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPurchase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldFilter))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonWished))
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
                                .addComponent(jButtonWish)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDeleteWish)))
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
                    .addComponent(jTextFieldFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch)
                    .addComponent(jButtonWished))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddToCart)
                    .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonView)
                    .addComponent(jButtonWish)
                    .addComponent(jButtonDeleteWish))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemove)
                    .addComponent(jButtonPurchase)
                    .addComponent(jButtonClose)
                    .addComponent(jComboBoxPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
        Integer current_row = jTableProducts.getSelectedRow();
        if(current_row != -1){
            try{
                logic_connection.DataBaseConnection.insertUserViewsProduct(username, (Integer) jTableProducts.getValueAt(current_row, 0));
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(this, e.toString(), "Warning", JOptionPane.ERROR_MESSAGE);
            }   
            InsertProduct dialog = new InsertProduct(new javax.swing.JFrame(), true, (Integer) jTableProducts.getValueAt(current_row, 0), "BQP", false);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Select a product to view", "Watch out", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonViewActionPerformed

    private void jButtonWishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWishActionPerformed
        Integer current_row = jTableProducts.getSelectedRow();
        if(current_row != -1){
            try{
                logic_connection.DataBaseConnection.insertUserWishesProduct(username, (Integer) jTableProducts.getValueAt(current_row, 0));
                JOptionPane.showMessageDialog(this, "Product was added successfully to wish list", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(this, e.toString(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a product to add in wish list", "Watch out", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonWishActionPerformed

    private void jButtonWishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWishedActionPerformed
        try{
            ProductCleanList();
            ProductWishList();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.toString(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonWishedActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        try{
            ProductCleanList();
            ProductList();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.toString(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        try{
           logic_connection.DataBaseConnection.deleteUserWantsProduct(username, 0);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.toString(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddToCartActionPerformed
        Integer current_row = jTableProducts.getSelectedRow();
        if(current_row != -1){
            try{
                logic_connection.DataBaseConnection.insertUserWantsProduct(username, (Integer) jTableProducts.getValueAt(current_row, 0));
                ProductCartCleanList();
                ProductCartList();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(this, e.toString(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
            catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(this, "Quantity box must be a number", "Warning", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a product to add into the cart", "Watch out", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_jButtonAddToCartActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        Integer current_row = jTableProductsCart.getSelectedRow();
        if(current_row != -1){
            try{
                logic_connection.DataBaseConnection.deleteUserWantsProduct(username, (Integer) jTableProductsCart.getValueAt(current_row, 0));
                ProductCartCleanList();
                ProductCartList();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(this, e.toString(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a product to delete of the cart", "Watch out", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_jButtonRemoveActionPerformed
    
    public void initial(){
        try{
            ResultSet pm = logic_connection.DataBaseConnection.getPaymentMethods();
            while(pm.next()){
                jComboBoxPaymentMethod.addItem(String.valueOf(pm.getInt("ID_PAYMENTMETHOD")) + " " + pm.getString("NAME"));
            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.toString(), "Watch out", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void jButtonPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPurchaseActionPerformed
        int count = jTableProductsCart.getModel().getRowCount();
        String current_paymentmethod = (String) jComboBoxPaymentMethod.getSelectedItem();
        Integer id_paymentmethod = Integer.valueOf(current_paymentmethod.split(" ")[0]);
        try {
            if(count > 0){
                logic_connection.DataBaseConnection.insertPurchase(username, id_paymentmethod);
                for(int c = 0; c < count; c++){
                    int productID = (Integer) jTableProductsCart.getValueAt( c, 0);
                    ResultSet r = logic_connection.DataBaseConnection.getProduct(productID);
                    while(r.next()){
                        logic_connection.DataBaseConnection.setProduct(productID, 
                        (String) jTableProductsCart.getValueAt( c, 1), 
                        r.getInt("SOLD")+Integer.parseInt(String.valueOf(jTableProductsCart.getValueAt( c, 6))), 
                        r.getString("DESCRIPTION"), 
                        r.getInt("QUANTITY")-Integer.parseInt((String.valueOf(jTableProductsCart.getValueAt( c, 6)))), 
                        (String) jTableProductsCart.getValueAt( c, 5), 
                        r.getInt("ID_CATEGORY"), r.getInt("ID_DELIVERYTYPE"));
                        ResultSet p = logic_connection.DataBaseConnection.getCurrentUserLastPurchase(username);
                        while(p.next()){
                            System.out.println("Hola");
                            logic_connection.DataBaseConnection.insertProductxPurchase(p.getInt("MAX_ID"), 
                                productID, Integer.parseInt(String.valueOf(jTableProductsCart.getValueAt(c, 6))));
                        }
                    }
                    ReviewUser dialog = new ReviewUser(new javax.swing.JFrame(), true, username, (String) jTableProductsCart.getValueAt( c, 5), 0);
                    dialog.setVisible(true);
                    ReviewProduct dialog1 = new ReviewProduct(new javax.swing.JFrame(), true, productID);
                    dialog1.setVisible(true);
                }
                JOptionPane.showMessageDialog(this, "Purchase was made successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else{
                JOptionPane.showMessageDialog(this, "The cart is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuyProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPurchaseActionPerformed

    private void jButtonDeleteWishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteWishActionPerformed
        Integer current_row = jTableProducts.getSelectedRow();
        if(current_row != -1){
            try{
                logic_connection.DataBaseConnection.deleteUserWishesProduct(username, (Integer) jTableProducts.getValueAt(current_row, 0));
                JOptionPane.showMessageDialog(this, "Product was deleted successfully to wish list", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(this, e.toString(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a product to delete in wish list", "Watch out", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteWishActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddToCart;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDeleteWish;
    private javax.swing.JButton jButtonPurchase;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonView;
    private javax.swing.JButton jButtonWish;
    private javax.swing.JButton jButtonWished;
    private javax.swing.JComboBox<String> jComboBoxPaymentMethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JTable jTableProductsCart;
    private javax.swing.JTextField jTextFieldFilter;
    private javax.swing.JTextField jTextFieldQuantity;
    // End of variables declaration//GEN-END:variables
}
