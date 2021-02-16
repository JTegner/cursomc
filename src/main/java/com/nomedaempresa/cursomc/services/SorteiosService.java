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
import com.nomedaempresa.cursomc.domain.Sorteios;
import com.nomedaempresa.cursomc.dto.CategoriaDTO;
import com.nomedaempresa.cursomc.dto.SorteiosDTO;
import com.nomedaempresa.cursomc.repositories.CategoriaRepository;
import com.nomedaempresa.cursomc.repositories.SorteiosRepository;
import com.nomedaempresa.cursomc.services.exception.DataIntegrityException;
import com.nomedaempresa.cursomc.services.exception.ObjectNotFoundException;

@Service
public class SorteiosService {
	
	@Autowired /* instancia a classe SorteiosRepository aqui */
	private SorteiosRepository sorteiosRepository;
	
	public Sorteios find(Integer id) {
		Optional<Sorteios> obj = sorteiosRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto nao encontrado Id: " + id + " Tipo: " + Sorteios.class.getName()));
		}
	
	public Sorteios insert(Sorteios obj) {
		obj.setSrtSorteio(null);
		return sorteiosRepository.save(obj);
	}
		
	public Sorteios update(Sorteios obj) {
		Sorteios newObj = find(obj.getSrtSorteio());
		updateData(newObj, obj);
		return sorteiosRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			sorteiosRepository.deleteById(id);
		} 
		/* DataIntegrityViolationException exececao que vem do banco de dados*/
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível porque há entidades relacionadas");
		}
	}
	
    public List<Sorteios> findAll() {
    	return sorteiosRepository.findAll();
    }
    
    public Page<Sorteios> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
    	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
    	return sorteiosRepository.findAll(pageRequest);
    }
    
    public Sorteios fromDTO(SorteiosDTO objDto) {
    	return new Sorteios(objDto.getSrtSorteio(), objDto.getSrtNro1(), objDto.getSrtNro2(), objDto.getSrtNro3(), objDto.getSrtNro4(), objDto.getSrtNro5(), objDto.getSrtNro6());
    }
	
    private void updateData (Sorteios newObj, Sorteios obj) {
    	newObj.setSrtNro1(obj.getSrtNro1());
    	newObj.setSrtNro2(obj.getSrtNro2());
    	newObj.setSrtNro3(obj.getSrtNro3());
    	newObj.setSrtNro4(obj.getSrtNro4());
    	newObj.setSrtNro5(obj.getSrtNro5());
    	newObj.setSrtNro6(obj.getSrtNro6());
    }

}
