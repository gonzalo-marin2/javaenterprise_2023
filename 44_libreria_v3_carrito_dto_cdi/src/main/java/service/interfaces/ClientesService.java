package service.interfaces;

import dtos.ClienteDto;

public interface ClientesService {
	ClienteDto autenticarCliente(String usuario, String password);
	void altaCliente(ClienteDto cliente);
}
