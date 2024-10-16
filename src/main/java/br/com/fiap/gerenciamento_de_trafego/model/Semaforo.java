package br.com.fiap.gerenciamento_de_trafego.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_SEMAFORO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Semaforo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_SEMAFORO"
    )
    @SequenceGenerator(
            name = "SEQ_SEMAFORO",
            sequenceName = "SEQ_SEMAFORO",
            allocationSize = 1
    )
    private Long semaforoId;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "status")
    private String status;

    @Column(name = "tempo_verde")
    private int tempoVerde;

    @Column(name = "tempo_amarelo")
    private int tempoAmarelo;

    @Column(name = "tempo_vermelho")
    private int tempoVermelho;
}
