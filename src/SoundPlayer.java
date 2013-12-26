	import java.io.*;

	import javax.sound.sampled.*;

	import sun.audio.*;


	@SuppressWarnings("restriction")
	public class SoundPlayer extends Thread{
//		public static void main(String[] args)	{
//			SimpleSoundPlayer sound = new SimpleSoundPlayer("/media/Lenovo/yearojaite chusano ninnu/Project-1.wav");
//			InputStream Stream = new In
//		}
	//}
		
		
		
		// write here for broadcast
		/*public boolean broadcast(String[] args) {
			boolean b;
			try {
				//if any action performs then return b = true
				logic           ;	    
			   b = true;}
			catch (Exception e) {
				//if not always return b = false
				 * logic ;
				
				b = false;	}
			 return b;

		}*/
		
			
		
			
	           //declaring audioformat
			public AudioFormat adf;
			public byte[] ads;
			
			
//			private static AudioPlayer MGP = AudioPlayer.player;
//			private static AudioStream BGM ;
//			private static AudioData MD;
//			private static ContinuousAudioDataStream loop = null;
//			public void bckgrndplay(){
//				
//				try{
//					
	//
//					BGM = new AudioStream(new FileInputStream(".wav"));
//					MD = BGM.getData();
//					loop = new ContinuousAudioDataStream(MD);}
//				catch(IOException error){
//					error.printStackTrace();
//					System.out.println(":P");
//				}
//				
//				
//				
//			}
//			
//			public void i_play(boolean i_play_sound) {
//				//public static void main(String[] args){
//				Thread.currentThread();
//					if(i_play_sound == true){
//					bckgrndplay();
//					MGP.start(loop);
//					}
//					if(i_play_sound==false){
//						
//						System.exit(0);
//						}
//					}
			/**
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			public SoundPlayer(String file) {
			try {AudioInputStream strm = AudioSystem.getAudioInputStream(new File(file));
					//storing audio format
					adf = strm.getFormat();
					
					ads = getads(strm);}
			
			
			catch (UnsupportedAudioFileException ex) {
				ex.printStackTrace();}
			catch (IOException ex) {
				ex.printStackTrace();
		        }
		    }

			//over load???
			public byte[] getads() {
			return ads;
			}


			private byte[] getads(AudioInputStream audStrm) {
				//geting lenght of audio file in sample frames
			int length = (int)(audStrm.getFrameLength() * adf.getFrameSize());
			byte[] ads = new byte[length];
			DataInputStream is = new DataInputStream(audStrm);		
			try {is.read(ads);}
			catch (IOException ex) {
			ex.printStackTrace();
			}
			return ads;
			}


			public void play(InputStream i_s) {
			int bufferSize = adf.getFrameSize() * Math.round(adf.getSampleRate());
			//file saving in array
			byte[] buffer = new byte[bufferSize];
			//data from file is written to line.
			SourceDataLine line;
			try {
				//gets information about the adf(file loading)
				DataLine.Info info = new DataLine.Info(SourceDataLine.class, adf);
				line = (SourceDataLine)AudioSystem.getLine(info);
				//opens line with adf format(the format which adf is in) and buffer size as declared before in line 72
				line.open(adf, bufferSize);
			}
				catch (LineUnavailableException ex) {
			ex.printStackTrace();
				return;
			}
	        //  audio playback starts at this point
			line.start();
			try {
				int numBytesRead = 0;
				while (numBytesRead != -1) {
			numBytesRead = i_s.read(buffer, 0, buffer.length);
				if (numBytesRead != -1) {
				line.write(buffer, 0, numBytesRead);
				}
				}
				}
				catch (IOException ex) {
			ex.printStackTrace();
			}
				//line.drain();
			
				//line.close();
			}
			
			} 