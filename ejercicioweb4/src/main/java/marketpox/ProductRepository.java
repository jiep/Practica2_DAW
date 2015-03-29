package marketpox;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	// Busca los productos que contienen el nombre ignorando las mayúsculas y
	// minúsculas pasado como parámetro
	List<Product> findByNameContainingIgnoreCase(String name);

	// Busca los productos por categoría
	List<Product> findByCategory(String category);

	// Busca los productos mayores o iguales que from y menores que to ordenados
	// ascendentemente
	List<Product> findByPriceBetweenOrderByPriceAsc(double from, double to);

}
