package br.com.ctrlu.ctrlu.load;

import br.com.ctrlu.ctrlu.model.Usuario;
import br.com.ctrlu.ctrlu.repository.UsuarioRepositorySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {

    private ElasticsearchOperations elasticsearchOperations;

    private UsuarioRepositorySearch usuarioRepositorySearch;

    @Autowired
    public Loaders(ElasticsearchOperations elasticsearchOperations,
            UsuarioRepositorySearch usuarioRepository) {
        this.elasticsearchOperations = elasticsearchOperations;
        this.usuarioRepositorySearch = usuarioRepository;
    }


    @PostConstruct
    public void loadAll(){
        elasticsearchOperations.putMapping(Usuario.class);
        System.out.println("Carregando usuarios ");
        usuarioRepositorySearch.saveAll(getUsuarios());
        System.out.println("Carga de usuarios completa ");
    }

    private List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1l,"Evaristo 01"));
        usuarios.add(new Usuario(2l,"Evaristo 02"));
        usuarios.add(new Usuario(3l,"Evaristo 03"));
        usuarios.add(new Usuario(4l,"Evaristo 04"));
        return usuarios;

    }


}
