package Lists;

public class MyReverseInterview {

    public static class Link {
        public Object data = null;
        public Link next = null;

        public Link(Integer data) {
            this.data = data;
        }
    }


    public Link reverse(Link head) {
        return reverseLoop(head);
    }

    private Link reverseLoop(Link curr) {
        if (curr == null) {
            return null;
        }

        if (curr.next != null) {
            Link switched = reverseLoop(curr.next);
            switched.next = curr;
            curr.next = null;
        }

        return curr;
    }

    public static void printList(Link list) {
        Link link = list;
        while (link != null) {
            System.out.print(link.data + " ");
            link = link.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        MyReverseInterview mri = new MyReverseInterview();

        Link list = new Link(3);
        list.next = new Link(4);
        list.next.next = new Link(5);

        printList(list);

        Link revList = mri.reverse(list);

        printList(revList);
    }
}
