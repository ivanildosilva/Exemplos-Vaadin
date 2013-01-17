/*
 * Menu.java
 *
 * Created on 11 de Outubro de 2011, 14:32
 */
package br.com.gecel.view;

import br.com.gecel.util.data;
import br.com.gecel.control.Conexao;
import br.com.gecel.jmf.GerenteJMF;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Familia-Silva
 */
public class Principal extends javax.swing.JFrame {

    private static final long serialVersionUID = 2769157269484182163L;
    private GerenteJMF gerente;
    private Component pnlVideo;
    private JButton btnAcionarFoto;
    private Conexao connect;
    data mostra_data;
    private String seta_look;

    /**
     * Creates new form Menu
     */
    public Principal() throws SQLException {
        initComponents();
        connect = new Conexao();
         mostra_data = new data();
        mostra_data.le_data();
        mostra_data.le_hora();
        this.setTitle("Principal                              " + mostra_data.dia_semana + ", " + mostra_data.dia + " de " + mostra_data.mes + " de " + mostra_data.ano + "             " + mostra_data.hora);
        timer1.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        Credor = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        Sair = new javax.swing.JMenuItem();
        Consulta = new javax.swing.JMenu();
        CCompromisso = new javax.swing.JMenuItem();
        Consulta1 = new javax.swing.JMenu();
        CCompromisso1 = new javax.swing.JMenuItem();
        Consulta2 = new javax.swing.JMenu();
        CCompromisso2 = new javax.swing.JMenuItem();
        Utilitarios = new javax.swing.JMenu();
        Padrao = new javax.swing.JMenuItem();
        Windows = new javax.swing.JMenuItem();
        Mofit = new javax.swing.JMenuItem();
        Liquid = new javax.swing.JMenuItem();

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Freestyle Script", 3, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gecel/imagem/logomenu.jpg"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 640, 420);

        Cadastros.setMnemonic('c');
        Cadastros.setText("Cadastros");
        Cadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrosActionPerformed(evt);
            }
        });

        Credor.setMnemonic('p');
        Credor.setText("Participantes");
        Credor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CredorActionPerformed(evt);
            }
        });
        Cadastros.add(Credor);
        Cadastros.add(jSeparator1);

        Sair.setMnemonic('s');
        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        Cadastros.add(Sair);

        jMenuBar1.add(Cadastros);

        Consulta.setMnemonic('o');
        Consulta.setText("Consulta");
        Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaActionPerformed(evt);
            }
        });

        CCompromisso.setMnemonic('p');
        CCompromisso.setText("Participantes");
        CCompromisso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCompromissoActionPerformed(evt);
            }
        });
        Consulta.add(CCompromisso);

        jMenuBar1.add(Consulta);

        Consulta1.setMnemonic('u');
        Consulta1.setText("Usuário");
        Consulta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consulta1ActionPerformed(evt);
            }
        });

        CCompromisso1.setMnemonic('i');
        CCompromisso1.setText("Incluir");
        CCompromisso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCompromisso1ActionPerformed(evt);
            }
        });
        Consulta1.add(CCompromisso1);

        jMenuBar1.add(Consulta1);

        Consulta2.setMnemonic('r');
        Consulta2.setText("Relatórios");
        Consulta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consulta2ActionPerformed(evt);
            }
        });

        CCompromisso2.setMnemonic('p');
        CCompromisso2.setText("Participante");
        CCompromisso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCompromisso2ActionPerformed(evt);
            }
        });
        Consulta2.add(CCompromisso2);

        jMenuBar1.add(Consulta2);

        Utilitarios.setMnemonic('t');
        Utilitarios.setText("Utilitários");
        Utilitarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UtilitariosActionPerformed(evt);
            }
        });

        Padrao.setMnemonic('p');
        Padrao.setText("Look and Feel - Padrão");
        Padrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PadraoActionPerformed(evt);
            }
        });
        Utilitarios.add(Padrao);

        Windows.setMnemonic('w');
        Windows.setText("Look and Feel - Windows");
        Windows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WindowsActionPerformed(evt);
            }
        });
        Utilitarios.add(Windows);

        Mofit.setMnemonic('m');
        Mofit.setText("Look and Feel - Mofit");
        Mofit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MofitActionPerformed(evt);
            }
        });
        Utilitarios.add(Mofit);

        Liquid.setMnemonic('m');
        Liquid.setText("Look and Feel - Liquid");
        Liquid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LiquidActionPerformed(evt);
            }
        });
        Utilitarios.add(Liquid);

        jMenuBar1.add(Utilitarios);

        setJMenuBar(jMenuBar1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-647)/2, (screenSize.height-470)/2, 647, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime
