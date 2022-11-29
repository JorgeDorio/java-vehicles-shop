package main;

import java.util.ArrayList;

public class App {
	private static ArrayList<Fisica> arrPF = new ArrayList<Fisica>();
	private static ArrayList<Juridica> arrPJ = new ArrayList<Juridica>();
	private static ArrayList<Carro> arrCarro = new ArrayList<Carro>();
	private static ArrayList<Moto> arrMoto = new ArrayList<Moto>();

	private static void cadastraDados() {
		// Todos os dados fora gerados aleatoriamente com
		// https://pt.fakenamegenerator.com/gen-male-br-br.php ou
		// https://www.4devs.com.br/gerador_de_empresas
		Fisica f1 = new Fisica(), f2 = new Fisica(), f3 = new Fisica();
		f1.setNome("Gabriel Azevedo Pinto");
		f1.setCpf("652.483.212-47 ");
		f1.setEndereco("Avenida Sete de Setembro, 1996");
		f1.setContato("(42) 8135-9615");
		f2.setNome("Estevan Almeida Goncalves");
		f2.setCpf("604.980.868-60");
		f2.setEndereco("Rua Guaraú, 323");
		f2.setContato("(11) 3899-7003");
		f3.setNome("Douglas Rodrigues Silva");
		f3.setCpf("287.481.063-05");
		f3.setEndereco("Rua Quarta, 8");
		f3.setContato("(91) 8079-7831");
		arrPF.add(f1);
		arrPF.add(f2);
		arrPF.add(f3);

		Juridica j1 = new Juridica(), j2 = new Juridica(), j3 = new Juridica();
		j1.setNome("Renato e Manoel Telecomunicações Ltda");
		j1.setCnpj("48.467.183/0001-86");
		j1.setEndereco("Rua Santo Antônio, 763");
		j1.setContato("(84) 7925-4008");
		j2.setNome("Stella e Mariah Doces & Salgados ME");
		j2.setCnpj("69.442.492/0001-71");
		j2.setEndereco("Rua Trinta e Dois, 28");
		j2.setContato("(51) 3347-4137");
		j3.setNome("Liz e Matheus Eletrônica Ltda");
		j3.setCnpj("81.717.934/0001-40");
		j3.setEndereco("Rua Diário de Pernambuco, 1982");
		j3.setContato("(81) 3102-5527");
		arrPJ.add(j1);
		arrPJ.add(j2);
		arrPJ.add(j3);
		
		Carro c1 = new Carro(),c2 = new Carro(), c3 = new Carro();
		c1.setMarca("Toyota");
		c1.setModelo("ETIOS X  1.3 Flex");
		c1.setValor(38000);
		c1.setQuantPortas(4);
		c2.setMarca("CHERY");
		c2.setModelo("QQ 1.0 ACT FL");
		c2.setValor(37000);
		c2.setQuantPortas(4);
		c3.setMarca("BMW");
		c3.setModelo("225i Active Tourer Sport 2.0");
		c3.setValor(110000);
		c3.setQuantPortas(4);
		arrCarro.add(c1);
		arrCarro.add(c2);
		arrCarro.add(c3);
		
		Moto m1 = new Moto(),m2 = new Moto(), m3 = new Moto();
		m1.setMarca("Honda");
		m1.setModelo("Biz 125");
		m1.setValor(14000);
		m2.setMarca("Kawasaki");
		m2.setModelo("Ninja 400 KRT");
		m2.setValor(36000);
		m3.setMarca("Harley-Davidson");
		m3.setModelo("Road Glide Limited");
		m3.setValor(130000);
		arrMoto.add(m1);
		arrMoto.add(m2);
		arrMoto.add(m3);
	}

	public static void main(String[] args) {
		// Comente a linha abaixo para inicializar a aplicação sem dados
		cadastraDados();
		boolean repete = true;
		int acao, tipoVeiculo, tipoCliente;

		while (repete) {
			acao = Menu.render();

			switch (acao) {
			case 0: {
				tipoCliente = Pessoa.selecionarTipo();
				if (tipoCliente == 0) {
					Fisica f = new Fisica();
					f.cadastro();
					arrPF.add(f);
				} else if (tipoCliente == 1) {
					Juridica j = new Juridica();
					j.cadastro();
					arrPJ.add(j);
				}
				break;
			}
			case 1: {
				tipoVeiculo = Veiculo.selecionarTipo();
				if (tipoVeiculo == 0) {
					Carro c = new Carro();
					c.cadastro();
					arrCarro.add(c);
				} else if (tipoVeiculo == 1) {
					Moto m = new Moto();
					m.cadastro();
					arrMoto.add(m);
				}
				break;
			}
			case 2: {
				Pessoa.listarClientes(arrPF, arrPJ);
				break;
			}
			case 3: {
				Veiculo.listarVeiculos(arrCarro, arrMoto);
				break;
			}
			case 4: {
				Ordem o = new Ordem();
				o.cadastrar(arrPF, arrPJ, arrCarro, arrMoto);
				o.confirmarCompra(arrPF, arrPJ, arrCarro, arrMoto);
				o.recibo();
				break;
			}
			default:
				repete = false;
			}
		}
	}

}
