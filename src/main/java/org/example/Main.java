package org.example;

public class Main
{
    static void main()
    {
        // Crear el estacionamiento
        Estacionamiento Parking = new Estacionamiento();

        // Registrar diferentes tipos de vehículos con sus respectivas horas
        Parking.registrarVehiculo(new Auto("ABC-123", 3));     // 3 horas * $2 = $6.00
        Parking.registrarVehiculo(new Moto("XYZ-987", 5));     // 5 horas * $1 = $5.00
        Parking.registrarVehiculo(new Camion("TRK-555", 4));   // (4 horas * $4) + $5 = $21.00
        Parking.registrarVehiculo(new Auto("DEF-456", 2));     // 2 horas * $2 = $4.00
        System.out.println("");

        Parking.MostrarVehiculos();

        //Parking.imprimirReporteDiario();



    }


}

//Una interfaz me obliga