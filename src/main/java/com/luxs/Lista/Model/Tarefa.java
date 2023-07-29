package com.luxs.Lista.Model;

public class Tarefa {

    private boolean feita = false;
    private String nome;
    private String descricao;
    private int numero;


    public Tarefa(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setFeita(boolean feita) {
        this.feita = feita;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome(){
        return nome;
    }

    public boolean isFeita(){
        return feita;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }


    public String toString(){
        return "Nome: "+nome+"\nDescricao: "+descricao+"\nFeita: " + (isFeita() ? "sim" : "nao")+"\n";
    }
}
