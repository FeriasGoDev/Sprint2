package ferias;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class TesteFerias {
	@Test
	public void calculaProximasFeriasdoUsuario() {
		SaldoFerias proximaFerias = new SaldoFerias(); //Aqui dentro, no consturtor proximasFerias é calculada
		assertEquals(LocalDate.of(2022, 4, 19), proximaFerias.getProximasFerias());
	}

// Generalizar para a função receber faltasDoControleDePonto
	
	@Test 
public void creditoDeFerias() {
	SaldoFerias creditoDias = new SaldoFerias ();
	creditoDias.creditarDiasDeFerias();
	assertEquals(24, creditoDias.creditarDiasDeFerias());
 }
	
	public void CreditarDiasDasFerias() {
		SaldoFerias creditoferias = new SaldoFerias();
		assertEquals(24, creditoferias.creditarDiasDeFerias());
		
		
	}
}
