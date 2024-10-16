package br.com.fiap.gerenciamento_de_trafego.repository;

import br.com.fiap.gerenciamento_de_trafego.model.Semaforo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SemaforoRepository extends JpaRepository<Semaforo, Long> {

    public Optional<Semaforo> findByLocalizacao(String localizacao);

}
