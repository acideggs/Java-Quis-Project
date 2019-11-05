package project_pbo;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Crud_player extends Crud {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void register(String username) {
        query = "insert into tb_player values(null,?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, username);
            psmt.executeUpdate();
            psmt.close();
            JOptionPane.showMessageDialog(null, "Pendaftaran Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mendaftar");
            System.out.println(e);
        }
    }

    public ResultSet search(String username) {
        query = "select * from tb_player where username='" + username + "'";
        try {
            smt = koneksi.createStatement();
            hasil = smt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return hasil;
    }

}
