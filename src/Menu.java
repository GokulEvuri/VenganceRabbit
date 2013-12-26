	import java.awt.Color;
	import java.awt.Component;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.IOException;

	import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JLayeredPane;
	import javax.swing.JTextField;

	public class Menu {
		
		public JFrame f;
		public JLayeredPane contentPane;
		public MyPanel menu;
		public MyPanel creditsPanel;
		public MyPanel controlsPanel;
		public MyPanel statsPanel;
		public MyPanel inputNamePanel;
		public MyPanel selectLevelPanel;
		public MyPanel loadgame2Panel;
		public GameScreen gameScreen;
		public JButton start;
		public JButton controls;
		public JButton credits;
		public JButton stats;
		public JButton exit;
		public JButton loadgame2;
		public String playerName;
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		public Menu(JFrame frame) {

			


			this.f = frame;
			contentPane = f.getLayeredPane();
			menu = new MyPanel("menuimages\\dsun.png");
			menu.setLayout(null);
			menu.setBounds(0,0, 800, 600);
			
		
			
			Icon imgicon1 = new ImageIcon("menuimages\\startps.jpg");
			start = new JButton("start", imgicon1);
			start.setBounds(90, 90, 150, 40);

		
			Icon imgicon2 = new ImageIcon("menuimages\\help.jpg");
			controls = new JButton("help", imgicon2);
			controls.setBounds(90, 150, 150, 40);

		
			
			Icon imgicon3 = new ImageIcon("menuimages\\resumegame.jpg");
			credits = new JButton("resumegame", imgicon3);
			credits.setBounds(90, 270, 150, 40);

			Icon imgicon5 = new ImageIcon("menuimages\\credits.jpg");
			stats = new JButton("credits", imgicon5);
			stats.setBounds(90, 330, 150, 40);

			Icon imgicon6 = new ImageIcon("menuimages\\exit.jpg");
			exit = new JButton("exit", imgicon6);
			exit.setBounds(90, 390, 150, 40);
			
			
			Icon imgicon4= new ImageIcon("menuimages\\next.jpg");
			loadgame2= new JButton("loadgame2", imgicon4);
			loadgame2.setBounds(90, 210, 150, 40);

			
		 addListeners(start, controls, credits, stats, exit);
			menu.add(start);
			menu.add(controls);
			menu.add(credits);
			menu.add(stats);
			menu.add(exit);
			menu.add(loadgame2);
			
		

			contentPane.add(menu, 1);

			creditsPanel = new MyPanel("menuimages\\backgroudimage.jpg");
			creditsPanel.setLayout(null);
			creditsPanel.setBounds(0, 0, 800, 560);
			creditsPanel.setVisible(false);
			contentPane.add(creditsPanel,1);

			controlsPanel = new MyPanel("menuimages\\backgroudimage.jpg");
			controlsPanel.setLayout(null);
			controlsPanel.setBounds(0, 0, 800, 560);
			controlsPanel.setVisible(false);
			contentPane.add(controlsPanel, 2);

			statsPanel = new MyPanel("menuimages\\backgroudimage.jpg");
			statsPanel.setLayout(null);
			statsPanel.setBounds(0, 0, 800, 560);
			statsPanel.setVisible(false);
			contentPane.add(statsPanel, 3);

			inputNamePanel = new MyPanel("menuimages\\backgroudimage.jpg");
			inputNamePanel.setLayout(null);
			inputNamePanel.setBounds(0, 0, 800, 560);
			inputNamePanel.setVisible(false);
			contentPane.add(inputNamePanel, 4);

			selectLevelPanel = new MyPanel("menuimages\\backgroudimage.jpg");
			selectLevelPanel.setLayout(null);
			selectLevelPanel.setBounds(0, 0, 800, 560);
			selectLevelPanel.setVisible(false);
			contentPane.add(selectLevelPanel, 5);
			
	     

		}

		public void addListeners(JButton start, JButton controls,JButton loadgame, JButton credits,
				JButton stats) {

			start.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					menu.setVisible(false);
					inputName();
					
				}

			});

			controls.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					System.out.println("lala01");
					menu.setVisible(false);
					controlsPanel.setVisible(true);
					Icon imgicon6 = new ImageIcon("back.jpg");
					final JButton back = new JButton("oo", imgicon6);
					back.setBounds(10, 380, 150, 50);
					back.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							controlsPanel.setVisible(false);
							back.setVisible(false);
							menu.setVisible(true);
							
						}

					});
					controlsPanel.add(back);
				}

			});

			credits.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					System.out.println("lala02");
					menu.setVisible(false);
					creditsPanel.setVisible(true);
					Icon imgicon6 = new ImageIcon("menuimages\\back.jpg");
					final JButton back = new JButton("back", imgicon6);
					back.setBounds(10, 380, 150, 50);
					back.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							creditsPanel.setVisible(false);
							back.setVisible(false);
							menu.setVisible(true);

						}

					});
					creditsPanel.add(back);
				}

			});

			
			
			
			
			
			
			stats.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					menu.setVisible(false);
					statsPanel.setVisible(true);
					statsPanel.setLayout(null);
					JLabel label = new JLabel(" anything else");
					label.setBounds(50, 50, 200, 100);
					statsPanel.add(label);
					Icon imgicon6 = new ImageIcon("menuimages\\back.jpg");
					final JButton back = new JButton("oo", imgicon6);
					back.setBounds(10, 380, 150, 50);
					back.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							statsPanel.setVisible(false);
							back.setVisible(false);
							menu.setVisible(true);

						}

					});
					statsPanel.add(back);
				}

			});
			
			
					
			
			

			exit.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					System.exit(0);

				}

			});
			
					}
				

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

		public void inputName() {

			inputNamePanel.setVisible(true);
			final JTextField nameField = new JTextField();
			nameField.setBounds(220, 200, 250, 40);
			inputNamePanel.add(nameField);
			JLabel pleaseInputName = new JLabel();
			pleaseInputName.setBounds(245, 90, 300, 100);
			pleaseInputName.setForeground(Color.BLACK);
			pleaseInputName.setFont(new Font("Serif", Font.BOLD, 24));
			pleaseInputName.setText(" Enter your name!");
			inputNamePanel.add(pleaseInputName);
			Icon imgicon7 = new ImageIcon("menuimages\\next.jpg");
		
			final JButton cont = new JButton("oo", imgicon7);
			cont.setBounds(260, 300, 150, 40);
			cont.addActionListener(new ActionListener()
			
			{

				public void actionPerformed(ActionEvent e) {
					
					playerName = nameField.getText();
					inputNamePanel.setVisible(false);
					selectLevel();
					// sends parameter name to user class.
					
				}

			});
			inputNamePanel.add(cont);

		}

		public void selectLevel() {
			
			JLabel pleaseSelectLevel = new JLabel();
			pleaseSelectLevel.setBounds(250, 90, 300, 100);
			pleaseSelectLevel.setForeground(Color.BLACK);
			pleaseSelectLevel.setFont(new Font("Serif", Font.BOLD, 24));
			pleaseSelectLevel.setText("Which mode do you like?");
			selectLevelPanel.add(pleaseSelectLevel);

			selectLevelPanel.setVisible(true);
			Icon imgicon8 = new ImageIcon("menuimages\\singleplayer.jpg");
			final JButton easy = new JButton("oo", imgicon8);
			easy.setBounds(280, 200, 210, 40);
			easy.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					
					
					selectLevelPanel.setVisible(false);
					easy.setVisible(false);
					f.setVisible(false);
	                 
					

				
			}});
			
			selectLevelPanel.add( easy);
			Icon imgicon9 = new ImageIcon("menuimages\\multiplayer.jpg");
			final JButton hard = new JButton("oo",imgicon9);
			hard.setBounds(280, 250, 210, 40);
			hard.addActionListener(new ActionListener() {
			
			
				public void actionPerformed(ActionEvent e) {

					selectLevelPanel.setVisible(false);
					hard.setVisible(false);
					Menumanage game = new Menumanage(f, contentPane);
					game.start(playerName, "multiplayer");
					f.setVisible(true);// if clicked the menu will dissapear.
					
					MenuMain.multiplayer = true;
					MenuMain.run = true;
				} 

			});
			
			selectLevelPanel.add(hard);

		}

	}
