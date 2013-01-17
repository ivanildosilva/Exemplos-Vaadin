/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gecel.control;

import br.com.gecel.dao.LoginDAO;
import br.com.gecel.dao.ParticipanteDAO;
import br.com.gecel.exception.CreateDAOException;
import br.com.gecel.model.entity.Participante;
import br.com.gecel.relatorio.RelatorioParticipanteAll;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivanildo
 */
public class Conexao {

    /*
     Vamos armazenar nessa ThreadLocal uma transação com conexão
     * para passamos recupar em qualquer lugar do código a
     * transação corrente
     */
    ThreadLocal<Connection> context = new ThreadLocal<Connection>();

    /**
     * Fornecener conexão ao banco de dados
     *
     * @return connection
     * @throws SQLExption
     */
    public java.sql.Connection getConexaoMySQL() {

        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/gecelbs";
        String usuario = "aplicacao";
        String senha = "appuser";
        Connection conn;

        try {
// Carregando o JDBC Driver padrão
            Class.forName(driverName);

// Configurando a nossa conexão com um banco de dados//
            conn = DriverManager.getConnection(url, usuario, senha);

            //Testa sua conexão//  

            if (conn != null) {
            } else {

                JOptionPane.showMessageDialog(null, "Não foi possivel realizar conexão");

            }
            return conn;

        } catch (ClassNotFoundException e) {  //Driver não encontrado

            JOptionPane.showMessageDialog(null, "O driver expecificado nao foi encontrado. " + e);
            return null;

        } catch (SQLException e) {

//Não conseguindo se conectar ao banco

            JOptionPane.showMessageDialog(null, "Nao foi possivel conectar ao Banco de Dados. " + e);

            return null;

        }
    }

    /*
     * Este método iniciára uma transação com BD
     * 
     */
    public void beginTransection() throws SQLException {
        Connection conn = getConexaoMySQL();
        conn.setAutoCommit(false);
        context.set(conn);
        System.out.println("qweqe");

    }

    public void endTransection() throws SQLException {
        commit(getConnectionFromContext());
        releaseTransection();
    }

    public void commit(Connection conn) throws SQLException {
        conn.commit();
    }

    public void rollback(Connection conn) throws SQLException {
        if (conn != null) {
            conn.rollback();
        }
    }

    public void releaseTransection() throws SQLException {
        Connection conn = getConnectionFromContext();
        release(conn);
        context.remove();

    }

    public void rollbackTransection() throws SQLException {

        Connection conn = getConnectionFromContext();

        rollback(conn);
        release(conn);
        context.remove();
    }

    public Connection getConnectionFromContext() throws SQLException {

        Connection conn = context.get();
        if (conn == null) {
            throw new SQLException("Transação inválida");

        } else if (conn.isClosed()) {
            throw new SQLException("Transação fechada");
        }
        return conn;

    }

    public void release(Statement stmt) {
        if (stmt == null) {
            System.out.println("Statemant Nulo");
        } else {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }
    }

    public void release(Connection conn) {
        if (conn == null) {
            System.out.println("Conexão nula");
        } else {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public void release(ResultSet rSet) {
        if (rSet == null) {
            System.out.println("ResultSet nulo");
        } else {
            try {
                rSet.close();
            } catch (SQLException e) {
            }
        }
    }

    public void releaseAll(Connection conn, Statement stmt) {
        release(conn);
        release(stmt);
    }

    public void releaseAll(Connection conn, Statement stmt, ResultSet rSet) {
        releaseAll(conn, stmt);
        release(rSet);
    }

    public PreparedStatement prepareStatement(String strSql) throws Exception {
        try {
            return getConexaoMySQL().prepareStatement(strSql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.sql.Timestamp converteDataBD(String data, int i) throws ParseException {

        int dia, mes, ano;
        dia = Integer.parseInt(data.substring(0, 2));
        mes = Integer.parseInt(data.substring(3, 5));
        ano = Integer.parseInt(data.substring(6));

        Timestamp dataBD;
        mes = mes - 1;
        if (i == 0) {
            dataBD = new java.sql.Timestamp(ano - 1900, mes, dia, 00, 00, 00, 0);
        } else {
            dataBD = new java.sql.Timestamp(ano - 1900, mes, dia, 23, 59, 59, 0);
        }


        return dataBD;
    }

    public static void main(String args[]) throws CreateDAOException, Exception {

        Conexao c = new Conexao();

        String text = "12-10-2012";
        System.out.println(converteDataBD(text, 0));
             
        

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS"); 
java.util.Date date = sdf.parse("1212/12/12"); 
java.sql.Timestamp timest = new java.sql.Timestamp(date.getTime()); 
        System.out.println(timest);

       




    }
}
