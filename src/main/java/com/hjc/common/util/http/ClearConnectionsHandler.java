package com.hjc.common.util.http;

import org.apache.http.conn.HttpClientConnectionManager;

public class ClearConnectionsHandler extends Thread{

    private final HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    public ClearConnectionsHandler(HttpClientConnectionManager httpClientConnectionManager){
        this.connMgr = httpClientConnectionManager;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown){
                synchronized (this){
                    wait(5000);
                    //关闭失效的连接
                    connMgr.closeExpiredConnections();
                }
            }
        }catch (InterruptedException ex){

        }
    }

    public void shutdown(){
        shutdown = true;
        synchronized (this){
            notifyAll();
        }
    }
}
