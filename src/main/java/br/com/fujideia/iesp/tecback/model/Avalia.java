package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_avalia")
public class Avalia {
    @Id
    private Integer id;
    private Integer idUsuario;
    private Integer idFilme;
    @Column(name = "ds_avaliacao", length = 500)
    private String avaliacao;

}
