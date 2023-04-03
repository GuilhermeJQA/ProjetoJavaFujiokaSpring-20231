package br.com.fujideia.iesp.tecback.Service;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.model.Genero;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import br.com.fujideia.iesp.tecback.repository.GeneroRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GeneroService {
    @Autowired
    private GeneroRepository repository;

    public Genero salvar(Genero genero) {
        genero = this.repository.save(genero);
        return genero;
    }


    public List<Genero> listar() {
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try {
            repository.deleteById(id);
        }catch (Exception e ){
            log.info("Erro ao realizar Exclusão : {}", e);
            return false;

        }
        return true;
    }

    public Genero consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public Genero alterar(Genero genero){
        if(Objects.nonNull(genero.getId())){
            genero = repository.save(genero);
        }
        else{throw new NotFoundException();
        }
        return genero;
    }
}