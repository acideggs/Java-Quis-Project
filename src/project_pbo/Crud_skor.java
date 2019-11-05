/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_pbo;

import java.sql.ResultSet;

/**
 *
 * @author ndogs
 */
public class Crud_skor extends Crud {

    private String username, waktu, kategori;
    private int skor, id_kuis;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public int getId_kuis() {
        return id_kuis;
    }

    public void setId_kuis(int id_kuis) {
        this.id_kuis = id_kuis;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public ResultSet getData() {
        query = "select * from tb_skor order by score desc";
        try {
            smt = koneksi.createStatement();
            hasil = smt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return hasil;
    }

    public ResultSet getTime(int id_kuis) {
        query = "select timediff ((select time_out from tb_skor where id_kuis=?),(select time_in from tb_skor where id_kuis=?)) as time";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setInt(1, id_kuis);
            psmt.setInt(2, id_kuis);
            hasil = psmt.executeQuery();
//            psmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return hasil;
    }

}
