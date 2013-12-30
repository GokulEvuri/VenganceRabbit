	import java.awt.Container;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.Scanner;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTable;
	import javax.swing.JTextField;


	public class HighScoreList  extends JFrame implements ActionListener{
		
		

		private static final long serialVersionUID = 1L;

	    
	    static final int MAX_ROWS = 5;
	    static final int MAX_COLUMNS = 3;
		
		public HighScoreList(){
			super("your HighScore");
			setBounds(0,0,400,400);
			
			setResizable(false);
			getContentPane().setLayout(null);
			setVisible( true );
		

	    JTable scoreTable = new JTable(5, 3);
	    scoreTable.setEnabled(false);
	    scoreTable.setBounds(20, 20, 250, 80);
	    
	    JTextField textlabel= new JTextField("this is your highscore list");
	    textlabel.setLocation(10, 170);
	    textlabel.setSize(textlabel.getPreferredSize());
	    
	    JLabel nameLabel = new JLabel("Enter Your Name:");
	    nameLabel.setLocation(10, 140);
	    nameLabel.setSize(nameLabel.getPreferredSize());

	    JTextField nameField = new JTextField();
	    nameField.setBounds(120, 140, 140, 20);

	    JButton addButton = new JButton("see your Score!");
	    addButton.setBounds(20, 220, 250, 30);

	    addButton.addActionListener(this);
	    
	    Container content = getContentPane();
	    content.add(textlabel);
	    content.add(scoreTable);
	    content.add(nameField);
	    content.add(addButton);

	    setVisible(true);
	    // <- NEW
	   
	    
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Scanner input= new Scanner (System.in);
			System.out.print("put in your name to see the highscore");
			String nameInput=input.next();
			
//			User name=
					new User(nameInput);
			input.close();
			}
			
		}

