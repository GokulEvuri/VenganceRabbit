	import javax.swing.JFrame;
	import javax.swing.JFrame;

	
	public class MenuMain{
		
		public static boolean run = false;
		public static boolean multiplayer = false;
		public static int level=0;

		MenuMain(){
		
		JFrame frame = new JFrame("Vengeful Rabbit");
		
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setResizable(false);
		frame.setLayout(null);
		new Menu (frame);
		
		while(run = false) {
			
			isitmp();
			isrun();
			if(run)break;
		}

	}
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		boolean isitmp() {
			
			return multiplayer;
		
			
		}
		
		boolean isrun() {return run;}
	}    
