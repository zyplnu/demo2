package cn.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public void reOrderArray(int [] array){
        if(array.length == 0)
            return;
        int start = array[0];
        int end = array.length - 1;
        while(start < end){
            while (start < end && !isEven(array[start]))
                start++;
            while (start < end && isEven(array[end]))
                end--;
            if(start < end){
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }

        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    public boolean isEven(int n){
        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        调整数组顺序使奇数位于偶数前面 test = new 调整数组顺序使奇数位于偶数前面();
        int[] arr = new int[]{1,2,3,4,5};
        test.reOrderArray(arr);
    }

}
/**
 if(array.length == 0)
 return;
 //2、若全为奇数或全为偶数则返回原数组
 //3、数组中存在奇数和偶数
 for(int i = 0; i < array.length; i++)
 for(int j = 0; j < array.length - 1; j++)
 if((array[j] & 0x1) == 0 && (array[j + 1] & 0x1) == 1){
 int tmp = array[j];
 array[j] = array[j + 1];
 array[j + 1] = tmp;
 }
 **/