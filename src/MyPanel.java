
	import java.awt.Dimension;
	import java.awt.Graphics;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;

	import javax.imageio.ImageIO;
	import javax.swing.JPanel;


	@SuppressWarnings("serial")
	public class MyPanel extends JPanel {
		



		public BufferedImage image;
		public int w, h;

		/*public MyPanel() {

		}*/
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		public MyPanel(String imagePath) {
			try {
				image = ImageIO.read(new File(imagePath));
				w = image.getWidth();
				h = image.getHeight();
			} catch (IOException ioe) {
				System.out.println(ioe);
				System.exit(0);
			}
		}

		public Dimension getPreferredSize() {
			return new Dimension(w, h);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(image, 0, 0, this);
			
			
		}

	}
