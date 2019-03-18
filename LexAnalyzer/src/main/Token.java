/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Fernando R
 */
public class Token {
    String Token;
    String Valor;

    public Token(String Token, String Valor) {
        this.Token = Token;
        this.Valor = Valor;
    }

    public String getToken() {
        return Token;
    }

    public String getValor() {
        return Valor;
    }
    
}
