/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gecel.dao;

import br.com.gecel.control.Conexao;
import br.com.gecel.exception.CreateDAOException;
import br.com.gecel.model.entity.Contato;
import br.com.gecel.model.entity.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ivanildo
 */
public class EnderecoDAO {

    private Conexao connect;

    public EnderecoDAO() {
        connect = new Conexao();
    }

    public void incluirEndereco(Endereco endereco) throws CreateDAOException, SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            connect.beginTransection();
            conn = connect.getConnectionFromContext();
            int index = 0;
            //Montagem da string sql que serÃ¡ rodada no banco de dados
            String sql = "INSERT INTO endereco (logradouro, numero, bairro, cidade, "
                    + "cep, complemento, uf, participante) "
                    + "values (?,?,?,?,?,?,?,?)";
            //Método preparedStatement de conexão para criar o PreparedStatement
            stmt = connect.prepareStatement(sql);

            stmt.setString(++index, endereco.getLogradouro());
            stmt.setString(++index, endereco.getNumero());
            stmt.setString(++index, endereco.getBairro());
            stmt.setString(++index, endereco.getCidade());
            stmt.setInt(++index, endereco.getCep());
            stmt.setString(++index, endereco.getComplemento());
            stmt.setString(++index, endereco.getUf());
            stmt.setString(++index, endereco.getParticipante().getMatricula());
            System.out.println("id participante endereco " + endereco.getParticipante().getId());
            stmt.executeUpdate();

            connect.endTransection();
        } catch (SQLException ex) {
            connect.rollbackTransection();
            throw new CreateDAOException("Não foi possível criar a transação " + endereco + ex);
        } catch (Exception ex) {
            throw new CreateDAOException("Não foi possível criar a transação " + endereco + ex);
        } finally {
            connect.releaseAll(conn, stmt);
        }
    }

    public void updateEndereco(Endereco endereco) throws SQLException, CreateDAOException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            connect.beginTransection();
            conn = connect.getConnectionFromContext();

            String sql = "update endereco set logradouro=?, numero=?, bairro=?, "
                    + "cidade=?, cep=?, complemento=?, uf=? where participante='"
                    + endereco.getParticipante().getMatricula() + "'";
            
            stmt = connect.prepareStatement(sql);
            int index = 0;

            stmt.setString(++index, endereco.getLogradouro().toUpperCase());
            stmt.setString(++index, endereco.getNumero());
            stmt.setString(++index, endereco.getBairro().toUpperCase());
            stmt.setString(++index, endereco.getCidade().toUpperCase());
            stmt.setInt(++index, endereco.getCep());
            stmt.setString(++index, endereco.getComplemento().toUpperCase());
            stmt.setString(++index, endereco.getUf().toUpperCase());
            
            stmt.execute();

        } catch (SQLException ex) {
            connect.rollbackTransection();
            throw new CreateDAOException("Não foi possível criar a transação " + endereco + ex);

        } catch (Exception ex) {
            throw new CreateDAOException("Não foi possível criar a transação " + endereco + ex);
        } finally {
            connect.releaseAll(conn, stmt);
        }
    }
}