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

        System.out.println("=== Grade Evaluation ===");

        // Solicitar la calificación numérica al usuario.
        System.out.print("Enter the student's grade (0-10): ");
        int grade = scanner.nextInt();

        // Validar que la calificación este dentro del rango válido (0 a 10).
        if (grade < 0 || grade > 10) {
            System.out.println("Error: the grade must be between 0 and 10.");
        } else if (grade >= 9) {
            // Calificación 9 o 10: promocionado. (highest distinction).
            System.out.println("Status: PROMOTED. Excellent work!");
        } else if (grade >= 7) {
            // Grade 7 or 8: approved with good performance.
            System.out.println("Status: APPROVED. Good job!");
        } else if (grade >= 5) {
            // Grade 5 or 6: approved but needs reinforcement.
            System.out.println("Status: APPROVED. You should reinforce some topics.");
        } else {
            // Grade below 5: failed.
            System.out.println("Status: FAILED. You need to retake the exam.");
        }

        scanner.close();
    }
}
