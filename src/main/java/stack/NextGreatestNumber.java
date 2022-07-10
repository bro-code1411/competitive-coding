package stack;

import java.util.Stack;

public class NextGreatestNumber {
    /* prints element and NGE pair for
       all elements of arr[] of size n */
    static void printNGE(int arr[], int n)
    {
        int i = 0;
        Stack<Integer> s = new Stack();
        int element, next;

        s.push(arr[0]);

        for (i = 1; i < n; i++)
        {
            next = arr[i];

            if (!s.isEmpty())
            {
                element = s.pop();
                while (element < next)
                {
                    System.out.println(element + " --> "
                            + next);
                    if (s.isEmpty())
                        break;
                    element = s.pop();
                }
                if (element > next)
                    s.push(element);
            }
            s.push(next);
        }

        while (!s.isEmpty())
        {
            element = s.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
        System.out.println("------------");

    }

    public static void printNGEOrder(int arr[], int n)
    {
        Stack<Integer> s = new Stack<>();
        int nge[] = new int[arr.length];

        // iterate for rest of the elements
        for (int i = arr.length - 1; i >= 0; i--)
        {
            /* if stack is not empty, then
            pop an element from stack.
            If the popped element is smaller
            than next, then
            a) print the pair
            b) keep popping while elements are
            smaller and stack is not empty */
            if (!s.empty())
            {
                while (!s.empty() && s.peek() <= arr[i]) {
                    s.pop();
                }
            }
            nge[i] = s.empty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] +
                    " --> " + nge[i]);
        System.out.println("------------");

    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printNGE(arr, n);
        printNGEOrder(arr, n);

    }
}