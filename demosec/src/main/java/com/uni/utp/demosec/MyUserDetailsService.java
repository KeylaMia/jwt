package com.uni.utp.demosec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {
   @Autowired
    private RepositoryUsuario repoUsuario;
   
         @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repoUsuario.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        var authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsuario(),
                user.getPassword(), true, true, true, true, authorities);
    }
}