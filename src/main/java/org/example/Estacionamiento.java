package org.example;

import java.util.ArrayList;

public class Estacionamiento
{
    private ArrayList<Vehiculo> listaVehiculos;

    public Estacionamiento()
    {
        this.listaVehiculos = new ArrayList<>();
    }

    // Metodo para registrar vehículos (acepta Auto, Moto o Camion)
    public void registrarVehiculo(Vehiculo vehiculo)
    {
        listaVehiculos.add(vehiculo);
        System.out.println("Vehículo con placa [" + vehiculo.getPlaca() + "] registrado con éxito.");
    }



    public void MostrarVehiculos()
    {
        for (Vehiculo v : listaVehiculos) { System.out.print(v.toString() + "\n"); }
        if (listaVehiculos.isEmpty())
        {
            System.out.println("No hay vehículos registrados registrados...");
        }
    }


    // Metodo para generar el reporte general en consola
    public void imprimirReporteDiario()
    {
        System.out.println("\n=============================================");
        System.out.println("     REPORTE DIARIO DE ESTACIONAMIENTO       ");
        System.out.println("=============================================");

        double totalRecaudado = 0.0;

        for (Vehiculo v : listaVehiculos)
        {
            double costo = v.calcularCostoEstacionamiento();
            totalRecaudado += costo;

            // Obtenemos el nombre de la clase (Auto, Moto, Camion) para el reporte
            String tipoVehiculo = v.getClass().getSimpleName();

            System.out.printf("Tipo: " + tipoVehiculo + " | Placa: " + v.getPlaca() + " | Horas: " + v.getHorasEstacionado()  + " | Total: $%.2f USD\n", costo);
        }

        System.out.println("---------------------------------------------");
        System.out.printf("TOTAL RECAUDADO EN EL DÍA: $%.2f USD\n", totalRecaudado);
        System.out.println("=============================================\n");
    }





}
