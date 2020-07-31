/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisul.ad23automacaowebservice.dao;

import br.unisul.ad23automacaowebservice.model.Itens;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Guilherme Noronha
 */
public class ItensDAO {

    private Connection con;

    public ItensDAO() {

    }

    public boolean inserir(Itens item) {
        try {
            RoupaDAO dao = new RoupaDAO();
            dao.setCon(con);
            int idRoupa = dao.buscarIDidentico(item.getRoupa());
            if (idRoupa == 0) {
                dao.inserir(item.getRoupa());
                idRoupa = dao.buscarIDidentico(item.getRoupa());
            }

            ComidaDAO daoB = new ComidaDAO();
            daoB.setCon(con);
            int idComida = daoB.buscarIDidentico(item.getComida());
            if (idComida == 0) {
                daoB.inserir(item.getComida());
                idComida = daoB.buscarIDidentico(item.getComida());
            }

            Statement smtm = con.createStatement();
            smtm.executeUpdate("insert into itens values ( null, "
                    + item.isDoacao() + ", "
                    + item.getDinheiro() + ", "
                    + idRoupa + ", "
                    + idComida + ")");
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    public Itens consultarID(int key) {
        Itens resultado = new Itens();
        try {
            int id = 0;
            int idComida = -1;
            int idRoupa = -2;
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from itens where idItens = " + key);
            while (rs.next()) {
                id = rs.getInt("idItens");
                if (id == key) {
                    resultado.setDoacao(rs.getBoolean("doar"));
                    resultado.setDinheiro(rs.getInt("dinheiro"));
                    idRoupa = rs.getInt("idRoupa");
                    idComida = rs.getInt("idComida");
                }
            }
            smtm.close();
            if (id == key) {
                RoupaDAO dao = new RoupaDAO();
                dao.setCon(con);
                resultado.setRoupa(dao.consultarID(idRoupa));
                ComidaDAO daoB = new ComidaDAO();
                daoB.setCon(con);
                resultado.setComida(daoB.consultarID(idComida));
            }
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return resultado;
    }

    public int buscarIDidentico(Itens key) {
        int resultado = 0;
        try {
            RoupaDAO dao = new RoupaDAO();
            dao.setCon(con);
            dao.inserir(key.getRoupa());
            int idRoupa = dao.buscarIDidentico(key.getRoupa());

            ComidaDAO daoB = new ComidaDAO();
            daoB.setCon(con);
            daoB.inserir(key.getComida());
            int idComida = daoB.buscarIDidentico(key.getComida());

            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from itens where doar = '" + key.isDoacao() + "'and dinheiro = " + key.getDinheiro() + "'and idRoupra = " + idRoupa + "'and idComida = " + idComida);
            while (rs.next()) {
                resultado = rs.getInt("idComidas");
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return resultado;
    }

    public ArrayList<Itens> listarTodos() {
        ArrayList<Itens> lista = new ArrayList<>();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from itens");
            while (rs.next()) {
                Itens resultado = new Itens(rs.getInt("dinheiro"),
                        rs.getBoolean("doar"));
                lista.add(resultado);
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return lista;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}
