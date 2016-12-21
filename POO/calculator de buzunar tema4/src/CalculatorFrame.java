import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CalculatorFrame extends JFrame{

	private static final long serialVersionUID = -5303129649562898197L;
	private JMenuBar menuBar;
	private JPanel screenCase,buttons;
	JTextArea screen = new JTextArea();	//screen must be accesible for eventListener
	
	ExpressionParser runCalculator;
	private String expresion;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,pct,plus,minus,log,sin,cos,pow,sqrt,backSpace,clear,ce,mul,div,equals,tan,cot,rightp,
					leftp,op;
	
	public CalculatorFrame(){
		
		runCalculator = new ExpressionParser();		//iinstance of the class that executes the numerical calculations
		expresion = new String();
		
		setDefaultCloseOperation(3);
		setTitle("Calculator");
		setSize(300, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		add(new CPanel());
	}
	
	public class CPanel extends JPanel {//main panel

		private static final long serialVersionUID = 1L;

		
		public CPanel() {
		
		//adding key events
		final myKeyAdapter ka= new myKeyAdapter(); 
		screen.addKeyListener(ka);	
			
		//components
		menuBar = new JMenuBar();	
		screenCase = new JPanel(new BorderLayout());	
		buttons = new JPanel(new BorderLayout());
			
		JPanel numbers  = new JPanel(null);
		final JPanel grid1 = new JPanel(new GridBagLayout());
		final JPanel grid2 = new JPanel(new GridBagLayout());
		final JPanel grid3 = new JPanel(new GridBagLayout());
		grid3.setVisible(false);
		
		setLayout(new BorderLayout());
		
		//adding menu
		JMenu options;
		menuBar.add(options = new JMenu("Options"));
		
		JMenuItem standard = new JMenuItem(new AbstractAction() {
			
		private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
					grid3.setVisible(false);	
					grid1.setBorder(new EmptyBorder(0,10,5,20));
					grid2.setBorder(new EmptyBorder(5,10,5,20));
					CalculatorFrame.this.setSize(300, 400);
			}
		});
		
		standard.setText("Standard");
		
		JMenuItem scientific = new JMenuItem(new AbstractAction() {
			
		private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
					grid3.setVisible(true);	
					grid1.setBorder(new EmptyBorder(0,0,5,20));
					grid2.setBorder(new EmptyBorder(5,0,5,20));
					CalculatorFrame.this.setSize(450, 400);
			}
		});
		scientific.setText("Scientific");
		JMenuItem exit = new JMenuItem(new AbstractAction() {
		
		private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setText("Exit");
		options.add(standard);
		options.add(scientific);
		options.addSeparator();
		options.add(exit);
		
		add(menuBar,BorderLayout.NORTH);
		
		//adding screen
		
		JScrollPane scroll = new JScrollPane(screen);
		scroll.setBorder(new EtchedBorder());
		screen.setBorder(new TitledBorder(new EmptyBorder(10,10,10,10)));//
		screen.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		screen.setWrapStyleWord(true);
		screen.setLineWrap(true);
		screen.setEditable(false);
		
		screenCase.add(scroll,BorderLayout.CENTER);
		screenCase.setBorder(new EmptyBorder(5, 10, 5, 10));
		add(screenCase,BorderLayout.CENTER);
		
		//adding buttons panel
		add(buttons,BorderLayout.SOUTH);
		
		grid1.setBorder(new EmptyBorder(0,10,5,20));
		grid2.setBorder(new EmptyBorder(5,10,5,20));
		grid3.setBorder(new EmptyBorder(0, 10, 20, 0));
		
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx=0;
		c.ipady=0;
		c.weightx=200;
		c.insets = new Insets(10, 10, 0, 5);
		
		clear = new JButton("C");
		ce = new JButton("CE");
		
		ActionListener listener = new EventListener(); //ascultator pentru fiecare buton
		
		backSpace = new JButton("R");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		
		pct = new JButton(".");
		plus = new JButton("+");
		minus = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		equals = new JButton("=");
		
		sin = new JButton("sin");
		cos = new JButton("cos");
		log = new JButton("log");
		sqrt = new JButton("sqrt");
		pow = new JButton("pow");
		tan = new JButton("tan");
		cot = new JButton("cot");
		op = new JButton("(-)");
		rightp = new JButton(")");
		leftp = new JButton("(");
				
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);
		b4.addActionListener(listener);
		b5.addActionListener(listener);
		b6.addActionListener(listener);
		b7.addActionListener(listener);
		b8.addActionListener(listener);
		b9.addActionListener(listener);
		b0.addActionListener(listener);
		plus.addActionListener(listener);
		minus.addActionListener(listener);
		mul.addActionListener(listener);
		div.addActionListener(listener);
		log.addActionListener(listener);
		sin.addActionListener(listener);
		cos.addActionListener(listener);
		sqrt.addActionListener(listener);
		pow.addActionListener(listener);
		equals.addActionListener(listener);
		pct.addActionListener(listener);
		tan.addActionListener(listener);
		cot.addActionListener(listener);
		op.addActionListener(listener);
		leftp.addActionListener(listener);
		rightp.addActionListener(listener);
		backSpace.addActionListener(listener);
		ce.addActionListener(listener);
		clear.addActionListener(listener);


		c.gridx=1;
		c.gridy=0;
		grid1.add(backSpace,c);
		
		c.gridx=2;
		c.gridy=0;
		grid1.add(clear,c);
		
		c.gridx=3;
		c.gridy=0;
		grid1.add(ce,c);
		
		c.gridx=4;
		c.gridy=0;
		grid1.add(plus,c);
		
		c.gridx=1;
		c.gridy=1;
		grid1.add(b7,c);
		
		c.gridx=2;
		c.gridy=1;
		grid1.add(b8,c);
		
		c.gridx=3;
		c.gridy=1;
		grid1.add(b9,c);
		
		c.gridx=4;
		c.gridy=1;
		grid1.add(minus,c);
		
		c.gridx=1;
		c.gridy=2;
		grid1.add(b4,c);
		
		c.gridx=2;
		c.gridy=2;
		grid1.add(b5,c);
		
		c.gridx=3;
		c.gridy=2;
		grid1.add(b6,c);
		
		c.gridx=4;
		c.gridy=2;
		grid1.add(mul,c);
		
		c.gridx=1;
		c.gridy=3;
		grid1.add(b1,c);
		
		c.gridx=2;
		c.gridy=3;
		grid1.add(b2,c);
		
		c.gridx=3;
		c.gridy=3;
		grid1.add(b3,c);
		
		c.gridx=4;
		c.gridy=3;
		grid1.add(div,c);
		
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(0,10,15,5);
		c.ipadx=133;
		grid2.add(b0,c);
				
		c.gridx=2;
		c.gridy=0;
		c.ipadx=79;
		grid2.add(pct,c);

		c.gridx=3;
		c.gridy=0;
		c.ipadx=68;
		grid2.add(equals,c);
		
		c.insets=new Insets(0,10,15,5);
		c.insets = new Insets(10, 10, 0, 5);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.ipadx=1;
		
		c.gridy=1;
		c.gridx=1;
		grid3.add(tan,c);
		
		c.gridy=2;
		c.gridx=1;
		grid3.add(cot,c);
		
		c.gridy=3;
		c.gridx=0;
		grid3.add(op,c);
		
		c.gridy=4;
		c.gridx=0;
		grid3.add(leftp,c);
		
		c.gridy=5;
		c.gridx=0;
		grid3.add(rightp,c);
		
		c.gridy=1;
		c.gridx=0;
		grid3.add(sin,c);
		
		c.gridy=2;
		c.gridx=0;
		grid3.add(cos,c);
		
		c.gridy=3;
		c.gridx=1;
		grid3.add(log,c);
		
		c.gridy=4;
		c.gridx=1;
		grid3.add(sqrt,c);
		
		c.gridy=5;
		c.gridx=1;
		grid3.add(pow,c);	
	
		numbers.setLayout(new BoxLayout(numbers, BoxLayout.Y_AXIS));
		numbers.add(grid1,BorderLayout.CENTER);
		numbers.add(grid2,BorderLayout.CENTER);
			
		buttons.add(numbers,BorderLayout.CENTER);
		buttons.add(grid3,BorderLayout.WEST);
				
		}
	}

	public class EventListener implements ActionListener{

		private String token;
		
		public EventListener(){
			token = new String();
		}
				
		@Override
		public void actionPerformed(ActionEvent e) {
			
			screen.setForeground(Color.black);
			Object button = e.getSource();
			
			if(button==log){
				token = " log ";
			}
			else if(button==sin){
				token = " sin ";
			}
			else if(button==cos){
				token = " cos ";
			}
			else if(button==pow){
				token = " ^ ";
			}
			else if(button==sqrt){
				token = " sqrt ";
			}	
			else if(button==plus){
				token = " + ";
			}
			else if(button==minus){
				token = " - ";
			}
			else if(button==mul){
				token = " * ";
			}
			else if(button==div){
				token = " / ";
			}
			else if(button==tan){
				token = "tan ";
			}
			else if(button==cot){
				token = "cot ";
			}
			else if(button==op){
				if(expresion.isEmpty() || expresion.trim().endsWith("("))
					token = "-";
			}
			else if(button==leftp){
				token = "( ";
			}
			else if(button==rightp){
				token = " )";
			}
			else if(button==equals){
				try {												//mododa eval din ExpressionParser poate arunca doua exceptii
					screen.setForeground(Color.red);
					Double result = runCalculator.eval(expresion);
					if ((result - result.intValue()) == 0)
						token=String.valueOf(result.intValue());
					else
						token=String.valueOf(result);
						
					expresion="";
					if(token.equals("Infinity"))					//daca numarul este prea mare rezultatul nu poate fi reprezentat pe tipul double
					{
						screen.setText(token);
						token = new String();
					}
											
				}catch (EvaluatorException e1) {
					expresion += "\nIllegal expression.";
					token=new String();						//pentru nu a intra in ultimul bloc if
					screen.setText(expresion);
					expresion = new String();				//expresia nu mai poate fi modificata si este reinitializata
				} catch (SyntacticException e1) {
					expresion += "\nWrong syntax.";
					token=new String();
					screen.setText(expresion);
					expresion = new String();
				}
			}
			else if(button==b1){
				token = "1";			}	
			else if(button==b2){
				token = "2";			}	
			else if(button==b3){
				token = "3";			}	
			else if(button==b4){
				token = "4";			}	
			else if(button==b5){
				token = "5";			}	
			else if(button==b6){
				token = "6";			}	
			else if(button==b7){
				token = "7";			}
			else if(button==b8){
				token = "8";			}	
			else if(button==b9){
				token = "9";			}	
			else if(button==b0){
				token = "0";			}	
			else if(button==pct){
				token = ".";			}	
			else if(button==backSpace){								//elimina ultimul caracter
				if(!expresion.isEmpty()){
					expresion = expresion.substring(0, expresion.length()-1);
					screen.setText(expresion);}
			}
			else if(button==clear){									//elimina ultimul token
				if(!expresion.isEmpty()){
					if(!expresion.trim().contains(" "))
						expresion="";
					else
						{
						expresion=expresion.substring(0,expresion.trim().lastIndexOf(" "));
						expresion +=" ";
						}
					screen.setText(expresion);}
				}
			else if(button==ce){									//reinitializeazaa expresia
				expresion = new String();	
				screen.setText(expresion);}
			
			if(!token.isEmpty()){
				expresion +=token.toString();
				token = new String();
				screen.setText(expresion);
			}
							
}
	
	}

	public class myKeyAdapter extends KeyAdapter{ 		//KeyAdapter implements KeyListener
		
		
		public void keyPressed(KeyEvent e) {
			
			if(e.isShiftDown()){
				switch (e.getKeyCode()){
					case KeyEvent.VK_0:
						rightp.doClick();
						break;
					case KeyEvent.VK_9:
						leftp.doClick();
						break;
					default: Toolkit.getDefaultToolkit().beep();
				}
			}
			else 
				{
					switch (e.getKeyCode()) {
						case KeyEvent.VK_0:
							b0.doClick();
							break;
						case KeyEvent.VK_1:
							b1.doClick();
							break;
						case KeyEvent.VK_2:
							b2.doClick();
							break;
						case KeyEvent.VK_3:
							b3.doClick();
							break;
						case KeyEvent.VK_4:
							b4.doClick();
							break;
						case KeyEvent.VK_5:
							b5.doClick();
							break;
						case KeyEvent.VK_6:
							b6.doClick();
							break;
						case KeyEvent.VK_7:
							b7.doClick();
							break;
						case KeyEvent.VK_8:
							b8.doClick();
							break;
						case KeyEvent.VK_9:
							b9.doClick();
							break;
						case KeyEvent.VK_BACK_SPACE:
							backSpace.doClick();
							break;
						case KeyEvent.VK_PERIOD:
							pct.doClick();
							break;
						case KeyEvent.VK_EQUALS:
							equals.doClick();
							break;
						case KeyEvent.VK_PLUS:
							plus.doClick();
							break;
						case KeyEvent.VK_MINUS:
							minus.doClick();
							break;
						case KeyEvent.VK_MULTIPLY:
							mul.doClick();
							break;
						case KeyEvent.VK_DIVIDE:
							div.doClick();
							break;
						case KeyEvent.VK_ENTER:
							equals.doClick();
							break;
						case KeyEvent.VK_NUMPAD0:
							b0.doClick();
							break;
						case KeyEvent.VK_NUMPAD1:
							b1.doClick();
							break;
						case KeyEvent.VK_NUMPAD2:
							b2.doClick();
							break;
						case KeyEvent.VK_NUMPAD3:
							b3.doClick();
							break;
						case KeyEvent.VK_NUMPAD4:
							b4.doClick();
							break;
						case KeyEvent.VK_NUMPAD5:
							b5.doClick();
							break;
						case KeyEvent.VK_NUMPAD6:
							b6.doClick();
							break;
						case KeyEvent.VK_NUMPAD7:
							b7.doClick();
							break;
						case KeyEvent.VK_NUMPAD8:
							b8.doClick();
							break;
						case KeyEvent.VK_NUMPAD9:
							b9.doClick();
							break;
						case 110:							//num_period
							pct.doClick();
							break;
						case KeyEvent.VK_ADD:
							plus.doClick();
							break;
						case KeyEvent.VK_SUBTRACT:
							minus.doClick();
							break;
						default: Toolkit.getDefaultToolkit().beep();
					}
			}
						
	}

	}
}