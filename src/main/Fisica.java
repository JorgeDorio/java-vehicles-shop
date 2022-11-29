package main;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fisica extends Pessoa{
	private double desconto = 0.05;
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public double getDesconto(double d) {
		return d * desconto;
	}

	@Override
	public void cadastro() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Cadastro Pessoa Física"));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.setLayout(new GridLayout(0,2));
		JTextField nome = new JTextField(15);
		JTextField cpf = new JTextField(15);
		JTextField endereco = new JTextField(15);
		JTextField contato = new JTextField(15);

		panel.add(new JLabel("Nome: "));
		panel.add(nome);
		panel.add(new JLabel("CPF: "));
		panel.add(cpf);
		panel.add(new JLabel("Endereço: "));
		panel.add(endereco);
		panel.add(new JLabel("Contato: "));
		panel.add(contato);
		
		JOptionPane.showMessageDialog(null, panel);
		
		this.setNome(nome.getText());
		this.setCpf(cpf.getText());
		this.setEndereco(endereco.getText());
		this.setContato(contato.getText());
	}
}
