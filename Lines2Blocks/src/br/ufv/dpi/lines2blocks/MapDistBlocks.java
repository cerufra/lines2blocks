package br.ufv.dpi.lines2blocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import br.ufv.dpi.blockscombinations.BlockList;

public class MapDistBlocks {

	private HashMap<Integer, ArrayList<BlockList > > map;

	public MapDistBlocks(String filename) 
	{
		Scanner scanner;
		try 
		{
			File file = new File(filename);
			scanner = new Scanner(file);
			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				System.out.println(line);				
			}

		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

}
