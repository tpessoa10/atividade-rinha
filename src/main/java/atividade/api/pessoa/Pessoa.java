package atividade.api.pessoa;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pessoa")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "apelido", unique = true)
	private String apelido;
	
	@Column(name = "nome")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	@ElementCollection
    @CollectionTable(name = "stack", joinColumns = @JoinColumn(name = "pessoa_id"))
    @Column(name = "tecnologia")
	private List<String> stack;
	
	public Pessoa(PessoaDTO dados) {
		this.apelido = dados.apelido();
		this.nome = dados.nome();
		this.nascimento = dados.nascimento();
		this.stack = dados.stack();
	}
}