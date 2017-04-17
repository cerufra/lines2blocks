package br.ufv.dpi.blockscombinations;

import java.util.ArrayList;

public class FactoryBlock {
	
	//TODO: Change names to static strings.
	public static String rectTiny = "RectTiny"; 

	public static Block create(String name) 
	{
		Block b;
		
		if(name.equals(rectTiny))
		{
			b = new Block(4, 2, rectTiny);
		} else if(name.equals("SquareHole"))
		{
			b = new Block(8, 8, "SquareHole");
		} else if(name.equals("RectSmall"))
		{
			b = new Block(9, 2, "RectSmall");
		} else if(name.equals("RectFat"))
		{
			b = new Block(8, 4, "RectFat");
		} else if(name.equals("RectBig"))
		{
			b = new Block(19, 2, "RectBig");
		} else 
		{
			b = new Block(17, 2, "RectMedium");
		}
		
		return b;
	}
	
	public static ArrayList<Block> getAllBlocks()
	{
		Block rectTiny = new Block(4, 2, FactoryBlock.rectTiny);
		Block squareHole = new Block(8, 8, "SquareHole");
		Block rectSmall = new Block(9, 2, "RectSmall");
		Block rectFat = new Block(8, 4, "RectFat");
		Block rectBig = new Block(19, 2, "RectBig");
		Block rectMedium = new Block(17, 2, "RectMedium");	
		
		ArrayList<Block> blocksList = new ArrayList<Block>();
		
		blocksList.add(rectTiny);
		blocksList.add(squareHole);
		blocksList.add(rectSmall);
		blocksList.add(rectFat);
		blocksList.add(rectBig);
		blocksList.add(rectMedium);	
		
		return blocksList;
	}
	
}
