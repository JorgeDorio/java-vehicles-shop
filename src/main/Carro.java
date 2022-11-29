package main;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Carro extends Veiculo {
	private double imposto = 0.3;
	private int quantPortas;

	public int getQuantPortas() {
		return quantPortas;
	}

	public void setQuantPortas(int quantPortas) {
		this.quantPortas = quantPortas;
	}

	public void cadastro() {
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

		this.setModelo(marca.getName());
		this.setMarca(modelo.getName());
		this.setValor(Double.parseDouble(valor.getName()));
		this.setQuantPortas(Integer.parseInt(quantPortas.getName()));
	}

	@Override
	public double getImposto() {
		return this.getValor() * this.imposto;
	}
}
