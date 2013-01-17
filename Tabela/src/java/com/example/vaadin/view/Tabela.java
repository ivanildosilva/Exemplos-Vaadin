/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.vaadin.view;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;

/**
 *
 * @author ivanildofilho
 */
public class Tabela extends VerticalLayout {

    private Table tabela;
    private TextField nome;
    private TextField idade;
    private Button inserir;

    public Tabela() {
        init();
    }

    public void init() {

        final Panel painelTabela = new Panel();
        painelTabela.setWidth("80%");
        tabela = new Table();
        tabela.setWidth("50%");
        tabela.addStyleName(Runo.TABLE_BORDERLESS);
        tabela.addStyleName(Runo.TABLE_SMALL);

        nome = new TextField("nome");
        nome.setWidth("100%");

        idade = new TextField("idade");
        idade.setWidth("100%");

        inserir = new Button("Inserir");


        HorizontalLayout grupoDados = new HorizontalLayout();
        grupoDados.setWidth("50%");
        grupoDados.addComponent(nome);
        grupoDados.setExpandRatio(nome, 40F);
        grupoDados.addComponent(idade);
        grupoDados.setExpandRatio(idade, 10F);
        grupoDados.addComponent(inserir);
        grupoDados.setComponentAlignment(inserir, Alignment.BOTTOM_LEFT);
        grupoDados.setMargin(false, false, true, false);
        grupoDados.setSpacing(true);

        tabela.addContainerProperty("Nome", String.class, null);
        tabela.setColumnExpandRatio("Nome", 20F);
        tabela.addContainerProperty("Idade Morte", Integer.class, null);
        tabela.setColumnExpandRatio("Idade Morte", 5F);


        //inserindo dados na tabela
        Object people[][] = {{"João", 77},
            {"Maria", 83},
            {"Vanessa", 79},
            {"Tião", 86}};
        for (int i = 0; i < people.length; i++) {
            tabela.addItem(people[i], new Integer(i));
            //calculando a media das colunas

            double media = 0;
            for (int j = 0; j < people.length; j++) {
                media += (Integer) people[j][1];
            }

            media /= people.length;

            System.out.println(media);


            tabela.setFooterVisible(true);
            tabela.setColumnFooter("Nome", "Média");
            tabela.setColumnFooter("Idade Morte", String.valueOf(media));
            tabela.setPageLength(tabela.size());

        }







        painelTabela.addComponent(grupoDados);
        painelTabela.addComponent(tabela);

        addComponent(painelTabela);
        setSpacing(true);

    }
}
