/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.dpi.lines2blocks;

/**
 *
 * @author dpimestrado
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import br.ufv.dpi.blockscombinations.Block;

public class Point2Line {

	private ArrayList<Line> linesList = new ArrayList<Line>();
	private MapDistBlocks map;
	
	public Point2Line(String filename) 
	{
		map = new MapDistBlocks(filename);
	}

	public void readPoint(String filename) throws FileNotFoundException 
	{
		try 
		{
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) 
			{
				String points[] = scanner.nextLine().split(",");

				int x1 = Integer.parseInt(points[0]);
				int y1 = Integer.parseInt(points[1]);
				int x2 = Integer.parseInt(points[2]);
				int y2 = Integer.parseInt(points[3]);
				Point p1 = new Point(x1, y1);
				Point p2 = new Point(x2, y2);
				Line line = new Line(p1, p2);
				linesList.add(line);
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	public void computeDistance(Line line)
	{
		Point p1 = line.getP1();
		Point p2 = line.getP2();

		int diffX = p2.getPx() - p1.getPx(); 
		int diffY = p2.getPx() - p1.getPx();  
		int degree = (int) Math.toDegrees(Math.atan(Math.round(diffY/diffX)));

		if (degree <= 0) degree = 180 + degree;
		
		int distance = (int) Math.round(Math.sqrt(Math.pow((p1.getPx() - p2.getPx()), 2) + Math.pow((p1.getPy() - p2.getPy()), 2)));
		int distancePointsMap=0;

		if (map.containsKey((Integer) distance))
		{
			distancePointsMap = distance;
		} else
		{
			distancePointsMap = map.getClosest((Integer) distance);
		}
		
		ArrayList<Block> list = map.getBlockList(distancePointsMap).getList();
		for (Iterator<Block> iterator = list.iterator(); iterator.hasNext();) 
		{
			Block block = (Block) iterator.next();
			String name = block.getName();
			int length = block.getLength();
			int height = block.getHeight();
			
			
		}
	}
}
