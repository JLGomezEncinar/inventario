package com.jlgomezencinar.inventario.controller;

import com.jlgomezencinar.inventario.model.Producto;
import com.jlgomezencinar.inventario.service.IProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoWebController {
    private final IProductoService productoService;

    public ProductoWebController(IProductoService productoService) {
        this.productoService = productoService;
    }
    @GetMapping
    public String traerProductos(Model model) {
        model.addAttribute("productos", productoService.traerProductos());
        return "productos/lista";
    }
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("titulo", "Registrar producto");
        return "productos/formulario";
    }
    @PostMapping("/crear")
    public String crearProducto(@ModelAttribute Producto producto, Model model) {
        Producto resultado;
        if (producto.getCodProducto() == null) {
            resultado = productoService.crearProducto(producto);
        } else {
            resultado = productoService.modificarProducto(producto.getCodProducto(), producto);
        }
        if (resultado == null) {
            System.out.println("Entrando en el error");
            model.addAttribute("producto", producto);
            model.addAttribute("titulo", producto.getCodProducto() == null ? "Registrar producto" : "Modificar producto");
            model.addAttribute("error", "Todos los campos debe ser rellenados correctamente.");
            return "productos/formulario";
        }
        return "redirect:/productos";
    }
    @GetMapping("/modificar/{codProducto}")
        public String modificarProducto(@PathVariable Long codProducto, Model model) {
            Producto producto = productoService.buscarProducto(codProducto);
            if (producto == null) {
                return "redirect:/productos";
            }
            model.addAttribute("producto", producto);
            model.addAttribute("titulo", "Modificar producto");
            return "productos/formulario";
        }
    @PostMapping("/eliminar/{codProducto}")
    public String eliminarProducto(@PathVariable Long codProducto) {
        productoService.eliminarProducto(codProducto);
        return "redirect:/productos";

        }

}
