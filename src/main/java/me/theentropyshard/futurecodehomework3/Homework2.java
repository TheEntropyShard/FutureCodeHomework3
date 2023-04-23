package me.theentropyshard.futurecodehomework3;

public class Homework2 {
    public static class MyLinkedList<E> {
        private class Node {
            public E element;
            public Node next;

            public Node(E element) {
                this.element = element;
            }

            public Node(E element, Node next) {
                this.element = element;
                this.next = next;
            }
        }

        private Node head;
        private int size;

        public MyLinkedList() {

        }

        private Node getNode(int index) {
            if(index < 0 || index > this.size) {
                throw new IndexOutOfBoundsException();
            }

            Node node = this.head;
            for(int i = 0; i < index; i++) {
                node = node.next;
            }

            return node;
        }

        public boolean add(E element) {
            Node node = new Node(element);
            Node current = this.head;

            if(this.head == null) {
                this.head = node;
                this.size = 1;
            } else {
                for(; current.next != null; current = current.next) {

                }
                current.next = node;
                this.size++;
            }
            return true;
        }

        public void add(int index, E element) {
            if(index == 0) {
                Node node = new Node(element);
                node.next = this.head;
                this.head = node;
            } else {
                Node node = this.getNode(index - 1);
                node.next = new Node(element, node.next);
            }
            this.size++;
        }

        public E get(int index) {
            Node node = this.getNode(index);
            return node.element;
        }

        public int indexOf(Object o) {
            Node node = head;
            for(int i = 0; i < this.size; i++) {
                if(o.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
            return -1;
        }

        public E remove(int index) {
            if(index < 0 || index > this.size) {
                throw new IndexOutOfBoundsException();
            }

            Node node1 = this.getNode(index - 1);
            node1.next = this.getNode(index + 1);

            return node1.element;
        }

        public boolean remove(Object o) {
            Node n = this.head;
            for(int i = 0; i < this.size; i++) {
                if(n != null && n.element != null && n.element.equals(o)) {
                    if(i == 0) {
                        this.head = n.next;
                        this.head.element = null;
                    } else {
                        Node node = this.getNode(i - 1);
                        node.next = n.next;
                        n.element = null;
                        return true;
                    }
                }
                if(n != null) {
                    n = n.next;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder("[");

            Node n = this.head;
            for(int i = 0; i < this.size; i++) {
                if(n != null) {
                    b.append(n.element);
                    b.append(", ");
                    n = n.next;
                }
            }

            b.delete(b.length() - 2, b.length());
            b.append("]");

            return b.toString();
        }
    }

    public static void testInts() {
        MyLinkedList<Integer> ints = new MyLinkedList<>();

        System.out.println("--- Initial add to the end ---");
        ints.add(5);
        ints.add(12);
        ints.add(4);
        ints.add(424);

        System.out.println("--- Initial ---");
        System.out.println(ints);

        System.out.println("--- Remove by index ---");
        ints.remove(1);
        System.out.println(ints);

        System.out.println("--- Remove by object ---");
        ints.remove(Integer.valueOf(4));
        System.out.println(ints);

        System.out.println("Add by index");
        ints.add(1, 7);
        System.out.println(ints);
    }

    public static void testStrs() {
        MyLinkedList<String> strs = new MyLinkedList<>();

        System.out.println("--- Initial add to the end ---");
        strs.add("a");
        strs.add("b");
        strs.add("dc");
        strs.add("egh");

        System.out.println("--- Initial ---");
        System.out.println(strs);

        System.out.println("--- Remove by index ---");
        strs.remove(1);
        System.out.println(strs);

        System.out.println("--- Remove by object ---");
        strs.remove("dc");
        System.out.println(strs);

        System.out.println("Add by index");
        strs.add(1, "bbb");
        System.out.println(strs);
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        System.out.println("--- Ints test ---");
        testInts();

        System.out.println("--- Strs test ---");
        testStrs();
    }
}
