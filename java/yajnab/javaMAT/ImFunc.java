package java.yajnab.javaMAT;

/*
 *This work is licensed under the Creative Commons Attribution-NonCommercial 4.0 International License. 
 *To view a copy of this license, visit http://creativecommons.org/licenses/by-nc/4.0/.
 * Author : Yajnavalkya Bandyopadhyay <yajnab@gmail.com>
 */


import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;

/**
 *
 * @author yajnavalkya
 */
public class ImFunc {

    
  public static void ImReadRGBMatrix(File file) throws IOException{
  BufferedImage image = ImageIO.read(file);  
  FileWriter matrix = new FileWriter("colormatrix.txt",true);
  int x = image.getHeight();
  int y = image.getWidth();
  for (int i=0;i<y;i++){
      for(int j=0;j<x;j++){          
            int clr=  image.getRGB(i,j);
            matrix.write(clr+"   ");
            }
  }
  }
  public static void ImReadSplitMatrix(File file)throws IOException {
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
            redf.write(red+"\t");
            greenf.write(green+"\t");
            bluef.write(blue+"\t");
      }
  }
  }
  public static void ImReadGrayScale(File file, int choice)throws IOException {
      BufferedImage image = null, imageo= null;
       FileWriter matrix = new FileWriter("colormatrix.txt",true);
      try{          
      image = ImageIO.read(file);     
      BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null); 
      imageo = op.filter(image, null);
      if(choice==1){ImageIO.write(imageo,"jpeg",new File("grayScale.jpg"));}
      }
      catch (IOException ex) {
            
      }
      if(imageo != null){
      int x = imageo.getHeight();
      int y = imageo.getWidth();
      for (int i=0;i<y;i++){
      for(int j=0;j<x;j++){          
            int clr=  imageo.getRGB(i,j);
            matrix.write(clr+"   ");
            }
  }}
      
      
  }
}

    

