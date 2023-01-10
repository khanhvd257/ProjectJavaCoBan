/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl.btl_sv;

import java.util.Scanner;

/**
 *
 * 
 */
public class NewClass {
    public static void main(String[] args) {
       int [] ar = new int[10];
       int s = 0,j =0;
       for(int i : ar ){
           i = ++j;
           s += j;
       }
        System.out.println(""+s);
}
}
