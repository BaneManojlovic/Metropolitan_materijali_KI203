/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manojlovic.primeri07;

import javafx.scene.control.Label;

/**
 *
 * @author manojlovic
 */
public class Tekst implements Runnable{
    
    private String text;
    Label labela;

    public Tekst(String text) {
        this.text = text;
    }

    public Tekst(Label labela) {
        this.labela = labela;
    }

    public Tekst(String text, Label labela) {
        this.text = text;
        this.labela = labela;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Label getLabela() {
        return labela;
    }

    public void setLabela(Label labela) {
        this.labela = labela;
    }
    
    
    @Override
    public void run() {
        try{
            if(labela.getText().length()==0){
                labela.setText("Welcome");
            }else{
                labela.setText(" ");
            }
            Thread.sleep(500);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

    }
    
}
