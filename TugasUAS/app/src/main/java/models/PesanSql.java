/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Perjalanan;
import entities.Pesan;
import entities.Tiket;
import helpers.KoneksiDB;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class PesanSql implements PesanDAO {

    @Override
    public void insert(Pesan pesan) {
        String sql = "INSERT INTO pesan(idpesan,idtiket, nama, jumlahkursi,total,status,idperjalanan) VALUES(?, ?, ?, ?, ?, ?,?)";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pesan.idpesan);
            pstmt.setString(2, pesan.idtiket.idtiket);
            pstmt.setString(3, pesan.nama);
            pstmt.setInt(4, pesan.jumlahkursi);
            pstmt.setInt(5, pesan.total);
            pstmt.setString(6, pesan.status);
            pstmt.setString(7, pesan.idtiket.idperjalanan.toString());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Pesan> selectAll() {
        String sql = """
            SELECT idpesan, p.idtiket as idtiket,pj.idperjalanan as idperjalanan,nama,jadwal,asal,tujuan, jumlahkursi, total, status,harga
                            FROM tiket t,pesan p,perjalanan pj
                            where t.idtiket = p.idtiket and p.idperjalanan = pj.idperjalanan""";
        List<Pesan> datapsn = new ArrayList<>();

        try (Connection conn = KoneksiDB.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pesan pesan = new Pesan(
                        rs.getString("idpesan"),
                        rs.getString("nama"),
                        rs.getInt("jumlahkursi"),
                        rs.getInt("total"),
                        rs.getString("Status")
                );
                String idtiket = rs.getString("idtiket");
                String idperjalanan = rs.getString("idperjalanan");
                String nama = rs.getString("nama");
                String asal = rs.getString("asal");
                String tujuan = rs.getString("tujuan");
                String jadwal = rs.getString("jadwal");
                int harga = rs.getInt("harga");
                if (idtiket != null && idperjalanan != null) {
                    pesan.perjalanan = new Perjalanan(idperjalanan, asal, tujuan, jadwal, harga);
                    pesan.idtiket = new Tiket(idtiket, 0);
                }
                datapsn.add(pesan);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return datapsn;
    }

    @Override
    public void delete(String idpesan) {
        String sql = "DELETE FROM pesan WHERE idpesan = ?";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idpesan);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void cancel(Pesan pesan) {
        String sql = "UPDATE pesan SET status = 'Dibatalkan' where idpesan = ?  ";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pesan.idpesan);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void confirm(Pesan pesan) {
        String sql = "UPDATE pesan SET status = 'Dibayar' where idpesan = ?  ";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pesan.idpesan);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Pesan selectbyidpesan(String idpesan) {
        String sql = """
            SELECT idpesan, jumlahkursi
                FROM pesan
                where idpesan= ?""";

        Pesan pesan = null;

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idpesan);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                pesan = new Pesan(
                        rs.getString("idpesan"),
                        rs.getInt("jumlahkursi")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return pesan;
    }
}


