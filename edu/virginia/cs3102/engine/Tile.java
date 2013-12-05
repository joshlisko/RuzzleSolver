package edu.virginia.cs3102.engine;

import java.util.ArrayList;

public class Tile
{
	private String letter;
	private boolean visited;
	private ArrayList<Tile> neighbors;
	
	public Tile(String l)
	{
		this.letter = l;
		this.neighbors = new ArrayList<Tile>();
	}

	public String getLetter(){
		return this.letter;
	}
	
	public void setLetter(String l){
		this.letter = l;
	}
	
	public void setVisited(boolean v){
		this.visited = v;
	}
	
	public boolean isVisited(){
		return this.visited;
	}
	
	public ArrayList<Tile> getNeighbors(){
		return this.neighbors;
	}
	
	public void setNeighbors(ArrayList<Tile> tiles){
		this.neighbors = tiles;
	}
	
	public void addNeighboringTile(Tile t){
		this.neighbors.add(t);
	}
}
