
package pkg4lista_tipocola.queue;


public class PrintOrder {
    
    private int usercode;
    private int numbercopy;
    private int numberpag;

    public PrintOrder(int usercode, int numberpag) {
        
        this.usercode = usercode;
        this.numberpag = numberpag;
        numbercopy = 1;
    }

    public PrintOrder(int usercode, int numbercopy, int numberpag) {
        this.usercode = usercode;
        this.numbercopy = numbercopy;
        this.numberpag = numberpag;
    }

    public int getUsercode() {
        return usercode;
    }

    public void setUsercode(int usercode) {
        this.usercode = usercode;
    }

    public int getNumbercopy() {
        return numbercopy;
    }

    public void setNumbercopy(int numbercopy) {
        this.numbercopy = numbercopy;
    }

    public int getNumberpag() {
        return numberpag;
    }

    public void setNumberpag(int numberpag) {
        this.numberpag = numberpag;
    }

    @Override
    public String toString() {
        return "PrintOrder{" + "usercode=" + usercode + ", numbercopy=" + numbercopy + ", numberpag=" + numberpag + '}';
    }
    
    
    
    
}
