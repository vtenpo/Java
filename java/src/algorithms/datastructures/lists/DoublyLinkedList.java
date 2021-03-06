package algorithms.datastructures.lists;
public class DoublyLinkedList {
    private class Link {
        public int data; 
        public Link next;
        public Link previous; 
    
        public Link(int value) {
            data = value; 
        }
    
        public void displayLink() {
            System.out.print(data + " ");
        }
    }

    private Link first;               // ref to first item
    private Link last;                // ref to last item

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() { 
        return first == null; 
    }

    /* Insert at front of list */
    public void insertFirst(int dd) {
        Link newLink = new Link(dd);    // make new link

        if (isEmpty()) {                // if empty list,
            last = newLink;             // newLink <-- last
        } else {
            first.previous = newLink;   // newLink <-- old first
        }
        newLink.next = first;           // newLink --> old first
        first = newLink;                // first --> newLink
    }

    public void insertLast(int dd) {
        Link newLink = new Link(dd);    // make new link

        if (isEmpty()) {                // if empty list,
            first = newLink;            // first --> newLink
        } else {
            last.next = newLink;        // old last --> newLink
            newLink.previous = last;    // old last <-- newLink
        }    
        last = newLink;                 // newLink <-- last
    }

    public Link deleteFirst() {
        Link temp = first;

        if (first.next == null) {       // if only one item
            last = null;                // null <-- last
        } else {
            first.next.previous = null; // null <-- old next
        }
        first = first.next;             // first --> old next
        
        return temp;
    }

    public Link deleteLast() {
        Link temp = last;

        if (first.next == null) {       // if only one item
            first = null;               // first --> null
        } else {
            last.previous.next = null;  // old previous --> null
        }
        last = last.previous;           // old previous <-- last
    
        return temp;
    }

    /* Insert dd just after key */
    public boolean insertAfter(int key, int dd) {
        Link current = first;           // start at beginning

        while (current.data != key) {
            current = current.next;     // move to next link

            if (current == null) {
                return false;           // didn't find it
            }
        }
        
        Link newLink = new Link(dd);     // make new link

        if (current == last) {           // if last link,
            newLink.next = null;         // newLink --> null
            last = newLink;              // newLink <-- last
        } else {                         // not last link,
            newLink.next = current.next; // newLink --> old next
            // newLink <-- old next
            current.next.previous = newLink;
        }
        newLink.previous = current; // old current <-- newLink
        current.next = newLink;     // old current --> newLink
        
        return true;
    }

    public Link deleteKey(int key) {  
        Link current = first;           // start at beginning
        
        while (current.data != key) {   // until match is found,
            current = current.next;     // move to next link
            
            if (current == null) {
                return null;            // didn't find it
            }
        }

        if (current == first) {         // found it; first item?
            first = current.next;       // first --> old next
        } else {                        // not first
            // old previous --> old next
            current.previous.next = current.next;
        }

        if (current == last) {          // last item?
            last = current.previous;    // old previous <-- last
        } else {                        // not last
            // old previous <-- old next
            current.next.previous = current.previous;
        }
    
        return current;
    }

    public void displayForward() {
        System.out.print("List (first --> last): ");
        Link current = first;           // start at beginning
    
        while (current != null) {       // until end of list,
            current.displayLink();      // display data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }

    public void displayBackward() {
        System.out.print("List (last --> first): ");
        Link current = last;            // start at end

        while (current != null) {       // until start of list,
            current.displayLink();      // display data
            current = current.previous; // move to previous link
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        DoublyLinkedList theList = new DoublyLinkedList();

        theList.insertFirst(22);      // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);       // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward();     // display list forward
        theList.displayBackward();    // display list backward

        theList.deleteFirst();        // delete first item
        theList.deleteLast();         // delete last item
        theList.deleteKey(11);        // delete item with key 11

        theList.displayForward();     // display list forward

        theList.insertAfter(22, 77);  // insert 77 after 22
        theList.insertAfter(33, 88);  // insert 88 after 33

        theList.displayForward();     // display list forward
    }
}