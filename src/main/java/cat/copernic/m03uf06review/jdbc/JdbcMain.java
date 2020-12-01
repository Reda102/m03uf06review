/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola.
 *
 *
 * @author pep
 */
public class JdbcMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String usuario = "root";
        String clave = "root";
        String url = "jdbc:mysql://localhost:3306/institut";
        Connection con;
        Statement stmt;
        ResultSet rs;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + "institut?useUnicode=true&useJDBCCompliantTimezoneShift=true&"
                    + "useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * From alumnat");
            rs.next();
            do { // ID dni nom cognoms data_naixement
                System.out.println(rs.getInt("id") + " " + rs.getString("dni") + " " + rs.getString("nom") + " " + rs.getString("cognoms")
                        + " " + rs.getDouble("matricula") + " " + rs.getDate("data_naixement") + " " + rs.getString("familia_nombrosa")
                        + " " + rs.getBoolean("mayor_edad"));
            } while (rs.next());

        } catch (SQLException ex) {
            Logger.getLogger(JdbcMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
