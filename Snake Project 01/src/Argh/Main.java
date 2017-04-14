package Argh;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

//@SuppressWarnings("serial")
public class Main extends JPanel {
	static int xPos = 0;
	static int yPos = 0;
	static int width = 50;
	static int height = 50;
	static boolean inGrid = false;

	static int frameHeight = 400;
	static int frameWidth = 400;
	
	static int gridSquaresWidth = frameWidth/width;
	static int gridSquaresHeight = frameHeight/height;
	
	static KeyboardReaction keyboardExample = new KeyboardReaction();
	static FoodSpawn foodExample = new FoodSpawn();
	static Collision collisionExample = new Collision();
	static JFrame frame = new JFrame("Keyboard attempt");
	static Main myMain = new Main();
	
	
	//The throws InterruptedException is due to the Thread.sleep() in the gameloop function
	public static void main(String[] args) throws InterruptedException {
		
		frame.addKeyListener(keyboardExample);
		//frame.add(foodExample);
		//frame.getContentPane().add(foodExample);
		myMain.add(foodExample);
		myMain.add(collisionExample);
		frame.setSize(frameHeight, frameWidth);
		frame.getContentPane().add(myMain);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Has to be called like that - cause gameloop is non-static
		myMain.gameloop();
		
	}
	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    g2.drawImage(foodExample.mouseIMG, foodExample.foodX, foodExample.foodY, foodExample.sizeX, foodExample.sizeY, this);

	    Image img1 = Toolkit.getDefaultToolkit().getImage("Images/test.png");
	    g2.drawImage(img1, xPos, yPos, width, height, this);
	    foodExample.repaint();
	    //make visual grid width for loop:
	    for(int i = 0; i<= frameWidth; i+=width){
	    	for(int j = 0; j<frameWidth; j+=width){
	    g2.draw(new Line2D.Double(i, 0, i, j));
	    g2.draw(new Line2D.Double(0, j, i, j));
	    }}
	    g2.finalize();
	    g2.getPaint();
	    
	    
	  }
	public void gameloop() throws InterruptedException{
		while (true) {
			//System.out.println("Score: "+Collision.score);
			movement();
			//game.move();
			repaint();
			frame.repaint();			
			//System.out.println(keyboardExample.leftDir);
			//System.out.println(xPos);
			if (collisionExample.foodEat == true)
			foodExample.spawnFood();
			collisionExample.Collision();
			Thread.sleep(10);

		}}
	public static boolean CheckForGrid(){
		for(int i=0; i<Main.frameWidth; i+=Main.width){
			if(Main.yPos ==i){	
			//System.out.println("yPos = " + i);
				inGrid = true;
				
		} else
				inGrid = false;
	}
		return inGrid;}
	
	public static void movement(){
		if (keyboardExample.leftDir){
			xPos-=1;	}
	
		if(keyboardExample.rightDir)
			xPos+=1;
		
		//for(int i = 0; i < frameWidth; i+=width){
		if(keyboardExample.upDir)
			yPos-=1;
		else if(keyboardExample.downDir)
			yPos+=1;
		
		//When leaving frame - position in the other end
		if(xPos==frameWidth && keyboardExample.rightDir)
			xPos = 0-width;
		else if(xPos ==0-width && keyboardExample.leftDir)
			xPos = frameWidth+width;
		
		if(yPos==frameHeight && keyboardExample.downDir)
			yPos = 0-height;
		else if(yPos ==0-height && keyboardExample.upDir)
			yPos = frameHeight+height;
		}	
}