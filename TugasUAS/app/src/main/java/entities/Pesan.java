/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author HP
 */
public class Pesan {

    public String idpesan;
    public String nama;
    public int jumlahkursi;
    public int total;
    public String status;
    public Tiket idtiket;
    public Perjalanan perjalanan;
    public String jadwal;
    public String asal;
    public String tujuan;

    public Pesan(String idpesan, String nama, int jumlahkursi, int total, String status) {
        this.idpesan = idpesan;
        this.nama = nama;
        this.jumlahkursi = jumlahkursi;
        this.total = total;
        this.status = status;
    }

    public Pesan(String idpesan, String nama, int jumlahkursi, int total, String status, Tiket idtiket) {
        this.idpesan = idpesan;
        this.nama = nama;
        this.jumlahkursi = jumlahkursi;
        this.total = total;
        this.status = status;
        this.idtiket = idtiket;
    }

    public Pesan(String idpesan, String nama, int jumlahkursi, String status, Tiket idtiket) {
        this.idpesan = idpesan;
        this.nama = nama;
        this.jumlahkursi = jumlahkursi;
        this.status = status;
        this.idtiket = idtiket;
    }

    public Pesan(String idpesan, String nama, int jumlahkursi) {
        this.idpesan = idpesan;
        this.nama = nama;
        this.jumlahkursi = jumlahkursi;
    }

    public Pesan(String idpesan, String nama, int jumlahkursi, int total) {
        this.idpesan = idpesan;
        this.nama = nama;
        this.jumlahkursi = jumlahkursi;
        this.total = total;
    }

    public Pesan(String idpesan, String nama, int jumlahkursi, int total, Tiket idtiket) {
        this.idpesan = idpesan;
        this.nama = nama;
        this.jumlahkursi = jumlahkursi;
        this.total = total;
        this.idtiket = idtiket;
    }

    public Pesan(String idpesan, String nama, int jumlahkursi, int total, String jadwal, String asal, String tujuan) {
        this.idpesan = idpesan;
        this.nama = nama;
        this.jumlahkursi = jumlahkursi;
        this.total = total;
        this.jadwal = jadwal;
        this.asal = asal;
        this.tujuan = tujuan;
    }

    public Pesan(String idpesan, String nama, int jumlahkursi, int total, String status, Tiket idtiket, Perjalanan idperjalanan, String jadwal, String asal, String tujuan) {
        this.idpesan = idpesan;
        this.nama = nama;
        this.jumlahkursi = jumlahkursi;
        this.total = total;
        this.status = status;
        this.idtiket = idtiket;
        this.perjalanan = idperjalanan;
        this.jadwal = jadwal;
        this.asal = asal;
        this.tujuan = tujuan;
    }

    public Pesan(String idpesan, String nama, int jumlahkursi, int total, Tiket idtiket, Perjalanan idperjalanan, String jadwal, String asal, String tujuan) {
        this.idpesan = idpesan;
        this.nama = nama;
        this.jumlahkursi = jumlahkursi;
        this.total = total;
        this.idtiket = idtiket;
        this.perjalanan = idperjalanan;
        this.jadwal = jadwal;
        this.asal = asal;
        this.tujuan = tujuan;
    }

    public Pesan(String idpesan, String nama, int total, String jadwal, String asal, String tujuan) {
        this.idpesan = idpesan;
        this.nama = nama;
        this.total = total;
        this.jadwal = jadwal;
        this.asal = asal;
        this.tujuan = tujuan;
    }

    public Pesan(String idpesan, int jumlahkursi) {
        this.idpesan = idpesan;
        this.jumlahkursi = jumlahkursi;
    }


    

    @Override
    public String toString() {
        return "[" +perjalanan.toString() + "] ["+idtiket.idtiket+"] " + " Nama pemesan : " + nama + " jumlah kursi : " +jumlahkursi+" total : "+total+"status : "+status;
    }
}
