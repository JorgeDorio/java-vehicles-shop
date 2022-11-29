package main;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Moto extends Veiculo {
	private double imposto = 0.15;

	public void cadastro() {
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
		
		this.setModelo(marca.getName());
		this.setMarca(modelo.getName());
		this.setValor(Double.parseDouble(valor.getName()));
	}

	@Override
	public double getImposto() {
		return this.getValor() * this.imposto;
	}
}
