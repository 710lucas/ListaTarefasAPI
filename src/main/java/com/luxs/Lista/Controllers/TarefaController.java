package com.luxs.Lista.Controllers;

import com.luxs.Lista.Services.TarefaService;
import com.luxs.Lista.TarefaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TarefaController {


    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService t){
        tarefaService = t;
    }



    @GetMapping("/tarefas")
    public ResponseEntity<String> getTarefas(){
        return ResponseEntity.ok(tarefaService.toString());
    }

    @PostMapping("/tarefas")
    public ResponseEntity<String> addTarefa(@RequestBody TarefaDTO tarefa){
        tarefaService.addTarefa(tarefa.getNome(), tarefa.getDescricao());
        return ResponseEntity.ok(tarefaService.getTarefas().get(tarefaService.getTarefas().size()-1).getNome()+" adicionado com sucesso");
    }

    @PutMapping("/fez")
    public ResponseEntity<String> fezTarefa(@RequestBody TarefaDTO tarefa){
        tarefaService.setFeita(true, tarefa.getNumero());
        return ResponseEntity.status(200).body("Ok");
    }
    @PutMapping("/nao-fez")
    public ResponseEntity<String> naoFezTarefa(@RequestBody TarefaDTO tarefa){
        tarefaService.getTarefa(tarefa.getNumero()).setFeita(false);
        return ResponseEntity.status(200).body("Ok");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletaTarefa(@RequestBody TarefaDTO tarefa){
        tarefaService.removeTarefa(tarefa.getNumero());
        return ResponseEntity.status(200).body("Ok");
    }

}
