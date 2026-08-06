package org.example.SQL;

import java.util.Scanner;

public class Metodos_SQL
{

    private static Scanner sc = new Scanner(System.in);

    // --- OPCIÓN 1: CREAR ALUMNOS ---
    public static void CrearVehiculo()
    {
        System.out.println("\n--- REGISTRAR NUEVO ALUMNO ---");
        try
        {
            String placa, tipo;
            int horas;
            double total;

            System.out.print("Matrícula: ");
            matricula = Integer.parseInt(sc.nextLine()); //Se escribe asi para evitar un sc.nextLine() para eliminar el buffer, es mejor asi

            System.out.print("Nombre: ");
            nombre = sc.nextLine();

            System.out.print("Edad: ");
            edad = Integer.parseInt(sc.nextLine());

            System.out.print("Sexo (F/M): ");
            sexo = sc.nextLine();

            System.out.print("Correo: ");
            correo = sc.nextLine();

            // Creamos el objeto con el constructor para nuevos registros
            VehiculoSql nuevoVehiculo = new VehiculoSql(matricula, tipo, horas, total);

            // Se usa la función .save() para crear nuevos registros
            int funcion = nuevoVehiculo.save();

            //Mensaje por si se inserto o no el registro
            if (funcion > 0) System.out.println("Alumno guardado exitosamente con ID: " + nuevoVehiculo.getID();

        } catch (Exception e) {
            System.err.println("Error al registrar el alumno " + e.getMessage() + "\n");
        }
    }

}
