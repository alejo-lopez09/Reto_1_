package com.reto.app;

import com.reto.model.Producto;
import com.reto.service.ProductoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal: crea una lista de productos de ejemplo,
 * pide al usuario una categoria y muestra el resultado filtrado
 * y ordenado en orden descendente por precio.
 */
public class Main {

    public static void main(String[] args) {
        List<Producto> productos = crearListaDeProductos();
        ProductoService service = new ProductoService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Filtrado y ordenamiento de productos ===\n");
        System.out.println("Productos disponibles:");
        productos.forEach(System.out::println);

        System.out.print("\nIngrese la categoria a filtrar (ej: Tecnologia, Hogar, Ropa, Alimentos): ");
        String categoria = scanner.nextLine().trim();

        List<Producto> resultado = service.filtrarYOrdenarPorCategoria(productos, categoria);

        System.out.println("\nProductos de la categoria \"" + categoria + "\" ordenados por precio descendente:");
        if (resultado.isEmpty()) {
            System.out.println("No se encontraron productos para esa categoria.");
        } else {
            resultado.forEach(System.out::println);
        }

        scanner.close();
    }

    private static List<Producto> crearListaDeProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Laptop", "Tecnologia", 3500000));
        productos.add(new Producto("Mouse", "Tecnologia", 45000));
        productos.add(new Producto("Teclado", "Tecnologia", 120000));
        productos.add(new Producto("Monitor", "Tecnologia", 850000));
        productos.add(new Producto("Sofa", "Hogar", 1200000));
        productos.add(new Producto("Lampara", "Hogar", 90000));
        productos.add(new Producto("Mesa", "Hogar", 450000));
        productos.add(new Producto("Camisa", "Ropa", 60000));
        productos.add(new Producto("Pantalon", "Ropa", 95000));
        productos.add(new Producto("Zapatos", "Ropa", 180000));
        productos.add(new Producto("Arroz", "Alimentos", 4500));
        productos.add(new Producto("Aceite", "Alimentos", 12000));
        return productos;
    }
}
