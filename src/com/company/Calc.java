package com.company;

import java.lang.reflect.Array;

public class Calc extends Compf{
    private StackInt s;
    private static int char2int(char c) {
        return (int)c - (int)'0';
    }
    protected int symOther(char c) {
        if (c < '0' || c > '9') {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }
    protected void nextOper(char c) {
        int second = s.pop();
        int first = s.pop();
        switch (c) {
            case '^':
                int sq=first;
                if(second > 0){
                    for (int i = 1; i < second; i++)
                    {
                        sq*=first;
                    }
                }
                else if(second == 0){
                    sq = 1;
                }
                s.push(sq); break;
            case '+':
                        s.push(first + second); break;
            case '-':
                        s.push(first - second); break;
            case '*':
                        s.push(first * second); break;
            case '/':
                        s.push(first / second); break;
//            default:
//                s.push(10*first + second);
//                break;
        }
    }
    protected void nextOther(char c) {
        if(num > 1){
            int a = s.top();
            s.pop();
            s.push(10*a +char2int(c));
        }
         else s.push(char2int(c));
    }
    public Calc() {
        s = new StackInt();
    }

    private void eightNum(int a){ // перевод числа в восьмеричную систему счисления
        int b=0, i=0;
        int A[] = new int[3];
        while ( i<3){
            A[i]=0;
            i++;
        }
        i=0;
        while (a!=0 && i<3){
            A[i]=a%8;
            a/=8;
            i++;
        }
        if (A[2]!=0)
            System.out.print(A[2]);
        if (A[1]!=0 || A[2]!=0 )
            System.out.print(A[1]);
        System.out.println(A[0]);
    }

    public final void compile(char[] str) {
        super.compile(str);
        System.out.println("" + s.top());
        if (s.top()<4000)
            eightNum(s.top());
        else
            System.out.println("Результат должен быть меньше 4000");
    }
}
