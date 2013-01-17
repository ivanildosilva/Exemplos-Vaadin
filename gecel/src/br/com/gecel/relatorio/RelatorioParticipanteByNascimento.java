package br.com.gecel.relatorio;

import br.com.gecel.control.Conexao;
import br.com.gecel.view.Relatorio;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Familia-Silva
 */
public class RelatorioParticipanteByNascimento {

    Conexao connect;
    Relatorio relatorio;

    /**
     * Creates a new instance of Rel_Cliente
     */
    public RelatorioParticipanteByNascimento() {

        connect = new Conexao();

        Connection conn = null;

        try {
//busca a conexão com a classe ConexaoMySQL 
            connect.beginTransection();
            conn = connect.getConnectionFromContext();


            HashMap parametro = new HashMap();
            parametro.put("mes", Relatorio.mes);
            System.out.println("mes "+          Relatorio.mes);
            JasperPrint jp = JasperFillManager.fillReport("c:/ProjetoNetbeans/gecel/relatorios/"
                    + "gecelNascimento.jasper", parametro, conn);
            JasperViewer jrv = new JasperViewer(jp, false);
            jrv.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String arg[]) {
        new RelatorioParticipanteByNascimento();
    }
}
