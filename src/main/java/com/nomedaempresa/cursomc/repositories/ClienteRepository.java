package com.nomedaempresa.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nomedaempresa.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	/* (readOnly=true) nao necessita ser envolvida como uma transacao de  
	 * banco de dados fica mais rapida e diminui o locking do banco de dados
	 */
	
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
}
