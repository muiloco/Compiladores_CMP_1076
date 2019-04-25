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
                        String registrador = this.token.getValor();
                        nextToken();
                        if(this.token.getToken().equals("VIRG")){
                            nextToken();
                            operator2();
                            int valor2 = (int) this.pilha.pop();
                            int valor1 = (int) this.pilha.pop();
                            destino = valor1 + valor2;
                            Lexer.addHash(registrador, String.valueOf(destino));
                        }
                    }
                    else{
                        throw new Exception("Erro 1 -- Registrador não identificado");
                    }
                    break;
                case "SUB":
                    nextToken();
                    if (this.token.getToken().equals("REGISTER")){
                        int destino = Integer.valueOf(Lexer.variaveis.get(this.token.getValor()));
                        String registrador = this.token.getValor();
                        nextToken();
                        if(this.token.getToken().equals("VIRG")){
                            nextToken();
                            operator2();
                            int valor2 = (int) this.pilha.pop();
                            int valor1 = (int) this.pilha.pop();
                            destino = valor1 - valor2;
                            Lexer.addHash(registrador, String.valueOf(destino));
                        }
                    }
                    else{
                        throw new Exception("Erro 1 -- Registrador não identificado");
                    }
                    break;
                case "MUL":
                    nextToken();
                    if (this.token.getToken().equals("REGISTER")){
                        int destino = Integer.valueOf(Lexer.variaveis.get(this.token.getValor()));
                        String registrador = this.token.getValor();
                        nextToken();
                        if(this.token.getToken().equals("VIRG")){
                            nextToken();
                            operator2();
                            int valor2 = (int) this.pilha.pop();
                            int valor1 = (int) this.pilha.pop();
                            destino = valor1 * valor2;
                            Lexer.addHash(registrador, String.valueOf(destino));
                        }
                    }
                    else{
                        throw new Exception("Erro 1 -- Registrador não identificado");
                    }
                    break;
                case "DIV":
                    nextToken();
                    if (this.token.getToken().equals("REGISTER")){
                        int destino = Integer.valueOf(Lexer.variaveis.get(this.token.getValor()));
                        String registrador = this.token.getValor();
                        nextToken();
                        if(this.token.getToken().equals("VIRG")){
                            nextToken();
                            operator2();
                            int valor2 = (int) this.pilha.pop();
                            int valor1 = (int) this.pilha.pop();
                            destino = valor1 / valor2;
                            Lexer.addHash(registrador, String.valueOf(destino));
                        }
                    }
                    else{
                        throw new Exception("Erro 1 -- Registrador não identificado");
                    }
                    break;
                case "MOD":
                    nextToken();
                    if (this.token.getToken().equals("REGISTER")){
                        int destino = Integer.valueOf(Lexer.variaveis.get(this.token.getValor()));
                        String registrador = this.token.getValor();
                        nextToken();
                        if(this.token.getToken().equals("VIRG")){
                            nextToken();
                            operator2();
                            int valor2 = (int) this.pilha.pop();
                            int valor1 = (int) this.pilha.pop();
                            destino = valor1 % valor2;
                            Lexer.addHash(registrador, String.valueOf(destino));
                        }
                    }
                    else{
                        throw new Exception("Erro 1 -- Registrador não identificado");
                    }
                    break;
                case "POT":
                    nextToken();
                    if (this.token.getToken().equals("REGISTER")){
                        int destino = Integer.valueOf(Lexer.variaveis.get(this.token.getValor()));
                        String registrador = this.token.getValor();
                        nextToken();
                        if(this.token.getToken().equals("VIRG")){
                            nextToken();
                            operator2();
                            int valor2 = (int) this.pilha.pop();
                            int valor1 = (int) this.pilha.pop();
                            destino = (int) Math.pow(valor1, valor2);
                            Lexer.addHash(registrador, String.valueOf(destino));
                        }
                    }
                    else{
                        throw new Exception("Erro 1 -- Registrador não identificado");
                    }
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
    
    void operator2() throws Exception{
        if(this.token.getToken().equals("REGISTER")){
            int valor1 = Integer.valueOf(Lexer.variaveis.get(this.token.getValor()));
            this.pilha.push(valor1);
            nextToken();
            if(this.token.getToken().equals("VIRG")){
                nextToken();
                operator3();
            }
        } else {
            throw new Exception("Erro 2 -- Erro no segundo registrador");
        }
    }
    
    void operator3() throws Exception{
        switch (this.token.getToken()) {
            case "REGISTER":
                {
                    int valor2 = Integer.valueOf(Lexer.variaveis.get(this.token.getValor()));
                    this.pilha.push(valor2);
                    break;
                }
            case "NUM":
                {
                    int valor2 = Integer.valueOf(this.token.getValor());
                    this.pilha.push(valor2);
                    break;
                }
            default:
                throw new Exception("Erro 3 -- Erro no terceiro registrador do comando");
        }
    }

}
