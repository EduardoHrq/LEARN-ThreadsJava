package org.wait_notify_notifyAll;

public class Main {

    public static void main(String[] args) {

        Data data = new Data();
        data.setOutOfSync(true);

        Thread readData = new Thread(new ReadDataThread(data));
        Thread syncData = new Thread(new SyncDataThread(data));

        syncData.setDaemon(true); // server somente para servir Threads User e quando não há mais terminará

        readData.start();
        syncData.start();


    }
}
