package br.com.fiap.springpfauthentication.repository;

import br.com.fiap.springpfauthentication.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
