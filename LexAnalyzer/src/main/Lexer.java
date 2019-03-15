/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Fernando.Sousa
 */
public class Lexer {
    ArrayList<Token> listaDeToken;
    HashMap<String, String> variaveis;

    public Lexer() {
        this.listaDeToken = new ArrayList<>();
        this.variaveis = new HashMap<>();
    }

    public ArrayList<Token> getListaDeToken() {
        return listaDeToken;
    }

    public HashMap<String, String> getVariaveis() {
        return variaveis;
    }
     
    public static void LexAnalyzer(String texto){
        
    }
}
