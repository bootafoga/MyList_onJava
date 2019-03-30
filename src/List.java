public class List<T>{
    private class Node<T> {
        Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        private T value;
        private Node<T> next;
        private Node<T> prev;
    }

    public void pushBack(T value){
        if (first == null){
            first = new Node<T>(value);
            last = first;
        } else {
            last.next = new Node<T>(value);
            last.next.prev = last;
            last = last.next;
        }
        size++;
    }

    public void pushFront(T value){
        if (first == null){
            first = new Node<T>(value);
            last = first;
        } else {
            Node<T> newEl = new Node<>(value);
            newEl.next = first;
            first.prev = newEl;
            first = newEl;
        }
        size++;
    }

    public void popBack(){
        if (first == null) throw new IllegalArgumentException();

        Node<T> curr = last;

        curr.prev.next = null;
        last = curr.prev;

        size--;
    }

    public void popFront(){
        if (first == null) throw new IllegalArgumentException();

        Node<T> curr = first;

        curr.next.prev = null;
        first = curr.next;

        size--;
    }

    public Node<T> find (int index){
        if (index > size || index < 0 || size == 0) throw new IllegalArgumentException();

        int count = 0;
        Node<T> curr = first;

        while (index != count){
            curr = curr.next;
            count++;
        }

        return curr;
    }

    public void insert(T value, int index){
        Node<T> curr = find(index);

        if (curr == first) pushFront(value);
        else if (curr == last) pushBack(value);
        else {
            Node<T> newEl = new Node<>(value);

            newEl.prev = curr;
            newEl.next = curr.next;

            curr.next.prev = newEl;
            curr.next = newEl;
        }
    }

   public T getValueAt(int index){
        return find(index).value;
   }

    public void remove(int index){
        Node<T> curr = find(index);

        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;

        size--;
    }

    public int getSize() { return size; }

    public void clear(){
        first = null;
        last = null;
        size = 0;
    }

    public void set(T value, int index){
        Node<T> curr = find(index);
        curr.value = value;
    }

    public boolean isEmpty() {
        return ((size == 0) && (first == null));
    }

    public void showList(){
        Node<T> curr = first;

        while (curr != null){
            System.out.print(curr.value + " ");
            curr = curr.next;
        }

        System.out.println();

//      curr = last;
//      while (curr != null){
//          System.out.print(curr.value + " ");
//          curr = curr.prev;
//      }
    }

    private int size = 0;
    private Node<T> first;
    private Node<T> last;
}
