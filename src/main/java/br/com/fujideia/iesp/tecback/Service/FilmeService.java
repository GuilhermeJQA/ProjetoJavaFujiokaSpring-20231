package br.com.fujideia.iesp.tecback.Service;

import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FilmeService {
    @Autowired
    private FilmeRepository repository;

    public Filme salvar(Filme filme) {
        filme = this.repository.save(filme);
        return filme;
    }


    public List<Filme> listar() {
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

    public Filme consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public Filme alterar(Filme filme){
        if(Objects.nonNull(filme.getId())){
            filme = repository.save(filme);
        }
        else{throw new NotFoundException();
        }
        return filme;
    }
}