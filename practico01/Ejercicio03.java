/*
Prompt inicial utilizado:
"Generame un programa que solicite nombre y edad utilizando Scanner."

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio03 {

    public static void main(String[] args) {

        // Crea un objeto Scanner que lee la entrada desde la consola (System.in).
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Registro de usuario ===");

        // Pide al usuario que ingrese su nombre y lee la entrada como String.
        System.out.print("Ingrese su nombre: ");
        String name = scanner.nextLine();

        // Pide al usuario que ingrese su edad y lee la entrada como un entero.
        System.out.print("Ingrese su edad: ");
        int age = scanner.nextInt();

        // Muestra un mensaje personalizado con los datos ingresados por el usuario.
        System.out.println();
        System.out.println("¡Hola, " + name + "! Tienes " + age + " años.");

        // Mensaje condicional según la edad.
        if (age >= 18) {
            System.out.println("Eres mayor de edad.");
        } else {
            System.out.println("Eres menor de edad.");
        }

        // Cierra siempre el Scanner para liberar los recursos del sistema.
        scanner.close();
    }
}
