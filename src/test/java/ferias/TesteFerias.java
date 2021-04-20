package ferias;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class TesteFerias {
	

// Generalizar para a função receber faltasDoControleDePonto
	@Test
	public void feriasTotal() {
		LocalDate data1 = LocalDate.of(2021, 4, 15);
		LocalDate data2 = LocalDate.of(2021, 5, 15); // 30 dias
		
		Ferias ferias = new Ferias(data1, data2, 30); //30 creditos
		assertTrue(ferias.checarValidade());
		assertEquals(ferias.getTipo(), TiposFerias.TOTAL);
		assertTrue(ferias.getDiasVendidos() == 0);
	}
	
	@Test
	public void feriasParcial() {
		LocalDate data1 = LocalDate.of(2021, 4, 15);
		LocalDate data2 = LocalDate.of(2021, 5, 5); // 20 dias
		// lembrando que CREDITOS_MINIMOS_FERIAS_FRACIONADAS = 15;
		// Sobram menos do que 15 creditos, logo a ferias é parcial e os dias restantes serão vendidos;
		
		Ferias ferias = new Ferias(data1, data2, 30);
		assertTrue(ferias.checarValidade());
		assertEquals(TiposFerias.PARCIAL, ferias.getTipo());
		assertTrue(ferias.getDiasVendidos() > 0);
	}
	
	@Test
	public void feriasFracionada() {
		LocalDate data1 = LocalDate.of(2021, 4, 16);
		LocalDate data2 = LocalDate.of(2021, 5, 1); //15 dias 
		// lembrando que CREDITOS_MINIMOS_FERIAS_FRACIONADAS = 15; <- creditos que restariam
		
		Ferias ferias = new Ferias(data1, data2, 30);
		assertTrue(ferias.checarValidade());
		assertTrue(ferias.getDiasVendidos() == 0);
		assertEquals(TiposFerias.FRACIONADA, ferias.getTipo());
	}
	
	@Test
	public void feriasVendida() {
		FeriasVendida ferias = new FeriasVendida(30); // 30 creditos para vender
		assertTrue(ferias.checarValidade());
		assertTrue(ferias.getDiasVendidos() == 30);
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
	public void feriasInvalida_SemCreditosSuficientes() {
		LocalDate data1 = LocalDate.of(2021, 4, 15);
		LocalDate data2 = LocalDate.of(2021, 12, 15);
		
		Ferias ferias = new Ferias(data1, data2, 15);
		assertFalse(ferias.checarValidade());
		assertEquals(TiposFerias.INVALIDA, ferias.getTipo());
	}
}
