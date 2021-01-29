package Java3;

import java.util.ArrayList;

public class ArrforReplace<T> {

    public T[] items;


    public ArrforReplace(T... items) {
        this.items = items;
    }

public void replaceArr (int src, int des) {

    Object ch = items[des];
    items[des] = items[src];
    items[src] = (T) ch;

}

public ArrayList ArrToList () {
   ArrayList<T> arrnew = new ArrayList<>();

   int leng = this.items.length;

    for (int i = 0; i < leng; i++) {
        arrnew.add(i,this.items[i]);
    }

              return arrnew;
    }





    public static void main(String[] args) {
        ArrforReplace<String> arr = new ArrforReplace<>("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");

        System.out.println("Меняем в заданном массиве местами элементы...");

        arr.replaceArr(3, 6);

        for (int i = 0; i <arr.items.length ; i++) {
             System.out.print(arr.items[i]+ " ");}

        System.out.println();
        System.out.println("Преобразование в ArrayList...");

        System.out.println(arr.ArrToList());                                                  ;








    }








}

