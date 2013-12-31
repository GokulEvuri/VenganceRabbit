package refactoring;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Play extends BasicGameState {

	Image background = null;
	private TiledMap levelMap1;
    private Animation sprite, up, down, left, right;
    private float x = 100f, y = 100f;
    private boolean[][] blocked;
    public boolean jumping = false;
    public long jumpingtime = 300;
   private static final int SIZE = 34;
    
	public Play(int state){
		
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		levelMap1 = new TiledMap("/res/hmmm.tmx");
		background = new Image("/res/Background.png");
		Image [] movementUp = {new Image("/res/wmg1_bk1.png"), new Image("/res/wmg1_bk2.png")};
		Image [] movementDown = {new Image("/res/wmg1_fr1.png"), new Image("/res/wmg1_fr2.png")};
		Image [] movementLeft = {new Image("/res/wmg1_lf1.png"), new Image("/res/wmg1_lf2.png")};
		Image [] movementRight = {new Image("/res/wmg1_rt1.png"), new Image("/res/wmg1_rt2.png")};
		int [] duration = {300, 300};
		
		 up = new Animation(movementUp, duration, false);
         down = new Animation(movementDown, duration, false);
         left = new Animation(movementLeft, duration, false);
         right = new Animation(movementRight, duration, false);
         
         sprite = right;
         
         blocked = new boolean[levelMap1.getWidth()][levelMap1.getHeight()];
         
         for (int xAxis=0;xAxis<levelMap1.getWidth(); xAxis++)
         {
              for (int yAxis=0;yAxis<levelMap1.getHeight(); yAxis++)
              {
                  int tileID = levelMap1.getTileId(xAxis, yAxis, 0);
                  String value = levelMap1.getTileProperty(tileID, "blocked", "false");
                  if ("true".equals(value))
                  {
                      blocked[xAxis][yAxis] = true;
                  }
              }
          }
      }
	

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawImage(background, 0, 0);
		levelMap1.render(0,0);
//		levelMap1.render(Math.round(x), Math.round(y));
		sprite.draw((int)x, (int)y);
		g.drawString("Pos X: "+x+" Y: "+y,100,100);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
//		gc.setFullscreen(true);
		try{
    	System.out.println(levelMap1.getTileId(100,100, 0));}
		catch(Exception e){
			
		}
		if((y<645 && !isBlocked(x, y )) && jumping == false){
			y+= delta * 0.1f;
		}
		
		if(jumping&&!isBlocked(x, y + SIZE + delta * 0.1f)){
			y -= delta * 0.1f;
        }
		
		Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_UP) && jumping == false )
        {
//
//        	levelMap1.getTileProperty(, "blocked", "border")
        	sprite = up;
            jumping = true;
            new Thread(new thread()).start();
//            if (!isBlocked(x, y - delta * 0.1f))
//            {
//                sprite.update(delta);
//                // The lower the delta the slowest the sprite will animate.
//                y -= delta * 0.1f;
//            }
        }

        else if (input.isKeyDown(Input.KEY_DOWN))
        {
            sprite = down;
            if (!isBlocked(x, y + SIZE + delta * 0.1f))
            {
                sprite.update(delta);
                y += delta * 0.1f;
            }
        }
        
        else if (input.isKeyDown(Input.KEY_LEFT))
        {
            sprite = left;
            if (!isBlocked(x - delta * 0.1f, y))
            {
                sprite.update(delta);
                x -= delta * 0.1f;
            }
        }
        else if (input.isKeyDown(Input.KEY_RIGHT))
        {
            sprite = right;
            if (!isBlocked(x + SIZE + delta * 0.1f, y))
            {
                sprite.update(delta);
                x += delta * 0.1f;
            }
        }
        
	}

	@Override
	public int getID() {
		return 1;
	}
	
	private boolean isBlocked(float x, float y) 
    {

		
		int xBlock = (int)x / SIZE;
        int yBlock = (int)y / SIZE;
        return blocked[xBlock][yBlock];
    }
	
	public class thread implements Runnable{

		@Override
		public void run() {
			try{
			
				Thread.sleep(jumpingtime);
				jumping = false;
			}catch(Exception e){
				e.printStackTrace();new Thread(this).start();
				System.exit(0);
			}
			
		}
		
	}
	
}