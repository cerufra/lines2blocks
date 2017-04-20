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
import java.util.Scanner;


/**
 *
 * @author dpimestrado
 */
public class Point2Line {

   

    public static String filen = "pontos";
    Scanner scanne;
    private ArrayList<Point> ponto = new ArrayList<Point>();

    public void ReadPoint(String file) throws FileNotFoundException {
        try {
            File filei = new File(filen);
            scanne = new Scanner(filei);
            while (scanne.hasNextLine()) {
                String partis[] = scanne.nextLine().split(",");

                int angu1 = Integer.parseInt(partis[0]);
                int angu2 = Integer.parseInt(partis[1]);
                Point pTemp = new Point(angu1, angu2);

                ponto.add(pTemp);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
              

        

    }
}
