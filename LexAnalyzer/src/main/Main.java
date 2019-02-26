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
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String url = "doc.txt";
        FileReader arquivo = new FileReader(url);
        BufferedReader arquivoLer = new BufferedReader(arquivo);
        String linha;
        String doc = "";
        while((linha = arquivoLer.readLine()) != null)
        {
            doc+=linha; 
        }
        String texto[] = doc.split("[^a-zA-Z]+[^0-9*]");
        for (String tex : texto){
            if(!tex.equals(" ")){
                System.out.println(tex);
            }
        }
//        String nocarc[] = null;
//        for (int i = 0; i < texto.length; i++) { ((|)|,|;|.|<|>|==|=|<=|>=|!=|+|*|-|%|/|^)|\\s+]
//            String x = texto[i];
//            nocarc[i]=x.split("\\W");
//        }[(,),;,.,<,>,==,=,<=,>=,!=,+,*,-,%,/,^
        
//        boolean x;
//        for (String dado : dados) {
//            x = Pattern.compile("^([a-zA-Z]([a-zA-Z]|\\d)*)").matcher(dado).matches();
//            System.out.println(dado);
//        }
//        for (int i=0 ; i<dados[3].length();i++){
//            //System.out.println(dados[3].charAt(i));
//        }
//        boolean x = Pattern.compile("^([a-zA-Z]([a-zA-Z]|\\d)*)").matcher(dados[4]).matches();
//        System.out.println(x);
//        boolean a = Pattern.compile("[a-zA-Z]*").matcher(teste).matches();
//        Matcher b = a.matcher(teste);
//        String[] slipt1 = teste.split("\[a-z]");
//        String[] slipt1 = teste.split(Pattern.compile("[a-zA-Z]*").matcher(teste));
//        System.out.println(slipt1.length);
//        System.out.println(a);
//        ((dados[3].charAt(i)>='a' && dados[3].charAt(i)<='z')||(dados[3].charAt(i)>='A' && dados[3].charAt(i)<='Z'))
    }
    
}
