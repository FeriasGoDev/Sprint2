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
//		FeriasEntrada ferias = new FeriasEntrada(data1, data2);
//		
//		assertEquals(10, ferias.diasVendidos);
//
//	}
	
// Generalizar para a função receber faltasDoControleDePonto
	
	@Test 
public void creditoDeFerias() {
	SaldoFerias creditoDias = new SaldoFerias ();
	creditoDias.creditarDiasDeFerias();
	assertEquals(24, creditoDias.creditarDiasDeFerias());
 }
	
}
