/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import com.sun.net.httpserver.Headers;
import entities.Pesan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class TabelData extends AbstractTableModel {
    
    List<Pesan> dataPesan;
    String Headers[]={"ID Pemesanan","ID Tiket","Nama Penumpang","Asal","Tujuan","Jadwal","Jumlah Kursi","Total","Status"};

    public TabelData(List<Pesan> dataPesan) {
        this.dataPesan = dataPesan;
    }

    @Override
    public String getColumnName(int column) {
        return Headers[column];
    }


    @Override
    public int getRowCount() {
        return dataPesan.size();
    }

    @Override
    public int getColumnCount() {
        return Headers.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dataPesan.get(rowIndex).idpesan;
            case 1:
                return dataPesan.get(rowIndex).idtiket.toid();
            case 2:
                return dataPesan.get(rowIndex).nama;
            case 3:
                return dataPesan.get(rowIndex).perjalanan.toasal();
            case 4:
                return dataPesan.get(rowIndex).perjalanan.totujuan();
            case 5:
                return dataPesan.get(rowIndex).perjalanan.tojadwal();
            case 6:
                return dataPesan.get(rowIndex).jumlahkursi;
                case 7:
                return dataPesan.get(rowIndex).total;
            default:
                return dataPesan.get(rowIndex).status;
        } 
    }
    
}
