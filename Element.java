package code_quality_lea;

public class Element<D> {

    private D data;
    private int index;

    public Element next;
    public Element prev;

    public Element (D data){
        this.data = data;
        this.prev = null;
        this.next = null;
        this.index = -1;
    }

    public Element (D data, int index){
        this.data = data;
        this.prev = null;
        this.next = null;
        this.index = index;
    }

    // set get var
    public void setData(D data) {
        this.data = data;
    }

    public D getData() {
        return (this.data);
    }

    public void setIndex(int index){
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public void setNext(Element<D> L){
        this.next = L;
    }

    public Element<D> getNext() {
        return this.next;
    }

    public void setPrev(Element<D> L){
        this.prev = L;
    }

    public Element<D> getPrev() {
        return this.prev;
    }
}
