package main;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public abstract class Veiculo {
	private String marca;
	private String modelo;
	private double valor;
	protected double imposto;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public abstract double getImposto();
	
	public static int selecionarTipo() {
		Object[] botoes = { "Carro", "Motocicleta" };

		int result = JOptionPane.showOptionDialog(null, new JLabel("Selecione o tipo de veículo que deseja cadastrar"),
				null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, botoes, null);

		return result;
	}
	
	public static void listarVeiculos(ArrayList<Carro> arrCarro, ArrayList<Moto> arrMoto) {
		String lista = "Carros:\n\n";
		
		for (int i = 0; i < arrCarro.size(); i++) {
			lista += "Marca: " + arrCarro.get(i).getMarca()
					+ "\nModelo: " + arrCarro.get(i).getModelo()
					+ "\nValor unitário: " + arrCarro.get(i).getValor()
					+ "\nQuantidade de portas: " + arrCarro.get(i).getQuantPortas() + "\n\n";
		}
		
		lista += "Motos:\n\n";
		
		for (int i = 0; i < arrMoto.size(); i++) {
			lista += "Marca: " + arrMoto.get(i).getMarca()
					+ "\nModelo: " + arrMoto.get(i).getModelo()
					+ "\nValor unitário: " + arrMoto.get(i).getValor()
					+ "\n\n";
		}
		
		JOptionPane.showMessageDialog(null, lista);
	}

}
