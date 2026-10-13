/*
Prompt inicial utilizado:
Implementar un sistema de ranking que reciba un arreglo de jugadores con nombre y puntaje. Ordenar los jugadores de mayor a menor puntaje usando el algoritmo más adecuado. Entrada de ejemplo: Player("Ana", 1200), Player("Pedro", 900), Player("Lucia", 1500). El programa debe mostrar la lista original, el ranking ordenado y explicar por qué el algoritmo elegido es apropiado. Incluir una clase Player con los campos nombre y puntaje. Usar Selection Sort por simplicidad con conjuntos de datos pequeños. Verificar el resultado confirmando que los puntajes están en orden descendente.

Ajustes realizados:
Ninguno
*/

import java.util.Arrays;

public class Ejercicio10 {

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + " (" + score + ")";
        }
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Ana", 1200),
            new Player("Pedro", 900),
            new Player("Lucia", 1500),
            new Player("Juan", 1100),
            new Player("Maria", 1350)
        };

        System.out.println("=== Sistema de Ranking de Jugadores ===");
        System.out.println("Lista original:");
        printRanking(players);
        System.out.println();

        // Ordenar por puntaje de mayor a menor usando Selection Sort
        selectionSortDescending(players);

        System.out.println("Ranking ordenado (de mayor a menor):");
        printRanking(players);
        System.out.println();

        System.out.println("Algoritmo elegido: Selection Sort");
        System.out.println("Motivo: Para conjuntos de datos pequeños, Selection Sort es simple y realiza");
        System.out.println("como máximo n-1 intercambios, lo que lo eficientiza en sistemas de ranking donde");
        System.out.println("el número de jugadores es limitado. Para conjuntos de datos más grandes,");
        System.out.println("Quicksort o MergeSort serían más apropiados.");
    }

    static void selectionSortDescending(Player[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j].score > array[maxIndex].score) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                Player temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
    }

    static void printRanking(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("  " + (i + 1) + ". " + players[i]);
        }
    }
}
