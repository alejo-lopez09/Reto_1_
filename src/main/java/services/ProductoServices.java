package services;



import com.reto.model.Producto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector

/**
 * Contiene la logica de negocio para filtrar y ordenar productos
 * usando expresiones lambda y la API de Streams.
 */
public class ProductoService {

    /**
     * Filtra los productos por una categoria especifica y los ordena
     * en orden descendente por precio.
     *
     * @param productos lista original de productos
     * @param categoria categoria por la cual filtrar
     * @return nueva lista filtrada y ordenada
     */
    public List<Producto> filtrarYOrdenarPorCategoria(List<Producto> productos, String categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria)) // 1. Filtrado con lambda
                .sorted((p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio())) // 2. Ordenamiento descendente con lambda
                .collect(Collectors.toList());
    }

    /**
     * Version alternativa usando Comparator.comparing + reversed,
     * tambien basada en expresiones lambda.
     */
    public List<Producto> filtrarYOrdenarPorCategoriaV2(List<Producto> productos, String categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
    }
}
