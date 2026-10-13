/*
Prompt inicial utilizado:
"Generame un programa en Java que solicite una nota e indique si el alumno aprobó, promocionó o desaprobó."

Ajustes realizados:
Ninguno
*/

import java.util.Scanner;

public class Ejercicio05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Evaluación de nota ===");

        // Solicita al usuario la nota numérica.
        System.out.print("Ingrese la nota del alumno (0-10): ");
        int grade = scanner.nextInt();

        // Valida que la nota esté dentro del rango válido (0 a 10).
        if (grade < 0 || grade > 10) {
            System.out.println("Error: la nota debe estar entre 0 y 10.");
        } else if (grade >= 9) {
            // Nota 9 o 10: promocionó (máxima distinción).
            System.out.println("Estado: PROMOCIONÓ. ¡Excelente trabajo!");
        } else if (grade >= 7) {
            // Nota 7 u 8: aprobó con buen desempeño.
            System.out.println("Estado: APROBÓ. ¡Buen trabajo!");
        } else if (grade >= 5) {
            // Nota 5 o 6: aprobó pero necesita refuerzo.
            System.out.println("Estado: APROBÓ. Conviene reforzar algunos temas.");
        } else {
            // Nota menor a 5: desaprobó.
            System.out.println("Estado: DESAPROBÓ. Es necesario rendir el examen nuevamente.");
        }

        scanner.close();
    }
}
