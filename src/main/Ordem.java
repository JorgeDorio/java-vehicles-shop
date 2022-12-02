package main;

import java.awt.GridLayout;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ordem {
	private int indexCliente;
	private int indexVeiculo;
	private Object clienteSelecionado;
	private Object veiculoSelecionado;
	private int formaDePagamento;
	private double desconto;
	private double imposto;

	public void cadastrar(ArrayList<Fisica> arrPF, ArrayList<Juridica> arrPJ, ArrayList<Carro> arrCarro,
			ArrayList<Moto> arrMoto) {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Cadastro Compra"));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.setLayout(new GridLayout(0, 2));
		JComboBox<String> cliente = new JComboBox<String>();
		JComboBox<String> veiculo = new JComboBox<String>();
		JComboBox<String> pagamento = new JComboBox<String>();

		pagamento.addItem("À vista");
		pagamento.addItem("Parcelado 24x");

		for (int i = 0; i < arrPF.size(); i++) {
			cliente.addItem(arrPF.get(i).getNome());
		}
		for (int i = 0; i < arrPJ.size(); i++) {
			cliente.addItem(arrPJ.get(i).getNome());
		}
		for (int i = 0; i < arrCarro.size(); i++) {
			veiculo.addItem(arrCarro.get(i).getModelo());
		}
		for (int i = 0; i < arrMoto.size(); i++) {
			veiculo.addItem(arrMoto.get(i).getModelo());
		}

		panel.add(new JLabel("Cliente: "));
		panel.add(cliente);
		panel.add(new JLabel("Veículo: "));
		panel.add(veiculo);
		panel.add(new JLabel("Forma de pagamento: "));
		panel.add(pagamento);

		JOptionPane.showMessageDialog(null, panel);

		this.indexCliente = cliente.getSelectedIndex();
		this.indexVeiculo = veiculo.getSelectedIndex();
		this.formaDePagamento = pagamento.getSelectedIndex();

		if (indexVeiculo >= arrCarro.size()) {
			this.veiculoSelecionado = arrMoto.get(indexVeiculo - arrCarro.size());
			this.imposto = arrMoto.get(indexVeiculo - arrCarro.size()).getImposto();
		} else {
			this.veiculoSelecionado = arrCarro.get(indexVeiculo);
			this.imposto = arrCarro.get(indexVeiculo).getImposto();
		}
		if (indexCliente >= arrPF.size()) {
			this.clienteSelecionado = arrPJ.get(indexCliente - arrPF.size());
			this.desconto = arrPJ.get(indexCliente - arrPF.size())
					.getDesconto(((Veiculo) veiculoSelecionado).getValor());
		} else {
			this.clienteSelecionado = arrPF.get(indexCliente);
			this.desconto = arrPF.get(indexCliente).getDesconto(((Veiculo) veiculoSelecionado).getValor());
		}

	}

	public void confirmarCompra(ArrayList<Fisica> arrPF, ArrayList<Juridica> arrPJ, ArrayList<Carro> arrCarro,
			ArrayList<Moto> arrMoto) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));
		panel.add(new JLabel("Confirmação de Compra"));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel("Cliente: "));
		panel.add(new JLabel(((Pessoa) clienteSelecionado).getNome()));
		panel.add(new JLabel("Veículo: "));
		panel.add(new JLabel(((Veiculo) veiculoSelecionado).getModelo()));
		panel.add(new JLabel("Forma de pagamento: "));
		if (this.formaDePagamento == 0) {
			panel.add(new JLabel("À vista"));
		} else {
			panel.add(new JLabel("Parcelado 24x"));
			this.desconto = 0;
		}
		panel.add(new JLabel("Valor unitário: "));
		panel.add(new JLabel("R$ " + ((Veiculo) veiculoSelecionado).getValor()));
		panel.add(new JLabel("Desconto: "));
		panel.add(new JLabel("R$ " + this.desconto));
		panel.add(new JLabel("Imposto: "));
		panel.add(new JLabel("R$ " + this.imposto));
		panel.add(new JLabel("Valor total: "));
		panel.add(new JLabel("R$ " + (((Veiculo) veiculoSelecionado).getValor() + this.imposto - this.desconto)));

		JOptionPane.showMessageDialog(null, panel);
	}

	public void recibo() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));
		panel.add(new JLabel("Recibo"));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel("Vendedor: "));
		panel.add(new JLabel("JD Automóveis LTDA."));
		panel.add(new JLabel("CNPJ: "));
		panel.add(new JLabel("18.770.928/0001-10"));
		panel.add(new JLabel("Endereço: "));
		panel.add(new JLabel("Rua Quatro, 1428"));
		panel.add(new JLabel("Contato: "));
		panel.add(new JLabel("(31) 5540-4333"));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel("Cliente: "));
		panel.add(new JLabel(((Pessoa) clienteSelecionado).getNome()));
		panel.add(new JLabel("Documento: "));
		panel.add(new JLabel(((Pessoa) clienteSelecionado).getDocumento()));
		panel.add(new JLabel("Endereço: "));
		panel.add(new JLabel(((Pessoa) clienteSelecionado).getEndereco()));
		panel.add(new JLabel("Contato: "));
		panel.add(new JLabel(((Pessoa) clienteSelecionado).getContato()));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel("Veículo: "));
		panel.add(new JLabel(((Veiculo) veiculoSelecionado).getModelo()));
		panel.add(new JLabel("Marca: "));
		panel.add(new JLabel(((Veiculo) veiculoSelecionado).getMarca()));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel("Forma de pagamento: "));
		if (formaDePagamento == 0) {
			panel.add(new JLabel("À vista"));
		} else {
			panel.add(new JLabel("Parcelado 24x"));
			this.desconto = 0;
		}
		panel.add(new JLabel("Valor unitário: "));
		panel.add(new JLabel("R$ " + ((Veiculo) veiculoSelecionado).getValor()));
		panel.add(new JLabel("Desconto: "));
		panel.add(new JLabel("R$ " + this.desconto));
		panel.add(new JLabel("Imposto: "));
		panel.add(new JLabel("R$ " + this.imposto));
		panel.add(new JLabel("Valor total: "));
		panel.add(new JLabel("R$ " + (((Veiculo) veiculoSelecionado).getValor() + this.imposto - this.desconto)));

		JOptionPane.showMessageDialog(null, panel);
	}
}
