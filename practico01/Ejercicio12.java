/*
Prompt inicial utilizado:
"Generame un programa en Java con una clase Alumno que tenga nombre y edad. Creá tres objetos y mostrá sus datos por pantalla."

Ajustes realizados:
Ninguno
*/

public class Ejercicio12 {

    public static void main(String[] args) {

        System.out.println("=== Student (Alumno) Management ===");
        System.out.println();

        // Create three Alumno objects using the constructor.
        // Each object is an independent instance with its own attribute values.
        Alumno student1 = new Alumno("Alice Johnson", 20);
        Alumno student2 = new Alumno("Bob Smith", 22);
        Alumno student3 = new Alumno("Carol Davis", 19);

        // Display the data of each student using the showInfo() method.
        System.out.println("--- Student 1 ---");
        student1.showInfo();

        System.out.println("--- Student 2 ---");
        student2.showInfo();

        System.out.println("--- Student 3 ---");
        student3.showInfo();

        // Demonstrate the use of individual getter methods.
        System.out.println("=== Accessing individual attributes ===");
        System.out.println("Name of student 1: " + student1.getName());
        System.out.println("Age of student 2:  " + student2.getAge());

        // Demonstrate the use of setter methods to modify attributes.
        System.out.println();
        System.out.println("=== Modifying student 3 ===");
        student3.setAge(20);
        System.out.println("Updated age of " + student3.getName() + ": " + student3.getAge());
    }
}

// The Alumno class encapsulates the data and behavior of a student.
class Alumno {

    // Private attributes: they can only be accessed from within this class.
    // This is the basic principle of encapsulation.
    private String name;
    private int age;

    // Constructor: called automatically when a new object is created.
    // It initializes the attributes with the provided values.
    public Alumno(String name, int age) {
        this.name = name;   // 'this' refers to the current object's attribute
        this.age = age;
    }

    // Getter for name: allows external code to read the name safely.
    public String getName() {
        return this.name;
    }

    // Setter for name: allows external code to modify the name safely.
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age: allows external code to read the age safely.
    public int getAge() {
        return this.age;
    }

    // Setter for age: allows external code to modify the age with validation.
    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            System.out.println("Error: invalid age (" + age + "). Age must be between 1 and 149.");
        }
    }

    // Method that displays all the student's information.
    public void showInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Age:  " + this.age);
        System.out.println();
    }
}
