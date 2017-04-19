package br.ufv.dpi.lines2blocks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import br.ufv.dpi.blockscombinations.BlockList;

public class MapDistBlocks {

	private HashMap<Integer, ArrayList<BlockList > > map;

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
                                            int dis = Integer.parseInt(line[0]);
                   String nom = line[1];
                   String[] ary = nom.split("");
              //     map.put(dis,ary);
                 //  ArrayList<blocksList> blocksList =nom.split("");
                 // blocksList.add(nom.split(""));
                            // ArrayList<blocksList> blocksList =  Arrays.asList(ary);
				//System.out.println(ary);				
			}

		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}

