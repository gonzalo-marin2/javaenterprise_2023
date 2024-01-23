package service;

import java.util.ArrayList;
import java.util.List;

import dtos.LibroDto;
import dtos.TemaDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Libro;
import model.Tema;
import service.mappers.Mapeador;

public class LibrosService {
	private EntityManager getEntityManager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreriaPU");
		return factory.createEntityManager();
	}
	
	//Ahora, en vez de entregar entidades, entregamos dtos
	
	public List<TemaDto> getTemas(){
		String jpql="select t from Tema t";
		TypedQuery<Tema> query=getEntityManager().createQuery(jpql, Tema.class);
		List<Tema> temas=query.getResultList();
		List<TemaDto> temasDto=new ArrayList<>();
		//return query.getResultList();
		//hay que devolver una lista de dtos Tema
		for(Tema t:temas) {
			TemaDto temaDto=Mapeador.temaEntityToDto(t);
			temasDto.add(temaDto);
		}
		return temasDto;
		
		//Con stream o programación funcional
		/*return query.getResultList()
				.stream()
				.map(t->Mapeador.temaEntityToDto(t))
				.toList();*/
		
	}
	
	public List<LibroDto> getLibrosPorTema(int idTema){
		String jpql="select l from Libro l";
		TypedQuery<Libro> query;
		if(idTema!=0) {
			jpql+=" where l.idTema=?1";
			query=getEntityManager().createQuery(jpql, Libro.class);
			query.setParameter(1, idTema);
		}else {
			//así muestra todos los libros
			query=getEntityManager().createQuery(jpql, Libro.class);
		}
		return query.getResultList()
				.stream()
				.map(l->Mapeador.libroEntityToDto(l))
				.toList();
	}
	
	public LibroDto getLibro(int isbn) {
		return Mapeador.libroEntityToDto(getEntityManager().find(Libro.class, isbn));
	}
	
	
	public TemaDto getTema(int idTema) {
		return Mapeador.temaEntityToDto(getEntityManager().find(Tema.class, idTema));
	}
}
