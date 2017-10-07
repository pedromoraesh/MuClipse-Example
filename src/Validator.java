
public class Validator {

	
	public static int whatKindOfNumber(String toConvert){
		// I V X L C D M
		// Numeros da tabela ASCii equivalentes aos caracteres romanos
		int[] inteiros = new int[] { 73, 86, 88, 76, 67, 68, 77};
		int letters = 0;
		int numbers = 0;
		String validString = toConvert.toUpperCase();
		
		for (int i = 0; i < validString.length(); i++) {
			if(validString.charAt(i) >= 48 && validString.charAt(i) <= 57){
				numbers += 1;
			}
		}
		
		for (int i = 0; i < validString.length(); i++) {
			for (int j = 0; j < inteiros.length; j++) {
				if(validString.charAt(i)== inteiros[j]){
					letters += 1;
				}
			}
		}
		// 1 Numero Romano
		// 2 Numero Ar�bico
		// 3 Numero Misto, mas cont�m caracteres v�lidos
		// 4 Numero totalmente inv�lido
		
		if(letters + numbers == validString.length()){
			if(letters > 0 && numbers == 0){
				return 1;
			}
			if(numbers > 0 && letters == 0){
				return 2;
			}
			else{
				return 3;
			}
		}
		else{
			return 4;
		}
		
	}
	
	public static int arabicEquivalent(char roman){
		if(roman == 'I'){
			return 1;
		}
		if(roman == 'V'){
			return 5;
		}
		if(roman == 'X'){
			return 10;
		}
		if(roman == 'L'){
			return 50;
		}
		if(roman == 'C'){
			return 100;
		}
		if(roman == 'D'){
			return 500;
		}
		if(roman == 'M'){
			return 1000;
		}		
		
		return 0;
	}
	
	public static boolean isValidNumber(int number){
		return number > 0 && number <= 1000;
	}
	
//	public static int isBiggerThan(char left, char right){
//		int arabicLeft = arabicEquivalent(left);
//		int arabicRight = arabicEquivalent(right);
//		if(arabicRight > arabicLeft){
//			return arabicRight - arabicLeft;
//		}
//		else{
//			return arabicRight;
//		}
//		
//	}
	
	public static int toArabic(String roman){
		int arabicEquivalent = 0;
		int left, right;
		//Ocorreu uma subtra��o na ultima verifica��o? EX:CMIII, ocorre uma subtra��o em CM, nos ultimos caracteres
		boolean signalLastCharacter = true;
		String romanUpperCase = roman.toUpperCase();
		if(whatKindOfNumber(romanUpperCase)== 1){
			for (int i = romanUpperCase.length()-1; i > 0; i--) {
				left = arabicEquivalent(romanUpperCase.charAt(i-1));
				right = arabicEquivalent(romanUpperCase.charAt(i));
				if(right > left){
					arabicEquivalent += (right - left);	
					if(i==1){
						signalLastCharacter = false;
					}
					i--;
				}
				else{
					arabicEquivalent += right;
				}
						
			}
			if(signalLastCharacter == true){
				arabicEquivalent += arabicEquivalent(romanUpperCase.charAt(0));
			}
		}
		
		if(isValidNumber(arabicEquivalent))
			return arabicEquivalent;
		else
			return 0;
	}
	
	public static String toRoman(String arabic) {
		
		
		if(whatKindOfNumber(arabic)== 2){
			int num = Integer.parseInt(arabic);
		 	if(isValidNumber(num)){
		    	
				StringBuilder sb = new StringBuilder();
				
				// vezes em que foi poss�vel dividir o numero por determinado valor, o qual vai fazer com que tantas
				// vezes seja colocado na string o romano equivalente ao numero que foi usado como divisor.
			    int vezes = 0;
			    		    
			    // Todos os casos de romanos "fixados" inclusive quando ocorrem casos de subtra��o	   
			    String[] romanos = new String[] { "I", "IV", "V", "IX", "X", "XL", "L",
			            "XC", "C", "CD", "D", "CM", "M" };
			    int[] inteiros = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
			            900, 1000 };
			    
			    
			    for (int i = inteiros.length - 1; i >= 0; i--) {
			        vezes = num / inteiros[i];
			        num %= inteiros[i];
			        while (vezes > 0) {
			            sb.append(romanos[i]);
			            vezes--;
			        }
			    }
			    return sb.toString();
		    }
		}
	    return "";
	} 
}
