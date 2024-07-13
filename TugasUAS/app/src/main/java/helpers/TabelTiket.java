/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import entities.Tiket;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class TabelTiket extends AbstractTableModel{
    List<Tiket> dataTiket;
    String header[] = {"ID Tiket", "ID Perjalanan", "Jumlah Tiket"};

    public TabelTiket(List<Tiket> dataTiket) {
        this.dataTiket = dataTiket;
    }

    
    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    @Override
    public int getRowCount() {
        return dataTiket.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
            case 0:
                return dataTiket.get(rowIndex).idtiket;
            case 1:
                return dataTiket.get(rowIndex).idperjalanan;
            default:
                return dataTiket.get(rowIndex).jumlah;
        }
    }
    
}
