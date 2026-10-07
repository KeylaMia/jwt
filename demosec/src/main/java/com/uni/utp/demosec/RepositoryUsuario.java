package com.uni.utp.demosec;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsuario(String nombre);
}