public class MyList<T> {

    public Link<T> head = null;


    public static class Link<T> {
        public T data = null;
        public Link<T> next = null;

        public Link() {

        }

        public Link(T data) {
            this.data = data;
        }
    }

    public void insert(T t) {
        Link<T> newLink = new Link<T>(t);
        if (this.head != null) {
            newLink.next = this.head;
        }
        this.head = newLink;
    }

    public void reverse() {
        Link<T> last = new Link<T>();
        Link<T> first = reverseLoop(this.head, last);
        first.next = null;
        this.head = last.next;
    }

    private Link<T> reverseLoop(Link<T> curr, Link<T> last) {
        if (curr == null || curr.next == null) {
            if (curr.next == null) {
                last.next = curr;
            }
            return curr;
        }

        Link<T> switched = reverseLoop(curr.next, last);
        switched.next = curr;
        return switched;
    }

    public void print() {
        Link<T> link = this.head;
        while (link != null) {
            System.out.print(link.data + " ");
            link = link.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        MyList<Integer> ml = new MyList<Integer>();

//		Link list = new Link(3L);
//		list.next = new Link(4L);
//		list.next.next = new Link(5L);

        ml.insert(1);
        ml.insert(2);
        ml.insert(3);

        ml.print();

        ml.reverse();

        ml.print();
    }

}