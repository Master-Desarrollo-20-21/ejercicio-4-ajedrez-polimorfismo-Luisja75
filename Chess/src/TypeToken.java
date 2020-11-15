enum TypeToken {
	ROOK('R'),
	KNIGHT('N'),
	BISHOP('B'),
	QUEEN('Q'),
	KING('K'),
	PAWN('P');
	
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
