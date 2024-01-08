package service;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductosService {
	private static List<Producto> productos=new ArrayList<>();
	
	/*public boolean agregarProducto(String nombre, double precio, String categoria) {
		Producto producto=new Producto(nombre, precio, categoria);
		for(Producto p:productos) {
			if(p.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				return false;
			}
		}
		productos.add(producto);
		return true;
	}*/
	
	public void agregarProducto(String nombre, double precio, String categoria) {
		productos.add(new Producto(nombre,precio,categoria));
	}
	
	
	
	public List<Producto> buscarPorCategoria(String categoria){
		ArrayList<Producto> aux=new ArrayList<>();
		for(Producto p:productos) {
			if(p.getCategoria().toLowerCase().equals(categoria.toLowerCase())) {
				aux.add(p);
			}
		}
		return aux;
		
		//PROGRAMACIÓN FUNCIONAL
		//return productos.stream()
			//.filter(p->p.getCategoria().equals(categoria))
			//.toList();
	}
	
	/*public boolean eliminarProducto(String nombre) {
		for(Producto p:productos) {
			if(p.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				productos.remove(p);
				return true;
			}
		}
		return false;	
	}*/
	
	public void eliminarProducto(String nombre) {
		productos.removeIf(p->p.getNombre().equals(nombre));
	}
	
	
}
