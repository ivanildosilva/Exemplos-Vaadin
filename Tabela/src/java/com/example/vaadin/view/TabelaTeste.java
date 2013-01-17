/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.vaadin.view;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;
import java.util.Iterator;
/**
 *
 * @author ivanildofilho
 */
public class TabelaTeste extends VerticalLayout {

  private Table tabela;
  private TextField nome;
  private TextField idade;
  private Button inserir, remove;
  private Label soma, item;
  private ComboBox combo;
  private int contador = 1;
  private CheckBox check;

  public TabelaTeste() {
    init();
  }

  public void init() {

    final Panel painelTabela = new Panel();
    painelTabela.setWidth("50%");
    tabela = new Table();
    tabela.setWidth("100%");
    tabela.addStyleName(Runo.TABLE_BORDERLESS);
    tabela.addStyleName(Runo.TABLE_SMALL);
    tabela.setHeight(200F);

    nome = new TextField("nome");
    nome.setWidth("100%");

    idade = new TextField("idade");
    idade.setWidth("100%");
    soma = new Label("0.00");
    item = new Label("0");

    combo = new ComboBox("Teste");
    check = new CheckBox("Teste");

    inserir = new Button("Inserir");
    remove = new Button("Remover");

    HorizontalLayout grupoDados = new HorizontalLayout();
    grupoDados.setWidth("100%");
    grupoDados.addComponent(nome);
    grupoDados.setExpandRatio(nome, 40F);
    grupoDados.addComponent(idade);
    grupoDados.setExpandRatio(idade, 10F);
    grupoDados.addComponent(inserir);
    grupoDados.setComponentAlignment(inserir, Alignment.BOTTOM_LEFT);
    grupoDados.setMargin(false, false, true, false);
    grupoDados.setSpacing(true);

    tabela.addContainerProperty("Item", Integer.class, null);
    tabela.setColumnExpandRatio("Item", 3F);
    tabela.addContainerProperty("Nome", CheckBox.class, null);
    tabela.setColumnExpandRatio("Nome", 20F);
    tabela.addContainerProperty("Idade", Double.class, null);
    tabela.setColumnExpandRatio("Idade", 5F);

    inserir.addListener(new Button.ClickListener() {

      @Override
      public void buttonClick(ClickEvent event) {

//        if (nome.getValue().equals("")) {
//          getWindow().showNotification("Digite o nome");
//          nome.focus();
//        } else if (idade.getValue().equals("")) {
//          getWindow().showNotification("Digite idade");
//          idade.focus();
//        } else {
        try {

          tabela.addItem(new Object[]{contador++,
                    new CheckBox("Teste"),
                    Double.parseDouble(idade.getValue().toString())}, null);

          nome.setValue("");
          idade.setValue("");
          nome.focus();
          soma.setValue(somar());

          tabela.setSortDisabled(true);
          tabela.setFooterVisible(true);
          tabela.setSelectable(true);
          tabela.setColumnFooter("Nome", "Total");
          tabela.setColumnFooter("Idade", String.valueOf(somar()));
          tabela.setPageLength(tabela.size());

        } catch (NumberFormatException e) {

          getWindow().showNotification("Caracter inválido");
          idade.setValue("");
          idade.focus();
        }
      }
      // }
    });
    remove.addListener(new Button.ClickListener() {

      @Override
      public void buttonClick(ClickEvent event) {

        try {

          if (check.getValue().equals(true)) {
            getWindow().showNotification("Checado" + check.getCaption());
          } else {

            soma.setValue(subtrair());
            tabela.setColumnFooter("Idade", String.valueOf(subtrair()));
            tabela.removeItem(Integer.parseInt(tabela.getValue().toString()));
          }
        } catch (NullPointerException e) {
          getWindow().showNotification("Selecione uma linha.");

        }
      }
    });

    painelTabela.addComponent(grupoDados);
    painelTabela.addComponent(tabela);
    addComponent(painelTabela);
    addComponent(soma);
    addComponent(item);
    addComponent(remove);
    setSpacing(true);

  }

  public double somar() {

    double sum = 0;
    for (Iterator<?> i = tabela.getItemIds().iterator(); i.hasNext();) {
      sum += (Double) tabela.getItem(i.next()).getItemProperty("Idade").getValue();
      System.out.println("Soma = " + sum);
    }
    System.out.println("valor da celular " + tabela.getItem(tabela.getItemIds()));
    System.out.println("método somar = " + sum);
    return sum;

  }

  public double subtrair() {

    double subt = 0;
    subt = somar();
    subt -= Double.parseDouble(String.valueOf(tabela.getItem(tabela.getValue()).getItemProperty("Idade").getValue()));
    return subt;

  }

  private IndexedContainer getIndexedContainerSiglasEstados() {
    String[] siglas = new String[]{"AC", "AL", "AM", "AP", "BA", "CE",
      "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
      "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
    IndexedContainer container = new IndexedContainer();
    container.addContainerProperty("item", String.class, null);

    for (String valor : siglas) {
      Item item = container.addItem(valor);
      item.getItemProperty("item").setValue(valor);
    }

    return container;
  }
}
