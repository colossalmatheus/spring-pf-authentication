package br.com.fiap.springpfauthentication.resource;


import br.com.fiap.springpfauthentication.entity.Perfil;
import br.com.fiap.springpfauthentication.entity.Permissao;
import br.com.fiap.springpfauthentication.entity.Sistema;
import br.com.fiap.springpfauthentication.entity.Usuario;
import br.com.fiap.springpfauthentication.repository.PerfilRepository;
import br.com.fiap.springpfauthentication.repository.SistemaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/sistema")
public class SistemaResource {


    @Autowired
    private SistemaRepository repo;

    @GetMapping
    public List<Sistema> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Sistema findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping(value = "/{id}/responsaveis")
    public Set<Usuario> findPermissoesById(@PathVariable Long id) {
        Sistema sistema = repo.findById(id).orElseThrow();
        return sistema.getResponsaveis();
    }

    @Transactional
    @PostMapping
    public Sistema save(@RequestBody Sistema sistema) {
        return repo.save(sistema);
    }

    @Transactional
    @PostMapping(value = "/{id}/responsaveis")
    public Sistema addPermission(@PathVariable Long id, @RequestBody Usuario usuario) {
        Sistema sistema = repo.findById(id).orElseThrow();
        sistema.getResponsaveis().add(usuario);
        return repo.save(sistema);
    }


}
