package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("LossyEncoding")
@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@Test
	public void testComparaDoisNumerosIguaisRetorna0(){
		int compara = calc.compara(0,0);
		assertTrue(compara == 0);
	}

	@Test
	public void testComparaDoisDiferentesRetorna1(){
		int compara = calc.compara(0,0);
		assertTrue(compara == 0);
	}

	@Test
	public void testComparaDoisNumerosSeBMaiorqueARetorna_1(){
		int compara = calc.compara(0,1);
		assertTrue(compara == -1);
	}

	@Test
	public void testComparaDoisNumerosSeAMaiorqueBRetorna1(){
		int compara = calc.compara(100,1);
		assertTrue(compara == 1);
	}

	@Test
	public void testePositivo(){
		boolean ehPositivo = calc.ehPositivo(1000);
		assertTrue(ehPositivo);
	}

	@Test
	public void testeNãoEPositivo(){
		boolean ehNegativo = calc.ehPositivo(-1000);
		assertFalse(ehNegativo);
	}
	@Test
	public void testeSomatoria(){
		int somatoria = calc.somatoria(1);
		assertTrue(somatoria == 1);
	}

	@Test
	public void testeSubtraçao(){
		int subtrai = calc.subtracao(1,50);
		int esperado = -49;
		assertEquals(esperado,subtrai);
	}

	@Test
	public void testeMultiplicaçãoDoisNumerosPositivos(){
		int multiplica = calc.multiplicacao(10,10);
		int esperado = 100;
		assertEquals(esperado,multiplica);
	}
	@Test
	public void testeMultiplicaçãoDoisNumerosNegativos(){
		int multiplica = calc.multiplicacao(-10,-10);
		int esperado = 100;
		assertEquals(esperado,multiplica);
	}

}
