class Square {

	private Piece piece;
	
	public Square() {
	}
	
	public void show() {
		Console console = new Console();
		if (piece == null) {
			console.out('_');
		}
		else {
			piece.show();
		}
	}
	
	public void setPiece(Piece token) {
		this.piece = token;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public boolean hasPiece() {
		return (piece != null);
	}
	
	public boolean isKing() {
		return this.piece!=null && this.piece.isKing();
	}

	public boolean IsColor(Color color) {
		return this.piece!=null && this.piece.isPlayer(color);
	}		
}
