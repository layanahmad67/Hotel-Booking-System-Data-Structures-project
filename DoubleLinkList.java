
package project;


public class DoubleLinkList <E>{
    
    public class DNode<E> {
    protected E element;
    protected DNode<E> next, prev;
    
    public DNode(E e,  DNode next,DNode prev) {
        element = e;
        this.next = next;
        this.prev = prev;
    }
    public E getElement() { return element; }
    public DNode<E> getNext() { return next; }
    public DNode<E> getPrev() { return prev; }
    public void setElement(E newElement) { element = newElement; }
    public void setNext(DNode newNext) { next = newNext; }
    public void setPrev(DNode newPrev) { prev = newPrev; } 
    } 
    //------------------------------------------------------- end of DNode class
    
    
    protected DNode<E> header;
    protected DNode<E> trailer;
    protected int size;
    
    // constructs a new Empty list..
    public DoubleLinkList() {
        header = new DNode<E>(null, null, null);
        trailer = new DNode(null, null, null);
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }
    public int size(){return size;}
    public boolean isEmpty(){ return size==0;}
     
    public E First(){
        if(isEmpty())
            return null;
        return header.getNext().getElement();
    }

     public E Last(){
        if(isEmpty())
            return null;
        return trailer.getPrev().getElement();
    }
    public void addFirst(E e) { addBetween(e,header,header.getNext());   }
    public void addLast (E e) { addBetween(e,trailer.getPrev(),trailer); }
    
    public void addBetween(E e, DNode<E>predecessor, DNode<E>sucessor){
        DNode<E> newNode= new DNode(e,sucessor,predecessor);
        predecessor.setNext(newNode);
        sucessor.setPrev(newNode);
        size++;
    }

    public E remove(DNode<E> Node){
       DNode<E> pre=Node.getPrev();
       DNode<E> post=Node.getNext();
       pre.setNext(post);
       post.setPrev(pre);
       size--;
       return Node.getElement();
    }

    public E removeFirst(){
        if(this.isEmpty())
            return null;
        return this.remove(header.getNext());
    }

    public E removeLast(){
        if(this.isEmpty())
            return null;
        return this.remove(trailer.getPrev());
    }
  
    public void addGuest(Guest guest) {
        addLast((E) guest);
    }

    public Guest findGuest(int guestID) {
        DNode<E> current = header.getNext();
        while (current != trailer) {
            Guest guest = (Guest) current.getElement();
            if (guest.getId() == guestID) {
                return guest;
            }
            current = current.getNext();
        }
        return null;
    }

    public void removeGuest(int guestID) {
        DNode<E> current = header.getNext();
        while (current != trailer) {
            Guest guest = (Guest) current.getElement();
            if (guest.getId() == guestID) { // Corrected comparison
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                size--;
                System.out.println("Guest " + guestID + " has been removed.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Guest not found.");
    }

    public void updateGuestInfo(int guestID, String newPhoneNumber) {
        Guest guest = findGuest(guestID);
        if (guest != null) {
            guest.setPhone(newPhoneNumber);
            System.out.println("Guest information updated successfully.");
        } else {
            System.out.println("Guest not found.");
        }
    }

    public void printAllGuests() {
        DNode<E> current = header.getNext();
        if (isEmpty()) {
            System.out.println("No guests in the list.");
            return;
        }
        while (current != trailer) {
            Guest guest = (Guest) current.getElement();
            guest.displayGuest();
            current = current.getNext();
        }
    }

}// End Double Linked List Class

