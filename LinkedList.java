package code_quality_lea;

public class LinkedList<D> {

    private D data;
    private int iterator;

    private LinkedList<D> prev;
    private LinkedList<D> next;

    public LinkedList(D data){
        this.data = data;
        this.next = null;
        this.prev = null;
        this.iterator = 0;
    }

    public LinkedList(D data, int it){
        this.data = data;
        this.next = null;
        this.prev = null;
        this.iterator = it;
    }

    // go function
    private LinkedList<D> goToHead(){
        LinkedList<D> tmp = this.getPrev();
        while (tmp.getPrev() != null) {
            tmp = tmp.getPrev();
        }
        return tmp;
    }

    private LinkedList<D> goToTail(){
        LinkedList<D> tmp = this.getNext();
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    private LinkedList<D> goToIndex(int index){
        LinkedList<D> tmp = this.goToHead();
        while (index > 0){
            if (tmp.getNext() == null){
                return null;
            }
            tmp = tmp.getNext();
            index--;
        }
        return tmp;
    }

    // set get var
    public void setData(D data) {
        this.data = data;
    }

    public D getData() {
        return (this.data);
    }

    private void incIterator(){
        this.iterator++;
    }

    private void descIterator(){
        this.iterator--;
    }

    public int getIterator() {
        return this.iterator;
    }

    public void setNext(LinkedList<D> L){
        this.next = L;
//        L.incIterator();
    }

    public LinkedList<D> getNext() {
        return this.next;
    }

    public void setPrev(LinkedList<D> L){
        this.prev = L;
//        this.descIterator();
    }

    public LinkedList<D> getPrev() {
        return this.prev;
    }

    // Add element
    public Boolean addHead(D data){
        LinkedList<D> Head = this.goToHead();
        Head.prev = new LinkedList<D>(data);
        Head.prev.setNext(Head);
        return true;
    }

    public Boolean addTail(D data){
        LinkedList<D> Tail = this.goToTail();
        Tail.next = new LinkedList<D>(data);
        Tail.next.setPrev(Tail);
        return true;
    }

    public Boolean addToPosition(D data, int index){
        LinkedList<D> tmp = this.goToHead();
        while (index > 0){
            if (tmp.getNext() == null) {
                return false;
            }
            tmp = tmp.getNext();
            index--;
        }
        LinkedList<D> newElem = new LinkedList<D>(data);
        newElem.setNext(tmp.getNext());
        newElem.setPrev(tmp);
        tmp.setNext(newElem);
        return true;
    }

    // Del element
    public Boolean deleteIndex(int index){
        LinkedList<D> tmp = this.goToIndex(index);
        if (tmp == null){
            return false;
        }
        tmp.getPrev().setNext(tmp.getNext());
        tmp.getNext().setPrev(tmp.getPrev());
        return true;
    }

    public Boolean deleteElementsEqual(D data) {
        LinkedList<D> tmp = this.goToHead();
        int deletedItems = 0;
        while (tmp.getNext() != null) {
            if (tmp.getData().equals(data)) {
                tmp.getPrev().setNext(tmp.getNext());
                tmp.getNext().setPrev(tmp.getPrev());
                deletedItems++;
            }
            tmp = tmp.getNext();
        }
        if (deletedItems > 0) {
            return true;
        }
        return false;
    }

    // get data
    public D getHead(){
        return (this.goToHead().getData());
    }

    public D getTail(){
        return (this.goToTail().getData());
    }

    public D getPosition(int index){
        return(this.goToIndex(index).getData());
    }

    // find equals
    public int getIndexFirstEqual(D data){
        LinkedList<D> tmp = this.goToHead();
        int index = 0;
        while (tmp.getData().equals(data) == false && tmp.getNext() != null) {
            tmp = tmp.getNext();
            index++;
        }
        return index;
    }

    public int getIndexLastEqual(D data){
        LinkedList<D> tmp = this.goToHead();
        int iterator = 0;
        int index = 0;
        while (tmp.getNext() != null) {
            if (tmp.getData().equals(data)){
                index = iterator;
            }
            iterator++;
            tmp = tmp.getNext();
        }
        return index;
    }

    //
    public int getNumberOfElement(){
        LinkedList<D> tmp = this.goToHead();
        int index = 0;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            index++;
        }
        return index;
    }
}
