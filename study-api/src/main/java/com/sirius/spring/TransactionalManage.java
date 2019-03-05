package com.sirius.spring;

import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-03-05 19:04
 */
@Component
public class TransactionalManage extends TransactionSynchronizationAdapter implements Executor {

    private static final ThreadLocal<List<Runnable>> TASK = new ThreadLocal<>();
    private static ExecutorService executor = Executors.newFixedThreadPool(5);



    @Override
    public void execute(Runnable command) {
        if (!TransactionSynchronizationManager.isActualTransactionActive()) {
            command.run();
            return;
        }
        List<Runnable> runnables = TASK.get();
        if (runnables == null) {
            runnables = new ArrayList<>();
            TASK.set(runnables);
            TransactionSynchronizationManager.registerSynchronization(this);
        }
        runnables.add(command);
    }


    @Override
    public void afterCommit() {
        List<Runnable> runnables = TASK.get();
        for (int i = 0; i < runnables.size(); i++) {
            Runnable runnable = runnables.get(i);
            executor.submit(runnable);
        }
    }

    @Override
    public void afterCompletion(int status) {
        TASK.remove();
    }

}