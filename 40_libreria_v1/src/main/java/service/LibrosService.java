package service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Libro;
import model.Tema;

public class LibrosService {
	private EntityManager getEntityManager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreriaPU");
		return factory.createEntityManager();
	}
	
	public List<Tema> getTemas(){
		String jpql="select t from Tema t";
		TypedQuery<Tema> query=getEntityManager().createQuery(jpql, Tema.class);
		return query.getResultList();
	}
	
	public List<Libro> getLibrosPorTema(String tema){
		String jpql="select t from Tema t where t.tema=?1";
		TypedQuery<Libro> query=getEntityManager().createQuery(jpql, Libro.class);
		query.setParameter(1, tema);
		return query.getResultList();
	}
}
