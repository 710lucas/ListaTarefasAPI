package com.luxs.Lista.Services;

import com.luxs.Lista.Model.Tarefa;
import com.luxs.Lista.Repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    List<Tarefa> tarefas = new ArrayList<>();
    private final ListaRepository l;
    @Autowired
    public TarefaService(ListaRepository l){
        this.l = l;
        tarefas = l.findAll();
    }


    public void addTarefa(String nome, String descricao){
        Tarefa t = new Tarefa(nome, descricao);
        t.setNumero(tarefas.size());
        int diferenca = 0;
        while(getTarefa(t.getNumero())!= null)
            t.setNumero(t.getNumero()+(diferenca++));
        tarefas.add(t);
        l.save(t);
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
        if(t!=null) {
            tarefas.remove(t);
            l.delete(t);
        }
    }

    public void setFeita(boolean feita, int numero){
        Tarefa t = getTarefa(numero);
        if(t!=null) {
            t.setFeita(feita);
            l.save(t);
        }
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
