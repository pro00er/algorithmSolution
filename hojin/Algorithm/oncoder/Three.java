package oncoder;

public class Three {
	public static void main(String[] args) {
		
	}
	public String encoder(String message){
		char[] messageChar = message.toCharArray();
		int[] encoder = new int[message.length()];
		String binaryStr = "";
		String total = "";
		for(int i=0; i<message.length();i++){
			encoder[i] = this.parserCharToInt(messageChar[i]);
			binaryStr = Integer.toBinaryString(encoder[i]);
			total += this.parserBinaryTo6bit(binaryStr);
		}
		total = this.lastAddZero(total);
		String[] hex = new String[total.length()/8];
		int start=0;
		String result="";
		int temp10=0;
		String hexStr="";
		
		for(int i=0;i<hex.length;i++){
			hex[i] = total.substring(start,start+8);
			start += 8;
			temp10 = Integer.parseInt(hex[i],2);
			hexStr = Integer.toHexString(temp10);
			if(temp10<16){
				result += "0"+hexStr;
			}else{
				result +=hexStr;
			}
		}
        return result.toUpperCase();
    }
	public String lastAddZero(String str){
		int zeroCnt = 8 - (str.length()%8);
		if(zeroCnt == 8){
			return str;
		}
		String retrunStr = "";
		while(zeroCnt > 0){
			retrunStr += "0";
			zeroCnt--;
		}
		return str+retrunStr;
	}
	public String parserBinaryTo6bit(String binaryStr){
		if(binaryStr.length()>1){
			if(binaryStr.indexOf("0")==0){
				binaryStr = binaryStr.substring(1,binaryStr.length());
			}
		}
		int zeroCnt = 6-binaryStr.length();
		String retrunStr = "";
		while(zeroCnt > 0){
			retrunStr += "0";
			zeroCnt--;
		}
		return retrunStr+binaryStr;
	}
	
	public int parserCharToInt(char val){
		int checkVal = val;
		if(checkVal >= 97 && checkVal <=122){
			return checkVal-97;
		}else if(checkVal >= 65 && checkVal <=90){
			return checkVal-39;
		}else if(checkVal >= 48 && checkVal <=57){
			return checkVal+4;
		}else{
			return 62;
		}
	}
}
