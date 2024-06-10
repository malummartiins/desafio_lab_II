package etapa_4;

public class Node<T> {
   private T data;    
   private Node nextNode;
   private Node previousNode;

   public Node( T element ) { 
      this( element, null ); 
   }

   public Node( T element, Node node ) {
      data = element;    
      nextNode = node;  
   }

   public T getData()  { return data; }
   
   public void setData (T element){
       data = element;
   }

   public Node getNext() { return nextNode; }
   
   public void setNext(Node n) { 
      nextNode = n; 
   }

   public Node getPrevious() { return previousNode; }
   
   public void setPrevious(Node n) { 
      previousNode = n; 
   }
} 
