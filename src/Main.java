import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Funciona para todos los métodos del Main
    static Scanner leer = new Scanner(System.in);
    static int opc;
    static ArrayList<String> nombreUser = new ArrayList<>();
    static ArrayList<String> passwordUser = new ArrayList<>();
    static ArrayList<String> nombreLibro = new ArrayList<>(); // guarda los nombres de los nombreLibro
    static ArrayList<String> autorLibro = new ArrayList<>();// guarda el autor de cada libro
    static ArrayList<String> estado = new ArrayList<>();// guarda el estado del libro : true si el libro esta y false si el libro se lo llevaron prestado
    static ArrayList<String> comentarios = new ArrayList<>(); // Comenta a los libros
    static ArrayList<Integer> sancion = new ArrayList<>();
    static ArrayList<String> libroPrest = new ArrayList<>();
    static ArrayList<String> cometarioUser = new ArrayList<>();
    static int usuarioActual = -1;
    static String vacio = "";

    public static void main(String[] args) {
        // Primer estudiante por defecto
        nombreUser.add("Tommy");
        passwordUser.add("1234");
        cometarioUser.add(vacio);
        sancion.add(0);
        libroPrest.add("Ninguno");

        // clase libro
        nombreLibro.add("Papelucho ");
        autorLibro.add("Marcela Paz");
        estado.add("Disponible");
        comentarios.add(vacio);

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

                System.out.println("1. iniciar sesion");
                System.out.println("2. Salir");
                if (leer.hasNextInt()) {
                    eleccion = leer.nextInt();
                    leer.nextLine();
                } else {
                    System.out.println("Debe ingresar un número.");
                    leer.nextLine();
                    eleccion = 0;
                }


                if (eleccion == 1) {
                    int intentos = 3;

                    while (intentos > 0) {
                        System.out.println("--Iniciar sesion--");
                        System.out.println(" ");
                        System.out.println("Ingrese su usuario");
                        String username = leer.nextLine();

                        System.out.println("Ingrese su contraseña");
                        String passwordUser = leer.nextLine();

                        boolean Found = false;

                        for (int i = 0; i < nombreUser.size(); i++) {


                            if (username.equals(nombreUser.get(i)) &&
                                    passwordUser.equals(Main.passwordUser.get(i))) {

                                usuarioActual = i;
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

                } else if (eleccion == 2) {//regresar al menu
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

    public static void registrarAlumno() {//para crear nuevas cuentas de estudiantes
        System.out.println("Registro nuevo alumno");
        System.out.println("ingrese el nombre de usuario del alumno");
        String nuevoUser = leer.nextLine();

        System.out.println("asigne una contraseña para el alumno");
        String nuevaPass = leer.nextLine();

        nombreUser.add(nuevoUser);
        passwordUser.add(nuevaPass);
        cometarioUser.add(vacio);
        sancion.add(0);
        libroPrest.add("Ninguno");

        System.out.println("la cuenta ha sido creada con existo");
    }

    public static void MenuUser() {// menu de usuario

// se modifico completamente para que funcionen las opciones del menu
        do {

            System.out.println("\n= MENU USUARIO =");
            System.out.println("1. Ver libros disponibles");
            System.out.println("2. Buscar libro");
            System.out.println("3. Pedir libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Ver mis prestamos");
            System.out.println("6. Ver mi informacion");
            System.out.println("7. Cerrar sesion");
            System.out.print("> ");

            if (leer.hasNextInt()) {

                opc = leer.nextInt();
                leer.nextLine();

                switch (opc) {

                    case 1 -> {

                        System.out.println("\nLIBROS DISPONIBLES");

                        for (int i = 0; i < nombreLibro.size(); i++) {

                            System.out.println((i + 1) + ". " +
                                    nombreLibro.get(i));

                            System.out.println("Autor: " +
                                    autorLibro.get(i));

                            System.out.println("Estado: " +
                                    estado.get(i));

                            System.out.println("----------------------");
                        }

                    }

                    case 2 -> buscarLibro();

                    case 3 -> pedirLibro();

                    case 4 -> devolverLibro();

                    case 5 -> verMisPrestamos();

                    case 6 -> verMiInformacion();

                    case 7 -> {

                        usuarioActual = -1;

                        System.out.println("Cerrando sesion...");

                        menu();

                        return;

                    }

                    default -> System.out.println("Opción invalida.");

                }

            } else {

                System.out.println("Debe ingresar un numero.");

                leer.nextLine();

            }

        } while (true);

    }

    public static void buscarLibro() {
// nuevo metodo para buscar los libros cuando el usurario lo solicite
        // busca solo una parte del nombre y no distingue entre mayusculas y minusculas para que se le haga mas facil al usuriao encontrarlo
        if (nombreLibro.size() == 0) {
            System.out.println("No hay libros registrados.");
            return;
        }

        System.out.println("= BUSCAR LIBRO =");
        System.out.println("Ingrese el nombre del libro:");
        String buscar = leer.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < nombreLibro.size(); i++) {

            if (nombreLibro.get(i).toLowerCase().contains(buscar.toLowerCase())) {

                System.out.println("-------------------------");
                System.out.println("Libro: " + nombreLibro.get(i));
                System.out.println("Autor: " + autorLibro.get(i));
                System.out.println("Estado: " + estado.get(i));

                if (!comentarios.get(i).equalsIgnoreCase(vacio)) {
                    System.out.println("Comentario: " + comentarios.get(i));
                }

                System.out.println("-------------------------");

                encontrado = true;
            }

        }

        if (!encontrado) {
            System.out.println("No se encontro ningún libro con ese nombre.");
        }

    }

    // Método para que el usuario pueda pedir un libro
    public static void pedirLibro() {

        // Verifica si existen libros registrados
        if (nombreLibro.size() == 0) {
            System.out.println("No hay libros registrados.");
            return;
        }

        // Verifica si el usuario ya tiene un libro prestado
        if (!libroPrest.get(usuarioActual).equals("Ninguno")) {
            System.out.println("Ya tienes un libro prestado.");
            System.out.println("Debes devolverlo antes de pedir otro.");
            return;
        }

        System.out.println("== LIBROS DISPONIBLES ==");

        boolean disponible = false;

        // Muestra solamente los libros disponibles
        for (int i = 0; i < nombreLibro.size(); i++) {

            if (estado.get(i).equalsIgnoreCase("Disponible")) {

                System.out.println(i + ". " + nombreLibro.get(i)
                        + " | Autor: " + autorLibro.get(i));

                disponible = true;
            }

        }

        // Si no hay libros disponibles termina el metodo
        if (!disponible) {
            System.out.println("No hay libros disponibles.");
            return;
        }

        System.out.print("Seleccione el número del libro: ");

        if (leer.hasNextInt()) {

            int libro = leer.nextInt();
            leer.nextLine();

            // Verifica que el numero exista
            if (libro >= 0 && libro < nombreLibro.size()) {

                // Comprueba nuevamente que el libro siga disponible
                if (estado.get(libro).equalsIgnoreCase("Disponible")) {

                    // Cambia el estado del libro
                    estado.set(libro, "Prestado");

                    // Guarda el nombre del libro en el usuario
                    libroPrest.set(usuarioActual, nombreLibro.get(libro));

                    System.out.println("--------------------------------");
                    System.out.println("Prestamo realizado correctamente");
                    System.out.println("Libro: " + nombreLibro.get(libro));
                    System.out.println("--------------------------------");

                } else {

                    System.out.println("Ese libro ya fue prestado");

                }

            } else {

                System.out.println("Libro inexistente");

            }

        } else {

            System.out.println("Debe ingresar un numero");
            leer.nextLine();

        }

    }

    // metodo para que el usuario pueda devolver un libro
    public static void devolverLibro() {

        // verifica si el usuario tiene un libro prestado
        if (libroPrest.get(usuarioActual).equals("Ninguno")) {
            System.out.println("No tienes ningún libro prestado");
            return;
        }

        System.out.println("= DEVOLVER LIBRO =");
        System.out.println("libro prestado: " + libroPrest.get(usuarioActual));

        System.out.print("¿Desea devolver este libro? (s/n): ");
        String respuesta = leer.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {

            // Busca el libro dentro de la lista
            for (int i = 0; i < nombreLibro.size(); i++) {

                if (nombreLibro.get(i).equals(libroPrest.get(usuarioActual))) {

                    // Cambia el estado del libro a disponible
                    estado.set(i, "Disponible");

                    break;
                }

            }

            // El usuario queda sin libros prestados
            libroPrest.set(usuarioActual, "Ninguno");

            System.out.println("---------------------------");
            System.out.println("Libro devuelto correctamente");
            System.out.println("---------------------------");

        } else {

            System.out.println("Operacion cancelada");

        }

    }

    // metodo para mostrar el libro que tiene prestado el usuario
    public static void verMisPrestamos() {

        System.out.println("= MIS PRESTAMOS =");

        // verifica si el usuario tiene un libro prestado
        if (libroPrest.get(usuarioActual).equals("Ninguno")) {

            System.out.println("no tienes libros prestados");

        } else {

            System.out.println("Libro prestado:");
            System.out.println(libroPrest.get(usuarioActual));

        }

    }

    // metodo para mostrar toda la informacion del usuario
    public static void verMiInformacion() {

        System.out.println("-- MI INFORMACION --");
        System.out.println("Nombre: " + nombreUser.get(usuarioActual));
        System.out.println("Libro prestado: " + libroPrest.get(usuarioActual));
        System.out.println("Sancion: " + sancion.get(usuarioActual));
        if (cometarioUser .get(usuarioActual).equals(vacio)) {
            System.out.println("Comentario: Sin comentario");
        } else {
            System.out.println("Comentario: " + cometarioUser .get(usuarioActual));
        }
    }

    public static void gestionLibro() {
        do {
            System.out.println("Gestion de libros");
            System.out.println("1.Agregar libros");
            System.out.println("2.Eliminar Libro");
            System.out.println("3.Ver lista de libros");
            System.out.println("4.Agregar comentario de libros");
            System.out.println("5.Editar Libros");
            System.out.println("6.Salir");
            System.out.print("> ");

            if (leer.hasNextInt()) {//pregunto si escribio un numero, por si usuario usa nose letras
                opc = leer.nextInt();
                leer.nextLine();

                switch (opc) {
                    case 1 -> {
                        System.out.println("Agregar libro");

                        System.out.print("Nombre del libro: ");
                        String nuevoNombre = leer.nextLine();
                        System.out.print("Autor del libro: ");
                        String nuevoAutor = leer.nextLine();
                        nombreLibro.add(nuevoNombre);
                        autorLibro.add(nuevoAutor);
                        estado.add("Disponible");
                        comentarios.add(vacio);

                        System.out.println("libro agregado ");

                    }
                    case 2 -> {
                        System.out.println("Eliminar libros");

                        if (nombreLibro.size() == 0) {
                            System.out.println("No hay lirbos registrados");

                        } else {
                            for (int i = 0; i < nombreLibro.size(); i++)
                                System.out.println(i + "-" + nombreLibro.get(i) + " Autor :" + autorLibro.get(i) + "Estado" + estado.get(i));
                            System.out.print("Seleccione libro a eliminar: ");
                            if (leer.hasNextInt()) {
                                int opc = leer.nextInt();
                                leer.nextLine();
                                if (opc >= 0 && opc < nombreLibro.size()) {
                                    if (estado.get(opc).equals("Prestado")) {
                                        System.out.println("No se puede eliminar un libro prestado");
                                    } else {
                                        System.out.print("¿Está seguro? (si/no): ");
                                        String confirmar = leer.nextLine();
                                        if (confirmar.equalsIgnoreCase("si")) {
                                            nombreLibro.remove(opc);
                                            autorLibro.remove(opc);
                                            estado.remove(opc);
                                            comentarios.remove(opc);
                                            System.out.println("Libro elimidado correctamente");
                                        } else {
                                            System.out.println("Operacion cancelada");
                                        }
                                    }

                                } else {
                                    System.out.println("Libro inexistente ");
                                }
                            } else {
                                System.out.println("Debe ingresar su numero");
                                leer.nextLine();
                            }

                        }

                    }
                    case 3 -> {
                        if (nombreLibro.size() == 0) {
                            System.out.println("No hay libros registrados");
                        } else {
                            System.out.println("Total libros: " + nombreLibro.size());
                            for (int i = 0; i < nombreLibro.size(); i++) {
                                System.out.println(i + ". Nombre: " + nombreLibro.get(i));
                                System.out.println("Autor: " + autorLibro.get(i));
                                System.out.println("Estado: " + estado.get(i));
                                System.out.println("Comentario: " + comentarios.get(i));
                                System.out.println("--------------------");
                            }

                        }
                    }
                    case 4 -> {
                        if (nombreLibro.size() == 0) {
                            System.out.println("No hay libros registrados ");
                        } else {
                            for (int i = 0; i < nombreLibro.size(); i++)
                                System.out.println(i + "-" + nombreLibro.get(i));
                            System.out.println("seleccione un libro: ");
                            if (leer.hasNextInt()) {
                                int opc = leer.nextInt();
                                leer.nextLine();
                                if (opc >= 0 && opc < nombreLibro.size()) {
                                    System.out.println("Comentario actual: " + comentarios.get(opc));
                                    System.out.print("Nuevo comentario ");
                                    String nuevocomentario = leer.nextLine();
                                    comentarios.set(opc, nuevocomentario);
                                    System.out.println("comentario actualizado");
                                }

                            } else {
                                System.out.println("debe ingresar un numero ");
                                leer.nextLine();
                            }
                        }
                    }
                    case 5 -> {
                        if (nombreLibro.size() == 0) {
                            System.out.println("No hay libros registrados ");
                        } else {
                            for (int i = 0; i < nombreLibro.size(); i++)
                                System.out.println(i + "- " + nombreLibro.get(i) + " Autor " + autorLibro.get(i));
                            System.out.println("Seleccion del libro a editar");
                            if (leer.hasNextInt()) {
                                int opc = leer.nextInt();
                                leer.nextLine();
                                if (opc >= 0 && opc < nombreLibro.size()) {
                                    System.out.println("Nuevo nombre" + nombreLibro.get(opc));
                                    String nuevonombre = leer.nextLine();
                                    if (!nuevonombre.trim().isEmpty()) nombreLibro.set(opc, nuevonombre);
                                    System.out.println("libro editado correctamente");


                                } else {
                                    System.out.println("Libro inexistente.");
                                }
                            } else {
                                System.out.println("Debe ingresar un número.");
                                leer.nextLine();
                            }
                        }
                    }
                    case 6 -> {
                        System.out.println("salida de gestion de libros");
                        return;
                    }
                    default -> System.out.println("opcion invalida");

                }

            } else {
                System.out.println("Debe ingresar un número.");
                leer.nextLine();
            }
        } while (true);

    }

    // gestion de usuario del menú admin
    public static void gestionUsuario() {
        do {
            System.out.println("-- Gestión de usuarios --");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Sancionar usuario y comentarios");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Ver usuario");
            System.out.println("5. Salir");
            System.out.print("> ");

            if (leer.hasNextInt()) {
                opc = leer.nextInt();
                leer.nextLine();

                switch (opc) {

                    // No listo
                    case 1 -> {
                        System.out.println("Agregar usuario");
                        registrarAlumno();
                    }
                    // No listo
                    case 2 -> {
                        System.out.println("-- Sancionar usuario y comentarios --");

                        for (int i = 0; i < nombreUser.size(); i++) {
                            System.out.println(i + ".- " + nombreUser.get(i));
                        }
                        System.out.println("-- Seleccione usuario --");
                        if (leer.hasNextInt()) {
                            opc = leer.nextInt();
                            leer.nextLine();

                            // Verificar
                            if (opc >= 0 && opc < nombreUser.size()) {
                                System.out.println("Sancion actual: " + sancion.get(opc));
                                System.out.print("Ingrese cantidad de sancion a agregar: ");

                                if (leer.hasNextInt()) {
                                    int nuevaSancion = leer.nextInt();
                                    leer.nextLine();

                                    System.out.print("Agrega comentario: ");
                                    String c = leer.nextLine();

                                    System.out.println("¿Está seguro de que desea aplicar esta sancion y comentario?");
                                    System.out.println("s/n");
                                    String decidir = leer.nextLine();
                                    if (decidir.equalsIgnoreCase("s")) {
                                        int total = sancion.get(opc) + nuevaSancion;
                                        sancion.set(opc, total);
                                        cometarioUser.set(opc, c);
                                        System.out.println("Sancion y comentario agregados");
                                    } else if (decidir.equalsIgnoreCase("n")) {
                                        System.out.println("Operación cancelada.");
                                    } else {
                                        System.out.println("Dato inválido.");
                                    }
                                } else {
                                    System.out.println("Debe ingresar un número.");
                                    leer.nextLine();
                                }
                            } else {
                                System.out.println("Usuario inexistente.");
                            }
                        } else {

                            System.out.println("Debe ingresar un número.");
                            leer.nextLine();

                        }
                    }

                    // Eliminación de nombreUser a través de gestion nombreUser (LISTO)
                    case 3 -> {
                        System.out.println("-- Eliminar usuario --");
                        for (int i = 0; i < nombreUser.size(); i++) {
                            System.out.println(i + ".- " + nombreUser.get(i));
                        }
                        System.out.println("-- Seleccione usuario --");
                        if (leer.hasNextInt()) {
                            opc = leer.nextInt();
                            leer.nextLine();
                            // Verificar
                            if (opc >= 0 && opc < nombreUser.size()) {
                                System.out.println("Se eliminará este usuario de manera permanente, ¿está seguro?");
                                System.out.println("s/n");
                                String decidir = leer.nextLine();

                                // Ignore case es para que permita poner S o s (mayuscula o miniscula)
                                if (decidir.equalsIgnoreCase("s")) {

                                    nombreUser.remove(opc);
                                    passwordUser.remove(opc);
                                    cometarioUser.remove(opc);
                                    sancion.remove(opc);
                                    libroPrest.remove(opc);

                                    System.out.println("Usuario eliminado correctamente.");
                                } else if (decidir.equalsIgnoreCase("n")) {
                                    System.out.println("Operación cancelada.");

                                } else {
                                    System.out.println("Dato inválido.");
                                }
                            } else {
                                System.out.println("Usuario inexistente.");
                            }
                        } else {
                            System.out.println("Debe ingresar un número.");
                            leer.nextLine();

                        }
                    }
                    // LISTO
                    case 4 -> {
                        System.out.println("-----------------------------------------");
                        System.out.println("Cantidad de alumnos: " + nombreUser.size());
                        System.out.println("Lista de usuarios:");
                        // for normal
                        for (int i = 0; i < nombreUser.size(); i++) {
                            System.out.println(i + ".- " + nombreUser.get(i));
                        }
                        System.out.println("1. seleccionar usuario");
                        System.out.println("2. salir");
                        if (leer.hasNextInt()) {
                            opc = leer.nextInt();
                            leer.nextLine();
                            switch (opc) {
                                case 1 -> {
                                    System.out.print("seleccione: ");
                                    if (leer.hasNextInt()) {
                                        opc = leer.nextInt();
                                        leer.nextLine();
                                        if (opc >= 0 && opc < nombreUser.size()) {
                                            System.out.println("-- Datos generales --");
                                            System.out.println("Nombre: " + nombreUser.get(opc));
                                            System.out.println("Comentarios: " + cometarioUser.get(opc));
                                            System.out.println("Sacion: " + sancion.get(opc));
                                            System.out.println("Libro prestado: " + libroPrest.get(opc));
                                            System.out.println("- - - - - - - - - - -");
                                        } else {
                                            System.out.println("usuario no existente");
                                        }
                                    } else {
                                        System.out.println("Dato invalido");
                                        leer.nextLine();
                                    }

                                }
                                case 2 -> System.out.println("Volviendo...");
                                default -> System.out.println("Opción inválida");
                            }
                        } else {
                            System.out.println("Debe ingresar un numero");
                            leer.nextLine();
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
        // Fin gestión nombreUser
    }

    public static void gestionarPrestYDev() {
        do {
            System.out.println("-- Préstamos y devoluciones --");
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Registrar devolución");
            System.out.println("3. Salir");
            System.out.print("> ");

            if (leer.hasNextInt()) {
                opc = leer.nextInt();
                leer.nextLine();
                switch (opc) {
                    case 1 -> {
                        System.out.println("-- Registrando préstamo --");
                        // Hay libros?
                        if (nombreLibro.size() == 0) {
                            System.out.println("No hay libros para prestar.");
                            return;
                        }
                        // Mostrar libros
                        for (int i = 0; i < nombreLibro.size(); i++) {
                            System.out.println(i + ".- " + nombreLibro.get(i));
                        }

                        System.out.println("Ingrese el libro que desea prestar");
                        System.out.print("> ");
                        if (leer.hasNextInt()) {
                            opc = leer.nextInt();
                            leer.nextLine();
                            // Validar libro
                            if (opc >= 0 && opc < nombreLibro.size()) {
                                // verifica si el libro ya esta prestado
                                if (estado.get(opc).equals("Prestado")) {
                                    System.out.println("Este libro no esta disponible por el momento");
                                    return;
                                }
                                // Mostrar usuarios
                                for (int i = 0; i < nombreUser.size(); i++) {
                                    System.out.println(i + ".- " + nombreUser.get(i));
                                }
                                System.out.println("Ingrese el usuario que recibirá el libro");
                                System.out.print("> ");
                                if (leer.hasNextInt()) {
                                    int m = leer.nextInt();
                                    leer.nextLine();
                                    // Validar usuario
                                    if (m >= 0 && m < nombreUser.size()) {
                                        if (!libroPrest.get(m).equals("Ninguno")) {
                                            System.out.println("Este usuario ya tiene un libro prestado.");
                                        } else {
                                            String libro = nombreLibro.get(opc);
                                            libroPrest.set(m, libro);
                                            estado.set(opc, "Prestado");
                                            System.out.println("Préstamo registrado correctamente.");
                                        }
                                    } else {
                                        System.out.println("Usuario inexistente.");
                                    }
                                } else {
                                    System.out.println("Debe ingresar un número.");
                                    leer.nextLine();
                                }
                            } else {
                                System.out.println("Libro inexistente.");
                            }
                        } else {
                            System.out.println("Debe ingresar un número.");
                            leer.nextLine();
                        }
                    }
                    case 2 -> {
                        System.out.println("-- Registrando devolución --");
                        for (int i = 0; i < nombreUser.size(); i++) {
                            System.out.println(i + ".- " + nombreUser.get(i));
                        }
                        System.out.println("Ingrese el usuario que devuelve el libro");
                        System.out.print("> ");
                        if (leer.hasNextInt()) {
                            int m = leer.nextInt();
                            leer.nextLine();
                            if (m >= 0 && m < nombreUser.size()) {
                                if (libroPrest.get(m).equals("Ninguno")) {
                                    System.out.println("Este usuario no tiene libros prestados.");
                                } else {
                                    String libro = libroPrest.get(m);
                                    for (int i = 0; i < nombreLibro.size(); i++) {
                                        if (nombreLibro.get(i).equals(libro)) {
                                            estado.set(i, "Disponible");
                                            break;
                                        }
                                    }
                                    libroPrest.set(m, "Ninguno");
                                    System.out.println("Devolución registrada correctamente.");
                                }
                            } else {
                                System.out.println("Usuario inexistente.");
                            }
                        } else {
                            System.out.println("Debe ingresar un número.");
                            leer.nextLine();
                        }
                    }
                    case 3 -> {
                        System.out.println("Saliendo . . .");
                        return;
                    }
                    default -> System.out.println("Opción inválida");
                }
            } else {
                System.out.println("Debe ingresar un número.");
                leer.nextLine();
            }
        } while (true);
    }
    // CREADORES: Jorge Curvivil - Daniel Huentenao - Hugo Iturra - Nicolas Espinoza

}