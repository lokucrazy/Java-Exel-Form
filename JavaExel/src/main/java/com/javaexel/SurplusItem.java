/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexel;

/**
 *
 * @author relc7d
 */
public class SurplusItem {
    private String[] attributes = new String[3];
    
    public SurplusItem(String name, String condition, String quantity){
        this.attributes[0] = name;
        this.attributes[1] = condition;
        this.attributes[2] = quantity;
    }
    
    public String[] getAttributes(){
        return attributes;
    }
    
    @Override
    public String toString(){
        String str = attributes[0] + " " + attributes[1] + " " + attributes[2];
        return str;
    }
}
