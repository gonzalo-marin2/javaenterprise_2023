package service;

import java.util.ArrayList;

import model.Curso;

public class CursosService {
	//creamos el ArrayList estático para que no se pierda y todas las instancias lo compartan
	//sino, se pierden los diferentes cursos nuevos que se crean
	private static ArrayList<Curso> cursos=new ArrayList<>();
	
	/*
	Menú con las siguientes opciones:
	1.- Nuevo curso
	Pide los datos del nuevo curso y lo guarda.
	Añade el curso si no hay otro con el mismo nombre.
	Si ya existe no se añade y se devuelve falso.
	2.- Buscar cursos por precio máximo
	Pide el precio máximo y muestra una lista con los cursos que valen menos de ese valor
	3.- Eliminar curso
	Pide nombre del curso y lo elimina
	4.- Modificar duración curso
	Pide nombre del curso y nueva duración, y lo modifica
	5.- Salir
	*/
	
	public boolean nuevo(String nombre, int duracion, double precio) {
		Curso curso=new Curso(nombre,duracion,precio);
		for(Curso c:cursos) {
			if(c.getNombre().equals(nombre)) { 
				return false;
			}
		//no es necesario el bloque else
		//sino guardaría en la primera iteración
		}
		cursos.add(curso);
		return true;
	}
	
	public ArrayList<Curso> preciosCursoMax(double precioMax) {
		//creamos arraylist auxiliar
		ArrayList<Curso> auxiliar=new ArrayList<>();
		//recorremos ArrayList principal y cada curso con precio menor o igual
		//al máximo, será guardado en el auxiliar
		for(Curso c:cursos) {
			if(c.getPrecio()<=precioMax) {
				auxiliar.add(c);
			}
		}
		//devolvemos el array auxiliar
		return auxiliar;
	}
	
	public void eliminarCurso(String nombre) {
		/*for(int i=0;i<cursos.size();i++) {//necesitamos un índice, por eso usamos un for normal
			if(cursos.get(i).getNombre().equals(nombre)) {
				cursos.remove(i);
				break;//nos salimos para no seguir recorriendo
			}
		}*/
		
		//lo hacemos con una expresión lambda
		cursos.removeIf(c->c.getNombre().equals(nombre));
	}
	
	public void modificarDuracion(String nombre, int nuevaDuracion) {
		for(Curso c:cursos) {//no necesitamos índice
			if(c.getNombre().equals(nombre)) {
				c.setDuracion(nuevaDuracion);
				break;
			}
		}
	}

}
