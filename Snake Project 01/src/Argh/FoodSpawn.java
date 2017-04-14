package Argh;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FoodSpawn extends JPanel{
	static int foodX = 40;
	static int foodY = 40;
	static int foodW = 50; 
	static int foodH = 50;
	int sizeX = 50;
	int sizeY = 50;
	//Must spawn 1x1 food pixel (image) at random location
	Image mouseIMG;
	//void FoodSpawn(){
	
		
	//}
	public void spawnFood(){
		
		Random X = new Random();
		foodX = X.nextInt(350);
		Random Y = new Random();
		foodY = Y.nextInt(350);
		System.out.println(foodY);
		Collision.foodEat = false;
	}
	public void paint(Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
		ImageIcon iia = new ImageIcon("Images/mus.jpg");
		mouseIMG = iia.getImage();
		super.paint(g);
		//g.drawImage(mouseIMG, foodX, foodY, this);
		//iia.paintIcon(this, g, 50, 50);
		/* Image img2 = Toolkit.getDefaultToolkit().getImage("Images/mus.jpg");
		 g3.drawImage(img2, foodX, foodY, foodW, foodH, this);
		    */
	    g3.finalize();
	    g3.getPaint();
	    // System.out.println("print print");
	    
	}	

	//Must have trigger-collision with snake (image)
	
	//Must despawn when "hit" by snake	

	//Must send info to snake so that it "grows" by ½ pix
}


