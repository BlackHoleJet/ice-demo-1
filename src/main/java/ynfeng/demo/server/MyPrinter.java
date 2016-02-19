package ynfeng.demo.server;

import Ice.Current;
import ynfeng.demo._PrinterDisp;

/**
 * Created by mac on 16/2/17.
 */
public class MyPrinter extends _PrinterDisp {

    public void printString(String s, Current __current) {
        System.out.println(__current.id + " print "+s+"!");
    }
}
