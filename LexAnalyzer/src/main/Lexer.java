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
            String fragmento = texto[i];
            regraID = Pattern.compile(Regex.ID.getDescricao()).matcher(fragmento);
            regraNUM = Pattern.compile(Regex.NUM.getDescricao()).matcher(fragmento);
            regraDIF = Pattern.compile(Regex.DIFERENTE.getDescricao()).matcher(fragmento);
            regraIG = Pattern.compile(Regex.IGUAL.getDescricao()).matcher(fragmento);
            regraMAI = Pattern.compile(Regex.MAIORIGUAL.getDescricao()).matcher(fragmento);
            regraMEI = Pattern.compile(Regex.MENORIGUAL.getDescricao()).matcher(fragmento);
            if (fragmento.length() != 0) {
                while (fragmento.length() != 0) {
                    if (regraID.find()) {
                        if (PalavrasReservadas.Ereservada(regraID.group(1).toUpperCase())) {
                            String id = regraID.group(1);
                            addToken(PalavrasReservadas.ReturnReservada(id.toUpperCase()), doc);
                            fragmento = fragmento.replaceFirst(id, "");
                            System.out.println(regraID.group(1));
                        } else {
                            String id = regraID.group(1);
                            addToken(Regex.ID.toString(), regraID.group(1));
                            addHash(id, "0");
                            fragmento = fragmento.replaceFirst(id, "");
                            System.out.println(regraID.group(1));
                        }
                    }
                    else if (regraNUM.find()) {
                        String id = regraNUM.group(1);
                        addToken(Regex.NUM.toString(), regraNUM.group(1));
                        fragmento = fragmento.replaceFirst(id, "");
                        System.out.println(regraNUM.group(1));
                    }
                    else if (regraDIF.find()) {
                        String id = regraDIF.group(1);
                        addToken("OPR_REL", regraDIF.group(1));
                        fragmento = fragmento.replaceFirst(id, "");
                        System.out.println(regraDIF.group(1));
                    }
                    else if (regraIG.find()) {
                        String id = regraIG.group(1);
                        addToken("OPR_REL", regraIG.group(1));
                        fragmento = fragmento.replaceFirst(id, "");
                        System.out.println(regraIG.group(1));
                    }
                    else if (regraMAI.find()) {
                        String id = regraMAI.group(1);
                        addToken("OPR_REL", regraMAI.group(1));
                        fragmento = fragmento.replaceFirst(id, "");
                        System.out.println(regraMAI.group(1));
                    }
                    else if (regraMEI.find()) {
                        String id = regraMEI.group(1);
                        addToken("OPR_REL", regraMEI.group(1));
                        fragmento = fragmento.replaceFirst(id, "");
                        System.out.println(regraMEI.group(1));
                    }
                    else if (fragmento.charAt(0) == '<') {
                        char id = fragmento.charAt(0);
                        addToken("OPR_REL", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == '>') {
                        char id = fragmento.charAt(0);
                        addToken("OPR_REL", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == '=') {
                        char id = fragmento.charAt(0);
                        addToken("ATRIB", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == '+') {
                        char id = fragmento.charAt(0);
                        addToken("OPR_AR", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == '*') {
                        char id = fragmento.charAt(0);
                        addToken("OPR_AR", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == '%') {
                        char id = fragmento.charAt(0);
                        addToken("OPR_AR", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == '-') {
                        char id = fragmento.charAt(0);
                        addToken("OPR_AR", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == '/') {
                        char id = fragmento.charAt(0);
                        addToken("OPR_AR", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == '(') {
                        char id = fragmento.charAt(0);
                        addToken("DELIM", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == ')') {
                        char id = fragmento.charAt(0);
                        addToken("DELIM", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == ',') {
                        char id = fragmento.charAt(0);
                        addToken("DELIM", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == ';') {
                        char id = fragmento.charAt(0);
                        addToken("DELIM", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    }
                    else if (fragmento.charAt(0) == '.') {
                        char id = fragmento.charAt(0);
                        addToken("DELIM", String.valueOf(id));
                        fragmento = fragmento.substring(1);
                        System.out.println(String.valueOf(id));
                    } else {
                        String id = fragmento;
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
