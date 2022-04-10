package algorithms.datastructures.lists;

public class LinkedList {
    private Link first; // ref to first on list

    public void LinkList() {
        first = null;
    }

    public void insertFirst(int value) {
        Link newLink = new Link(value);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link find(int key) {
        Link current = first;
        
        while (current.data != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }

        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;

        while (current.data != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current; // go to next link
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

        return current;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        System.out.print("List (first --> last): ");
        Link current = first; // start at beginning of list
       
        while (current != null) {
            current.displayLink();  // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkedList theList = new LinkedList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertFirst(88);

        theList.displayList(); 

        Link f = theList.find(44);
        if (f != null) {
            System.out.println("Found link with key " + f.data);
        } else {
            System.out.println("Can't find link");
        }

        /* Link d = theList.delete(66);
        if (d != null) {
            System.out.println("Deleted link with key " + d.iData);
        } else {
            System.out.println("Can't delete link");
        }

        /* while (!theList.isEmpty()) {
            Link aLink = theList.deleteFirst();
            System.out.println("Deleted ");
            aLink.displayLink();
            System.err.println("");
        }
        
        theList.displayList(); */
    }
}