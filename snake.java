import java.util.*;
import javax.swing.*;
import java.awt.*;
public class snake{
	public static void main(String args[]){
		JFrame obj=new JFrame();
		play pl = new play();
		obj.setBounds(10,10,800,800);
		obj.setTitle("Snake Game.");
		obj.setVisible(true);
		obj.setResizable(false);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(pl);
	}
}
