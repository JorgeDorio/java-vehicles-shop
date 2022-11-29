package main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Menu {
	public static int render() {
		Object[] botoes = { "Cadastrar Cliente", "Cadastrar Veículo", "Listar Clientes", "Listar Veículos", "Cadastrar Compra"};

		int result = JOptionPane.showOptionDialog(null, new JLabel("Escolha a ação que deseja realizar"),
				null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, botoes, null);

		return result;
	}
}
