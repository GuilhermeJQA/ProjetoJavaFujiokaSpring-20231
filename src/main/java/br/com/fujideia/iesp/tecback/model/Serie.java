package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "tb_serie")
public class Serie implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String titulo;

    @Column(name = "ds_sinopse", length = 500)
    @NotEmpty
    private String sinopse;

    @Positive
    private Integer episodios;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

}
