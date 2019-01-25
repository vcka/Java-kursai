package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();

        list1.add(1);

        list1.add(2);

        list1.add(3);

        list1.add(4);

        list1.add(5);

        list1.add(6);

        list1.add(7);

        list1.add(8);

        list1.add(9);

        List<Integer> list2 = new ArrayList<>();

        list2.add(1);

        list2.add(2);

        list2.add(3);

        list2.add(4);

        list2.add(5);

        list2.add(6);

        list2.add(7);

        list2.add(8);

        list2.add(9);

        List<List<Integer>> list = new ArrayList<>();

        list.add(list1);

        list.add(list2);



        for (int i = 1; i < list.get(0).size() + 1; i++)

        {

            for (int j = 1; j < list.get(1).size() + 1; j++)

            {

                System.out.print(list.get(0).get(j - 1) + " ");

                if (j == i)

                {

                    for (int k = j; k < 9;k++)

                    {

                        System.out.print(list.get(1).get(j - 1) + " ");

                    }

                    break;

                }

            }

            System.out.println();

        }

    }


}
