/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import asrama.DataKamar;
import asrama.DataPenghuni;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class CreateDataPenghuni extends javax.swing.JFrame {

    /**
     * Creates new form CreateDataPenghuni
     */
    public CreateDataPenghuni() {
        initComponents();
        DataKamar dK = new DataKamar(null, null, null, 0);
        dK.setJComboBoxRuangKosong(KamarBox);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelID = new javax.swing.JLabel();
        LabelNama = new javax.swing.JLabel();
        LabelAlamat = new javax.swing.JLabel();
        LabelInstansi = new javax.swing.JLabel();
        LabelKamar = new javax.swing.JLabel();
        IdBox = new javax.swing.JTextField();
        NamaBox = new javax.swing.JTextField();
        AlamatKTPBox = new javax.swing.JTextField();
        InstansiBox = new javax.swing.JTextField();
        NoHPBox = new javax.swing.JTextField();
        Create = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        KamarBox = new javax.swing.JComboBox<>();
        LabelNoHP1 = new javax.swing.JLabel();
        CreateDataPenghuni = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelID.setText("ID Penghuni");
        getContentPane().add(LabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 80, 20));

        LabelNama.setText("Nama");
        getContentPane().add(LabelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 80, 20));

        LabelAlamat.setText("Alamat KTP");
        getContentPane().add(LabelAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 80, 30));

        LabelInstansi.setText("Instansi");
        getContentPane().add(LabelInstansi, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 70, 20));

        LabelKamar.setText("Kamar");
        getContentPane().add(LabelKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 50, 30));
        getContentPane().add(IdBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 190, 40));
        getContentPane().add(NamaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 190, 40));
        getContentPane().add(AlamatKTPBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 190, 40));

        InstansiBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstansiBoxActionPerformed(evt);
            }
        });
        getContentPane().add(InstansiBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 200, 40));
        getContentPane().add(NoHPBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 200, 40));

        Create.setBackground(new java.awt.Color(204, 255, 204));
        Create.setText("Create");
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });
        getContentPane().add(Create, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 110, 40));

        Back.setBackground(new java.awt.Color(204, 255, 255));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, 90, 40));

        KamarBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K01", "K02", "K03", "K04", "K05", "K06", "K07", "K08", "K09", "K10" }));
        KamarBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KamarBoxActionPerformed(evt);
            }
        });
        getContentPane().add(KamarBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 200, 40));

        LabelNoHP1.setText("No.HP");
        getContentPane().add(LabelNoHP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 60, 40));

        CreateDataPenghuni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/9.jpg"))); // NOI18N
        CreateDataPenghuni.setText("jLabel1");
        CreateDataPenghuni.setPreferredSize(new java.awt.Dimension(500, 530));
        getContentPane().add(CreateDataPenghuni, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InstansiBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstansiBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InstansiBoxActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        AwalCRUD_DataPenghuni ADP = new AwalCRUD_DataPenghuni();
        this.dispose();
        ADP.setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActionPerformed
        // TODO add your handling code here:
        String id = IdBox.getText();
        String nama = NamaBox.getText();
        String alamat = AlamatKTPBox.getText();
        String instansi = InstansiBox.getText();
        String noHp = NoHPBox.getText();
        String kamar = (String) KamarBox.getSelectedItem();

        if (id.isEmpty() || nama.isEmpty() || alamat.isEmpty() || instansi.isEmpty() || noHp.isEmpty() || kamar == null) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            DataPenghuni dP = new DataPenghuni(id, nama, alamat, instansi, noHp, kamar);
            boolean createSuccess = dP.create();

            if (createSuccess) {
                // Notifikasi jika berhasil menambahkan data
                JOptionPane.showMessageDialog(null, "Data Penghuni berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Notifikasi jika gagal menambahkan data
                JOptionPane.showMessageDialog(null, "Gagal menambahkan data Penghuni.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        IdBox.setText("");
        NamaBox.setText("");
        AlamatKTPBox.setText("");
        InstansiBox.setText("");
        NoHPBox.setText("");
        KamarBox.setSelectedItem(0);
        
        DataKamar dK = new DataKamar(null, null, null, 0);
        dK.setJComboBoxRuangKosong(KamarBox);
    }//GEN-LAST:event_CreateActionPerformed

    private void KamarBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KamarBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KamarBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateDataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateDataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateDataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateDataPenghuni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateDataPenghuni().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AlamatKTPBox;
    private javax.swing.JButton Back;
    private javax.swing.JButton Create;
    private javax.swing.JLabel CreateDataPenghuni;
    private javax.swing.JTextField IdBox;
    private javax.swing.JTextField InstansiBox;
    private javax.swing.JComboBox<String> KamarBox;
    private javax.swing.JLabel LabelAlamat;
    private javax.swing.JLabel LabelID;
    private javax.swing.JLabel LabelInstansi;
    private javax.swing.JLabel LabelKamar;
    private javax.swing.JLabel LabelNama;
    private javax.swing.JLabel LabelNoHP1;
    private javax.swing.JTextField NamaBox;
    private javax.swing.JTextField NoHPBox;
    // End of variables declaration//GEN-END:variables
}