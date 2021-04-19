package ferias;

/**
 * Enumera os possiveis tipos de ferias;
 * @author SPRINT 2
 *
 */
public enum TiposFerias {
	INVALIDA, // Erro
	TOTAL, // Todos os dias s�o utilizados nas f�rias
	PARCIAL, // F�rias com uma fra��o dos dias dispon�veis, o restante � automaticamente vendido
	FRACIONADA, // Ferias com uma fra��o dos dias disponiveis, o restante continua como credito
	VENDIDA // Vende todos os dias dispon�veis
}
