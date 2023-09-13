package atividade.api.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {
	private final PessoaDAO pessoaDAO;

	@Autowired
	public PessoaController(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}
	
	@PostMapping("pessoas")
	public void salvarPessoa(@RequestBody Pessoa pessoa) {
		pessoaDAO.salvarPessoa(pessoa);
	}
}
