package br.ufv.dpi.blockscombinations;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CreateMap {
	
	private ArrayList<Block> blocksList = new ArrayList<Block>();
	private HashSet<BlockList> closed = new HashSet<BlockList>();
        public static String nomebloco;
        public static String dist;
        public static String cadeia;
	public static String cade;
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
			//System.out.print(list.getName() + " ");
			//System.out.println(x);
			nomebloco=list.getName();
                        dist=String.valueOf(x);
                        cade= "\n"+dist+","+nomebloco;
                        cadeia=cadeia+cade;
                         try {
           FileWriter out = new FileWriter("C:\\Users\\dpime\\OneDrive\\Documentos\\NetBeansProjects\\angry_levi_4\\src\\dataset\\lista");
          out.write(cadeia);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
                
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
