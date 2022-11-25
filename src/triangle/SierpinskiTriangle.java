package triangle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SierpinskiTriangle {
	public static int SIZE = 1000;

	JFrame frame;
	JPanel panel;

	@SuppressWarnings("serial")
	public void display() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				paintSierpinskiTriangle(g, getSize());
			}
		};
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				panel.repaint();
			}
		});
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setSize(SIZE, SIZE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SierpinskiTriangle triangle = new SierpinskiTriangle();
		triangle.display();
		//triangle.paintSierpinskiTriangle(, 100);
	}


	public void paintSierpinskiTriangle(Graphics g, Dimension size) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.white);
		g2.clearRect(0, 0, size.width, size.height);
		g2.draw3DRect(20, 20, size.width - 40, size.height - 40, true);


		//int height = size.height;
		//int side = size.width -40;
		//int x = 20;
		//int y = height-20;

		//tri(g2,x,y,side,height);

		//draws first Triangle









		int[] Start ={20, size.height-20};
		int[] A ={(size.width/2) , 20};
		int[] B= {size.width-20, size.height-20};

		tri(g2,Start,A,B,4);

		//g2.drawLine(Start[0],Start[1], A[0] , A[1]);
		//g2.drawLine(A[0],A[1],B[0],B[1]);



		//draws outer Triangles / connects midpoints

		//int[] AB = makeMidpoint(A,B);
		//int[] StartA= makeMidpoint(Start, A);
		//int[] StartB= makeMidpoint(Start,B);

		//triangle(g2,AB,StartA,StartB);

		//g2.drawLine(AB[0],AB[1],(size.width/2),size.height-20);
		//g2.drawLine(StartToA[0],StartToA[1],(size.width/2),size.height-20 );
		//g2.drawLine(AB[0],AB[1], StartToA[0], StartToA[1]);







	}
	public int[] makeMidpoint(int[] point1, int[] point2)
	{
		int[] Midpoint ={((point1[0]+point2[0])/2),((point1[1]+point2[1])/2)};
		return Midpoint;
	}
	public void triangle(Graphics g, int[] point1, int[] point2, int[] point3)
	{

		g.drawLine(point1[0],point1[1],point2[0],point2[1]);
		g.drawLine(point2[0],point2[1],point3[0],point3[1]);
		g.drawLine(point3[0],point3[1],point1[0],point1[1]);
	}
	public Color getColor(Graphics g){
		Random rand = new Random();
		int random = rand.nextInt(5);
		Color[] colors= {Color.red,Color.blue,Color.green,Color.CYAN,Color.MAGENTA,Color.yellow};
		return colors[random];
	}
	public int[] getX(int[]p1,int[]p2,int[]p3)
	{
		int[] X = {p1[0],p2[0],p3[0]};
		return X;
	}
	public int[] getY(int[]p1,int[]p2,int[]p3)
	{
		int[] Y = {p1[1],p2[1],p3[1]};
		return Y;
	}


	public void tri(Graphics g, int[] P1, int[] P2, int[] P3, int lvl)
	{

		int[] P12 = makeMidpoint(P1,P2);
		int[] P23 = makeMidpoint(P2,P3);
		int[] P13 = makeMidpoint(P1,P3);
		triangle(g,P1,P2,P3);
			if(lvl >0) {

				tri(g,P1,P12,P13,lvl-1);
				tri(g,P12,P2,P23,lvl-1);
				tri(g,P13,P23,P3,lvl-1);
				g.setColor(getColor(g));
				g.fillPolygon(getX(P12,P23,P13),getY(P12,P23,P13),3);

				}


			//if(lvl == 2)triangle();





	}



}
