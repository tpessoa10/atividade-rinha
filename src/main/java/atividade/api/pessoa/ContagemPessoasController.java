package atividade.api.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contagem-pessoas")
public class ContagemPessoasController {
	private final PessoaDAO pessoaDAO;

	@Autowired
	public ContagemPessoasController(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}
	
	@GetMapping
	public Long ContagemDePessoas() {
		return pessoaDAO.ContagemDePessoas();
	}
}
