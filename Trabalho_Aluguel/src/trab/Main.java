package trab;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.JobHoldUntil;







public class Main{
	
	
	private static List<Agencia> agencias = null;
	private static List <Carro> carros = null;
	private static List <Cliente> clientes = null;
	private static List <Locacao> locacao = null;
	private static Boolean sair = false;
	private static Scanner scan = null;
	private static int agencia;
	private static int codCliente;
	private static int codCarroAux;
	private static int codLocacaoAux;
	private static int guardaDiasGeral=0;
	private static int guardaPeriodoGeral=0;
	
	
	public static void main(String[] args)  {
		
        
		
		
		
		agencias = new ArrayList<Agencia>();
		carros= new ArrayList<Carro>();
		clientes = new ArrayList<Cliente>();
		locacao = new ArrayList<Locacao>();
		
		primeirasPerguntas();
		
		
	}
	private static void primeirasPerguntas() {
		System.out.print("*****SEJA BEM VINDO A LOCADORA DE CARROS! *****\n");
		
		while(!sair) {
			
			System.out.print("*****Essa e uma area restrita dos funcionarios! *****\n");
			System.out.print("*****Voce deseja: *****\n");
			System.out.println("Criar agencia[0]");
			System.out.println("Deletar agencia[1]");
			System.out.println("Listar agencias[2]");
			System.out.println("Logar agencia[3]");
			System.out.println("Sair[4]");
			
			
			scan = new Scanner(System.in);
			
			int option = scan.nextInt();
			
			switch(option) {
			case 0:
				criaAgencia();
			break;
			case 1:
				deletaAgencia();
			break;
			case 2:
				listarAgencias();
			break;
			case 3:
				usarAgencia();
			break;
			case 4:
				sair = true;
			break;
			default:
				System.out.println("Erro: selecione uma opcao valida!");
			}
		}
	}
	
	private static void criaAgencia() {
		Agencia novaAgencia = null;
		String nome = null;
		int codigo;
		String localidade = null;
		
		System.out.println("******************************");
		System.out.println("CADASTRO DE NOVA AGENCIA");
		System.out.println("Nome da nova agencia:");
		nome = scan.next();
		
		
		System.out.println("Localidade da nova agencia");   
		localidade = scan.next();
		codigo = agencias.size();
		
		novaAgencia = new Agencia(nome, codigo, localidade);
		agencias.add(novaAgencia);
	}
	
	private static void deletaAgencia() {
		String nome = null;
		if(agencias.size()>0) {
		System.out.println("******************************");
		System.out.println("DELETAR AGENCIAS:");
		System.out.println("Nome da agencia a ser deletada?");
		nome = scan.next();
		for(int i = 0; i < agencias.size(); i++) {
			Agencia agencia = agencias.get(i);
			if (agencia.getNome().equals(nome)) {
				agencias.remove(i);
				break;
			}
			else {
				System.out.println("Nao encontramos essa agencia que deseja remover!");
			}
		}
		}
		else {
			System.out.println("Nao existe agencia cadastrada");
		}
	}
	
	private static void listarAgencias() { 
	   
		if(agencias.size()>0) {  
		for(int i = 0; i < agencias.size(); i++) {
			
			System.out.println("******************************");
			System.out.println("As agencias cadastradas são:\n");
			System.out.println("cod: "+i);
			System.out.println("Nome e: " +(agencias.get(i).getNome()));
            System.out.println("Agencia e: "+(agencias.get(i).getLocalidade()));
            System.out.println("\n");
        }
		}
		else {
			System.out.println("******************************");
			System.out.println("Nao existe agencias cadastradas!");
			primeirasPerguntas();
			
			
		}
	}
	
	private static void usarAgencia() {
		 listarAgencias();
		 System.out.println("\n******************************");
		System.out.println("Digite o codigo da agencia que deseja usar: ");
		int encontrarAgencia = scan.nextInt();
		  
		for(int i = 0; i < agencias.size(); i++) {
			if (i == encontrarAgencia) {
				agencia=i;
			
				System.out.println("Codigo da agencia selecionada:"+i);
				System.out.println("Agencia selecionada:" +(agencias.get(i).getNome()));
				System.out.println("Localizacao da agencia: " +(agencias.get(i).getLocalidade()));
				
				
			}
			else {
				System.out.println("Nao encontramos a agencia desejada!");
				primeirasPerguntas();
				break;
			}
			
		}
		questionCarro();
		
	}
	
