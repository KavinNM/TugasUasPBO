/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Perjalanan;
import entities.Tiket;
import java.util.List;

/**
 *
 * @author HP
 */
public interface TiketDAO {
        
    void insert(Tiket tiket);
    Tiket selectbyidtiket(String idtiket);
    List<Tiket> selectAll();
    void update(Tiket tiket);
    void tambah(Tiket tiket,int kursi);
    void kurang(Tiket tiket,int kursi);
    void delete(String idtiket);
    
}
