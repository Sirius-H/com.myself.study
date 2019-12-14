package com.sirius.lock;




import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-11-20 15:08
 */
public class TwinsLock implements Lock {

    //同时容纳2个线程获取锁
    private Sync sync = new Sync(2);

    static class Sync extends AbstractQueuedSynchronizer {


        public Sync(int status) {
            if (status <= 0) {
                throw new IllegalStateException();
            }
            setState(status);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (;;){
                int current = getState();
                int nowCount = current - arg;
                //小于0 说明锁已经被获取光了，如果没获取光去尝试获取
                if (nowCount >= 0 &&  compareAndSetState(current,nowCount)) {
                    return nowCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (;;){
                int current = getState();
                int nowCount = current + arg;
                if (compareAndSetState(current,nowCount)) {
                    return true;
                }
            }
        }
    }



    @Override
    public void lock() {
        sync.tryAcquireShared(1);
    }

    @Override
    public void unlock() {
        sync.tryReleaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}