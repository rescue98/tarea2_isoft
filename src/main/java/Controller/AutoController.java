package Controller;

import Model.Auto;
import Service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutoController {

    private final AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("/crearAuto")
    public List<Auto> crearAuto(){
        return autoService.generarXauto();
    }

    @GetMapping("/filtroPrecio")
    public List<Auto> crearFiltroPrecio(){
        List<Auto> auto1 = autoService.generarXauto();
        return autoService.filtroPrecio(auto1);
    }
}
