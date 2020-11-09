public class Movement {
	
	private Console console;
	private Board board;
	
	private Player player;
	private Coordenada origin;
	private Coordenada destination;
	private DataMovement dataMovement; 
	
	public Movement(Board board, Player player) {
		this.console = new Console();
		this.board = board;
		this.player = player;
	}

	public void requestCoordenates() {
		do {
			requestOrigen();
			requestDestination();	
		} while (!this.isCorrect());   	
	
	}

	public Coordenada getOrigin() {
		 return origin;
	}
	
	public Coordenada getDestination() {
		 return destination;
	}	

    private void requestOrigen(){
		boolean coordenadaOrigenValida = false;
		do {
			console.out("Introduce coordenada ficha ORIGEN\n");
			origin = new Coordenada();
			origin.recoger(1,8);
			coordenadaOrigenValida = coordenadaOrigenValida();
		} while (!coordenadaOrigenValida);   	
    }
	
	private boolean coordenadaOrigenValida() {
		Box box = board.getBox(origin);
		if(!box.hasToken()) {
			console.out("La coordenada origen no tiene ficha\n");
			return false;
		}
		if (box.IsPlayer(this.player)) {
			console.out("La coordenada origen tiene una ficha que no es de tu jugador\n");
			return false;
		}
		return true;
	}
	
    private void requestDestination() {
		boolean coordenadaOrigenDestino = false;
		do {
			console.out("Introduce coordenada ficha DESTINO\n");
			destination = new Coordenada();
			destination.recoger(1,8);
			coordenadaOrigenDestino = coordenadaDestinoValida();
		} while (!coordenadaOrigenDestino);		
    	
    }

	private boolean coordenadaDestinoValida() {
		Box box = board.getBox(destination);
		if(box.IsPlayer(player)) {
			console.out("La coordenada destino tiene una ficha de tu jugador\n");
			return false;
		}
		
		return true;
	}
	
	private TypeMovement getType()
	{
		TypeMovement type;
		if (origin.fila == destination.fila) {
			type = TypeMovement.HORIZONTAL;
		} else if (origin.columna == destination.columna) {
			type = TypeMovement.VERTICAL;
		} else if (Math.abs(origin.fila - destination.fila) == Math.abs(origin.columna - destination.columna)) {
			type = TypeMovement.DIAGONAL;
			Box box = board.getBox(destination);
			if(box.IsPlayer(player)) {
				type = TypeMovement.DIAGONAL_BY_EAT;
			}
		} else if ((Math.abs(origin.fila - destination.fila) == 2 && Math.abs(origin.columna - destination.columna) == 1) ||
			       (Math.abs(origin.fila - destination.fila) == 1 && Math.abs(origin.columna - destination.columna) == 2)){
			type =  TypeMovement.L;
		} else {
			type = TypeMovement.UNKNOWN;
		}
		return type;
	}

	private TypeDirection getDirection()
	{
		TypeDirection direction = TypeDirection.FORWARD;
		if (origin.columna > destination.columna ||
		    origin.fila > destination.fila){
			direction = TypeDirection.BACK;
		} 
		return direction;
	}	
	
	private int getDistance(TypeMovement type)
	{
		int distance = 0;
		if (type == TypeMovement.HORIZONTAL || type == TypeMovement.DIAGONAL) {
			distance = Math.abs(origin.columna - destination.columna);
		}
		if (type == TypeMovement.VERTICAL) {
			distance = Math.abs(origin.fila - destination.fila);
		}
		return distance;
	}
	
	private boolean isCorrect() {
		TypeMovement type = getType();
		TypeDirection direction = getDirection();
		int distance = getDistance(type);
		this.dataMovement = new DataMovement(type, direction, distance);
						
		if (type == TypeMovement.UNKNOWN){
			console.out("El movimiento introducido es desconocido\n");
			return false;
		}

		Box box = board.getBox(this.origin);
		Token tokenOrigin = box.getToken();
		if (!tokenOrigin.isMovementAllow(type) && !tokenOrigin.isDirectionAllow(direction) && !tokenOrigin.isDistanceAllow(distance)) {
			console.out("El movimiento introducido no está permitido para la pieza que se quiere mover.");
			return false;	
		}

		if (!this.freeWay(this.dataMovement)) {
			console.out("El movimiento introducido no está permitido porque hay piezas en el camnino\n");
			return false;
		}
	
		return true;
	}
	
	private boolean freeWay(DataMovement dataMovement) {
		if (dataMovement.getType() == TypeMovement.L) {
			return true;
		}

		int incrementToNextFila = 0; 
		int incrementToNextColum = 0; 
		if (dataMovement.getType() == TypeMovement.HORIZONTAL || dataMovement.getType() == TypeMovement.DIAGONAL) {
			if (dataMovement.getDirection() == TypeDirection.BACK) {
				incrementToNextColum = -1;
			} else {
				incrementToNextColum = 1;
			}			
		}
		if (dataMovement.getType() == TypeMovement.VERTICAL || dataMovement.getType() == TypeMovement.DIAGONAL) {
			if (dataMovement.getDirection() == TypeDirection.BACK) {
				incrementToNextFila = -1;
			} else {
				incrementToNextFila = 1;
			}			
		}

		int nextFila = origin.fila + incrementToNextFila;
		int nextColum = origin.columna + incrementToNextColum;
		for (int i=1; i<=dataMovement.getDistance(); i++) {
			Coordenada nextCoordenate = new Coordenada(nextFila, nextColum);
			Box box = board.getBox(nextCoordenate);
			if (box.hasToken()) {				
				return false;
			}
			nextFila += incrementToNextFila;
			nextColum += incrementToNextColum;
		}
		
		return true;
	}
}

