class Movement {
	
	private Console console;
	private Coordinate origin;
	private Coordinate destination;
	
	public Movement() {
		this.console = new Console();
		requestCoordenates();
	}

	private void requestCoordenates() {
		requestOrigen();
		requestDestination();	
	}
	
    private void requestOrigen(){
		console.out("Introduce coordenada ficha ORIGEN\n");
		origin = new Coordinate();
		origin.recoger(1,8);
    }
	
    private void requestDestination() {
		console.out("Introduce coordenada ficha DESTINO\n");
		destination = new Coordinate();
		destination.recoger(1,8);
    }
	
	public Coordinate getOrigin() {
		 return origin;
	}
	
	public Coordinate getDestination() {
		 return destination;
	}
}

