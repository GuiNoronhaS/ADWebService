/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisul.ad23automacaowebservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Guilherme Noronha
 */
public class Conexao {

    String dbdriver = "com.mysql.cj.jdbc.Driver";
    String dburl = "";
    String dbusuario = "";
    String dbsenha = "";
    Connection con;
    Statement stmt;

    public Conexao() {
    }

    /**
     * Metodo que é usado para tentar a conexão com o banco de dados retorna
     * true caso de certo e false para os erros
     *
     * @return boolean
     */
    public boolean conectarBanco() {
        try {
            Class.forName(dbdriver);
            con = DriverManager.getConnection(dburl, dbusuario, dbsenha);
            System.out.println("Conexão bem sucedida");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("USE webserviceautomacao");
            System.out.println("Pronto para uso");
            stmt.close();
            return true;
        } catch (ClassNotFoundException e) { //Falha em carregar o DRIVER 
            System.out.println("Falha no Driver = " + e);
            return false;
        } catch (SQLException e) { // Falha na Conexão ou no SQL  
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    /**
     * Metodo que é usado para cortar a conexão com o banco de dados retorna
     * true caso de certo e false para os erros
     *
     * @return boolean
     */
    public boolean desconectarBanco() {
        try {
            con.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL  
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }
    public Connection getConnection() {
        return con;
    }

}
