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
import java.sql.SQLException;

/**
 *
 * @author ivanildofilho
 */
public class UsuarioDAO {

  Conexao connect;

  public UsuarioDAO() {
    connect = new Conexao();

  }

  public void incluirUsuario(Usuario usuario) throws CreateDAOException, SQLException {

    Connection conn = null;
    PreparedStatement stmt = null;

    try {
      connect.beginTransection();
      conn = connect.getConnectionFromContext();
      int index = 0;
      //Montagem da string sql que serÃ¡ rodada no banco de dados
      String sql = "INSERT INTO usuario (nome, login, senha, foto, "
              + "ativo, privilegio) values (?,?,?,?,?,?)";
      //Método preparedStatement de conexão para criar o PreparedStatement
      stmt = connect.prepareStatement(sql);

      stmt.setString(++index, usuario.getNome().toUpperCase());
      stmt.setString(++index, usuario.getLogin().toLowerCase());
      stmt.setString(++index, usuario.getSenha());
      stmt.setString(++index, usuario.getFoto());
      stmt.setInt(++index, usuario.getAtivo());
      stmt.setInt(++index, usuario.getPrivilegio().getId());
      //System.out.println("id participante contato " + usuario.getParticipante().getId());
      stmt.executeUpdate();

      connect.endTransection();

    } catch (SQLException ex) {
      connect.rollbackTransection();
      throw new CreateDAOException("Não foi possível criar a transação " + usuario + ex);
    } catch (Exception ex) {
      connect.rollbackTransection();
      throw new CreateDAOException("Não foi possível criar a transação " + usuario + ex);
    } finally {
      connect.releaseAll(conn, stmt);
    }

  }
}
