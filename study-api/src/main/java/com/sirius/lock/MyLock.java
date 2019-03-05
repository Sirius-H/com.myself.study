package com.sirius.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 描述:
 *
 * @author tangzhiming
 * @create 2019-03-05 13:16
 */
public class MyLock extends AbstractQueuedSynchronizer {


    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}