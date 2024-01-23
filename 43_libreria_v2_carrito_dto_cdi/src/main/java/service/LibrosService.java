package service;

import java.util.List;

import dtos.LibroDto;
import dtos.TemaDto;

public interface LibrosService {

	List<TemaDto> getTemas();

	List<LibroDto> getLibrosPorTema(int idTema);

	LibroDto getLibro(int isbn);

	TemaDto getTema(int idTema);

}