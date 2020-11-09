class Box {

	private Console console;
	private Token token;
	
	public Box(Coordenada coordenada) {
		console = new Console();
	}
	
	public void show() {
		if (token == null) {
			console.out('_');
		}
		else {
			token.show();
		}
	}
	
	public void setToken(Token token) {
		this.token = token;
	}
	
	public Token getToken() {
		return this.token;
	}
	
	public boolean hasToken() {
		return (token != null);
	}
	
	public boolean isKing() {		
		return this.token!=null && this.token.isKing();
	}

	public boolean IsPlayer(Player player) {
		return this.token!=null && this.token.isPlayer(player);
	}		
}
