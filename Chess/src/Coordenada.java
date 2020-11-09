class Coordenada {

    protected int fila;

    protected int columna;

    public Coordenada() {
    }

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public boolean igual(Coordenada coordenada) {
        assert coordenada != null;
        return fila == coordenada.fila && columna == coordenada.columna;
    }

    public void recoger(int limitDown, int limitUp) {
        Console gestorIO = new Console();
		do {
	        gestorIO.out("Introduce fila (" + limitDown + ".." + limitUp + "): ");
	        fila = gestorIO.inInt();
		} while (!coordenadaValida(fila, limitDown, limitUp));   	

		do {
	        gestorIO.out("Introduce columna (" + limitDown + ".." + limitUp + "): ");
	        columna = gestorIO.inInt();
		} while (!coordenadaValida(columna, limitDown, limitUp));  	
		
    }
    
	private boolean coordenadaValida(int value, int limitDown, int limitUp) {
		return (value >= limitDown && value <= limitUp);
	}
}
