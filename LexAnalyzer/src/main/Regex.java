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
public enum Regex {
    ID("^([(a-zA-Z)][(a-zA-Z)|(0-9)]*)"),
    NUM("^((-?)(\\d+)((\\.\\d+)?))"),
    MAIORIGUAL("<="),
    MENORIGUAL(">="),
    IGUAL("=="),
    DIFERENTE("!=");
    
    String descricao;

    private Regex(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
    
}
