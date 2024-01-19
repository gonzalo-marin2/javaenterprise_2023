package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "temas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Libro {
	private int isbn;
	private String titulo;
	private String autor;
	private double precio;
	private int paginas;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTema;
}
