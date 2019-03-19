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
        String texto[] = doc.split(" ");
        String espa="";
        Matcher regraID, regraNUM, regraDIF, regraIG, regraMAI, regraMEI;
        System.out.println("ate aqui veio!!");
        for (int i = 0; i <= texto.length; i++) {
            regraID = Pattern.compile(Regex.ID.getDescricao()).matcher(texto[i]);
            regraNUM = Pattern.compile(Regex.NUM.getDescricao()).matcher(texto[i]);
            regraDIF = Pattern.compile(Regex.DIFERENTE.getDescricao()).matcher(texto[i]);
            regraIG = Pattern.compile(Regex.IGUAL.getDescricao()).matcher(texto[i]);
            regraMAI = Pattern.compile(Regex.MAIORIGUAL.getDescricao()).matcher(texto[i]);
            regraMEI = Pattern.compile(Regex.MENORIGUAL.getDescricao()).matcher(texto[i]);
            if (!texto[i].equals("")) {
                while (!texto[i].equals("")) {
                    if (regraID.find()) {
                        if (PalavrasReservadas.Ereservada(regraID.group(1).toUpperCase())) {
                            String id = regraID.group(1);
                            addToken(PalavrasReservadas.ReturnReservada(id.toUpperCase()), doc);
                            texto[i] = texto[i].replaceFirst(id, "");
                            System.out.println(regraID.group(1));
                        } else {
                            String id = regraID.group(1);
                            addToken(Regex.ID.toString(), regraID.group(1));
                            addHash(id, "0");
                            texto[i] = texto[i].replaceFirst(id, "");
                            System.out.println(regraID.group(1));
                        }
                    }
                    else if (regraNUM.find()) {
                        String id = regraNUM.group(1);
                        addToken(Regex.NUM.toString(), regraNUM.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                        System.out.println(regraNUM.group(1));
                    }
                    else if (regraDIF.find()) {
                        String id = regraDIF.group(1);
                        addToken("OPR_REL", regraDIF.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                        System.out.println(regraDIF.group(1));
                    }
                    else if (regraIG.find()) {
                        String id = regraIG.group(1);
                        addToken("OPR_REL", regraIG.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                        System.out.println(regraIG.group(1));
                    }
                    else if (regraMAI.find()) {
                        String id = regraMAI.group(1);
                        addToken("OPR_REL", regraMAI.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                        System.out.println(regraMAI.group(1));
                    }
                    else if (regraMEI.find()) {
                        String id = regraMEI.group(1);
                        addToken("OPR_REL", regraMEI.group(1));
                        texto[i] = texto[i].replaceFirst(id, "");
                        System.out.println(regraMEI.group(1));
                    }
                    else if (texto[i].charAt(0) == '<') {
                        char id = texto[i].charAt(0);
                        addToken("OPR_REL", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == '>') {
                        char id = texto[i].charAt(0);
                        addToken("OPR_REL", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == '=') {
                        char id = texto[i].charAt(0);
                        addToken("ATRIB", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == '+') {
                        char id = texto[i].charAt(0);
                        addToken("OPR_AR", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == '*') {
                        char id = texto[i].charAt(0);
                        addToken("OPR_AR", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == '%') {
                        char id = texto[i].charAt(0);
                        addToken("OPR_AR", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == '-') {
                        char id = texto[i].charAt(0);
                        addToken("OPR_AR", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == '/') {
                        char id = texto[i].charAt(0);
                        addToken("OPR_AR", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == '(') {
                        char id = texto[i].charAt(0);
                        addToken("DELIM", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == ')') {
                        char id = texto[i].charAt(0);
                        addToken("DELIM", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == ',') {
                        char id = texto[i].charAt(0);
                        addToken("DELIM", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == ';') {
                        char id = texto[i].charAt(0);
                        addToken("DELIM", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (texto[i].charAt(0) == '.') {
                        char id = texto[i].charAt(0);
                        addToken("DELIM", String.valueOf(id));
                        texto[i] = texto[i].substring(1);
                        System.out.println(String.valueOf(id));
                    } else {
                        String id = texto[i];
                        System.out.println("Erro:---" + id);
                        i++;
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
