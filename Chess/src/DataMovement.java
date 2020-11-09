public class DataMovement {
	
	private TypeMovement type;
	private TypeDirection direction;
	private int distance;
	
	public DataMovement(TypeMovement type, TypeDirection direction, int distance) {
		this.type = type;
		this.direction = direction;
		this.distance = distance;
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
}

