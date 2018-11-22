package br.com.ctrlu.ctrlu.repository;

import br.com.ctrlu.ctrlu.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface UsuarioRepositorySearch extends ElasticsearchRepository<Usuario, Long> {


    Optional<Usuario> findById(Long id);

    @Query( value = "{ \"usuario\" : { \"nome\" : ?0 }  }")
    Usuario getUsuarioPorNome(String nome);
}
