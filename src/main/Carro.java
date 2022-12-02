package main;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Carro extends Veiculo {
	private int quantPortas;

	public Carro() {
		this.imposto = 0.3;
	}

	public int getQuantPortas() {
		return quantPortas;
	}

	public void setQuantPortas(int quantPortas) {
		this.quantPortas = quantPortas;
	}

	public void cadastro() {
		Boolean repete = true;

		while (repete) {
			JPanel panel = new JPanel();
			panel.add(new JLabel("Cadastro Carro"));
			panel.add(new JLabel(""));
			panel.add(new JLabel(""));
			panel.add(new JLabel(""));
			panel.setLayout(new GridLayout(0, 2));
			JTextField marca = new JTextField(15);
			JTextField modelo = new JTextField(15);
			JTextField valor = new JTextField(15);
			JTextField quantPortas = new JTextField(15);

			panel.add(new JLabel("Marca: "));
			panel.add(marca);
			panel.add(new JLabel("Modelo: "));
			panel.add(modelo);
			panel.add(new JLabel("Valor unitário: "));
			panel.add(valor);
			panel.add(new JLabel("Quantidade de portas: "));
			panel.add(quantPortas);

			JOptionPane.showMessageDialog(null, panel);

			if (marca.getText().length() < 3 || marca.getText().matches("-?\\d+(\\.\\d+)?")) {
				JOptionPane.showMessageDialog(null, "Marca inválida.");
			} else if (modelo.getText().length() < 3 || modelo.getText().matches("-?\\d+(\\.\\d+)?")) {
				JOptionPane.showMessageDialog(null, "Modelo inválido.");
			} else if (valor.getText().length() == 0 || !valor.getText().matches("-?\\d+(\\.\\d+)?")) {
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			} else if (Integer.parseInt(quantPortas.getText()) < 1 && Integer.parseInt(quantPortas.getText()) > 6) {
				JOptionPane.showMessageDialog(null, "Quantidade de portas inválido");
			} else {
				repete = false;
				this.setModelo(marca.getText());
				this.setMarca(modelo.getText());
				this.setValor(Double.parseDouble(valor.getText()));
				this.setQuantPortas(Integer.parseInt(quantPortas.getText()));
			}
		}
	}

	@Override
	public double getImposto() {
		return this.getValor() * this.imposto;
	}
}
