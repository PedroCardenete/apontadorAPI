package br.com.apontador.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.apontador.model.Empresa;
import br.com.apontador.model.SearchRequest;
import br.com.apontador.model.ShowAllEmpresas;
import br.com.apontador.service.EmpresaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {


	@Autowired
	private EmpresaService empresaService;

	@CrossOrigin 
	@ApiOperation(value = "Listar todas as Empresas ( paginação )")
	@GetMapping(value="/list")
	public ResponseEntity<Page<ShowAllEmpresas>> ListStorefront(@RequestParam(defaultValue = "0") int page,
												@RequestParam(defaultValue = "16") int pageSize,
												@RequestParam(defaultValue = "") String tipoEmpresa){
		SearchRequest searchRequest = new SearchRequest(page,pageSize,tipoEmpresa);
		Page<ShowAllEmpresas> result = empresaService.listar(searchRequest);
		
		return ResponseEntity.ok().body(result);
	}

	@CrossOrigin 
	@ApiOperation(value = "Buscar empresa pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<ShowAllEmpresas> buscarPeloId(@PathVariable Long id) {
		Optional<ShowAllEmpresas> empresa = empresaService.buscarPeloId(id);

		return ResponseEntity.ok().body(empresa.get());
	}

	@CrossOrigin 
	@ApiOperation(value = "Adicionar Empresa")
	@PostMapping
	public ResponseEntity<Map<String,Empresa>> salvar(@Valid @RequestBody Empresa empresa) {
		Map<String,Empresa> result = empresaService.salvar(empresa);
		return ResponseEntity.ok().body(result);
	}

	@CrossOrigin 
	@ApiOperation(value = "Atualizar Empresa")
	@PutMapping("/{id}")
	public ResponseEntity<Map<String,Empresa>> atualizar(@PathVariable Long id, @Valid @RequestBody Empresa empresa) {
		Map<String,Empresa> result = empresaService.atualizar(empresa);
		return ResponseEntity.ok().body(result);
	}

	@CrossOrigin
	@ApiOperation(value = "Deletar Empresa")
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,ShowAllEmpresas>>deletar(@PathVariable Long id) {

			Map<String,ShowAllEmpresas> result = empresaService.deletar(id);
		return ResponseEntity.ok().body(result);
	}

}
