/*
Prompt inicial utilizado:
Implement a ranking system that receives an array of players with name and score. Sort the players from highest to lowest score using the most appropriate sorting algorithm. Example input: Player("Ana", 1200), Player("Pedro", 900), Player("Lucia", 1500). The program should display the original list, the sorted ranking, and explain why the chosen algorithm is appropriate. Include a Player class with name and score fields. Use Selection Sort for simplicity with small datasets. Verify the result by confirming scores are in descending order.

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

        System.out.println("=== Player Ranking System ===");
        System.out.println("Original list:");
        printRanking(players);
        System.out.println();

        // Sort by score descending using Selection Sort
        selectionSortDescending(players);

        System.out.println("Sorted ranking (highest to lowest):");
        printRanking(players);
        System.out.println();

        System.out.println("Algorithm choice: Selection Sort");
        System.out.println("Reason: For small datasets, Selection Sort is simple and performs");
        System.out.println("at most n-1 swaps, making it efficient for ranking systems where");
        System.out.println("the number of players is limited. For larger datasets, Quicksort");
        System.out.println("or MergeSort would be more appropriate.");
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
