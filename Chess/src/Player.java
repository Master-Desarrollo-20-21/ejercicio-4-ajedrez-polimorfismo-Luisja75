class Player {
	private Color color;
	Console console;
	
	public Player(Color color) {
		this.color = color;
		console = new Console();
	}
	
	public boolean isWhite(){
		return color == Color.WHITE;
	}

	public Movement getMovement(Board board) {
		console.out("Mueve el jugador " + color + "\n");
		Movement movement = new Movement(board, this);
		movement.requestCoordenates();
		return movement;
	}
	
	public void showWinner(){
		console.out("GANADOR el jugador " + color + "\n");
	}
}
