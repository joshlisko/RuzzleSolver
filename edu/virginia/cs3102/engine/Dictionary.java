package edu.virginia.cs3102.engine;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

import edu.virginia.cs3102.engine.Trie;


public class Dictionary {
	
	private Trie trie = new Trie();

	public Dictionary(String f){
		//init dictionary file
		
		BufferedReader dictionaryFile = null;
		
		try{
			dictionaryFile = new BufferedReader(new FileReader(f));
			String curLine;
			while((curLine = dictionaryFile.readLine()) != null){
				this.trie.addWord(curLine.trim().toLowerCase());
			}
			dictionaryFile.close();
		}
		catch(Exception e){
			System.out.println("Dictionary file error");
			JOptionPane.showMessageDialog(
				    null, "Could not initialize dictionary file",
				    "File Error",
				    JOptionPane.ERROR_MESSAGE);
		}
		
	}

		
	
	public boolean partialContains(String word){
		return this.trie.isPartialWord(word);
	}
	
	public boolean contains(String word){
		return trie.isWord(word);
	}
	
}
