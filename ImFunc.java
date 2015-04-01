/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author yajnavalkya
 */
public class ImFunc {

    
  public static void ImRead(File file) throws IOException{
  BufferedImage image = ImageIO.read(file);  
  FileWriter redf = new FileWriter("red.txt",true);
  FileWriter greenf = new FileWriter("green.txt",true);
  FileWriter bluef = new FileWriter("blue.txt",true);
  int x = image.getHeight();
  int y = image.getWidth();
  for (int i=0;i<y;i++){
      for(int j=0;j<x;j++){          
            int clr=  image.getRGB(i,j);
            int  red   = (clr & 0x00ff0000) >> 16;
            int  green = (clr & 0x0000ff00) >> 8;
            int  blue  =  clr & 0x000000ff;
            redf.write(red+"   ");
            greenf.write(green+"   ");
            bluef.write(blue+"    ");
      }
  }
  }
    
}
