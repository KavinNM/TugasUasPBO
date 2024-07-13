/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author HP
 */
public class Perjalanan {
    public String idperjalanan;
    public String asal;
    public String tujuan;
    public String jadwal;
    public int harga;

    public Perjalanan(String idperjalanan, String asal, String tujuan, String jadwal, int harga) {
        this.idperjalanan = idperjalanan;
        this.asal = asal;
        this.tujuan = tujuan;
        this.jadwal = jadwal;
        this.harga = harga;
    }

    public Perjalanan(String idperjalanan, String asal, String tujuan) {
        this.idperjalanan = idperjalanan;
        this.asal = asal;
        this.tujuan = tujuan;
    }

    public Perjalanan(String idperjalanan) {
        this.idperjalanan = idperjalanan;
    }

    public Perjalanan(String idperjalanan, String asal, String tujuan, String jadwal) {
        this.idperjalanan = idperjalanan;
        this.asal = asal;
        this.tujuan = tujuan;
        this.jadwal = jadwal;
    }

    public Perjalanan(String idperjalanan, int harga) {
        this.idperjalanan = idperjalanan;
        this.harga = harga;
    }
    

    
    
    @Override
    public String toString(){
        return idperjalanan;
    }
    
    public String toasal(){
        return asal;
    }
    
    public String totujuan() {
        return tujuan;
    }
    
    public int toharga() {
       return harga;
    }
    
    
    public String tojadwal() {
        return jadwal;
    }
}
