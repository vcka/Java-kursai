package com.company;

public class Main {

    public static void main(String[] args) {
        Integer[] integerList = {1, 2, 3};
        String[] stringList ={"Hello", "World"};

        printList(integerList);
        printList(stringList);

    }

    public static <E> void printList(E[] list) {
        for (Object elem : list)
            System.out.println(elem);
    }

}