	private static void questionCarro() {
		while(!sair) {
			System.out.println("\n******************************");
			System.out.println("Voce deseja:");
			System.out.println("Incluir carro[0]");
			System.out.println("Remover carro[1]");
			System.out.println("Listar todos os carros[2]");
			System.out.println("Listar carros alugados[3]");
			System.out.println("Listar carros nao alugados[4]");
			System.out.println("Alugar carro[5]");
			System.out.println("Voltar para o ultimo menu[6]");
			System.out.println("Mostrar carros dessa agencia[7]");
			System.out.println("Mostrar lista de clientes[8]");
			
			
			scan= new Scanner(System.in);
			
			int option = scan.nextInt();
			
			switch(option) {
			case 0:
				incluirCarro();
			break;
			case 1:
				removerCarro();
			break;
			case 2:
				listarTodosOsCarros();
			break;
			case 3:
				listarCarrosAlugados();
			break;
			case 4:
				listarCarrosNaoAlugados();
			break;
			case 5:
				alugarCarros();
			break;
			case 6:
				primeirasPerguntas();
			break;
			case 7:
				carrosAgencia();
			break;
			case 8:
				listarClientesAgencia();
			break;
			
			default:
				System.out.println("Erro: selecione uma opcao valida!");
			}
		}
	
	}

	private static void listarClientesAgencia() {
		
		 if(agencias.get(agencia).getCliente().size()>0) {
		System.out.println("\n******************************");
		System.out.println("\nOs clientes dessa agencia sao:\n");
		for (Iterator<?> cliente = agencias.get(agencia).getCliente().iterator(); cliente.hasNext();) {
			Cliente listCliente = (Cliente) cliente.next();
			System.out.println("Cod:"+listCliente.getCodigoCliente());
			System.out.println("Nome:"+listCliente.getNome());
			System.out.println("Numero Habilitacao:"+listCliente.getNumeroHabilitacao());
			System.out.println("Telefone :"+listCliente.getTelefone());
		} 
		 }
		 else {
			 System.out.println("Nao existem clientes cadastrados");
		 }
		
	}
	private static void carrosAgencia() {
		
		if(agencias.get(agencia).getCarros().size()==0) {
			System.out.println("\n******************************");
			System.out.println("Lista de carros vazia");
		}
		
		else {
			System.out.println("\n******************************");
			System.out.println("Os carros dessa agencia sao: \n");
			for (Iterator<?> carros = agencias.get(agencia).getCarros().iterator(); carros.hasNext();) {
				Carro carAg = (Carro) carros.next();
				System.out.println("Modelo:"+carAg.getModelo());
				System.out.println("Ano:"+carAg.getAno());
				System.out.println("Placa:"+carAg.getPlaca());
				System.out.println("Cor:"+carAg.getCor());
				if(carAg.getAlugado()) {
					System.out.println("Alugado: Sim\n");
				}
				else {
					System.out.println("Alugado: Nao\n");
				}
				
			}
			
			
		}
		 
	}
	private static void listarCarrosNaoAlugados() {
		
		if(agencias.get(agencia).getCarros().size()>0) {
		System.out.println("\n******************************");
		System.out.println("\nOs carros NAO alugados dessa agencia sao:");
		for(int i=0;i<agencias.get(agencia).getCarros().size();i++) {
			 if(agencias.get(agencia).getCarros().get(i).getAlugado()==false){
			System.out.println("Codigo : " +(agencias.get(agencia).getCarros().get(i).getCodigo()));
			System.out.println("Modelo : " +(agencias.get(agencia).getCarros().get(i).getModelo()));
            System.out.println("Placa : "+(agencias.get(agencia).getCarros().get(i).getPlaca()));
            System.out.println("Cor : "+(agencias.get(agencia).getCarros().get(i).getCor()));
            System.out.println("Ano : "+(agencias.get(agencia).getCarros().get(i).getAno()));
            System.out.println("Alugado : "+(agencias.get(agencia).getCarros().get(i).getAlugado())); 
			}
			 else {
				 System.out.println("Todos os carros estao alugados!");
			 }
		}
		}
		else {
			System.out.println("Nao existe carros nessa agencia");
		}
		
		
	}

