/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_pbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ndogs
 */
public class Admin_login {

    private Connection koneksi;
    private PreparedStatement psmt;
    private ResultSet userData;
    private String query, username, password, message;

    public Admin_login() {
        KoneksiMysql connection = new KoneksiMysql();
        try {
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login(String username, String password) {
        query = "select * from tb_admin where user_admin=? AND password=md5(?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, username);
            psmt.setString(2, password);
            userData = psmt.executeQuery();

            if (userData.next()) {
                Admin_session.setUsername(userData.getString("user_admin"));
                Admin_session.setStatusLogin("AKTIF");

                query = "insert into tb_log_admin(user_admin) values(?)";
                try {
                    psmt = koneksi.prepareStatement(query);
                    psmt.setString(1, username);
                    psmt.executeUpdate();
                    psmt.close();
                } catch (Exception e) {
                    message = "gagal simpan log login";
                }
            } else {
                message = "gagal login";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return message;
    }

    public void logout(String username) {
        query = "update tb_log_admin set time_out=CURRENT_TIMESTAMP() where user_admin=? order by id desc limit 1";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, username);
            psmt.executeUpdate();
            psmt.close();
            
            koneksi.close();
            
            Admin_session.setUsername(null);
            Admin_session.setStatusLogin(null);
        } catch (Exception e) {
            System.out.println("gagal logout : " + e);
        }
    }

}
