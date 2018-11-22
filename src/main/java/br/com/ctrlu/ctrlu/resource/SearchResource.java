package br.com.ctrlu.ctrlu.resource;

import br.com.ctrlu.ctrlu.model.Usuario;
import br.com.ctrlu.ctrlu.repository.UsuarioRepositorySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/search")
public class SearchResource {

    private UsuarioRepositorySearch usuarioRepositorySearch;

    @Autowired
    public SearchResource(UsuarioRepositorySearch usuarioRepository){
        this.usuarioRepositorySearch = usuarioRepository;
    }

    @GetMapping(value = "/all")
    public List<Usuario> searchAll(){
        List<Usuario> usuarios = new ArrayList<>();
        Iterable<Usuario> all = usuarioRepositorySearch.findAll();
        all.forEach(usuarios::add);
        return usuarios;
    }

    @GetMapping(value = "/nome/{nome}")
    public Usuario searchName(@PathVariable final String nome){
        return usuarioRepositorySearch.getUsuarioPorNome(nome);
    }

    @GetMapping(value = "/name/{id}")
    public Usuario searchName(@PathVariable final Long id){
        Optional<Usuario> byId = usuarioRepositorySearch.findById(id);
        return byId.get();
    }

}
