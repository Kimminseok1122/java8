package me.whiteship.java8to11.Changed_etc.List;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {

        //Fork/Join 프레임워크를 사용해서 배열을 정렬하는 기능을 제공한다.
        int size = 1500;
        int[] numbers = new int[size];

        Random random = new Random();
        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());

        long start = System.nanoTime();
        //쓰레드를 하나만 쓰는 Sort -> 자바는 QuickSort를 쓰는데 시간복잡도는 O(nlogn)
        Arrays.sort(numbers);
        System.out.println("serial sorting took " + (System.nanoTime() - start));

        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        //쓰레드를 여러개쓰기때문에 속도 차이가 난다.
        Arrays.parallelSort(numbers);
        System.out.println("parallel sorting took " + (System.nanoTime() - start));
    }
}
