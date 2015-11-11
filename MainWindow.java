package marconemendonca.mascarasderedes;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;


public class MainWindow extends JFrame {

	//serialVersionUID "standard = 1L"
	
	private static final long serialVersionUID = 1L;
	private JPanel mainWindow;
	private final ButtonGroup buttonGroup_Intro = new ButtonGroup();
	private JTextField textField_nHosts;
	private JTextField textField_CDIR;
	private JTextField textField_MeDecimais_group1;
	private JTextField textField_MeDecimais_group2;
	private JTextField textField_MeDecimais_group3;
	private JTextField textField_MeDecimais_group4;

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
		setTitle("M\u00E1scaras de Redes");
		setFont(UIManager.getFont("EditorPane.font"));
		setForeground(SystemColor.window);
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 380);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Arquivo");
		
		mnFile.setForeground(SystemColor.windowText);
		mnFile.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(mnFile);
		
		
		JMenuItem mnItNewCalc = new JMenuItem("Novo C\u00E1lculo");
		mnItNewCalc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnItNewCalc.setIcon(null);
		mnItNewCalc.setFont(UIManager.getFont("Button.font"));
		mnItNewCalc.setForeground(SystemColor.windowText);
		mnFile.add(mnItNewCalc);
		mnItNewCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				CardLayout windowIntro = (CardLayout) mainWindow.getLayout();
				windowIntro.show(mainWindow, "window_intro_CardLayout");
			}
		});
		
		
		JMenuItem mnItExit = new JMenuItem("Sair");
		mnItExit.setIcon(null);
		mnItExit.setForeground(SystemColor.windowText);
		mnItExit.setFont(UIManager.getFont("Button.font"));
		mnFile.add(mnItExit);
		mnItExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exitAction) {
				if (exitAction.getSource() == mnItExit)
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
		
		JLabel label = new JLabel("Qual par\u00E2metro deseja utilizar?");
		label.setBounds(21, 130, 185, 14);
		jP_intro_AbsLayout.add(label);
		
		JRadioButton jRadiobutton_Hosts = new JRadioButton("N\u00FAmero de HOSTS");
		buttonGroup_Intro.add(jRadiobutton_Hosts);
		jRadiobutton_Hosts.setToolTipText("Neste par\u00E2metro deve ser informado o n\u00FAmero de HOSTS (clientes) que poder\u00E3o utilizar a Rede.");
		jRadiobutton_Hosts.setSelected(true);
		jRadiobutton_Hosts.setBounds(21, 155, 150, 23);
		jP_intro_AbsLayout.add(jRadiobutton_Hosts);
		
		
		JRadioButton jRadiobutton_CDIR = new JRadioButton("Barramento CDIR");
		buttonGroup_Intro.add(jRadiobutton_CDIR);
		jRadiobutton_CDIR.setToolTipText("Neste par\u00E2metro deve ser informado o Barramento CDIR (2 < CDIR < 32).");
		jRadiobutton_CDIR.setBounds(21, 185, 150, 23);
		jP_intro_AbsLayout.add(jRadiobutton_CDIR);
		
		JRadioButton radioButton_3 = new JRadioButton("M\u00E1scara de Sub-rede em DECIMAIS");
		radioButton_3.setEnabled(false);
		buttonGroup_Intro.add(radioButton_3);
		radioButton_3.setToolTipText("Neste par\u00E2metro deve ser informada uma M\u00E1scara de Sub-rede em DECIMAIS.");
		radioButton_3.setBounds(21, 215, 230, 23);
		jP_intro_AbsLayout.add(radioButton_3);
		
		
		JButton button = new JButton("Pr\u00F3ximo >>");
		button.setBounds(21, 245, 100, 23);
		jP_intro_AbsLayout.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jRadiobutton_Hosts.isSelected()){
					CardLayout windowHOSTS = (CardLayout) mainWindow.getLayout();
					windowHOSTS.show(mainWindow, "windowHOSTS_CardLayout");
				} else if(jRadiobutton_CDIR.isSelected()){
					CardLayout windowCDIR = (CardLayout) mainWindow.getLayout();
					windowCDIR.show(mainWindow, "jP_CDIRWindow_CardLayout");
				}
			}
		});
		
		JTextArea txtrEstaAplicaoDestinase = new JTextArea();
		txtrEstaAplicaoDestinase.setFocusable(false);
		txtrEstaAplicaoDestinase.setEditable(false);
		txtrEstaAplicaoDestinase.setLineWrap(true);
		txtrEstaAplicaoDestinase.setTabSize(2);
		txtrEstaAplicaoDestinase.setRows(6);
		txtrEstaAplicaoDestinase.setForeground(SystemColor.windowText);
		txtrEstaAplicaoDestinase.setBackground(SystemColor.menu);
		txtrEstaAplicaoDestinase.setText("Esta aplica\u00E7\u00E3o destina-se \u00E0s determina\u00E7\u00F5es de M\u00E1scaras de Sub-rede.\r\n\r\nPodendo essas erem determinadas por 4 par\u00E2metros: N\u00FAmero de HOSTS, Barramento CDIR,  M\u00E1scara de Sub-rede em n\u00FAmeros Bin\u00E1rios e Sub-rede em n\u00FAmeros Decimais.\r\n\r\nConforme as op\u00E7\u00F5es abaixo, basta escolher qual o par\u00E2metro de c\u00E1lculo deseja utilizar.");
		txtrEstaAplicaoDestinase.setBounds(10, 11, 614, 112);
		jP_intro_AbsLayout.add(txtrEstaAplicaoDestinase);
		
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
		
		JButton btn_HOSTS_calc = new JButton("Calcular");
		btn_HOSTS_calc.setAlignmentY(Component.TOP_ALIGNMENT);
		btn_HOSTS_calc.setBounds(206, 101, 90, 25);
		jP_HostsWindow_AbsLayout.add(btn_HOSTS_calc);
		
		Calculos hosts = new Calculos(); //cria o Objeto "hosts" com a SuperClasse "Calculos".
		
		//determina a ação para o botão "Calcular" da Janela de HOSTS:
				btn_HOSTS_calc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent calcHosts) {
						String temp_txt = textField_nHosts.getText();
						
						/*A próxima instrução, cria um "tratamento de exeção" para os possíveis erros de entrada
						 * de dados pelo usuário.*/
						try {											
							long temp_nHosts = Long.parseLong(temp_txt); // pode retornar uma "NumberFormatException".
							
							while ((temp_nHosts < 0) || (temp_nHosts > 4294967294L)) {
								temp_txt = JOptionPane.showInputDialog(null, "Valor inválido!\n\nInforme um valor entre: 1 e 4.294.967.294:", "Aviso:", 2);
								temp_nHosts = Long.parseLong(temp_txt); // pode retornar uma "NumberFormatException".
								textField_nHosts.setText(temp_txt);
							};
						} catch (NumberFormatException nfe){
							JOptionPane.showMessageDialog(null, "O valor informado não é um número INTEIRO!", "Aviso:", 0);
							textField_nHosts.setText("0");							
						}
						
						/* A próxima instrução, cria o long hosts_p, atribui a ele o valor o retorno do Método SetHostsPossible da Classe Hosts,
						 * que por sua vez recebe os parâmetros long do "textField_nHosts", byte "0" e controller "true". */
						long hosts_p = hosts.SetHostsPossibles(Long.parseLong(textField_nHosts.getText()), (byte)0);
						byte cdir = hosts.setCDIR(); // recebe o resultado do método setCDIR da Calsse Hosts.
						
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
							txtP_HostsWindow_MeBinario.setText(hosts.setMaskBinary());
							txtP_HostsWindow_MeDecimal.setText(hosts.setMaskDecimal());
							txtP_HostsWindow_CDIR.setText(Byte.valueOf(cdir).toString());
						}
					}
				});
				
		JButton btn_HOSTS_ClearFields = new JButton("Limpar");
		btn_HOSTS_calc.setAlignmentY(Component.TOP_ALIGNMENT);
		btn_HOSTS_ClearFields.setBounds(306, 101, 90, 25);
		jP_HostsWindow_AbsLayout.add(btn_HOSTS_ClearFields);
		btn_HOSTS_ClearFields.addActionListener(new ActionListener() {
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
		
		
		
		JButton btn_HOSTS_Back = new JButton("<< Voltar");
		btn_HOSTS_calc.setAlignmentY(Component.TOP_ALIGNMENT);
		btn_HOSTS_Back.setBounds(206, 274, 90, 25);
		jP_HostsWindow_AbsLayout.add(btn_HOSTS_Back);
		
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
		
		JLabel lblInformeONmero = new JLabel("Informe o n\u00FAmero de HOSTS desejado:");
		lblInformeONmero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInformeONmero.setBounds(10, 73, 188, 14);
		jP_HostsWindow_AbsLayout.add(lblInformeONmero);
		btn_HOSTS_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout windowIntro = (CardLayout) mainWindow.getLayout();
				windowIntro.show(mainWindow, "window_intro_CardLayout");
			}
		});
		
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
		
		textField_CDIR = new JTextField();
		textField_CDIR.setToolTipText("Valores aceitos: 1 a 32.");
		textField_CDIR.setBackground(Color.WHITE);
		textField_CDIR.setAutoscrolls(false);
		textField_CDIR.setAlignmentY(0.0f);
		textField_CDIR.setAlignmentX(0.0f);
		textField_CDIR.setBounds(160, 69, 40, 20);
		jP_cdirWindow_AbsLayout.add(textField_CDIR);
		
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
		
		Calculos pCDIR = new Calculos(); // Cria o Objeto pDIR (Parâmetro CDIR).
		
		JButton btn_CDIR_calc = new JButton("Calcular");
		btn_CDIR_calc.setAlignmentY(0.0f);
		btn_CDIR_calc.setBounds(10, 100, 90, 25);
		jP_cdirWindow_AbsLayout.add(btn_CDIR_calc);
		btn_CDIR_calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*A próxima instrução, cria um "tratamento de exeção" para os possíveis erros de entrada
				 * de dados pelo usuário.*/
				try {									
					String temp_txt;
					byte  temp_CDIR = Byte.parseByte(textField_CDIR.getText()); // pode retornar uma "NumberFormatException".
					
					while ((temp_CDIR < 0) || (temp_CDIR > 32)) {
						JOptionPane.showMessageDialog(null, "O valor informado não é válido!\n\nPor favor, tente novamente com um valor entre 0 e 32.", "Aviso:", 2);
						temp_txt = "0";
						temp_CDIR = Byte.parseByte(temp_txt);
						textField_CDIR.setText(temp_txt);
					};
					if (temp_CDIR == 31) {
						JOptionPane.showMessageDialog(null, "O Barramento \"CDIR /31\" é inutilizável.", "Aviso:", 0);
						temp_txt = "0";
						temp_CDIR = Byte.parseByte(temp_txt);
						textField_CDIR.setText(temp_txt);
					}
					if (temp_CDIR == 32) {
						JOptionPane.showMessageDialog(null, "O Barramento \"CDIR /32\" é útil apenas para um único HOST.", "Aviso:", 1);
						temp_txt = "32";
						temp_CDIR = Byte.parseByte(temp_txt);
						textField_CDIR.setText(temp_txt);
					}
				} catch (NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "O valor informado não é válido!\n\nPor favor, tente novamente com um valor entre 0 e 32.", "Aviso:", 0);
					textField_CDIR.setText("0");							
				}
				
				
				/* A próxima instrução, executa o Método getCDIR do Objeto pCDIR.
				 * passand como parâmetro o valor informado pelo usuário no campo "textField_CDIR"*/
				pCDIR.getCDIR(Byte.valueOf(textField_CDIR.getText()));
				/* A próxima instrução, cria o Long hosts_p, atribui a ele o valor o retorno do Método SetHostsPossible da Classe Hosts,
				 * que por sua vez recebe os parâmetros long 0, byte 0 e controller false */
				long hosts_p = pCDIR.SetHostsPossibles(Long.valueOf(textField_CDIR.getText()),(byte)1);								
				
				// A próxima instução atribue valores aos respectivos campos abaixo:
				
				if (Byte.parseByte(textField_CDIR.getText()) == 0){
					txtP_CDIRWindow_CDIR.setText(textField_CDIR.getText());
					txtP_CDIRWindow_Hosts_p.setText("4294967294");
					txtP_CDIRWindow_MeBinario.setText(pCDIR.setMaskBinary());
					txtP_CDIRWindow_MeDecimal.setText(pCDIR.setMaskDecimal());
					} else if (Byte.parseByte(textField_CDIR.getText()) == 32){
						txtP_CDIRWindow_CDIR.setText(textField_CDIR.getText());	
						txtP_CDIRWindow_Hosts_p.setText("1");
						txtP_CDIRWindow_MeBinario.setText("11111111.11111111.11111111.11111111");
						txtP_CDIRWindow_MeDecimal.setText("255.255.255.255");
						} else {
							txtP_CDIRWindow_CDIR.setText(textField_CDIR.getText());	
							txtP_CDIRWindow_Hosts_p.setText(Long.valueOf(hosts_p).toString());
							txtP_CDIRWindow_MeBinario.setText(pCDIR.setMaskBinary());
							txtP_CDIRWindow_MeDecimal.setText(pCDIR.setMaskDecimal());
						}
			}
		});
		
		JButton btn_CDIR_ClearFields = new JButton("Limpar");
		btn_CDIR_ClearFields.setBounds(110, 100, 90, 25);
		jP_cdirWindow_AbsLayout.add(btn_CDIR_ClearFields);
		btn_CDIR_ClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_CDIR.setText(null);
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
		
		JButton btn_CDIR_back = new JButton("<< Voltar");
		btn_CDIR_back.setBounds(255, 249, 90, 25);
		jP_cdirWindow_AbsLayout.add(btn_CDIR_back);
		btn_CDIR_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout windowIntro = (CardLayout) mainWindow.getLayout();
				windowIntro.show(mainWindow, "window_intro_CardLayout");
			}
		});
		
		JLabel lbl_CDIRWindow_Titulo = new JLabel("Par\u00E2metro: CDIR");
		lbl_CDIRWindow_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_CDIRWindow_Titulo.setBounds(255, 0, 119, 17);
		jP_cdirWindow_AbsLayout.add(lbl_CDIRWindow_Titulo);
		
		JLabel lbl_CDIRWindow_01 = new JLabel("Informe o Barramento CDIR: /");
		lbl_CDIRWindow_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_CDIRWindow_01.setBounds(10, 73, 152, 14);
		jP_cdirWindow_AbsLayout.add(lbl_CDIRWindow_01);
		
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
		txta_CDIRWindow_Descricao.select(Byte.MIN_VALUE, 1);
		scrollPane_CDIRWindow_Descricao.setViewportView(txta_CDIRWindow_Descricao);
		
		JPanel jP_MeDecimaisWindow_CL = new JPanel();
		jP_MeDecimaisWindow_CL.setForeground(SystemColor.menu);
		jP_MeDecimaisWindow_CL.setBorder(null);
		jP_MeDecimaisWindow_CL.setBackground(SystemColor.menu);
		mainWindow.add(jP_MeDecimaisWindow_CL, "name_23826972312891");
		jP_MeDecimaisWindow_CL.setLayout(new CardLayout(0, 0));
		
		JPanel jP_MeDecimaisWindow_AbsLayout = new JPanel();
		jP_MeDecimaisWindow_AbsLayout.setLayout(null);
		jP_MeDecimaisWindow_CL.add(jP_MeDecimaisWindow_AbsLayout, "name_24078009318013");
		
		JLabel lbl_MeDecimal_Titulo = new JLabel("Par\u00E2metro: M\u00E1scara em DECIMAL");
		lbl_MeDecimal_Titulo.setAlignmentY(Component.TOP_ALIGNMENT);
		lbl_MeDecimal_Titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_MeDecimal_Titulo.setBounds(194, 0, 233, 17);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimal_Titulo);
		
		JScrollPane scrollPane_MeDecimal_Descricao = new JScrollPane();
		scrollPane_MeDecimal_Descricao.setBounds(10, 28, 604, 90);
		jP_MeDecimaisWindow_AbsLayout.add(scrollPane_MeDecimal_Descricao);
		
		JTextArea txta_MeDecimal_Descricao = new JTextArea();
		txta_MeDecimal_Descricao.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane_MeDecimal_Descricao.setViewportView(txta_MeDecimal_Descricao);
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
		btn_MeDecimalWindow_back.setBounds(10, 278, 90, 25);
		jP_MeDecimaisWindow_AbsLayout.add(btn_MeDecimalWindow_back);
		
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
		
		JButton btn_MeDecimal_clearFields = new JButton("Limpar");
		btn_MeDecimal_clearFields.setBounds(110, 160, 90, 25);
		jP_MeDecimaisWindow_AbsLayout.add(btn_MeDecimal_clearFields);
		
		JButton btn_MeDecimal_calc = new JButton("Calcular");
		btn_MeDecimal_calc.setAlignmentY(0.0f);
		btn_MeDecimal_calc.setBounds(10, 160, 90, 25);
		jP_MeDecimaisWindow_AbsLayout.add(btn_MeDecimal_calc);
		
		JLabel label_5 = new JLabel("Informe o Barramento CDIR: /");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(10, 133, 152, 14);
		jP_MeDecimaisWindow_AbsLayout.add(label_5);
		
		textField_MeDecimais_group1 = new JTextField();
		textField_MeDecimais_group1.setToolTipText("Valores aceitos: 1 a 32.");
		textField_MeDecimais_group1.setBackground(Color.WHITE);
		textField_MeDecimais_group1.setAutoscrolls(false);
		textField_MeDecimais_group1.setAlignmentY(0.0f);
		textField_MeDecimais_group1.setAlignmentX(0.0f);
		textField_MeDecimais_group1.setBounds(160, 129, 40, 20);
		jP_MeDecimaisWindow_AbsLayout.add(textField_MeDecimais_group1);
		
		textField_MeDecimais_group2 = new JTextField();
		textField_MeDecimais_group2.setToolTipText("Valores aceitos: 1 a 32.");
		textField_MeDecimais_group2.setBackground(Color.WHITE);
		textField_MeDecimais_group2.setAutoscrolls(false);
		textField_MeDecimais_group2.setAlignmentY(0.0f);
		textField_MeDecimais_group2.setAlignmentX(0.0f);
		textField_MeDecimais_group2.setBounds(210, 129, 40, 20);
		jP_MeDecimaisWindow_AbsLayout.add(textField_MeDecimais_group2);
		
		textField_MeDecimais_group3 = new JTextField();
		textField_MeDecimais_group3.setToolTipText("Valores aceitos: 1 a 32.");
		textField_MeDecimais_group3.setBackground(Color.WHITE);
		textField_MeDecimais_group3.setAutoscrolls(false);
		textField_MeDecimais_group3.setAlignmentY(0.0f);
		textField_MeDecimais_group3.setAlignmentX(0.0f);
		textField_MeDecimais_group3.setBounds(260, 129, 40, 20);
		jP_MeDecimaisWindow_AbsLayout.add(textField_MeDecimais_group3);
		
		textField_MeDecimais_group4 = new JTextField();
		textField_MeDecimais_group4.setToolTipText("Valores aceitos: 1 a 32.");
		textField_MeDecimais_group4.setBackground(Color.WHITE);
		textField_MeDecimais_group4.setAutoscrolls(false);
		textField_MeDecimais_group4.setAlignmentY(0.0f);
		textField_MeDecimais_group4.setAlignmentX(0.0f);
		textField_MeDecimais_group4.setBounds(310, 129, 40, 20);
		jP_MeDecimaisWindow_AbsLayout.add(textField_MeDecimais_group4);
		
		JLabel lbl_MeDecimaisWindow_dot3 = new JLabel(".");
		lbl_MeDecimaisWindow_dot3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimaisWindow_dot3.setBounds(304, 135, 4, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimaisWindow_dot3);
		
		JLabel lbl_MeDecimaisWindow_dot2 = new JLabel(".");
		lbl_MeDecimaisWindow_dot2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimaisWindow_dot2.setBounds(254, 135, 4, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimaisWindow_dot2);
		
		JLabel lbl_MeDecimaisWindow_dot1 = new JLabel(".");
		lbl_MeDecimaisWindow_dot1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_MeDecimaisWindow_dot1.setBounds(203, 135, 4, 14);
		jP_MeDecimaisWindow_AbsLayout.add(lbl_MeDecimaisWindow_dot1);
	}
}
