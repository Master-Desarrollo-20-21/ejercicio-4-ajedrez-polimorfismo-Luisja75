class Chess {

	private static final int NUM_JUGADORES = 2;
    final Color[] COLORS = new Color[] {Color.WHITE, Color.BLACK};

	private Board board;
	private Player[] players; 
    private Shift shift;    

    public Chess()
    {
    	players = new Player[NUM_JUGADORES];
	    for(int i=0; i<NUM_JUGADORES; i++){
	    	players[i] = new Player(COLORS[i]);
	    }
	    this.board = new Board(COLORS);
	    shift = new Shift();
    }
    
	private void play() { 
        board.show();
        do {
        	Movement movement = board.getMovement(players[shift.toca()].getColor());
        	board.moveToken(movement.getOrigin(), movement.getDestination());
            board.show();
        	shift.cambiar();
        } while (!board.win());
        
        players[shift.noToca()].showWinner();
	} 
	
	public static void main(String[] args) {
		new Chess().play(); 
	} 	
}
