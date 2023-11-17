package es.uhu.etsi.tallerhexagonal.tiendaweb.negocio;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.uhu.etsi.tallerhexagonal.tiendaweb.persistencia.Cliente;
import es.uhu.etsi.tallerhexagonal.tiendaweb.persistencia.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository clienteRepository;
	
	@Autowired	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public void darAltaCliente ( String email, String nombre ) {
		lanzarExeptionSiEmailIncorrecto(email);
		Cliente cliente = new Cliente();
		cliente.setEmail(email);
		cliente.setNombre(nombre);
		this.clienteRepository.save(cliente);
		return;
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		return this.clienteRepository.findAll();
	}

	
	private void lanzarExeptionSiEmailIncorrecto ( String email ) {
		if ( email==null ) {
			throw new EmailIncorrectoException("El email no puede ser nulo");
		}
		if ( email.trim().length()==0 ) {
			throw new RuntimeException("El email no puede estar en blanco");
		}
		if ( ! formatoEmailEsCorrecto(email) ) {
			throw new RuntimeException("El formato del email no es correcto");
		}
		return;
	}
	
	private boolean formatoEmailEsCorrecto(String email) {
		String patronEmail =
	            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
	            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	    Pattern pattern = Pattern.compile(patronEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
	}
	
}
