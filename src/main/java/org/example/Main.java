package org.example;
import org.example.SQL.Metodos_SQL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE GESTIÓN DE ESTACIONAMIENTOS ===");
            System.out.println("1. Registrar estacionamiento de vehiculo");
            System.out.println("2. Eliminar registro de estacionamiento de vehiculo");
            System.out.println("3. Mostrar registros de estacionamiento de motos");
            System.out.println("4. Mostrar registros de estacionamientos de autos");
            System.out.println("5. Mostrar registros de estacionamiento camiones");
            System.out.println("6. Mostrar total de tarifas");
            System.out.println("7. Buscar registro de estacionamiento mediante la placa del vehiculo");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> Metodos_SQL.CrearRegistro();
                case 2 -> Metodos_SQL.Eliminar_Registro();
                case 3 -> Metodos_SQL.Mostrar_RegistrosMotos();
                case 4 -> Metodos_SQL.Mostrar_RegistrosAutos();
                case 5 -> Metodos_SQL.Mostrar_RegistrosCamiones();
                //case 6 -> Metodos_SQL.Mostrar_Total();
                case 7 -> Metodos_SQL.Buscar_ByPlaca();
                case 8 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 8);
    }
}