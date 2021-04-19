package ferias;

/**
 * Enumera os possiveis tipos de ferias;
 * @author SPRINT 2
 *
 */
public enum TiposFerias {
	INVALIDA, // Erro
	TOTAL, // Todos os dias são utilizados nas férias
	PARCIAL, // Férias com uma fração dos dias disponíveis, o restante é automaticamente vendido
	FRACIONADA, // Ferias com uma fração dos dias disponiveis, o restante continua como credito
	VENDIDA // Vende todos os dias disponíveis
}
