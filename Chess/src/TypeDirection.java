enum TypeDirection{
	FORWARD('F'),
	BACK('B'),
	UNKNOWN('X');	
	
	private char keyword;
	
	TypeDirection (char keyword){
		this.keyword = keyword;		
	}
}
