import org.eclipse.swt.SWT;

import java.util.Random;
import java.util.Scanner;
public class TreinamentoProway {

	public static void main(String[] args) {
		
		/*CriaJanela janela = new CriaJanela();
		janela.inicalizaJanela();
		janela.inicializaBotao();
		janela.inicializaBotao();
		janela.inicializaConsulta();*/
		
		Random aleatorio = new Random();
		Pessoa[] pessoa = new Pessoa[50];
		Sala[] sala = new Sala[20];
		Cafe[] cafe = new Cafe[2];
		int linhaPessoa = 0;
		int linhaSala = 1;
		int linhaCafe = 0;
		Scanner s = new Scanner(System.in);
		
		int opcao;
		
		do{
	    System.out.println(" __________________________________________________");
		System.out.println("| CADASTRO PESSOAS | CADASTRO SALA | CADASTRO CAFÉ |");
		System.out.println("|        1         |       2       |       3       |");
		System.out.println("|__________________________________________________|");
		System.out.println("| CONSULTA PESSOA  | CONSULTA SALA | CONSULTA CAFE |");
		System.out.println("|        4         |       5       |       6       |");
		System.out.println("|__________________________________________________|");
		System.out.println("|                SAIR     0                        |");
		System.out.println("|__________________________________________________|");
		opcao = s.nextInt();
		if(opcao==1){
			
			pessoa[linhaPessoa] = new Pessoa();
			System.out.println("Digite o nome da pessoa:");
			pessoa[linhaPessoa].setNome(s.next().toUpperCase());
			
			System.out.println();
			System.out.println("Digite o sobrenome da pessoa:");
			pessoa[linhaPessoa].setSobrenome(s.next());
			pessoa[linhaPessoa].setSala1(aleatorio.nextInt(linhaSala));
			int temp = aleatorio.nextInt(linhaSala);
			if(temp!=pessoa[linhaPessoa].getSala1()){
				pessoa[linhaPessoa].setSala2(temp);
			}
			pessoa[linhaPessoa].setCafe1(0);
			pessoa[linhaPessoa].setCafe2(1);
			linhaPessoa++;
			
		}else if(opcao==2) {
			sala[linhaSala] = new Sala();
			System.out.println("Digite o nome da sala:");
			sala[linhaSala].setNomeSala(s.next());
			System.out.println();
			System.out.println("Digite a lotação máxima da sala:");
			sala[linhaSala].setLotacao(s.nextInt());
			sala[linhaSala].setId(linhaSala);
			linhaSala++;
			
		}else if(opcao==3) {
			
			System.out.println("Digite o nome do espaço do café:");
			cafe[linhaCafe].setNomeCafe(s.nextLine());
			System.out.println();
			System.out.println("Digite a lotação máxima do espaço do café:");
			cafe[linhaCafe].setLotacaoCafe(s.nextInt());
			
		}else if(opcao==4) {
			
			System.out.println("Digite o nome da pessoa: ");
			String nome = s.nextLine();
			for(int i=0;i<linhaPessoa;i++) {
			if(nome.toUpperCase().equals(pessoa[i].getNome())) {
				System.out.println("| NOME |   SALA ETAPA 1 | SALA ETAPA 2 | CAFÉ 1| CAFÉ 2 |");
				System.out.println("|"+pessoa[i].getNome()+"|"+pessoa[i].getSala1()+"|"+pessoa[i].getSala2()+"|"+pessoa[i].getCafe1()+"|"+pessoa[i].getCafe2()+"|");
				
			}
			}
		}else if(opcao==5) {
			
		}
		
		}while(opcao!=0);
		s.close();
}
}