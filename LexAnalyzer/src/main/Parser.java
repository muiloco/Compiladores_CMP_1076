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
    
    void SinAnalyzer(){
        listaInstrucoes();
        if(this.pos+1 == listaDeToken.size())
            System.out.println("main.Parser.SinAnalyzer()");
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
    /*expressao --> termo resto1*/
    void expressao(){
        termo();
        resto1();
    }
    /*resto1 -> + termo resto1 | - termo resto1 | E*/
    void resto1(){
        if(token.getValor().equals("+") || token.getValor().equals("-")){
            nextToken();
            termo();
            resto1();
        } else {
            
        }
    }
    /*termo -> fator resto2*/
    void termo(){
        fator();
        resto2();
    }
    /*resto2 -> * fator resto2 | / fator resto2 | % fator resto2 | E */
    void resto2(){
        if(token.getValor().equals("*") || token.getValor().equals("/") || token.getValor().equals("%")){
            nextToken();
            fator();
            resto2();
        } else {
            
        }
    }
    /*fator -> base resto3*/
    void fator(){
        base();
        resto3();
    }
    /*base -> NUM | ID | ( expressa )*/
    void base(){
        if(token.getToken().equals("ID") || token.getToken().equals("NUM")){
            nextToken();
        } else if(token.getValor().equals("(")){
            nextToken();
            expressao();
            if(token.getValor().equals(")"))
                nextToken();
            else
                System.out.println("erro");
        } else {
            System.out.println("erro");
        }
    }
    /*resto3 -> ^ expressao | E*/
    void resto3(){
        if(token.getValor().equals("^")){
            nextToken();
            expressao();
        } else {
            
        }
    }
}
