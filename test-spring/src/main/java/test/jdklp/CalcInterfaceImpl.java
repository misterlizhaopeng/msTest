package test.jdklp;

public class CalcInterfaceImpl implements  CalcInterface {


    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int del(int a, int b) {
        return a-b;
    }


}
