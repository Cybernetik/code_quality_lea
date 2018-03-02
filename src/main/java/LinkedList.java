
public class LinkedList<D> {

    private D data;
    private int iterator;

    private LinkedList<D> prev;
    private LinkedList<D> next;

    public LinkedList(D data) {
        this.data = data;
        this.next = null;
        this.prev = null;
        this.iterator = 0;
    }

    // go function
    private LinkedList<D> goToHead() {
        LinkedList<D> tmp = this;
        while (tmp.getPrev() != null) {
            tmp = tmp.getPrev();
        }
        return tmp;
    }

    private LinkedList<D> goToTail() {
        LinkedList<D> tmp = this;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    private LinkedList<D> goToIndex(int index) {
        LinkedList<D> tmp = this.goToHead();
        while (index > 0) {
            if (tmp.getNext() == null) {
                return null;
            }
            tmp = tmp.getNext();
            index--;
        }
        return tmp;
    }

    private LinkedList<D> goToIndexIterator(int index) {
        LinkedList<D> tmp = this;
        if (index == this.iterator) {
            return tmp;
        } else if (index < this.iterator) {
            while (tmp != null) {
                if (tmp.iterator == index) {
                    return tmp;
                }
                tmp = tmp.getPrev();
            }
        } else if (index > this.iterator) {
            while (tmp != null) {
                if (tmp.iterator == index) {
                    return tmp;
                }
                tmp = tmp.getNext();
            }
        }
        return null;
    }

    // set get var
    public void setData(D data) {
        this.data = data;
    }

    public D getData() {
        return (this.data);
    }

    public int getIterator() {
        return this.iterator;
    }

    public void setNext(LinkedList<D> element) {
        this.next = element;
        //        L.incIterator();
    }

    public LinkedList<D> getNext() {
        return this.next;
    }

    public void setPrev(LinkedList<D> element) {
        this.prev = element;
        //        this.descIterator();
    }

    public LinkedList<D> getPrev() {
        return this.prev;
    }

    // Add element
    public Boolean addHead(D data) {
        LinkedList<D> head = this.goToHead();
        head.prev = new LinkedList<D>(data);
        head.prev.setNext(head);
        return true;
    }

    public Boolean addHead(LinkedList<D> element) {
        LinkedList<D> head = this.goToHead();
        head.prev = element;
        element.setNext(head);
        return true;
    }

    public Boolean addTail(D data) {
        LinkedList<D> tail = this.goToTail();
        tail.next = new LinkedList<D>(data);
        tail.next.setPrev(tail);
        return true;
    }

    public Boolean addTail(LinkedList<D> element) {
        LinkedList<D> tail = this.goToTail();
        tail.next = element;
        element.setPrev(tail);
        return true;
    }

    public Boolean addToPosition(D data, int index) {
        LinkedList<D> tmp = this.goToHead();
        while (index > 0) {
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
    public Boolean deleteIndex(int index) {
        LinkedList<D> tmp = this.goToIndex(index);
        if (tmp == null) {
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
    public LinkedList<D> getHead() {
        return (this.goToHead());
    }

    public D getHeadData() {
        return (this.goToHead().getData());
    }

    public LinkedList<D> getTail() {
        return (this.goToTail());
    }

    public D getTailData() {
        return (this.goToTail().getData());
    }

    public D getPosition(int index) {
        return (this.goToIndex(index).getData());
    }

    // find equals
    public int getIndexFirstEqual(D data) {
        LinkedList<D> tmp = this.goToHead();
        int index = 0;
        while (tmp.getData().equals(data) == false && tmp.getNext() != null) {
            tmp = tmp.getNext();
            index++;
        }
        return index;
    }

    public int getIndexLastEqual(D data) {
        LinkedList<D> tmp = this.goToHead();
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
        LinkedList<D> tmp = this.goToHead();
        int index = 0;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            index++;
        }
        return index;
    }
}
