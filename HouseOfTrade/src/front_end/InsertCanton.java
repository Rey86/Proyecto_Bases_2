package front_end;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InsertCanton extends javax.swing.JDialog {
    private Integer id_canton;

    public InsertCanton(java.awt.Frame parent, boolean modal, Integer id_canton) {
        super(parent, modal);
        this.id_canton = id_canton;
        initComponents();
        initial();
        setLocationRelativeTo(null);
    }

    public void initial(){
        try{
            if(id_canton > 0){
                ResultSet r = logic_connection.DataBaseConnection.getCanton(id_canton);
                if(r.next()) {
                    jLabelID.setText(String.valueOf(r.getInt("ID_CANTON")));
                    jTextFieldName.setText(r.getString("CANTON_NAME")); 
                    jTextFieldForeignId.setText(String.valueOf(r.getInt("ID_PROVINCE"))); 
                }
            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.toString(), "Watch out", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<Integer> allforeigns(){
        ArrayList<Integer> provinces = new ArrayList<>();
        try{
            ResultSet r = logic_connection.DataBaseConnection.getProvinces();
            while(r.next()) provinces.add(r.getInt("ID_PROVINCE"));
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.toString(), "Watch out", JOptionPane.ERROR_MESSAGE);
        }
        return provinces;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldForeignId = new javax.swing.JTextField();
        jLabelID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonAccept = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabel4.setText("ID Province:");

        jLabel1.setText("ID: ");

        jLabel2.setText("Name:");

        jLabel3.setText("Canton");

        jButtonAccept.setText("Accept");
        jButtonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(jTextFieldForeignId)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldForeignId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
        ArrayList<Integer> provinces = allforeigns();
        if (!jTextFieldName.getText().equals("")){
            if (!jTextFieldForeignId.getText().equals("")){
                try{
                    if(id_canton > 0){
                        if (provinces.contains(Integer.parseInt(jTextFieldForeignId.getText()))){
                            logic_connection.DataBaseConnection.setCanton(Integer.valueOf(jLabelID.getText()), jTextFieldName.getText(), Integer.valueOf(jTextFieldForeignId.getText()));
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "The province doesn't exist", "Watch out", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else{
                        if (provinces.contains(Integer.parseInt(jTextFieldForeignId.getText()))){
                            logic_connection.DataBaseConnection.insertCanton(jTextFieldName.getText(), Integer.valueOf(jTextFieldForeignId.getText()));
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "The province doesn't exist", "Watch out", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                catch (SQLException e){
                    JOptionPane.showMessageDialog(this, e.toString(), "Watch out", JOptionPane.ERROR_MESSAGE);
                }
                catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(this, "One of the attributes must be a number", "Watch out", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "The foreign key box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "The name box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAcceptActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JTextField jTextFieldForeignId;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
