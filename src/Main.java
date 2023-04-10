import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean runApp = true;
        Trabajador trabajador = new Trabajador();
        Scanner scan = new Scanner(System.in);
        List<Trabajador> listaEntradas = new ArrayList<>();
        int passAdmin = 0000;
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
                    listaEntradas.add(setEntrada()); break;
                }
                case "2":

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

        while (runIn){
            System.out.println("Introduce numero de usuario");
            String user = scan.nextLine();
            System.out.println("Introduce la contraseña");
            String pass = scan.nextLine();

            if (user.equals(pass)) {
                trabajador.setDni(user);
                trabajador.setPass(pass);
                trabajador.setHora(horaActual);
                runIn = false;


            }else{
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
}