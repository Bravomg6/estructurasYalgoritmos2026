/*
Prompt inicial utilizado:
"Generame un ejemplo utilizando todos los tipos primitivos de Java con comentarios."

Ajustes realizados:
Ninguno
*/

public class Ejercicio02 {

    public static void main(String[] args) {

        // byte: entero con signo de 8 bits. Rango: -128 a 127.
        byte smallNumber = 42;

        // short: entero con signo de 16 bits. Rango: -32768 a 32767.
        short mediumNumber = 30000;

        // int: entero con signo de 32 bits. Tipo entero más utilizado.
        int age = 25;

        // long: entero con signo de 64 bits. Use el sufijo 'L' para literales grandes.
        long bigNumber = 9876543210L;

        // float: punto flotante de 32 bits. Use el sufijo 'f' para literales float.
        // Menos preciso que double, ocupa menos memoria.
        float temperature = 23.5f;

        // double: punto flotante de 64 bits. Tipo predeterminado para decimales.
        double pi = 3.141592653589793;

        // boolean: solo almacena true o false.
        boolean isActive = true;

        // char: carácter Unicode de 16 bits. Se escribe entre comillas simples.
        char grade = 'A';

        // Imprime todas las variables declaradas en la consola.
        System.out.println("=== Tipos primitivos en Java ===");
        System.out.println("byte   smallNumber    = " + smallNumber);
        System.out.println("short  mediumNumber   = " + mediumNumber);
        System.out.println("int    age            = " + age);
        System.out.println("long   bigNumber      = " + bigNumber);
        System.out.println("float  temperature    = " + temperature);
        System.out.println("double pi            = " + pi);
        System.out.println("boolean isActive      = " + isActive);
        System.out.println("char   grade          = " + grade);

        // Muestra el tamaño (en bits) de cada tipo primitivo.
        System.out.println();
        System.out.println("=== Tamaño de cada tipo primitivo ===");
        System.out.println("byte:   " + Byte.SIZE   + " bits");
        System.out.println("short:  " + Short.SIZE  + " bits");
        System.out.println("int:    " + Integer.SIZE + " bits");
        System.out.println("long:   " + Long.SIZE   + " bits");
        System.out.println("float:  " + Float.SIZE  + " bits");
        System.out.println("double: " + Double.SIZE + " bits");
    }
}
