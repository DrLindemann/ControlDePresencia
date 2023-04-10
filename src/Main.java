import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String passAdmin = "0000";

    public static void main(String[] args) {


        boolean runApp = true;
        Trabajador trabajador = new Trabajador();
        Scanner scan = new Scanner(System.in);
        List<Trabajador> listaEntradas = new ArrayList<>();
        List<Trabajador> listaSalidas = new ArrayList<>();

        String option;

        while (runApp) {
            System.out.println("----CONTROL DE PRESENCIA----");
            System.out.println("Elige el numero de la opcion de que desees.");
            System.out.println("-1) Ticar Entrada");
            System.out.println("-2) Ticar Salida");
            System.out.println("-3) Listado de Entradas");
            System.out.println("-4) Listado de Salidas");
            System.out.println("-5) Guardar lista de Entradas");
            System.out.println("-6) Guardar lista de Salidas");
            System.out.println("-7) Salir");

            option = scan.nextLine();

            switch (option) {

                case "1": {
                    listaEntradas.add(setEntrada());
                    break;
                }
                case "2": {
                    listaSalidas.add(setSalida());
                    break;
                }
                case "3": {
                    getEntradas(listaEntradas);
                    break;
                }
                case "4": {
                    getSalidas(listaSalidas);
                    break;
                }
                case "5": {
                    imprimirEntradas(listaEntradas);
                    break;
                }
                case "6": {
                    imprimirSalidas(listaSalidas);
                    break;
                }
                case "7": {
                    System.out.println("Saliendo...");
                    runApp = false;
                    break;
                }
                default:
                    System.out.println("elige una de las 7 opciones.");

            }


        }
    }

    public static Trabajador setEntrada() {
        boolean runIn = true;

        Scanner scan = new Scanner(System.in);

        LocalTime localtime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String horaActual = localtime.format(formatter);

        Trabajador trabajador = new Trabajador();

        while (runIn) {
            System.out.println("Introduce numero de usuario");
            String user = scan.nextLine();
            System.out.println("Introduce la contraseña");
            String pass = scan.nextLine();

            if (user.equals(pass)) {
                trabajador.setDni(user);
                trabajador.setPass(pass);
                trabajador.setHora(horaActual);
                runIn = false;


            } else {
                System.out.println("DATOS INCORRECTOS");
                System.out.println("-1) volver a intentarlo");
                System.out.println("-2) menu principal");
                String opcion = scan.nextLine();

                switch (opcion) {
                    case "1" -> runIn = true;
                    case "2" -> runIn = false;
                    default -> System.out.println("Solo puedes elegir 1 o 2");
                }


            }
        }


        return trabajador;
    }

    public static Trabajador setSalida() {
        boolean runOut = true;

        Scanner scan = new Scanner(System.in);

        LocalTime localtime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String horaActual = localtime.format(formatter);

        Trabajador trabajador = new Trabajador();

        while (runOut) {
            System.out.println("Introduce numero de usuario");
            String user = scan.nextLine();
            System.out.println("Introduce la contraseña");
            String pass = scan.nextLine();

            if (user.equals(pass)) {
                trabajador.setDni(user);
                trabajador.setPass(pass);
                trabajador.setHora(horaActual);
                runOut = false;


            } else {
                System.out.println("DATOS INCORRECTOS");
                System.out.println("-1) volver a intentarlo");
                System.out.println("-2) menu principal");
                String opcion = scan.nextLine();

                switch (opcion) {
                    case "1" -> runOut = true;
                    case "2" -> runOut = false;
                    default -> System.out.println("Solo puedes elegir 1 o 2");
                }


            }
        }


        return trabajador;
    }

    public static void getEntradas(List<Trabajador> lista) {
        Scanner scan = new Scanner(System.in);

        Trabajador trabajador = new Trabajador();

        System.out.println("introduce la contraseña de administrador");
        String password = scan.nextLine();

        if (password.equals(passAdmin)) {
            for (Trabajador i : lista) {
                System.out.println(i.toString());
            }

        } else {
            System.out.println("contraseña incorrecta");
        }


    }

    public static void getSalidas(List<Trabajador> lista) {
        Scanner scan = new Scanner(System.in);

        Trabajador trabajador = new Trabajador();

        System.out.println("introduce la contraseña de administrador");
        String password = scan.nextLine();

        if (password.equals(passAdmin)) {
            for (Trabajador i : lista) {
                System.out.println(i.toString());
            }

        } else {
            System.out.println("contraseña incorrecta");
        }


    }

    public static void imprimirEntradas(List<Trabajador> lista) {
        List<String> listaFormateada = new ArrayList<>();
        String nombreArchivo = "ListaEntradas" + fecha() + ".txt";
        String rutaArchivo = new File(nombreArchivo).getAbsolutePath();

        for (Trabajador i : lista) {
            listaFormateada.add(i.toString());
            listaFormateada.add("\n");
        }
        try {
            FileWriter archivo = new FileWriter(rutaArchivo);
            archivo.write(listaFormateada.toString());
            archivo.close();
            System.out.println("El archivo ha sido creado exitosamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el archivo.");
            e.printStackTrace();
        }

    }

    public static void imprimirSalidas(List<Trabajador> lista) {
        List<String> listaFormateada = new ArrayList<>();
        String nombreArchivo = "ListaSalidas" + fecha() + ".txt";
        String rutaArchivo = new File(nombreArchivo).getAbsolutePath();

        for (Trabajador i : lista) {
            listaFormateada.add(i.toString());
            listaFormateada.add("\n");
        }
        try {
            FileWriter archivo = new FileWriter(rutaArchivo);
            archivo.write(listaFormateada.toString());
            archivo.close();
            System.out.println("El archivo ha sido creado exitosamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el archivo.");
            e.printStackTrace();
        }

    }

    public static LocalDate fecha() {
        LocalDate localDate = LocalDate.now();
        return localDate;
    }


}