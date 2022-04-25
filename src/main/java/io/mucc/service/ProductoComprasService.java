package io.mucc.service;

import io.mucc.model.Producto;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoComprasService {


    private final KieContainer container;

    @Autowired
    public ProductoComprasService(KieContainer containerLocal){
        this.container = containerLocal;
    }

    public Producto getProductoSeleccionado(Producto producto){
        KieSession session = container.newKieSession("rulesSession");
        session.insert(producto);
        session.fireAllRules();
        session.dispose();
        return producto;
    }

}
