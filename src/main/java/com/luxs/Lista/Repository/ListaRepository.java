package com.luxs.Lista.Repository;

import com.luxs.Lista.Model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends JpaRepository<Tarefa, Long> {
}
