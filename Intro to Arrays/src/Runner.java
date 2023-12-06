import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Runner extends JPanel implements ActionListener, MouseMotionListener{
	
	//arrays of Cell objects (container only)
	Cell[] cells = new Cell[1000];
	
	//singular variable - one Cell
	Cell exp = new Cell();
	
	

	public void paint(Graphics g) {
		super.paintComponent(g);
	 
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
		
		
		//have the single cell draw itself
		exp.paint(g);
		
		//now - "traverse" the array and instruct every Cell object
		//to paint themselves in our world
		//vists every Cell object in the array, tell them to paint
		//themselves
		for(int i = 0; i < Cell.population; i++) {
			
			if(cells[i%cells.length] != null) {
				cells[i%cells.length].paint(g); //yo, cell at position i, paint yourself
			}
		}

		
	}
	
	
	
	public static void main(String[] arg) {
		Runner m = new Runner();
		
	}
	
	public Runner() {
		JFrame f = new JFrame("[hip, hip, array]");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);
		f.add(this);
		f.addMouseMotionListener(this);
		Timer t = new Timer(50, this);
		
		//Create particles to add to the array
		//constructor helps setup the objects!
		for( int i = 0; i < 12; i++ ) {
			cells[i] = new Cell(); //store a new cell @ index i
		}
		
		t.start();
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}


	@Override
	public void mouseDragged(MouseEvent m) {
		
		
		//when you drag your mouse on the screen
		//create a new Cell that is located at
		//the position of the mouse
		int x = m.getX();
		int y = m.getY();
		
		//create a Cell object at position x, y
		Cell newCell = new Cell(x, y);
		
		//add cell to array
		cells[Cell.population%cells.length] = newCell;
		
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
