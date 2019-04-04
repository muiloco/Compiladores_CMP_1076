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

    public static void LexAnalyzer(String doc) {
        Lexer.listaDeToken = new ArrayList<>();
        Lexer.variaveis = new HashMap<>();
        String texto[] = doc.split("\\s+");
        String espa = "";
        Matcher regraID, regraNUM, regraDIF, regraIG, regraMAI, regraMEI;
        String item;
        char caracter;
        for (String fragmento : texto) {
            if (fragmento.length() > 0) {
                while (fragmento.length() > 0) {
                    regraID = Pattern.compile(Regex.ID.getDescricao()).matcher(fragmento);
                    regraNUM = Pattern.compile(Regex.NUM.getDescricao()).matcher(fragmento);
                    regraDIF = Pattern.compile(Regex.DIFERENTE.getDescricao()).matcher(fragmento);
                    regraIG = Pattern.compile(Regex.IGUAL.getDescricao()).matcher(fragmento);
                    regraMAI = Pattern.compile(Regex.MAIORIGUAL.getDescricao()).matcher(fragmento);
                    regraMEI = Pattern.compile(Regex.MENORIGUAL.getDescricao()).matcher(fragmento);
                    caracter = fragmento.charAt(0);
                    if (regraID.find()) {
                        if (PalavrasReservadas.Ereservada(regraID.group(1).toUpperCase())) {
                            item = regraID.group(1);
                            addToken(PalavrasReservadas.ReturnReservada(item.toUpperCase()), item);
                            fragmento = fragmento.substring(item.length());
                        } else {
                            item = regraID.group(1);
                            addToken(Regex.ID.toString(), regraID.group(1));
                            addHash(item, "0");
                            fragmento = fragmento.substring(item.length());
                        }
                    } else if (regraNUM.find()) {
                        item = regraNUM.group(1);
                        addToken(Regex.NUM.toString(), regraNUM.group(1));
                        fragmento = fragmento.substring(item.length());
                    } else if (regraDIF.find()) {
                        item = regraDIF.group(1);
                        addToken("OPR_REL", regraDIF.group(1));
                        fragmento = fragmento.substring(item.length());
                    } else if (regraIG.find()) {
                        item = regraIG.group(1);
                        addToken("OPR_REL", regraIG.group(1));
                        fragmento = fragmento.substring(item.length());
                    } else if (regraMAI.find()) {
                        item = regraMAI.group(1);
                        addToken("OPR_REL", regraMAI.group(1));
                        fragmento = fragmento.substring(item.length());
                    } else if (regraMEI.find()) {
                        item = regraMEI.group(1);
                        addToken("OPR_REL", regraMEI.group(1));
                        fragmento = fragmento.substring(item.length());
                    } else if (caracter == '<') {
                        addToken("OPR_REL", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == '>') {
                        addToken("OPR_REL", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == '=') {
                        addToken("ATRIB", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == '+') {
                        addToken("SOMA", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == '*') {
                        addToken("MULT", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == '%') {
                        addToken("REST", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == '-') {
                        addToken("SUBR", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == '/') {
                        addToken("DIVI", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == '(') {
                        addToken("PARE", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == ')') {
                        addToken("PARD", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == ',') {
                        addToken("VIRG", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == ';') {
                        addToken("PVIR", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else if (caracter == '.') {
                        addToken("PONT", String.valueOf(caracter));
                        fragmento = fragmento.substring(1);
                    } else {
                        item = fragmento;
                        fragmento = fragmento.substring(1);
                        System.out.println("Erro:---" + item);
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
