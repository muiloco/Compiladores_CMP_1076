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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Fernando R
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String url = "doc.txt";
        FileReader arquivo = new FileReader(url);
        BufferedReader arquivoLer = new BufferedReader(arquivo);
        String linha;
        String doc = "";
        while ((linha = arquivoLer.readLine()) != null) {
            doc += linha;
        }
        String texto [] = doc.split("\\s");
        Matcher regraNUM = Pattern.compile(Regex.NUM.getDescricao()).matcher("-25.05;algo25");
        String t;
        if (regraNUM.find()) {
            t = regraNUM.group();
            System.out.println(t);
        }
        
//        for (int i = 0; i < texto.length; i++) {
//            System.out.println(texto[i]);
//        }
//        Lexer.LexAnalyzer(doc);
//        Lexer.imprimirLista();
    }
}
