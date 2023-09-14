package atividade.api.pessoa;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


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
	@Transactional
	public List<Pessoa> buscaRegistrosPorTermo(String termo) {
	    String jpql = "SELECT p FROM Pessoa p JOIN p.stack s WHERE p.nome LIKE :termo OR p.apelido LIKE :termo OR s LIKE :termo";
	    TypedQuery<Pessoa> queryPessoa = entityManager.createQuery(jpql, Pessoa.class).setParameter("termo", "%" + termo + "%");
	    return queryPessoa.getResultList();
	}
	
	public Long ContagemDePessoas() {
		String jpql = "SELECT COUNT(p) FROM Pessoa p";
		TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
		return query.getSingleResult();
	}
}
