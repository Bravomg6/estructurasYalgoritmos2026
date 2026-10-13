/*
Prompt inicial utilizado:
Implementar una función recursiva que invierta una cadena de caracteres (String).
El caso base es una cadena vacía o un solo carácter — ya está invertida.
Separar el primer carácter del resto mediante substring. Reducir el problema
invirtiendo el resto y agregando el primer carácter al final.
Reconstrucción: reverse(rest) + firstChar. Probar con "a", "ab", "hello", "recursion".
Esperado: "a", "ba", "olleh", "noisrucer".

Ajustes realizados:
Ninguno
*/

public class Ejercicio08 {

    public static String reverse(String s) {
        // Caso base: cadena vacía o un solo carácter ya está invertida
        if (s == null || s.length() <= 1) {
            return s;
        }
        // Caso recursivo: invertir el resto y luego agregar el primer carácter
        return reverse(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println("=== Ejercicio 8: Invertir una palabra ===");

        String[] testValues = {"a", "ab", "hello", "recursion"};
        String[] expected = {"a", "ba", "olleh", "noisrucer"};

        for (int i = 0; i < testValues.length; i++) {
            String result = reverse(testValues[i]);
            System.out.println("reverse(\"" + testValues[i] + "\") = \"" + result
                    + "\" (esperado: \"" + expected[i] + "\") "
                    + (result.equals(expected[i]) ? "CORRECTO" : "INCORRECTO"));
        }
    }
}
