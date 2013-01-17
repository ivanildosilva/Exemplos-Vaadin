/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gecel.dao;

import br.com.gecel.control.Conexao;
import br.com.gecel.exception.CreateDAOException;
import br.com.gecel.model.entity.Contato;
import br.com.gecel.model.entity.Endereco;
import br.com.gecel.model.entity.Participante;
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
public class ParticipanteDAO {
    
    private Conexao connect;
    
    public ParticipanteDAO() {
        connect = new Conexao();
    }
    
    public void incluirParticipante(Participante participante) throws CreateDAOException, SQLException {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        ContatoDAO contatoDAO = new ContatoDAO();
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            
            connect.beginTransection();
            conn = connect.getConexaoMySQL();
            int index = 0;
            //Montagem da string sql que serÃ¡ rodada no banco de dados
            String sql = "INSERT INTO participante (nome, sobrenome, sexo, nascimento, curso, "
                    + "matricula, projeto, rg, cpf, foto, cadastro, obs, criador, ativo) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //Método preparedStatement de conexão para criar o PreparedStatement
            stmt = connect.prepareStatement(sql);
            
            stmt.setString(++index, participante.getNome());
            stmt.setString(++index, participante.getSobreNome());
            stmt.setString(++index, participante.getSexo().toString());
            stmt.setDate(++index, new java.sql.Date(participante.getNascimento().getTime()));
            stmt.setString(++index, participante.getCurso());
            stmt.setString(++index, participante.getMatricula());
            stmt.setString(++index, participante.getProjeto());
            stmt.setString(++index, participante.getRg());
            stmt.setString(++index, participante.getCpf());
            stmt.setString(++index, participante.getFoto());
            stmt.setDate(++index, new java.sql.Date(participante.getCadastro().getTime()));
            stmt.setString(++index, participante.getObservacao());
            stmt.setInt(++index, participante.getCriador().getId());
            stmt.setInt(++index, participante.getAtivo());
            stmt.executeUpdate();
            
            enderecoDAO.incluirEndereco(participante.getEndereco());
            contatoDAO.incluirCotanto(participante.getContato());
            connect.endTransection();
        } catch (SQLException ex) {
            connect.rollbackTransection();
            throw new CreateDAOException("Não foi possível criar a transação " + participante + ex);
            
        } catch (Exception ex) {
            throw new CreateDAOException("Não foi possível criar a transação " + participante + ex);
        } finally {
            connect.releaseAll(conn, stmt);
        }
        
    }
    
    public ArrayList<Participante> retornaParticipante() throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet r = null;
        try {
            connect.beginTransection();
            conn = connect.getConnectionFromContext();
            
            String sql = "SELECT p.matricula, p.nome, p.sobrenome, p.sexo, p.nascimento, "
                    + "p.curso, p.projeto, p.rg, p.cpf, p.obs, p.foto, p.cadastro, "
                    + "p.ativo, e.logradouro, e.numero, e.bairro, e.cidade, "
                    + "e.cep, e.complemento, e.uf, c.telefone, c.celular, c.email, "
                    + "u.nome FROM participante AS p INNER JOIN "
                    + "endereco AS e ON p.matricula = e.participante INNER JOIN "
                    + "contato AS c ON p.matricula = c.participante INNER JOIN "
                    + "usuario AS u ON p.criador = u.id";
            stmt = conn.prepareStatement(sql);
            r = stmt.executeQuery();
            ArrayList<Participante> participante = new ArrayList<Participante>();
            while (r.next()) {
                Participante pa = new Participante(r.getString(1), r.getString(2), r.getString(3),
                        r.getString(4), (java.util.Date) r.getDate(5), r.getString(6),
                        r.getString(7), r.getString(8), r.getString(9), r.getString(10),
                        r.getString(11), (java.util.Date) r.getDate(12), r.getInt(13),
                        new Endereco(r.getString(14), r.getString(15), r.getString(16),
                        r.getString(17), r.getInt(18), r.getString(19), r.getString(20)),
                        new Contato(r.getString(21), r.getString(22), r.getString(23)),
                        new Usuario(r.getString(24)));
                
                participante.add(pa);
                
            }
            return participante;
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
        
    }
    
    public ArrayList<Participante> consultaParticipante(String consulta, int flag) throws SQLException, CreateDAOException {
        Connection conn;
        PreparedStatement stmt;
        ResultSet r;
        
        try {
            connect.beginTransection();
            conn = connect.getConnectionFromContext();
            String sql = "SELECT p.matricula, p.nome, p.sobrenome, p.sexo, p.nascimento, "
                    + "p.curso, p.projeto, p.rg, p.cpf, p.obs, p.foto, p.cadastro, "
                    + "p.ativo, e.logradouro, e.numero, e.bairro, e.cidade, "
                    + "e.cep, e.complemento, e.uf, c.telefone, c.celular, c.email, "
                    + "u.nome FROM participante AS p INNER JOIN "
                    + "endereco AS e ON p.matricula = e.participante INNER JOIN "
                    + "contato AS c ON p.matricula = c.participante INNER JOIN "
                    + "usuario AS u ON p.criador = u.id ";
            
            if (flag == 1) {
                System.out.println("flag " + flag);
                sql += "where p.matricula = '" + consulta + "'";
            } else if (flag == 2) {
                System.out.println("flag " + flag);
                sql += "where p.nome LIKE  '%" + consulta + "%'";
                
            }
            stmt = conn.prepareStatement(sql);
            r = stmt.executeQuery();
            
            ArrayList<Participante> participante = new ArrayList<Participante>();
            while (r.next()) {
                
                Participante pa = new Participante(r.getString(1), r.getString(2), r.getString(3),
                        r.getString(4), (java.util.Date) r.getDate(5), r.getString(6),
                        r.getString(7), r.getString(8), r.getString(9), r.getString(10),
                        r.getString(11), (java.util.Date) r.getDate(12), r.getInt(13),
                        new Endereco(r.getString(14), r.getString(15), r.getString(16),
                        r.getString(17), r.getInt(18), r.getString(19), r.getString(20)),
                        new Contato(r.getString(21), r.getString(22), r.getString(23)),
                        new Usuario(r.getString(24)));
                
                participante.add(pa);
                
            }
            if (participante.size() > 0) {
                return participante;
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            
            return null;
        }
    }
    
    public void updateParticipante(Participante participante) throws SQLException, CreateDAOException {
        ContatoDAO contatoDAO = new ContatoDAO();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            connect.beginTransection();
            conn = connect.getConnectionFromContext();
            
            String sql = "update participante set nome=?, sobrenome=?, sexo=?, nascimento=?, curso=?"
                    + ", projeto=?, rg=?, cpf=?, obs=?, cadastro=? where matricula='"
                    + participante.getMatricula() + "'";
            
            stmt = connect.prepareStatement(sql);
            int index = 0;
            
            stmt.setString(++index, participante.getNome());
            System.out.println("nome " + participante.getNome());
            stmt.setString(++index, participante.getSobreNome());
            stmt.setString(++index, participante.getSexo());
            stmt.setDate(++index, new java.sql.Date(participante.getNascimento().getTime()));
            stmt.setString(++index, participante.getCurso());
            stmt.setString(++index, participante.getProjeto());
            stmt.setString(++index, participante.getRg());
            stmt.setString(++index, participante.getCpf());
            stmt.setString(++index, participante.getObservacao());
            stmt.setDate(++index, new java.sql.Date(participante.getCadastro().getTime()));
            stmt.execute();
            
            contatoDAO.updateContato(participante.getContato());
            enderecoDAO.updateEndereco(participante.getEndereco());
            
        } catch (SQLException ex) {
            connect.rollbackTransection();
            throw new CreateDAOException("Não foi possível criar a transação " + participante + ex);
            
        } catch (Exception ex) {
            throw new CreateDAOException("Não foi possível criar a transação " + participante + ex);
        } finally {
            connect.releaseAll(conn, stmt);
        }
    }
}
