package br.com.apontador.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.apontador.model.Empresa;
import br.com.apontador.model.SearchRequest;
import br.com.apontador.model.ShowAllEmpresas;
import br.com.apontador.respository.EmpresaRepository;
import br.com.apontador.respository.ShowAllEmpresasRepository;
import br.com.apontador.service.exceptions.RecursoNaoEncontradoException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private ShowAllEmpresasRepository showAllEmpresasRepository;
	
	public Page<ShowAllEmpresas> listar(SearchRequest searchRequest) {
		return showAllEmpresasRepository.findByTipoLikeOrderByIdDesc(("%" +stringToSQL(searchRequest.getTipoEmpresa())+ "%"),PageRequest.of(searchRequest.getPage(),searchRequest.getPageSize()));
	}
	public Optional<ShowAllEmpresas> buscarPeloId(Long id) {
		
		Optional<ShowAllEmpresas> empresa = showAllEmpresasRepository.findById(id);
		
		if(!empresa.isPresent()) {
			throw new RecursoNaoEncontradoException("Nenhuma empresa foi encontrada");
		}
		
		return empresa;
	}
		
	public String stringToSQL(String search) {
		String decodedSearchTerm = "";
		try {
			decodedSearchTerm = java.net.URLDecoder.decode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		return decodedSearchTerm.replace(' ', '%');
	}
	
	
	public Map<String,Empresa> salvar(Empresa empresa) {
		try{
			empresaRepository.save(empresa);
		}catch(Exception e){
			throw new RecursoNaoEncontradoException("Problemas ao salvar Empresa, tente novamente!");
		}
		Map<String,Empresa> result = new HashMap<String,Empresa>();
		result.put("result", empresa);
		return result;

	}
	

	public void verificarExistencia(Long id) {
		buscarPeloId(id);
	}
	
	public Map<String,Empresa> atualizar(Empresa empresa) {
	
		verificarExistencia(empresa.getId());
		empresaRepository.save(empresa);
		Map<String,Empresa> result = new HashMap<String,Empresa>();
		result.put("result", empresa);
		return result;
	}
	
	public Map<String,ShowAllEmpresas>  deletar(Long id) {
		verificarExistencia(id);
		Optional<ShowAllEmpresas> empresa = buscarPeloId(id);		
		try {						
			empresaRepository.deleteById(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException("A empresa não foi encontrad");
		}
		Map<String,ShowAllEmpresas> result = new HashMap<String,ShowAllEmpresas>();
		result.put("result", empresa.get());
		return result;
	}

}
