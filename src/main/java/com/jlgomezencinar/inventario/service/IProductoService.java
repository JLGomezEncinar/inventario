package com.jlgomezencinar.inventario.service;

import com.jlgomezencinar.inventario.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> traerProductos();
    Producto buscarProducto (Long codProducto);
    Producto crearProducto(Producto producto);
    Producto modificarProducto(Long codProducto, Producto producto);
    boolean eliminarProducto(Long codProducto);
}
