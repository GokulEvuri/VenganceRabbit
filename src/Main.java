	import java.applet.*;
	import java.awt.*;
	import java.awt.event.KeyEvent;
	import java.io.ByteArrayInputStream;
	import java.io.InputStream;

	public class Main extends Applet implements Runnable {

		private static final long serialVersionUID = 1L;

		Thread thread;
		
		//frames_timer
		long start_time;
		long sleep_time;
		
		//Graphics Handling
		private Image screen_buffer;
		private Graphics graphics;
		protected Component component; 
		
		public static int screen_width, screen_height, native_width, native_height, bit_depth, physics_multi_sampling;
		public static double factor;
		
		boolean multiplayer = true;
		int level = 0;
		
		public static boolean running = false;
		

		//graphics handling
		private Graphics g;
		
		//load classes here
		Game game;
		MenuMain menu;
		
		// keyboard object
		Keyboard keyboard;// = new Keyboard();
		
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		public void init()
		{
		    screen_width =  800;
			screen_height =  600;
			
			native_width =  640;
			native_height = 480;

			bit_depth = 16;
			
			//applet 	
			setSize(screen_width, screen_height);
			setBackground(Color.black);
			
			
			//game speed & collission check runs
			physics_multi_sampling = 5; //how many times the physics loop will loop
			factor = 0.2;

			//graphics (this points to the applets width == MAin.widht)
			screen_buffer = createImage (native_width, native_height);
			graphics = screen_buffer.getGraphics ();
			keyboard = new Keyboard();
			
			//keyListener 
			addKeyListener(keyboard);
			
			
		}
		public void start() //move to threads.java
		{
			thread = new Thread(this);
			thread.start ();
			
		}	
		@SuppressWarnings("deprecation")
		public void stop()
		{
			thread.stop();
			thread = null;
		}
		
		
		public void helth_zero(){
			Player obj_plyer = new Player(level, level);
			if(obj_plyer.health==0||obj_plyer.health<0){
				Main fu = new Main();
				//fu.stop();
				
				
			}
		}
		
		{
			
		}
		public void run() {
			/*
			menu = new MenuMain();
			
			while(!menu.run) {
				
				multiplayer =  menu.isitmp();
				
			}
			
			*/
			//init Game
			
			
			
			game = new Game();
			Sound sobj = new Sound();
			sobj.i_play_sound = true;
//			sobj.i_play(true);
//			SoundPlayer b_g_s_p_obj = new SoundPlayer("Story Line.wav");
//			InputStream stream = new ByteArrayInputStream(b_g_s_p_obj.getads());
//			b_g_s_p_obj.play(stream);
//			BackGroundSound BackGroundSoundObj = new BackGroundSound("Story Line.wav");
//			BackGroundSoundObj.start();	
			
			if(multiplayer)game.mp_init();//run after selections in start menu are set
			else game.sp_init();//run after selections in start menu are set
			//game.u = new User("apa");
			
			
			while (true)
			{
				processInput();
				keyboard.pollkey();
				
				Thread.currentThread().setPriority(Thread.MAX_PRIORITY); 
				start_time = System.currentTimeMillis();
				
				if(multiplayer)game.mp_loop();
				else game.sp_loop();

				//refresh
				repaint();
				
				sleep_time = (16 - (System.currentTimeMillis() - start_time)); 
				if(sleep_time>0){
				
					Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
				
				try
				{
					Thread.sleep ( sleep_time  ); //it's a 60hz game!! sleeps the rest of the time (if there is any)
					
				}
				catch (InterruptedException ex){}
				
				}			
			}
		}

		public void update (Graphics g)
		{
			//it's called double buffering, it first draws to an image, then draws the image to the screen. Got it Rabbits? 
			// set color o draw to buffer
			graphics.setColor (getBackground ());
			graphics.fillRect (0, 0, native_width, native_height);
			graphics.setColor (getForeground());
		
			//paints to imgae 
			if(multiplayer)game.mp_render(graphics, this);
			else game.sp_render(graphics, this);
			
			//g.drawImage (screen_buffer, 0, 0, this);//final display image
			g.drawImage (screen_buffer, 0, 0, screen_width, screen_height, 0, 0, native_width, native_height, this);//final display image
		}
		   protected void processInput(){// protected
				
				/// all the key Bindings
				// remember the players twos keybindings !!
				
			   if (keyboard.keyDown(KeyEvent.VK_ESCAPE)){
					
				   //Temporary, applets does not exit. Just go to start menu later.
				   System.exit(0);
				}
				
			   
			   //if moving left
				if (keyboard.keyDown(KeyEvent.VK_LEFT)){
					game.players.p[0].LEFT=true;
				}
				// moving right
				if (keyboard.keyDown(KeyEvent.VK_RIGHT)){
					game.players.p[0].RIGHT=true;
				}
				// jump
				if (keyboard.keyDown(KeyEvent.VK_UP)){
					game.players.p[0].UP=true;
				}
				if (keyboard.keyDown(KeyEvent.VK_SPACE)){
					game.players.p[0].SPACE=true;
				}
				// jump
				if (keyboard.keyDown(KeyEvent.VK_DOWN)){
					game.players.p[0].drop=true;
				}

				if(game.players.p[1] != null) {
				//Player_two
				// jump
				if (keyboard.keyDown(KeyEvent.VK_A)){
					game.players.p[1].LEFT=true;
				}
				if (keyboard.keyDown(KeyEvent.VK_D)){
					game.players.p[1].RIGHT=true;
				}
				if (keyboard.keyDown(KeyEvent.VK_W)){
					game.players.p[1].UP=true;
				}
				if (keyboard.keyDown(KeyEvent.VK_S)){
					game.players.p[1].drop=true;
				}
				if (keyboard.keyDown(KeyEvent.VK_CONTROL)){
					game.players.p[1].SPACE=true;
				}
				}
				
				}
				
			}
