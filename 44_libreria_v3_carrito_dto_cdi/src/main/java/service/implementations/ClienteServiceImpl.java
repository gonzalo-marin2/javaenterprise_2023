package service.implementations;

import java.util.ArrayList;
import java.util.List;

import dtos.ClienteDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Cliente;
import service.interfaces.ClientesService;
import service.mappers.Mapeador;

public class ClienteServiceImpl implements ClientesService{
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("libreriaPU");
		return factory.createEntityManager();
	}
	
	@Override
	public ClienteDto autenticarCliente(String usuario, String password) {
		String jpql="select c from Cliente c where c.usuario=?1 and c.password=?2";
		TypedQuery<Cliente> query=getEntityManager().createQuery(jpql, Cliente.class);
		query.setParameter(1, usuario);
		query.setParameter(2, password);
		ClienteDto clienteDto=new ClienteDto();
		List<Cliente> clientes=query.getResultList();
		return clientes.size()>0?Mapeador.clienteEntityToDto(clientes.get(0)):null;
		
		// otra opción, usando getSingleResult
		/*try {
			return Mapeador.clienteEntityToDto(query.getSingleResult());
		}
		catch(Exception ex) {
			return null;
		}*/
	}

	@Override
	public void altaCliente(ClienteDto cliente) {
		EntityManager em=getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(Mapeador.clienteDtoToEntity(cliente));
		tx.commit();
		
	}
}
