/**
 *
 * @author Jesus Ivan
 */ 
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class Burbuja3 {
    static int Lista [];            
    static Panel p1;
    
       static class Panel extends Frame{
        public Panel(int Lista[]){        
            super("Viruz Blog: Burbuja Ordenada");
            setSize(300,300);
            setBackground(Color.WHITE);
            setLayout(new GridLayout(Lista.length,1));
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(false);
            
            addWindowListener(new WindowAdapter(){
                //evitará,que sobrecarguemos accidentalmente un método
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        }
    }
       
    static class Arreglo{ 

        public void push(){               
            String introduce, cantidad = JOptionPane.showInputDialog(null,"¿Cuantos numeros quiere ordenar de menor a mayor?");        
            int pos = 0, num, y = 0, x = Integer.parseInt(cantidad);
            Lista = new int[x];        
            p1 = new Panel(Lista);        
            p1.setVisible(true);
            
            while(y < x){
                introduce = JOptionPane.showInputDialog("Introduzca numeros enteros "+(y+1));                
                num = Integer.parseInt(introduce);                                
                Lista[pos]=num;
                p1.add(new Label(""+Lista[pos]));                        
                pos++;                               
                y++;            
            }
            
            p1.setVisible(true);        
            JOptionPane.showMessageDialog(null,"Los numeros introducidos fueron"+" "+y);        
        }      
    }
    
    public static void ordenar(int[] arreglo) {              
        int var = 0;
        for (int i = 0; i < arreglo.length; i++) {            
            for (int j = 0; j < arreglo.length - 1; j++) {                
                if (arreglo[j] > arreglo[j + 1]) {
                    p1.removeAll();                    
                    int temp = arreglo[j];
                    arreglo[j]  = arreglo[j+1];
                    arreglo[j+1] = temp;                    
                    p1.setVisible(false);
                    for(int e=0;e<arreglo.length;){             
                        p1.add(new Label(""+arreglo[e]));
                        e++;                               
                    }
                    var++;
                    p1.setVisible(true);                    
                    JOptionPane.showMessageDialog(null,"Cambiar numero "+var);
                }
            }
        }
        JOptionPane.showMessageDialog(null,"Los numeros estan en ordenados de menor a mayor");
    }    
   public static void  main (String args[]) {        
        Arreglo a1 = new Arreglo();
        a1.push();
        ordenar(Lista);
    }
}
