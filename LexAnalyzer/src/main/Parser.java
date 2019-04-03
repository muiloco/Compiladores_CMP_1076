/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import jdk.nashorn.internal.ir.ContinueNode;

/**
 *
 * @author Fernando.Sousa
 */
public class Parser {

    String entrada;
    ArrayList<Token> listaDeToken;
    int pos;
    Token token;

    public Parser(String entrada) {
        this.entrada = entrada;
        Lexer.LexAnalyzer(entrada);
        this.listaDeToken = Lexer.getListaDeToken();
        this.pos = 0;
        this.token = this.listaDeToken.get(this.pos);
    }

    void nextToken() {
        this.pos++;
        this.token = this.listaDeToken.get(this.pos);
    }

    //----------------------PRODUÇÕES---------------------
    /*Lista.instruções -> instrução ; Lista.instruções | E
     */
    void listaInstrucoes() {
        instrucao();
        if (this.token.getToken().equals("DELIM")) {
            nextToken();
            listaInstrucoes();
        } else if(this.listaDeToken.size() != this.pos-1) {
            nextToken();
        } else {
            System.out.println("erro");
        }
    }
    /*
    instrução -> ID = expressão
              -> LEIA ID
              -> ESCREVA expressão
    */
    
    void instrucao() {
        switch (this.token.getToken()) {
            case "ID":
                nextToken();
                if(this.token.getToken().equals("DELIM")){
                    nextToken();
                    expressao();
                }   break;
            case "LEIA":
                nextToken();
                if(token.getToken().equals("ID"))
                    nextToken();
                break;
            case "ESCREVA":
                nextToken();
                expressao();
                break;
            default:
                System.out.println("erro");
                break;
        }
    }
    
    void expressao(){
        
    }

}
