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
	
	//singular variable 

	

	public void paint(Graphics g) {
		super.paintComponent(g);
	 
		//have the single cell draw itself
		
		
		//now - "traverse" the array and instruct every Cell object
		//to paint themselves in our world

		
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
		// TODO Auto-generated method stub
		

		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
