	import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.*;



	public class SoundMain {
		public boolean fire_sound;
		public boolean menu_sound;
		public boolean game_start_sound;
		public boolean jump_sound;
		public boolean dead_rbt_sound;
		public boolean dead_enem_sound;
		
		SoundPlayer sound = new SoundPlayer("ShootGame.wav");
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		public void play_fire_sound(){
			//SoundPlayer sound = new SoundPlayer("D:/Game sounds/ShootGame.wav");
			InputStream stream = new ByteArrayInputStream(sound.getads());
			Weapon wepobj = new Weapon(0, 0);
			if(fire_sound == true && wepobj.ammunition > 0 ){
				sound.play(stream);	
				}
			}
	}		

