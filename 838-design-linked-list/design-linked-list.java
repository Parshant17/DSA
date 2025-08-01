class Node {
    int val;
    Node next;
    //constructor 
    Node(int val){
        this.val = val;
    }
}


class MyLinkedList
 {

 int size;
 Node head;
    public MyLinkedList() {
        size=0;
    }
    
    public int get(int index) {
        if(index<0 || index>=size){
            return -1;
        }
            Node temp = head;
            for(int i=0;i<index ;i++){
                temp=temp.next;
            }
            return temp.val;
        
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        size++;
        if(head==null){
            head = node;
        }else{
            node.next =head;
            head= node;
        }
    }
    
    public void addAtTail(int val) {
     Node node = new Node(val);
     if(head==null){
    
            head = node;
        }else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;    
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0 || index>size){
            return;
        }
        if(index==0){
            addAtHead(val);
        }else if(index== size){
             addAtTail(val);
        }
        else{
            Node node = new Node(val);
            Node temp = head;
            for(int i=0;i<index-1 ;i++){
             temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size){
            return;
        }
        if(head== null ){
            return;
        }
        if(index==0){
            head = head.next;
           
        }else{
            Node temp = head;
            for(int i=0;i<index-1 ; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
         size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */