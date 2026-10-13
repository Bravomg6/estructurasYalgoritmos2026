/*
Prompt inicial utilizado:
"Generame un programa en Java con una clase Alumno que tenga nombre y edad. Creá tres objetos y mostrá sus datos por pantalla."

Ajustes realizados:
Ninguno
*/

public class Ejercicio12 {

    public static void main(String[] args) {

        System.out.println("=== Gestión de alumnos ===");
        System.out.println();

        // Crea tres objetos Alumno usando el constructor.
        // Cada objeto es una instancia independiente con sus propios valores de atributo.
        Alumno student1 = new Alumno("Alice Johnson", 20);
        Alumno student2 = new Alumno("Bob Smith", 22);
        Alumno student3 = new Alumno("Carol Davis", 19);

        // Muestra los datos de cada alumno usando el método showInfo().
        System.out.println("--- Alumno 1 ---");
        student1.showInfo();

        System.out.println("--- Alumno 2 ---");
        student2.showInfo();

        System.out.println("--- Alumno 3 ---");
        student3.showInfo();

        // Demuestra el uso de los métodos getter individuales.
        System.out.println("=== Acceso a atributos individuales ===");
        System.out.println("Nombre del alumno 1: " + student1.getName());
        System.out.println("Edad del alumno 2:   " + student2.getAge());

        // Demuestra el uso de los métodos setter para modificar atributos.
        System.out.println();
        System.out.println("=== Modificación del alumno 3 ===");
        student3.setAge(20);
        System.out.println("Edad actualizada de " + student3.getName() + ": " + student3.getAge());
    }
}

// La clase Alumno encapsula los datos y el comportamiento de un alumno.
class Alumno {

    // Atributos privados: solo pueden accederse desde dentro de esta clase.
    // Este es el principio básico de la encapsulación.
    private String name;
    private int age;

    // Constructor: se llama automáticamente cuando se crea un nuevo objeto.
    // Inicializa los atributos con los valores proporcionados.
    public Alumno(String name, int age) {
        this.name = name;   // 'this' hace referencia al atributo del objeto actual
        this.age = age;
    }

    // Getter de name: permite leer el nombre desde código externo de forma segura.
    public String getName() {
        return this.name;
    }

    // Setter de name: permite modificar el nombre desde código externo de forma segura.
    public void setName(String name) {
        this.name = name;
    }

    // Getter de age: permite leer la edad desde código externo de forma segura.
    public int getAge() {
        return this.age;
    }

    // Setter de age: permite modificar la edad desde código externo con validación.
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            System.out.println("Error: edad no válida (" + age + "). La edad debe estar entre 1 y 149.");
        }
    }

    // Método que muestra toda la información del alumno.
    public void showInfo() {
        System.out.println("Nombre: " + this.name);
        System.out.println("Edad:   " + this.age);
        System.out.println();
    }
}
