package service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Curso;

public class CursosService {
	private EntityManager getEntityManager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("cursosPU");
		return factory.createEntityManager();
	}
	public List<Curso> preciosCursoMax(double precioMax) {
		String jpql="select c from Curso c where c.precio<=?1";
		TypedQuery<Curso> query=getEntityManager().createQuery(jpql, Curso.class);
		query.setParameter(1, precioMax);
		return query.getResultList();
	}
	public List<Curso> buscarPorDuracion(int minimo, int maximo){
		String jpql="select c from Curso c where c.duracion>=?1 and c.duracion<=?2maximo";
		TypedQuery<Curso> query=getEntityManager().createQuery(jpql, Curso.class);
		query.setParameter(1, minimo);
		query.setParameter(2, maximo);
		return query.getResultList();
		
	}
}
