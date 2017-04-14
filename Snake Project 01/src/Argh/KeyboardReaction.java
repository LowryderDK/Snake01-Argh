package Argh;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class KeyboardReaction implements KeyListener {

	static boolean leftDir = false;
	boolean rightDir = false;
	boolean upDir = false;
	boolean downDir = false;
	boolean ChangeDirection = false;
	static int[] gridArray =  { 0, 50, 100, 150, 200, 250, 300, 350, 400 };
	@Override
	public void keyPressed(KeyEvent e) {
		//Check if position is in grid....
		for(int i = 0; i<gridArray.length; i++){
			//Making it easier to turn, as it doesn't have to be right on the pixel but plus/minus one
			if(Main.yPos == gridArray[i]||Main.yPos == gridArray[i]+1||Main.yPos == gridArray[i]-1){		
				Main.yPos = gridArray[i];
		//System.out.println(Arrays.toString(gridArray));
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			leftDir = true;
			rightDir = false;
			upDir = false;
			downDir = false;
		}
			
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			rightDir = true;
			leftDir = false;
			upDir = false;
			downDir = false;
			}
			}}
		for(int i = 0; i<gridArray.length; i++){
			if(Main.xPos == gridArray[i]||Main.xPos == gridArray[i]+1||Main.xPos == gridArray[i]-1){		
				Main.xPos = gridArray[i];	
		if(e.getKeyCode() == KeyEvent.VK_UP){
			upDir = true;
			leftDir = false;
			rightDir = false;
			downDir = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			downDir = true;
			leftDir = false;
			rightDir = false;
			upDir = false;	
		}
		}}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		

		//System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		//System.out.println("Left = "  + leftDir);
		
	}
	
	
	
}
