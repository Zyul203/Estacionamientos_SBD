package org.example;

public class Moto extends Vehiculo
{
    public Moto(String placa, int horasEstacionado) {
        super(placa, horasEstacionado, new TarifaMoto());
    }


    @Override
    public String toString()
    {
        return "Tipo: Moto | Placa: " + placa +  " | Horas: " + horasEstacionado + " | Tarifa: $" + calcularCostoEstacionamiento();
    }


}
