package org.example.SQL;
import org.example.Vehiculo;

import org.example.Auto;
import org.example.Camion;
import org.example.Moto;
import org.example.Vehiculo;

import java.util.List;
import java.util.Scanner;

public class Metodos_SQL
{

    private static Scanner sc = new Scanner(System.in);


    // --- OPCIÓN 1: CREAR ALUMNOS ---
    public static void CrearRegistro()
    {
        System.out.println("\n--- REGISTRAR ESTACIONAMIENTO ---");
        try
        {
            String placa, tipo;
            int horas;

            System.out.print("Placa: ");
            placa = sc.nextLine();

            System.out.print("Tipo (Auto, Moto, Camion): ");
            tipo = sc.nextLine();

            System.out.print("Horas: ");
            horas = Integer.parseInt(sc.nextLine());

           Vehiculo vehiculo = null;
           if (tipo.equalsIgnoreCase("Auto")) {vehiculo = new Auto(placa, horas);}
           else if (tipo.equalsIgnoreCase("Moto")) {vehiculo = new Moto(placa, horas);}
          else if (tipo.equalsIgnoreCase("Camion")) {vehiculo = new Camion(placa, horas);}

            double tarifa = vehiculo.calcularCostoEstacionamiento();

            VehiculoSql nuevoRegistro = new VehiculoSql(placa, tipo, horas, tarifa  );
            // Creamos el objeto con el constructor para nuevos registros

            // Se usa la función .save() para crear nuevos registros
            int funcion = nuevoRegistro.save();

            //Mensaje por si se inserto o no el registro
            if (funcion > 0) System.out.println("Registro guardado exitosamente con ID: " + nuevoRegistro.getId());

        } catch (Exception e) {
            System.err.println("Error al registrar el estacionamiento " + e.getMessage() + "\n");
        }
    }

    // --- OPCIÓN 4: ELIMINAR ALUMNOS  ---
    public static void Eliminar_Registro()
    {
        System.out.println("\n--- ELIMINAR ESTACIONAMIENTOS REGISTRADOS ---");
        try
        {
            System.out.println("Ingrese el id aa eliminar");
            int id = Integer.parseInt(sc.nextLine());

            int eliminado = VehiculoSql.deletebyId(id);
            if (eliminado > 0) System.out.println("Registro con el ID " + id + " eliminado correctamente");

        } catch (Exception e) {
            System.err.println("Error al eliminar registro " + e.getMessage());
        }
    }

    public static void Mostrar_RegistrosMotos()
    {
        System.out.println("\n--- LISTA DE ESTACIONAMIENTOS DE MOTOS ---");

        try
        {
            List<VehiculoSql> motos = VehiculoSql.getAllMotos("Moto");

            if (motos.isEmpty())
            {
                System.out.println("No hay alumnos registrados en la base de datos.");
                return;
            }

            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s | %-15s | %-15s | %-5s | %-5s \n", "ID", "Placa", "Tipo", "Horas", "Tarifa");
            System.out.println("--------------------------------------------------------------------------------------------------");

            for (VehiculoSql a : motos)
            {
                System.out.printf("%-5s | %-15s | %-15s | %-5s | %-5s\n",
                        a.getId(),
                        a.getPlaca(),
                        a.getTipo(),
                        a.getHoras(),
                        a.getTarifa());
            }
            System.out.println("--------------------------------------------------------------------------------------------------");

        } catch (Exception e) {
            System.err.println("Error al consultar la lista de estacionamientos de motos: " + e.getMessage());
        }
    }


}
