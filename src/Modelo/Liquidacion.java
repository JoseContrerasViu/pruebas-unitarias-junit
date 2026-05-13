package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Liquidacion {
    private String concepto;
    private double importeBase;
    private List<Double> impuestos;

    public Liquidacion(String concepto, double importeBase) {
        this.concepto = concepto;
        this.importeBase = importeBase;
        this.impuestos = new ArrayList<>();
    }

    public void añadirImpuesto(double porcentaje) {
        impuestos.add(porcentaje);
    }

    public double calcularTotal() {
        double total = importeBase;
        for (double impuesto : impuestos) {
            total += importeBase * (impuesto / 100);
        }
        return total;
    }

    public String getConcepto() {
        return concepto;
    }
}