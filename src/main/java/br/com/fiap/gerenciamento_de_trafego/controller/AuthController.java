package br.com.fiap.gerenciamento_de_trafego.controller;

import br.com.fiap.gerenciamento_de_trafego.config.security.TokenService;
import br.com.fiap.gerenciamento_de_trafego.dto.LoginDTO;
import br.com.fiap.gerenciamento_de_trafego.dto.TokenDTO;
import br.com.fiap.gerenciamento_de_trafego.dto.UsuarioCadastroDTO;
import br.com.fiap.gerenciamento_de_trafego.dto.UsuarioExibicaoDTO;
import br.com.fiap.gerenciamento_de_trafego.model.Usuario;
import br.com.fiap.gerenciamento_de_trafego.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody
            @Valid
            LoginDTO usuarioDto
    ){
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        usuarioDto.email(),
                        usuarioDto.senha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        System.out.println(auth.getPrincipal());

        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(token));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDTO registrar(@RequestBody @Valid UsuarioCadastroDTO usuarioCadastroDTO){

        UsuarioExibicaoDTO usuarioSalvo = usuarioService.salvarUsuario(usuarioCadastroDTO);

        return usuarioSalvo;

    }

}
