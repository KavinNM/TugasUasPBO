/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import entities.Perjalanan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class TabelPerjalanan extends AbstractTableModel{
    
    List<Perjalanan> dataPerjalanan;
    String[] header = {"ID Perjalanan","Asal","Tujuan","Jadwal","Harga"};

    public TabelPerjalanan(List<Perjalanan> dataPerjalanan) {
        this.dataPerjalanan = dataPerjalanan;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    @Override
    public int getRowCount() {
        return dataPerjalanan.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dataPerjalanan.get(rowIndex).idperjalanan;
            case 1:
                return dataPerjalanan.get(rowIndex).asal;
            case 2:
                return dataPerjalanan.get(rowIndex).tujuan;
            case 3:
                return dataPerjalanan.get(rowIndex).jadwal;
            default:
                return dataPerjalanan.get(rowIndex).harga;
        }
    }
    
}
