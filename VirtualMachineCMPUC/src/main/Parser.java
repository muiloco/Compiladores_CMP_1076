/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando.Sousa
 */
public class Parser {

    String entrada;
    ArrayList<Token> listaDeToken;
    Stack pilha;
    int pos;
    Token token;

    public Parser(String entrada) {
        this.entrada = entrada;
        try {
            Lexer.LexAnalyzer(entrada);
        } catch (Exception ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.listaDeToken = Lexer.getListaDeToken();
        this.pilha = new Stack();
        this.pos = 0;
        this.token = this.listaDeToken.get(this.pos);
    }

    void nextToken() {
        this.pos++;
        this.token = this.listaDeToken.get(this.pos);
    }

    void Processamento() throws Exception {
        while (this.pos < this.listaDeToken.size()) {
            switch (this.token.getToken()) {
                case "ADD":
                    nextToken();
                    if (this.token.getToken().equals("REGISTER")){
                        int destino = Integer.valueOf(Lexer.variaveis.get(this.token.getValor()));
                        nextToken();
                        if(this.token.getToken().equals("REGISTER")){
                            int op1 = 
                        }
                    }
                    break;
                case "SUB":
                    break;
                case "MUL":
                    break;
                case "DIV":
                    break;
                case "MOD":
                    break;
                case "POT":
                    break;
                case "AND":
                    break;
                case "OR":
                    break;
                case "NOT":
                    break;
                case "LOAD":
                    break;
                case "STORE":
                    break;
                case "PUSH":
                    break;
                case "POP":
                    break;
                case "JUMP":
                    break;
                case "BEQ":
                    break;
                case "BNE":
                    break;
                case "BLT":
                    break;
                case "BLE":
                    break;
                case "BGT":
                    break;
                case "BGE":
                    break;
                case "READ":
                    break;
                case "WRITE":
                    break;
                default:
                    throw new Exception("Deu Pau na Maquina, comando não identificado");
            }
        }
    }

}
