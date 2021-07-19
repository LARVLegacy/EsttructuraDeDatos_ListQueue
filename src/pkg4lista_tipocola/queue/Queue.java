
package pkg4lista_tipocola.queue;

public class Queue {
    
    private Node first; //primero
    private Node last; //ultimo

    public Queue() {  
        //first = null;
        //last = null;
    }
    
    public boolean isEmpty() //Esta vacia
    {
        return first == null && last == null;
    }
    
    public void Enqueue(Object data)  //guardar en la cola
    {
        if(isEmpty())
        {
            first = new Node(data);
            last = first;
        }
        else
        {
            Node n = new Node(data);
            last.setLink(n);
            last = n;
        }
    }
    
    public Object Dequeue() //Sacar de cola
    {
        Object data = null;
        if(!isEmpty())
        {
            data = first.getData();
            first = first.getLink();
            if(first==null)
                last = null;  //la lista queda vacia
        }
        return data;
    }
    
    public int Size(){
        
        int cont=0;
        Object data = null;
        
        while(!isEmpty())
        {
            data = first.getData();
            first = first.getLink();
            cont++;
            if(first==null)
                last = null;//la lista queda vacia
        }
        return cont;
    }
}
