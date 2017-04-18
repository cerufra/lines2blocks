package br.ufv.dpi.blockscombinations;

import java.util.ArrayList;

public class FactoryBlock {
	
	//TODO: Change names to static strings.
	public static String rectTiny = "RectTiny"; 
        public static String squareHole = "SquareHole"; 
        public static String rectSmall = "RectSmall"; 
        public static String rectFat = "RectFat"; 
        public static String rectBig = "RectBig"; 
        public static String rectMedium = "RectMedium"; 

	public static Block create(String name) 
	{
		Block b;
		
		if(name.equals(rectTiny))
		{
			b = new Block(4, 2, rectTiny);
		} else if(name.equals(squareHole))
		{
			b = new Block(8, 8,squareHole);
		} else if(name.equals(rectSmall))
		{
			b = new Block(9, 2, rectSmall);
		} else if(name.equals(rectFat))
		{
			b = new Block(8, 4, rectFat);
		} else if(name.equals(rectBig))
		{
			b = new Block(19, 2, rectBig);
		} else 
		{
			b = new Block(17, 2, rectMedium);
		}
		
		return b;
	}
	
	public static ArrayList<Block> getAllBlocks()
	{
		Block rectTiny = new Block(4, 2, FactoryBlock.rectTiny);
		Block squareHole = new Block(8, 8, FactoryBlock.squareHole);
		Block rectSmall = new Block(9, 2, FactoryBlock.rectSmall);
		Block rectFat = new Block(8, 4, FactoryBlock.rectFat);
		Block rectBig = new Block(19, 2, FactoryBlock.rectBig);
		Block rectMedium = new Block(17, 2, FactoryBlock.rectMedium);	
		
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
