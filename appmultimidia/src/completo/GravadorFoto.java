package completo;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.media.Buffer;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;

public class GravadorFoto {
    
	private FrameGrabbingControl fg;
	
	public GravadorFoto(FrameGrabbingControl _fg){
		this.fg = _fg;
	}
	
    
 	public synchronized void salvarFoto() throws Exception{ 
 		
 		Buffer buf = fg.grabFrame(); // puxa o frame atual da camera 
 		
	    VideoFormat vf = (VideoFormat) buf.getFormat(); //converte o formato para o formato de video 
	    
	    BufferedImage im = (BufferedImage) new BufferToImage(vf).createImage(buf); // Cria uma BufferedImage a partir do buffer e especificando o formato

	    int larguraRetangulo = 360;
		int alturaRetangulo  = 240;
		
		int posicaoX = 100;
		int posicaoY = 20;
	    
		String nomeArquivo = getNomeArquivo();
		
 		salvarParteDaFoto(im, nomeArquivo, posicaoX, posicaoY, larguraRetangulo, alturaRetangulo);
 	
 		System.out.println(".actionPerformed() FOTO SALVA COM SUCESSO "+nomeArquivo);
 		
	} 
 	
 	private String getNomeArquivo(){
		SimpleDateFormat formatoData = new SimpleDateFormat("yyyy_M_d_H_m_s");
 	    return formatoData.format(new Date())+".jpg";
 	}
	
 	
 	private void salvarParteDaFoto(BufferedImage imagemOriginal, String nomeArquivo, int x, int y , int largura, int altura ) throws Exception{

 		BufferedImage imagemCortada = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
 		
 		Graphics g = imagemCortada.createGraphics();
 		
 		g.drawImage(imagemOriginal, 0, 0, largura, altura, x, y, x+largura, y+altura, null);
 		
 		g.dispose();

 		ImageIO.write(imagemCortada, "jpg", new File(nomeArquivo));

 	}
 	
}

