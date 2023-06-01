package ru.gb.lesson3;

import java.util.Random;
import java.util.Scanner;

public class MyListUsage {
    public static void main (String[] args) {
        Scanner myInput = new Scanner(System.in);

        MyList myList = new MyList();

        for (int i = 0; i < 5; i++) {
            //System.out.print("Добавьте новый элемент в список... ");
            Random rand = new Random();
            myList.addTail(rand.nextInt(100));
            myList.addHead(i*i);
        }

        System.out.println("Заполняем список добавлением новых элементов:");
        System.out.println("    " + myList.toString());

        int findValue = 12; //myInput.nextInt();
        System.out.printf("Ищем в списке элемент со значением %d:\n    ", findValue);
        if (myList.contains(findValue))
            System.out.printf("Элемент со значением %d найден под индексом %d. \n", findValue, myList.find(findValue));
        else
            System.out.println("Искомый элемент не найден.");

        System.out.print("Добавляем в середину списка новые элементы... \n    ");
        for (int i = 0; i < 5; i++) {
            myList.add(i*2,1_000_000 + i);
        }

        System.out.println(myList.toString());

        System.out.println("Элемент c индексом 4: " + myList.get(4).value);
        System.out.println("Элемент c индексом 0: " + myList.get(0).value);

        System.out.println("Удаляем элемент с индексом 5: " + myList.delete(5));
        System.out.println("    " + myList.toString());
        System.out.println("Удаляем первый элемент = " + myList.delete(0));
        System.out.println("    " + myList.toString());
        System.out.println("Удаляем последний элемент = " + myList.delete(myList.size() - 1));
        System.out.println("    " + myList.toString());


        MyList reversedList = myList.reversed();
        System.out.println("Развёрнутая копия списка: \n    " + reversedList.toString());

        MyList newList = new MyList();
        reversedList = newList.reversed();
        System.out.println("Развёрнутая копия пустого списка: \n    " + reversedList.toString());

        newList.addTail(1);
        reversedList = newList.reversed();
        System.out.println("Развёрнутая копия списка из 1 элемента: \n    " + reversedList.toString());

        myInput.close();
    }

}

