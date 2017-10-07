import junit.framework.Assert;
import junit.framework.TestCase;


public class Testing extends TestCase {

	/* 
	 * Testando os numeros romanos padrões I, V, X, L, C, D e M
	 */
	
	public void testStaticNumbers(){
				
		Assert.assertEquals(1, Validator.arabicEquivalent('I'));
		Assert.assertEquals(5, Validator.arabicEquivalent('V'));
		Assert.assertEquals(10, Validator.arabicEquivalent('X'));
		Assert.assertEquals(50, Validator.arabicEquivalent('L'));
		Assert.assertEquals(100, Validator.arabicEquivalent('C'));
		Assert.assertEquals(500, Validator.arabicEquivalent('D'));
		Assert.assertEquals(1000, Validator.arabicEquivalent('M'));
		Assert.assertEquals(0, Validator.arabicEquivalent('Y'));
		
	}
	
	/*
	 * Testando se o numero pesquisado está dentro do limite estipulado em sala (0 e 1000)
	 */
	
	public void testLimitNumber(){
		
		Assert.assertTrue(Validator.isValidNumber(1000));
		Assert.assertFalse(Validator.isValidNumber(-1));
		Assert.assertFalse(Validator.isValidNumber(1001));
		Assert.assertFalse(Validator.isValidNumber(0));
	}
	
	/*
	 * Teste para verificar qual o maior numero romano
	 * OBS: Não foi necessário, pois de acordo com os testes, tive que decrementar o i do for(convertToArabic)
	 * em -1 para o mesmo pular uma letra no caso de o subtração na conversão.	
	 */
//	@Test
//	public void testBigger(){
//		assertEquals(9,Validator.isBiggerThan('I', 'X'));
//		assertEquals(50,Validator.isBiggerThan('L', 'X'));
//	}
	/*
	 * Teste de conversão direta de romano para arabico
	 */
	
	public void testRomanToArabic(){
		Assert.assertEquals(71, Validator.toArabic("LXXI"));
		Assert.assertEquals(1000, Validator.toArabic("M"));
		Assert.assertEquals(745, Validator.toArabic("DCCXLV"));
		Assert.	assertEquals(900, Validator.toArabic("CM"));
		
		/*
		 * "0" por que MI não é um numero entre 0 e 1000. Como 0 não existe em romano, retorno o mesmo como sinal
		 * de erro
		*/
		Assert.	assertEquals(0, Validator.toArabic("MI"));
		System.out.println(Validator.toArabic("DCCXLV"));
		System.out.println(Validator.toArabic("DCC10"));
		Assert.	assertEquals(0, Validator.toArabic("M20"));
		Assert.	assertEquals(0, Validator.toArabic("X29"));
		Assert.	assertEquals(0, Validator.toArabic("asd"));
		Assert.assertEquals(30, Validator.toArabic("xxx"));
		
		
		
	}
	/*
	 * Teste de fato da conversão de Arábico para romano
	 */
	
	public void testArabicToRoman(){
		Assert.assertEquals("LXXI", Validator.toRoman("71"));
		Assert.assertEquals("", Validator.toRoman("0"));
		Assert.	assertEquals("", Validator.toRoman("1001"));
		System.out.println(Validator.toRoman("998"));
		Assert.	assertEquals("", Validator.toRoman("X29"));
		Assert.assertEquals("", Validator.toRoman("asd"));
		Assert.assertEquals("", Validator.toRoman("xxx"));
		
	}

	

}
