package main;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Juridica extends Pessoa{
	private double desconto = 0.1;
	private String cnpj;

	@Override
	public double getDesconto(double valorTotal) {
		return valorTotal * desconto;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public void cadastro() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Cadastro Pessoa Jurídica"));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.setLayout(new GridLayout(0,2));
		JTextField nome = new JTextField(15);
		JTextField cnpj = new JTextField(15);
		JTextField endereco = new JTextField(15);
		JTextField contato = new JTextField(15);

		panel.add(new JLabel("Razão social: "));
		panel.add(nome);
		panel.add(new JLabel("CNPJ: "));
		panel.add(cnpj);
		panel.add(new JLabel("Endereço: "));
		panel.add(endereco);
		panel.add(new JLabel("Contato: "));
		panel.add(contato);
		
		JOptionPane.showMessageDialog(null, panel);
		
		this.setNome(nome.getText());
		this.setCnpj(cnpj.getText());
		this.setEndereco(endereco.getText());
		this.setContato(contato.getText());
	}
}
