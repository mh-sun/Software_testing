package BVA;

import java.util.ArrayList;

import static java.lang.Math.pow;

public class Test {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
        ArrayList<Integer>arrayList=new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        ArrayList<Integer>arrayList1=new ArrayList<>();
        arrayList1.add(100);
        arrayList1.add(200);
        arrayList1.add(300);
        arrayLists.add(arrayList);
        arrayLists.add(arrayList1);

        for (int i=0;i<arrayLists.size();i++)
        {
            for(int j=0;j<arrayLists.get(i).size();j++)
            {
                System.out.print(arrayLists.get(i).get(j)+" ");
            }
            System.out.println("");
        }

        int t= (int) pow(5,2);
        System.out.println(t);


    }
}
