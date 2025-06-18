class MyStack {
   Queue<Integer> queue; // this is interface implementation done by linked list
   public MyStack() {
       queue = new LinkedList<>();
   }
   public void push(int x) {
       queue.add(x);
       int size = queue.size();
       for (int i = 0; i < size - 1; i++) {
           queue.add(queue.remove()); // remove from the front and add it back in rear so the queue will be reverse
       }
   }
   public int pop() {
       return queue.remove();
   }
   public int top() {
       return queue.peek(); // Use peek instead of remove for top
   }
   public boolean empty() {
       return queue.isEmpty();
   }
}