package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_avalia")
public class Avalia implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "ds_avaliacao", length = 1000)
    private String avaliacao;

    @ManyToOne
    @JoinColumn(name= "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_filme")
    private Filme filme;
}
