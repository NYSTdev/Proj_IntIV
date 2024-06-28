package projeto;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//Sthefanny Oliveira de Sousa - Módulo IV, CTBJ, Concomitante
public class ConversorMoney extends JFrame{
	private JRadioButton argentinabtn, usabtn, italybtn, francebtn, spainbtn, mexicobtn, chilebtn, japanbtn, canadabtn;
    private JButton selectbtn, btncalcular, btnvoltar;
    private ButtonGroup btngroup;
    //labels e caixas
    private JLabel valorconverterlabel;
    private JTextField caixavalorconverter;
    //parte do panel
    private JPanel panelMenuPais;
    private JPanel panelConversao;
    
    public ConversorMoney() { //construtor
		setSize(700,500); //tamanho do JFrame
		setTitle("Conversor de Moedas"); //título do JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //define o comportamento padrão ao fechar o JFrame

		//definindo o layout do JFrame
        setLayout(new BorderLayout());
        
		//panel para o menu de seleção do país
        panelMenuPais = new JPanel();
        panelMenuPais.setLayout(new GridLayout(11, 1));

        JLabel pais = new JLabel("Você deseja realizar a conversão para a moeda de qual país?");
        panelMenuPais.add(pais);

        //criando as RadioButtons
		argentinabtn = new JRadioButton("Argentina");
		usabtn = new JRadioButton("Estados Unidos");
		italybtn = new JRadioButton("Itália");
		francebtn = new JRadioButton("França");
		spainbtn = new JRadioButton("Espanha");
		mexicobtn = new JRadioButton("México");
		chilebtn = new JRadioButton("Chile");
		japanbtn = new JRadioButton("Japão");
		canadabtn = new JRadioButton("Canadá");
		//adicionando os RadioButtons a um ButtonGroup para garantir que só um seja selecionado por vez
		btngroup = new ButtonGroup();
		btngroup.add(argentinabtn);
		btngroup.add(usabtn);
		btngroup.add(italybtn);
		btngroup.add(francebtn);
		btngroup.add(spainbtn);
		btngroup.add(mexicobtn);
		btngroup.add(chilebtn);	
		btngroup.add(japanbtn);
		btngroup.add(canadabtn);
		//adicionando eles ao panel do menu
		panelMenuPais.add(argentinabtn);
	    panelMenuPais.add(usabtn);
	    panelMenuPais.add(italybtn);
	    panelMenuPais.add(francebtn);
	    panelMenuPais.add(spainbtn);
	    panelMenuPais.add(mexicobtn);
	    panelMenuPais.add(chilebtn);
	    panelMenuPais.add(japanbtn);
	    panelMenuPais.add(canadabtn);

	  //Botão para selecionar o país
		selectbtn = new JButton("Selecionar");
		panelMenuPais.add(selectbtn);
//-----------------------------------
		selectbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Verificando qual RadioButton está selecionado
				if(argentinabtn.isSelected()) {
                    exibirPainelConversao("a Argentina é o peso argentino (ARS).",163.41);
				}else if(usabtn.isSelected()) {
                    exibirPainelConversao("os Estados Unidos é o dólar americano (USD)." ,0.18);
				}else if(italybtn.isSelected()) {
					exibirPainelConversao("a Itália é o euro (EUR) desde 2002. Antigamente era a lira italiana (ITL).", 0.167);
				}else if(francebtn.isSelected()) {
					exibirPainelConversao("a França é o euro (EUR) atualmente. Antigamente era o franco francês (FRF).", 0.167);
				}else if(spainbtn.isSelected()) {
					exibirPainelConversao("a Espanha é o euro (EUR) desde 2002. Antigamente era a peseta espanhola (ESP).", 0.167);
				}else if(mexicobtn.isSelected()) {
					exibirPainelConversao("o México é o peso mexicano (MXN).", 3.282);
				}else if(chilebtn.isSelected()) {
					exibirPainelConversao("o Chile é o peso chileno (CLP).", 168.79);
				}else if(japanbtn.isSelected()) {
					exibirPainelConversao("o Japão é o iene japonês (JPY).", 28.82);
				}else if(canadabtn.isSelected()) {
					exibirPainelConversao("o Canadá é o dólar canadense (CAD).", 0.245);
				}else {
					JOptionPane.showMessageDialog(null, "Nenhum país selecionado.");
				}
			}
        });
		add(panelMenuPais, BorderLayout.CENTER);
        setVisible(true);
    }
//******************************************************************************************************************** 
    private void exibirPainelConversao(String selecionado, double moedaestrangeira) {
        // Remover o menu de seleção de país
        getContentPane().remove(panelMenuPais);

        // Criar o painel para exibir a moeda e realizar a conversão
        panelConversao = new JPanel();
        panelConversao.setLayout(new GridLayout(5, 1));

        JLabel moedaLabel = new JLabel("A moeda d" + selecionado);
        panelConversao.add(moedaLabel);

        valorconverterlabel = new JLabel("Valor que você deseja converter (em real - BRL): ");
        panelConversao.add(valorconverterlabel);

        caixavalorconverter = new JTextField(10);
        panelConversao.add(caixavalorconverter);

        btncalcular = new JButton("Calcular");
        panelConversao.add(btncalcular);

        btnvoltar = new JButton("Voltar");
        panelConversao.add(btnvoltar);

//------------------------------------       
        
        btnvoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //remove o painel de conversão
                getContentPane().remove(panelConversao);

                //adiciona de volta o menu de seleção do país
                getContentPane().add(panelMenuPais, BorderLayout.CENTER);

                //atualizar a interface gráfica
                revalidate();
                repaint();
            }
        });

        btncalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {  
                    //O try-catch permite identificar e controlar erros de maneira eficaz, evitando que o programa quebre inesperadamente.
                	//try -  utilizado para envolver o código que pode gerar exceções, o código que desejamos monitorar quanto a possíveis erros.
                    double money = Double.parseDouble(caixavalorconverter.getText());//pega os valores do JTextField e converte para double
                    double resultadofinal = money * moedaestrangeira; //calcula o resultado
                    JOptionPane.showMessageDialog(null, "Valor convertido: " + String.format("%.2f", resultadofinal));
                } catch (NumberFormatException ex) { 
                	//catch - usado pra capturar e lidar com essas exceções caso elas ocorram
                	//exibe uma mensagem de erro se tiver erro no formato digitado
                    JOptionPane.showMessageDialog(null, "Digite valores numéricos!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //adiciona o painel de conversão ao JFrame
        getContentPane().add(panelConversao, BorderLayout.CENTER);

        //atualiza a interface gráfica
        revalidate();
        repaint();
    }
}
