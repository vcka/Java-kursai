package com.company;

import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> messages = Arrays.asList(6,4,2,9,1,16,5,17,100,20,19);
        Collections.sort(messages);
        //Collections.reverse(messages);
        int skaicius=5;
        List<Integer> mas = messages;
        //messages.forEach(n -> System.out.println(n));
        for (int index = 0; index < messages.size() ; index++) {
            if ((messages.get(index))<skaicius){
                //System.out.println(index);
                mas = messages.subList(index,messages.size());

            }
            //System.out.println((messages.get(index)-messages.get(index+1)));
                //your logic
            //System.out.println(mas);
        }
        System.out.println(mas);
    }
}
