package tiendapox;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
	
	// Busca los pedidos por nombre ignorando las mayúsculas y
	// minúsculas pasado como parámetro
	List<Cart> findByNameContainingIgnoreCase(String name);
	
	// Busca los pedidos por el estado en el que se encuentra.
	List<Cart> findByState(String state);
	
	// Busca los pedidos por el estado en el que se encuentra.
	List<Cart> findByDateBetween(Date from, Date to);

}
