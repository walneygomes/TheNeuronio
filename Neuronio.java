import java.util.ArrayList;
import java.util.List;

public class Neuronio {
	private int id;
	private static final int CAPACIDADE_INFORM = 500;
	ArrayList<Neuronio> conecta = new ArrayList<Neuronio>();
	String[] informacao = new String[CAPACIDADE_INFORM];
	static int numeroInformacao = 0;
	static int numeroInformcaoAddicional = 0;

	public void inserirInformcao(String dados) {
		if (verificarCapacidade()) {
			for (Neuronio n : conecta) {
				int amazena = n.getNumeroInformacao();
				int amazenaOutro = n.getNumeroInformcaoAddicional();
				n.inserirInformcao(dados);
				numeroInformcaoAddicional++;
				if (n.getNumeroInformacao() > amazena) {
					break;
				}
				if (n.getNumeroInformcaoAddicional() > amazenaOutro) {
					break;
				}

			}
		} else {
			this.informacao[numeroInformacao] = dados;
			this.numeroInformacao++;
		}
		criarConexao();
	}

	public void criarConexao() {
		conecta.add(new Neuronio());

	}

	public void criarNovasConexaoPor(int numero) {
		for (int i = 0; i < numero; i++) {
			criarConexao();
		}
	}

	public static int getNumeroInformcaoAddicional() {
		return numeroInformcaoAddicional;
	}

	public static void setNumeroInformcaoAddicional(int numeroInformcaoAddicional) {
		Neuronio.numeroInformcaoAddicional = numeroInformcaoAddicional;
	}

	public boolean verificarCapacidade() {
		if (this.getNumeroInformacao() == this.CAPACIDADE_INFORM) {
			return true;
		}

		return false;
	}

	public static int getNumeroInformacao() {
		return numeroInformacao;
	}

	public static void setNumeroInformacao(int numeroInformacao) {
		Neuronio.numeroInformacao = numeroInformacao;
	}

	public ArrayList<Neuronio> getConecta() {
		return conecta;
	}

	public void setConecta(ArrayList<Neuronio> conecta) {
		this.conecta = conecta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
