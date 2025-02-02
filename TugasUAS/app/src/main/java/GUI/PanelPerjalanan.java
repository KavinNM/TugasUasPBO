/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import entities.Perjalanan;
import helpers.KoneksiDB;
import helpers.TabelPerjalanan;
import java.sql.Connection;
import java.util.List;
import models.PerjalananDAO;
import models.PerjalananSql;

/**
 *
 * @author HP
 */
public class PanelPerjalanan extends javax.swing.JPanel {

    PerjalananDAO dao;
    List<Perjalanan> dataPerjalanan;

    boolean editMode = false;

    /**
     * Creates new form PanelPerjalanan
     */
    public PanelPerjalanan() {
        initComponents();
        dao = new PerjalananSql();
        refresh();
    }

    private void clear() {
        txtIdperjalanan.setText("");
        txtAsal.setText("");
        txtTujuan.setText("");
        txtJadwal.setText("");
        txtHarga.setText("");

        btnHapus.setEnabled(false);
    }

    public void refresh() {
        dataPerjalanan = dao.selectAll();
        tblPerjalanan.setModel(new TabelPerjalanan(dataPerjalanan));
        clear();
    }

    public void cari() {
        dataPerjalanan = dao.selectByRoute(txtAsal.getText(), txtTujuan.getText());
        tblPerjalanan.setModel(new TabelPerjalanan(dataPerjalanan));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdperjalanan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAsal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTujuan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtJadwal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPerjalanan = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        jLabel1.setText("ID Perjalanan");

        txtIdperjalanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdperjalananActionPerformed(evt);
            }
        });

        jLabel2.setText("Asal");

        txtAsal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAsalActionPerformed(evt);
            }
        });

        jLabel3.setText("Tujuan");

        txtTujuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTujuanActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(0, 153, 0));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(153, 0, 0));
        btnHapus.setText("Hapus");
        btnHapus.setEnabled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel4.setText("Jadwal");

        jLabel5.setText("Harga");

        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });

        tblPerjalanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPerjalanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPerjalananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPerjalanan);

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAsal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdperjalanan, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(85, 85, 85)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCari)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSimpan)
                                    .addComponent(btnHapus))))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdperjalanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdperjalananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdperjalananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdperjalananActionPerformed

    private void txtAsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String idperjalanan = txtIdperjalanan.getText();
        String asal = txtAsal.getText();
        String tujuan = txtTujuan.getText();
        String jadwal = txtJadwal.getText();
        int harga = Integer.parseInt(txtHarga.getText());

        Perjalanan perjalanan = new Perjalanan(idperjalanan, asal, tujuan, jadwal, harga);

        if (editMode == false) {
            dao.insert(perjalanan);
        } else {
            dao.update(perjalanan);
        }
        refresh();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void txtTujuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTujuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTujuanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        dao.delete(txtIdperjalanan.getText());
        refresh();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblPerjalananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPerjalananMouseClicked
        if (evt.getClickCount() == 2) {
            editMode = true;
            btnHapus.setEnabled(true);

            Perjalanan perjalanan = dataPerjalanan.get(tblPerjalanan.getSelectedRow());

            txtIdperjalanan.setText(perjalanan.idperjalanan);
            txtAsal.setText(perjalanan.asal);
            txtTujuan.setText(perjalanan.tujuan);
            txtJadwal.setText(perjalanan.jadwal);
            txtHarga.setText(String.valueOf(perjalanan.harga));

            txtIdperjalanan.setEnabled(false);

        }
    }//GEN-LAST:event_tblPerjalananMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        editMode = false;
        txtIdperjalanan.setEnabled(true);
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPerjalanan;
    private javax.swing.JTextField txtAsal;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIdperjalanan;
    private javax.swing.JTextField txtJadwal;
    private javax.swing.JTextField txtTujuan;
    // End of variables declaration//GEN-END:variables
}
