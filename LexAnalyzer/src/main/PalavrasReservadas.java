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
public enum PalavrasReservadas {
    IF("IF"),
    ELSE("ELSE"),
    AND("OPR_LOG"),
    OR("OPR_LOG"),
    NOT("OPR_LOG"),
    WHILE("WHILE");
    
    String descricao;

    private PalavrasReservadas(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
