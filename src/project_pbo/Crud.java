package project_pbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud {

    protected Connection koneksi;
    protected PreparedStatement psmt;
    protected Statement smt;
    protected ResultSet hasil;
    protected String query;

    protected Crud() {
        try {
            KoneksiMysql connection = new KoneksiMysql();
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
