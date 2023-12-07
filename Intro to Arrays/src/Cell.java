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
	private double area; //for better size calculation as you eat
	public int ellapsedTime;
	
	
	//include a constructor
	//that will init the state of the object
	// position: randomly placed in an 800x600 space
	//			 should be alive
	//			 size: 45
	//			 color: random
	//			 speed: random
	public Cell() {
		
		ellapsedTime = (int)(Math.random()*(1000)+1000);
		
		// (int)(Math.random()*(range+1)+min);
		this.size = 12;
		
		//set the area
		this.area = Math.PI * Math.pow(this.size/2, 2);
		
		this.x = (int)(Math.random()*((1920-size)+1));
		this.y = (int)(Math.random()*((1200-size)+1));
		
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
	public Cell(boolean alive) {
		
		this.x = (int)(Math.random()*((1920-size)+1));
		this.y = (int)(Math.random()*((1200-size)+1));
		
		int red = (int)(Math.random()*(256)); //[0 255]
		int green = (int)(Math.random()*(256));
		int blue = (int)(Math.random()*(256));
		
		this.color = new Color(red, green, blue);
		
		// xSpeed, xSpeed are 0
		this.xSpeed = 0;
		this.ySpeed = 0;
		this.alive = alive;
		
		//size of food?
		this.size = 6;
		
		//update the area
		this.area = Math.PI * Math.pow(this.size/2, 2);
		
	}
	
	
	
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
		
		if(alive) {
			ellapsedTime -= 16;
			if(ellapsedTime <= 0) {
				
				this.xSpeed = (int)(Math.random()*(6+1)+-3);
				this.ySpeed = (int)(Math.random()*(6+1)+-3);
				
				while(this.xSpeed == 0) {
					this.xSpeed = (int)(Math.random()*(6+1)+-3);
				}
				
				while(this.ySpeed == 0) {
					this.ySpeed = (int)(Math.random()*(6+1)+-3);
				}
				
				ellapsedTime = (int)(Math.random()*(1000)+1000);
				
			}
		}
		
	}
	
	
	//eat - aka collision between cells!
	public void eat(Cell other) {
		
		//size of bigger cell increases
		
		//collision
		
		//find the center of this cell
		int x1 = this.x + this.size/2;
		int y1 = this.y + this.size/2;
		
		//find the center of the other cell
		int x2 = other.x + other.size/2;
		int y2 = other.y + other.size/2;
		
		
		//find the distance between the two points
		double d = Math.sqrt( Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2) );
		
		//determine if there is collision
		if(d < this.size/2 + other.size/2) {
			
			
			//the bigger cell eats the smaller cell
			if( this.area > other.area ) {
				
				//this cell's area will increase by the other cell's area
				this.area += other.area;
				
				this.size = (int) (Math.sqrt(this.area / Math.PI) * 2);
				
				//other cell is consumed
				//respawn the other cell anywhere on the screen
				//reset its size to the default size
				if(other.alive) {
					//respawn as a new live cell
					other.x = (int)(Math.random()*1920);
					other.y = (int)(Math.random()*1200);
					other.size = 12;
					other.area = Math.PI * Math.pow(other.size/2, 2);
				}else {
					//respawn as a food cell
					other.x = (int)(Math.random()*1920);
					other.y = (int)(Math.random()*1200);
					other.size = 6;
					other.area = Math.PI * Math.pow(other.size/2, 2);
				}
				
				
			}else if(this.area < other.area) {
				
				//the other cell's area is gonna increase
				other.area += this.area;
				
				//the other cell's size will update
				other.size = (int) (Math.sqrt(other.area / Math.PI) * 2);
				
				//this cell will respawn
				if(this.alive) {
					//respawn as a new live cell
					this.x = (int)(Math.random()*1920);
					this.y = (int)(Math.random()*1200);
					this.size = 12;
					this.area = Math.PI * Math.pow(this.size/2, 2);
				}else {
					//respawn as a food cell
					this.x = (int)(Math.random()*1920);
					this.y = (int)(Math.random()*1200);
					this.size = 6;
					this.area = Math.PI * Math.pow(this.size/2, 2);
				}
				
				
			}else {
				//same size - draw
				//nothing happens
			}
			
		}
		
		
		
	}
	
	
}
