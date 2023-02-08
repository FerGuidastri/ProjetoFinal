package com.cxcommerce.projetofinal.Config;
import com.cxcommerce.projetofinal.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepository userRepository;


    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            return userRepository.findByUsername(username).orElseThrow(()-> new Exception("Não encontrado"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}