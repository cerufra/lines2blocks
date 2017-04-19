package br.ufv.dpi.lines2blocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import br.ufv.dpi.blockscombinations.BlockList;

public class MapDistBlocks {

	private HashMap<Integer, ArrayList<BlockList > > map = new HashMap<Integer, ArrayList<BlockList > >();

	MapDistBlocks(String filename) 
	{
		Scanner scanner;
		try 
		{
			File file = new File(filename);
			scanner = new Scanner(file);
			while(scanner.hasNextLine())
			{
				String line[] = scanner.nextLine().split(",");
                Integer length = Integer.parseInt(line[0]);
                String blockNames = line[1];
                String[] names = blockNames.split(" ");
                
                BlockList blockList = new BlockList();
                for (int i = 0; i < names.length; i++) 
                {
                	blockList.add(names[i]);
				}
                
                if(!map.containsKey(length)) 
                {
                	map.put(length, new ArrayList<>());
                	map.get(length).add(blockList);
                }
                else
                {
                	map.get(length).add(blockList);
                }			
			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * This method provides an example of how to iterate through the map.
	 * In this example we simply print the blocks' length and their combination.
	 */
	public void printMap() {
		Iterator<Integer> iter = map.keySet().iterator();

		while(iter.hasNext()) 
		{
			Integer i = iter.next();
			System.out.println("\n\nLength: " + i);
			
			ArrayList<BlockList> arrayList = map.get(i);
			for (Iterator<BlockList> iterator = arrayList.iterator(); iterator.hasNext();) 
			{
				BlockList blockList = (BlockList) iterator.next();
				System.out.println(blockList.getName());
			}
		}
		
	}
}

