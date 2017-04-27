package br.ufv.dpi.lines2blocks;

import java.io.FileNotFoundException;

public class Line2Blocks {

	public static void main(String args[])
	{
		try
		{
                Point2Line points2Line = new Point2Line("_dataset");
                points2Line.readPoint("dataset/pontos");
                points2Line.createXml();
        } catch(FileNotFoundException e)
		{
        	e.printStackTrace();
		}
	}
	
}
