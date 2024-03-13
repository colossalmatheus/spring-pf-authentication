package br.com.fiap.springpfauthentication.resource;

import br.com.fiap.springpfauthentication.entity.Perfil;
import br.com.fiap.springpfauthentication.entity.Permissao;
import br.com.fiap.springpfauthentication.repository.PerfilRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilResource {

    @Autowired
    private PerfilRepository repo;

    @GetMapping
    public List<Perfil> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Perfil findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping(value = "/{id}/permissoes")
    public Set<Permissao> findPermissoesById(@PathVariable Long id) {
        Perfil perfil = repo.findById(id).orElseThrow();
        return perfil.getPermissoes();
    }

    @Transactional
    @PostMapping
    public Perfil save(@RequestBody Perfil perfil) {
        return repo.save(perfil);
    }

    @Transactional
    @PostMapping(value = "/{id}/permissoes")
    public Perfil addPermission(@PathVariable Long id, @RequestBody Permissao permissao) {
        Perfil perfil = repo.findById(id).orElseThrow();
        perfil.getPermissoes().add(permissao);
        return repo.save(perfil);
    }
}
