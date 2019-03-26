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
    Lexer analisador;

    public Parser(String entrada) {
        this.entrada = entrada;
    }

    void Expressao(){
        Lexer.LexAnalyzer(entrada);
        ArrayList<Token> listaDeToken = Lexer.getListaDeToken();
    }
    
}
