/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asrama;

import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DataPenghuni extends Database.Database{
    private String id_penghuni;
    private String nama;
    private String alamat;
    private String instansi;
    private String no_hp;
    private String kamar;
    
    private String originalNama;
    private String originalAlamat;
    private String originalInstansi;
    private String originalNoHp;
    private String originalKamar;

    public DataPenghuni(String id_penghuni, String nama, String alamat, String instansi, String no_hp, String kamar) {
        this.id_penghuni = id_penghuni;
        this.nama = nama;
        this.alamat = alamat;
        this.instansi = instansi;
        this.no_hp = no_hp;
        this.kamar = kamar;
    }
    
    public DefaultTableModel read() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            openConnection();

            String query = "SELECT * FROM data_penghuni";
            preparedStatement = getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            model.addColumn("ID Penghuni");
            model.addColumn("Nama");
            model.addColumn("Alamat");
            model.addColumn("Instansi");
            model.addColumn("Telepon");
            model.addColumn("Kamar");

            while (resultSet.next()) {
                this.id_penghuni= resultSet.getString("id_penghuni");
                this.nama = resultSet.getString("Nama");
                this.alamat = resultSet.getString("Alamat_KTP");
                this.instansi = resultSet.getString("Instansi");
                this.no_hp = resultSet.getString("No_HP");
                this.kamar = resultSet.getString("No_Kamar");

                model.addRow(new Object[]{id_penghuni, nama, alamat, instansi, no_hp, kamar});
            }
        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }

        return model;
    }
    
    private boolean PenghuniExists() {
        try {
            String checkQuery = "SELECT COUNT(*) FROM data_penghuni WHERE id_penghuni = ?";
            preparedStatement = getConnection().prepareStatement(checkQuery);
            preparedStatement.setString(1, id_penghuni);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; 
            }
        } catch (SQLException ex) {
            displayErrors(ex);
        }
        return false; 
    }
    
    public boolean create() {
        try {
            openConnection();
            
            if (PenghuniExists()) {
            JOptionPane.showMessageDialog(null, "Data Penghuni sudah ada.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }
            
            String query = "INSERT INTO `data_penghuni`(`id_penghuni`, `Nama`, `Alamat_KTP`, `Instansi`, `No_HP`, `No_Kamar`) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, id_penghuni);
            preparedStatement.setString(2, nama);
            preparedStatement.setString(3, alamat);
            preparedStatement.setString(4, instansi);
            preparedStatement.setString(5, no_hp);
            preparedStatement.setString(6, kamar);

            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }
        return true;
    }
    
    public boolean update() {
        try {
            openConnection();
            
            if (!penghuniExists()) {
                JOptionPane.showMessageDialog(null, "Data Penghuni tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

            String query = "UPDATE `data_penghuni` SET `Nama`= ?,"
                    + "`Alamat_KTP`= ?,`Instansi`= ?,`No_HP`= ? WHERE id_penghuni = ?";
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, alamat);
            preparedStatement.setString(3, instansi);
            preparedStatement.setString(4, no_hp);
            preparedStatement.setString(5, id_penghuni);

            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }
        return true;
    }
    
    private boolean penghuniExists() {
    try {
        String checkQuery = "SELECT COUNT(*) FROM `data_penghuni` WHERE `id_penghuni` = ?";
        preparedStatement = getConnection().prepareStatement(checkQuery);
        preparedStatement.setString(1, id_penghuni);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;
        }
    } catch (SQLException ex) {
        displayErrors(ex);
    }
    return false;
}

    
    
    public boolean hapus() {
        try {
            openConnection();

            String query = "DELETE FROM `data_penghuni` WHERE id_penghuni = ?";
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, id_penghuni);

            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }
        return true;
    }
    
    public void setJComboBoxPenghuni(JComboBox<String> idPenghunii) {
        try {
            openConnection();

            String query = "SELECT * FROM data_penghuni";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            idPenghunii.removeAllItems();
            
            while (resultSet.next()) {
                this.id_penghuni= resultSet.getString("id_penghuni");

                idPenghunii.addItem(id_penghuni);
            }
        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }
    }
    
    public boolean isDataChanged() {
        return !nama.equals(originalNama) || !alamat.equals(originalAlamat) ||
               !instansi.equals(originalInstansi) || !no_hp.equals(originalNoHp) ||
               !kamar.equals(originalKamar);
    }
}
