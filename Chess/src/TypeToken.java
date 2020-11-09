enum TypeToken {
	KING('K'),
	PAWN('P'),
	KNIGHT('C');
	
	private char keyword;
	
	TypeToken (char  keyword){
		this.keyword = keyword;
		
	}
	
	public static TypeToken valueOf(char c) {
		for (TypeToken typeToken : values()){
			if (typeToken.keyword == c){
				return typeToken;
			}
		}
		return null;
	}		
	
	public String getKeyword(){
		return  String.valueOf(keyword);
	}
}
