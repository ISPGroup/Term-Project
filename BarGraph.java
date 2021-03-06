import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;

/**
 * This class creates a coloured bar graph that displays the numbers of books in each genre.
 * It has a method that will create the data, and will determine what kind of scale to use
 * depending on the maximum value.
 * 
 * @author Lily Xiao
 * @version v 1.0, May 25/14
 */
public class BarGraph extends JPanel {

  /**
   * values holds all the data to go into the graph. (Temporary data at the moment)
   */
  int [] values = new int [12];
  JFrame frame = new JFrame("BarGraph");
  /**
   * Constructor for the BarGraph class.
   * 
   * @param frame creates a new JFrame (temporary only to test the program)
   */
  public BarGraph ()
  {
    JLabel title;
    title = new JLabel ("Book Genres");
    title.setFont (new Font ("Serif", Font.PLAIN, 50));
    add (title);
    frame.add(this);
    frame.setSize(700, 500);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    setVisible (true);
    
  }
  
  /**
   * Counts up the genres and creates the data for the bar graph.
   * 
   * @param tempBook stores the ArrayList with the data
   * @param tempValues stores the new data and puts it into values
   */
  public void countValues (ArrayList <BookRecord> tempBook)
  {
    int [] tempValues = new int [11]; 
    
    for (int x = 0; x < tempBook.size (); x++)
    {
      if (tempBook.get (x).getGenre ().equals ("Action"))
      {
        tempValues [0] ++;
      }
      else if (tempBook.get (x).getGenre ().equals ("Historical"))
      {
        tempValues [1] ++;
      }
      else if (tempBook.get (x).getGenre ().equals ("Horror"))
      {
        tempValues [2] ++;
      }
      else if (tempBook.get (x).getGenre ().equals ("Humour"))
      {
        tempValues [3] ++;
      }
      else if (tempBook.get (x).getGenre ().equals ("Kids"))
      {
        tempValues [4] ++;
      }
      else if (tempBook.get (x).getGenre ().equals ("Mystery"))
      {
        tempValues [5] ++;
      }
      else if (tempBook.get (x).getGenre ().equals ("Romance"))
      {
        tempValues [6] ++;
      }
      else if (tempBook.get (x).getGenre ().equals ("Sci-fi/Fantasy"))
      {
        tempValues [7] ++;
      }
      else if (tempBook.get (x).getGenre ().equals ("Supernatural"))
      {
        tempValues [8] ++;
      }
      else if (tempBook.get (x).getGenre ().equals ("Young Adult"))
      {
        tempValues [9] ++;
      }
      else if (tempBook.get (x).getGenre ().equals ("Other"))
      {
        tempValues [10] ++;
      }
    }
    values = tempValues;
  }
    
  /**
   * Returns the maximum value in the array values.
   * 
   * @param max holds the currently biggest number.
   * @return the biggest value in the array
   */
  public int deterMax (int [] number)
  {
    int max = 0;
    for (int x = 0; x < number.length; x++)
    {
      if (number [x] > max)
      {
        max = number [x];
      }
    }
    return max;
  }
  
  /**
   * Draws the graph, the title of the graph, and the legend.
   * 
   * @param string displays the genres
   * @param g points to the Graphics class
   * @param g2d points to the Graphics2D class
   * @param scale stores by how many pixels the data should multiply to get the height of the bar
   * @param title creates a new JLabel for the title
   */
  public void paintComponent(Graphics g) 
  {
    super.paintComponent(g);
    String string = "";
    Graphics2D g2d = (Graphics2D) g;
    double scale = 300/deterMax (values);
    

    
      g2d.drawLine(150, 400, 150, 100);
      g2d.drawLine(150, 400, 650, 400);
      for (int x = 0; x < 11; x++)
      {
        if (x == 0)
        {
          g2d.setColor (Color.red);
          string = "Action";
        }
        else if (x == 1)
        {
          g2d.setColor (Color.orange);
          string = "Historical";
        }
        else if (x == 2)
        {
          g2d.setColor (Color.yellow);
          string = "Horror";
        }
        else if (x == 3)
        {
          g2d.setColor (Color.green);
          string = "Humour";
        }
        else if (x == 4)
        {
          g2d.setColor (Color.cyan);
          string = "Kids";
        }
        else if (x == 5)
        {
          g2d.setColor (Color.blue);
          string = "Mystery";
        }
        else if (x == 6)
        {
          g2d.setColor (Color.magenta);
          string = "Romance";
        }
        else if (x == 7)
        {
          g2d.setColor (Color.pink);
          string = "Sci-fi/Fantasy";
        }
        else if (x == 8)
        {
          g2d.setColor (Color.white);
          string = "Supernatural";
        }
        else if (x == 9)
        {
          g2d.setColor (Color.lightGray);
          string = "Young Adult";
        }
        else if (x == 10)
        {
          g2d.setColor (Color.darkGray);
          string = "Other";
        }
        g2d.fillRect (160 + 35 * x, 400 - (int)(values [x] * scale), 25, (int)(values [x] * scale));
        g2d.fillRect (20, 120 + x * 25, 20, 20);
        g2d.setColor (Color.black);
        g2d.drawString (String.valueOf (values [x]), 160 + 35 * x, 395 - (int)(values [x] * scale));
        g2d.drawString (string, 45, 137 + x * 25);
      }
      
    
  }
}
