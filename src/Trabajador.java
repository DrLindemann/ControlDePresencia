public class Trabajador {

    private String dni;
    private String pass;
    private String hora;

    public Trabajador() {
    }

    public Trabajador(String dni, String pass, String hora) {
        this.dni = dni;
        this.pass = pass;
        this.hora = hora;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "dni='" + dni + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }
}
