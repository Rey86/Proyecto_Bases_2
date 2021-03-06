package front_end;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;


public class Register extends javax.swing.JDialog {
    private String username;
    private String photoDirection;
    private DefaultListModel<String> listModelNationalities;
    
    public Register(java.awt.Frame parent, boolean modal, String username) {
        super(parent, modal);
        this.username = username;
        this.listModelNationalities = new DefaultListModel();
        initComponents();
        initial();
        updateNationalities();
        setLocationRelativeTo(null);
    }
    
    public ImageIcon ResizeImage(String ImagePath){
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    public void initial(){
        try{
            ResultSet g = logic_connection.DataBaseConnection.getGenders();
            ResultSet c = logic_connection.DataBaseConnection.getCommunities();
            ResultSet n = logic_connection.DataBaseConnection.getNationalities();
            while(g.next()){
                cmbGender.addItem(String.valueOf(g.getInt("ID_GENDER")) + " " + g.getString("NAME"));
            }
            while(c.next()){
                cmbCommunity.addItem(String.valueOf(c.getInt("ID_COMMUNITY")) + " " + c.getString("COMMUNITY_NAME"));
            }
            while(n.next()){
                jComboBoxNationalities.addItem(String.valueOf(n.getInt("ID_NATIONALITY")) + " " + n.getString("NAME"));
            }
            if(!username.equals("")){
                txtUsername.setEnabled(false); 
                ResultSet u = logic_connection.DataBaseConnection.getUser(username);
                if(u.next()) {
                    ResultSet nationalities = logic_connection.DataBaseConnection.getUserxNationalities(username);
                    String current_gender = u.getInt("ID_GENDER") + " " + u.getString("GENDER_NAME");
                    String current_community = u.getInt("ID_COMMUNITY") + " " + u.getString("COMMUNITY_NAME");
                    String[] date = String.valueOf(u.getDate("BIRTHDATE")).split("-");
                    txtUsername.setText(u.getString("USERNAME"));
                    txtEmail.setText(u.getString("EMAIL"));
                    txtBirthDate.setText(date[2] + "-" + date[1] + "-" + date[0]);
                    txtFirstName.setText(u.getString("FIRST_NAME"));  
                    txtFirstLastName.setText(u.getString("FIRST_LASTNAME"));
                    txtSecondLastName.setText(u.getString("SECOND_LASTNAME"));
                    txtPassword.setText(u.getString("PASSWORD"));
                    txtID.setText(u.getString("ID_USER"));
                    photoDirection = u.getString("PHOTO_DIRECTION");
                    lblPhoto.setIcon(ResizeImage(photoDirection));
                    cmbGender.setSelectedItem(current_gender);
                    cmbCommunity.setSelectedItem(current_community);
                    DefaultListModel<String> listModelNationalities = new DefaultListModel();
                    while(nationalities.next()){ 
                        String nationality = String.valueOf(nationalities.getInt("ID_NATIONALITY")) + " " + nationalities.getString("NATIONALITY_NAME");
                        listModelNationalities.addElement(nationality); 
                    }
                    jListNationalities.setModel(listModelNationalities);
                }
            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.toString(), "Watch out", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<String> allforeigns(){
        ArrayList<String> users = new ArrayList<>();
        try{
            ResultSet r = logic_connection.DataBaseConnection.getUsers();
            while(r.next()) users.add(r.getString("ID_USER"));
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.toString(), "Watch out", JOptionPane.ERROR_MESSAGE);
        }
        return users;
    }
    
    public void updateNationalities(){
        try{
            jListNationalities.removeAll();
            ResultSet nationalities = logic_connection.DataBaseConnection.getUserxNationalities(username);
            DefaultListModel<String> listModelNationalities = new DefaultListModel();
            while(nationalities.next()){ 
                String nationality = String.valueOf(nationalities.getInt("ID_NATIONALITY")) + " " + nationalities.getString("NATIONALITY_NAME");
                listModelNationalities.addElement(nationality); 
            }
            jListNationalities.setModel(listModelNationalities);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtBirthDate = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtFirstLastName = new javax.swing.JTextField();
        txtSecondLastName = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        cmbCommunity = new javax.swing.JComboBox<>();
        cmbGender = new javax.swing.JComboBox<>();
        btnAccept = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblPhoto = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jButtonDeleteNationality = new javax.swing.JButton();
        jComboBoxNationalities = new javax.swing.JComboBox<>();
        jButtonAddNationality = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListNationalities = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Username:");

        jLabel2.setText("Email:");

        jLabel3.setText("Date of birth:");

        jLabel4.setText("First Name:");

        jLabel5.setText("First Last Name:");

        jLabel6.setText("Second Last Name:");

        jLabel7.setText("Password:");

        jLabel8.setText("ID:");

        jLabel9.setText("Photo:");

        jLabel10.setText("Community:");

        jLabel11.setText("Gender:");

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jButtonDeleteNationality.setText("Delete");
        jButtonDeleteNationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteNationalityActionPerformed(evt);
            }
        });

        jButtonAddNationality.setText("Add");
        jButtonAddNationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNationalityActionPerformed(evt);
            }
        });

        jLabel12.setText("Nationalities:");

        jScrollPane4.setViewportView(jListNationalities);

        jLabel13.setText("Name:");

        jLabel14.setText("Register");

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
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBirthDate))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFirstName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFirstLastName))
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPassword))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbCommunity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jComboBoxNationalities, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButtonAddNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(jButtonDeleteNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAdd))
                                    .addComponent(jLabel12))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAccept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cmbCommunity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(7, 7, 7)
                        .addComponent(jComboBoxNationalities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDeleteNationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAddNationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnAccept))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lblPhoto.setIcon(ResizeImage(path));
            photoDirection = path;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        String current_gender = (String) cmbGender.getSelectedItem();
        String current_community = (String) cmbCommunity.getSelectedItem();
        Integer id_gender = Integer.valueOf(current_gender.split(" ")[0]);
        Integer id_community = Integer.valueOf(current_community.split(" ")[0]);
        if(!txtUsername.getText().equals("")){
            if(!txtPassword.getPassword().equals("")){
                if(!txtFirstName.getText().equals("")){
                    if(!txtFirstLastName.getText().equals("")){
                        if(!txtSecondLastName.getText().equals("")){
                            if(!txtBirthDate.getText().equals("")){
                                if(!txtID.getText().equals("")){
                                    if(!txtEmail.getText().equals("")){
                                        if(!photoDirection.equals("")){
                                            try{
                                                if(!username.equals("")){
                                                    String[] numbers = txtBirthDate.getText().split("-");
                                                    String birthdate = numbers[2] + "-" + numbers[1] + "-" + numbers[0];
                                                    logic_connection.DataBaseConnection.setUser(txtUsername.getText(), txtEmail.getText(), birthdate, txtFirstName.getText(), txtFirstLastName.getText(), txtSecondLastName.getText(), String.valueOf(txtPassword.getPassword()), txtID.getText(), photoDirection, id_community, 2, id_gender);
                                                    dispose();                                       
                                                }
                                                else{
                                                    logic_connection.DataBaseConnection.insertUser(txtUsername.getText(), txtEmail.getText(), txtBirthDate.getText(), txtFirstName.getText(), txtFirstLastName.getText(), txtSecondLastName.getText(), String.valueOf(txtPassword.getPassword()), txtID.getText(), photoDirection, id_community, 2, id_gender);
                                                    for(int i = 0; i < listModelNationalities.getSize(); i++){
                                                        String nationality = listModelNationalities.getElementAt(i);
                                                        String[] n = nationality.split(" ");
                                                        logic_connection.DataBaseConnection.insertUserxNationality(username, Integer.parseInt(n[0]));
                                                    }
                                                    dispose(); 
                                                }
                                            }
                                            catch (SQLException e){
                                                JOptionPane.showMessageDialog(this, e.toString(), "Watch out", JOptionPane.ERROR_MESSAGE);
                                            }
                                            catch (NumberFormatException nfe){
                                                JOptionPane.showMessageDialog(this, "Some of the entered data must be a number", "Watch out", JOptionPane.ERROR_MESSAGE);
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(this, "You must select a photo", "Watch out", JOptionPane.WARNING_MESSAGE);
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(this, "The email box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
                                    }
                                }else {
                                    JOptionPane.showMessageDialog(this, "The ID box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
                                }
                            }else {
                                JOptionPane.showMessageDialog(this, "The birthdate box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
                            }
                        }else {
                            JOptionPane.showMessageDialog(this, "The second last name box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
                        }
                    }else {
                        JOptionPane.showMessageDialog(this, "The first last name box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "The first name box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(this, "The password box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(this, "The username box is empty", "Watch out", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void jButtonDeleteNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteNationalityActionPerformed
        try{
            String nationality = (String) jComboBoxNationalities.getSelectedItem();
            String[] n = nationality.split(" ");
            if("".equals(username)){
                Integer index = jListNationalities.getSelectedIndex();
                listModelNationalities.remove(index); 
                jListNationalities.setModel(listModelNationalities);
            } else {
                logic_connection.DataBaseConnection.deleteUserxNationality(username, Integer.parseInt(n[0]));
                updateNationalities();
            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.toString(), "Watch out", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteNationalityActionPerformed

    private void jButtonAddNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNationalityActionPerformed
        try{
            String nationality = (String) jComboBoxNationalities.getSelectedItem();
            String[] n = nationality.split(" ");
            if("".equals(username)){
                if(!listModelNationalities.contains(nationality)){
                    listModelNationalities.addElement(nationality);
                    jListNationalities.setModel(listModelNationalities);
                }
            } else {
                logic_connection.DataBaseConnection.insertUserxNationality(username, Integer.parseInt(n[0]));
                updateNationalities();
            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(this, e.toString(), "Watch out", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddNationalityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cmbCommunity;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JButton jButtonAddNationality;
    private javax.swing.JButton jButtonDeleteNationality;
    private javax.swing.JComboBox<String> jComboBoxNationalities;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListNationalities;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JTextField txtBirthDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstLastName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtID;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSecondLastName;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
