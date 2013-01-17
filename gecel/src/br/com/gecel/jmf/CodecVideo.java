package br.com.gecel.jmf;


import java.awt.Color;

import javax.media.Buffer;
import javax.media.Codec;
import javax.media.Format;
import javax.media.format.VideoFormat;

/**
 * Codec para desenhar um retangulo no video da camera
 * @author silvio
 *
 */
public class CodecVideo implements Codec {

	private Format [] formatosSuportados = { new VideoFormat(null) } ;
	
	private Format input = null, output = null;

	public String getName() {
		return "Java Magazine Codec";
	}

	public void open() {}

	public void close() {}

	public void reset() {}

	public Format [] getSupportedInputFormats() {
		return formatosSuportados ; // notificando que suporta qualquer formato de vidoe
	}

	public Format [] getSupportedOutputFormats(Format in) {
		if (in == null)
			return formatosSuportados;
		else {
			// If an input format is given, we use that input format
			// as the output since we are not modifying the bit stream
			// at all.
			Format outs[] = new Format[1];
			outs[0] = in;
			return outs;
		}
	}

	public Format setInputFormat(Format format) {
		input = format;
		return input;
	}

	public Format setOutputFormat(Format format) {
		output = format;
		return output;
	}

	/**
	 * Desenha o retangulo no buffer de video
	 * @param frame
	 */
	private void desenharRetangulo(Buffer frame) {

		byte[] data = (byte[]) frame.getData();

		int larguraRetangulo = 120;
		int alturaRetangulo  = 160;
		int posicaoX = 100;
		int posicaoY = 60;
		
		this.desenharLinhaHorizontal(posicaoX, posicaoY, data, larguraRetangulo); // linha horizontal de cima
		
		this.desenharLinhaHorizontal(posicaoX, posicaoY+alturaRetangulo, data, larguraRetangulo); //linha horizontal de baixo
		
		this.desenharLinhaVertical(posicaoX, posicaoY, data, alturaRetangulo);//linha vertical da esquerda

		this.desenharLinhaVertical(posicaoX+larguraRetangulo, posicaoY, data, alturaRetangulo);//linha vertical da direita
		
	}

	/**
	 * Pinta o pixel de uma determinada cor
	 * @param pixel
	 * @param data
	 * @param red
	 * @param green
	 * @param azul
	 */
	private void pintarPixel(int pixel, byte[]data, Color cor){
		data[pixel]   = (byte) cor.getBlue();//blue
		data[pixel+1] = (byte) cor.getGreen();//green
		data[pixel+2] = (byte) cor.getRed();//red
	}
	
	
	/**
	 * Desenha uma linha vertical em uma imagem
	 * @param x
	 * @param y
	 * @param data
	 * @param altura
	 * @param espessuraBorda
	 */
	private void desenharLinhaVertical(int x, int y, byte[] data, int altura){

		for (int i = 0; i < altura; i++) {
			
			int posicaoPixel = getPosicaoPixel(x, y+i);

			this.pintarPixel(posicaoPixel, data, Color.RED);
		}

	}
	
	/**
	 * Desenha uma linha horizontal em uma imagem
	 * @param x
	 * @param y
	 * @param data
	 * @param largura
	 * @param espessuraBorda
	 */
	private void desenharLinhaHorizontal(int x, int y, byte[] data, int largura){
		
		for (int i = 0; i < largura; i++) {
			
			int posicaoPixel = getPosicaoPixel(x+i, y);
			
			this.pintarPixel(posicaoPixel, data, Color.RED);
			
		}
		
	}

	/**
	 * Retorna a posicao num pixel considerando um video de 320 x 240
	 * @param x
	 * @param y
	 * @return
	 */
	private int getPosicaoPixel( int x , int y ){

		// 320 = largura em pixels do video
		// 3 = RGB (cada pixel = 3 bytes)
		int posicaoY = 320 * 3 * y; 

		// cada pixel contem 3 bytes
		int posicaoX = x * 3 ;
		
		return posicaoY + posicaoX;
		
	}
	
	/**
	 * Metodo invocado a todo momento que um novo frame de video esta disponivel
	 */
	public int process(Buffer in, Buffer out) {

		desenharRetangulo(in);

		// Realiza a troca entre o buffer de entrada e o de saida.
		Object data = in.getData();
		in.setData(out.getData());
		out.setData(data);


		// Copia os atributos de entrada para a saida
		out.setFormat(in.getFormat());
		out.setLength(in.getLength());
		out.setOffset(in.getOffset());

		return BUFFER_PROCESSED_OK;
	}

	public Object[] getControls() {
		return new Object[0];
	}

	public Object getControl(String type) {
		return null;
	}
}
