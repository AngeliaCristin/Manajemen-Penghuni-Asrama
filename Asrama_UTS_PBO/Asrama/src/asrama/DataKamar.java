/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asrama;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DataKamar extends Database.Database{
    private String no_kamar;
    private String lantai;
    private String fasilitas;
    private int harga;
    private final Map<String, Integer> Kamar = new HashMap<>();
    
    private String originalFasilitas;
    private int originalHarga;
    
    
    public DataKamar(String no_kamar, String lantai, String fasilitas, int harga) {
        this.no_kamar = no_kamar;
        this.lantai = lantai;
        this.fasilitas = fasilitas;
        this.harga = harga;
        
        this.originalFasilitas = fasilitas;
        this.originalHarga = harga;
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

            String query = "SELECT * FROM data_kamar";
            preparedStatement = getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            model.addColumn("No Kamar");
            model.addColumn("Lantai");
            model.addColumn("Fasilitas");
            model.addColumn("Harga");

            while (resultSet.next()) {
                this.no_kamar= resultSet.getString("no_kamar");
                this.lantai = resultSet.getString("lantai");
                this.fasilitas= resultSet.getString("fasilitas");
                this.harga = resultSet.getInt("harga");

                model.addRow(new Object[]{no_kamar, lantai, fasilitas, harga});
            }
        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }

        return model;
    }
    
    private boolean kamarExists() {
        try {
            String checkQuery = "SELECT COUNT(*) FROM `data_kamar` WHERE `No_Kamar` = ?";
            preparedStatement = getConnection().prepareStatement(checkQuery);
            preparedStatement.setString(1, no_kamar);
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
            
            if (kamarExists()) {
            JOptionPane.showMessageDialog(null, "Data kamar sudah ada.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }

            String query = "INSERT INTO `data_kamar`(`No_Kamar`, `lantai`, `Fasilitas`, `Harga`) VALUES (?, ?, ?, ?)";
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, no_kamar);
            preparedStatement.setString(2, lantai);
            preparedStatement.setString(3, fasilitas);
            preparedStatement.setInt(4, harga);

            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }
        return true;
    }
    
    public boolean isDataChanged() {
        return !fasilitas.equals(originalFasilitas) || harga != originalHarga;
    }
    
    public boolean update() {
        try {
            openConnection();

            String originalQuery = "SELECT Fasilitas, Harga FROM data_kamar WHERE No_Kamar = ?";
            preparedStatement = getConnection().prepareStatement(originalQuery);
            preparedStatement.setString(1, no_kamar);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                originalFasilitas = resultSet.getString("Fasilitas");
                originalHarga = resultSet.getInt("Harga");
            }

            String updateQuery = "UPDATE `data_kamar` SET `Fasilitas`= ?,`Harga`= ? WHERE No_Kamar = ?";
            preparedStatement = getConnection().prepareStatement(updateQuery);
            preparedStatement.setString(1, fasilitas);
            preparedStatement.setInt(2, harga);
            preparedStatement.setString(3, no_kamar);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0 && isDataChanged();

        } catch (SQLException ex) {
            displayErrors(ex);
            return false; 
        } finally {
            closeConnection();
        }
    }
    
    public boolean hapus() {
        try {
            openConnection();

            String query = "DELETE FROM `data_kamar` WHERE No_Kamar = ?";
            preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, no_kamar);

            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }
        return true;
    }
    
    public void setJComboBoxRuang(JComboBox<String> noKamar) {
        try {
            openConnection();

            String query = "SELECT DISTINCT `No_Kamar`, `lantai`, `Fasilitas`, `Harga` FROM data_kamar";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            noKamar.removeAllItems();
            
            while (resultSet.next()) {
                no_kamar = resultSet.getString("No_Kamar");
                lantai = resultSet.getString("lantai");
                fasilitas = resultSet.getString("Fasilitas");
                harga = resultSet.getInt("Harga");


                noKamar.addItem(no_kamar);
            }
        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }
    }
    
    public void setJComboBoxRuangKosong(JComboBox<String> noKamar) {
        try {
            openConnection();

           String query = "SELECT `No_Kamar` FROM data_kamar WHERE No_Kamar NOT IN (SELECT No_Kamar FROM data_penghuni)";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            noKamar.removeAllItems();
            
            while (resultSet.next()) {
                no_kamar = resultSet.getString("No_Kamar");
 
                noKamar.addItem(no_kamar);
            }
        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }
    }
    
    public void setJComboBoxRuangPenghuni(JComboBox<String> noKamar) {
        try {
            openConnection();

           String query = "SELECT `No_Kamar` FROM data_kamar WHERE No_Kamar IN (SELECT No_Kamar FROM data_penghuni)";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            noKamar.removeAllItems();
            
            while (resultSet.next()) {
                no_kamar = resultSet.getString("No_Kamar");
 
                noKamar.addItem(no_kamar);
            }
        } catch (SQLException ex) {
            displayErrors(ex);
        } finally {
            closeConnection();
        }
    }
    
    
}
