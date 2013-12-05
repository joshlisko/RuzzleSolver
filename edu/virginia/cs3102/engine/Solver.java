package edu.virginia.cs3102.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;



public class Solver 
{
	
	private Dictionary dictionary;
	private ArrayList<Tile> tileSet;
	private Set<String> words;
	private int minWordLength;
	
	public Solver(Dictionary d, ArrayList<Tile> s, int min)
	{
		dictionary = d;
		tileSet = s;
		minWordLength = min;
		words = new TreeSet<String>();
	}
	
	public Set<String> getAlphaSortedSolutions(){
		//return alphabetically sorted list
		return words;
	}
	
	public ArrayList<String> getLengthSortedSolutions(){
		//return length sorted list
		ArrayList<String> sortedWords = new ArrayList<String>(words);
		Collections.sort(sortedWords, new Comparator <String>(){

			public int compare(String o1, String o2) {
				return o2.length()-o1.length();
			}
		});
		
		return sortedWords;
	}
	
	//iterate through each tile
	public void findAllWords(){
		for(int i=0; i<tileSet.size(); i++){
			ArrayList<Tile> tileOrigin = new ArrayList<Tile>();
			tileSet.get(i).setVisited(true);
			tileOrigin.add(tileSet.get(i));
			findWords(tileOrigin);
			tileSet.get(i).setVisited(false);
		}
	}
	
	//search algorithm
	protected void findWords(ArrayList<Tile> tileSequence){
		//convert to string
		String tileSequenceString = convertSequenceToString(tileSequence);
		//partial match, move on
		if(dictionary.partialContains(tileSequenceString)){
			//exact match, add word into solutions list
			if(tileSequence.size() >= minWordLength && dictionary.contains(tileSequenceString) ){
				words.add(tileSequenceString);
			}
			//recursive stuff
			Tile endTile = tileSequence.get(tileSequence.size()-1);
			ArrayList<Tile> neighbors = endTile.getNeighbors();
			for(int i=0; i<neighbors.size(); i++){
				if(!neighbors.get(i).isVisited()){
					neighbors.get(i).setVisited(true);
					ArrayList<Tile> newTileSequence = new ArrayList<Tile>();
					for(int j=0; j<tileSequence.size(); j++){
						newTileSequence.add(tileSequence.get(j));
					}
					newTileSequence.add(neighbors.get(i));
					findWords(newTileSequence);
				}
			}
		}
		
		tileSequence.get(tileSequence.size()-1).setVisited(false);
		return;
	}
	
	//helper method
	public String convertSequenceToString(ArrayList<Tile> tileSequence){
		String sequence = "";
		for(int i=0; i<tileSequence.size(); i++){
			sequence += tileSequence.get(i).getLetter();
		}
		return sequence;
	}
	
}