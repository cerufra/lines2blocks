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
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class Point2Line 
{

    private ArrayList<Line> linesList = new ArrayList<Line>();
    private MapDistBlocks map;
    //private ArrayList<String> script = new ArrayList<>();
    private String script;
    private BigDecimal floor;// Its the minimal y axis in the scene
    private BigDecimal discretization;// transform the x axis in the unity x axis
    private FileWriter out;

    public Point2Line(String filename)
    {
        map = new MapDistBlocks(filename);
        //map.printMap();
    }

    public void readPoint(String filename) throws FileNotFoundException 
    {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            floor = new BigDecimal(-3.436699);
            discretization = new BigDecimal(0.0998);
            while (scanner.hasNextLine()) {
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
            script = "<?xml version=\"1.0\" encoding=\"utf-16\"?>" + "\n" + "<Level width=\"2\">" + "\n" + "<Camera x=\"0\" y=\"-1\">" + " minWidth=\"15\" maxWidth=\"17.5\">" + "\n" + "<Birds>" + "\n" + "<Bird type=\"BirdBlue\"/>" + "\n" + "<Bird type=\"BirdBlack\"/>" + "\n" + "<Bird type=\"BirdRed\"/>" + "\n"
                    + "</Birds>" + "\n" + "<Slingshot x=\"-8.5\" y=\"-2.5\">" + "\n" + "<GameObjects>";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void computeDistance(Line line) 
    {
        Point p1 = line.getP1();
        Point p2 = line.getP2();

        int diffX = p2.getPx() - p1.getPx();
        int diffY = p2.getPx() - p1.getPx();
        int degree = (int) Math.toDegrees(Math.atan(Math.round(diffY / diffX)));

        if (degree <= 0) 
        {
            degree = 180 + degree;
        }

        int distance = (int) Math.round(Math.sqrt(Math.pow((p1.getPx() - p2.getPx()), 2) + Math.pow((p1.getPy() - p2.getPy()), 2)));
        int distancePointsMap = 0;

        if (map.containsKey((Integer) distance)) 
        {
            distancePointsMap = distance;
        } else {
            distancePointsMap = map.getClosest((Integer) distance);
        }
        ArrayList<Block> list = map.getBlockList(distancePointsMap).getList();
        double r = 0;
        int firstpointx = p1.getPx();
        int firstpointy = p1.getPy();
        int unknowpointx = 0;
        int unknowpointy = 0;
        int midpointx = 0;
        int midpointy = 0;
        BigDecimal unityx;
        BigDecimal unityy;
        int distancenew = distance;
        for (Iterator<Block> iterator = list.iterator(); iterator.hasNext();) 
        {
            Block block = (Block) iterator.next();
            String name = block.getName();
            int length = block.getLength();
            //int height = block.getHeight();
            r = length / distancenew;
            unknowpointx = (int) (firstpointx + r * (p2.getPx() + firstpointx));
            unknowpointy = (int) (firstpointy + r * (p2.getPy() + firstpointy));
            midpointx = (int) ((firstpointx + p2.getPx()) / 2);
            midpointy = (int) ((firstpointy + p2.getPy()) / 2);
            unityx = discretization.multiply(new BigDecimal(midpointx));
            unityy = floor.add(new BigDecimal(midpointy));
            String auxiliaryscript = "\n" + "<Block type=" + name + " material=" + "\"wood\"" + " x=\"" + unityx + "\" y=\"" + unityy + "\" rotation=\"" + degree + "\" />";
            script = script + auxiliaryscript;
            firstpointx = unknowpointx;
            firstpointy = unknowpointy;
            distancenew = distancenew - length;
        }
    }
    
    public void createXml()
    {
        script = script + "\n" + "</GameObjects>" + "\n" + "</Level>";
        try {
            out = new FileWriter("level1.xml");
            out.write(script);
            out.close();
            //  outi.write(testString);
            //   outi.close();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        System.out.println("XML Result: " + script);
    }
}
