package ferias;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * 
 * @author Jonata e Leonardo Pereira
 *
 */
//TODO: Documentar
public class FeriasRequerimento {
	private String identificadorUsuario; // FK Foreign Key do usuário
	private Ferias feriasRequisitada; // Instância de Férias
	private EstadosRequisicao estadoRequisicao; // ENUM
	private LocalDate dataSolicitacao;

	public String getIdentificadorUsuario() {
		return identificadorUsuario;
	}

	public void setIdentificadorUsuario(String identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
	}

	public Ferias getFeriasRequisitada() {
		return feriasRequisitada;
	}

	public void setFeriasRequisitada(Ferias feriasRequisitada) {
		this.feriasRequisitada = feriasRequisitada;
	}

	public EstadosRequisicao getEstadoRequisicao() {
		return estadoRequisicao;
	}

	public void setEstadoRequisicao(EstadosRequisicao estadoRequisicao) {
		this.estadoRequisicao = estadoRequisicao;
	}
	

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	static short PRAZO_MINIMO_SOLICITACAO_FERIAS = 10;
	
	public FeriasRequerimento() {
		
	}

	public FeriasRequerimento(String identificadorUsuario, Ferias feriasRequisitada) {
		this.identificadorUsuario = identificadorUsuario;
		this.feriasRequisitada = feriasRequisitada;
		this.estadoRequisicao = EstadosRequisicao.EM_ANALISE;
		this.dataSolicitacao = LocalDate.now();
	}


	public FeriasRequerimento() {
		// TODO Auto-generated constructor stub
	}

	public String getIdentificadorUsuario() {
		return identificadorUsuario;
	}

	public void setIdentificadorUsuario(String identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
	}

	public Ferias getFeriasRequisitada() {
		return feriasRequisitada;
	}

	public void setFeriasRequisitada(Ferias feriasRequisitada) {
		this.feriasRequisitada = feriasRequisitada;
	}

	public EstadosRequisicao getEstadoRequisicao() {
		return estadoRequisicao;
	}

	public void setEstadoRequisicao(EstadosRequisicao estadoRequisicao) {
		this.estadoRequisicao = estadoRequisicao;
	}
	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	/*
	 * Atualiza o estado da requisição
	 * 
	 * Verifica se o novoEstado está registrado nas ENUMS do sistema Atualiza o
	 * estado do requerimento
	 * 
	 * @return true/false sucesso da operação.
	 */
	public void atualizarEstadoRequisicao(EstadosRequisicao novoEstado) {
		// Verificar os estados dentro do ENUM);
		setEstadoRequisicao(novoEstado);
	}

	/**
	 * Retorna quantidade de dias
	 * 
	 * Retorna a quantidade de dias em formato short, a partir das datas de início e
	 * término informadas.
	 * 
	 * @param inicio  Data de início.
	 * @param termino Data de término.
	 * 
	 */
	public short retornarIntervaloEmDiasEntreAsDatas(LocalDate inicio, LocalDate termino) {
		short dias = (short) ChronoUnit.DAYS.between(inicio, termino);
		if(inicio.isBefore(termino)) {
			return dias;
		}
		return -1;
	}

	/**
	 * Retorna um boolean obtido atraves da comparacao entre a data de inicio de
	 * ferias e a variavel PRAZO_MINIMO_SOLICITACAO_FERIAS. Para o boolean retornar
	 * true, o (intervalo) deve ser maior que a variavel
	 * PRAZO_MINIMO_SOLICITACAO_FERIAS, neste caso aplicamos o short 10.
	 * 
	 * @param dataInicioFerias
	 * 
	 */
	public boolean validacaoPrazoSolicitacaoDeFerias(LocalDate dataInicio) {
		int intervalo = retornarIntervaloEmDiasEntreAsDatas(getDataSolicitacao(), dataInicio);
		System.out.println(intervalo);
		if (intervalo >= PRAZO_MINIMO_SOLICITACAO_FERIAS) {
			return true;
		} else {
			return false;

		}
	}


}
