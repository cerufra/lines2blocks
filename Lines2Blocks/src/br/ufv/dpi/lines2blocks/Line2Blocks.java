package br.ufv.dpi.lines2blocks;

import java.io.FileNotFoundException;

public class Line2Blocks {

	public static void main(String args[])
	{
		try
		{
                Point2Line points2Line = new Point2Line("dataset");
                points2Line.readPoint("pontos");
                points2Line.createXml();
        } catch(FileNotFoundException e)
		{
        	e.printStackTrace();
		}
	}
	
}