	private static void listarCarrosAlugados() {
		
		if (agencias.get(agencia).getCarros().size()>0) {
		System.out.println("\n******************************");
		System.out.println("\nOs carros alugados dessa agencia sao:");
		for(int i=0;i<agencias.get(agencia).getCarros().size();i++) {
			 if(agencias.get(agencia).getCarros().get(i).getAlugado()==true){
			System.out.println("Codigo : " +(agencias.get(agencia).getCarros().get(i).getCodigo()));
			System.out.println("Modelo : " +(agencias.get(agencia).getCarros().get(i).getModelo()));
            System.out.println("Placa : "+(agencias.get(agencia).getCarros().get(i).getPlaca()));
            System.out.println("Cor : "+(agencias.get(agencia).getCarros().get(i).getCor()));
            System.out.println("Ano : "+(agencias.get(agencia).getCarros().get(i).getAno()));
            System.out.println("Alugado : "+(agencias.get(agencia).getCarros().get(i).getAlugado())); 
			}
			 else {
				 System.out.println("Nao existe carros alugados!");
			 }
		}
		}
		else {
			System.out.println("Nao existe carros nessa agencia");
		}
		
	}

	private static void listarTodosOsCarros() {
		
		if(carros.size()>0) {
		System.out.println("\n******************************");
		System.out.println("\nLista de todos os carros dessa agencia, alugados ou nao!:");
       for(int i=0;i<carros.size();i++) {
			if(carros.size()>0) {
    	   System.out.println("Codigo : " +(carros.get(i).getCodigo()));
			System.out.println("Modelo : " +(carros.get(i).getModelo()));
            System.out.println("Placa : "+(carros.get(i).getPlaca()));
            System.out.println("Cor : "+(carros.get(i).getCor()));
            System.out.println("Ano : "+(carros.get(i).getAno()));
            System.out.println("Alugado : "+(carros.get(i).getAlugado()));
            System.out.println("\n");
		}
			else {
				System.out.println("Nao existe carros nessa agencia");
			}
		}	
       }
		else {
			System.out.println("Nao existe carro nessa agencia!");
		}
	}

	private static void removerCarro() {
		int numDelete;
		
		   if(agencias.get(agencia).getCarros().size()>0) {
		System.out.println("******************************");
		System.out.println("DELETAR CARROS DA AGENCIA:");
		System.out.println("Codigo do carro que voce deseja deletar?");
		numDelete = scan.nextInt();
		
			for(int i=0;i<agencias.get(agencia).getCarros().size(); i++) {
				 if(agencias.get(agencia).getCarros().get(i).getCodigo() == numDelete) {
					 agencias.get(agencia).getCarros().remove(numDelete);
					 break;
				 }
				 else {
					 System.out.println("Nao encontramos o carro que deseja deletar!");
					 questionCarro();
					 break;
				 }
			}
		
  }
		   else {
			   System.out.println("Nao existe carros para remover");
			   questionCarro();
		   }
}

	private static void incluirCarro() {
	
	Carro addCarro = null;
		
		String modelo = null;
		String placa = null;
		String cor = null;
		boolean alugado = false;
		int ano = 0;
		int codigo;
		System.out.println("\n******************************");
		System.out.println("\nInsira os dados do carro na agencia selecionada:");
		System.out.println("Nome do carro: ");
		modelo = scan.next();
				
		System.out.println(" Digite a placa: ");   
		placa = scan.next();
		
		System.out.println(" Digite a cor: ");   
		cor = scan.next();
		
		System.out.println(" Digite o ano: ");   
		ano = scan.nextInt();
		codigo = carros.size();
		
		codCarroAux = codigo;
		
		addCarro = new Carro(modelo, placa, cor, ano, codigo, alugado);
		carros.add(addCarro);
		
		agencias.get(agencia).getCarros().add(addCarro);
	}
	
