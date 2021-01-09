package BVA;

public class Param {
    String name="Parameter_";
    int min,minPlus,minMinus;
    int max,maxPlus,maxMinus;
    int norm;
    public Param(int min,int max,int number){
        this.min=min;
        this.max=max;
        minMinus=min-1;
        minPlus=min+1;
        maxMinus=max-1;
        maxPlus=max+1;
        norm=(min+max)/2;
        name+=number;
    }

}
