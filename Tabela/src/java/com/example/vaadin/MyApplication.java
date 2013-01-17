/*
 * MyApplication.java
 *
 * Created on 23 de Julho de 2012, 10:49
 */
package com.example.vaadin;

import com.example.vaadin.view.Tabela;
import com.example.vaadin.view.Tabela1;
import com.example.vaadin.view.TabelaTeste;
import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Runo;

/**
 *
 * @author ivanildofilho
 * @version
 */
public class MyApplication extends Application {

  @Override
  public void init() {
    setTheme("css");
    //setTheme("runo");
    TabelaTeste tabela = new TabelaTeste();
    Window mainWindow = new Window("MyApplication");
    mainWindow.addComponent(tabela);
    setMainWindow(mainWindow);
  }
}
