package atividade.api.pessoa;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class PessoaDAO {

	@PersistenceContext
	private EntityManager entityManager;
	@Transactional
	public void salvarPessoa(Pessoa pessoa) {
		entityManager.persist(pessoa);
	}
}
