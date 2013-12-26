
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import javax.swing.ImageIcon;

	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JLayeredPane;

	public class Menumanage implements MouseListener {

		public JFrame frame;
		public JLayeredPane contentPane;
		public GameScreen gameScreen;
		public MyPanel oponentOnePanel;
		public MyPanel oponentTwoPanel;
		public MyPanel overallInfoPanel;
		public MyPanel gameLogoPanel;
		
		public JLabel[] labels = new JLabel[6];
		public JLabel time = new JLabel();
		public ImageIcon icon;
		public Runnable cr;
		public Thread thread1;
		public int scoreValue = 0;
		
		public boolean startPlay;
		public boolean startThread;
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

		public Menumanage(JFrame f, JLayeredPane cp) {
			
			try {
				
			} catch (OutOfMemoryError e) {
				System.out.println("");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();}
			this.frame = f;
			f.setLayout(null);
			this.contentPane = cp;
			
			startPlay = false;
			startThread = true;
			}

		public void start(String playerName, String level) {

			if (level.equalsIgnoreCase("single player")) {
//				gameScreen = new GameScreen("menuimages\\Credits_08419.gif");
			} else if (level.equalsIgnoreCase("multiplayer")) {
				gameScreen = new GameScreen("menuimages\\Credits_08419.gif");


		}

		
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		}
				
