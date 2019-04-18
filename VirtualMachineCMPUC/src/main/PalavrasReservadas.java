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
    //OPERAÇÕES ARITMÉTICAS
    ADD("ADD"),
    SUB("SUB"),
    MUL("MUL"),
    DIV("DIV"),
    MOD("MOD"),
    POT("POT"),
    //OPERAÇÕES LÓGICAS
    AND("AND"),
    OR("OR"),
    NOT("NOT"),
    //OPERAÇÕES DE MÉMORIA
    LOAD("LOAD"),
    STORE("STORE"),
    //OPERAÇÕES DE PILHA
    PUSH("PUSH"),
    POP("POP"),
    //OPERAÇÕES DE DESVIO
    //-INCONDICIONAIS:
    JUMP("JUMP"),
    //-CONDICIONAIS:
    BEQ("BEQ"),
    BNE("BNE"),
    BLT("BLT"),
    BLE("BLE"),
    BGT("BGT"),
    BGE("BGE"),
    //OPERAÇÕES DE I/O
    READ("READ"),
    WRITE("WRITE");

    String descricao;

    private PalavrasReservadas(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static boolean Ereservada(String palavra) {
        if (palavra.equals(ADD.getDescricao())) {
            return true;
        } else if (palavra.equals(SUB.getDescricao())) {
            return true;
        } else if (palavra.equals(MUL.getDescricao())) {
            return true;
        } else if (palavra.equals(DIV.getDescricao())) {
            return true;
        } else if (palavra.equals(MOD.getDescricao())) {
            return true;
        } else if (palavra.equals(AND.getDescricao())) {
            return true;
        } else if (palavra.equals(OR.getDescricao())) {
            return true;
        } else if (palavra.equals(NOT.getDescricao())) {
            return true;
        } else if (palavra.equals(LOAD.getDescricao())) {
            return true;
        } else if (palavra.equals(STORE.getDescricao())) {
            return true;
        } else if (palavra.equals(PUSH.getDescricao())) {
            return true;
        } else if (palavra.equals(POP.getDescricao())) {
            return true;
        } else if (palavra.equals(JUMP.getDescricao())) {
            return true;
        } else if (palavra.equals(BEQ.getDescricao())) {
            return true;
        } else if (palavra.equals(BNE.getDescricao())) {
            return true;
        } else if (palavra.equals(BLT.getDescricao())) {
            return true;
        } else if (palavra.equals(BLE.getDescricao())) {
            return true;
        } else if (palavra.equals(BGT.getDescricao())) {
            return true;
        } else if (palavra.equals(BGE.getDescricao())) {
            return true;
        } else if (palavra.equals(READ.getDescricao())) {
            return true;
        } else if (palavra.equals(WRITE.getDescricao())) {
            return true;
        } else {
            return false;
        }
    }

    public static String ReturnReservada(String palavra) {
        if (palavra.equals(ADD.getDescricao())) {
            return ADD.getDescricao();
        } else if (palavra.equals(SUB.getDescricao())) {
            return SUB.getDescricao();
        } else if (palavra.equals(MUL.getDescricao())) {
            return MUL.getDescricao();
        } else if (palavra.equals(DIV.getDescricao())) {
            return DIV.getDescricao();
        } else if (palavra.equals(MOD.getDescricao())) {
            return MOD.getDescricao();
        } else if (palavra.equals(AND.getDescricao())) {
            return AND.getDescricao();
        } else if (palavra.equals(OR.getDescricao())) {
            return OR.getDescricao();
        } else if (palavra.equals(NOT.getDescricao())) {
            return NOT.getDescricao();
        } else if (palavra.equals(LOAD.getDescricao())) {
            return LOAD.getDescricao();
        } else if (palavra.equals(STORE.getDescricao())) {
            return STORE.getDescricao();
        } else if (palavra.equals(PUSH.getDescricao())) {
            return PUSH.getDescricao();
        } else if (palavra.equals(POP.getDescricao())) {
            return POP.getDescricao();
        } else if (palavra.equals(JUMP.getDescricao())) {
            return JUMP.getDescricao();
        } else if (palavra.equals(BEQ.getDescricao())) {
            return BEQ.getDescricao();
        } else if (palavra.equals(BNE.getDescricao())) {
            return BNE.getDescricao();
        } else if (palavra.equals(BLT.getDescricao())) {
            return BLT.getDescricao();
        } else if (palavra.equals(BLE.getDescricao())) {
            return BLE.getDescricao();
        } else if (palavra.equals(BGT.getDescricao())) {
            return BGT.getDescricao();
        } else if (palavra.equals(BGE.getDescricao())) {
            return BGE.getDescricao();
        } else if (palavra.equals(READ.getDescricao())) {
            return READ.getDescricao();
        } else {
            return WRITE.getDescricao();
        }
    }

}
