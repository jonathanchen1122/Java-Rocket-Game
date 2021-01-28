package ProPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class spaceJet extends JPanel implements ActionListener, KeyListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer tik = new Timer(5, this);
	Random random = new Random();
	
	int width = 10;
	int height = 150;
	
	int x1 = 0;
	int x2 = 0;

	int vx1 = 0;			// velocity x
	int vx2 = 0;

	int y1 =  650;
	int y2 =  0;
	int vy1 = 0;			//velocity y
	int vy2 = 0;
	
	int startGame = 1;
	

	
	
	
	double maxHP = 392.0;
	double damage = 0;
	int lazer = x1 + 2000;
	
	//Asteroids
	int asteroidPosition = 1100;
	int asteroidVelocity = -10;
	int asteroidHeight = 300;
	
	int asteroidPosition2 = 1200;
	int asteroidVelocity2 = -5;
	int asteroidHeight2 = 200;
	
	int asteroidPosition3 = 1300;
	int asteroidVelocity3 = -6;
	int asteroidHeight3 = 100;
	
	int asteroidPosition4 = 1000;
	int asteroidVelocity4 = -10;
	int asteroidHeight4 = 250;
	
	int asteroidPosition5 = 1500;
	int asteroidVelocity5 = -3;
	int asteroidHeight5 = 500;
	
	int asteroidPosition6 = 1400;
	int asteroidVelocity6 = -6;
	int asteroidHeight6 = 600;
	
	
	//comet
	int cometx = 1600;
	int cometv = -10;
	int comety = 300;
	
	
	double xlration = 1.29972;

	
	//Game Over
	String endGame = " ";
	String score = " ";
	int scoreNum = 0;
	int endingSizeX = 0;
	int endingSizeY = 0;
	int scoreX = 0;
	int scoreY = -1000;
	
	
	//Alien
	double AlienX = 800;
	int AlienY = 0;
	double AlienVX = 0;
	int AlienVY = 0;
	int AlienHP = 100;
	int AlienDamage = 0;
	int a = 0; // Alien spawn interval in respect to points
	int killScore = 0;
	
	int Alert = 0;
	

	
	
	
	public spaceJet(){
		tik.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		
	}

	
	public void healthDrop() {
	 
		damage = -.15;
	}
	
	
	public void asteroid() {			//+ comet
		if(asteroidPosition < -100) {
			asteroidPosition = 1100;
			asteroidHeight = 100 + 10*random.nextInt(30);
		}
		if(asteroidPosition2 < -100) {
			asteroidPosition2 = 1100;
			asteroidHeight2 = 100 + 10*random.nextInt(30);
		}
		if(asteroidPosition3 < -100) {
			asteroidPosition3 = 1100;
			asteroidHeight3 = 100 + 10*random.nextInt(30);
		}
		if(asteroidPosition4 < -100) {
			asteroidPosition4 = 1100;
			asteroidHeight4 = 300 + 10*random.nextInt(30);
		}
		if(asteroidPosition5 < -300) {
			asteroidPosition5 = 1100;
			asteroidHeight5 = 300 + 10*random.nextInt(30);
		}
		if(asteroidPosition6 < -100) {
			asteroidPosition6 = 1100;
			asteroidHeight6 = 300 + 10*random.nextInt(30);
		}
		if(cometx < -100) {
			cometx = 5000;
			comety = 100 + 200*random.nextInt(2);
		}
	}
	
	public void heal() {
		if(cometx >= x1 && cometx <= x1 + 250) {
			if(comety >= y1 && comety <= y1 + 160) {
				if(maxHP <= 392-100) {
				maxHP += 100;
				cometx = 5000;
				scoreNum++;
				}
				else{
					maxHP = 392;
					cometx = 5000;
					scoreNum++;
				}
			}
		}
	}
	
	public void laser() {
		lazer = x1 + 100;
	}
	
	
	
	
	public void gameOver() {
		if(maxHP <=0) {
			y1 = 1500;
			vx1 = 0;
			endGame = "Game Over";
			scoreX = 280;
			scoreY = 400;
			endingSizeX = getWidth();
			endingSizeY = getHeight();
		}
	}
	
	public void alienAttack() {
		
		//starts moving towards the screen
		AlienVX = -5;
		
		if (AlienX <=300) {
		damage = -0.5;
		}
		
		//Jumps to position when it reaches to the screen
		if (AlienX <= 600) {
		Alert = 1;
		AlienY = 0;
		AlienVX = -0.5;
			if (AlienY == 0 && AlienY != 300 ) {
				AlienVY = 3;	
			}
			if(AlienY == 300 && AlienY != 0 ) {
				AlienVY = -3;
			}
			
		}
	}
	
	public void alienHealthDrop() {
		if(AlienY + 300 <= y1 + 43 && AlienY +  420 >= y1 + 57  ) {
				AlienDamage = -1;
		}
	}
	
	public void alienExplode() {
			//reset Position
			AlienX = 800;
			//setting bound just in case
			AlienY = 1000;
			
			//stop moving
			AlienVX = 0;
			//resetHealth
			AlienHP = 100;
			
			
			Alert = 0;
			//Score count
			killScore ++;
			a++;
	}
	
	public void music() {
		
	}
	
	
	

	public void paint(Graphics gg) {				// making the picture
   		
		//Vacuum Of space
		gg.setColor(Color.black);
		gg.fillRect(0, 0, getWidth(), getHeight());
		
		
		//Stars
		gg.setColor(Color.white);
		gg.fillRect(random.nextInt(1000), random.nextInt(650), 5, 5);
		gg.fillRect(random.nextInt(1000), random.nextInt(650), 5, 5);
		gg.fillRect(random.nextInt(1000), random.nextInt(650), 5, 5);
		gg.fillRect(random.nextInt(1000), random.nextInt(650), 5, 5);
		gg.fillRect(random.nextInt(1000), random.nextInt(650), 5, 5);
		gg.fillRect(random.nextInt(1000), random.nextInt(650), 5, 5);
		gg.fillRect(random.nextInt(1000), random.nextInt(650), 5, 5);
		gg.fillRect(random.nextInt(1000), random.nextInt(650), 5, 5);
		
		//Asteroids ***
		gg.setColor(Color.white);
		gg.fillOval(asteroidPosition, asteroidHeight, 50, 50);
		gg.fillOval(asteroidPosition2, asteroidHeight2, 110, 110);
		gg.fillOval(asteroidPosition3, asteroidHeight3, 70, 70);
		
		gg.fillOval(asteroidPosition4, asteroidHeight4, 50, 50);
		gg.fillOval(asteroidPosition5, asteroidHeight5, 200, 200);
		gg.fillOval(asteroidPosition6, asteroidHeight6, 60, 60);
		
		
		//	Rocket Engine Fire
		gg.setColor(Color.red);			
		gg.fillOval(x1-130 + random.nextInt(10), y1+28, 30, 13);
		gg.fillOval(x1-130 + random.nextInt(10), y1+68, 30, 13);
		gg.fillOval(x1-100 + random.nextInt(10), y1+48, 30, 12);
		gg.setColor(Color.yellow);
		gg.fillOval(x1-125 + random.nextInt(10), y1+30, 20, 12);
		gg.fillOval(x1-125 + random.nextInt(10), y1+66, 20, 12);
		gg.fillOval(x1-100 + random.nextInt(10), y1+48, 27, 12);

		
		
		//laser **********
		gg.setColor(Color.orange);
		gg.fillRect(lazer,y1 + 43 ,20000, 14);
		gg.setColor(Color.yellow);
		gg.fillRect(lazer,y1 + 46 ,20000, 8);
		gg.setColor(Color.green);
		gg.fillRect(lazer,y1 + 48,20000, 4);
		
		
		
		// Wings And Beak of the Rocket
		gg.setColor(Color.gray);
		gg.fillArc(x1+150+random.nextInt(5), y1-150, 250, 400, 170,20);
		gg.fillOval(x1-25+random.nextInt(5), y1-35, 150, 80);
		gg.fillOval(x1-25+random.nextInt(5), y1+65, 150, 80);	
		
		// Cut-holes from the wings
		gg.setColor(Color.black);
		gg.fillOval(x1-30+random.nextInt(5), y1-10, 50, 50);
		gg.fillOval(x1-30+random.nextInt(5), y1+66, 50, 50);
	
		//	Rocket Main Color
		gg.setColor(Color.RED);
		gg.fillOval(x1 + random.nextInt(5),y1, 200,100);
		
		//	Rocket Wing on the side of the rocket Main Color
		gg.setColor(Color.gray);
		gg.fillRect(x1-20+random.nextInt(5),y1+50, 80,8);
		gg.fillOval(x1+75, y1+16, 70, 60);
		
		// window screen
		gg.setColor(Color.yellow);
		gg.fillOval(x1+80, y1+21, 60, 50);
		
		
		//Health Font
		gg.setColor(Color.orange);
		gg.fillRect(20, 20, 400, 80);
		gg.setColor(Color.black);
		gg.fillRect(22, 22, 396, 76);

		
		//Health Bar:	392 is the maximum health
		gg.setColor(Color.green);
		gg.fillRect(24, 24, (int)maxHP, 72); 
	//	gg.setFont(new Font(null,Font.BOLD,20));
		//gg.drawString("Health",60,130);
		
		//Indicators to spacing the health Bar
		gg.setColor(Color.black);
		gg.fillRect(24+195, 24, 4, 72);
		gg.fillRect(24+97, 24, 4, 72);
		gg.fillRect(24+97+195, 24, 4, 72);
		
		//Rocket Location
		gg.setColor(Color.green);; 
		gg.setFont(new Font(null,Font.BOLD,20));
		gg.drawString("Rocket Location:",5,590);
		gg.drawString("X: " + x1,10,610);
		gg.drawString("Y: " + (650-y1),100,610);
		gg.drawString(" Score:			" + scoreNum, 500,610);
		gg.drawString(" Ship Destroyed:		" + killScore, 700,610);
		
		//Title
		gg.setColor(Color.yellow);
		gg.setFont(new Font(null,Font.BOLD,50));
		gg.drawString("ROCKET POWER",500,90);

		//Comet ***
		gg.setColor(Color.green.darker());
		gg.fillOval(cometx, comety, 80, 25);
		gg.setColor(Color.green);
		gg.fillOval(cometx, comety, 25, 25);
	
		
		
		
		
		
		
		//Alien UFO:		spawns each time you score 10 points.
		gg.setColor(Color.green);
		gg.fillOval((int)AlienX + 500,AlienY + 300, 100, 100);					// UFO top window screen
		gg.fillArc((int)AlienX + 300,AlienY +  160, 250,400 ,  -10, 20);				// UFO disk  left side
		gg.fillArc((int)AlienX + 550,AlienY +  160, 250, 400, 170,20);				//UFO disk   right side
		//Alien Outline
		gg.setColor(Color.black);
		gg.fillRect((int)AlienX + 500,AlienY +  340, 100, 2);
		gg.fillRect((int)AlienX + 516,AlienY +  385, 67, 2);
		gg.fillArc((int)AlienX + 500,AlienY + 300, 100, 100, 0, 180);
		//window shield
		gg.setColor(Color.green);
		gg.drawOval((int)AlienX + 500,AlienY + 300, 100, 100);	
		//Alien Health Bar
		gg.setColor(Color.green);
		gg.fillRect((int)AlienX + 500, AlienY +  450, AlienHP, 20);
		
		//Alien Radiation Alert!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		gg.setColor(Color.orange);
		gg.fillOval(50,450, 100,100*Alert);
		gg.setColor(Color.black);
		gg.fillOval(65, 465, 70, 70*Alert);
		gg.setColor(Color.orange);
		gg.fillArc(67,467, 66,66, 0, 60*Alert);
		gg.fillArc(67,467, 66,66, 120, 60*Alert);
		gg.fillArc(67,467, 66,66, 240, 60*Alert);
		gg.setColor(Color.black);
		gg.fillOval(85, 485, 30, 30*Alert);
		gg.setColor(Color.orange);
		gg.fillOval(90, 490, 20, 20*Alert);
		
		
		//game Over screen
		gg.setColor(Color.black);
		gg.fillRect(0, 0, endingSizeX, endingSizeY);
		
		//Game Over Word
		gg.setColor(Color.RED);
		gg.setFont(new Font (null, Font.BOLD,100));
		gg.drawString(endGame,200,300);	
		gg.setFont(new Font (null, Font.ITALIC,30));
		gg.drawString(" Score:			" + scoreNum,scoreX,scoreY);	
		gg.drawString(" Ship Destroyed:		" + killScore, scoreX,scoreY + 100);
		
		
		
		
		
		
		
		//Welcome!!!!!					PLAY SCREEN
		
		gg.setColor(Color.BLACK);
		gg.fillRect(0, 0, getWidth()*startGame, getHeight()*startGame);
		gg.setColor(Color.yellow);
		gg.setFont(new Font (null, Font.BOLD,100*startGame));
		gg.drawString( "ROCKET POWER",75*startGame,300*startGame);
		gg.setFont(new Font (null, Font.ITALIC,30*startGame));
		gg.drawString(" Press Enter To Play ",350*startGame,400*startGame);
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
		// incrementing velocity into player 1 and player 2 x y positions
		
		x1 += vx1;
		x2 += vx2;
		
		y1 += vy1;
		y2 += vy2;
		
		
		//HP Decreasing
		maxHP += damage;
		
		
		//Out Of Bound
		if(x1 <= -500) {
			maxHP = 0;
		}
		if(y1 <= -500) {
			maxHP = 0;
		}
		if(y1 >= 1150) {
			maxHP = 0;
		}
		
		
		
		//Asteroid
		asteroidPosition += asteroidVelocity;	
		asteroidPosition2 += asteroidVelocity2;	
		asteroidPosition3 += asteroidVelocity3;	
		asteroidPosition4 += asteroidVelocity4;
		asteroidPosition5 += asteroidVelocity5;
		asteroidPosition6 += asteroidVelocity6;
		
		//comet
		cometx += cometv;
		
		
		
		//Alien
		AlienX += AlienVX;
		AlienY += AlienVY;
		AlienHP += AlienDamage;
		
		asteroid();  // + comet
		heal();
		gameOver();

		
			if(scoreNum >= 10+a*10 && scoreNum < 20 + a*10) {
				alienAttack();
				if(AlienHP <=0) {
					alienExplode();
				}
			}
	}
	
		



	@Override
	public void keyPressed(KeyEvent e){
		int co = e.getKeyCode();
		if(startGame == 0) {
			if(co == KeyEvent.VK_W ) {	//up
				vy1 = -3;	
				
			}	
			if(co == KeyEvent.VK_S ) {	//down
				vy1 = 3;
			}		

			if(co == KeyEvent.VK_A ) {	//back
				vx1 = -6;	
			}
			
			if(co == KeyEvent.VK_D ) {	//Forwards
				vx1 = 1;
				healthDrop();
								
			}
			if(co == KeyEvent.VK_SPACE) { // shoot laser
				lazer = x1 + random.nextInt(5) + 100;
				healthDrop();
				alienHealthDrop();
								
			}
			
			// Resetting Position
			if(co == KeyEvent.VK_R ) {
				x1 = getWidth()/2;
				y1 = getHeight()/2;
			}
			
			//Health dropping test button
			if(co == KeyEvent.VK_O) {
				healthDrop();
			}
			//Health Increasing test button
			if(co == KeyEvent.VK_P) {
				damage = 2;
			}
			if (co == KeyEvent.VK_U) {
				scoreNum++;
			}
		}
		
		
		
		
		
		if (co == KeyEvent.VK_ENTER) {
			if(startGame == 1) {				//Start 	Screen
				startGame = 0;
				x1 = 500;
				y1 =  370;
				vx1 = -3;
			}
			else if(startGame == 0) {			//End   	Screen
				startGame = 1;
				x1 = 0;
				x2 = 0;
				vx1 = 0;		
				vx2 = 0;
				y1 =  650;
				vy1 = 0;

				maxHP = 392.0;
				damage = 0;
			}
		}
		}

	@Override
	public void keyReleased(KeyEvent e) {
		int co = e.getKeyCode();
	if(startGame == 0) {
		if(co == KeyEvent.VK_W ) {
			 vy1 = 0;
		}			
		if(co == KeyEvent.VK_S ) {
			 vy1 = 0;
		}		

		if(co == KeyEvent.VK_A ) {
			vx1 = -3;	
		}
		
		if(co == KeyEvent.VK_D ) {
			vx1 = -3;
			damage = 0;
		}
		if(co == KeyEvent.VK_SPACE) { // shoot laser
			lazer = x1 + 2000;
			AlienDamage = 0;
		}
		if(co == KeyEvent.VK_O) {
			damage = -300;
		}
		if(co == KeyEvent.VK_P) {
			damage = 0;
		}
	}
		if (co == KeyEvent.VK_ENTER) {
	
			}	
		}
	
	
	public static void main(String[]args) {
			JFrame j = new JFrame();
			spaceJet player = new spaceJet();
			
			j.add(player);					// adding object to j frame object
			j.setTitle("Space Jet Game");
			j.setSize(1000, 650);
			j.setResizable(false);
			j.setVisible(true);
			j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
