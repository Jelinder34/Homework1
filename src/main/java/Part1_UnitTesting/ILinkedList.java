package Part1_UnitTesting;

public class ILinkedList<T> implements ILinkedListInterface<T> {

    private ILinkedList<T> head;
    private T data;

    public ILinkedList(){}

    public ILinkedList(T value){
        this.data = value;
    }

    @Override
    public ILinkedList<T> next(){
        return this.head;
    }//The next element in the list.

    @Override
    public ILinkedList<T> last(){
        ILinkedList<T> temp = this;
        while(temp.next() != null)
            temp = temp.next();
        return temp;
    }//The last element in the list.

    @Override
    public ILinkedList<T> after(int n){
        ILinkedList<T> temp = this;
        for(int i = 0; i < n; i++){
            temp = temp.next();
        }//End for loop.
        return temp;
    }//Get the element n elements down the list.

    public ILinkedList<T> detach(){
        ILinkedList<T> temp = this.head;
        this.head = null;
        return temp;
    }//Removes the next element and returns the previously next element.

    public T get(){
        return this.data;
    }//Gets the current value.

    public void set(T value){
        this.data = value;
    }//Sets the value of this node.

    @Override
    public void setNext(ILinkedList<T> next){
        this.head = next;
    }//Sets the next element in the list.

    @Override
    public void append(ILinkedList<T> next){
        ILinkedList<T> temp = this;
        temp = temp.last();
        temp.head = next;
    }//Sets the next element after this current element.

    @Override
    public void insert (ILinkedList<T> newFirst){
        ILinkedList<T> temp = new ILinkedList<>(this.data);
        temp.setNext(this.head);
        this.data = newFirst.get();
        this.head = temp;
    }//Adds the current list as the next of newFirst.

}
