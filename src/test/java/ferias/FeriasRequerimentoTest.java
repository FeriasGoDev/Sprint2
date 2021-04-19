package ferias;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class FeriasRequerimentoTest {



	@Test
	public void testRetornarIntervaloEmDiasEntreAsDatas() {
		FeriasRequerimento ferias = new FeriasRequerimento();
		LocalDate inicio = LocalDate.of(2021, 4, 1);
		LocalDate termino = LocalDate.of(2021, 5, 1);
		short dias = ferias.retornarIntervaloEmDiasEntreAsDatas(inicio, termino);
		assertEquals(30, dias);

	}
	
	@Test
	public void testRetornarIntervalo_DiasEntreAsDatas() {
		FeriasRequerimento ferias = new FeriasRequerimento();
		LocalDate inicio = LocalDate.of(2021, 5, 1);
		LocalDate termino = LocalDate.of(2021, 4, 1);
		short dias = ferias.retornarIntervaloEmDiasEntreAsDatas(inicio, termino);
		assertEquals(-1, dias);

	}
	

	@Test
	public void testValidacaoPrazoSolicitacaoDeFerias() {
		FeriasRequerimento ferias = new FeriasRequerimento();
		ferias.setDataSolicitacao(LocalDate.of(2021, 4, 20));
		LocalDate inicio = LocalDate.of(2021, 4, 30);
		boolean resultado = ferias.validacaoParaSolicitacaoDeFerias(inicio);
		assertTrue(resultado);

	}

	@Test
	public void testValidacaoPrazoSolicitacaoDeFeriasFalse() {
		FeriasRequerimento ferias = new FeriasRequerimento();
		ferias.setDataSolicitacao(LocalDate.of(2021, 4, 25));
		LocalDate inicio = LocalDate.of(2021, 4, 30);
		boolean resultado = ferias.validacaoParaSolicitacaoDeFerias(inicio);
		assertFalse(resultado);

	}
}
