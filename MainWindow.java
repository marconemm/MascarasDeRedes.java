/**
 * @author Marcone Melo Mendonça
 * @date 26/10/2015. (Última modificação: 22/11/2015.)
 * @version Beta 
 */

package marconemendonca.mascarasderedes;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.Desktop;
import java.net.URI;


public class MainWindow extends JFrame {

	//serialVersionUID "standard = 1L"
	
	private static final long serialVersionUID = 1L;
	private JPanel mainWindow;
	private final ButtonGroup buttonGroup_Intro = new ButtonGroup();
	private JTextField textField_nHosts;
	private JTextField textField_CDIRWindow_CDIR;
	private JTextField textField_MeDecimalWindow_MeDecimaisG1;
	private JTextField textField_MeDecimalWindow_MeDecimaisG2;
	private JTextField textField_MeDecimalWindow_MeDecimaisG3;
	private JTextField textField_MeDecimalWindow_MeDecimaisG4;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("M\u00E1scaras de Redes (Beta)");
		setFont(UIManager.getFont("EditorPane.font"));
		setForeground(SystemColor.window);
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(320, 256, 650, 380);
		
		Calculos calcular = new Calculos(); //cria o Objeto "calcular" com a SuperClasse "Calculos".
		
		JMenuBar menuBar_MainWindow = new JMenuBar();
		setJMenuBar(menuBar_MainWindow);
		
		JMenu mn_MainWindow_File = new JMenu("Arquivo");
		mn_MainWindow_File.setMnemonic('A');
		
