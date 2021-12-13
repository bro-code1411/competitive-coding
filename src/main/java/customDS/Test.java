package customDS;

// Stack with add number to first n number functionality
public class Test {
    class Stack{

        static final int RANGE = 100;
        int top;
        int add[] = new int[RANGE];
        int a[] = new int[RANGE];

        Stack(){
            top = -1;
        }
        boolean push (int x){
            if(top >= (RANGE-1)){
                return false;
            }
            else{
                top++;
                a[top] = x;
            }
            return true;
        }

        Integer pop(){
            if(top < 0){
                return null;
            }
            int val = a[top];
            val += add[top];
            if(top -1 >= 0){
                add[top-1] += add[top];
            }
            add[top] = 0;
            top--;
            return val;
        }

        void addNumber(int a , int b){
            if(top < 0){
                return;
            }
            if(a-1 > top) {
                add[top] += b;
            } else{
                add[a-1] += b;
            }
        }

    }

}
