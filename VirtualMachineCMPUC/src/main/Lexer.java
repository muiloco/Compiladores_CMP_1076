/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Fernando.Sousa
 */
public class Lexer {

    static ArrayList<Token> listaDeToken;
    static HashMap<String, String> variaveis;

    public Lexer() {

    }

    public static ArrayList<Token> getListaDeToken() {
        return listaDeToken;
    }

    public static HashMap<String, String> getVariaveis() {
        return variaveis;
    }

    public static void addToken(String id, String valor) {
        Token token = new Token(id, valor);
        Lexer.listaDeToken.add(token);
    }

    public static void addHash(String key, String valor) {
        Lexer.variaveis.put(key, valor);
    }

    public static void LexAnalyzer(String doc) throws Exception {
        Lexer.listaDeToken = new ArrayList<>();
        Lexer.variaveis = new HashMap<>();
        String texto[] = doc.split("\\s+");
        Matcher regraREGISTER, regraNUM, regraOPERATOR;
        char caracter;
        for (String fragmento : texto) {
            if (fragmento.length() > 0) {
                while (fragmento.length() > 0) {
                    regraREGISTER = Pattern.compile(Regex.REGISTER.getDescricao()).matcher(fragmento);
                    regraNUM = Pattern.compile(Regex.NUM.getDescricao()).matcher(fragmento);
                    regraOPERATOR = Pattern.compile(Regex.OPERATOR.getDescricao()).matcher(fragmento);
                    caracter = fragmento.charAt(0);
                    if (regraOPERATOR.find()) {
                        if (PalavrasReservadas.Ereservada(regraOPERATOR.group(1).toUpperCase())) {
                            addToken(PalavrasReservadas.ReturnReservada(regraOPERATOR.group(1).toUpperCase()), regraOPERATOR.group(1));
                            fragmento = fragmento.substring(regraOPERATOR.group(1).length());
                        } else {
                            throw new Exception("Comando não identificado:" + regraOPERATOR.group(1));
                        }
                    } else if (regraREGISTER.find()) {
                        addToken(Regex.REGISTER.toString(), regraREGISTER.group(1));
                        addHash(regraREGISTER.group(1), "0");
                        fragmento = fragmento.substring(regraREGISTER.group(1).length());
                    } else if (regraNUM.find()) {
                        addToken(Regex.NUM.toString(), regraNUM.group(1));
                        fragmento = fragmento.substring(regraNUM.group(1).length());
                    } else if (caracter == ',') {
                        addToken("VIRG", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else {
                        throw new Exception("Codigo errado!!-" + fragmento);
                    }
                }
            }
        }
    }

    public static void imprimirLista() {
        Token token;
        for (int i = 0; i < Lexer.listaDeToken.size(); i++) {
            token = Lexer.listaDeToken.get(i);
            System.out.println(token.getToken() + ":" + token.getValor());
        }
    }

    public static void imprimirHash() {
        String x = Lexer.variaveis.toString();
        System.out.println(x);
    }
}
