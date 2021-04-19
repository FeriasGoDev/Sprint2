package ferias;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class TesteFerias {

//	@Test
//	public void testDiasVendidos() {
//		Ferias ferias = new Ferias(LocalDate.of(2021, 04, 16), LocalDate.of(2021, 05, 16));
//		ferias.calcularDiasVendidos();
//		assertEquals(30, ferias.diasVendidos);
//
//	}
	@Test
	public void calculaProximasFeriasdoUsuario() {
		SaldoFerias proximaFerias = new SaldoFerias(); //Aqui dentro, no consturtor proximasFerias é calculada
		assertEquals(LocalDate.of(2022, 4, 19), proximaFerias.getProximasFerias());
	}

	public void CreditarDiasDasFerias() {
		SaldoFerias creditoferias = new SaldoFerias();
		assertEquals(24, creditoferias.creditarDiasDeFerias());
		
		
	}
}
