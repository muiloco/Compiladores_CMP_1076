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

    public ArrayList<Token> getListaDeToken() {
        return listaDeToken;
    }

    public HashMap<String, String> getVariaveis() {
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
        Matcher regra;
        for (int i = 0; i <= texto.length; i++) {
            if (!texto[i].equals("")) {
                while (!texto[i].equals("")) {
                    regra = Pattern.compile(Regex.ID.getDescricao()).matcher(texto[i]);
                    if (regra.find()) {
                        if (PalavrasReservadas.Ereservada(regra.group(1).toUpperCase())) {
                            String id = regra.group(1);
                            addToken(PalavrasReservadas.ReturnReservada(id.toUpperCase()), doc);
                            texto[i] = texto[i].replaceFirst(id, "");
                        } else {
                            String id = regra.group(1);
                            addToken(Regex.ID.toString(), regra.group(1));
                            addHash(id, "0");
                            texto[i] = texto[i].replaceFirst(id, "");
                        }
                    }
                    regra = Pattern.compile(Regex.NUM.getDescricao()).matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken(Regex.NUM.toString(), regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile(Regex.DIFERENTE.getDescricao()).matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("OPR_REL", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile(Regex.IGUAL.getDescricao()).matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("OPR_REL", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile(Regex.MAIORIGUAL.getDescricao()).matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("OPR_REL", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile(Regex.MENORIGUAL.getDescricao()).matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("OPR_REL", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile(Regex.MENOR.getDescricao()).matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("OPR_REL", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile(Regex.MAIOR.getDescricao()).matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("OPR_REL", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile("^(\\=)").matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("ATRIB", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile("^(\\+)").matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("OPR_AR", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile("/*^(\\*)*/").matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("OPR_AR", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile("^(\\%)").matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("OPR_AR", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile("^(\\-)").matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("OPR_AR", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile("^(\\/)").matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("OPR_AR", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile("^(\\()").matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("DELIM", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile("^(\\))").matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("DELIM", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile("^(\\,)").matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("DELIM", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile("^(\\;)").matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("DELIM", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                    regra = Pattern.compile("^(\\.)").matcher(texto[i]);
                    if (regra.find()) {
                        String id = regra.group(1);
                        addToken("DELIM", regra.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                    }
                }
            }
        }
    }

    public static void imprimirLista() {
        Token token;
        for (int i = 0; i <= Lexer.listaDeToken.size(); i++) {
            token = Lexer.listaDeToken.get(i);
            System.out.println(token.getToken() + "---" + token.getValor());
        }
    }
}
