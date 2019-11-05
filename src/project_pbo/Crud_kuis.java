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
public class Crud_kuis extends Crud {

    private int id_kuis, id_soal;
    private String jawaban, status;

    public int getId_kuis() {
        return id_kuis;
    }

    public void setId_kuis(int id_kuis) {
        this.id_kuis = id_kuis;
    }

    public int getId_soal() {
        return id_soal;
    }

    public void setId_soal(int id_soal) {
        this.id_soal = id_soal;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResultSet getCurrentId() {
        query = "select max(id_kuis) from tb_kuis";
        try {
            smt = koneksi.createStatement();
            hasil = smt.executeQuery(query);
        } catch (Exception e) {

        }
        return hasil;
    }

    public void start(String username, int id_kuis, String kategori) {
        query = "insert into tb_skor (username, id_kuis,score, kategori) values(?,?,0,?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, username);
            psmt.setInt(2, id_kuis);
            psmt.setString(3, kategori);
            psmt.executeUpdate();
            psmt.close();
            System.out.println("Berhasil Input");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void stop(int skor, int id_kuis) {
        query = "update tb_skor set time_out=CURRENT_TIMESTAMP(), score=? where id_kuis=?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setInt(1, skor);
            psmt.setInt(2, id_kuis);
            psmt.executeUpdate();
            psmt.close();
            System.out.println("Berhasil Input");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void simpan(int id_kuis, int id_soal, String jawaban) {
        query = "insert into tb_kuis values(null,?,?,?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setInt(1, id_kuis);
            psmt.setInt(2, id_soal);;
            psmt.setString(3, jawaban);
            psmt.executeUpdate();
            psmt.close();
            System.out.println("Berhasil simpan");
        } catch (Exception e) {

        }
    }

}
