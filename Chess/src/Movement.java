public class Movement {
	
	private Console console;
	private Board board;
	
	private Coordinate origin;
	private Coordinate destination;
	private DataMovement dataMovement; 
	
	public Movement(Board board) {
		this.console = new Console();
		this.board = board;
		do {
			requestCoordenates();
			calculate();
		} while (!this.isCorrect());   	
	}

	private void requestCoordenates() {
		requestOrigen();
		requestDestination();	
	}
	
	private void calculate() {
		TypeMovement type = this.getType();
		TypeDirection direction = this.getDirection();		
		int distance = this.getDistance(type);
		boolean freeway = this.getFreeWay(type, direction, distance);
		this.dataMovement = new DataMovement(type, direction, distance, freeway);
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
	
	private TypeMovement getType()
	{
		TypeMovement type;
		if (origin.equalRow(destination)) {
			type = TypeMovement.VERTICAL;
		} else if (origin.equalColumn(destination)) {
			type = TypeMovement.HORIZONTAL;
		} else if (Math.abs(origin.getRow() - destination.getRow()) == Math.abs(origin.getColum() - destination.getColum())) {
			type = TypeMovement.DIAGONAL;
		} else if ((Math.abs(origin.getRow() - destination.getRow()) == 2 && Math.abs(origin.getColum() - destination.getColum()) == 1) ||
			       (Math.abs(origin.getRow() - destination.getRow()) == 1 && Math.abs(origin.getColum() - destination.getColum()) == 2)){
			type =  TypeMovement.L;
		} else {
			type = TypeMovement.UNKNOWN;
		}
		return type;
	}

	private TypeDirection getDirection()
	{
		TypeDirection direction = TypeDirection.FORWARD;
		if (origin.getColum() > destination.getColum() ||
		    origin.getRow() > destination.getRow()){
			direction = TypeDirection.BACK;
		} 
		return direction;
	}	
	
	private int getDistance(TypeMovement type)
	{
		int distance = 0;
		if (type == TypeMovement.HORIZONTAL || type == TypeMovement.DIAGONAL) {
			distance = Math.abs(origin.getColum() - destination.getColum());
		}
		if (type == TypeMovement.VERTICAL) {
			distance = Math.abs(origin.getRow() - destination.getRow());
		}
		return distance;
	}
	
	private boolean getFreeWay(TypeMovement type, TypeDirection direction, int distance) {
		int incrementToNextFila = 0; 
		int incrementToNextColum = 0; 
		if (type == TypeMovement.HORIZONTAL || type == TypeMovement.DIAGONAL) {
			if (direction == TypeDirection.BACK) {
				incrementToNextColum = -1;
			} else {
				incrementToNextColum = 1;
			}			
		}
		if (type == TypeMovement.VERTICAL || type == TypeMovement.DIAGONAL) {
			if (direction == TypeDirection.BACK) {
				incrementToNextFila = -1;
			} else {
				incrementToNextFila = 1;
			}			
		}

		int nextFila = origin.getRow() + incrementToNextFila;
		int nextColum = origin.getColum() + incrementToNextColum;
		for (int i=1; i<distance; i++) {
			Coordinate nextCoordenate = new Coordinate(nextFila, nextColum);
			Box box = board.getBox(nextCoordenate);
			if (box.hasToken()) {				
				return false;
			}
			nextFila += incrementToNextFila;
			nextColum += incrementToNextColum;
		}
		
		return true;
	}

	private boolean isCorrect() {		
		if (this.dataMovement.getType() == TypeMovement.UNKNOWN){
			console.out("El movimiento introducido es desconocido\n");
			return false;
		}

		return true;
	}
	
	public Coordinate getOrigin() {
		 return origin;
	}
	
	public Coordinate getDestination() {
		 return destination;
	}
	
	public DataMovement getDataMovement() {
		 return dataMovement;
	}	
}

