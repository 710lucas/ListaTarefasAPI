package com.luxs.Lista.Services;

import com.luxs.Lista.Model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    List<Tarefa> tarefas = new ArrayList<>();

    public void addTarefa(String nome, String descricao){
        Tarefa t = new Tarefa(nome, descricao);
        t.setNumero(tarefas.size());
        int diferenca = 0;
        while(getTarefa(t.getNumero())!= null)
            t.setNumero(t.getNumero()+(diferenca++));
        tarefas.add(t);
    }

    public Tarefa getTarefa(int numero){
        for(Tarefa t : tarefas){
            if(t.getNumero() == numero)
                return t;
        }
        return null;
    }

    public void removeTarefa(int numero){
        Tarefa t = getTarefa(numero);
        if(t!=null)
            tarefas.remove(t);
    }

    public void setFeita(boolean feita, int numero){
        Tarefa t = getTarefa(numero);
        if(t!=null)
            t.setFeita(feita);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public String toString(){
        String out= "";
        for(Tarefa t : tarefas){
            out+=t.toString()+"\n";
        }
        return out;
    }

}
