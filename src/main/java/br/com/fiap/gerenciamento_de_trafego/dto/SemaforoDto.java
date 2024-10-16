package br.com.fiap.gerenciamento_de_trafego.dto;


import br.com.fiap.gerenciamento_de_trafego.model.Semaforo;

public record SemaforoDto(
        Long semaforoId,
        String localizacao,
        String status,
        int tempoVerde,
        int tempoAmarelo,
        int tempoVermelho
) {

    public SemaforoDto(Semaforo semaforo) {
        this(
                semaforo.getSemaforoId(),
                semaforo.getLocalizacao(),
                semaforo.getStatus(),
                semaforo.getTempoVerde(),
                semaforo.getTempoAmarelo(),
                semaforo.getTempoVermelho()
        );
    }


}
