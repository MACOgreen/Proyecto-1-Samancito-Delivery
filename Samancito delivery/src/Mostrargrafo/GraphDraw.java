/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mostrargrafo;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GraphDraw extends JFrame {
    int width;
    int height;

    ArrayList<Node> nodes;
    ArrayList<edge> edges;
    int ymedio;
    int xmedio;

    public GraphDraw() { //Constructor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	nodes = new ArrayList<Node>();
	edges = new ArrayList<edge>();
	width = 30;
	height = 30;
    }
    
    public GraphDraw(String name) { //Construct with label
	this.setTitle(name);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	nodes = new ArrayList<Node>();
	edges = new ArrayList<edge>();
	width = 30;
	height = 30;
    }
    
    class Node {
	int x, y;
	String name;
	
	public Node(String myName, int myX, int myY) {
	    x = myX;
	    y = myY;
	    name = myName;
	}
    }
    
    class edge {
	int i,j;
	String peso;
        
	public edge(int ii, int jj,String pp) {
	    i = ii;
	    j = jj;
            peso=pp;
	}
    }
    
    public void addNode(String name, int x, int y) { 
	//add a node at pixel (x,y)
	nodes.add(new Node(name,x,y));
	this.repaint();
    }
    public void addEdge(int i, int j,String p) {
	//add an edge between nodes i and j
	edges.add(new edge(i,j,p));
	this.repaint();
    }
    /*
    public void medio(int x1, int y1, int x2, int y2){
        xmedio=(x2-x1)/2;
        ymedio=(y2-y1)/2;
        
        if(xmedio<0){
            xmedio=xmedio*(-1);
        }
        if(ymedio<0){
            ymedio=ymedio*(-1);
        }
    }
    */
    
    
    public void paint(Graphics g) { // draw the nodes and edges
	FontMetrics f = g.getFontMetrics();
	int nodeHeight = Math.max(height, f.getHeight());
        
	g.setColor(Color.YELLOW);
	for (edge e : edges) {
            
	    g.drawLine(nodes.get(e.i).x, nodes.get(e.i).y,
		     nodes.get(e.j).x, nodes.get(e.j).y);
            
	}  

	for (Node n : nodes) {
	    int nodeWidth = Math.max(width, f.stringWidth(n.name)+width/2);
	    g.setColor(Color.white);
	    g.fillOval(n.x-nodeWidth/2, n.y-nodeHeight/2, 
		       nodeWidth, nodeHeight);
	    g.setColor(Color.black);
	    g.drawOval(n.x-nodeWidth/2, n.y-nodeHeight/2, 
		       nodeWidth, nodeHeight);
	    
	    g.drawString(n.name, n.x-f.stringWidth(n.name)/2,
			 n.y+f.getHeight()/2);
	}
        
        
        /*
        for(int k=0;k<edges.size();k++){
            edge e=edges.get(k);
            this.medio(nodes.get(e.i).x, nodes.get(e.i).y, nodes.get(e.j).x, nodes.get(e.j).y);
            g.setColor(Color.black);
            g.drawString(e.peso, xmedio ,
			 ymedio );
            
        }
        */
        
    }

    
}
