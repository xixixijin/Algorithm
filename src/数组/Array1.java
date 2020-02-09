package 数组;

import java.util.Arrays;

/**
 * @author Haokun
 * @date 2020/2/8 0:03
 * <p>
 * 动态扩容数组
 *
 */
public class Array1 {
    private static final int DEFAULT_SIZE=8;
    private int[] array;
    private int size;

    public Array1() {
        this.array=new int[DEFAULT_SIZE];
        this.size=DEFAULT_SIZE;
    }

    public Array1(int size) {
        if (size<=0){
            throw new RuntimeException("数组大小不能小于零");
        }
        if (size<=8){
            size=DEFAULT_SIZE;
        }
        this.array=new int[size];
    }

    public void add(int a){
        if (size<array.length){
            array[size]=a;
        }else if (size==array.length){
            array = Arrays.copyOf(array,size*2);
            array[size++]=a;
        }else if (size>array.length){
            throw new RuntimeException("大事不妙");
        }
    }

    public void set(int index,int a){
        array[index]=a;
    }
    public int get(int index){
        if (index>=size||index<0){
            throw new RuntimeException("数组下标越界");
        }else {
            return array[index];
        }
    }

    @Override
    public String toString() {

        for (int a:array){
            System.out.println(a);
        }
        return "1";
    }
}
