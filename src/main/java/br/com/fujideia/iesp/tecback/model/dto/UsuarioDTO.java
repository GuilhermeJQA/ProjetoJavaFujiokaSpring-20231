package br.com.fujideia.iesp.tecback.model.dto;

import br.com.fujideia.iesp.tecback.validator.NomeValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Integer id;
    private String login;

    @NomeValidation
    private String nome;

    @Email @NotEmpty
    private String email;
    private String telefone;

    private Integer idade;
}
