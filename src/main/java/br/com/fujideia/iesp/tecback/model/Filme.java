package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_filme")
public class Filme implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "No title")
    private String titulo;

    @Column(name = "ds_sinopse", length = 500)
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;


}
