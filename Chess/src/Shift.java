public class Shift {

	private int valor;

    public Shift() {
        valor = 0;
    }

    public int toca() {
        return valor;
    }

    public int noToca() {
        return (valor + 1) % 2;
    }

    public void cambiar() {
        valor = this.noToca();
    }

    public static void main(String[] args) {
        Console console = new Console();
        Shift turno;
        for (int i = 0; i < 10; i++) {
            turno = new Shift();
            console.out("Toca: " + turno.toca() + "\n");
            console.out("No toca: " + turno.noToca() + "\n");
            turno.cambiar();
            console.out("Cambiado\n");
            console.out("Toca: " + turno.toca() + "\n");
            console.out("No toca: " + turno.noToca() + "\n");
            console.out("\n");
        }
    }
	
}
