package ynfeng.demo.server;

import Ice.Application;
import Ice.Communicator;

/**
 * Created by mac on 16/2/17.
 */
public class Server extends Application {
    public static void main(String[] args) {
        Server server = new Server();
        int status = server.main("Server", args);
        System.exit(status);
    }

    @Override
    public int run(String[] strings) {
        Communicator ic = Application.communicator();
        Ice.ObjectAdapter adapter =
                ic.createObjectAdapterWithEndpoints("SimplePrinterAdapter", "default -p 10000");
        Ice.Object object = new MyPrinter();
        adapter.add(object, ic.stringToIdentity("SimplePrinter"));
        adapter.activate();
        ic.waitForShutdown();
        if (interrupted())
            System.err.println(appName() + ": terminating");
        return 0;
    }
}
