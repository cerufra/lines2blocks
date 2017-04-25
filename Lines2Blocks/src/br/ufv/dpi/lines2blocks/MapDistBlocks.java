package br.ufv.dpi.lines2blocks;

import br.ufv.dpi.blockscombinations.Block;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import br.ufv.dpi.blockscombinations.BlockList;
import java.math.BigDecimal;

public class MapDistBlocks {
       public static char[][] cenario;
    public static int dx;
    public static int ax;
    public static int bx;
     public static int ay;
      public static int by;
    public static int dy;
    public static String caden;
    public static String cadeia;
    public static BigDecimal descretizacao;
    public static int qtde; 
    public static int qttde;
    public static int bloqueado;
    public static BigDecimal chao;// y minimo ou seja coordenadas y do chao nao vaira 
    public static BigDecimal lado; //xminimo varia de a cordo com o cenario do unity por em quanto e 0 
    public static int distancia;
    private ArrayList<Point> ponto = new ArrayList<Point>();
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
      /*  public MapDistBlocks(HashMap mapi)
	{
		this.setMap(mapi);
		
	}
        
        public void setMap(HashMap map) 
	{
		this.map = map;
	}
        public HashMap getMap() 
	{
		return this.map;
	}*/
        
        public void distancia(){
                    int tam = ponto.size();
               for (int i = 0; i < tam-1; i++) {
            //primeiro ponto
            Point p1 =  ponto.get(i);
            //segundo
            Point p2 =ponto.get(i+1);
            
            //calculos
 ax=p1.getPx();
 ay= p1.getPy();
bx= p2.getPx();
by= p2.getPy();
int  anx = bx -ax; 
        
     int any= by-ay;  
   
  //  angulo= any.divide(anx);
    int  anguloo = Math.round(any/anx);
    int ang =(int) Math.toDegrees((Math.atan(anguloo)));
  
         distancia =(int) Math.round( Math.sqrt( Math.pow( (ax - bx),2 ) +
                               Math.pow( (ay - by),2 ) ));
     
    if (ang <= 0){
        ang = 180+ang;
    }
    int temp=0;
    if (map.containsKey(distancia)){
        temp =distancia;
    }else{
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.next()>distancia){
            temp= iter.next();
        }
    }
     ArrayList<BlockList> arrayList = map.get(temp);
     Iterator<BlockList> iterator = arrayList.iterator();
     while(iterator.hasNext()){
         BlockList blockilist = (BlockList) iterator.next();
        String blocki= blockilist.getName();
         ArrayList<Block> blokk = new ArrayList<Block>();
         Iterator<Block> itera = blokk.iterator();
         while(itera.hasNext()){
             Block ela = itera.next();
             String nomm = ela.getName();
           if(blocki.equals(nomm)){
         int  lx = ela.getHeight();
         
           } else {
               
           }
         }
     
     }
        } 
        }
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

