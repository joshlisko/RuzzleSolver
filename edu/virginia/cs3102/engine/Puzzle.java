package edu.virginia.cs3102.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Puzzle 
{
	private ArrayList<TileSlot> slots = null;
	
	public Puzzle(String f)
	{
		this.slots = new ArrayList<TileSlot>();
		
		Scanner puzzleFile;
		try {

			puzzleFile = new Scanner(new File(f));
			//get length of file
			int n = puzzleFile.nextLine().split(" ").length; //get dimension of puzzle
			puzzleFile = new Scanner(new File(f));
			//load files into tileboard
			int col=0;
			int row=0;
			
			puzzleFile.useDelimiter(" |\n"); //separate based on space and new lines
			while(puzzleFile.hasNext()){ //create puzzle
				if(col>=n){
					col=0;
					row+=1;
				}
				//Create new tile, then add it to a slot then add that slot to the board
				Tile tile = new Tile(puzzleFile.next());
				TileSlot tileSlot = new TileSlot(col, row, tile);
				this.addTileSlot(tileSlot);
				col++;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Puzzle init error");
			JOptionPane.showMessageDialog(
				    null, "Could not initialize Puzzle file.\nMake sure each letter is separated by a space and each line is on new line.\nThe last letter on each line should not have a space after it.",
				    "File Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	
	}
	
	public Puzzle(ArrayList<TileSlot> s)
	{
		this.slots = s;
	}
	
	public ArrayList<TileSlot> getTileSlots(){
		return this.slots;
	}
	
	public void addTileSlot(TileSlot s){
		this.slots.add(s);
	}
	
	//return set of all tiles
	public ArrayList<Tile> getTileSet(){
		ArrayList<Tile> tileSet = new ArrayList<Tile>();
		for(int i=0; i<this.slots.size(); i++){
			tileSet.add(this.slots.get(i).getContainedTile());
		}
		return tileSet;
	}

	//initialize all the neighbors for every tile
	public void initTitleNeighbors(){
		int curRow = lowestYValue();
		while(curRow <= highestYValue()){
			int curCol = lowestXValue();
			while(curCol <= highestXValue()){
				Tile tile = getTileSlotAt(curCol, curRow).getContainedTile();
				
				//get tiles at all possibly adjacent positions
                TileSlot nwTileSlot = getTileSlotAt(curCol-1, curRow-1); 
                TileSlot nTileSlot = getTileSlotAt(curCol, curRow-1); 
                TileSlot neTileSlot = getTileSlotAt(curCol+1, curRow-1); 
                TileSlot eTileSlot = getTileSlotAt(curCol+1, curRow); 
                TileSlot seTileSlot = getTileSlotAt(curCol+1, curRow+1);
                TileSlot sTileSlot = getTileSlotAt(curCol, curRow+1);
                TileSlot swTileSlot = getTileSlotAt(curCol-1, curRow+1); 
                TileSlot wTileSlot = getTileSlotAt(curCol-1, curRow); 

                //add all tiles found to the current tiles list of adjacencies                
                if (nwTileSlot != null) tile.addNeighboringTile(nwTileSlot.getContainedTile());
                if (nTileSlot != null) tile.addNeighboringTile(nTileSlot.getContainedTile());
                if (neTileSlot != null) tile.addNeighboringTile(neTileSlot.getContainedTile());
                if (eTileSlot != null) tile.addNeighboringTile(eTileSlot.getContainedTile());
                if (seTileSlot != null) tile.addNeighboringTile(seTileSlot.getContainedTile());
                if (sTileSlot != null) tile.addNeighboringTile(sTileSlot.getContainedTile());
                if (swTileSlot != null) tile.addNeighboringTile(swTileSlot.getContainedTile());
                if (wTileSlot != null) tile.addNeighboringTile(wTileSlot.getContainedTile());
				
				curCol++;
			}
			curRow++;
		}
	}
	
	
	public TileSlot getTileSlotAt(int x, int y){
		for(int i=0; i<this.slots.size(); i++){
			if((this.slots.get(i).getXPosition() == x) && (this.slots.get(i).getYPosition() == y)){
				return this.slots.get(i);
			}
		}
		return null;
	}
	
	public int width(){
		return highestXValue() - lowestXValue();
	}
	
	public int height(){
		return highestYValue() - lowestYValue();
	}
	
	private int highestXValue(){
		int highestXValue = Integer.MIN_VALUE;
		for(int i=0; i<this.slots.size(); i++){
			if(this.slots.get(i).getXPosition() > highestXValue){
				highestXValue = this.slots.get(i).getXPosition();
			}
		}
		return highestXValue;
	}
	
	private int lowestXValue(){
		int lowestXValue = Integer.MAX_VALUE;
		for(int i=0; i<this.slots.size(); i++){
			if(this.slots.get(i).getXPosition() < lowestXValue){
				lowestXValue = this.slots.get(i).getXPosition();
			}
		}
		return lowestXValue;
	}
	
	private int highestYValue(){

		int highestYValue = Integer.MIN_VALUE;
		for(int i=0; i<this.slots.size(); i++){
			if(this.slots.get(i).getYPosition() > highestYValue){
				highestYValue = this.slots.get(i).getYPosition();
			}
		}
		return highestYValue;
	}

	private int lowestYValue(){
		int lowestYValue = Integer.MAX_VALUE;
		for(int i=0; i<this.slots.size(); i++){
			if(this.slots.get(i).getYPosition() < lowestYValue){
				lowestYValue = this.slots.get(i).getYPosition();
			}
		}
		return lowestYValue;
	}
	
}	