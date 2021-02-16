package com.nomedaempresa.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nomedaempresa.cursomc.domain.Cidade;
import com.nomedaempresa.cursomc.domain.Sorteios;

@Repository
public interface SorteiosRepository extends JpaRepository<Sorteios, Integer>{

}
