enum TypeMovement{
	HORIZONTAL("H"),
	VERTICAL("V"),
	DIAGONAL("D"),
	DIAGONAL_BY_EAT("E"),
	L("L"),
	UNKNOWN("X");	
	
	private String keyword;
	
	TypeMovement (String  keyword){
		this.keyword = keyword;
		
	}
		
	public String getKeyword(){
		return keyword;
	}
}
