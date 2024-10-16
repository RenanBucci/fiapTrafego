package br.com.fiap.gerenciamento_de_trafego.controller;

import br.com.fiap.gerenciamento_de_trafego.dto.SemaforoDto;
import br.com.fiap.gerenciamento_de_trafego.model.Semaforo;
import br.com.fiap.gerenciamento_de_trafego.service.SemaforoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SemaforoController {

    @Autowired
    private SemaforoService semaforoService;

    @PostMapping("/semaforos")
    @ResponseStatus(HttpStatus.CREATED)
    public SemaforoDto salvar(@RequestBody SemaforoDto semaforo) {
        return semaforoService.salvarSemaforo(semaforo);
    }

    @GetMapping("/semaforos")
    @ResponseStatus(HttpStatus.OK)
    public Page<SemaforoDto> listarTodos(@PageableDefault(size = 20, page = 0) Pageable paginacao) {
       return semaforoService.listarTodos(paginacao);
    }

    @GetMapping("/semaforos/localizacao/{localizacao}")
    @ResponseStatus(HttpStatus.OK)
    public Semaforo buscarPorLocalizacao(@PathVariable String localizacao) {
        return semaforoService.buscarPorLocalizacao(localizacao);
    }

    @GetMapping("/semaforos/id/{semaforoId}")
    public ResponseEntity<SemaforoDto> buscarPorId(
            @PathVariable Long semaforoId){
        try {
            return ResponseEntity
                    .ok(semaforoService.buscarPorId(semaforoId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/semaforos/id/{semaforoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long semaforoId){
        semaforoService.excluir(semaforoId);
    }

    @PutMapping("/semaforos")
    public ResponseEntity<SemaforoDto> atualizar(
            @RequestBody SemaforoDto semaforoDto){
        try {
             semaforoDto = semaforoService.atualizar(semaforoDto);
            return ResponseEntity.ok(semaforoDto);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
