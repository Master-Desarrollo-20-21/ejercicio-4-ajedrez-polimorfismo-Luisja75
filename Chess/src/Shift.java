class Shift {

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
        Shift shift;
        for (int i = 0; i < 10; i++) {
            shift = new Shift();
            console.out("Toca: " + shift.toca() + "\n");
            console.out("No toca: " + shift.noToca() + "\n");
            shift.cambiar();
            console.out("Cambiado\n");
            console.out("Toca: " + shift.toca() + "\n");
            console.out("No toca: " + shift.noToca() + "\n");
            console.out("\n");
        }
    }
}
