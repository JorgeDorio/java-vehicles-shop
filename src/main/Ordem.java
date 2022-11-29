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
	private String nomeCliente;
	private String modeloVeiculo;
	private DateTimeFormatter date;
	private int formaDePagamento;
	private double valorTotal;
	private double valorUnitario;
	private double imposto;
	private double desconto;
	private String documento;
	private String endereco;
	private String contato;
	private String Marca;
	
	
	
	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public DateTimeFormatter getDate() {
		return date;
	}

	public void setDate(DateTimeFormatter date) {
		this.date = date;
	}

	public int getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(int formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getIndexCliente() {
		return indexCliente;
	}

	public void setIndexCliente(int indexCliente) {
		this.indexCliente = indexCliente;
	}

	public int getIndexVeiculo() {
		return indexVeiculo;
	}

	public void setIndexVeiculo(int indexVeiculo) {
		this.indexVeiculo = indexVeiculo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public void cadastrar(ArrayList<Fisica> arrPF, ArrayList<Juridica> arrPJ, ArrayList<Carro> arrCarro, ArrayList<Moto> arrMoto) {
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
		
		for(int i = 0; i < arrPF.size(); i++) {
			cliente.addItem(arrPF.get(i).getNome());
		}
		for(int i = 0; i < arrPJ.size(); i++) {
			cliente.addItem(arrPJ.get(i).getNome());
		}
		for(int i = 0; i < arrCarro.size(); i++) {
			veiculo.addItem(arrCarro.get(i).getModelo());
		}
		for(int i = 0; i < arrMoto.size(); i++) {
			veiculo.addItem(arrMoto.get(i).getModelo());
		}

		panel.add(new JLabel("Cliente: "));
		panel.add(cliente);
		panel.add(new JLabel("Veículo: "));
		panel.add(veiculo);
		panel.add(new JLabel("Forma de pagamento: "));
		panel.add(pagamento);

		JOptionPane.showMessageDialog(null, panel);
		
		this.setIndexCliente(cliente.getSelectedIndex());
		this.setIndexVeiculo(veiculo.getSelectedIndex());
		this.setNomeCliente((String) cliente.getSelectedItem());
		this.setModeloVeiculo((String) veiculo.getSelectedItem());
		this.setFormaDePagamento(pagamento.getSelectedIndex());
		if(getIndexVeiculo() > arrCarro.size()) {
			this.setValorUnitario(arrMoto.get(getIndexVeiculo() - arrCarro.size()).getValor());
			this.setImposto(arrMoto.get(getIndexVeiculo() - arrCarro.size()).getImposto());
			this.setMarca(arrMoto.get(getIndexVeiculo() - arrCarro.size()).getMarca());
		} else {
			this.setValorUnitario(arrCarro.get(getIndexVeiculo()).getValor());
			this.setImposto(arrCarro.get(getIndexVeiculo()).getImposto());
			this.setMarca(arrCarro.get(getIndexVeiculo()).getMarca());
		}
		if(getIndexCliente() > arrPF.size()) {
			this.setDesconto(arrPJ.get(getIndexCliente() - arrPF.size()).getDesconto(getValorUnitario()));
			this.setDocumento(arrPJ.get(getIndexCliente() - arrPF.size()).getCnpj());
			this.setEndereco(arrPJ.get(getIndexCliente() - arrPF.size()).getEndereco());
			this.setContato(arrPJ.get(getIndexCliente() - arrPF.size()).getContato());
		} else {
			this.setDesconto(arrPF.get(getIndexCliente()).getDesconto(getValorUnitario()));
			this.setDocumento(arrPF.get(getIndexCliente()).getCpf());
			this.setEndereco(arrPF.get(getIndexCliente()).getEndereco());
			this.setContato(arrPF.get(getIndexCliente()).getContato());
		}
		
	}

	public void confirmarCompra(ArrayList<Fisica> arrPF, ArrayList<Juridica> arrPJ, ArrayList<Carro> arrCarro, ArrayList<Moto> arrMoto) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));
		panel.add(new JLabel("Confirmação de Compra"));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel("Cliente: "));
		panel.add(new JLabel(getNomeCliente()));
		panel.add(new JLabel("Veículo: "));
		panel.add(new JLabel(getModeloVeiculo()));
		panel.add(new JLabel("Forma de pagamento: "));
		if(formaDePagamento == 0) {
			panel.add(new JLabel("À vista"));			
		} else {
			panel.add(new JLabel("Parcelado 24x"));		
			this.setDesconto(0);
		}
		panel.add(new JLabel("Valor unitário: "));
		panel.add(new JLabel("R$ " + getValorUnitario()));
		panel.add(new JLabel("Desconto: "));
		panel.add(new JLabel("R$ " + getDesconto()));
		panel.add(new JLabel("Imposto: "));
		panel.add(new JLabel("R$ " + getImposto()));
		panel.add(new JLabel("Valor total: "));
		panel.add(new JLabel("R$ " + (getValorUnitario() + getImposto() - getDesconto())));
		
		
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
		panel.add(new JLabel(getNomeCliente()));
		panel.add(new JLabel("Documento: "));
		panel.add(new JLabel(getDocumento()));
		panel.add(new JLabel("Endereço: "));
		panel.add(new JLabel(getEndereco()));
		panel.add(new JLabel("Contato: "));
		panel.add(new JLabel(getContato()));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel("Veículo: "));
		panel.add(new JLabel(getModeloVeiculo()));
		panel.add(new JLabel("Marca: "));
		panel.add(new JLabel(getMarca()));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel("Forma de pagamento: "));
		if(formaDePagamento == 0) {
			panel.add(new JLabel("À vista"));			
		} else {
			panel.add(new JLabel("Parcelado 24x"));		
			this.setDesconto(0);
		}
		panel.add(new JLabel("Valor unitário: "));
		panel.add(new JLabel("R$ " + getValorUnitario()));
		panel.add(new JLabel("Desconto: "));
		panel.add(new JLabel("R$ " + getDesconto()));
		panel.add(new JLabel("Imposto: "));
		panel.add(new JLabel("R$ " + getImposto()));
		panel.add(new JLabel("Valor total: "));
		panel.add(new JLabel("R$ " + (getValorUnitario() + getImposto() - getDesconto())));
		
		JOptionPane.showMessageDialog(null, panel);
	}
}