		mn_MainWindow_File.setForeground(SystemColor.windowText);
		mn_MainWindow_File.setFont(UIManager.getFont("Menu.font"));
		menuBar_MainWindow.add(mn_MainWindow_File);
		
		
		JMenuItem mnIt_MainWindow_NewCalc = new JMenuItem("Novo C\u00E1lculo");
		mnIt_MainWindow_NewCalc.setMnemonic('N');
		mnIt_MainWindow_NewCalc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnIt_MainWindow_NewCalc.setIcon(null);
		mnIt_MainWindow_NewCalc.setFont(UIManager.getFont("Button.font"));
		mnIt_MainWindow_NewCalc.setForeground(SystemColor.windowText);
		mn_MainWindow_File.add(mnIt_MainWindow_NewCalc);
		mnIt_MainWindow_NewCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				CardLayout windowIntro = (CardLayout) mainWindow.getLayout();
				windowIntro.show(mainWindow, "window_intro_CardLayout");
			}
		});
		
		
		JMenuItem mnIt_MainWindow_Exit = new JMenuItem("Sair");
		mnIt_MainWindow_Exit.setMnemonic('S');
		mnIt_MainWindow_Exit.setIcon(null);
		mnIt_MainWindow_Exit.setForeground(SystemColor.windowText);
		mnIt_MainWindow_Exit.setFont(UIManager.getFont("Button.font"));
		mn_MainWindow_File.add(mnIt_MainWindow_Exit);
		
		//Menu "Sobre":
		JMenu mn_MainWindow_About = new JMenu("Sobre");
		mn_MainWindow_About.setMnemonic('o');
		mn_MainWindow_About.setForeground(Color.BLACK);
		mn_MainWindow_About.setFont(UIManager.getFont("Menu.font"));
		menuBar_MainWindow.add(mn_MainWindow_About);
		
		//Item de Menu "Sobre...":
		JMenuItem mnIt_MainWindow_About = new JMenuItem("Sobre...");
		mnIt_MainWindow_About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				CardLayout windowIntro = (CardLayout) mainWindow.getLayout();
				windowIntro.show(mainWindow, "window_About_CardLayout");
			}
		});
		mnIt_MainWindow_About.setMnemonic('S');
		mnIt_MainWindow_About.setForeground(Color.BLACK);
		mnIt_MainWindow_About.setFont(UIManager.getFont("Button.font"));
		mn_MainWindow_About.add(mnIt_MainWindow_About);
		mnIt_MainWindow_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exitAction) {
				if (exitAction.getSource() == mnIt_MainWindow_Exit)
					System.exit(EXIT_ON_CLOSE);
			}
		});
		
		mainWindow = new JPanel();
		mainWindow.setForeground(SystemColor.menu);
		mainWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainWindow);
		mainWindow.setLayout(new CardLayout(0, 0));
		
		JPanel jP_intro_CardLayout = new JPanel();
		jP_intro_CardLayout.setBackground(SystemColor.menu);
		jP_intro_CardLayout.setForeground(SystemColor.menu);
		jP_intro_CardLayout.setBorder(null);
		mainWindow.add(jP_intro_CardLayout, "window_intro_CardLayout");
		jP_intro_CardLayout.setLayout(new CardLayout(0, 0));
		
		JPanel jP_intro_AbsLayout = new JPanel();
		jP_intro_CardLayout.add(jP_intro_AbsLayout, "jP_intro");
		jP_intro_AbsLayout.setLayout(null);
		
		JLabel label_Parametro_introWindow = new JLabel("Qual par\u00E2metro deseja utilizar?");
		label_Parametro_introWindow.setBounds(21, 130, 185, 14);
		jP_intro_AbsLayout.add(label_Parametro_introWindow);
		
		JRadioButton jRadiobutton_Hosts_introWindow = new JRadioButton("N\u00FAmero de HOSTS");
		jRadiobutton_Hosts_introWindow.setMnemonic('H');
		buttonGroup_Intro.add(jRadiobutton_Hosts_introWindow);
		jRadiobutton_Hosts_introWindow.setToolTipText("Neste par\u00E2metro deve ser informado o n\u00FAmero de HOSTS (clientes) que poder\u00E3o utilizar a Rede.");
		jRadiobutton_Hosts_introWindow.setSelected(true);
		jRadiobutton_Hosts_introWindow.setBounds(21, 155, 150, 23);
		jP_intro_AbsLayout.add(jRadiobutton_Hosts_introWindow);
		
		
		JRadioButton jRadiobutton_CDIR_introWindow = new JRadioButton("Barramento CDIR");
		jRadiobutton_CDIR_introWindow.setMnemonic('B');
		buttonGroup_Intro.add(jRadiobutton_CDIR_introWindow);
		jRadiobutton_CDIR_introWindow.setToolTipText("Neste par\u00E2metro deve ser informado o Barramento CDIR (2 < CDIR < 32).");
		jRadiobutton_CDIR_introWindow.setBounds(21, 185, 150, 23);
		jP_intro_AbsLayout.add(jRadiobutton_CDIR_introWindow);
		
		JRadioButton radioButton_MeDecimais_introWindow = new JRadioButton("M\u00E1scara de Sub-rede em DECIMAIS");
		radioButton_MeDecimais_introWindow.setMnemonic('M');
		buttonGroup_Intro.add(radioButton_MeDecimais_introWindow);
		radioButton_MeDecimais_introWindow.setToolTipText("Neste par\u00E2metro deve ser informada uma M\u00E1scara de Sub-rede em DECIMAIS.");
		radioButton_MeDecimais_introWindow.setBounds(21, 215, 230, 23);
		jP_intro_AbsLayout.add(radioButton_MeDecimais_introWindow);
		
		
		JButton btn_Next_introWindow = new JButton("Pr\u00F3ximo >>");
		btn_Next_introWindow.setMnemonic('P');
		btn_Next_introWindow.setBounds(21, 245, 100, 23);
		jP_intro_AbsLayout.add(btn_Next_introWindow);
		btn_Next_introWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jRadiobutton_Hosts_introWindow.isSelected()){
					CardLayout windowHOSTS = (CardLayout) mainWindow.getLayout();
					windowHOSTS.show(mainWindow, "windowHOSTS_CardLayout");
				} else if(jRadiobutton_CDIR_introWindow.isSelected()){
					CardLayout windowCDIR = (CardLayout) mainWindow.getLayout();
					windowCDIR.show(mainWindow, "jP_CDIRWindow_CardLayout");
				} else {
					CardLayout windowMeDecimais = (CardLayout) mainWindow.getLayout();
					windowMeDecimais.show(mainWindow, "jP_MeDecimaisWindow_CardLayout");
				}
			}
		});
		
		JTextArea txtr_Descricao_introWindow = new JTextArea();
		txtr_Descricao_introWindow.setFocusable(false);
		txtr_Descricao_introWindow.setEditable(false);
		txtr_Descricao_introWindow.setLineWrap(true);
		txtr_Descricao_introWindow.setTabSize(2);
		txtr_Descricao_introWindow.setRows(6);
		txtr_Descricao_introWindow.setForeground(SystemColor.windowText);
		txtr_Descricao_introWindow.setBackground(SystemColor.menu);
		txtr_Descricao_introWindow.setText("Esta aplica\u00E7\u00E3o destina-se \u00E0s determina\u00E7\u00F5es de M\u00E1scaras de Sub-rede.\r\n\r\nPodendo essas serem determinadas por 4 par\u00E2metros: N\u00FAmero de HOSTS, Barramento CDIR e M\u00E1scara de\r\nSub-rede em DECIMAIS.\r\n\r\nConforme as op\u00E7\u00F5es abaixo, basta escolher qual o par\u00E2metro de c\u00E1lculo deseja utilizar.");
		txtr_Descricao_introWindow.setBounds(10, 11, 614, 112);
		jP_intro_AbsLayout.add(txtr_Descricao_introWindow);
		
		JLabel lbl_FREEWARE_introWindow = new JLabel("FREEWARE");
		lbl_FREEWARE_introWindow.setForeground(new Color(0, 128, 0));
		lbl_FREEWARE_introWindow.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_FREEWARE_introWindow.setBounds(557, 294, 66, 15);
		jP_intro_AbsLayout.add(lbl_FREEWARE_introWindow);
		
		JLabel lbl_Distribuicao_introWindow = new JLabel("Distribui\u00E7\u00E3o:");
		lbl_Distribuicao_introWindow.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_Distribuicao_introWindow.setBounds(488, 295, 59, 14);
		jP_intro_AbsLayout.add(lbl_Distribuicao_introWindow);
		
		JPanel jP_HostsWindow_CL = new JPanel();
		mainWindow.add(jP_HostsWindow_CL, "windowHOSTS_CardLayout");
		jP_HostsWindow_CL.setForeground(SystemColor.menu);
		jP_HostsWindow_CL.setBorder(null);
		jP_HostsWindow_CL.setBackground(SystemColor.menu);
		jP_HostsWindow_CL.setLayout(new CardLayout(0, 0));
		
		JPanel jP_HostsWindow_AbsLayout = new JPanel();
		jP_HostsWindow_AbsLayout.setEnabled(false);
		jP_HostsWindow_AbsLayout.setLayout(null);
		jP_HostsWindow_CL.add(jP_HostsWindow_AbsLayout, "windowHOSTS_AbsLayout");
		
		textField_nHosts = new JTextField();
		textField_nHosts.setToolTipText("Valores aceitos: 1 a 4.294.967.294");
		textField_nHosts.setAutoscrolls(false);
		textField_nHosts.setAlignmentY(Component.TOP_ALIGNMENT);
		textField_nHosts.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField_nHosts.setBackground(SystemColor.text);
		textField_nHosts.setBounds(206, 70, 100, 20);
		jP_HostsWindow_AbsLayout.add(textField_nHosts);
		
		JTextPane txtP_HostsWindow_Hosts_n = new JTextPane();
		txtP_HostsWindow_Hosts_n.setFocusable(false);
		txtP_HostsWindow_Hosts_n.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtP_HostsWindow_Hosts_n.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_HostsWindow_Hosts_n.setBackground(SystemColor.info);
		txtP_HostsWindow_Hosts_n.setEditable(false);
		txtP_HostsWindow_Hosts_n.setBounds(200, 145, 100, 20);
		jP_HostsWindow_AbsLayout.add(txtP_HostsWindow_Hosts_n);
		
		JTextPane txtP_HostsWindow_Hosts_p = new JTextPane();
		txtP_HostsWindow_Hosts_p.setEditable(false);
		txtP_HostsWindow_Hosts_p.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_HostsWindow_Hosts_p.setBackground(SystemColor.info);
		txtP_HostsWindow_Hosts_p.setBounds(200, 170, 100, 20);
		jP_HostsWindow_AbsLayout.add(txtP_HostsWindow_Hosts_p);
		
		JTextPane txtP_HostsWindow_MeBinario = new JTextPane();
		txtP_HostsWindow_MeBinario.setEditable(false);
		txtP_HostsWindow_MeBinario.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_HostsWindow_MeBinario.setBackground(SystemColor.info);
		txtP_HostsWindow_MeBinario.setBounds(200, 195, 240, 20);
		jP_HostsWindow_AbsLayout.add(txtP_HostsWindow_MeBinario);
		
		JTextPane txtP_HostsWindow_MeDecimal = new JTextPane();
		txtP_HostsWindow_MeDecimal.setEditable(false);
		txtP_HostsWindow_MeDecimal.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_HostsWindow_MeDecimal.setBackground(SystemColor.info);
		txtP_HostsWindow_MeDecimal.setBounds(200, 220, 100, 20);
		jP_HostsWindow_AbsLayout.add(txtP_HostsWindow_MeDecimal);
		
		JTextPane txtP_HostsWindow_CDIR = new JTextPane();
		txtP_HostsWindow_CDIR.setEditable(false);
		txtP_HostsWindow_CDIR.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_HostsWindow_CDIR.setBackground(SystemColor.info);
		txtP_HostsWindow_CDIR.setBounds(200, 245, 50, 20);
		jP_HostsWindow_AbsLayout.add(txtP_HostsWindow_CDIR);
		
		JButton btn_HostsWindow_calc = new JButton("Calcular");
		btn_HostsWindow_calc.setMnemonic('C');
		btn_HostsWindow_calc.setAlignmentY(Component.TOP_ALIGNMENT);
		btn_HostsWindow_calc.setBounds(206, 101, 90, 25);
		jP_HostsWindow_AbsLayout.add(btn_HostsWindow_calc);
		
		//Calculos hosts = new Calculos(); 
		
		//determina a ação para o botão "Calcular" da Janela de HOSTS:
				btn_HostsWindow_calc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent calcHosts) {
						
						try { //INICIO Tratamento de exeção tipo "NumberFormatException":											
							long hosts_n = Long.parseLong(textField_nHosts.getText()); // pode retornar uma "NumberFormatException".
							
							while ((hosts_n < 0) || (hosts_n > 4294967294L)) {
								String hosts_nString = JOptionPane.showInputDialog(btn_HostsWindow_calc, "Valor inválido!\n\nInforme um valor entre: 1 e 4.294.967.294:", "Aviso:", 2);
								hosts_n = Long.parseLong(hosts_nString); // pode retornar uma "NumberFormatException".
								textField_nHosts.setText(hosts_nString);
							};
						} catch (NumberFormatException nfe){
							JOptionPane.showMessageDialog(btn_HostsWindow_calc, "O valor informado não é um número INTEIRO!", "Aviso:", 0);
							textField_nHosts.setText("0");							
						} //FIM Tratamento de exeção tipo "NumberFormatException".	
						
						long hosts_p = calcular.setHostsPossibles(Long.parseLong(textField_nHosts.getText()), "Indireto"); // determina "hosts_p", através do método calcular.SetHostsPossibles(hosts_n, tipoCalc).
						byte cdir = calcular.setCDIR(); // recebe o resultado do método setCDIR da Calsse Hosts.
						
						//A próxima instrução, atribui os valores aos respectivos campos de exibição.
						if (hosts_p == 0){
							txtP_HostsWindow_Hosts_n.setText(null);
							txtP_HostsWindow_Hosts_p.setText(null);
							txtP_HostsWindow_MeBinario.setText(null);
							txtP_HostsWindow_MeDecimal.setText(null);
							txtP_HostsWindow_CDIR.setText(null);
						}else{
							txtP_HostsWindow_Hosts_n.setText(textField_nHosts.getText());
							txtP_HostsWindow_Hosts_p.setText(Long.valueOf(hosts_p).toString());
							txtP_HostsWindow_MeBinario.setText(calcular.setMaskBinary());
							txtP_HostsWindow_MeDecimal.setText(calcular.setMaskDecimal());
							txtP_HostsWindow_CDIR.setText(Byte.valueOf(cdir).toString());
						}
					}
				});
				
		JButton btn_HostsWindow_ClearFields = new JButton("Limpar");
		btn_HostsWindow_ClearFields.setMnemonic('L');
		btn_HostsWindow_calc.setAlignmentY(Component.TOP_ALIGNMENT);
		btn_HostsWindow_ClearFields.setBounds(306, 101, 90, 25);
		jP_HostsWindow_AbsLayout.add(btn_HostsWindow_ClearFields);
		btn_HostsWindow_ClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clearHosts) {
				textField_nHosts.setText(null);
				txtP_HostsWindow_Hosts_n.setText(null);
				txtP_HostsWindow_Hosts_p.setText(null);
				txtP_HostsWindow_MeBinario.setText(null);
				txtP_HostsWindow_MeDecimal.setText(null);
				txtP_HostsWindow_CDIR.setText(null);
			}
		});		
				
		JLabel lbl_HostsWindow_Hosts_n = new JLabel("N\u00FAmero de HOSTS da sua rede:");
		lbl_HostsWindow_Hosts_n.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_HostsWindow_Hosts_n.setBounds(46, 151, 152, 14);
		jP_HostsWindow_AbsLayout.add(lbl_HostsWindow_Hosts_n);
		
		JLabel lbl_HostsWindow_Hosts_p = new JLabel("M\u00E1ximo de HOSTS poss\u00EDveis:");
		lbl_HostsWindow_Hosts_p.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_HostsWindow_Hosts_p.setBounds(61, 176, 137, 14);
		jP_HostsWindow_AbsLayout.add(lbl_HostsWindow_Hosts_p);
		
		JLabel lbl_HostsWindow_MeBinario = new JLabel("M\u00E1scara em Bin\u00E1rio:");
		lbl_HostsWindow_MeBinario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_HostsWindow_MeBinario.setBounds(102, 201, 96, 14);
		jP_HostsWindow_AbsLayout.add(lbl_HostsWindow_MeBinario);
		
		JLabel lbl_HostsWindow_MeDecimal = new JLabel("M\u00E1scara em Decimal:");
		lbl_HostsWindow_MeDecimal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_HostsWindow_MeDecimal.setBounds(98, 226, 100, 14);
		jP_HostsWindow_AbsLayout.add(lbl_HostsWindow_MeDecimal);
		
		JLabel lbl_HostsWindow_CDIR = new JLabel("Barramento CDIR: /");
		lbl_HostsWindow_CDIR.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_HostsWindow_CDIR.setBounds(102, 251, 95, 14);
		jP_HostsWindow_AbsLayout.add(lbl_HostsWindow_CDIR);
		
		JButton btn_HostsWindow_Back = new JButton("<< Voltar");
		btn_HostsWindow_Back.setMnemonic('V');
		btn_HostsWindow_calc.setAlignmentY(Component.TOP_ALIGNMENT);
		btn_HostsWindow_Back.setBounds(206, 274, 90, 25);
		jP_HostsWindow_AbsLayout.add(btn_HostsWindow_Back);
		btn_HostsWindow_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout windowIntro = (CardLayout) mainWindow.getLayout();
				windowIntro.show(mainWindow, "window_intro_CardLayout");
			}
		});
		
		JLabel lbl_HostsWindow_Titulo = new JLabel("Par\u00E2metro: N\u00FAmero de HOSTS");
		lbl_HostsWindow_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_HostsWindow_Titulo.setBounds(200, 0, 212, 17);
		jP_HostsWindow_AbsLayout.add(lbl_HostsWindow_Titulo);
		
		JTextArea txta_HostsWindow_Descricao = new JTextArea();
		txta_HostsWindow_Descricao.setFocusable(false);
		txta_HostsWindow_Descricao.setBounds(102, 28, 414, 37);
		jP_HostsWindow_AbsLayout.add(txta_HostsWindow_Descricao);
		txta_HostsWindow_Descricao.setWrapStyleWord(true);
		txta_HostsWindow_Descricao.setText("Neste par\u00E2metro deve ser informado o n\u00FAmero de HOSTS (clientes) que poder\u00E3o utilizar a Rede.");
		txta_HostsWindow_Descricao.setLineWrap(true);
		txta_HostsWindow_Descricao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txta_HostsWindow_Descricao.setEditable(false);
		txta_HostsWindow_Descricao.setBorder(null);
		txta_HostsWindow_Descricao.setAlignmentY(0.0f);
		txta_HostsWindow_Descricao.setAlignmentX(0.0f);
		
		JLabel lbl_HostsWindow_Hosts_inf = new JLabel("Informe o n\u00FAmero de HOSTS desejado:");
		lbl_HostsWindow_Hosts_inf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_HostsWindow_Hosts_inf.setBounds(10, 73, 188, 14);
		jP_HostsWindow_AbsLayout.add(lbl_HostsWindow_Hosts_inf);
		
		JLabel lbl_FREEWARE_HostsWindow = new JLabel("FREEWARE");
		lbl_FREEWARE_HostsWindow.setForeground(new Color(0, 128, 0));
		lbl_FREEWARE_HostsWindow.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_FREEWARE_HostsWindow.setBounds(558, 294, 66, 15);
		jP_HostsWindow_AbsLayout.add(lbl_FREEWARE_HostsWindow);
		
		JLabel lbl_Distribuicao_HostsWindow = new JLabel("Distribui\u00E7\u00E3o:");
		lbl_Distribuicao_HostsWindow.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_Distribuicao_HostsWindow.setBounds(489, 295, 59, 14);
		jP_HostsWindow_AbsLayout.add(lbl_Distribuicao_HostsWindow);
		
		JPanel jP_cdirWindow_CardLayout = new JPanel();
		jP_cdirWindow_CardLayout.setForeground(SystemColor.menu);
		jP_cdirWindow_CardLayout.setBorder(null);
		jP_cdirWindow_CardLayout.setBackground(SystemColor.menu);
		mainWindow.add(jP_cdirWindow_CardLayout, "jP_CDIRWindow_CardLayout");
		jP_cdirWindow_CardLayout.setLayout(new CardLayout(0, 0));
		
		JPanel jP_cdirWindow_AbsLayout = new JPanel();
		jP_cdirWindow_AbsLayout.setLayout(null);
		jP_cdirWindow_AbsLayout.setEnabled(false);
		jP_cdirWindow_CardLayout.add(jP_cdirWindow_AbsLayout, "jP_CDIRWindow_AbsLayout");
		
		textField_CDIRWindow_CDIR = new JTextField();
		textField_CDIRWindow_CDIR.setToolTipText("Valores aceitos: 1 a 32.");
		textField_CDIRWindow_CDIR.setBackground(Color.WHITE);
		textField_CDIRWindow_CDIR.setAutoscrolls(false);
		textField_CDIRWindow_CDIR.setAlignmentY(0.0f);
		textField_CDIRWindow_CDIR.setAlignmentX(0.0f);
		textField_CDIRWindow_CDIR.setBounds(160, 69, 40, 20);
		jP_cdirWindow_AbsLayout.add(textField_CDIRWindow_CDIR);
		
		JTextPane txtP_CDIRWindow_Hosts_p = new JTextPane();
		txtP_CDIRWindow_Hosts_p.setEditable(false);
		txtP_CDIRWindow_Hosts_p.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_CDIRWindow_Hosts_p.setBackground(SystemColor.info);
		txtP_CDIRWindow_Hosts_p.setBounds(200, 170, 100, 20);
		jP_cdirWindow_AbsLayout.add(txtP_CDIRWindow_Hosts_p);
		
		JTextPane txtP_CDIRWindow_MeBinario = new JTextPane();
		txtP_CDIRWindow_MeBinario.setEditable(false);
		txtP_CDIRWindow_MeBinario.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_CDIRWindow_MeBinario.setBackground(SystemColor.info);
		txtP_CDIRWindow_MeBinario.setBounds(200, 195, 240, 20);
		jP_cdirWindow_AbsLayout.add(txtP_CDIRWindow_MeBinario);
		
		JTextPane txtP_CDIRWindow_MeDecimal = new JTextPane();
		txtP_CDIRWindow_MeDecimal.setEditable(false);
		txtP_CDIRWindow_MeDecimal.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_CDIRWindow_MeDecimal.setBackground(SystemColor.info);
		txtP_CDIRWindow_MeDecimal.setBounds(200, 220, 100, 20);
		jP_cdirWindow_AbsLayout.add(txtP_CDIRWindow_MeDecimal);
		
		JTextPane txtP_CDIRWindow_CDIR = new JTextPane();
		txtP_CDIRWindow_CDIR.setEditable(false);
		txtP_CDIRWindow_CDIR.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_CDIRWindow_CDIR.setBackground(SystemColor.info);
		txtP_CDIRWindow_CDIR.setBounds(200, 145, 50, 20);
		jP_cdirWindow_AbsLayout.add(txtP_CDIRWindow_CDIR);
		
		JButton btn_CDIRWindow_calc = new JButton("Calcular");
		btn_CDIRWindow_calc.setMnemonic('C');
		btn_CDIRWindow_calc.setAlignmentY(0.0f);
		btn_CDIRWindow_calc.setBounds(10, 100, 90, 25);
		jP_cdirWindow_AbsLayout.add(btn_CDIRWindow_calc);
		btn_CDIRWindow_calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*A próxima instrução, cria um "tratamento de exeção" para os possíveis erros de entrada
				 * de dados pelo usuário.*/
				try {	
					byte  temp_CDIR = Byte.parseByte(textField_CDIRWindow_CDIR.getText()); // pode retornar uma "NumberFormatException".
					
					if ((temp_CDIR < 0) || (temp_CDIR > 32)) {
						JOptionPane.showMessageDialog(btn_CDIRWindow_calc, "O valor informado não é válido!\n\nPor favor, tente novamente com um valor entre 0 e 32.", "Aviso:", 2);
						temp_CDIR = Byte.parseByte("0");
						textField_CDIRWindow_CDIR.setText("0");
					};
					if (temp_CDIR == 31) {
						JOptionPane.showMessageDialog(btn_CDIRWindow_calc, "O Barramento \"CDIR /31\" é inutilizável.", "Aviso:", 0);
						temp_CDIR = Byte.parseByte("0");
						textField_CDIRWindow_CDIR.setText("0");
					}
					if (temp_CDIR == 32) {
						JOptionPane.showMessageDialog(btn_CDIRWindow_calc, "O Barramento \"CDIR /32\" é útil apenas para um único HOST.", "Aviso:", 1);
						temp_CDIR = Byte.parseByte("32");
						textField_CDIRWindow_CDIR.setText("32");
					}
				} catch (NumberFormatException nfe){
					JOptionPane.showMessageDialog(btn_CDIRWindow_calc, "O valor informado não é válido!\n\nPor favor, tente novamente com um valor entre 0 e 32.", "Aviso:", 0);
					textField_CDIRWindow_CDIR.setText("0");							
				}
				
				calcular.getCDIR(Byte.valueOf(textField_CDIRWindow_CDIR.getText())); //recebe o valor informado como barramento CDIR.
				long hosts_p = calcular.setHostsPossibles(0, "Direto"); // determina o valor de "hosts_p", pelo método "calcular.SetHostsPossibles(0, "Direto")".								
				
				//INICIO das atribuições de valores para os campos:
				if (Byte.parseByte(textField_CDIRWindow_CDIR.getText()) == 0){// existe Barramento CDIR /0?
					txtP_CDIRWindow_CDIR.setText(textField_CDIRWindow_CDIR.getText());
					txtP_CDIRWindow_Hosts_p.setText("4294967294");
					txtP_CDIRWindow_MeBinario.setText(calcular.setMaskBinary());
					txtP_CDIRWindow_MeDecimal.setText(calcular.setMaskDecimal());
					} else if (Byte.parseByte(textField_CDIRWindow_CDIR.getText()) == 32){
						txtP_CDIRWindow_CDIR.setText(textField_CDIRWindow_CDIR.getText());	
						txtP_CDIRWindow_Hosts_p.setText("1");
						txtP_CDIRWindow_MeBinario.setText("11111111.11111111.11111111.11111111");
						txtP_CDIRWindow_MeDecimal.setText("255.255.255.255");
						} else {
							txtP_CDIRWindow_CDIR.setText(textField_CDIRWindow_CDIR.getText());	
							txtP_CDIRWindow_Hosts_p.setText(Long.valueOf(hosts_p).toString());
							txtP_CDIRWindow_MeBinario.setText(calcular.setMaskBinary());
							txtP_CDIRWindow_MeDecimal.setText(calcular.setMaskDecimal());
						}
				//FIM das atribuições de valores para os campos.
			}
		});
		
		JButton btn_CDIRWindow_ClearFields = new JButton("Limpar");
		btn_CDIRWindow_ClearFields.setMnemonic('L');
		btn_CDIRWindow_ClearFields.setBounds(110, 100, 90, 25);
		jP_cdirWindow_AbsLayout.add(btn_CDIRWindow_ClearFields);
		btn_CDIRWindow_ClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_CDIRWindow_CDIR.setText(null);
				txtP_CDIRWindow_Hosts_p.setText(null);
				txtP_CDIRWindow_MeBinario.setText(null);
				txtP_CDIRWindow_MeDecimal.setText(null);
				txtP_CDIRWindow_CDIR.setText(null);
			}
		});
		
		JLabel lbl_CDIRWindow_Hosts_p = new JLabel("M\u00E1ximo de HOSTS poss\u00EDveis:");
		lbl_CDIRWindow_Hosts_p.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_CDIRWindow_Hosts_p.setBounds(63, 176, 137, 14);
		jP_cdirWindow_AbsLayout.add(lbl_CDIRWindow_Hosts_p);
		
		JLabel lbl_CDIRWindow_MeBinario = new JLabel("M\u00E1scara em Bin\u00E1rio:");
		lbl_CDIRWindow_MeBinario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_CDIRWindow_MeBinario.setBounds(104, 201, 96, 14);
		jP_cdirWindow_AbsLayout.add(lbl_CDIRWindow_MeBinario);
		
		JLabel lbl_CDIRWindow_MeDecimal = new JLabel("M\u00E1scara em Decimal:");
		lbl_CDIRWindow_MeDecimal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_CDIRWindow_MeDecimal.setBounds(100, 226, 100, 14);
		jP_cdirWindow_AbsLayout.add(lbl_CDIRWindow_MeDecimal);
		
		JLabel lbl_CDIRWindow_CDIR = new JLabel("Barramento CDIR: / ");
		lbl_CDIRWindow_CDIR.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_CDIRWindow_CDIR.setBounds(102, 151, 98, 14);
		jP_cdirWindow_AbsLayout.add(lbl_CDIRWindow_CDIR);
		
		JButton btn_CDIRWindow_back = new JButton("<< Voltar");
		btn_CDIRWindow_back.setMnemonic('V');
		btn_CDIRWindow_back.setBounds(255, 249, 90, 25);
		jP_cdirWindow_AbsLayout.add(btn_CDIRWindow_back);
		btn_CDIRWindow_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout windowIntro = (CardLayout) mainWindow.getLayout();
				windowIntro.show(mainWindow, "window_intro_CardLayout");
			}
		});
		
		JLabel lbl_CDIRWindow_Titulo = new JLabel("Par\u00E2metro: CDIR");
		lbl_CDIRWindow_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_CDIRWindow_Titulo.setBounds(255, 0, 119, 17);
		jP_cdirWindow_AbsLayout.add(lbl_CDIRWindow_Titulo);
		
		JLabel lbl_CDIRWindow_CDIR_info = new JLabel("Informe o Barramento CDIR: /");
		lbl_CDIRWindow_CDIR_info.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_CDIRWindow_CDIR_info.setBounds(10, 73, 152, 14);
		jP_cdirWindow_AbsLayout.add(lbl_CDIRWindow_CDIR_info);
		
		JScrollPane scrollPane_CDIRWindow_Descricao = new JScrollPane();
		scrollPane_CDIRWindow_Descricao.setBounds(210, 28, 415, 90);
		ScrollPaneConstants.UPPER_LEFT_CORNER.length();
		jP_cdirWindow_AbsLayout.add(scrollPane_CDIRWindow_Descricao);
		
		JTextArea txta_CDIRWindow_Descricao = new JTextArea();
		txta_CDIRWindow_Descricao.setAlignmentX(Component.LEFT_ALIGNMENT);
		txta_CDIRWindow_Descricao.setAlignmentY(Component.TOP_ALIGNMENT);
		txta_CDIRWindow_Descricao.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txta_CDIRWindow_Descricao.setWrapStyleWord(true);
		txta_CDIRWindow_Descricao.setText("Neste par\u00E2metro os c\u00E1lculos s\u00E3o baseados no Barramento CDIR da sua Rede.\r\n\r\nCDIR : Classless Inter-Domain Routing, foi introduzido em 1993, como um refinamento para a forma como o tr\u00E1fego era conduzido pelas redes IP. Permitindo flexibilidade acrescida quando dividindo margens de endere\u00E7os IP em redes separadas, promoveu assim um uso mais eficiente para os endere\u00E7os IP cada vez mais escassos.\r\n\r\nhttp://pt.wikipedia.org/wiki/CIDR");
		txta_CDIRWindow_Descricao.setLineWrap(true);
		txta_CDIRWindow_Descricao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txta_CDIRWindow_Descricao.setEditable(false);
		txta_CDIRWindow_Descricao.setBorder(null);
		txta_CDIRWindow_Descricao.select(Byte.MIN_VALUE, 1); //determina que a ScrollBar inicie posicionada na parte superior da barra.
		scrollPane_CDIRWindow_Descricao.setViewportView(txta_CDIRWindow_Descricao);
		
		JLabel lbl_FREEWARE_CDIRWindow = new JLabel("FREEWARE");
		lbl_FREEWARE_CDIRWindow.setForeground(new Color(0, 128, 0));
		lbl_FREEWARE_CDIRWindow.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_FREEWARE_CDIRWindow.setBounds(559, 294, 66, 15);
		jP_cdirWindow_AbsLayout.add(lbl_FREEWARE_CDIRWindow);
		
		JLabel lbl_Distribuicao_CDIRWindow = new JLabel("Distribui\u00E7\u00E3o:");
		lbl_Distribuicao_CDIRWindow.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_Distribuicao_CDIRWindow.setBounds(490, 295, 59, 14);
		jP_cdirWindow_AbsLayout.add(lbl_Distribuicao_CDIRWindow);
		
		JPanel jP_MeDecimaisWindow_CL = new JPanel();
		jP_MeDecimaisWindow_CL.setForeground(SystemColor.menu);
		jP_MeDecimaisWindow_CL.setBorder(null);
		jP_MeDecimaisWindow_CL.setBackground(SystemColor.menu);
		mainWindow.add(jP_MeDecimaisWindow_CL, "jP_MeDecimaisWindow_CardLayout");
		jP_MeDecimaisWindow_CL.setLayout(new CardLayout(0, 0));
		
		JPanel jP_MeDecimaisWindow_AbsLayout = new JPanel();
		jP_MeDecimaisWindow_AbsLayout.setLayout(null);
		jP_MeDecimaisWindow_CL.add(jP_MeDecimaisWindow_AbsLayout, "jP_MeDecimaisWindow_AbsLayout");
		
		JLabel lbl_MeDecimalWindow_Titulo = new JLabel("Par\u00E2metro: M\u00E1scara em DECIMAL");
		lbl_MeDecimalWindow_Titulo.setAlignmentY(Component.TOP_ALIGNMENT);
		lbl_MeDecimalWindow_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_MeDecimalWindow_Titulo.setBounds(194, 0, 233, 17);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimalWindow_Titulo);
		
		JScrollPane scrollPane_MeDecimalWindow_Descricao = new JScrollPane();
		scrollPane_MeDecimalWindow_Descricao.setBounds(10, 28, 604, 90);
		jP_MeDecimaisWindow_AbsLayout.add(scrollPane_MeDecimalWindow_Descricao);
		
		JTextArea txta_MeDecimal_Descricao = new JTextArea();
		txta_MeDecimal_Descricao.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane_MeDecimalWindow_Descricao.setViewportView(txta_MeDecimal_Descricao);
		txta_MeDecimal_Descricao.setWrapStyleWord(true);
		txta_MeDecimal_Descricao.setText("Neste par\u00E2metro, deve ser informada uma M\u00E1scara de Sub-rede em decimal, por exepmlo: \r\n\r\n255.255.240.0\r\n\r\nConceito:\r\n\r\nUma m\u00E1scara de sub-rede tamb\u00E9m conhecida como subnet mask ou netmask, \u00E9 uma bitmask de 32 bits usada para informar os routers.\r\n\r\nNormalmente, as m\u00E1scaras de sub-rede s\u00E3o representadas com quatro n\u00FAmeros. 0 e 255 separados por tr\u00EAs pontos [...].\r\n\r\n[...]\r\n\r\nCada m\u00E1scara de sub-rede \u00E9 um n\u00FAmero de 32 bits que usa grupos de bits consecutivos de todos os n\u00FAmeros um (1) para identificar a parte referente \u00E0 identifica\u00E7\u00E3o de rede e de zeros (0) para identificar a parte referente ao host de um endere\u00E7o IP.\r\n\r\nPor exemplo, uma m\u00E1scara de sub-rede normalmente usada com o endere\u00E7o IP 131.107.16.200 \u00E9 o seguinte n\u00FAmero bin\u00E1rio de 32 bits:\r\n\r\n11111111 11111111 00000000 00000000\r\n\r\nEsse n\u00FAmero de m\u00E1scara de sub-rede \u00E9 16 bits de \" 1 \" seguidos de 16 bits de \" 0 \", indicando que as partes referentes \u00E0 identifica\u00E7\u00E3o de rede e de host desse endere\u00E7o IP t\u00EAm ambas 16 bits de comprimento.\r\n\r\nNormalmente, essa m\u00E1scara de sub-rede \u00E9 exibida em nota\u00E7\u00E3o decimal com ponto como 255.255.0.0.\r\n\r\nFonte: http://technet.microsoft.com/pt-br/library/cc776674(v=ws.10).aspx");
		txta_MeDecimal_Descricao.setLineWrap(true);
		txta_MeDecimal_Descricao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txta_MeDecimal_Descricao.setEditable(false);
		txta_MeDecimal_Descricao.setBorder(null);
		txta_MeDecimal_Descricao.select(Byte.MIN_VALUE, 1);
		txta_MeDecimal_Descricao.setAlignmentY(Component.TOP_ALIGNMENT);
		txta_MeDecimal_Descricao.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JTextPane txtP_MeDecimalWindow_CDIR = new JTextPane();
		txtP_MeDecimalWindow_CDIR.setEditable(false);
		txtP_MeDecimalWindow_CDIR.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_MeDecimalWindow_CDIR.setBackground(SystemColor.info);
		txtP_MeDecimalWindow_CDIR.setBounds(374, 278, 50, 20);
		jP_MeDecimaisWindow_AbsLayout.add(txtP_MeDecimalWindow_CDIR);
		
		JButton btn_MeDecimalWindow_back = new JButton("<< Voltar");
		btn_MeDecimalWindow_back.setMnemonic('V');
		btn_MeDecimalWindow_back.setBounds(10, 278, 90, 25);
		jP_MeDecimaisWindow_AbsLayout.add(btn_MeDecimalWindow_back);
		btn_MeDecimalWindow_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				CardLayout windowIntro = (CardLayout) mainWindow.getLayout();
				windowIntro.show(mainWindow, "window_intro_CardLayout");
			}
		});
		
		JTextPane txtP_MeDecimalWindow_MeDecimal = new JTextPane();
		txtP_MeDecimalWindow_MeDecimal.setEditable(false);
		txtP_MeDecimalWindow_MeDecimal.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_MeDecimalWindow_MeDecimal.setBackground(SystemColor.info);
		txtP_MeDecimalWindow_MeDecimal.setBounds(374, 216, 100, 20);
		jP_MeDecimaisWindow_AbsLayout.add(txtP_MeDecimalWindow_MeDecimal);
		
		JTextPane txtP_MeDecimalWindow_MeBinario = new JTextPane();
		txtP_MeDecimalWindow_MeBinario.setEditable(false);
		txtP_MeDecimalWindow_MeBinario.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_MeDecimalWindow_MeBinario.setBackground(SystemColor.info);
		txtP_MeDecimalWindow_MeBinario.setBounds(374, 247, 240, 20);
		jP_MeDecimaisWindow_AbsLayout.add(txtP_MeDecimalWindow_MeBinario);
		
		JTextPane txtP_MeDecimalWindow_hosts_p = new JTextPane();
		txtP_MeDecimalWindow_hosts_p.setEditable(false);
		txtP_MeDecimalWindow_hosts_p.setBorder(UIManager.getBorder("TextPane.border"));
		txtP_MeDecimalWindow_hosts_p.setBackground(SystemColor.info);
		txtP_MeDecimalWindow_hosts_p.setBounds(374, 185, 100, 20);
		jP_MeDecimaisWindow_AbsLayout.add(txtP_MeDecimalWindow_hosts_p);
		
		JLabel lbl_MeDecimalWindow_hosts_p = new JLabel("M\u00E1ximo de HOSTS poss\u00EDveis:");
		lbl_MeDecimalWindow_hosts_p.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimalWindow_hosts_p.setBounds(237, 191, 137, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimalWindow_hosts_p);
		
		JLabel lbl_MeDecimalWindow_MeBinario = new JLabel("M\u00E1scara em Bin\u00E1rio:");
		lbl_MeDecimalWindow_MeBinario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimalWindow_MeBinario.setBounds(278, 253, 96, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimalWindow_MeBinario);
		
		JLabel lbl_MeDecimalWindow_MeDecimal = new JLabel("M\u00E1scara em Decimal:");
		lbl_MeDecimalWindow_MeDecimal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimalWindow_MeDecimal.setBounds(274, 222, 100, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimalWindow_MeDecimal);
		
		JLabel lbl_MeDecimalWindow_CDIR = new JLabel("Barramento CDIR: / ");
		lbl_MeDecimalWindow_CDIR.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimalWindow_CDIR.setBounds(276, 284, 98, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimalWindow_CDIR);
		
		//Botão Limpar da tela "jP_MeDecimaisWindow_AbsLayout":
		JButton btn_MeDecimalWindow_clearFields = new JButton("Limpar");
		btn_MeDecimalWindow_clearFields.setMnemonic('L');
		btn_MeDecimalWindow_clearFields.setBounds(110, 160, 90, 25);
		jP_MeDecimaisWindow_AbsLayout.add(btn_MeDecimalWindow_clearFields);
		btn_MeDecimalWindow_clearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent clickApagar) {
				textField_MeDecimalWindow_MeDecimaisG1.setText(null);
				textField_MeDecimalWindow_MeDecimaisG2.setText(null);
				textField_MeDecimalWindow_MeDecimaisG3.setText(null);
				textField_MeDecimalWindow_MeDecimaisG4.setText(null);
				txtP_MeDecimalWindow_hosts_p.setText(null);
				txtP_MeDecimalWindow_CDIR.setText(null);
				txtP_MeDecimalWindow_MeBinario.setText(null);
				txtP_MeDecimalWindow_MeDecimal.setText(null);
			}
		});
		
		JButton btn_MeDecimalWindow_calc = new JButton("Calcular");
		btn_MeDecimalWindow_calc.setMnemonic('C');
		btn_MeDecimalWindow_calc.setAlignmentY(0.0f);
		btn_MeDecimalWindow_calc.setBounds(10, 160, 90, 25);
		jP_MeDecimaisWindow_AbsLayout.add(btn_MeDecimalWindow_calc);
		btn_MeDecimalWindow_calc.addActionListener(new ActionListener() {
			
			//@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent click) {
				
				byte grupo; // cria a variável "grupo", para determinar qual dos grupos decimais está sendo tradado no método "calcular.setnZd(grupo,G_MR)".
				short G_MR[] = new short[4]; //cria o vetor G_MR[] com escopo Local à Ação de click do botão "btn_MeDecimal_calc":
				
				try {
					//realiza a atribuição dos valores das respectivas posições do vetor G_MR[]:
					G_MR[0] = Short.parseShort(textField_MeDecimalWindow_MeDecimaisG1.getText()); // pode retornar uma NumberFormatException (nfe).
					G_MR[1] = Short.parseShort(textField_MeDecimalWindow_MeDecimaisG2.getText()); // pode retornar uma nfe.
					G_MR[2] = Short.parseShort(textField_MeDecimalWindow_MeDecimaisG3.getText()); // pode retornar uma nfe.
					G_MR[3] = Short.parseShort(textField_MeDecimalWindow_MeDecimaisG4.getText()); // pode retornar uma nfe.
					
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(txtP_MeDecimalWindow_hosts_p, "Máscara inválida!\n\nInforme apenas números.", "Aviso:",0);
					textField_MeDecimalWindow_MeDecimaisG1.setText(null);					
				}
				//verifica se os valores informados são válidos para os campos:
				//textField_MeDecimalWindow_MeDecimaisG1
				if(G_MR[0] == 255 || G_MR[0] == 252 || G_MR[0] == 254 || G_MR[0] == 248 || G_MR[0] == 240 || G_MR[0] == 224 || G_MR[0] == 192 || G_MR[0] == 128 || G_MR[0] == 0){
					//textField_MeDecimalWindow_MeDecimaisG2
					if (G_MR[1] == 255 || G_MR[1] == 252 ||  G_MR[1] == 254 || G_MR[1] == 248 || G_MR[1] == 240 || G_MR[1] == 224 || G_MR[1] == 192 || G_MR[1] == 128 || G_MR[1] == 0){
						//textField_MeDecimalWindow_MeDecimaisG3
						if (G_MR[2] == 255 || G_MR[2] == 252 || G_MR[2] == 254 || G_MR[2] == 248 || G_MR[2] == 240 || G_MR[2] == 224 || G_MR[2] == 192 || G_MR[2] == 128 || G_MR[2] == 0){
							//textField_MeDecimalWindow_MeDecimaisG4
							if (G_MR[3] == 255 || G_MR[3] == 252 || G_MR[3] == 254 || G_MR[3] == 248 || G_MR[3] == 240 || G_MR[3] == 224 || G_MR[3] == 192 || G_MR[3] == 128 || G_MR[3] == 0){
								//verifica se os valores válidados estão em uma ordem válida:
								if(!(G_MR[0] < G_MR[1] || G_MR[0] < G_MR[2] || G_MR[0] < G_MR[3] || G_MR[1] < G_MR[2] || G_MR[1] < G_MR[3] || G_MR[2] < G_MR[3])){
									// realiza a atribuição dos nZd (número de Zeros decimais) para o Objeto calcular:
									if (G_MR[0] == 255 && G_MR[1] == 255 && G_MR[2] == 255){
										grupo = 4;
										calcular.setnZd(grupo, G_MR[3]); // determina o nZd, através do método "calcular.setnZd(grupo,G_MR)".
									} else if (G_MR[0] == 255 && G_MR[1] == 255 && G_MR[3] == 0){
										grupo = 3;
										calcular.setnZd(grupo, G_MR[2]); // determina o nZd.
									} else if (G_MR[0] == 255 && G_MR[2] == 0 && G_MR[3] == 0){
										grupo = 2;
										calcular.setnZd(grupo, G_MR[1]); // determina o nZd.
									} else if (G_MR[1] == 0 && G_MR[2] == 0 && G_MR[3] == 0) {
										grupo = 1;
										calcular.setnZd(grupo, G_MR[0]); // determina o nZd.	
									}
									
									long hosts_p = calcular.setHostsPossibles(0, "Direto"); // determina o hosts_p, pelo método "calcular.SetHostsPossibles(hosts_n, tipoCalc)".
									
									//INICIO das atribuições de valores para os campos:
									if(G_MR[3] == 254){ //Se o Grupo 4 for igual a 254:
										JOptionPane.showMessageDialog(btn_CDIRWindow_calc, "A Máscara de Sub-rede \"255.255.255.254\" é inutilizável.", "Aviso:", 0);
										G_MR[0] = 0;
										textField_MeDecimalWindow_MeDecimaisG1.setText(null);
									} else if (G_MR[3] == 255){ //Se não, se o Grupo 4 for igual a 255:
										JOptionPane.showMessageDialog(btn_CDIRWindow_calc, "A Máscara de Sub-rede \"255.255.255.255\" é útil apenas para um único HOST.", "Aviso:", 1);
										txtP_MeDecimalWindow_hosts_p.setText("1");
										txtP_MeDecimalWindow_MeDecimal.setText("255.255.255.255");
										txtP_MeDecimalWindow_MeBinario.setText("11111111.11111111.11111111.11111111");
										txtP_MeDecimalWindow_CDIR.setText("32");
									} else { //Se não:
										txtP_MeDecimalWindow_hosts_p.setText(Long.valueOf(hosts_p).toString());
										txtP_MeDecimalWindow_MeDecimal.setText(calcular.setMaskDecimal());
										txtP_MeDecimalWindow_MeBinario.setText(calcular.setMaskBinary());
										txtP_MeDecimalWindow_CDIR.setText(Byte.valueOf(calcular.setCDIR()).toString());
									}
									
									if (G_MR[0] == 0){ //caso o primeiro grupo da Máscara informada esteja em Branco, limpa os demais campos:
										textField_MeDecimalWindow_MeDecimaisG2.setText(null);
										textField_MeDecimalWindow_MeDecimaisG3.setText(null);
										textField_MeDecimalWindow_MeDecimaisG4.setText(null);
										txtP_MeDecimalWindow_hosts_p.setText(null);
										txtP_MeDecimalWindow_MeDecimal.setText(null);
										txtP_MeDecimalWindow_MeBinario.setText(null);
										txtP_MeDecimalWindow_CDIR.setText(null);	
									} //FIM das atribuições de valores para os campos.
									
									} else { //caso FALSO para a verificação de uma ordem válida.
									JOptionPane.showMessageDialog(txtP_MeDecimalWindow_MeDecimal, "Os valores informados são válidos, mas NÃO correspondem a uma Máscara de Sub-rede VÁLIDA!\n\nPor favor, informe uma Máscara de Sub-rede válida.\n\n", "Aviso:", JOptionPane.INFORMATION_MESSAGE, null);
									}
							} else { //caso FALSO textField_MeDecimais_group4
								JOptionPane.showMessageDialog(textField_MeDecimalWindow_MeDecimaisG4, "A Máscara informada é INVÁLIDA!\n\nInforme uma máscara válida contendo os valores:\n255, 252, 254, 248, 240, 224, 192, 128 ou 0.\n\n", "Aviso:", JOptionPane.INFORMATION_MESSAGE, null);						
							}
						} else { //caso FALSO textField_MeDecimais_group3
							JOptionPane.showMessageDialog(textField_MeDecimalWindow_MeDecimaisG3, "A Máscara informada é INVÁLIDA!\n\nInforme uma máscara válida contendo os valores:\n255, 252, 254, 248, 240, 224, 192, 128 ou 0.\n\n", "Aviso:", JOptionPane.INFORMATION_MESSAGE, null);						
						}
					} else { //caso FALSO textField_MeDecimais_group2
						JOptionPane.showMessageDialog(textField_MeDecimalWindow_MeDecimaisG2, "A Máscara informada é INVÁLIDA!\n\nInforme uma máscara válida contendo os valores:\n255, 252, 254, 248, 240, 224, 192, 128 ou 0.\n\n", "Aviso:", JOptionPane.INFORMATION_MESSAGE, null);						
					}
				} else { //caso FALSO textField_MeDecimais_group1
					JOptionPane.showMessageDialog(textField_MeDecimalWindow_MeDecimaisG1, "A Máscara informada é INVÁLIDA!\n\nInforme uma máscara válida contendo os valores:\n255, 252, 254, 248, 240, 224, 192, 128 ou 0.\n\n", "Aviso:", JOptionPane.INFORMATION_MESSAGE, null);
				}
			}
		});
		
		JLabel lbl_MeDecimalWindow_MeDecimal_Info = new JLabel("Informe uma M\u00E1scara de Sub-Rede:");
		lbl_MeDecimalWindow_MeDecimal_Info.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimalWindow_MeDecimal_Info.setBounds(10, 135, 173, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimalWindow_MeDecimal_Info);
		
		textField_MeDecimalWindow_MeDecimaisG1 = new JTextField();
		textField_MeDecimalWindow_MeDecimaisG1.setToolTipText("Valores aceitos: 255, 254, 252, 248, 240, 224, 192, 128 ou 0.");
		textField_MeDecimalWindow_MeDecimaisG1.setBackground(Color.WHITE);
		textField_MeDecimalWindow_MeDecimaisG1.setAutoscrolls(false);
		textField_MeDecimalWindow_MeDecimaisG1.setAlignmentY(0.0f);
		textField_MeDecimalWindow_MeDecimaisG1.setAlignmentX(0.0f);
		textField_MeDecimalWindow_MeDecimaisG1.setBounds(190, 129, 40, 20);
		jP_MeDecimaisWindow_AbsLayout.add(textField_MeDecimalWindow_MeDecimaisG1);
		
		textField_MeDecimalWindow_MeDecimaisG2 = new JTextField();
		textField_MeDecimalWindow_MeDecimaisG2.setToolTipText("Valores aceitos: 255, 254, 252, 248, 240, 224, 192, 128 ou 0.");
		textField_MeDecimalWindow_MeDecimaisG2.setBackground(Color.WHITE);
		textField_MeDecimalWindow_MeDecimaisG2.setAutoscrolls(false);
		textField_MeDecimalWindow_MeDecimaisG2.setAlignmentY(0.0f);
		textField_MeDecimalWindow_MeDecimaisG2.setAlignmentX(0.0f);
		textField_MeDecimalWindow_MeDecimaisG2.setBounds(240, 129, 40, 20);
		jP_MeDecimaisWindow_AbsLayout.add(textField_MeDecimalWindow_MeDecimaisG2);
		
		textField_MeDecimalWindow_MeDecimaisG3 = new JTextField();
		textField_MeDecimalWindow_MeDecimaisG3.setToolTipText("Valores aceitos: 255, 254, 252, 248, 240, 224, 192, 128 ou 0.");
		textField_MeDecimalWindow_MeDecimaisG3.setBackground(Color.WHITE);
		textField_MeDecimalWindow_MeDecimaisG3.setAutoscrolls(false);
		textField_MeDecimalWindow_MeDecimaisG3.setAlignmentY(0.0f);
		textField_MeDecimalWindow_MeDecimaisG3.setAlignmentX(0.0f);
		textField_MeDecimalWindow_MeDecimaisG3.setBounds(290, 129, 40, 20);
		jP_MeDecimaisWindow_AbsLayout.add(textField_MeDecimalWindow_MeDecimaisG3);
		
		textField_MeDecimalWindow_MeDecimaisG4 = new JTextField();
		textField_MeDecimalWindow_MeDecimaisG4.setToolTipText("Valores aceitos: 255, 254, 252, 248, 240, 224, 192, 128 ou 0.");
		textField_MeDecimalWindow_MeDecimaisG4.setBackground(Color.WHITE);
		textField_MeDecimalWindow_MeDecimaisG4.setAutoscrolls(false);
		textField_MeDecimalWindow_MeDecimaisG4.setAlignmentY(0.0f);
		textField_MeDecimalWindow_MeDecimaisG4.setAlignmentX(0.0f);
		textField_MeDecimalWindow_MeDecimaisG4.setBounds(340, 129, 40, 20);
		jP_MeDecimaisWindow_AbsLayout.add(textField_MeDecimalWindow_MeDecimaisG4);
		
		JLabel lbl_MeDecimaisWindow_dot3 = new JLabel(".");
		lbl_MeDecimaisWindow_dot3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimaisWindow_dot3.setBounds(334, 135, 4, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimaisWindow_dot3);
		
		JLabel lbl_MeDecimaisWindow_dot2 = new JLabel(".");
		lbl_MeDecimaisWindow_dot2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimaisWindow_dot2.setBounds(284, 135, 4, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimaisWindow_dot2);
		
		JLabel lbl_MeDecimaisWindow_dot1 = new JLabel(".");
		lbl_MeDecimaisWindow_dot1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimaisWindow_dot1.setBounds(233, 135, 4, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimaisWindow_dot1);
		
		JLabel lbl_MeDecimaisWindow_FREEWARE = new JLabel("FREEWARE");
		lbl_MeDecimaisWindow_FREEWARE.setForeground(new Color(0, 128, 0));
		lbl_MeDecimaisWindow_FREEWARE.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_MeDecimaisWindow_FREEWARE.setBounds(548, 294, 66, 15);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimaisWindow_FREEWARE);
		
		JLabel lbl_MeDecimaisWindow_Distribuicao = new JLabel("Distribui\u00E7\u00E3o:");
		lbl_MeDecimaisWindow_Distribuicao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimaisWindow_Distribuicao.setBounds(479, 295, 59, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimaisWindow_Distribuicao);
		
		JPanel jP_About_CL = new JPanel();
		jP_About_CL.setForeground(SystemColor.menu);
		jP_About_CL.setBorder(null);
		jP_About_CL.setBackground(SystemColor.menu);
		mainWindow.add(jP_About_CL, "window_About_CardLayout");
		jP_About_CL.setLayout(new CardLayout(0, 0));
		
		JPanel jP_About_AbsLayout = new JPanel();
		jP_About_AbsLayout.setLayout(null);
		jP_About_CL.add(jP_About_AbsLayout, "window_About_AbsolutLayout");
		
		//Botão "Voltar" da Janela "Sobre":
		JButton btn_AboutWindow_Back = new JButton("<< Voltar");
		btn_AboutWindow_Back.setMnemonic('V');
		btn_AboutWindow_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				CardLayout windowIntro = (CardLayout) mainWindow.getLayout();
				windowIntro.show(mainWindow, "window_intro_CardLayout");
			}
		});
		btn_AboutWindow_Back.setBounds(266, 215, 90, 25);
		jP_About_AbsLayout.add(btn_AboutWindow_Back);
		
		JLabel lbl_AboutWindow_Titulo = new JLabel("Sobre:");
		lbl_AboutWindow_Titulo.setAlignmentY(Component.TOP_ALIGNMENT);
		lbl_AboutWindow_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_AboutWindow_Titulo.setBounds(290, 0, 46, 17);
		jP_About_AbsLayout.add(lbl_AboutWindow_Titulo);
		
		JScrollPane scrollPane_AboutWindow_Descricao = new JScrollPane();
		scrollPane_AboutWindow_Descricao.setBounds(10, 28, 614, 176);
		jP_About_AbsLayout.add(scrollPane_AboutWindow_Descricao);
	
		JTextArea txta_About_Descricao = new JTextArea();
		txta_About_Descricao.setEditable(false);
		txta_About_Descricao.setAutoscrolls(false);
		scrollPane_AboutWindow_Descricao.setViewportView(txta_About_Descricao);
		txta_About_Descricao.setText("-------------------------------------------------------------------------\r\nOl\u00E1 Usu\u00E1rio(a)!\r\n\r\nTudo bem!?\r\n\r\nMe chamo Marcone Mendon\u00E7a e desenvolvi este aplicativo com os intuitos de come\u00E7ar a programar na\r\nlinguagem  Java\r (desculpem-me pelos possiveis bugs! rs...)\r, e reduzir o tempo dos c\u00E1lculos para\r\ndetermina\u00E7\u00E3o de M\u00E1scaras de Redes e Sub-redes para praticamente zero.\r\n\r\nEspero que  esta aplica\u00E7\u00E3o possa lhe ser \u00FAtil.\r\n\r\nCaso deseje entrar em contato, por qualquer motivo, seguem os meios:\r\n\r\nE-mail: marconemendonca@gmail.com;\r\nFacebook: https:/facebook.com/marconemm; ou\r\nGitHub: https://github.com/marconemm\r\n\r\nNo mais, um grade abra\u00E7o e at\u00E9 breve!\r\n\r\nAtenciosamente,\r\n\r\nMarcone M. Mendon\u00E7a\r\n\r\n-------------------------------------------------------------------------\r\nEste software pode ser distribuido GRATUITAMENTE.");
		txta_About_Descricao.setTabSize(2);
		txta_About_Descricao.setRows(6);
		txta_About_Descricao.setLineWrap(true);
		txta_About_Descricao.select(Byte.MIN_VALUE, 1); //determina que a ScrollBar inicie posicionada na parte superior da barra.
		txta_About_Descricao.setForeground(SystemColor.windowText);
		txta_About_Descricao.setBackground(SystemColor.window);
		
		//botão de acesso rápido ao Facebook:
		JButton btn_AboutWindow_Facebook = new JButton("");
		btn_AboutWindow_Facebook.setIcon(new ImageIcon(MainWindow.class.getResource("/marconemendonca/mascarasderedes/facebook-logo.png")));
		btn_AboutWindow_Facebook.setBounds(10, 274, 35, 35);
		jP_About_AbsLayout.add(btn_AboutWindow_Facebook);
		btn_AboutWindow_Facebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				try {
					byte numConfirmacao = (byte)(JOptionPane.showConfirmDialog(btn_AboutWindow_Facebook, "Esta aplicação está tentando abrir o site:\nhttps://www.facebook.com/marconemm\n\nPressione \"OK\" para continuar.\n", "Aviso:", JOptionPane.OK_CANCEL_OPTION, 1));					
					if( numConfirmacao == 0){
						Desktop teste = Desktop.getDesktop();
						teste.browse(new URI("https://www.facebook.com/marconemm"));		
					}
				} catch (Exception error) {
					System.out.println(error);
				}	
			}
		});
		
		//botão de acesso rápido ao GitHub:
		JButton btn_AboutWindow_GitHub = new JButton("");
		btn_AboutWindow_GitHub.setIcon(new ImageIcon(MainWindow.class.getResource("/marconemendonca/mascarasderedes/logo-developer-github.png")));
		btn_AboutWindow_GitHub.setBounds(55, 281, 84, 28);
		jP_About_AbsLayout.add(btn_AboutWindow_GitHub);
		btn_AboutWindow_GitHub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				try {
					byte numConfirmacao = (byte)(JOptionPane.showConfirmDialog(btn_AboutWindow_GitHub, "Esta aplicação está tentando abrir o site:\nhttps://github.com/marconemm\n\nPressione \"OK\" para continuar.\n", "Aviso:", JOptionPane.OK_CANCEL_OPTION, 1));					
					if( numConfirmacao == 0){
						Desktop teste = Desktop.getDesktop();
						teste.browse(new URI("https://github.com/marconemm"));	
					}
					} catch (Exception error) {
						System.out.println(error);
					}
			}
		});
		
		JLabel lbl_AboutWindow_AcessoRpido = new JLabel("Acesso r\u00E1pido:");
		lbl_AboutWindow_AcessoRpido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_AboutWindow_AcessoRpido.setBounds(10, 249, 71, 14);
		jP_About_AbsLayout.add(lbl_AboutWindow_AcessoRpido);
		
		JLabel lbl_AboutWindow_FREEWARE = new JLabel("FREEWARE");
		lbl_AboutWindow_FREEWARE.setForeground(new Color(0, 128, 0));
		lbl_AboutWindow_FREEWARE.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_AboutWindow_FREEWARE.setBounds(558, 294, 66, 15);
		jP_About_AbsLayout.add(lbl_AboutWindow_FREEWARE);
		
		JLabel lbl_AboutWindow_Distribuicao = new JLabel("Distribui\u00E7\u00E3o:");
		lbl_AboutWindow_Distribuicao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_AboutWindow_Distribuicao.setBounds(489, 295, 59, 14);
		jP_About_AbsLayout.add(lbl_AboutWindow_Distribuicao);
	}
}
