class Coordinate {
	
	public static final String[][] ALLOWS = {{"A", "B", "C", "D", "E", "F", "G", "H"}, {"1", "2", "3", "4", "5", "6", "7", "8"}};
	private int row;
	private int column;


	public Coordinate() {
	}
	
	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

    public boolean equal(Coordinate coordenada) {
        assert coordenada != null;
        return row == coordenada.row && column == coordenada.column;
    }

    public boolean equalRow(Coordinate coordenada) {
        assert coordenada != null;
        return column == coordenada.column;
    }

    public boolean equalColumn(Coordinate coordenada) {
        assert coordenada != null;
        return row == coordenada.row;
    }
    
    public void recoger(int limitDown, int limitUp) {
        Console console = new Console();
		String value;
		do {
			console.out("Introduce la cordenada (A1 ... H8): ");
	        value = console.inString();
		} while (!coordenadaValida(value));   	
    }  
    
	private boolean coordenadaValida(String value) {
		if (value.length() !=  2){
			return false;
		}

		int[] values = {-1, -1}; 
		for (int i=0; i<value.length(); i++) {
			for (int j=0; j<ALLOWS[i].length; j++) {
				if (value.substring(i,i+1).toUpperCase().equals(ALLOWS[i][j])){
					values[i] = j+1;
				}
			}
		}
		this.row = values[0];
		this.column = values[1];
		
		return (values[0] != -1 && values[1] != -1);
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColum() {
		return this.column;
	}
}
