class Player {
	private Color color;
	private Console console;
	
	public Player(Color color) {
		this.color = color;
		this.console = new Console();
	}
	
	public boolean isWhite(){
		return color == Color.WHITE;
	}
	
	public void showWinner(){
		console.out("GANADOR el jugador " + color + "\n");
	}
	
	public Color getColor() {
		return this.color;
	}
}
