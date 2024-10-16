package br.com.fiap.gerenciamento_de_trafego.dto;


import br.com.fiap.gerenciamento_de_trafego.model.Usuario;

public record UsuarioExibicaoDTO(
        Long usuarioId,
        String nome,
        String email) {

    public UsuarioExibicaoDTO(Usuario usuario) {
        this(
            usuario.getUsuarioId(),
            usuario.getNome(),
            usuario.getEmail());
    }

}
