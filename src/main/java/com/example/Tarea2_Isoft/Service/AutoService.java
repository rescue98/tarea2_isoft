package com.example.Tarea2_Isoft.Service;

import com.example.Tarea2_Isoft.Model.Auto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class AutoService {

    private List<Auto> autos = new ArrayList<>();


    private final String[] marcaAuto = {"Mazda", "Honda", "Nissan", "Chevrolet", "Jaguar"};
    private final String[] colorAuto = {"Blanco", "Negro Matte", "Azul Matte", "Burdeo", "Plateado"};
    private final String [] tipoAuto = {"Sedan", "SUV", "Camioneta"};
    private final String [] sedanMotor = {"1.4cc", "1.6cc", "2.0cc"};
    private final String [] suvMotor = {"1.8cc", "2.2cc", "2.8cc"};
    private final String [] camionetaMotor = {"2.4cc", "3.0cc", "4.0cc"};

    public List<Auto> generarXauto(){
        int cantidad = 30;

        if(cantidad > 0){
            List<Auto> auto1 = crearAuto(cantidad);
            return auto1;
        }else{
            System.out.println("la cantidad ingresada no es valida");
            return new ArrayList<>();
        }
    }

    public List<Auto> crearAuto(int autos) {
        List<Auto> auto1 = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < autos; i++) {
            Auto auto = new Auto();
            auto.setIdAuto(i+1);
            auto.setMarcaAuto(marcaAuto[r.nextInt(marcaAuto.length)]);
            auto.setAnioAuto(2015 + r.nextInt(9)); // Utiliza el método setAnioAuto() en su lugar
            auto.setColorAuto(colorAuto[r.nextInt(colorAuto.length)]);
            auto.setPrecioAuto(8000000 + r.nextInt(22000000));
            auto.setTurbo(r.nextBoolean());
            auto.setTipoAuto(tipoAuto[r.nextInt(tipoAuto.length)]);

            if (auto.getTipoAuto().equals("Sedan")) {
                auto.setMotorAuto(sedanMotor[r.nextInt(sedanMotor.length)]);
            } else if (auto.getTipoAuto().equals("Camioneta")) {
                auto.setMotorAuto(camionetaMotor[r.nextInt(camionetaMotor.length)]);
                auto.setCabina(r.nextInt(2) + 1);
            } else if (auto.getTipoAuto().equals("SUV")) {
                auto.setMotorAuto(suvMotor[r.nextInt(suvMotor.length)]);
                auto.setSunroof(r.nextBoolean());
            }

            auto.setPopularidad(0);

            auto1.add(auto);
        }

        return auto1;
    }

    public List<Auto> filtroPrecio(double precioMinimo, double precioMaximo) {
        return autos.stream()
                .filter(auto -> auto.getPrecioAuto() >= precioMinimo && auto.getPrecioAuto() <= precioMaximo)
                .collect(Collectors.toList());
    }
}
