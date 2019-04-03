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
    WHILE("WHILE"),
    ESCREVA("ESCREVA"),
    LEIA("LEIA");

    String descricao;

    private PalavrasReservadas(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static boolean Ereservada(String palavra) {
        if (palavra.equals(IF.getDescricao())) {
            return true;
        } else if (palavra.equals(ELSE.getDescricao())) {
            return true;
        } else if (palavra.equals(AND.getDescricao())) {
            return true;
        } else if (palavra.equals(OR.getDescricao())) {
            return true;
        } else if (palavra.equals(NOT.getDescricao())) {
            return true;
        } else if (palavra.equals(WHILE.getDescricao())) {
            return true;
        } else if (palavra.equals(ESCREVA.getDescricao())) {
            return true;
        } else if (palavra.equals(LEIA.getDescricao())) {
            return true;
        } else {
            return false;
        }
    }

    public static String ReturnReservada(String palavra) {
        if (palavra.equals(IF.getDescricao())) {
            return IF.getDescricao();
        } else if (palavra.equals(ELSE.getDescricao())) {
            return ELSE.getDescricao();
        } else if (palavra.equals(AND.getDescricao())) {
            return AND.getDescricao();
        } else if (palavra.equals(OR.getDescricao())) {
            return OR.getDescricao();
        } else if (palavra.equals(NOT.getDescricao())) {
            return NOT.getDescricao();
        } else if (palavra.equals(ESCREVA.getDescricao())) {
            return ESCREVA.getDescricao();
        } else if (palavra.equals(LEIA.getDescricao())) {
            return LEIA.getDescricao();
        } else {
            return WHILE.getDescricao();
        }
    }

}
