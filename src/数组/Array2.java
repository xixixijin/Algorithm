package 数组;

/**
 * @author Haokun
 * @date 2020/2/8 18:50
 * <p>
 * 大小固定的有序数组，支持动态增删改
 */
public class Array2 {
    private static final int DEFAULT_SIZE = 8;
    private int size;
    private int[] array;

    public Array2() {
        array = new int[DEFAULT_SIZE];
        this.size = 0;
    }

    public void add(int a) {
        if (size >= DEFAULT_SIZE) {
            throw new RuntimeException("数组已达上限");
        }
        if (size == 0) {
            array[size++] = a;
        } else {
            for (int i = 0; i < size; i++) {
//                比插入值大则 大的部分往后移一位
                if (array[i] > a) {
                    for (int j = size - 1; j >= i; --j) {
                        array[j + 1] = array[j];
                    }
                    array[i] = a;
                    size++;
                    break;
                } else {
                    if (array[i+1]==0){
                        array[size++]=a;
                        break;
                    }
                    if (array[i + 1] >a) {
                        for (int z = size - 1; z >= i + 1; --z) {
                            array[z + 1] = array[z];
                        }
                    }
                }
            }

        }
    }

    public void delete(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size]=0;

    }

    public void set(int index, int a) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("数组下标越界");
        }else if (index==0){
            if (a<=array[1]){
                array[0]=a;
            }else {
                for (int i=2;i<size;i++){
                    if (array[i]>=a){
                        for (int j=0;j<i;j++){
                            array[j]=array[j+1];
                        }
                        array[i]=a;
                        break;
                    }
                }
            }
        } else {
            if (a < array[index - 1]) {
                for (int i = 0; i < index; i++) {
                    if (array[i] <= a && array[i + 1] >= a) {
                        for (int j = index; j>i+1; j--) {
                            array[j] = array[j-1];
                        }
                        array[i + 1] = a;
                    }

                }


            } else if (a > array[index + 1]) {
                for (int i = index + 1; i < size - 1; i++) {
                        if (array[i]<a&&array[i+1]>a){
                            for (int j=index;j<i+1;j++){
                                array[j]=array[j+1];
                            }
                            array[i]=a;
                        }

                }


            } else {
                array[index] = a;
            }

        }

    }


}
