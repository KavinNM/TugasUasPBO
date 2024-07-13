/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.Perjalanan;
import entities.Pesan;
import entities.Tiket;
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
public class TiketSql implements TiketDAO {

    @Override
    public void insert(Tiket tiket) {
        String sql = "INSERT INTO tiket(idtiket, idperjalanan, jumlah,hargatiket) VALUES(?, ?, ?,?)";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tiket.idtiket);
            pstmt.setString(2, tiket.idperjalanan.idperjalanan);
            pstmt.setInt(3, tiket.jumlah);
            pstmt.setInt(4, tiket.harga);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Tiket> selectAll() {
        String sql = """
            SELECT idtiket, t.idperjalanan as idjalan,jadwal, jumlah,asal,tujuan,harga
                            FROM tiket t,perjalanan p
                            where t.idperjalanan = p.idperjalanan""";
        List<Tiket> datatkt = new ArrayList<>();

        try (Connection conn = KoneksiDB.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Tiket tiket = new Tiket(
                        rs.getString("idtiket"),
                        rs.getInt("jumlah")
                );
                String idperjalanan = rs.getString("idjalan");
                String asal = rs.getString("asal");
                String tujuan = rs.getString("tujuan");
                String jadwal = rs.getString("jadwal");
                int harga = rs.getInt("harga");
                if (idperjalanan != null) {
                    tiket.idperjalanan = new Perjalanan(idperjalanan, asal, tujuan, jadwal, harga);
                }
                datatkt.add(tiket);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return datatkt;
    }

    @Override
    public void update(Tiket tiket) {
        String sql = "UPDATE tiket SET jumlah = ? where idtiket = ?  ";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tiket.jumlah);
            pstmt.setString(2, tiket.idtiket);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String idtiket) {
        String sql = "DELETE FROM tiket WHERE idtiket = ?";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idtiket);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Tiket selectbyidtiket(String idtiket) {
        String sql = """
            SELECT idtiket, t.idperjalanan as idjalan, jumlah
                FROM tiket t,perjalanan p
                where t.idperjalanan = p.idperjalanan and idtiket= ?""";

        Tiket tiket = null;

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idtiket);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                tiket = new Tiket(
                        rs.getString("idtiket"),
                        rs.getInt("jumlah")
                );
                String idperjalanan = rs.getString("idjalan");
                if (idperjalanan != null) {
                    tiket.idperjalanan = new Perjalanan(idperjalanan);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tiket;
    }

    @Override
    public void tambah(Tiket tiket, int jumlah) {
        String sql = "UPDATE tiket SET jumlah = jumlah +? where idtiket = ?  ";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, jumlah);
            pstmt.setString(2, tiket.idtiket);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void kurang(Tiket tiket, int jumlah) {
        String sql = "UPDATE tiket SET jumlah = jumlah -? where idtiket = ?  ";

        try (Connection conn = KoneksiDB.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, jumlah);
            pstmt.setString(2, tiket.idtiket);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
