package sample;

import java.util.Arrays;

public class ThreadsTiming {

    static final int size = 10000000;
    static final int h = size / 2;


    public static void OneThread(){

        float[] arr = new float[size];

        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время исполнения в одном потоке:" + (System.currentTimeMillis()-a)+ "мс");
}


public static void TwoThreads() {

    float[] arr = new float[size];
    float[] a1 = new float[h];
    float[] a2 = new float[h];

    Arrays.fill(arr, 1);

    long a = System.currentTimeMillis();

    System.arraycopy(arr, 0, a1, 0, h);
    System.arraycopy(arr, h, a2, 0, h);

    Thread thread1 = new Thread (()  -> {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }}, "Поток1");


    Thread thread2 = new Thread (() -> {
        for (int i = 0; i < a2.length; i++) {
            a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }}, "Поток2");

    thread1.start();
    thread2.start();

    System.arraycopy(a1, 0, arr, 0, h);
    System.arraycopy(a2, 0, arr, h, h);

    System.out.println("Время исполнения в двух потоках:" + (System.currentTimeMillis()-a) + "мс");
}



    public static void main(String[] args) {

        OneThread();

        TwoThreads();

    }


}