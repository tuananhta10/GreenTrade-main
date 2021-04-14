package com.greentrade.worker;

public interface BaseWorker {
    void start(String workerName) throws Exception;
    void stop() throws Exception;
    void onStarted() throws Exception;
    void onStopping() throws Exception;
}
