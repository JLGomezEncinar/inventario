package com.jlgomezencinar.inventario.service;

import com.jlgomezencinar.inventario.model.Producto;
import com.jlgomezencinar.inventario.repository.IProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private final IProductoRepository productoRepository;

    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> traerProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarProducto(Long codProducto) {
        return productoRepository.findById(codProducto).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto producto) {
        if (producto == null) {
            return null;
        }
        boolean valido = this.validarDatos(producto);
        if(!valido) {
            return null;
        }
        return productoRepository.save(producto);
    }

    @Override
    public Producto modificarProducto(Long codProducto, Producto producto) {
        Producto productoAux = buscarProducto(codProducto);
        if (productoAux == null) {
            return null;
        }

        productoAux.setNombre(producto.getNombre());
        productoAux.setCategoria(producto.getCategoria());
        productoAux.setPrecio(producto.getPrecio());
        productoAux.setStock(producto.getStock());
        productoAux.setDescripcion(producto.getDescripcion());
        boolean valido = this.validarDatos(producto);
        if(!valido) {
            return null;
        }
        return productoRepository.save(productoAux);

    }


    @Override
    public boolean eliminarProducto(Long codProducto) {
        Producto productoAux = buscarProducto(codProducto);
        if (productoAux == null) {
            return false;
        }
        productoRepository.delete(productoAux);
        return true;
    }
    public boolean validarDatos(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            return false;
        }
        if (producto.getCategoria() == null || producto.getCategoria().isBlank()) {
            return false;
        }
        if (producto.getPrecio() <= 0) {
            return false;
        }
        if (producto.getStock() <= 0) {
            return false;
        }
        return true;
    }
}
