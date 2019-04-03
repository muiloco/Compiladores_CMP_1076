/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author Fernando.Sousa
 */
public class Parser {

    String entrada;
    ArrayList<Token> listaDeToken;
    int pos;

    public Parser(String entrada) {
        this.entrada = entrada;
        Lexer.LexAnalyzer(entrada);
        this.listaDeToken = Lexer.getListaDeToken();
        this.pos = -1;
    }

    Token nextToken() {
        this.pos++;
        return this.listaDeToken.get(this.pos);
    }

    //----------------------PRODUÇÕES---------------------
    /*Lista.instruções -> instrução; Lista.instruções | E
     */
    void listaInstrucoes() {
        Token token = nextToken();
        if (token.getToken().equals("ID")) {
            instrucao();

        } else {

        }
    }

    void instrucao() {

    }

}
