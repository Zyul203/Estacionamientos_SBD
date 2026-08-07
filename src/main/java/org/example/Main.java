package org.example;
import org.example.SQL.Metodos_SQL;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do
        {
            System.out.println("\n=== MENÚ DE GESTIÓN DE ESTACIONAMIENTOS ===");
            System.out.println("1. Registrar estacionamiento de vehiculo");
            System.out.println("2. Eliminar registro de estacionamiento de vehiculo");
            System.out.println("3. Mostrar registros de estacionamiento de motos");
            System.out.println("4. Mostrar registros de estacionamientos de autos");
            System.out.println("4. Mostrar registros de estacionamiento camiones");
            System.out.println("5. Mostrar total de tarifas");
            System.out.println("6. Buscar registro de estacionamiento mediante la placa del vehiculo");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion)
            {
                case 1 -> Metodos_SQL.CrearRegistro();
                case 2 -> Metodos.Mostrar_AlumnosTodos();
                case 3 -> Metodos.Mostrar_Alumnos15Y();
                case 4 -> Metodos.EliminarAlumnoM();
                case 5 -> Metodos.ActualizarAlumnoM();
                case 6 -> Metodos.ContarPorSexo();
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }









    /*
        // Crear el estacionamiento
        Estacionamiento Parking = new Estacionamiento();

        // Registrar diferentes tipos de vehículos con sus respectivas horas
        Parking.registrarVehiculo(new Auto("ABC-123", 3));     // 3 horas * $2 = $6.00
        Parking.registrarVehiculo(new Moto("XYZ-987", 5));     // 5 horas * $1 = $5.00
        Parking.registrarVehiculo(new Camion("TRK-555", 4));   // (4 horas * $4) + $5 = $21.00
        Parking.registrarVehiculo(new Auto("DEF-456", 2));     // 2 horas * $2 = $4.00
        System.out.println("");

        Parking.MostrarVehiculos();

        Parking.imprimirReporteDiario();


    */


}

//Una interfaz me obliga