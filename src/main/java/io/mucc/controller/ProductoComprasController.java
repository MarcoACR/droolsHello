package io.mucc.controller;

import io.mucc.model.Producto;
import io.mucc.service.ProductoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoComprasController {

    private final ProductoComprasService service;

    @Autowired
    public ProductoComprasController(ProductoComprasService comprasService) {
        this.service = comprasService;
    }


    @PostMapping("/producto")
    public Producto getPregunta(@RequestParam String valor){

        Producto producto = new Producto();
        producto.setTipo(valor);
        service.getProductoSeleccionado(producto);
        return producto;

    }

}
