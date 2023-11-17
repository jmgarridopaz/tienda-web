package es.uhu.etsi.tallerhexagonal.tiendaweb.negocio;

import java.util.List;
import es.uhu.etsi.tallerhexagonal.tiendaweb.persistencia.Cliente;


public interface ClienteService {

	public void darAltaCliente ( String email, String nombre );

	public List<Cliente> obtenerTodosClientes();
	
}
