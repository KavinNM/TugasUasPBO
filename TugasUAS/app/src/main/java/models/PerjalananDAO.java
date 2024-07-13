/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Perjalanan;
import java.util.List;

/**
 *
 * @author HP
 */
public interface PerjalananDAO {
    
    void insert(Perjalanan perjalanan);
    
    List<Perjalanan> selectByRoute(String asal,String tujuan);
    Perjalanan selectByidperjalanan(String idperjalanan);
    List<Perjalanan> selectAll();
    void update(Perjalanan perjalanan);
    void delete(String idperjalanan);
    
}
