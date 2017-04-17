/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.dpi.blockscombinations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author dpimestrado
 */
public class OrdenaLista {
    String nome; 
    double dist; 
    public OrdenaLista(double n, String  i) {
        dist = n; nome = i; 
    }
          
}
class Test126 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList teste = new ArrayList();
         File angry = new File("C:\\Users\\dpime\\OneDrive\\Documentos\\NetBeansProjects\\angry_levi_4\\src\\dataset\\block");
        //File angry = new File("C:\\Users\\CERUTINHO\\Documents\\NetBeansProjects\\angry_levi_4\\src\\dataset\\block");
        FileReader angried = new FileReader(angry);
        //lendo o arquivo filereder
        try (BufferedReader input = new BufferedReader(angried)) {

            Scanner sc = new Scanner(angry);
            String dx = sc.nextLine();
             for (int i = 0; i < 276; i++) {
                String parts[] = sc.nextLine().split(",");
                 int dis = Integer.parseInt(parts[0]);
                  String nom = parts[1];
        teste.add (new OrdenaLista (dis, nom));
             }
        }
         Collections.sort (teste, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
            OrdenaLista p1 = (OrdenaLista) o1;
            OrdenaLista p2 = (OrdenaLista) o2;
            return p1.dist < p2.dist ? -1 : (p1.dist > p2.dist ? +1 : 0);
            }
         });
        System.out.println (teste);
         }
    }

