/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

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
        Lexer.LexAnalyzer(entrada);
        this.listaDeToken = Lexer.getListaDeToken();
        this.pilha = new Stack();
        this.pos = 0;
        this.token = this.listaDeToken.get(this.pos);
    }

    void nextToken() {
        this.pos++;
        this.token = this.listaDeToken.get(this.pos);
    }

    void SinAnalyzer() throws Exception {
        listaInstrucoes();
    }

    //----------------------PRODUÇÕES---------------------
    /*Lista.instruções -> instrução ; Lista.instruções | E
     */
    void listaInstrucoes() throws Exception {
        instrucao();
        if (this.token.getValor().equals(";")) {
            if (this.listaDeToken.size() != this.pos + 1) {
                nextToken();
                listaInstrucoes();
            } else {
                System.out.println("Cod. Valido!!!");
                System.out.println("N. de Tokens analisados:" + this.pos);
            }
        } else {
            throw new Exception("Teu codigo ta errado!!!");
        }
    }

    /*
    instrução -> ID = expressão
              -> LEIA ID
              -> ESCREVA expressão
     */
    void instrucao() throws Exception {
        switch (this.token.getToken()) {
            case "ID":
                nextToken();
                if (this.token.getValor().equals("=")) {
                    nextToken();
                    expressao();
                    Lexer.addHash(this.token.Valor, pilha.pop().toString());
                }
                break;
            case "LEIA":
                nextToken();
                if (token.getToken().equals("ID")) {
                    InputStream is = System.in;
                    System.out.println("Digite o Valor da Variavel:");
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    float valor = Float.valueOf(br.readLine());
                    Lexer.addHash(this.token.getValor(), String.valueOf(valor));
                    nextToken();
                }
                break;
            case "ESCREVA":
                nextToken();
                expressao();
                System.out.println("consola >> " + Lexer.variaveis.get(token.getValor()));
                break;
            default:
                throw new Exception("Teu codigo esta errado - instrução");
        }
    }

    /*expressao --> termo resto1*/
    void expressao() throws Exception {
        termo();
        resto1();
    }

    /*resto1 -> + termo resto1 | - termo resto1 | E*/
    void resto1() throws Exception {
        if (token.getValor().equals("+") || token.getValor().equals("-")) {
            String Token = this.token.getToken();
            nextToken();
            termo();
            resto1();
            
            float x1 = Float.valueOf(this.pilha.pop().toString());
            float x2 = Float.valueOf(this.pilha.pop().toString());
            if(Token.equals("SOMA")){
                float result = x1 + x2;
                this.pilha.push(result);
            } else {
                float result = x1 - x2;
                this.pilha.push(result);
            }
        } else {

        }
    }

    /*termo -> fator resto2*/
    void termo() throws Exception {
        fator();
        resto2();
    }

    /*resto2 -> * fator resto2 | / fator resto2 | % fator resto2 | E */
    void resto2() throws Exception {
        if (token.getValor().equals("*") || token.getValor().equals("/") || token.getValor().equals("%")) {
            String Token = this.token.getToken();
            nextToken();
            fator();
            resto2();
            float x2 = Float.valueOf(this.pilha.pop().toString());
            float x1 = Float.valueOf(this.pilha.pop().toString());
            switch (Token) {
                case "MULT":
                    {
                        float result = x1 * x2;
                        this.pilha.push(result);
                        break;
                    }
                case "DIVI":
                    {
                        float result = x1 / x2;
                        this.pilha.push(result);
                        break;
                    }
                case "REST":
                    {
                        float result = x1 % x2;
                        this.pilha.push(result);
                        break;
                    }
                default:
                    throw new Exception("Deu Pau!!");
            }
        } else {

        }
    }

    /*fator -> base resto3*/
    void fator() throws Exception {
        base();
        resto3();
    }

    /*base -> NUM | ID | ( expressa )*/
    void base() throws Exception {
        if (token.getToken().equals("ID") || token.getToken().equals("NUM")) {
            if (token.getToken().equals("ID")){
                float valor = Float.valueOf(Lexer.variaveis.get(token.getValor()));
                pilha.push(valor);
            } else {
                pilha.push(Float.valueOf(token.getValor()));
            }
            nextToken();
        } else if (token.getValor().equals("(")) {
            nextToken();
            expressao();
            if (token.getValor().equals(")")) {
                nextToken();
            } else {
                throw new Exception("Erro no cod -- base");
            }
        } else {
            throw new Exception("Erro no cod -- base");
        }
    }

    /*resto3 -> ^ expressao | E*/
    void resto3() throws Exception {
        if (token.getValor().equals("^")) {
            nextToken();
            expressao();
            float x2 = Float.valueOf(this.pilha.pop().toString());
            float x1 = Float.valueOf(this.pilha.pop().toString());
            float result = (float) Math.pow(x1, x2);
            this.pilha.push(result);
        } else {

        }
    }
}
