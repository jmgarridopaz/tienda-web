package es.uhu.etsi.tallerhexagonal.tiendaweb.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente save (Cliente cliente);

    public List<Cliente> findAll();

}
