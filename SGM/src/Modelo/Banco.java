/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author acg
 */
public class Banco {

    private static Connection conectar() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        //NO JAVA DB:
        //DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/manutencaoBD", "postgres", "lucaspeixoto");        
        //NO JAVA DB:
        //Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/bdcontatos", "usuario", "usuario"); 
        return c;
    }
    
    public static void executarAtualizacao(String sql) throws SQLException {
            Statement st = conectar().createStatement();
            st.executeUpdate(sql);
    }
    
     public static ResultSet executaConsulta(String sql) throws SQLException {
        Statement st = conectar().createStatement();
        return st.executeQuery(sql);
    }

}
