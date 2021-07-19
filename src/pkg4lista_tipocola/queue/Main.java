
package pkg4lista_tipocola.queue;

import javax.swing.JOptionPane;

public class Main {

    static Queue aux = new Queue();
    static Queue q = new Queue();
    
    public static void main(String[] args) {
        
      int usercode, numberp, numberc;
      String opt;
      String menu[] = {"Add", "Update","Print", "Total", "Size", "Exit"};
      
      do{
          opt =(String)JOptionPane.showInputDialog(null, "Selected option", 
                  "Main menu", 1, null, menu, menu[0]);
          switch(opt)
          {
              case "Add":
                  usercode = Integer.parseInt(JOptionPane.showInputDialog("Enter usercode"));
                  numberp = (int)(Math.random()*50);
                  numberc = (int)(Math.random()*10);
                  PrintOrder po = new PrintOrder(usercode, numberp, numberc);
                  q.Enqueue(po);
                  
                  JOptionPane.showMessageDialog(null,"Created printOrder: " + po.toString());
                  break;
                  
              case "Update":
                  usercode = Integer.parseInt(JOptionPane.showInputDialog("Enter usercode"));
                  Update(usercode);
                  break;
                  
              case "Print":
                  JOptionPane.showMessageDialog(null,Print(), "Print",3);
                  break;
                  
              case "Total":
                  JOptionPane.showMessageDialog(null,"the total of pages is: "+Total(), "",1);
                  break;
                  
              case "Size":
                  int size;
                  size = q.Size();
                  JOptionPane.showMessageDialog(null,"Size: " + size);
                  
                  break;
          }
      }while(!opt.equals("Exit"));
      
    }
    
    public static void Update (int userc)
    {
        //recorremos la cola, sacamos el elemento y preguntamos si coincide el codigo
        PrintOrder po;
        String res;
        int number;
        
        while(!q.isEmpty())
        {
            po = (PrintOrder)q.Dequeue();
            if(po.getUsercode()==userc)
            {
                res = JOptionPane.showInputDialog("Update copies of: " + po.toString() + "(YES/NO)");
                if(res.equalsIgnoreCase("yes")){ //InnoreCase ignora minusculas y mayusculas
                     number=Integer.parseInt(JOptionPane.showInputDialog("Enter number of copies"));
                     po.setNumbercopy(number);
                     JOptionPane.showMessageDialog(null,"updated printOrder");
                }                 
            }
            aux.Enqueue(po);
        } //retomamos
        while(!aux.isEmpty())
            q.Enqueue(aux.Dequeue());
    }
    

    public static String Print()
    {
        String text="";
        PrintOrder po;
        while(!q.isEmpty())
        {
            po=(PrintOrder)q.Dequeue();
            text = text + po.toString() + "\n";
            aux.Enqueue(po);
        }
        while(!aux.isEmpty())
            q.Enqueue(aux.Dequeue());
        
        return text;
    }
    
    public static int Total()
    {
        int total=0;
        PrintOrder po;
        while(!q.isEmpty())           
            aux.Enqueue(q.Dequeue());
        
        while(!aux.isEmpty())
        {
            po=(PrintOrder)aux.Dequeue();
            total = total + po.getNumbercopy()*po.getNumberpag();
            q.Enqueue(po);
        }
        return total;
        
    }
}