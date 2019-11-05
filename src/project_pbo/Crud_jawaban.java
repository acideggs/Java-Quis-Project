package project_pbo;

import java.sql.ResultSet;

public class Crud_jawaban extends Crud {

    private String pil_A, pil_B, pil_C, pil_D, kunci;

    public String getPil_A() {
        return pil_A;
    }

    public void setPil_A(String pil_A) {
        this.pil_A = pil_A;
    }

    public String getPil_B() {
        return pil_B;
    }

    public void setPil_B(String pil_B) {
        this.pil_B = pil_B;
    }

    public String getPil_C() {
        return pil_C;
    }

    public void setPil_C(String pil_C) {
        this.pil_C = pil_C;
    }

    public String getPil_D() {
        return pil_D;
    }

    public void setPil_D(String pil_D) {
        this.pil_D = pil_D;
    }

    public String getKunci() {
        return kunci;
    }

    public void setKunci(String kunci) {
        this.kunci = kunci;
    }

    public ResultSet getData() {
        query = "select max(id_jawaban) from tb_jawaban";
        try {
            smt = koneksi.createStatement();
            hasil = smt.executeQuery(query);
            if (!hasil.next()) {
                query = "select * from tb_jawaban";
                try {
                    smt = koneksi.createStatement();
                    hasil = smt.executeQuery(query);
                } catch (Exception e) {
                    System.out.println("get data jawaban error : " + e);
                }
            }
        } catch (Exception e) {
            System.out.println("gagal ambil data" + e);
        }
        return hasil;
    }

    public ResultSet searchData(int id_jawaban) {
        query = "select * from tb_jawaban where id_jawaban=?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setInt(1, id_jawaban);
            hasil = psmt.executeQuery(query);
            psmt.close();
        } catch (Exception e) {

        }
        return hasil;
    }

    public void simpan(String pil_A, String pil_B, String pil_C, String pil_D, String kunci) {
        query = "insert into tb_jawaban values(null,?,?,?,?,?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, pil_A);
            psmt.setString(2, pil_B);
            psmt.setString(3, pil_C);
            psmt.setString(4, pil_D);
            psmt.setString(5, kunci);
            psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("gagal simpan " + e);
        }
    }
    
    public void update(String pil_A, String pil_B, String pil_C, String pil_D, String kunci, int id_jawaban) {
        query = "update tb_jawaban set pilihan_a=?, pilihan_b=?, pilihan_c=?, pilihan_d=?, kunci=? where id_jawaban=?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, pil_A);
            psmt.setString(2, pil_B);
            psmt.setString(3, pil_C);
            psmt.setString(4, pil_D);
            psmt.setString(5, kunci);
            psmt.setInt(6, id_jawaban);
            psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("gagal simpan " + e);
        }
    }
    
    public void delete(int id_jawaban) {
        query = "delete from tb_jawaban where id_jawaban=?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setInt(1, id_jawaban);
            psmt.executeUpdate();
            psmt.close();
        } catch (Exception e) {
            System.out.println("gagal hapus soal " + e);
        }
    }

}
