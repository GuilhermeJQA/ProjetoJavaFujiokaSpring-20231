package br.com.fujideia.iesp.tecback.Service;

import br.com.fujideia.iesp.tecback.model.Avalia;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.AvaliaRepository;
import br.com.fujideia.iesp.tecback.repository.FilmeRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AvaliaService {
    @Autowired
    private AvaliaRepository repository;

    public Avalia salvar(Avalia avalia) {
        avalia = this.repository.save(avalia);
        return avalia;
    }


    public List<Avalia> listar() {
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

    public Avalia consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public Avalia alterar(Avalia avalia){
        if(Objects.nonNull(avalia.getId())){
            avalia = repository.save(avalia);
        }
        else{throw new NotFoundException();
        }
        return avalia;
    }
}