import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Funciona para todos los métodos del Main
    static Scanner leer = new Scanner(System.in);
    static ArrayList<String> usuarios = new ArrayList<>();
    static ArrayList<String> contraseñas = new ArrayList<>();
    static ArrayList<String> libros = new ArrayList<>(); // guarda los nombres de los libros
    static ArrayList<String> autores = new ArrayList<>();// guarda el autor de cada libro
    static ArrayList<Boolean> disponible = new ArrayList<>();// guarda el estado del libro : true si el libro esta y false si el libro se lo llevaron prestado

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
            int opc;
            System.out.println("----------------");
            System.out.println("-- Seleccione opción --");
            System.out.println("1. Usuario admin");
            System.out.println("2. Usuario normal");
            x
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
                        System.out.println("bienvenido administrador");
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

                System.out.println("1.-crear usuario");
                System.out.println("2.-iniciar sesion");
                eleccion = leer.nextInt();
                leer.nextLine();

                if (eleccion == 1) { // primera opcion crear usuario
                    System.out.println("ingrese su nombre de usuario a crear: ");
                    String username = leer.nextLine();

                    System.out.println("ingrese contraseña: ");
                    String passwordUser = leer.nextLine();

                    usuarios.add(username);
                    contraseñas.add(passwordUser);

                    System.out.println("Su usuario a sido creado correctamente");
                    menu();

                } else if (eleccion == 2) {// segunda opcion iniciar sesion
                    int intentos = 3;

                    while (intentos > 0) {

                        System.out.println("Ingrese su usuario");
                        String username = leer.nextLine();

                        System.out.println("Ingrese su contraseña");
                        String passwordUser = leer.nextLine();

                        boolean Found = false;

                        for (int i = 0; i < usuarios.size(); i++) {
                            if (username.equals(usuarios.get(i)) && passwordUser.equals(contraseñas.get(i))) {
                                Found = true;
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

                } else {
                    System.out.println("Esta opcion no existe");
                    inicioSesion(2);
                }
            }
        }
    }

    public static void MenuAd() {// menu de administrador
        int opc;
        do {
            System.out.println("Panel Administraccion de la Biblioeteca");
            System.out.println("1. Registrar nuevo alumno(Crear cuenta)");
            System.out.println("2.Agregar nuevo libro al catalogo");
            System.out.println("3. Cerrar sesion y volver al menu principal");
            System.out.print(">");// es para decirle al usuario donde escribir no mas

            if (leer.hasNextInt()) {//para preguntar si tiene un numero entero (has)
                opc = leer.nextInt();
                leer.nextLine();

                switch (opc) {
                    case 1 -> mostrarlibro();
                    case 2 -> prestarlibro();
                    case 3 -> devolverlibro();
                    case 4 -> {
                        System.out.println("Cerrando sesion del alumno");
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

    public static void registrarAlumno(){//para creear nuevas cuentas de estudiantes
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
}