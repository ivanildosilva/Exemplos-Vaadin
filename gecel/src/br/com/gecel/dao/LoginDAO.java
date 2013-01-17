/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gecel.dao;

import br.com.gecel.control.Conexao;
import br.com.gecel.exception.CreateDAOException;
import br.com.gecel.model.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ivanildo
 */
public class LoginDAO {

    private Conexao connect;

    public LoginDAO() {
        connect = new Conexao();
    }

    public String consultalogin(Usuario usuario) throws SQLException, CreateDAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            connect.beginTransection();
            conn = connect.getConnectionFromContext();

            String sql = "SELECT nome From Usuario where login = '"
                    + usuario.getLogin() + "' and senha= '" + usuario.getSenha() + "'";
            stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            r.next();
            connect.endTransection();
            return r.getString("nome");

        } catch (SQLException e) {
            connect.rollbackTransection();
            return null;

        }
    }

    public ArrayList<Usuario> retornaUser(String login, String senha) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet r = null;
        try {
            connect.beginTransection();
            conn = connect.getConnectionFromContext();

            String sql = "SELECT nome, foto, id From Usuario where login = '"
                    + login + "' and senha= '" + senha + "'";
            stmt = conn.prepareStatement(sql);
            r = stmt.executeQuery();
            ArrayList<Usuario> user = new ArrayList<Usuario>();
            while (r.next()) {
                Usuario co = new Usuario(r.getInt("id"), r.getString("nome"),
                        r.getString("foto"));

                user.add(co);

            }
            return user;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public int consultaParticipante() throws SQLException, CreateDAOException {
        int codigo = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {

            connect.beginTransection();
            conn = connect.getConnectionFromContext();

            String sql = "select MAX(id) as Codigo from participante";
            stmt = conn.prepareStatement(sql);
            ResultSet r = stmt.executeQuery();
            r.next();

            codigo = r.getInt("Codigo");
        } catch (SQLException e) {
            connect.rollbackTransection();
            throw new CreateDAOException("Não foi possível criar a transação " + e);

        } finally {
            connect.endTransection();
        }

        return codigo;
    }
    
}
