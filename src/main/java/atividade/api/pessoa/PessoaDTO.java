package atividade.api.pessoa;

import java.sql.Date;
import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record PessoaDTO (
	@NotBlank	
	String apelido,
	@NotBlank
	String nome,
	@NotBlank
	Date nascimento, 
	List stack) {
	
}
