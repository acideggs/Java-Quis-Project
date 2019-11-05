package project_pbo;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Crud_soal extends Crud {

    private String kategori, isi_soal;
    private String[] data_soal = new String[10];

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getIsi_soal() {
        return isi_soal;
    }

    public void setIsi_soal(String isi_soal) {
        this.isi_soal = isi_soal;
    }

    public ResultSet getData() {
        query = "select * from tb_soal";
        try {
            smt = koneksi.createStatement();
            hasil = smt.executeQuery(query);
        } catch (Exception e) {

        }
        return hasil;
    }

    public String[] getData_soal() {
        return data_soal;
    }

    public void setData_soal(String isi, int index) {
        data_soal[index] = isi;
    }

    public ResultSet searchByIdJawaban(int id_jawaban) {
        query = "select id_soal,kategori, isi_soal,pilihan_a,pilihan_b,pilihan_c,pilihan_d,kunci from tb_soal,tb_jawaban where tb_soal.id_jawaban=" + id_jawaban + " and tb_jawaban.id_jawaban=" + id_jawaban;
        try {
            smt = koneksi.createStatement();
            hasil = smt.executeQuery(query);
            psmt.close();
        } catch (Exception e) {
        }
        return hasil;
    }

    public ResultSet searchByIdSoal(int id_soal) {
        query = "select * from tb_soal, tb_jawaban where id_soal=" + id_soal + " and tb_soal.id_jawaban = tb_jawaban.id_jawaban";
        try {
            smt = koneksi.createStatement();
            hasil = smt.executeQuery(query);
            psmt.close();
        } catch (Exception e) {
        }
        return hasil;
    }

    public ResultSet searchByKategoriRand(String kategori) {
        query = "select id_soal,kategori, isi_soal,pilihan_a,pilihan_b,pilihan_c,pilihan_d,kunci from tb_soal,tb_jawaban where tb_soal.id_jawaban=tb_jawaban.id_jawaban and kategori='" + kategori + "' order by rand()";
        try {
            smt = koneksi.createStatement();
            hasil = smt.executeQuery(query);
            psmt.close();
        } catch (Exception e) {
        }
        return hasil;
    }

    public void simpan(String kategori, String isi_soal, int id_jawaban) {
        query = "insert into tb_soal values(null,?,?,?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, kategori);
            psmt.setString(2, isi_soal);
            psmt.setInt(3, id_jawaban);
            psmt.executeUpdate();
            psmt.close();
            JOptionPane.showMessageDialog(null, "Soal Berhasil Disimpan");
        } catch (Exception e) {
            System.out.println("gagal simpan soal " + e);
        }
    }

    public void update(String kategori, String isi_soal, int id_jawaban) {
        query = "update tb_soal set kategori=?, isi_soal=? where id_jawaban=?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, kategori);
            psmt.setString(2, isi_soal);
            psmt.setInt(3, id_jawaban);
            psmt.executeUpdate();
            psmt.close();
            JOptionPane.showMessageDialog(null, "Soal Berhasil Diubah");
        } catch (Exception e) {
            System.out.println("gagal ubah soal " + e);
        }
    }

    public void delete(int id_jawaban) {
        query = "delete from tb_soal where id_jawaban=?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setInt(1, id_jawaban);
            psmt.executeUpdate();
            psmt.close();
            JOptionPane.showMessageDialog(null, "Soal Berhasil dihapus");
        } catch (Exception e) {
            System.out.println("gagal hapus soal " + e);
        }
    }

}
