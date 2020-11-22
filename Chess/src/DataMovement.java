class DataMovement {
	
	private TypeMovement type;
	private TypeDirection direction;
	private int distance;
	private boolean freeWay;
	private boolean eatPeace;
	
	public DataMovement(Board board, Color color, Movement movement) {
		this.calculate(board, color, movement);		
	}

	private void calculate(Board board, Color color, Movement movement) {
		Coordinate origin = movement.getOrigin();
		Coordinate destination = movement.getDestination();
		this.setType(origin, destination);
		this.setDirection(origin, destination);		
		this.setDistance(origin, destination);
		this.setFreeWay(origin, board);
		this.setEatPeace(board, color, destination);
	}
    
	private void setType(Coordinate origin, Coordinate destination) {
		if (origin.equalRow(destination)) {
			this.type = TypeMovement.VERTICAL;
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
	}

	private void setDirection(Coordinate origin, Coordinate destination) {
		this.direction = TypeDirection.FORWARD;
		if (origin.getColum() > destination.getColum() ||
			origin.getRow() > destination.getRow()){
			this.direction = TypeDirection.BACK;
		} 
	}	
	
	private void setDistance(Coordinate origin, Coordinate destination) {
		this.distance = 0;
		if (this.type == TypeMovement.HORIZONTAL || this.type == TypeMovement.DIAGONAL) {
			this.distance = Math.abs(origin.getColum() - destination.getColum());
		}
		if (this.type == TypeMovement.VERTICAL) {
			this.distance = Math.abs(origin.getRow() - destination.getRow());
		}
	}
	
	private void setFreeWay(Coordinate origin, Board board) {
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
			Square box = board.getSquare(nextCoordenate);
			if (box.hasPiece()) {
				this.freeWay = false;
				return;
			}
			nextFila += incrementToNextFila;
			nextColum += incrementToNextColum;
		}
		
		this.freeWay = true;
	}
	
	private void setEatPeace(Board board, Color color, Coordinate destination) {
		this.eatPeace = false;
		Square boxDestination = board.getSquare(destination);
		if(!boxDestination.isColor(color)) {
			this.eatPeace = true;
		}
	}
	
	public TypeMovement getType() {
		return this.type;
	}

	public TypeDirection getDirection() {
		return this.direction;
	}

	public int getDistance() {
		return this.distance;
	}

	public boolean isFreeWay() {
		return this.freeWay;
	}

	public boolean isEatPeace() {
		return eatPeace;
	}
}

