package Argh;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Collision extends JPanel {
	//FoodSpawn foodExample = new FoodSpawn();
	static boolean foodEat = false;
	static int score = 0;
	
	public int Collision(){
		//Corner 1 - top left of the snake
		if (Main.xPos > FoodSpawn.foodX && Main.xPos< FoodSpawn.foodX+ FoodSpawn.foodW 
				&& Main.yPos > FoodSpawn.foodY && Main.yPos < FoodSpawn.foodY+FoodSpawn.foodH){
			foodEat = true;	
			
		}
		//Corner 4 - bottom right of the snake
		if(Main.xPos+Main.width > FoodSpawn.foodX && Main.xPos+Main.width < FoodSpawn.foodX+FoodSpawn.foodW
				&& Main.yPos+Main.height > FoodSpawn.foodY && Main.yPos +Main.height < FoodSpawn.foodY+FoodSpawn.foodH) {
			System.out.println("collision");
			foodEat = true;
		}
		if(foodEat){
		score +=1;
		}
		return score;
	}
}
