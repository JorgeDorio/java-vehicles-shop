package main;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Moto extends Veiculo {
	public Moto() {
		this.imposto = 0.15;
	}

	public void cadastro() {
		Boolean repete = true;

		while (repete) {
			JPanel panel = new JPanel();
			panel.add(new JLabel("Cadastro Moto"));
			panel.add(new JLabel(""));
			panel.add(new JLabel(""));
			panel.add(new JLabel(""));
			panel.setLayout(new GridLayout(0, 2));
			JTextField marca = new JTextField(15);
			JTextField modelo = new JTextField(15);
			JTextField valor = new JTextField(15);

			panel.add(new JLabel("Marca: "));
			panel.add(marca);
			panel.add(new JLabel("Modelo: "));
			panel.add(modelo);
			panel.add(new JLabel("Valor unitário: "));
			panel.add(valor);

			JOptionPane.showMessageDialog(null, panel);

			if (marca.getText().length() < 3 || marca.getText().matches("-?\\d+(\\.\\d+)?")) {
				JOptionPane.showMessageDialog(null, "Marca inválida.");
			} else if (modelo.getText().length() < 3 || modelo.getText().matches("-?\\d+(\\.\\d+)?")) {
				JOptionPane.showMessageDialog(null, "Modelo inválido.");
			} else if (valor.getText().length() == 0 || !valor.getText().matches("-?\\d+(\\.\\d+)?")) {
				JOptionPane.showMessageDialog(null, "Valor inválido.");
			} else {
				repete = false;
				this.setModelo(marca.getText());
				this.setMarca(modelo.getText());
				this.setValor(Double.parseDouble(valor.getText()));
			}
		}
	}

	@Override
	public double getImposto() {
		return this.getValor() * this.imposto;
	}
}
