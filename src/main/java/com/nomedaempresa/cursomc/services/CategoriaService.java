package com.nomedaempresa.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nomedaempresa.cursomc.domain.Categoria;
import com.nomedaempresa.cursomc.dto.CategoriaDTO;
import com.nomedaempresa.cursomc.repositories.CategoriaRepository;
import com.nomedaempresa.cursomc.services.exception.DataIntegrityException;
import com.nomedaempresa.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired /* instancia a classe CategoriaRepository aqui */
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto nao encontrado Id: " + id + " Tipo: " + Categoria.class.getName()));
		}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
		
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return categoriaRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			categoriaRepository.deleteById(id);
		} 
		/* DataIntegrityViolationException exececao que vem do banco de dados*/
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível porque há entidades relacionadas");
		}
	}
	
    public List<Categoria> findAll() {
    	return categoriaRepository.findAll();
    }
    
    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
    	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
    	return categoriaRepository.findAll(pageRequest);
    }
    
    public Categoria fromDTO(CategoriaDTO objDto) {
    	return new Categoria(objDto.getId(), objDto.getNome());
    }
	
    private void updateData (Categoria newObj, Categoria obj) {
    	newObj.setNome(obj.getNome());
    }
    


}
