/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author HP
 */
public class Tiket {

    public String idtiket;
    public Perjalanan idperjalanan;
    public int jumlah;
    public int harga;

    public Tiket(String idtiket, int jumlah) {
        this.idtiket = idtiket;
        this.jumlah = jumlah;
    }

    public Tiket(String idtiket, Perjalanan perjalanan, int jumlah) {
        this.idtiket = idtiket;
        this.idperjalanan = perjalanan;
        this.jumlah = jumlah;
    }

    public Tiket(String idtiket, Perjalanan idperjalanan, int jumlah, int harga) {
        this.idtiket = idtiket;
        this.idperjalanan = idperjalanan;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public Tiket(String idtiket, int jumlah, int harga) {
        this.idtiket = idtiket;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public Tiket(String idtiket, Perjalanan idperjalanan) {
        this.idtiket = idtiket;
        this.idperjalanan = idperjalanan;
    }

    public String toid(){
        return idtiket;
    }

    @Override
    public String toString() {
        return idtiket;
    }
}
