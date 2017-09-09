/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tcs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class UpdateForm extends javax.swing.JFrame {

    PreparedStatement pst;
    ResultSet rs;
    
    public UpdateForm() {
        initComponents();
        ExCon.call();
        cl();
    }
    
    public void clearfields()
    {
        jTextField1.setText(null);
        jFormattedTextField1contact.setText(null);
        jTextField3.setText(null);
        buttonGroup1.clearSelection();
        jComboBox1.setSelectedItem("karachi");
    }
public void clear(){
        jTextField1.setText(null);
        jFormattedTextField1contact.setText(null);
        jTextField3.setText(null);
        buttonGroup1.clearSelection();
        jComboBox1.setSelectedItem("karachi");
}
    int getid(){
        Integer id =(Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
        return id;
    }
    DefaultTableModel dtm;
    void cl(){
        dtm= (DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        String sql="select * from TCS.dbo.tblConnectionUser";
        try {
            pst=ExCon.con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                dtm.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
                    } catch (Exception e) {
        }
    }
            
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jFormattedTextField1contact = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Name ", "Contact", "Gender", "Address", "City"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 600, 196));

        jButton1.setText("Update Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 81, 264, 27));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 84, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Contact");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 123, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Gender");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 166, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("City");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 241, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Address");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 205, -1, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 165, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 165, -1, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 201, 264, 29));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Karachi", "Lahore", "Islamabad", "Quetta", "Peshawar" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 241, 138, -1));

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Update Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel4)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 50));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 620, 40));

        try {
            jFormattedTextField1contact.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("03##-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jFormattedTextField1contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 260, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
    String name=jTextField1.getText();
    String contact=jFormattedTextField1contact.getText();
    String gender="";
    if(jRadioButton1.isSelected()){
        gender="Male";
    }
    if(jRadioButton2.isSelected()){
        gender="Female";
    }
    String address=jTextField3.getText();
    String city=jComboBox1.getSelectedItem().toString();
    if(name.equals("") || contact.equals("03  -       ") || address.equals("") || gender.equals("")){
                    JOptionPane.showMessageDialog(this, "please fill the box");
                    }
    else{
    
                    pst=ExCon.con.prepareStatement("update tblConnectionUser set u_name='"+name+"', u_contact='"+contact+"', u_gender='"+gender+"', u_address='"+address+"', u_city='"+city+"' where u_id="+getid());
                    pst.executeUpdate();
                    cl();
                    JOptionPane.showMessageDialog(this, "Updated");
                    clearfields();
        }    } catch (Exception e) {
        }
    
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed

    }//GEN-LAST:event_jTable1KeyPressed

    
    
    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString());
jFormattedTextField1contact.setText(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString());
if(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString().equalsIgnoreCase("Male")){
    jRadioButton1.setSelected(true);
    jRadioButton2.setSelected(false);
}
else if(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString().equalsIgnoreCase("FeMale")){
    jRadioButton1.setSelected(false);
    jRadioButton2.setSelected(true);
}
jTextField3.setText(jTable1.getValueAt(jTable1.getSelectedRow(),4).toString());  

jComboBox1.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 5));
String cityName = "Karachi,Lahore,Islamabad,Quetta,Peshawar".trim();
String city = "".trim();
String getselecity = jTable1.getValueAt(jTable1.getSelectedRow(), 5)+"".trim();
        
    jComboBox1.removeAllItems();

        jComboBox1.addItem(jTable1.getValueAt(jTable1.getSelectedRow(), 5));
        
        for (int i = 0; i < cityName.length(); i++) {
            
            if(cityName.charAt(i)==',')
            {
                
                if(getselecity.equalsIgnoreCase(city))
                    
                {
                    city = "";
                    
                }else{
                jComboBox1.addItem(city);
                city = "";
                }
            }else
            {
                city += ""+cityName.charAt(i);
            }
        }




    }//GEN-LAST:event_jTable1MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clear();
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
             
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            this.dispose();
            AdminMainPage amp=new AdminMainPage();
            amp.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UpdateForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1contact;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
