import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Funciona para todos los métodos del Main
    static Scanner leer = new Scanner(System.in);
    static int opc;
    static ArrayList<String> usuarios = new ArrayList<>();
    static ArrayList<String> contraseñas = new ArrayList<>();
    static ArrayList<String> libros = new ArrayList<>(); // guarda los nombres de los libros
    static ArrayList<String> autores = new ArrayList<>();// guarda el autor de cada libro
    static ArrayList<Boolean> disponible = new ArrayList<>();// guarda el estado del libro : true si el libro esta y false si el libro se lo llevaron prestado

    static int UserOnline = -1;

    public static void main(String[] args) {
        libros.add("Papelucho ");
        autores.add("Marcela Paz");
        disponible.add(true);

        // Empieza todo
        menu();
    }

    // Este es el menú principal
    public static void menu() {
        do {
            System.out.println("----------------");
            System.out.println("-- Seleccione opción --");
            System.out.println("1. Usuario admin");
            System.out.println("2. Usuario normal");
            System.out.println("3. Salir");
            System.out.print("> ");
            // VADILACIÓN
            if (leer.hasNextInt()) {
                opc = leer.nextInt();
                leer.nextLine(); // Poner esto siempre después de ingresar un dato int
                switch (opc) {
                    // Admin
                    case 1 -> {
                        System.out.println("-- Usuario admin --");
                        System.out.println(" ");
                        inicioSesion(1);
                        return;
                    }

                    case 2 -> {
                        System.out.println("-- Usuario normal --");
                        System.out.println(" ");
                        inicioSesion(2);
                        return;
                    }
                    case 3 -> {
                        System.out.println("Saliendo . . .");
                        return;
                    }
                    default -> System.out.println("Opción inválida ");
                }
            } else {
                System.out.println("Opción inválida");
                leer.nextLine(); // Poner esto para que causar un ciclo infinito
            }
        } while (true);
    }

    // Este es el inicio de sesión
    public static void inicioSesion(int opc) {
        // Solo un usuario admin
        String UserAdmin = "admin";
        String passwordAd = "1234";

        switch (opc) {
            case 1 -> {// administrador

                int intentos = 3;
                while (intentos > 0) {

                    System.out.println("Ingrese nombre del usuario");
                    UserAdmin = leer.nextLine();

                    System.out.println("ingrese su contraseña");
                    passwordAd = leer.nextLine();

                    if (UserAdmin.equals("admin") && passwordAd.equals("1234")) {
                        System.out.println("-- Bienvenido administrador --");
                        MenuAd();
                        return;
                    } else {
                        intentos--;
                        System.out.println("contraseña incorrecta porfavor intente denuevo");
                        System.out.println("intentos restantes: " + intentos);
                    }
                }
                System.out.println("Superaste el limite de intentos");
                System.out.println("Regresando al menu...");
                menu();
            }
            case 2 -> {
                //usuario // hacer contador y limite de intentos
                int eleccion = 0;
                System.out.println("¿que desea hacer?");

                System.out.println(" ");

                System.out.println("1.-iniciar sesion");
                System.out.println("2.-Regresar al menu");
                eleccion = leer.nextInt();
                leer.nextLine();

                if (eleccion == 1) { // primera opcion crear usuario
                    int intentos = 3;

                    while (intentos > 0) {
                        System.out.println("--Iniciar sesion--");
                        System.out.println(" ");
                        System.out.println("Ingrese su usuario");
                        String username = leer.nextLine();

                        System.out.println("Ingrese su contraseña");
                        String passwordUser = leer.nextLine();

                        boolean Found = false;

                        for (int i = 0; i < usuarios.size(); i++) {
                            if (username.equals(usuarios.get(i)) && passwordUser.equals(contraseñas.get(i))) {
                                Found = true;
                                UserOnline = i;
                                break;

                            }
                        }
                        if (Found) {
                            System.out.println("Bienvenido a nuestra biblioteca");
                            MenuUser();
                            return;
                        } else {
                            intentos--;
                            System.out.println("Usuario o contraseña incorrectos");
                            System.out.println("intentos restantes: " + intentos);
                        }

                    }

                } else if (eleccion == 2){//regresar al menu
                    System.out.println("regresando al menu...");
                   menu();

                } else {
                    System.out.println("Esta opcion no existe");
                    inicioSesion(2);
                }
            }
        }
    }

    // menu admin
    public static void MenuAd() {// menu de administrador
        do {
            System.out.println("seleccione lo que desee realizar");
            System.out.println("1. Gestionar libro");
            System.out.println("2. Gestionar usuario");
            System.out.println("3. Gestionar préstamos y devoluciones");
            System.out.println("4. Salir");
            System.out.print("> ");// es para decirle al usuario donde escribir no mas

            if (leer.hasNextInt()) {//para preguntar si tiene un numero entero (has)
                opc = leer.nextInt();
                leer.nextLine();

                switch (opc) {
                    case 1 -> gestionLibro();
                    case 2 -> gestionUsuario();
                    case 3 -> gestionarPrestYDev();
                    case 4 -> {
                        System.out.println("Cerrando sesión ");
                        menu();
                        return;
                    }
                    default -> System.out.println("opcion no valida");
                }

            } else {
                System.out.println("Por favor , ingrese un numero valido");
                leer.nextLine();
            }
        } while (true);


    }

    public static void registrarAlumno(){//para crear nuevas cuentas de estudiantes
        System.out.println("Registro nuevo alumno");
        System.out.println("ingrese el nombre de usuario del alumno");
        String nuevoUser= leer.nextLine();

        System.out.println("asigne una contraseña para el alumno");
        String nuevaPass = leer.nextLine();

        usuarios.add(nuevoUser);
        contraseñas.add(nuevaPass);
        System.out.println("la cuenta ha sido creada con existo");
    }

    public static void MenuUser() {// menu de usuario

    }

    public static void gestionLibro(){

    }

    // gestion de usuario del menú admin
    public static void gestionUsuario(){
        do {
            System.out.println("-- Gestión de usuarios --");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Sancionar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Ver usuarios");
            System.out.println("5. Salir");
            System.out.print("> ");

            if (leer.hasNextInt()) {
                opc = leer.nextInt();
                leer.nextLine();

                switch (opc) {
                    case 1 -> {
                        System.out.println("Agregar usuario");
                        // aquí llamas tu método o lógica
                        registrarAlumno();
                    }

                    case 2 -> {
                        System.out.println("Sancionar usuario");

                    }

                    case 3 -> {
                        System.out.println("Eliminar usuario");
                        for (int i = 0; i < usuarios.size(); i++) {
                            System.out.println(i + ".- " + usuarios.get(i));
                        }

                        System.out.println("Seleccione usuario que desea eliminar:");
                        System.out.print("> ");

                        if (leer.hasNextInt()) {
                            int index = leer.nextInt();
                            leer.nextLine();
                            if (index >= 0 && index < usuarios.size()) {
                                System.out.println("Usuario eliminado: " + usuarios.get(index));
                                usuarios.remove(index);
                                contraseñas.remove(index);
                            } else {
                                System.out.println("Índice inválido");
                            }

                        } else {
                            System.out.println("Debe ingresar un número");
                            leer.nextLine();
                        }
                    }

                    case 4 -> {
                        System.out.println("Lista de usuarios:");
                        // for each
                        for (String u : usuarios) {
                            System.out.println("- " + u);
                        }
                    }

                    case 5 -> {
                        System.out.println("Saliendo de gestión de usuarios...");
                        return;
                    }

                    default -> System.out.println("Opción inválida");
                }
            } else {
                System.out.println("Ingrese un número válido");
                leer.nextLine();
            }
        } while (true);
    }

    public static void gestionarPrestYDev(){

    }

}