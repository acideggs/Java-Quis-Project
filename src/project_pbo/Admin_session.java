
package project_pbo;

public class Admin_session {

    private static String username, statusLogin;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Admin_session.username = username;
    }

    public static String getStatusLogin() {
        return statusLogin;
    }

    public static void setStatusLogin(String statusLogin) {
        Admin_session.statusLogin = statusLogin;
    }

}
