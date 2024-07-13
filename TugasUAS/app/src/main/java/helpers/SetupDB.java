/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class SetupDB {

    public static void migrate() {
        String[] sql = {"""
            CREATE TABLE IF NOT EXISTS perjalanan (
            idperjalanan TEXT PRIMARY KEY,
            asal TEXT NOT NULL,
            tujuan TEXT NOT NULL,
            jadwal TEXT NOT NULL,
            harga INTEGER NOT NULL);""",
            """
            CREATE TABLE IF NOT EXISTS tiket (
            idtiket TEXT PRIMARY KEY,
            idperjalanan TEXT,
            jumlah INTEGER NOT NULL,
            hargatiket INTEGER NOT NULL,
            FOREIGN KEY (idperjalanan) REFERENCES perjalanan(idperjalanan)
            );""",
            """
            CREATE TABLE IF NOT EXISTS pesan (
            idpesan TEXT PRIMARY KEY,
            idtiket TEXT,
            idperjalanan TEXT,
            nama TEXT NOT NULL,
            jumlahkursi INTEGER NOT NULL,
            total INTEGER DEFAULT 0,
            status TEXT default 'Menunggu',
            FOREIGN KEY (idtiket) REFERENCES tiket(idtiket),
            FOREIGN KEY (idperjalanan) REFERENCES perjalanan(idperjalanan)
            );""",};

        try (Connection conn = KoneksiDB.connect(); Statement stmt = conn.createStatement()) {

            for (String query : sql) {
                stmt.executeUpdate(query);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
