/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Reda
 */
public class Conexion {

    public static Connection connect() {
        String MySQLURL = "jdbc:mysql://localhost/institut";
        String databseUserName = "root";
        String databasePassword = "root";
        Connection con = null;

        try {
            //Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "institut?useUnicode=true&useJDBCCompliantTimezoneShift=true&"
                    + "useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

}
