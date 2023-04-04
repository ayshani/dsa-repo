package com.string.manipulation;

public class Test extends Casec implements i{
    public static void main(String[] args) {
        try{
            Float f1 = new Float("3.0");
            int x = f1.intValue();
            byte b = f1.byteValue();
            double d = f1.doubleValue();
            System.out.println(x+b+d);
        } catch (NumberFormatException e){
            System.out.println("bad number");
        }
    }
}

interface i{
    void method();
}

class Casec{
    public void method(){
        System.out.println("Test Casec");
    }
}

class ImplC extends Casec implements i{

}
