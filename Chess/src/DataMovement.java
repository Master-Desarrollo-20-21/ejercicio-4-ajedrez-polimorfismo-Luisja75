public class DataMovement {
	
	private TypeMovement type;
	private TypeDirection direction;
	private int distance;
	private boolean freeWay;
	
	public DataMovement(TypeMovement type, TypeDirection direction, int distance, boolean freeWay) {
		this.type = type;
		this.direction = direction;
		this.distance = distance;
		this.freeWay = freeWay;
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

	public boolean getFreeWay() {
		return this.freeWay;
	}
}

