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
        Parser x = new Parser(doc);
        try {
            x.SinAnalyzer();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
