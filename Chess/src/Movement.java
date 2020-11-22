class Movement {
	
	private Console console;
	private Coordinate origin;
	private Coordinate destination;
	
	public Movement() {
		this.console = new Console();
	}

	public void requestCoordenates() {
		requestOrigen();
		requestDestination();	
	}
	
    private void requestOrigen(){
		console.out("Introduce coordenada ficha ORIGEN\n");
		origin = new Coordinate();
		origin.get();
    }
	
    private void requestDestination() {
		console.out("Introduce coordenada ficha DESTINO\n");
		destination = new Coordinate();
		destination.get();
    }
	
	public Coordinate getOrigin() {
		 return origin;
	}
	
	public Coordinate getDestination() {
		 return destination;
	}
}

