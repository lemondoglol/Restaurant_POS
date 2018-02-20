/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Ryan
 */
public class Log_In extends javax.swing.JDialog {

    /**
     * Creates new form Log_In
     */
    // variable define here
    HashMap<String,String> account;
    
    public Log_In(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Security Log In");
        this.setSize(644,387);
        this.setResizable(false);
        setLocationRelativeTo(null);
        Initialize_Account();
        
    }
    
    private void Initialize_Account(){
        account = new HashMap<String, String>();
        account.put("Ryan","abc");
        account.put("worker","123");
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UN = new javax.swing.JLabel();
        UN_Field = new javax.swing.JTextField();
        PW = new javax.swing.JLabel();
        PW_Field = new javax.swing.JPasswordField();
        Type = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        OK_Button = new javax.swing.JButton();
        Cancel_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        UN.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        UN.setText("UserName");
        getContentPane().add(UN);
        UN.setBounds(340, 0, 100, 71);

        UN_Field.setText("Ryan");
        UN_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UN_FieldActionPerformed(evt);
            }
        });
        getContentPane().add(UN_Field);
        UN_Field.setBounds(440, 0, 197, 71);

        PW.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        PW.setText("PassWord");
        getContentPane().add(PW);
        PW.setBounds(340, 70, 100, 71);

        PW_Field.setText("abc");
        PW_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PW_FieldActionPerformed(evt);
            }
        });
        getContentPane().add(PW_Field);
        PW_Field.setBounds(440, 70, 197, 71);

        Type.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        Type.setText("Type");
        getContentPane().add(Type);
        Type.setBounds(340, 140, 100, 71);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee", "Employer", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(440, 140, 197, 71);

        OK_Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OK_Button.setText("Log In");
        OK_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OK_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(OK_Button);
        OK_Button.setBounds(260, 280, 190, 70);

        Cancel_Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Cancel_Button.setText("Cancel");
        Cancel_Button.setPreferredSize(new java.awt.Dimension(160, 80));
        Cancel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(Cancel_Button);
        Cancel_Button.setBounds(450, 280, 190, 71);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant/security.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 320, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UN_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UN_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UN_FieldActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void Cancel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel_ButtonActionPerformed
        Log_In_Menu ob = new Log_In_Menu();
        this.dispose();
        ob.setVisible(true);
    }//GEN-LAST:event_Cancel_ButtonActionPerformed

    private void OK_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OK_ButtonActionPerformed
        //check data valid
        try{
        if(UN_Field.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"UserName can't be empty","Error",JOptionPane.WARNING_MESSAGE);
        }else if(PW_Field.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Password can't be empty","Error",JOptionPane.WARNING_MESSAGE);
        }else if(!account.containsKey(UN_Field.getText()) || !account.get(UN_Field.getText()).equals(PW_Field.getText()) ){
            JOptionPane.showMessageDialog(this,"Password does not match","Error",JOptionPane.WARNING_MESSAGE);
        }else{
            this.dispose();
            String name = UN_Field.getText();
            Main_Menu ob = new Main_Menu(name);
            ob.setVisible(true);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Typing Error","Error",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_OK_ButtonActionPerformed

    private void PW_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PW_FieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_PW_FieldActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel_Button;
    private javax.swing.JButton OK_Button;
    private javax.swing.JLabel PW;
    private javax.swing.JPasswordField PW_Field;
    private javax.swing.JLabel Type;
    private javax.swing.JLabel UN;
    private javax.swing.JTextField UN_Field;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
