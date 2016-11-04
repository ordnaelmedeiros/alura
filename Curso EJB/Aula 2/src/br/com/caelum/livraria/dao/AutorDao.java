package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@Inject
	private Banco banco;
	
	@PostConstruct
	void aposCriacao() {
	    System.out.println("[INFO] AutorDao foi criado.");
	}
	
	public AutorDao() {
		System.out.println("[INFO] AutorDao foi iniciado.");
	}
	
	public void salva(Autor autor) {
		
		System.out.println("[INFO] Salvando o Autor " + autor.getNome());
	    banco.save(autor);
	    System.out.println("[INFO] Salvou o Autor " + autor.getNome());
	    
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
