class Square {

	private Piece piece;
	
	public Square() {
	}
	
	public String show() {
		if (piece == null) {
			return "    ";
		}
		else {
			return "   " + piece.show() + "  ";
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

	public boolean isColor(Color color) {
		return this.piece!=null && this.piece.isPlayer(color);
	}		
}
