package BVA;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Main {

    static ArrayList<Param> params;
    static String header="Test Case ID,";

    public static void main(String[] args) throws IOException {
        int number_of_param;
        params=new ArrayList<>();

        Scanner sc=new Scanner(System.in);
        number_of_param=sc.nextInt();
        for (int i=1;i<=number_of_param;i++)
        {
            int temp1= sc.nextInt(),temp2= sc.nextInt();
            Param param =new Param(temp1,temp2,i);
            params.add(param);
        }

        BVC();
        Robust();
        Worst();
    }

    private static void Worst() throws IOException {
        FileWriter fileWriter=new FileWriter("Robust.csv");

        WriteHeader(fileWriter);

        int counter=0;
        for(int i=0;i<params.size();i++)
        {
            for(int j=0;j<5;j++)
            {
                fileWriter.write(++counter+",");

                for (int k = 0; k < params.size(); k++)
                {
                    if(j==0){
                        fileWriter.write(valueOf(params.get(k).min));
                    }
                    else if(j==1){
                        fileWriter.write(valueOf(params.get(k).minPlus));
                    }
                    else if(j==2){
                        fileWriter.write(valueOf(params.get(k).max));
                    }
                    else if(j==3){
                        fileWriter.write(valueOf(params.get(k).maxMinus));
                    }
                    else fileWriter.write(valueOf(params.get(k).norm));

                    fileWriter.write(",");
                }
                fileWriter.write("\n");
            }
        }

        fileWriter.close();
    }

    private static void Robust() throws IOException {
        FileWriter fileWriter=new FileWriter("Robust.csv");

        WriteHeader(fileWriter);

        int counter=0;
        for(int i=0;i<params.size();i++)
        {
            for(int j=0;j<6;j++)
            {
                fileWriter.write(++counter+",");

                for (int k = 0; k < params.size(); k++) {

                    if(i==k){
                        if(j==0){

                            fileWriter.write(valueOf(params.get(k).min));
                        }
                        else if(j==1){
                            fileWriter.write(valueOf(params.get(k).minPlus));
                        }
                        else if(j==2){
                            fileWriter.write(valueOf(params.get(k).minMinus));
                        }
                        else if(j==3){
                            fileWriter.write(valueOf(params.get(k).max));
                        }
                        else if(j==4){
                            fileWriter.write(valueOf(params.get(k).maxPlus));
                        }
                        else {
                            fileWriter.write(valueOf(params.get(k).maxMinus));
                        }

                    }
                    else fileWriter.write(valueOf(params.get(k).norm));

                    fileWriter.write(",");
                }
                fileWriter.write("\n");
            }
        }
        fileWriter.write(++counter+",");
        for (Param param:params) {
            fileWriter.write(param.norm+",");
        }
        fileWriter.write("\n");

        fileWriter.close();
    }

    private static void BVC() throws IOException {

        FileWriter fileWriter=new FileWriter("BVC.csv");

        WriteHeader(fileWriter);

        int counter=0;
        for(int i=0;i<params.size();i++)
        {
            for(int j=0;j<4;j++)
            {
                fileWriter.write(++counter+",");

                for (int k = 0; k < params.size(); k++) {

                    if(i==k){
                        if(j==0){

                            fileWriter.write(valueOf(params.get(k).min));
                        }
                        else if(j==1){
                            fileWriter.write(valueOf(params.get(k).minPlus));
                        }
                        else if(j==2){
                            fileWriter.write(valueOf(params.get(k).max));
                        }
                        else {
                            fileWriter.write(valueOf(params.get(k).maxMinus));
                        }
                    }
                    else fileWriter.write(valueOf(params.get(k).norm));

                    fileWriter.write(",");
                }
                fileWriter.write("\n");
            }
        }
        fileWriter.write(++counter+",");
        for (Param param:params) {
            fileWriter.write(param.norm+",");
        }
        fileWriter.write("\n");

        fileWriter.close();
    }

    private static void WriteHeader(FileWriter fileWriter) throws IOException {
        fileWriter.write(header);
        for (Param param:params) {
            fileWriter.write(param.name+",");
        }
        fileWriter.write("Expected Value\n");
    }
}
