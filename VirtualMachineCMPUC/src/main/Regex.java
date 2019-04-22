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
public enum Regex {
    REGISTER("^([r]{1}([0-9]{1,2}))"),
    NUM("^([\\-]?[0-9]+([\\.][0-9]+)?)"),
    OPERATOR("^([a-zA-Z]([a-zA-Z])+)");
   
    String descricao;

    private Regex(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
    
}
