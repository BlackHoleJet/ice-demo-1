package ynfeng.demo.client;

import Ice.Application;
import Ice.Communicator;
import ynfeng.demo.PrinterPrx;
import ynfeng.demo.PrinterPrxHelper;
import ynfeng.demo.server.MyPrinter;

/**
 * Created by mac on 16/2/17.
 */
public class Client extends Application{
    public static void main(String[] args) {
        Client client = new Client();
        int status = client.main("Server", args);
        System.exit(status);
    }

    @Override
    public int run(String[] strings) {
        Ice.ObjectPrx base = communicator().stringToProxy("SimplePrinter:default -p 10000");
        PrinterPrx printer = PrinterPrxHelper.checkedCast(base);
        if (printer == null)
            throw new Error("Invalid proxy");

        printer.printString("Hello Ice!");
        return 0;
    }
}
