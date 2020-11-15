enum TypeMovement{
	HORIZONTAL("H"),
	VERTICAL("V"),
	DIAGONAL("D"),
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
