import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<String> usuarios = new ArrayList<>();
    static ArrayList<String> contraseñas = new ArrayList<>();
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
                System.out.println("Cargando...");
                System.out.println(" ");
                iniciosesion(1);
            }

            case 2 -> {
                System.out.println("-- Usuario normal --");
                System.out.println("Cargando...");
                System.out.println(" ");
                iniciosesion(2);
            }

            default ->{
                System.out.println("Esta opcion no existe :( ");
                menu();
            }

        }

    }
    // Este es el inicio de sesión
    public static void iniciosesion(int opc){
        Scanner leer = new Scanner (System.in);

        String UserAdmin = "admin";
        String passwordAd = "1234";

        switch(opc){
            case 1 -> {// administrador

                int  intentos = 3;

                while(intentos>0){

                    System.out.println("Ingrese nombre del usuario");
                    UserAdmin = leer.nextLine();

                    System.out.println("ingrese su contraseña");
                    passwordAd = leer.nextLine();

                    if (UserAdmin.equals("admin") && passwordAd.equals("1234")){
                        System.out.println("bienvenido administrador");
                        MenuAd();
                        return;
                    }else{
                        intentos--;
                        System.out.println("contraseña incorrecta porfavor intente denuevo");
                        System.out.println("intentos restantes: "+intentos);
                    }
                }
                System.out.println("Superaste el limite de intentos");
                System.out.println("Regresando al menu...");
                menu();
            }
            case 2->{//usuario // hacer contador y limite de intentos
                int eleccion = 0;
                System.out.println("¿que desea hacer?");

                System.out.println(" ");

                System.out.println("1.-crear usuario");
                System.out.println("2.-iniciar sesion");
                eleccion = leer.nextInt();
                leer.nextLine();

                if (eleccion == 1){ // primera opcion crear usuario
                    System.out.println("ingrese su nombre de usuario a crear: ");
                    String username = leer.nextLine();

                    System.out.println("ingrese contraseña: ");
                    String passwordUser = leer.nextLine();

                    usuarios.add(username);
                    contraseñas.add(passwordUser);

                    System.out.println("Su usuario a sido creado correctamente");
                    menu();

                }else if (eleccion == 2){// segunda opcion iniciar sesion
                    int intentos = 3;

                    while (intentos > 0) {

                        System.out.println("Ingrese su usuario");
                        String username = leer.nextLine();

                        System.out.println("Ingrese su contraseña");
                        String passwordUser = leer.nextLine();

                        boolean Found = false;

                        for(int i = 0 ; i< usuarios.size();i++){
                            if(username.equals(usuarios.get(i)) && passwordUser.equals(contraseñas.get(i))){
                                Found = true;
                                break;

                            }
                        }
                        if(Found){
                            System.out.println("Bienvenido a nuestra biblioteca");
                            MenuUser();
                            return;
                        }else{
                            intentos--;
                            System.out.println("Usuario o contraseña incorrectos");
                            System.out.println("intentos restantes: "+intentos);
                        }

                    }

                }else{
                    System.out.println("Esta opcion no existe");
                    iniciosesion(2);
                }
            }
        }
    }
    public static void MenuAd(){// menu de administrador

    }
    public static void MenuUser(){// menu de usuario

    }

    // Este es mi comentario
}