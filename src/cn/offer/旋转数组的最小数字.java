package cn.offer;

public class 旋转数组的最小数字 {

    public int minNumberInRotateArray(int [] array) {
        if(array.length <= 0)
            return 0;
        int start = 0;
        int end = array.length - 1;
        int mid = start;
        while(array[start] >= array[end]){
            if(end - start == 1){
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            if(array[start] == array[end] && array[mid] == array[start])
                return minInOrder(array , start , end);
            if(array[mid] >= array[start])
                start = mid;
            else if(array[mid] <= array[end])
                end = mid;
        }
        return array[mid];
    }

    public int minInOrder(int[] array , int start , int end){
        int result = array[start];
        for(int i = start + 1; i <= end; ++i)
            if(result > array[i])
                result = array[i];
        return result;
    }

    public static void main(String[] args) {
        旋转数组的最小数字 min = new 旋转数组的最小数字();
        int[] arr = new int[]{1,1,1,0,1};
        System.out.println(min.minNumberInRotateArray(arr));
    }
}
