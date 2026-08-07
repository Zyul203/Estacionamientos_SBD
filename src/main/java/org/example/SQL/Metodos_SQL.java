package org.example.SQL;
import org.example.Vehiculo;

import org.example.Auto;
import org.example.Camion;
import org.example.Moto;
import org.example.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

            // Creamos el objeto con el constructor para nuevos registros
            VehiculoSql nuevoRegistro = new VehiculoSql(placa, tipo, horas, tarifa  );

            int funcion = nuevoRegistro.save();
            //nuevoRegistro.save();

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

    public static void Mostrar_RegistrosAutos()
    {
        System.out.println("\n--- LISTA DE ESTACIONAMIENTOS DE AUTOS ---");

        try
        {
            List<VehiculoSql> autos = VehiculoSql.getAllAutos("Auto");

            if (autos.isEmpty())
            {
                System.out.println("No hay autos registrados en la base de datos.");
                return;
            }

            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s | %-15s | %-15s | %-5s | %-5s \n", "ID", "Placa", "Tipo", "Horas", "Tarifa");
            System.out.println("--------------------------------------------------------------------------------------------------");

            for (VehiculoSql a : autos)
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
            System.err.println("Error al consultar la lista de estacionamientos de autos: " + e.getMessage());
        }
    }


    public static void Mostrar_RegistrosCamiones()
    {
        System.out.println("\n--- LISTA DE ESTACIONAMIENTOS DE CAMIONES ---");

        try
        {
            List<VehiculoSql> camiones = VehiculoSql.getAllCamiones("Camion");

            if (camiones.isEmpty())
            {
                System.out.println("No hay camiones registrados en la base de datos.");
                return;
            }

            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s | %-15s | %-15s | %-5s | %-5s \n", "ID", "Placa", "Tipo", "Horas", "Tarifa");
            System.out.println("--------------------------------------------------------------------------------------------------");

            for (VehiculoSql a : camiones)
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
            System.err.println("Error al consultar la lista de estacionamientos de camiones: " + e.getMessage());
        }
    }

    public static void Buscar_ByPlaca()
    {
        System.out.println("\n--- BUSCAR REGISTRO DE ESTACIONAMIENTO ---");
        try
        {
            System.out.print("Ingrese la placa del vehiculo a buscar: ");
            String placa = sc.nextLine();

            // Guardar el objeto que retorna la búsqueda
            VehiculoSql v = VehiculoSql.Find(placa);

            // Verificar si existe y mostrar sus datos
            if (v != null) {
                System.out.println("\n--- VEHÍCULO ENCONTRADO ---");
                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.printf("%-5s | %-15s | %-15s | %-5s | %-5s \n", "ID", "Placa", "Tipo", "Horas", "Tarifa");
                System.out.printf("%-5s | %-15s | %-15s | %-5s | %-5s\n",
                        v.getId(),
                        v.getPlaca(),
                        v.getTipo(),
                        v.getHoras(),
                        v.getTarifa());
                System.out.println("--------------------------------------------------------------------------------------------------");

            } else {
                System.out.println("No se encontró ningún vehículo registrado con la placa: " + placa);
            }

        } catch (Exception e) {
            System.err.println("Error al buscar registro " + e.getMessage());
        }
    }

    public static void Mostrar_Total()
    {
        System.out.println("\n--- RECAUDACION TOTAL DE TARIFAS ---");
        try {
            double total = VehiculoSql.getSumaTarifas();
            System.out.printf("El total acumulado de las tarifas es: $%.2f\n", total);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}




