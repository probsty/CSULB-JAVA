package linkedList;

import java.util.NoSuchElementException;
import java.util.Stack;

public class LLIter implements Iterator {
    LinkedList.Node m_head;
    LinkedList m_linkedList;						//The Linked List that we're servicing
    Stack <LinkedList.Node> m_stackOfNode = new Stack <>();

    /**
     * The constructor might be able to get along with just the ll parameter
     * (that's short for Linked List by the way), but then I would have had
     * to have a getter for the Linked List for the head.  That would have
     * broken the encapsulation of the linked list.  The head that we pass
     * in is just a pointer to the first node (if any) of the linked list,
     * not the pointer to the pointer to the head of the linked list, so changing
     * the passed in head is not going to change the head in the linked list.
     *
     * We could have made LLIter a nested class under LinkedList, but the book
     * chose to do it this way, with an independent class, and I wanted to
     * mimic the book's approach as best as I could.
     * @param ll	The LinkedList that we are iterating over.
     * @param head	A reference to the head of that linked list.
     */
    public LLIter (LinkedList ll, LinkedList.Node head) {
        this.m_head = head;				//Start the iterator off at the front of the LinkedList.
        this.m_linkedList = ll;
    }

    @Override
    public String next() {
        if (! this.hasNext()) {
            throw new NoSuchElementException ("Call hasNext first.  No next!");
        } else {
            String result = m_head.getValue();
            m_stackOfNode.push(m_head);
            m_head = m_head.getNext();
            return result;
        }
    }

    @Override
    public String previous() {
        if (! this.hasPrevious()) {
            throw new NoSuchElementException ("Call hasPrevious first.  No previous!");
        } else {
            LinkedList.Node previous = m_stackOfNode.pop();
            this.m_head = previous;
            return previous.getValue();
        }
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (this.m_head != null) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean hasPrevious() {
        return (m_stackOfNode.size() > 0);
    }

    @Override
    public void insert(String value) {
        if (this.m_stackOfNode.size() > 0) {						//We are in the middle of the list
            LinkedList.Node newNode = new LinkedList.Node(value, null);
            m_stackOfNode.peek().setNext(newNode);
            newNode.setNext(this.m_head);
            this.m_stackOfNode.push(newNode);						//Pretend that we iterated past this new node
        } else {
            this.m_linkedList.front(value);
            this.m_stackOfNode.push(this.m_linkedList.head);					//Pretend that we iterated past this new head
        }
    }

    @Override
    public void delete() {
        if (this.m_stackOfNode.size() > 0) {
            LinkedList.Node tmpDeleted = m_stackOfNode.peek();
            m_stackOfNode.pop();
            if (!m_stackOfNode.empty()) {
                m_stackOfNode.peek().setNext(tmpDeleted.getNext());
            } else {
                this.m_linkedList.head = tmpDeleted.getNext();
            }
        }
    }
}