package br.com.apontador.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apontador.model.ShowAllEmpresas;

@Repository
public interface ShowAllEmpresasRepository extends JpaRepository<ShowAllEmpresas, Long>{

  Page<ShowAllEmpresas> findByTipoLikeOrderByIdDesc(String tipoEmpresa,Pageable pageable);

}
