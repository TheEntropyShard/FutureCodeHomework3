package me.theentropyshard.futurecodehomework3;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Homework4 {
    // Взято из Homework3.java, слегка изменено
    public static class MyTreeMap<K, V> {
        // Добавление элемента, получение по ключу, удаление элемента по ключу

        public class Node {
            public K key;
            public V value;

            public Node left;
            public Node right;

            protected Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private Node root;

        private Node findNode(Object key) {
            Comparable<K> cKey = (Comparable<K>) key;
            Node node = this.root;

            while(node != null) {
                int cmp = cKey.compareTo(node.key);
                if(cmp < 0) {
                    node = node.left;
                } else if(cmp > 0) {
                    node = node.right;
                } else {
                    return node;
                }
            }
            return null;
        }

        private V putHelper(K key, V value, Node node) {
            Comparable<K> cKey = (Comparable<K>) key;
            int cmp = cKey.compareTo(node.key);
            if(cmp < 0) {
                if(node.left == null) {
                    node.left = new Node(key, value);
                    this.size++;
                    return null;
                }
                return this.putHelper(key, value, node.left);
            }

            if(cmp > 0) {
                if(node.right == null) {
                    node.right = new Node(key, value);
                    this.size++;
                    return null;
                }
                return this.putHelper(key, value, node.right);
            }

            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        public V put(K key, V value) {
            if(this.root == null) {
                this.root = new Node(key, value);
                this.size++;
                return null;
            }

            return this.putHelper(key, value, this.root);
        }

        public V get(Object key) {
            Node node = findNode(key);
            if(node == null) return null;
            return node.value;
        }

        private Node removeHelper(Object key) {
            Node child = this.findNode(key);
            Node parent = this.findParent(key);

            if(child.left == null && child.right == null) {
                if(child == parent.left) {
                    parent.left = null;
                }
                if(child == parent.right) {
                    parent.right = null;
                }
                this.size--;
                return child;
            }
            if(child.left == null) {
                if(child == parent.left) {
                    parent.left = child.right;
                }
                if(child == parent.right) {
                    parent.right = child.right;
                }
                if(child == parent) {
                    child.key = child.right.key;
                    child.value = child.right.value;
                    child.right = null;
                }
                this.size--;
                return child;
            }
            if(child.right == null) {
                if(child == parent.left) {
                    parent.left = child.left;
                }
                if(child == parent.right) {
                    parent.right = child.left;
                }
                if(child == parent) {
                    child.key = child.left.key;
                    child.value = child.left.value;
                    child.left = null;
                }
                this.size--;
                return child;
            }

            Node preemnik = this.findSmallest(child.right);
            removeHelper(preemnik.key);
            child.key = preemnik.key;
            child.value = preemnik.value;

            return child;
        }

        private Node findSmallest(Node node) {
            if(node.left == null) {
                return node;
            }
            return this.findSmallest(node.left);
        }

        public V remove(Object key) {
            V oldValue = this.get(key);
            if(oldValue == null) {
                return null;
            }

            if(this.size == 1) {
                this.root = null;
                this.size--;
                return oldValue;
            }

            this.removeHelper(key);

            return oldValue;
        }

        private Node findParent(Object key) {
            Comparable<K> cKey = (Comparable<K>) key;
            Node child = this.root;
            Node parent = this.root;
            while(child != null) {
                int cmp = cKey.compareTo(child.key);
                if(cmp < 0) {
                    parent = child;
                    child = child.left;
                } else if(cmp > 0) {
                    parent = child;
                    child = child.right;
                } else {
                    return parent;
                }
            }
            return null;
        }

        private void LER(Node node) {
            if(node.left != null) {
                this.LER(node.left);
            }
            System.out.println(node.value);
            if(node.right != null) {
                this.LER(node.right);
            }
        }

        public void printTree() {
            if(this.root == null) {
                System.out.println("Tree is empty");
                return;
            }
            System.out.println("Root = " + this.root.value);
            this.LER(this.root);
        }
    }

    public static class MyTreeSet<E> {
        private static final Object PRESENT = new Object();

        private final MyTreeMap<E, Object> map;

        public MyTreeSet() {
            this.map = new MyTreeMap<>();
        }

        public boolean add(E element) {
            return this.map.put(element, PRESENT) == null;
        }

        public boolean remove(Object o) {
            return this.map.remove(o) == PRESENT;
        }

        public boolean contains(Object o) {
            return this.map.findNode(o) != null;
        }

        private void LER(MyTreeMap.Node node) {
            if(node.left != null) {
                this.LER(node.left);
            }
            System.out.println(node.key);
            if(node.right != null) {
                this.LER(node.right);
            }
        }

        public void printSet() {
            if(this.map.root == null) {
                System.out.println("Set is empty");
                return;
            }
            this.LER(this.map.root);
        }
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        MyTreeSet<Integer> treeSet = new MyTreeSet<>();

        treeSet.add(13);
        treeSet.add(235);
        treeSet.add(123);
        treeSet.add(34);
        treeSet.add(65);
        treeSet.add(324);

        treeSet.printSet();

        treeSet.remove(235);
        treeSet.remove(34);
        System.out.println("-----------");
        treeSet.printSet();

        System.out.println("-----------");
        System.out.println(treeSet.contains(123));
        System.out.println(treeSet.contains(4234));
    }
}
