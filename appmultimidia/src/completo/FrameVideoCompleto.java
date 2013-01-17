package completo;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Classe principal contendo a interface swing para acesso a camera
 * @author silvio
 *
 */
public class FrameVideoCompleto extends JFrame{

	private static final long serialVersionUID = 2769157269484182163L;
	
	private GerenteJMF gerente;
	
	private Component pnlVideo;
	
	private JButton btnAcionarFoto;
	
	/**
	 * Construtor
	 */
	public FrameVideoCompleto() {

		try {
			this.inicializarJMF();//inicializa o jmf
			this.getContentPane().add(getBotaoFoto());//adiciona no container principal o botao
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setLayout(null);//altera o layout para null
		this.setSize(350, 330);//ajusta o tamanho da janela
		this.setLocationRelativeTo(null);//centralizar o jframe na tela
		this.setVisible(true);//torna o jframe visivel
		
	}
	
	/**
	 * Retorna o bot�o de salvar a foto 
	 * @return
	 */
	private JButton getBotaoFoto(){
		
		if (btnAcionarFoto == null){
			
			btnAcionarFoto = new JButton("Capturar");
			btnAcionarFoto.setBounds(120, 260, 90, 25);
			
			/*
			 * Associa o evento do bot�o salvar o ato de salvar a foto na maquina 
			 */
			btnAcionarFoto.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					try {
						gerente.salvarFoto();	
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}
		
		return btnAcionarFoto;
	}
	
	/**
	 * Inicializa o gerente do JMF e adiciona o painel com o video da camera na tela
	 * @throws Exception
	 */
	private void inicializarJMF() throws Exception{
	
		gerente = new GerenteJMF();
		pnlVideo = gerente.getPainelVideo();
		pnlVideo.setBounds(10,10, 320,240);
		this.getContentPane().add(pnlVideo);
		
	}

	public static void main(String[] args) {
		new FrameVideoCompleto();
	}
	
}
