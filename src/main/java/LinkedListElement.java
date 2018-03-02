

public class LinkedListElement<D> {

    private Element<D> data;

    private Element<D> head;
    private Element<D> tail;

    private int length = 0;

    public LinkedListElement(Element data) {
        this.data = data;
        this.head = this.data;
        this.tail = this.data;
        this.length = 1;
    }

    public LinkedListElement(D data) {
        this.data = new Element<D>(data);
        this.length = 1;
    }

    // go function
    private Element goToHead() {
        Element tmp = this.data;
        while (tmp.getPrev() != null) {
            tmp = tmp.getPrev();
        }
        return tmp;
    }

    private Element goToTail() {
        Element tmp = this.data;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    private Element goToIndex(int index) {
        Element tmp = this.data;
        if (tmp.getIndex() == index) {
            return tmp;
        } else if (tmp.getIndex() > index) {
            while (tmp != null) {
                if (tmp.getIndex() == index) {
                    return tmp;
                }
                tmp = tmp.getPrev();
            }
        } else if (tmp.getIndex() < index) {
            while (tmp != null) {
                if (tmp.getIndex() == index) {
                    return tmp;
                }
                tmp = tmp.getNext();
            }
        }
        return null;
    }

    private void reloadIndex() {
        Element<D> tmp = this.head;
        int index = 0;
        tmp.setIndex(0);
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            tmp.setIndex(++index);
        }
        this.length = index;
    }

    private void reloadIndex(int index) {
        Element<D> tmp = goToIndex(index);
        tmp.setIndex(index);
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            tmp.setIndex(++index);
        }
        this.length = index;
    }

    // Add element
    public Boolean addHead(Element<D> data) {
        Element<D> oldHead = this.head;
        oldHead.setPrev(data);
        this.head = data;
        this.length++;
        reloadIndex();
        return true;
    }

    /*public Boolean addHead(LinkedList<D> L){
        LinkedList<D> Head = this.goToHead();
        Head.prev = L;
        L.setNext(Head);
        return true;
    }*/

    public Boolean addTail(Element<D> data) {
        Element<D> oldTail = this.tail;
        oldTail.setNext(data);
        this.tail = data;
        this.length++;
        data.setIndex(length);
        return true;
    }

    /*public Boolean addTail(LinkedList<D> L){
        LinkedList<D> Tail = this.goToTail();
        Tail.next = L;
        L.setPrev(Tail);
        return true;
    }*/

    public Boolean addToPosition(Element<D> data, int index) {
        Element<D> oldIndex = goToIndex(index);
        data.setNext(oldIndex.getNext());
        data.setPrev(oldIndex);
        oldIndex.setNext(data);
        return true;
    }

    // Del element
    public Boolean deleteIndex(int index) {
        Element<D> tmp = goToIndex(index);
        if (tmp == null) {
            return false;
        }
        tmp.getPrev().setNext(tmp.getNext());
        tmp.getNext().setPrev(tmp.getPrev());
        return true;
    }

    public Boolean deleteElementsEqual(D data) {
        Element<D> tmp = this.goToHead();
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
    public Element<D> getHead() {
        return (this.goToHead());
    }

    public Element<D> getHeadData() {
        return (this.head);
    }

    public Element<D> getTail() {
        return (this.goToTail());
    }

    public Element<D> getTailData() {
        return (this.tail);
    }

    public Element<D> getPosition(int index) {
        return (this.goToIndex(index));
    }

    // find equals
    public int getIndexFirstEqual(D data) {
        Element<D> tmp = this.head;
        int index = 0;
        while (tmp.getData().equals(data) == false && tmp.getNext() != null) {
            tmp = tmp.getNext();
            index++;
        }
        return index;
    }

    public int getIndexLastEqual(D data) {
        Element<D> tmp = this.goToHead();
        int iterator = 0;
        int index = 0;
        while (tmp.getNext() != null) {
            if (tmp.getData().equals(data)) {
                index = iterator;
            }
            iterator++;
            tmp = tmp.getNext();
        }
        return index;
    }

    //
    public int getNumberOfElement() {
        Element<D> tmp = this.head;
        int index = 0;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            index++;
        }
        return index;
    }
}
