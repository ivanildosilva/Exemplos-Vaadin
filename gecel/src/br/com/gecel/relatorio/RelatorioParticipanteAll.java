package br.com.gecel.relatorio;

import br.com.gecel.control.Conexao;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Familia-Silva
 */
public class RelatorioParticipanteAll {

    Conexao connect;

    /**
     * Creates a new instance of Rel_Cliente
     */
    public RelatorioParticipanteAll() {

        connect = new Conexao();

        Connection conn = null;

        try {
//busca a conexão com a classe ConexaoMySQL 
            connect.beginTransection();
            conn = connect.getConnectionFromContext();


            HashMap parametro = new HashMap();
            //  parametro.put("num_amostra", numAmostraField);
            JasperPrint jp = JasperFillManager.fillReport("c:/ProjetoNetbeans/gecel/relatorios/"
                    + "gecelTodos.jasper", new HashMap(), conn);
            JasperViewer jrv = new JasperViewer(jp, false);
            jrv.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String arg[]) {
        new RelatorioParticipanteAll();
    }
}
