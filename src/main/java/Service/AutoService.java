package Service;

import Model.Auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoService {

    private final String[] marcaAuto = {"Mazda", "Honda", "Nissan", "Chevrolet", "Jaguar"};
    private final String[] colorAuto = {"Blanco", "Negro Matte", "Azul Matte", "Burdeo", "Plateado"};
    private final String [] tipoAuto = {"Sedan", "SUV", "Camioneta"};
    private final String [] sedanMotor = {"1.4cc", "1.6cc", "2.0cc"};
    private final String [] suvMotor = {"1.8cc", "2.2cc", "2.8cc"};
    private final String [] camionetaMotor = {"2.4cc", "3.0cc", "4.0cc"};

    public List<Auto> crearAuto(int autos) {
        List<Auto> auto1 = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < autos; i++) {
            Auto auto = new Auto();

        }

        return auto1;
    }
}
