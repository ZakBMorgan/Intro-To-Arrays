import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	
	//attributes of a Cell (the state)
	private int x, y;
	private boolean alive;
	private int size;
	private Color color;
	private int xSpeed, ySpeed;
	public static int population = 0;
	
	
	//include a constructor
	//that will init the state of the object
	// position: randomly placed in an 800x600 space
	//			 should be alive
	//			 size: 45
	//			 color: random
	//			 speed: random
	public Cell() {
		
		// (int)(Math.random()*(range+1)+min);
		this.size = 12;
		
		this.x = (int)(Math.random()*((800-size)+1));
		this.y = (int)(Math.random()*((800-size)+1));
		
		int red = (int)(Math.random()*(256)); //[0 255]
		int green = (int)(Math.random()*(256));
		int blue = (int)(Math.random()*(256));
		
		this.color = new Color(red, green, blue);
		
		//speed
		//[-3 3]
		this.xSpeed = (int)(Math.random()*(6+1)+-3);
		this.ySpeed = (int)(Math.random()*(6+1)+-3);
		
		while(this.xSpeed == 0) {
			this.xSpeed = (int)(Math.random()*(6+1)+-3);
		}
		
		while(this.ySpeed == 0) {
			this.ySpeed = (int)(Math.random()*(6+1)+-3);
		}
		
		this.alive = true;
		
		//we just created an object!
		this.population++;
		
	}
	
	
	//add a second constructor
	//that allows initialization of the position
	//during construction
	public Cell(int initX, int initY) {
		
		//call the default constructor
		//to do the basic init portions like usual
		this(); // adding parenthesis to this
				// allows you to invoke the default constructor
		this.x = initX;
		this.y = initY;
		
	}
	
	//3rd constructor
	//to be able to create the stationary
	// smaller than the regular cells
	
	
	
	
	//paint method - runs 60x per second
	//acts as animation timer
	public void paint(Graphics g) {
		update(); //update state first before redrawing
		
		g.setColor(color);
		g.fillOval(x, y, size, size);
		
		
	}
	
	//update method
	//stuff that update the state of the object
	public void update() {
		
		//position update
		this.x += xSpeed;
		this.y += ySpeed;
		
	}
	
	
}
