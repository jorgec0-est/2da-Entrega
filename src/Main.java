import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Empieza todo

        menu();


    }



    // Este es el menú principal
    public static void menu(){
        Scanner leer = new Scanner(System.in);
        int opc;
        System.out.println("----------------");
        System.out.println("-- Seleccione opción --");
        System.out.println("1. Usuario admin");
        System.out.println("2. Usuario normal");
        opc = leer.nextInt();
        switch (opc){
            // Admin
            case 1 -> {
                System.out.println("-- Usuario admin --");

            }

            case 2 -> {
                System.out.println("-- Usuario normal --");
            }

        }

    }
    // Este es el inicio de sesión
}