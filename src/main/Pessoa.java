package main;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public abstract class Pessoa {
	private String nome;
	private String endereco;
	private String contato;
	protected double desconto;
	private String documento;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public void setDesconto(double valor) {
		this.desconto = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public abstract void cadastro();

	public abstract double getDesconto(double valorTotal);

	public static int selecionarTipo() {
		Object[] botoes = { "Pessoa Física", "Pessoa Jurídica" };

		int result = JOptionPane.showOptionDialog(null, new JLabel("Selecione o tipo de cliente que deseja cadastrar"),
				null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, botoes, null);

		return result;
	}

	public static void listarClientes(ArrayList<Fisica> arrPF, ArrayList<Juridica> arrPJ) {
		String lista = "Clientes Pessoa Física:\n\n";

		for (int i = 0; i < arrPF.size(); i++) {
			lista += "Nome: " + arrPF.get(i).getNome() + "\nCPF: " + arrPF.get(i).getDocumento() + "\nEndereço: "
					+ arrPF.get(i).getEndereco() + "\nContato: " + arrPF.get(i).getContato() + "\n\n";
		}

		lista += "Clientes Pessoa Jurídica:\n\n";

		for (int i = 0; i < arrPJ.size(); i++) {
			lista += "Razão Social: " + arrPJ.get(i).getNome() + "\nCPF: " + arrPJ.get(i).getDocumento() + "\nEndereço: "
					+ arrPJ.get(i).getEndereco() + "\n Contato" + arrPJ.get(i).getContato() + "\n\n";
		}

		JOptionPane.showMessageDialog(null, lista);
	}
}
