package com.reto.service;

import com.reto.model.Producto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ProductoService {

   
   
    public List<Producto> filtrarYOrdenarPorCategoria(List<Producto> productos, String categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria)) 
                .sorted((p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio())) 
                .collect(Collectors.toList());
    }

    
    public List<Producto> filtrarYOrdenarPorCategoriaV2(List<Producto> productos, String categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
    }
}
