import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriaJanela {

	private JFrame frame;
	private JTable tabela;
	private DefaultTableModel modelPessoa;
	private DefaultTableModel modelSala;
	private DefaultTableModel modelCafe;
	private DefaultTableModel modelConsulta;
	private JScrollPane painel;
	private JTextField entradaNome;
	private JTextField entradaSobrenome;
	private JTextField consultaNome;
	private JLabel labelNome;
    private JLabel labelSobrenome;
    private JButton cadastroPessoa;
    private JButton cadastroSala;
    private JButton cadastroCafe;
    private JButton consultaPessoa;
    private JButton consultaSala;
    private Object[] linha;
    private Object[] etapa;
    
	public CriaJanela() {
		
	}
	
	public void inicalizaJanela() {
		
		frame = new JFrame();
		tabela = new JTable();
		
		Object[] colunasPessoa = {"Nome","Sobrenome"};
		Object[] colunasSala = {"Sala","Lotação"};
		Object[] colunasCafe = {"Café","Lotação"};
		Object[] colunasConsulta = {"1","2"};
		
        modelPessoa = new DefaultTableModel();
        modelSala = new DefaultTableModel();
        modelCafe = new DefaultTableModel();
        modelConsulta = new DefaultTableModel();
        
        modelPessoa.setColumnIdentifiers(colunasPessoa);
        modelSala.setColumnIdentifiers(colunasSala);
        modelCafe.setColumnIdentifiers(colunasCafe);
        modelConsulta.setColumnIdentifiers(colunasConsulta);
        
        tabela.setModel(modelPessoa);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.setBackground(Color.LIGHT_GRAY);
        tabela.setForeground(Color.black);
        Font font = new Font("",1,22);
        tabela.setFont(font);
        tabela.setRowHeight(30);
        painel = new JScrollPane(tabela);
        painel.setBounds(250, 150, 500, 250);
        
		entradaNome = new JTextField();
		entradaSobrenome = new JTextField();
		
		entradaNome.setBounds(100, 100, 100, 25);
        entradaSobrenome.setBounds(100, 130, 100, 25);
        
        labelNome = new JLabel("Nome");
        labelSobrenome = new JLabel("Sobrenome");
        
        labelNome.setBounds(20, 100, 80, 14);
        labelSobrenome.setBounds(20, 130, 80, 14);
        
      
        frame.getContentPane().add(labelNome);
        frame.getContentPane().add(labelSobrenome);
   
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(entradaNome);
        frame.getContentPane().add(entradaSobrenome);
        frame.getContentPane().add(painel);
        frame.setSize(800,564);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	public void inicializaBotao() {
		cadastroPessoa = new JButton("Cadastro Pessoa");
		cadastroSala = new JButton("Cadastro Sala");
		cadastroCafe = new JButton("Cadastro Café");
		
		cadastroPessoa.setBounds(25, 30, 140, 37);
		cadastroSala.setBounds(225, 30, 140, 37);
		cadastroCafe.setBounds(425, 30, 140, 37);
		
		frame.getContentPane().add(cadastroPessoa);
		frame.getContentPane().add(cadastroSala);
		frame.getContentPane().add(cadastroCafe);
		
		linha = new Object[3];
		
		cadastroPessoa.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){
			    linha[0] = entradaNome.getText();
			    linha[1] = entradaSobrenome.getText();
			   // linha[2] = 
			        modelPessoa.addRow(linha);
			        tabela.setModel(modelPessoa);
			        JScrollPane painelPessoa = new JScrollPane(tabela);
			        painelPessoa.setBounds(250, 150, 500, 250);
			        frame.getContentPane().add(painelPessoa);
			        
			         }  
			     });
		cadastroSala.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){
			
			         }  
			     });  
		
		cadastroCafe.addActionListener(new ActionListener(){  
			 public void actionPerformed(ActionEvent e){
				
			      
			         }  
			     });  
	}
	
	public void inicializaConsulta() {
		
		consultaPessoa = new JButton("Consulta Pessoas");
		consultaSala = new JButton("Consulta Salas");
		consultaNome = new JTextField();
		consultaPessoa.setBounds(25, 450, 150, 37);
        consultaSala.setBounds(325, 450, 150, 37);
        consultaNome.setBounds(175,450,150,37);
        
        frame.getContentPane().add(consultaPessoa);
        frame.getContentPane().add(consultaSala);
		frame.getContentPane().add(consultaNome);
		
        consultaPessoa.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            
            	for(int i = 0; i <= modelPessoa.getRowCount(); i++){
            	if(consultaNome.getText().equals(modelPessoa.getValueAt(i, 0))) {
            		linha[0] = modelPessoa.getValueAt(i, 0);
            //		linha[1] = modelSala.getValueAt(i, 0);
            		modelConsulta.addRow(linha);
            	 	}
            	}
            	tabela.setModel(modelConsulta);
            	frame.getContentPane().add(tabela);
              
            	
            }
       
		
        });
	}
}
	
