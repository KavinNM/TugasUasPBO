/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Pesan;
import java.util.List;

/**
 *
 * @author HP
 */
public interface PesanDAO {

    void insert(Pesan pesan);

    List<Pesan> selectAll();

    void delete(String idpesan);

    void confirm(Pesan pesan);

    void cancel(Pesan pesan);

    Pesan selectbyidpesan(String idpesan);
}
