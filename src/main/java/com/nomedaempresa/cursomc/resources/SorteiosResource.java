package com.nomedaempresa.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nomedaempresa.cursomc.domain.Sorteios;
import com.nomedaempresa.cursomc.dto.SorteiosDTO;
import com.nomedaempresa.cursomc.services.SorteiosService;

@RestController
@RequestMapping(value="/sorteios")
public class SorteiosResource {
	
	@Autowired
	private SorteiosService sorteiosService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Sorteios> find(@PathVariable Integer id) {
		/* ResponseEntity spring encapsula varias informacoes de uma resposta http*/
		/* <?> qualquer tipo */
		
		Sorteios obj = sorteiosService.find(id);
		//return ResponseEntity.ok().body(obj);
		return obj != null ? ResponseEntity.ok(obj) : ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SorteiosDTO objDto) {
		Sorteios obj = sorteiosService.fromDTO(objDto);
		obj = sorteiosService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getSrtSorteio()).toUri();
		return ResponseEntity.created(uri).build();
	}
	 
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody SorteiosDTO objDto, @PathVariable Integer id) {
		Sorteios obj = sorteiosService.fromDTO(objDto);
		obj.setSrtSorteio(id);
		obj = sorteiosService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		sorteiosService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SorteiosDTO>> findAll() {
		List<Sorteios> list = sorteiosService.findAll();
		List<SorteiosDTO> listDto = list.stream().map(obj -> new SorteiosDTO(obj)).collect(Collectors.toList());
		/* stream
		 * map efetua uma operacao para cada elemento da lista
		 * map (obj = obj eh um apelido para os objetos da lista
		 * a arrow function esta criando uma funcao anonima que a SorteiosDTO
		 * passando o obj como argumento
		 * para voltar para o tipo lista eh incluido .collect(Collectors.toList())
		 */
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<SorteiosDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Sorteios> list = sorteiosService.findPage(page, linesPerPage, orderBy, direction);
		Page<SorteiosDTO> listDto = list.map(obj -> new SorteiosDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
}
