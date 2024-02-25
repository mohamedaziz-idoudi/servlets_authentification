package main;

import java.sql.*;



public class LoginDao {
    public static boolean validate(String name, String pass) {
        boolean status = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true", "idoudi", "Qwerty123@"); // creating a connection with mysql database

            PreparedStatement ps = con.prepareStatement(
                    "select * from userreg where name=? and pass=?"); // preparing sql statement
            ps.setString(1, name);									// setting the first parameter name(sql)
            ps.setString(2, pass);									// setting the second parameter pass

            ResultSet rs = ps.executeQuery();// executing the query
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
