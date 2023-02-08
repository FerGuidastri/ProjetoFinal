package com.cxcommerce.projetofinal.controller;

import com.cxcommerce.projetofinal.model.EnderecoModel;
import com.cxcommerce.projetofinal.repository.UserRepository;
import com.cxcommerce.projetofinal.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;
    private UserRepository userRepository;

    public EnderecoController(EnderecoService enderecoService,UserRepository userRepository){
        this.enderecoService = enderecoService;
        this.userRepository = userRepository;
    }
    @GetMapping("/getUser")
    public Object teste(){
        return userRepository.findByUsername("User");
    }

    @PostMapping
    public ResponseEntity<?> createEndereco(@Valid EnderecoModel enderecoModel){
        return ResponseEntity.ok(enderecoService.createEndereco(enderecoModel));
    }
}
