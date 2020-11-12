abstract class Token {

	protected Console console;
	protected Color color;			
	
	public Token(Color color) 
	{
		console = new Console();
		this.color = color;
	}
	
	public boolean isPlayer(Color color) {
		if (!hasPlayer()) {
			return false;
		}
				
		//LUIS REVISAR
		return this.color == color;
				
		//return ((this.color.WHITE == color.WHITE || 
		//		(!this.color.WHITE && !color.WHITE)
		//	   );
	}	

	public boolean hasPlayer() {
		return (color != null);
	}			
	
	public abstract boolean isDirectionAllow(TypeDirection typeDirection);
	
	public abstract boolean isDistanceAllow(int distance);

	public abstract boolean isMovementAllow(TypeMovement typeMovement);

	public abstract boolean isKing();
	
	public abstract void show();
}

