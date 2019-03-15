/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Fernando R
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String url = "doc.txt";
        FileReader arquivo = new FileReader(url);
        BufferedReader arquivoLer = new BufferedReader(arquivo);
        Matcher rid;
        String linha;
        String doc = "";
        while ((linha = arquivoLer.readLine()) != null) {
            doc += linha;
        }
        ArrayList<Token> listaDeToken = new ArrayList<>();
        String texto[] = doc.split("\\s+");
//        for (int i = 0; i < texto.length; i++) {
//            rid = Pattern.compile(Regex.ID.getDescricao()).matcher(texto[i]);
//            if (!texto[i].equals("")) {
//                while (!texto[i].equals("")) {
//                    //comparacao para ID
//                    if (rid.find()) {
//                        Token lex = new Token("ID", rid.group(1));
//                        listaDeToken.add(lex);
//                        texto[i] = texto[i].replaceFirst(rid.group(1), "");
//                    }
//                }
//            }
//        }
        
    }
}
