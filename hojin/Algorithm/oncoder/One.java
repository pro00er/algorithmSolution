package oncoder;

public class One {
	static public void main(String[] args){
		System.out.println(new One().decryptSpell("OnCoder"));
	}
	public String decryptSpell(String str){
		if(str.length()<1 || str.length()>100){
			return "";
		}
		if(str.length()==2){
			return str;
		}
		
		char[] charArray = str.toCharArray();
		char[] resultChar = str.toCharArray();
		for(int i=2; i<charArray.length;i+=3){
			if((int)charArray[i] >= 97 &&
					(int)charArray[i] <=122){
				//소문자다 
				//대문자로 변경
				resultChar[i] = (char) ((char)((int)charArray[i])-(32));
			}else{
				//느낌표로 변경
				resultChar[i] = '!';
			}
		}
        return String.valueOf(resultChar);
    }
}
