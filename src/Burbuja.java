/**
 *
 * @author Jesus Ivan
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Burbuja extends JFrame{
    private JLabel etiqueta,etiqueta5,etiqueta6;
    private JButton boton, boton2,boton3;
    private JLabel etiqueta3,etiqueta4;
    private Container contenedor;
    private JPanel pTamaño,pMostrar,pOrdenar;
    static int Lista [];
   
  public Burbuja(){
        super("Viruz Blog: Metodo de La Burbuja");
        setSize(550,230);
        setBackground(Color.gray);
        contenedor = getContentPane();
        addComponentes();
        addEventos();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
   static Panel p1;
    static class Panel extends Frame{
        public Panel(int Lista[]){        
            super("Viruz Blog: Burbuja Ordenada");
            setSize(310,250);
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

   public void addComponentes(){
            pOrdenar = new JPanel();
            pTamaño = new JPanel();
            pMostrar = new JPanel();
            
            pTamaño.setLayout(new FlowLayout());
            etiqueta = new JLabel("Tamaño del Vector  ");
            boton = new JButton("Introducir");
            
            //borde con título
            pTamaño.setBorder(new TitledBorder(": : Tamaño Vector : :"));
            //adición de componentes
            pTamaño.add(etiqueta);
            pTamaño.add(boton);
           
            //Segundo Panel
            pMostrar.setLayout(new FlowLayout());
            etiqueta3= new JLabel("Muestra tu Vector   ");
            boton2 = new JButton("Mostrar");
            etiqueta4= new JLabel();
            //borde con título
            pMostrar.setBorder(new TitledBorder(": : Muestra Vector : :"));
            
            pMostrar.add(etiqueta3);
            pMostrar.add(boton2);
            pMostrar.add(etiqueta4);
            
            //Tercer Panel
            pOrdenar.setLayout(new FlowLayout());
            etiqueta5= new JLabel("Ordenar Tu Vector   ");
            boton3 = new JButton("Ordenar");
            etiqueta6= new JLabel();
            //borde con título
            pOrdenar.setBorder(new TitledBorder(": : Ordena Vector : :"));
            
            pOrdenar.add(etiqueta5);
            pOrdenar.add(boton3);
            pOrdenar.add(etiqueta6);
            
            //adición de componentes a la ventana o contenedor.
            contenedor.add(pTamaño, BorderLayout.NORTH);
            contenedor.add(pMostrar);
            contenedor.add(pOrdenar, BorderLayout.SOUTH);
        }
    
  public void addEventos(){
        boton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String introduce,
                cantidad = JOptionPane.showInputDialog
                    (null,"¿Cuantos numeros quiere ordenar de menor a mayor?");
                
                int pos=0, y = 0, num, x = Integer.parseInt(cantidad);
                Lista = new int[x];
                p1 = new Panel(Lista);        
                
         //Este ciclo checa que y sea menor que la cantidad del vector     
           while(y < x){
    //Introducira los elementos y Y aumentara 1 cada ves que se introdusca un elemento
    //se guardar los elementos en la variable introduce.
    introduce = JOptionPane.showInputDialog("Introduzca numeros enteros "+(y+1));
          //aqui el String(introduce) pasara a Entero(num).
          num = Integer.parseInt(introduce);
          Lista[pos]=num;
          p1.add(new Label(""+Lista[pos])); 
          //Aumentamos pos y Y 1 posicion.
          pos++;                               
          y++;  
             } 
       JOptionPane.showMessageDialog(null,"Los numeros introducidos fueron"+" "+y);
           }
       });
        
        boton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              p1.setVisible(true);
              }
        });
        
        boton3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
              //Declaramos un arreglo que tendra los valores de Lista[].  
              int[] arreglo=Lista;           
              int var = 0;
               for (int i = 0; i < arreglo.length; i++) {            
                for (int j = 0; j < arreglo.length - 1; j++) {                
                if (arreglo[j] > arreglo[j + 1]) {
                    //Remueve Los Componentes del Panel.
                     p1.removeAll();
                    //Se hace el Cambio de Numeros
                    int temp = arreglo[j];
                    arreglo[j]  = arreglo[j+1];
                    arreglo[j+1] = temp;
                    
                   //Ciclo For para El Cambio del Label.
                    for(int e=0;e<arreglo.length;){
                        //Agregamos en el Label el cambio que se Hizo
                        p1.add(new Label(""+arreglo[e]));
                        e++;                               
                    }
                    var++;
                    p1.setVisible(true);                    
                    JOptionPane.showMessageDialog(null,"Cambiar numero "+var);
                }
            }
        }
        JOptionPane.showMessageDialog
                       (null,"Los numeros estan en ordenados de menor a mayor");
              }
        });
     }
}
 
