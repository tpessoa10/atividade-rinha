package atividade.api.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
	private final PessoaDAO pessoaDAO;

	@Autowired
	public PessoaController(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}
	
	
	
	
	@PostMapping
	public void salvarPessoa(@RequestBody PessoaDTO dados) {
		var pessoa = new Pessoa(dados);
		pessoaDAO.salvarPessoa(pessoa);
	}
	
	@GetMapping("/{id}")
	public Pessoa RetornarPorId(@PathVariable Long id) {
		return pessoaDAO.RetornarPessoa(id);
	}
	
	@GetMapping
	public List<Pessoa> RetornarPorTermo(@PathParam("t") String termo) {
		return pessoaDAO.buscarRegistrosPorNome(termo);
	}
}
