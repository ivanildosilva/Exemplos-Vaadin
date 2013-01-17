package br.com.gecel.jmf;

import java.awt.Component;
import java.util.Vector;

import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Player;
import javax.media.Processor;
import javax.media.control.FrameGrabbingControl;

/**
 * Encapsula o acesso �s funcionalidades de video. Essa classe atua como um
 * Facade para o framework JMF
 *
 * @author silvio
 *
 */
public class GerenteJMF {

  private Processor playerVideo = null;
  private FrameGrabbingControl fg = null;
  private GravadorFoto gravadorFoto = null;

  /**
   * Salva uma foto em um determinado lugar
   *
   * @param nomeFoto
   * @throws Exception
   */
  public void salvarFoto() throws Exception {

    if (gravadorFoto == null) {

      this.fg = (FrameGrabbingControl) getPlayerVideo().getControl("javax.media.control.FrameGrabbingControl");

      gravadorFoto = new GravadorFoto(fg);

    }

    gravadorFoto.salvarFoto();

  }

  /**
   * Retorna o processor com o video
   *
   * @return
   * @throws Exception
   */
  private Player getPlayerVideo() throws Exception {

    if (playerVideo == null) {

      CaptureDeviceInfo device = detectarDispositivoVideo();

      /*
       * tem que ver se vamos superar o bug do jmf
       */
      this.playerVideo = new ConfiguraProcessor(device.getLocator()).getProcessor();

    }

    return playerVideo;

  }

  /**
   * Retorna o componente visual do video
   *
   * @return
   * @throws Exception
   */
  public Component getPainelVideo() throws Exception {

    return this.getPlayerVideo().getVisualComponent();

  }

  /**
   * Detecta automaticamente as cameras presentes no pc
   *
   * @return
   */
  private CaptureDeviceInfo detectarDispositivoVideo() {

    //nesse metodo o jmf retorna todos os dispositivos de captura presentes na maquina
    Vector list = CaptureDeviceManager.getDeviceList(null);

    for (Object dispositivo : list) { //iteramos todos os dispositivos

      CaptureDeviceInfo device = (CaptureDeviceInfo) dispositivo;

      String nome = device.getName();

      //caso seja um dispositivo de video retornamos o primeiro encontrado
      if (nome.startsWith("v")) /*
       * Verificamos se a informacao do dispositivo inicia-se com v, essa
       * verifica��o permite que funcione tanto no linux quanto no windows No
       * linux os dispositivos recebem o nome : "v4l://0" enquanto no windows :
       * "vfw://0"
       */ {
        return device;
      }
    }

    return null;

  }

  public Player removePlayerVideo() throws Exception {

    if (playerVideo != null) {


      this.playerVideo.close();

    }

    return playerVideo;

  }
}
