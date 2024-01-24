package service.mappers;

import dtos.ClienteDto;
import dtos.LibroDto;
import dtos.TemaDto;
import model.Cliente;
import model.Libro;
import model.Tema;
import service.implementations.LibrosServiceImpl;
import service.interfaces.LibrosService;

public class Mapeador {
	
	public static TemaDto temaEntityToDto(Tema tema) {
		return new TemaDto(tema.getIdTema(), tema.getTema());
	}
	
	public static LibroDto libroEntityToDto(Libro libro) {
		LibrosService service=new LibrosServiceImpl();
		return new LibroDto(libro.getIsbn(),
				libro.getTitulo(),
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(),
				service.getTema(libro.getIdTema()));
	}
	
	public static ClienteDto clienteEntityToDto(Cliente cliente) {
		return new ClienteDto(
				cliente.getUsuario(),
				cliente.getPassword(),
				cliente.getEmail(),
				cliente.getTelefono());
	}
	
	public static Cliente clienteDtoToEntity(ClienteDto cliente) {
		return new Cliente(0,
				cliente.getUsuario(),
				cliente.getPassword(),
				cliente.getEmail(),
				cliente.getTelefono());
	}
}
