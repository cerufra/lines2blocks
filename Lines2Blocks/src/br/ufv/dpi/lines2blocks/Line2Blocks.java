package br.ufv.dpi.lines2blocks;

public class Line2Blocks {

	public static void main(String args[])
	{
		MapDistBlocks map = new MapDistBlocks("dataset\\dataset");
		map.printMap();
                Point2Line points = new Point2Line();
                points.createXml();
        }
	
}
