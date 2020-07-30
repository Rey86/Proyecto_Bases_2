package front_end;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class InsertProduct extends javax.swing.JDialog {
    private Integer id_product;
    private String username;
    private Boolean editable;
    
    public InsertProduct(java.awt.Frame parent, boolean modal, Integer id_product, String username, Boolean editable) {
        super(parent, modal);
        this.id_product = id_product;
        this.username = username;
        this.editable = editable;
        initComponents();
        initial();
        setLocationRelativeTo(null);
    }
    
    public void initial(){
        try{
            ResultSet c = logic_connection.DataBaseConnection.getCategories();
            ResultSet dt = logic_connection.DataBaseConnection.getDeliveryTypes();
            while(c.next()){
                jComboBoxCategories.addItem(String.valueOf(c.getInt("ID_CATEGORY")) + " " + c.getString("NAME"));
            }
            while(dt.next()){
                jComboBoxDeliveryTypes.addItem(String.valueOf(dt.getInt("ID_DELIVERYTYPE")) + " " + dt.getString("NAME"));
            }
            if(id_product > 0){
                ResultSet r = logic_connection.DataBaseConnection.getProduct(id_product);
                if(r.next()) {
                    String current_category = r.getInt("ID_CATEGORY") + " " + r.getString("CATEGORY_NAME");
                    String current_deliverytype = r.getInt("ID_DELIVERYTYPE") + " " + r.getString("DELIVERYTYPE_NAME");
                    jLabelID.setText(String.valueOf(r.getInt("ID_PRODUCT")));
                    jTextFieldName.setText(r.getString("PRODUCT_NAME"));
                    jTextFieldQuantity.setText(String.valueOf(r.getInt("QUANTITY")));
                    jTextFieldPrice.setText(String.valueOf(r.getInt("PRICE")));
                    jTextAreaDescription.setText(r.getString("DESCRIPTION"));
                    jComboBoxCategories.setSelectedItem(current_category);
                    jComboBoxDeliveryTypes.setSelectedItem(current_deliverytype);
                }
            }
            if(!editable){
                jTextFieldName.setEnabled(false); 
                jTextFieldQuantity.setEnabled(false);
                jTextFieldPrice.setEnabled(false); 
                jTextAreaDescription.setEnabled(false);
                jComboBoxCategories.setEnabled(false);
                jComboBoxDeliveryTypes.setEnabled(false);
                jButtonAccept.setEnabled(false);
            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.toString(), "Watch out", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldQuantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxCategories = new javax.swing.JComboBox<>();
        jButtonAccept = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxDeliveryTypes = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabelID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Product");

        jLabel2.setText("ID:");

        jLabel3.setText("Name:");

        jLabel4.setText("Description:");

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescription);

        jLabel5.setText("Quantity:");

        jLabel6.setText("Category:");

        jButtonAccept.setText("Accept");
        jButtonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceptActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabel7.setText("Delivery Type:");

        jLabel8.setText("Price:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxDeliveryTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabelID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAccept)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCancel)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxDeliveryTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAccept)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceptActionPerformed
        String current_category = (String) jComboBoxCategories.getSelectedItem();
        String current_deliverytype = (String) jComboBoxDeliveryTypes.getSelectedItem();
        Integer id_category = Integer.valueOf(current_category.split(" ")[0]);
        Integer id_deliverytype = Integer.valueOf(current_deliverytype.split(" ")[0]);
        if (!jTextFieldName.getText().equals("")){
            if (!jTextFieldQuantity.getText().equals("")){
                if (!jTextFieldPrice.getText().equals("")){
                    if (!jTextAreaDescription.getText().equals("")){
                        try{
                            if(id_product > 0){
                                ResultSet p = logic_connection.DataBaseConnection.getProduct(Integer.valueOf(jLabelID.getText()));
                                while(p.next()){
                                    if(!jTextFieldPrice.getText().equals(p.getInt("PRICE"))){
                                        logic_connection.DataBaseConnection.setProductPrice(Integer.valueOf(jLabelID.getText()), Integer.valueOf(jTextFieldPrice.getText()));
                                    }
                                }
                                logic_connection.DataBaseConnection.setProduct(Integer.valueOf(jLabelID.getText()), jTextFieldName.getText(), 0, jTextAreaDescription.getText(), Integer.valueOf(jTextFieldQuantity.getText()), username, id_category, id_deliverytype);
                                dispose();
                            }
                            else{
                                logic_connection.DataBaseConnection.insertProduct(jTextFieldName.getText(), Integer.valueOf(jTextFieldPrice.getText()), 0, jTextAreaDescription.getText(), Integer.valueOf(jTextFieldQuantity.getText()), username, id_category, id_deliverytype);
                                dispose();
                            }
                        }
                        catch (SQLException e){
                            JOptionPane.showMessageDialog(this, e.toString(), "Watch out", JOptionPane.ERROR_MESSAGE);
                        }
                        catch (NumberFormatException nfe){
                            JOptionPane.showMessageDialog(this, "One field must be a number", "Watch out", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "The description box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this, "The price box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "The quantity box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "The name box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAcceptActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JComboBox<String> jComboBoxCategories;
    private javax.swing.JComboBox<String> jComboBoxDeliveryTypes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldQuantity;
    // End of variables declaration//GEN-END:variables
}
