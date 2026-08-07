package org.example.SQL;

import java.util.Scanner;

public class Metodos_SQL
{

    private static Scanner sc = new Scanner(System.in);


    // --- OPCIÓN 1: CREAR ALUMNOS ---
    public static void CrearRegistro()
    {
        System.out.println("\n--- REGISTRAR NUEVO REGISTRO DE ESTACIONAMIENTO ---");
        try
        {
            String placa, tipo;
            int horas;
            double total;

            System.out.print("Placa: ");
            placa = sc.nextLine();

            System.out.print("Tipo: ");
            tipo = sc.nextLine();

            System.out.print("Horas: ");
            horas = Integer.parseInt(sc.nextLine());

            System.out.print("Total: ");
            total = Double.parseDouble(sc.nextLine());

            // Creamos el objeto con el constructor para nuevos registros
            VehiculoSql nuevoRegistro = new VehiculoSql(placa, tipo, horas, total);

            // Se usa la función .save() para crear nuevos registros
            int funcion = nuevoRegistro.save();

            //Mensaje por si se inserto o no el registro
            if (funcion > 0) System.out.println("Registro guardado exitosamente con ID: " + nuevoRegistro.getId());

        } catch (Exception e) {
            System.err.println("Error al registrar el alumno " + e.getMessage() + "\n");
        }
    }

}
