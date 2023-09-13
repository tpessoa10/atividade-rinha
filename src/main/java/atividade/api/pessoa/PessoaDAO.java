package atividade.api.pessoa;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;


@Repository
public class PessoaDAO {

	@PersistenceContext
	private EntityManager entityManager;
	@Transactional
	public void salvarPessoa(Pessoa pessoa) {
		entityManager.persist(pessoa);
	}
	public Pessoa RetornarPessoa(Long id) {
		return entityManager.find(Pessoa.class, id);
		
	}
	public List<Pessoa> buscarRegistrosPorNome(String termo) {
	    String jpql = "select s from stack";
	    Query query = entityManager.createQuery(jpql, Pessoa.class);
	    query.setParameter("termo", "%" + termo + "%");
	    return query.getResultList();
	}
}
