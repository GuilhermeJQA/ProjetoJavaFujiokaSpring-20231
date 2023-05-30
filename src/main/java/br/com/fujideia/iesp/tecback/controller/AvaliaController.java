package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.service.AvaliaService;
import br.com.fujideia.iesp.tecback.model.Avalia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avalia")

public class AvaliaController {
    @Autowired
    private AvaliaService service;

    @PostMapping
    public ResponseEntity<Avalia> salvar(@RequestBody Avalia avalia){
        avalia = service.salvar(avalia);
        return ResponseEntity.ok(avalia);
    }
    @PutMapping
    public ResponseEntity<Avalia> alterar(@RequestBody Avalia avalia){
        avalia = service.alterar(avalia);
        return ResponseEntity.ok(avalia);
    }

    @GetMapping
    public ResponseEntity<List<Avalia>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avalia> consultar(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id){
        if(service.excluir(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}


