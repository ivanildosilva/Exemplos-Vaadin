package completo;


import javax.media.Codec;
import javax.media.ConfigureCompleteEvent;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.PrefetchCompleteEvent;
import javax.media.Processor;
import javax.media.control.TrackControl;
import javax.media.format.VideoFormat;
import javax.media.protocol.ContentDescriptor;

/**
 * Classe responsavel por configurar o processor da camera
 * @author silvio
 *
 */
public class ConfiguraProcessor implements ControllerListener{

	private Processor processor;
	
	private Object lock = new Object();

	/**
	 * Construtor
	 * @param ml
	 * @throws Exception
	 */
	public ConfiguraProcessor(MediaLocator ml) throws Exception{
		
		processor = Manager.createProcessor(ml);

		processor.addControllerListener(this);

		processor.configure();
		
	}
	
	/**
	 * Retorna o processor contendo o video da camera 
	 * @return
	 * @throws Exception
	 */
	public Processor getProcessor() throws Exception{
		
		synchronized(lock){
			lock.wait();
		}
		
		return processor;
	}



	/**
	 * Metodo que configura o codec no processor
	 */
	private void configurarCodec(){

		// Necessario para utilizar o Processor como um Player.
		processor.setContentDescriptor(null);


		for (int i = 0; i < processor.getTrackControls().length; i++) {

			if (processor.getTrackControls()[i].getFormat() instanceof VideoFormat) {

				try {

					// Instantiate and set the frame access codec to the data flow path.
					TrackControl videoTrack = processor.getTrackControls()[i];
					Codec codec[] = { new CodecVideo() };
					videoTrack.setCodecChain(codec);
					break;

				} catch (Exception e) {
					e.printStackTrace();
				}


			}
		}

		processor.prefetch();

	}
	
	/**
	 * Controller Listener.
	 */
	public void controllerUpdate(ControllerEvent evt) {
		
		System.out.println("FrameAccess.controllerUpdate() "+evt.getClass().getName());

		if (evt instanceof ConfigureCompleteEvent){
			
			this.configurarCodec();
			
		}else if ( evt instanceof PrefetchCompleteEvent){
			
			processor.start();// Inicia o processor.
			
			synchronized(lock){
				lock.notifyAll();
			}
			System.out.println("ConfiguraProcessor.controllerUpdate() PROCESSOR OK ! , iniciar a interface");			
			
//			System.out.println("ConfiguraProcessor.controllerUpdate()"+procesor.getContentDescriptor().getEncoding());
			
//			DataSource ds  = processor.getSupportedContentDescriptors();
//			
//			System.out.println("GerenteJMF.createDataSource() "+ds.getClass().getName());
//					System.out.println("GerenteJMF.createDataSource() "+ds.getContentType());
					
					ContentDescriptor[] c = processor.getSupportedContentDescriptors();
					for (int i = 0; i < c.length; i++) {
//						c.
						System.out.println("GerenteJMF.createDataSource() ciontro "+c[i].getClass().getName()+" ; "+c[i].getContentType());
					}
			
		}

	}
	
}
