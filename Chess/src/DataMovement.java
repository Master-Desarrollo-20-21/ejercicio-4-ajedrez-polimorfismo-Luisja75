public class DataMovement {
	
	private TypeMovement type;
	private TypeDirection direction;
	private int distance;
	private boolean freeWay;
	
	public DataMovement(TypeMovement type, TypeDirection direction, int distance, boolean freeway) {
		this.type = type;
		this.direction = direction;
		this.distance = distance;
		this.freeWay = freeWay;
	}

	public TypeMovement getType() {
		return type;
	}

	public TypeDirection getDirection() {
		return direction;
	}

	public int getDistance() {
		return distance;
	}

	public boolean getFreeWay() {
		return freeWay;
	}
}

