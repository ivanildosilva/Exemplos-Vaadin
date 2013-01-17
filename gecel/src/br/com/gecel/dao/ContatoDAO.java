/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gecel.dao;

import br.com.gecel.control.Conexao;
import br.com.gecel.exception.CreateDAOException;
import br.com.gecel.model.entity.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ivanildo
 */
public class ContatoDAO {

    private Conexao connect;

    public ContatoDAO() {
        connect = new Conexao();
    }

    public void incluirCotanto(Contato contato) throws CreateDAOException, SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
       
        try {
            connect.beginTransection();
            conn = connect.getConnectionFromContext();
            int index = 0;
            //Montagem da string sql que serÃ¡ rodada no banco de dados
            String sql = "INSERT INTO contato (telefone, celular, email, "
                    + "participante) values (?,?,?,?)";
            //Método preparedStatement de conexão para criar o PreparedStatement
            stmt = connect.prepareStatement(sql);

            stmt.setString(++index, contato.getTelefoneFixo());
            stmt.setString(++index, contato.getCelular());
            stmt.setString(++index, contato.getEmail());
            stmt.setString(++index, contato.getParticipante().getMatricula());
            System.out.println("id participante contato " + contato.getParticipante().getId());
            stmt.executeUpdate();

            connect.endTransection();

        } catch (SQLException ex) {
           connect.rollbackTransection();
           throw new CreateDAOException("Não foi possível criar a transação " + contato + ex);
        } catch (Exception ex) {
           connect.rollbackTransection();
            throw new CreateDAOException("Não foi possível criar a transação " + contato + ex);
        } finally {
            connect.releaseAll(conn, stmt);
        }

    }
    public void updateContato(Contato contato) throws SQLException, CreateDAOException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            connect.beginTransection();
            conn = connect.getConnectionFromContext();

            String sql = "update contato set telefone=?, celular=?, email=? where participante='"
                    + contato.getParticipante().getMatricula() + "'";
            System.out.println("matricula " + contato.getParticipante().getMatricula());
            stmt = connect.prepareStatement(sql);
            int index = 0;

            stmt.setString(++index, contato.getTelefoneFixo());
            stmt.setString(++index, contato.getCelular());
            stmt.setString(++index, contato.getEmail().toLowerCase());
            stmt.execute();

        } catch (SQLException ex) {
            connect.rollbackTransection();
            throw new CreateDAOException("Não foi possível criar a transação " + contato + ex);

        } catch (Exception ex) {
            throw new CreateDAOException("Não foi possível criar a transação " + contato + ex);
        } finally {
            connect.releaseAll(conn, stmt);
        }
    }
}
