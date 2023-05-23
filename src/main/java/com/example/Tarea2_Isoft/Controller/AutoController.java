package com.example.Tarea2_Isoft.Controller;

import com.example.Tarea2_Isoft.Model.Auto;
import com.example.Tarea2_Isoft.Service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class AutoController {

    private final AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @PostMapping("/crearAuto")
    public List<Auto> crearAuto() {
        return autoService.generarXauto();
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Auto>> filtroPrecio(@RequestParam double precioMinimo, @RequestParam double precioMaximo) {
        List<Auto> autosFiltrados = autoService.filtroPrecio(precioMinimo, precioMaximo);
        if (autosFiltrados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(autosFiltrados);
    }
}
