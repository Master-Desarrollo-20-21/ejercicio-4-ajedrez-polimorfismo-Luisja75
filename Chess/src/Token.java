abstract class Token {

	protected Console console;
	protected Player player;			
	
	public Token(Player player) 
	{
		console = new Console();
		this.player = player;
	}
	
	public boolean isPlayer(Player player) {
		if (!hasPlayer()) {
			return false;
		}
				
		return ((this.player.isWhite() && player.isWhite()) || 
				(!this.player.isWhite() && !player.isWhite())
			   );
	}	

	public boolean hasPlayer() {
		return (player != null);
	}			
	
	public abstract boolean isDirectionAllow(TypeDirection typeDirection);
	
	public abstract boolean isDistanceAllow(int distance);

	public abstract boolean isMovementAllow(TypeMovement typeMovement);

	public abstract boolean isKing();
	
	public abstract void show();
}

