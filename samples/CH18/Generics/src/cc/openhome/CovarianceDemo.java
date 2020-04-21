package cc.openhome;

public class CovarianceDemo {
    public static void main(String[] args) {
        var apple1 = new Node<>(new Apple(), null);
        var apple2 = new Node<>(new Apple(), apple1);
        var apple3 = new Node<>(new Apple(), apple2);
        
        var banana1 = new Node<>(new Banana(), null);
        var banana2 = new Node<>(new Banana(), banana1);

        show(apple3);
        show(banana2);
    }
    
    public static void show(Node<? extends Fruit> n) { 
        Node<? extends Fruit> node = n;
        do {
            System.out.println(node.value);
            node = node.next;
        } while(node != null);
    }
} 
