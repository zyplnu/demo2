package cn.offer;
import java.util.Stack;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min，push及pop的时间复杂度都是O（1）
 */
public class 包含min函数的栈 {

    static  Stack<Integer> stack = new Stack<>();
    static Stack<Integer> backupStack = new Stack<>();

    public void push(int node){
        if(stack.isEmpty() && !backupStack.isEmpty()){
            stack.push(node);
            backupStack.push(node);
        }else {
            if(node < stack.peek()){
                stack.push(node);
                backupStack.push(node);
            }else{
                stack.push(node);
                backupStack.push(stack.peek());
            }
        }
    }

    public void pop(){
        this.stack.pop();
        backupStack.pop();
    }

    public int top(){
        return stack.size() - 1;
    }

    public int min(){
        return backupStack.pop();
    }

    public static void main(String[] args) {
        包含min函数的栈 test = new 包含min函数的栈();
        test.stack.push(3);
        test.stack.push(4);
        test.stack.push(2);
        test.stack.push(1);
        System.out.println(test.stack.size());
        System.out.println(test.min());
    }

}