	private static void alugarCarros() {
		listarTodosOsCarros();
		int codCarro;
		String nomeCliente;
		String numeroHabilitacao;
		int telefone;
		int cod;
		int opAluga;
		int locacaoSemana = 100;
		int locacaoDiaria = 25;
		int guardaDias;
		int guardaSemanas;
		int valorLocacao=0;
		
		Cliente cliente = null;
		Locacao addDadosLocacao = null;
		
		if(carros.size()>0) {
		System.out.println("\n******************************");
		System.out.println("DADOS DO CLIENTE:\n");
		
		System.out.println("Nome do cliente: ");
		nomeCliente = scan.next();
		
		System.out.println("Numero da habilitacao : ");
		numeroHabilitacao = scan.next();
		
		System.out.println("Numero telefone: ");
		telefone = scan.nextInt();
		
		cod = agencias.get(agencia).getCliente().size(); 
		codCliente=cod;
		
		cliente = new Cliente(nomeCliente,numeroHabilitacao,telefone,cod);
		agencias.get(agencia).getCliente().add(cliente);
		
		System.out.println("\n******************************");
		System.out.println("->Cliente salvo com sucesso!<-");
		System.out.println("\n******************************");
		System.out.println("DADOS DO CARRO:\n");
		System.out.println("\n******************************");
		System.out.println("Os carros nao alugados da agencia sao:\n");
		listarCarrosNaoAlugados();
		System.out.println("\n******************************");
		
		System.out.println(" Qual o codigo do carro que deseja alugar: ");   
		codCarro = scan.nextInt();
		
		System.out.println("Voce deseja alugar o carro por diaria[0]\nperiodo[1]\n ");   
		opAluga = scan.nextInt();
		
		
		for (int i=0;i<carros.size();i++) {
			codLocacaoAux=i;
			  if(codCarro == i ) {
				  carros.get(i).setAlugado(true);  
				  if(opAluga==0) {
					  System.out.println("Quantos dias?");
					  guardaDias= scan.nextInt();
					  guardaDiasGeral= guardaDias;
					  
					  
					  valorLocacao=locacaoDiaria*guardaDias; //valor da locacao
					    
				  }
				  else {
					  System.out.println("Quantas semanas voce deseja alugar?");
					  guardaSemanas = scan.nextInt();
					  valorLocacao = locacaoSemana*guardaSemanas;//valor da locacao
					  guardaPeriodoGeral=guardaSemanas;
				  }
			  }
		  }
		
		 String horaSaida="12h";
		 String horaVolta="18h";
		 
		 addDadosLocacao = new Locacao(horaSaida,horaVolta,cliente,valorLocacao);
		 locacao.add(addDadosLocacao);
		 agencias.get(agencia).setLocacao(locacao);
		 
		 FinalizacaoAluguel();
		}
		else {
			System.out.println("Nao existe carros na agencia");
			questionCarro();
			
		}
		
	}
	private static void FinalizacaoAluguel() {
		System.out.println("\n******************************");
		System.out.println("Aluguel Finalizado!Abaixo encontra-se os dados de sua reserva:");
		 
		        System.out.println("Dados do cliente:\n");
				System.out.println("Codigo Cliente:\n" +(agencias.get(agencia).getCliente().get(codCliente).getCodigoCliente()));
				System.out.println("Nome cliente:\n" +(agencias.get(agencia).getCliente().get(codCliente).getNome()));
				System.out.println("Numero habiltacao cliente:\n" +(agencias.get(agencia).getCliente().get(codCliente).getNumeroHabilitacao()));
				System.out.println("Telefone Cliente: \n" +(agencias.get(agencia).getCliente().get(codCliente).getTelefone()));
				
				 System.out.println("Dados do carro:\n");
				System.out.println("Codigo carro:" +(agencias.get(agencia).getCarros().get(codCarroAux).getCodigo()));
				System.out.println("Modelo carro:" +(agencias.get(agencia).getCarros().get(codCarroAux).getModelo()));
				System.out.println("Ano do carro:" +(agencias.get(agencia).getCarros().get(codCarroAux).getAno()));
				System.out.println("Cor Carro:" +(agencias.get(agencia).getCarros().get(codCarroAux).getCor()));
				System.out.println("Placa carro:" +(agencias.get(agencia).getCarros().get(codCarroAux).getPlaca()));
				System.out.println("Status do Aluguel:"  +(agencias.get(agencia).getCarros().get(codCarroAux).getAlugado()));
				
				 System.out.println("Dados do locacao:\n");
				 
				System.out.println("Valor Locacao:" +(agencias.get(agencia).getLocacao().get(codLocacaoAux).getValorLocacao()));
				System.out.println("Hora Saida do carro da agencia:" +(agencias.get(agencia).getLocacao().get(codLocacaoAux).getHoraSaida()));
				System.out.println("Hora devolucao:" +(agencias.get(agencia).getLocacao().get(codLocacaoAux).getHora()));
				  if(guardaDiasGeral == 0) {
					  System.out.println("Voce tem que entregar o carro em" + guardaPeriodoGeral+" semanas");
					  
				  }
				  else {
					  System.out.println("Voce tem que entregar o carro em" + guardaDiasGeral+" dias");
				  }
				 
				
	}	
	}
	
	

