package edu.virginia.cs3102.engine;

import java.util.ArrayList;

public class Engine {
	
	/**
	 * @param args the text file input
	 */
	
	private Dictionary dictionary;
	private Puzzle tileBoard;
	private Solver solver;
	
	public Engine(final String dictionaryFile, final String puzzleFile, final int minWordLength) {
		dictionary = new Dictionary(dictionaryFile);
		tileBoard = new Puzzle(puzzleFile);
		tileBoard.initTitleNeighbors();
		solver = new Solver(dictionary, tileBoard.getTileSet(), minWordLength);
		solver.findAllWords();
	}
	
	public ArrayList<String> getSolutions(int wordSortFlag){
		if(solver.getLengthSortedSolutions()==null || solver.getLengthSortedSolutions().size()==0){
			return null;
		}
		if(wordSortFlag == 0)
			return solver.getLengthSortedSolutions();
		else
			return new ArrayList<String>(solver.getAlphaSortedSolutions());
	}
}

