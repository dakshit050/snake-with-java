import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
public class play extends JPanel implements ActionListener, KeyListener{
	private int play=0;
	private boolean stop=false;
	private int snacklength=3;
	private int Score=0;
	private Timer timer;
	private int delay=200;
	private boolean Left=false;
	private boolean Right=false;
	private boolean Up=false;
	private boolean Down=false;
	private Random random=new Random();
	private int[] snackx=new int[750];
	private int[] snacky=new int[750];
	private int[] Foodx={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650};
	private int[] Foody={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650};
	private int Foodxpos=random.nextInt(Foodx.length);
	private int Foodypos=random.nextInt(Foody.length);
	public play(){
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer =new Timer(delay,this);
		timer.start();
	}
	public void paint(Graphics g){
			if(play==0){
				snackx[0]=100;
				snackx[1]=75;
				snackx[2]=50;
				snacky[0]=100;
				snacky[1]=100;
				snacky[2]=100;
			}
			g.setColor(Color.black);
			g.fillRect(1,1,800,800);
			g.setColor(Color.yellow);
			g.fillRect(0,0,3,792);
			g.fillRect(0,0,792,3);
			g.fillRect(780,0,3,692);
			g.fillRect(3,0,650,0);
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD,25));
			g.drawString(""+Score,720,30);
			if(stop==true){
				g.setColor(Color.white);
				g.setFont(new Font("serif",Font.BOLD,25));
				g.drawString("Game Over Sore:"+Score,200,300);
				g.setFont(new Font("serif",Font.BOLD,30));
				g.drawString("Press Enter To Restart",230,350);	
			}
				for(int i=0;i<snacklength;i++){
					if(i==0){
						g.setColor(Color.green);
						g.fillOval(snackx[0],snacky[0],20,20);
					}
					if(i!=0){
						g.setColor(Color.blue);
						g.drawOval(snackx[i],snacky[i],20,20);
					}
				}
				g.fillOval(Foodx[Foodxpos],Foody[Foodypos],10,10);
				if(new Rectangle(snackx[0],snacky[0],20,20).intersects(new Rectangle(Foodx[Foodxpos],Foody[Foodypos],15,15))){
					snacklength++;
					Score=Score+5;
					Foodxpos=random.nextInt(Foodx.length);
					Foodypos=random.nextInt(Foody.length);
				}
				for(int i=1;i<snacklength;i++){
					if(new Rectangle(snackx[0],snacky[0],20,20).intersects(new Rectangle(snackx[i],snacky[i],20,20))){
						stop=true;
						snacklength=3;
						break;
					}
				}
			g.dispose();
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	public void actionPerformed(ActionEvent e){
		timer.start();
		if(stop==false){
			if(Right){
				for(int i=snacklength-1;i>=0;i--){
					snacky[i+1]=snacky[i];
				}
				for(int i=snacklength;i>=0;i--){
					if(i==0){
						snackx[i]=snackx[i]+25;
						if(snackx[i]>850){
							snackx[i]=25;
						}
					}else{
						snackx[i]=snackx[i-1];
					}
				}
			}
			if(Left){
				for(int i=snacklength-1;i>=0;i--){
					snacky[i+1]=snacky[i];
				}
				for(int i=snacklength;i>=0;i--){
					if(i==0){
						snackx[i]=snackx[i]-25;
						if(snackx[i]<0){
							snackx[i]=850;
						}
					}else{
						snackx[i]=snackx[i-1];
					}
				}
			}
			if(Down){
				for(int i=snacklength-1;i>=0;i--){
					snackx[i+1]=snackx[i];
				}
				for(int i=snacklength;i>=0;i--){
					if(i==0){
						snacky[i]=snacky[i]+25;
						if(snacky[i]>850){
							snacky[i]=25;
						}
					}else{
						snacky[i]=snacky[i-1];
					}
				}
			}
			if(Up){
				for(int i=snacklength-1;i>=0;i--){
					snackx[i+1]=snackx[i];
				}
				for(int i=snacklength;i>=0;i--){
					if(i==0){
						snacky[i]=snacky[i]-25;
						if(snacky[i]<0){
							snacky[i]=850;
						}
					}else{
						snacky[i]=snacky[i-1];
					}
				}
			}
		}
		repaint();
	}
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			if(stop==false){
				if(!Right){
				play++;
				Right=true;
				Left=false;
				Up=false;
				Down=false;
			}else{
				play++;
				Left=false;
				Up=false;
				Down=false;
				
			}
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			if(stop==false){
			if(!Left){
				play++;
				Left=true;
				Right=false;
				Up=false;
				Down=false;
			}else{
			play++;
			Right=false;
			Up=false;
			Down=false;	
			}				
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			if(stop==false){
			if(!Up){
				play++;
				Left=false;
				Up=true;
				Down=false;
				Right=false;
			}else{
				play++;
				Left=false;
				Right=false;
				Down=false;
			}
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			if(stop==false){
			if(!Down){
				play++;
				Left=false;
				Up=false;
				Down=true;
				Right=false;
			}else{
				play++;
				Down=true;
				Right=false;
				Left=false;
				Up=false;
			}				
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			if(stop==true){
				stop=false;
				play=0;
				snackx[0]=100;
				snacky[0]=100;
				Score=0;
				repaint();
				
			}
		}
	}
}