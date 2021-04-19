package ferias;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

public class TestFeriasRequerimento {

	
	
	@Test
	public void testRetornarIntervaloEmDiasEntreAsDatas() {
		FeriasRequerimento ferias = new FeriasRequerimento();
		LocalDate inicio = LocalDate.of(2021, 4, 1);
		LocalDate termino = LocalDate.of(2021, 5, 1);
		short dias = ferias.retornarIntervaloEmDiasEntreAsDatas(inicio, termino);
		assertEquals(30, dias);
	}
	
	
	@Test
	public void testRetornarIntervaloEmDiasEntreAsDatas_DataIncioMaiorQueDataTermino() {
		FeriasRequerimento ferias = new FeriasRequerimento();
		LocalDate inicio = LocalDate.of(2021, 4, 19);
		LocalDate termino = LocalDate.of(2021, 4, 1);
		short dias = ferias.retornarIntervaloEmDiasEntreAsDatas(inicio, termino);
		assertTrue(dias < 0);

	}
	

	@Test
	public void testValidacaoPrazoSolicitacaoDeFerias() {
		FeriasRequerimento ferias = new FeriasRequerimento();
		ferias.setDataSolicitacao(LocalDate.of(2021, 4, 20));
		LocalDate inicio = LocalDate.of(2021, 4, 30);
		boolean resultado = ferias.validacaoPrazoSolicitacaoDeFerias(inicio);
		assertTrue(resultado);

	}

	@Test
	public void testValidacaoPrazoSolicitacaoDeFerias_False() {
		FeriasRequerimento ferias = new FeriasRequerimento();
		ferias.setDataSolicitacao(LocalDate.of(2021,4,11));
		LocalDate inicio = LocalDate.of(2021, 4, 19);
		boolean resultado = ferias.validacaoPrazoSolicitacaoDeFerias(inicio);
		assertFalse(resultado);

	}
	
}
