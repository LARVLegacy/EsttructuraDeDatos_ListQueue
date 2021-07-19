
package pkg4lista_tipocola.queue;

public class Node {
    
    private Object data;
    private Node link;

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node link) {
        this.data = data;
        this.link = link;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
    
    
}

