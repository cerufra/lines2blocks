package br.ufv.dpi.blockscombinations;

import java.util.ArrayList;
import java.util.HashSet;

public class CreateMap {
	
	private ArrayList<Block> blocksList = new ArrayList<Block>();
	private HashSet<BlockList> closed = new HashSet<BlockList>();
	
	public CreateMap() {
		Block rectTiny = new Block(0.267,0.12, "RectTiny");
		Block squareHole = new Block(0.40,0.40, "SquareHole");
		Block rectSmall = new Block(0.42,0.11, "RectSmall");
		Block rectFat = new Block(0.45,0.30, "RectFat");
		Block rectBig = new Block(1.10,0.12, "RectBig");
		Block rectMedium = new Block(0.86,0.12, "RectMedium");	
		
		blocksList.add(rectTiny);
		blocksList.add(squareHole);
		blocksList.add(rectSmall);
		blocksList.add(rectFat);
		blocksList.add(rectBig);
		blocksList.add(rectMedium);	
	}
		
	public void search(BlockList list, double xMax)
	{
		double x = list.getX();
		
		if(x >= xMax || closed.contains(list))
		{
			return;
		}
		
		if(!list.isEmpty())
		{
			System.out.print(list.getName() + " ");
			System.out.println(x);
			
			closed.add(list);
		}
		
		for (Block block : blocksList) 
		{
			list.add(block);
			search(list, xMax);
			list.remove(block);
		}
	}

}