// TODO add your handling code here:
        mostra_data.le_hora();
        this.setTitle("Principal                              " + mostra_data.dia_semana + ", " + mostra_data.dia + " de " + mostra_data.mes + " de " + mostra_data.ano + "             " + mostra_data.hora);
    }//GEN-LAST:event_timer1OnTime
    public void lookandfeel() {

        try {
            UIManager.setLookAndFeel(seta_look);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }
    private void UtilitariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UtilitariosActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_UtilitariosActionPerformed

    private void LiquidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LiquidActionPerformed
// TODO add your handling code here:
        seta_look = "com.birosoft.liquid.LiquidLookAndFeel";
        lookandfeel();
    }//GEN-LAST:event_LiquidActionPerformed

    private void MofitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MofitActionPerformed
// TODO add your handling code here:
        seta_look = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        lookandfeel();
    }//GEN-LAST:event_MofitActionPerformed

    private void WindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WindowsActionPerformed
// TODO add your handling code here:
        seta_look = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        lookandfeel();
    }//GEN-LAST:event_WindowsActionPerformed

    private void PadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PadraoActionPerformed
// TODO add your handling code here:
        seta_look = "javax.swing.plaf.metal.MetalLookAndFeel";
        lookandfeel();
    }//GEN-LAST:event_PadraoActionPerformed

    private void ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_ConsultaActionPerformed

    private void CCompromissoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCompromissoActionPerformed
        try {
            new ConsultaAluno().show();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_CCompromissoActionPerformed

    private void CadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrosActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_CadastrosActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
// TODO add your handling code here:
        String nome = "Deseja realmente sair do sistema?";
        int opcao_escolha = JOptionPane.showConfirmDialog(null, nome, "Atenção", JOptionPane.YES_NO_OPTION);
        if (opcao_escolha == JOptionPane.YES_OPTION) {

            System.exit(0);

        } else {
        }
    }//GEN-LAST:event_SairActionPerformed

    private void CredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CredorActionPerformed
        try {
            try {
                
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            new CadastroAluno().show();
            try {
                //this.inicializarJMF();//inicializa o jmf
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CredorActionPerformed
    private void inicializarJMF() throws Exception {

        gerente = new GerenteJMF();
        pnlVideo = gerente.getPainelVideo();
        pnlVideo.setBounds(10, 10, 390, 270);
        //this.getContentPane().add(pnlVideo);
        CadastroAluno.jPanel2.add(pnlVideo);

    }
  private void CCompromisso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCompromisso1ActionPerformed
      // TODO add your handling code here:
      new CadastroUsuario().show();
  }//GEN-LAST:event_CCompromisso1ActionPerformed

  private void Consulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consulta1ActionPerformed
      // TODO add your handling code here:
  }//GEN-LAST:event_Consulta1ActionPerformed

    private void CCompromisso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCompromisso2ActionPerformed
        try {
            new Relatorio().show();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CCompromisso2ActionPerformed

    private void Consulta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consulta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Consulta2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CCompromisso;
    private javax.swing.JMenuItem CCompromisso1;
    private javax.swing.JMenuItem CCompromisso2;
    private javax.swing.JMenu Cadastros;
    private javax.swing.JMenu Consulta;
    private javax.swing.JMenu Consulta1;
    private javax.swing.JMenu Consulta2;
    private javax.swing.JMenuItem Credor;
    private javax.swing.JMenuItem Liquid;
    private javax.swing.JMenuItem Mofit;
    private javax.swing.JMenuItem Padrao;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenu Utilitarios;
    private javax.swing.JMenuItem Windows;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    // End of variables declaration//GEN-END:variables
}