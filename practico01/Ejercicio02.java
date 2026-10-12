/*
Prompt inicial utilizado:
"Generame un ejemplo utilizando todos los tipos primitivos de Java con comentarios."

Ajustes realizados:
Ninguno
*/

public class Ejercicio02 {

    public static void main(String[] args) {

        // byte:  8-bit signed integer. Range: -128 to 127.
        byte smallNumber = 42;

        // short: 16-bit signed integer. Range: -32768 to 32767.
        short mediumNumber = 30000;

        // int: 32-bit signed integer. Most commonly used integer type.
        int age = 25;

        // long: 64-bit signed integer. Use 'L' suffix for large literals.
        long bigNumber = 9876543210L;

        // float: 32-bit floating point. Use 'f' suffix for float literals.
        // Less precise than double, uses less memory.
        float temperature = 23.5f;

        // double: 64-bit floating point. Default type for decimals.
        double pi = 3.141592653589793;

        // boolean: holds only true or false.
        boolean isActive = true;

        // char: 16-bit Unicode character. Written with single quotes.
        char grade = 'A';

        // Print all declared variables to the console.
        System.out.println("=== Primitive Types in Java ===");
        System.out.println("byte   smallNumber    = " + smallNumber);
        System.out.println("short  mediumNumber   = " + mediumNumber);
        System.out.println("int    age            = " + age);
        System.out.println("long   bigNumber      = " + bigNumber);
        System.out.println("float  temperature    = " + temperature);
        System.out.println("double pi            = " + pi);
        System.out.println("boolean isActive      = " + isActive);
        System.out.println("char   grade          = " + grade);

        // Demonstrate the size (in bits) of each primitive type.
        System.out.println();
        System.out.println("=== Size of each primitive type ===");
        System.out.println("byte:   " + Byte.SIZE   + " bits");
        System.out.println("short:  " + Short.SIZE  + " bits");
        System.out.println("int:    " + Integer.SIZE + " bits");
        System.out.println("long:   " + Long.SIZE   + " bits");
        System.out.println("float:  " + Float.SIZE  + " bits");
        System.out.println("double: " + Double.SIZE + " bits");
    }
}
