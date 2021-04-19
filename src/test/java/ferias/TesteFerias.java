package ferias;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class TesteFerias {

	@Test
	public void feriasTotal() {
		LocalDate data1 = LocalDate.of(2021, 4, 15);
		LocalDate data2 = LocalDate.of(2021, 5, 15); // 30 dias
		
		Ferias ferias = new Ferias(data1, data2, 30); //30 creditos
		assertTrue(ferias.checarValidade());
		assertEquals(ferias.getTipo(), TiposFerias.TOTAL);
	}
	
	@Test
	public void feriasParcial() {
		LocalDate data1 = LocalDate.of(2021, 4, 15);
		LocalDate data2 = LocalDate.of(2021, 5, 5); // 20 dias
		
		Ferias ferias = new Ferias(data1, data2, 30);
		assertTrue(ferias.checarValidade());
		assertEquals(TiposFerias.PARCIAL, ferias.getTipo());
	}
	
	@Test
	public void feriasFracionada() {
		LocalDate data1 = LocalDate.of(2021, 4, 16);
		LocalDate data2 = LocalDate.of(2021, 5, 1); //15 dias 
		// lembrando que DIAS_MAXIMOS_FERIAS_FRACIONADAS = 15;
		
		Ferias ferias = new Ferias(data1, data2, 30);
		assertTrue(ferias.checarValidade());
		assertEquals(TiposFerias.FRACIONADA, ferias.getTipo());
	}
	
	@Test
	public void feriasVendida() {
		FeriasVendida ferias = new FeriasVendida(30); // 30 creditos para vender
		assertTrue(ferias.checarValidade());
		assertEquals(TiposFerias.VENDIDA, ferias.getTipo());
	}
	
	@Test
	public void feriasInvalida_DataInicioPosteriorADataFim() {
		LocalDate data1 = LocalDate.of(2021, 6, 15);
		LocalDate data2 = LocalDate.of(2021, 5, 15);
		
		Ferias ferias = new Ferias(data1, data2, 30);
		assertFalse(ferias.checarValidade());
		assertEquals(TiposFerias.INVALIDA, ferias.getTipo());
	}
	
	@Test
	public void feriasInvalida_PeriodoGrandeDemais() {
		LocalDate data1 = LocalDate.of(2021, 4, 15);
		LocalDate data2 = LocalDate.of(2021, 12, 15);
		
		Ferias ferias = new Ferias(data1, data2, 15);
		assertFalse(ferias.checarValidade());
		assertEquals(TiposFerias.INVALIDA, ferias.getTipo());
	}
	
}
