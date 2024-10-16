package br.com.fiap.gerenciamento_de_trafego.service;

import br.com.fiap.gerenciamento_de_trafego.dto.SemaforoDto;
import br.com.fiap.gerenciamento_de_trafego.model.Semaforo;
import br.com.fiap.gerenciamento_de_trafego.repository.SemaforoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SemaforoService {

    @Autowired
    private SemaforoRepository semaforoRepository;

    public SemaforoDto salvarSemaforo(SemaforoDto semaforoDto) {
        Semaforo semaforo = new Semaforo();
        BeanUtils.copyProperties(semaforoDto, semaforo);

        Semaforo semaforoSalvo = semaforoRepository.save(semaforo);
        return new SemaforoDto(semaforoSalvo);
    }

    public SemaforoDto buscarPorId(Long id){
        Optional<Semaforo> semaforoOptional =
                semaforoRepository.findById(id);

        if (semaforoOptional.isPresent()){
            return new SemaforoDto(semaforoOptional.get());
        } else {
            throw new RuntimeException("Semaforo não existe!");
        }
    }

    public Semaforo buscarPorLocalizacao(String localizacao) {
        Optional<Semaforo> semaforoOptional = semaforoRepository.findByLocalizacao(localizacao);
        if (semaforoOptional.isPresent()) {
            return semaforoOptional.get();
        } else {
            throw new RuntimeException("Semaforo não encontrado!");
        }
    }

    public Page<SemaforoDto> listarTodos(Pageable paginacao){
        return semaforoRepository
                .findAll(paginacao)
                .map(SemaforoDto::new);
    }



    public void excluir(Long id){
        Optional<Semaforo> semaforoOptional =
                semaforoRepository.findById(id);

        if (semaforoOptional.isPresent()){
            semaforoRepository.delete(semaforoOptional.get());
        } else {
            throw new RuntimeException("Semaforo não encontrado!");
        }
    }

    public SemaforoDto atualizar(SemaforoDto semaforoDto){
        Optional<Semaforo> semaforoOptional =
                semaforoRepository.findById(semaforoDto.semaforoId());

        if (semaforoOptional.isPresent()){
            Semaforo semaforo = new Semaforo();
            BeanUtils.copyProperties(semaforoDto, semaforo);

            return new SemaforoDto(semaforoRepository.save(semaforo));
        } else {
            throw new RuntimeException("Semaforo não encontrado!");
        }
    }

}
