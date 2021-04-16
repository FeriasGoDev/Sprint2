package ferias;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

public class TestFeriasRequerimento {

	@Test
	public void testRetornarIntervaloEmDiasEntreAsDatas() {
		LocalDate inicio = LocalDate.of(2021, 4, 1);
		LocalDate termino = LocalDate.of(2021, 5, 1);
		short dias = FeriasRequerimento.retornarIntervaloEmDiasEntreAsDatas(inicio, termino);
		assertEquals(30, dias);

	}

	@Test
	public void testValidacaoParaSolicitacaoDeFerias() {
		LocalDate inicio = LocalDate.of(2021, 4, 27);
		boolean resultado = FeriasRequerimento.validacaoParaSolicitacaoDeFerias(inicio);
		assertTrue(resultado);
		
	}

}
