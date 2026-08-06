package org.example;

public class Auto extends Vehiculo
{
    public Auto(String placa, int horasEstacionado)
    {
        // Al nacer un Auto, se le asigna obligatoriamente la TarifaAuto
        super(placa, horasEstacionado, new TarifaAuto());
    }


    @Override
    public String toString()
    {
        return "Tipo: Auto | Placa: " + placa +  " | Horas: " + horasEstacionado + " | Tarifa: $" + tarifa;
    }
}
