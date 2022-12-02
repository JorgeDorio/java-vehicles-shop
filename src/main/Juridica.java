package main;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Juridica extends Pessoa {
	public Juridica() {
		this.desconto = 0.1;
	}

	@Override
	public double getDesconto(double valorTotal) {
		return valorTotal * desconto;
	}

	@Override
	public void cadastro() {
		Boolean repete = true;
		while (repete) {
			JPanel panel = new JPanel();
			panel.add(new JLabel("Cadastro Pessoa Jurídica"));
			panel.add(new JLabel(""));
			panel.add(new JLabel(""));
			panel.add(new JLabel(""));
			panel.setLayout(new GridLayout(0, 2));
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

			if (nome.getText().length() < 3 || nome.getText().matches("-?\\d+(\\.\\d+)?")) {
				JOptionPane.showMessageDialog(null, "Nome inválido.");
			} else if (cnpj.getText().length() != 11 || !cnpj.getText().matches("-?\\d+(\\.\\d+)?")) {
				JOptionPane.showMessageDialog(null, "CPF inválido.");
			} else if (endereco.getText().length() < 5) {
				JOptionPane.showMessageDialog(null, "Endereço inválido.");
			} else if ((contato.getText().length() < 11 || !contato.getText().matches("-?\\d+(\\.\\d+)?"))
					&& (contato.getText().length() < 7 || !contato.getText().matches("^(.+)@(.+)$"))) {
				JOptionPane.showMessageDialog(null, "O contato deve ser um telefone ou um email válido");
			} else {
				repete = false;
				this.setNome(nome.getText());
				this.setDocumento(cnpj.getText());
				this.setEndereco(endereco.getText());
				this.setContato(contato.getText());
			}
		}
	}
}
