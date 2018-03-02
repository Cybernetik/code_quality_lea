/*elem
        search elem in list (elem)
        first occurence
        last occurence
        tri elem
        main add elem list
*/

public class ListLinked {
  private Elem head;
  private int countElem;

  public ListLinked(Object el) {
    head = new Elem(el);
  }

  class Elem {
    private Object info;
    private Elem next;

    public Elem(Object myInfo) {
      info = myInfo;
    }

    public Object getInfo() {
      return info;
    }
  }

  /* COUNT
  */
  public int getCountElem() {
    return countElem;
  }

  /* ADD
   */
  public void addElemAtHead(Elem el) {
    Elem tmp = head;
    head = new Elem(el);
    head.next = tmp;
    countElem = countElem + 1;
  }

  public void addElemAtEnd(Elem el) {
    Elem tmp = head;
    while (tmp.next != null) {
      tmp = tmp.next;
    }
    tmp.next = new Elem(el);
    countElem = countElem + 1;
  }

  public void addElemAtPos(Elem el, int pos) {
    Elem tmp = head;
    Elem find;
    int it = 0;
    while (it < pos  - 1 && tmp.next != null) {
      tmp = tmp.next;
      it++;
    }
    find = tmp.next;
    tmp.next = new Elem(el);
    tmp.next.next = find;
    countElem = countElem + 1;
  }

  // DEL
  public void delElemAtPos(int pos) {
    if (!checkIfIsInRange(pos)) {
      return;
    }
    Elem tmp = head;
    int it = 0;
    while (it < pos - 1 && tmp.next != null) {
      tmp = tmp.next;
      it++;
    }
    if (tmp.next != null && tmp.next.next != null) {
      tmp.next = tmp.next.next;
    }
    countElem = countElem - 1;
  }

  public boolean checkIfIsInRange(int pos) {
    if ((0 <= pos) && (pos <= countElem)) {
      return true;
    }
    return false;
  }

  public void delElem(Elem toDelete) {
    Elem tmp = head;
    while (tmp != toDelete && tmp.next != null) {
      tmp = tmp.next;
    }
    if (tmp.next != null && tmp.next.next != null) {
      tmp.next = tmp.next.next;
      countElem = countElem - 1;
    }
  }

  // GET
  public Elem getElem(Elem toFind) {
    Elem el = head;
    int it = 0;
    while (el != toFind && el.next != null) {
      it++;
      el = el.next;
    }
    return (el);
  }

  public Elem getElemByPos(int pos) {
    Elem el = head;
    int it = 0;
    while (it < pos) {
      el = el.next;
      it++;
    }
    return (el);
  }
}