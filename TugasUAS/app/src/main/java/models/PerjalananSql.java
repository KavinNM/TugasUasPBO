/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Perjalanan;
import helpers.KoneksiDB;
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
public class PerjalananSql implements PerjalananDAO {

    @Override
    public void insert(Perjalanan perjalanan) {
        String sql = "INSERT INTO perjalanan(idperjalanan, asal, tujuan, jadwal, harga) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, perjalanan.idperjalanan);
            pstmt.setString(2, perjalanan.asal);
            pstmt.setString(3, perjalanan.tujuan);
            pstmt.setString(4, perjalanan.jadwal);
            pstmt.setInt(5, perjalanan.harga);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
public List<Perjalanan> selectByRoute(String asal, String tujuan) {
    String sql = "SELECT * FROM perjalanan WHERE asal = ? AND tujuan = ?";
    List<Perjalanan> dataPerjalanan = new ArrayList<>();

    try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, asal);
        pstmt.setString(2, tujuan);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Perjalanan perjalanan = new Perjalanan(
                    rs.getString("idperjalanan"),
                    rs.getString("asal"),
                    rs.getString("tujuan"),
                    rs.getString("jadwal"),
                    rs.getInt("harga"));
            dataPerjalanan.add(perjalanan);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return dataPerjalanan;
}


    @Override
    public List<Perjalanan> selectAll() {
        String sql = "SELECT idperjalanan,asal,tujuan,jadwal,harga FROM perjalanan";
        List<Perjalanan> dataPerjalanan = new ArrayList<>();

        try (Connection conn = KoneksiDB.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Perjalanan perjalanan = new Perjalanan(
                        rs.getString("idperjalanan"),
                        rs.getString("asal"),
                        rs.getString("tujuan"),
                        rs.getString("jadwal"),
                        rs.getInt("harga"));
                dataPerjalanan.add(perjalanan);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dataPerjalanan;
    }

    @Override
    public void update(Perjalanan perjalanan) {
        String sql = "UPDATE perjalanan SET asal = ?, tujuan = ?, jadwal = ?, harga = ? WHERE idperjalanan = ?";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, perjalanan.asal);
            pstmt.setString(2, perjalanan.tujuan);
            pstmt.setString(3, perjalanan.jadwal);
            pstmt.setInt(4, perjalanan.harga);
            pstmt.setString(5, perjalanan.idperjalanan);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String idperjalanan) {
        String sql = "DELETE FROM perjalanan WHERE idperjalanan = ?";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idperjalanan);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Perjalanan selectByidperjalanan(String idperjalanan) {
        String sql = "SELECT idperjalanan,harga FROM perjalanan WHERE idperjalanan = ?";
        Perjalanan perjalanan = null;

        try (Connection conn = KoneksiDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idperjalanan);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                perjalanan = new Perjalanan(
                        rs.getString("idperjalanan"),
                        rs.getInt("harga"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return perjalanan; 
    }

}
