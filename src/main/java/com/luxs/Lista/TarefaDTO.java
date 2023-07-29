package com.luxs.Lista;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TarefaDTO {

    private boolean feita;
    private String nome;
    private String descricao;
    private int numero;

}
