package com.habzy.concurrence2;

import java.util.Timer;
import java.util.TimerTask;

import com.habzy.log.Log;
/**
 * 
 * One sentence description
 * Detailed description
 *  notify():     wait1,2,3,4,5;wake1,2,3,4,5;The first wait, The first wake.
 *  notifyAll():  wait1,2,3,4,5;wake5,4,3,2,1;The first wait, The last wake.
 * 
 * @author habzy
 * @version [version, 2011-9-8]
 * @see [relevant class/method]
 * @since [product/module version]
 */
public class ThreadNotifyOrAll extends Thread
{
    private static volatile int index = 1;
    
    private final String TAG = "ThreadNotifyOrAll_" + index++;
    
    private static Object mBlock = new Object();
    
    boolean isAll = false;
    
    public ThreadNotifyOrAll()
    {
        start();
        if (2 == index)
        {
            notifyTest();
        }
        
        while (index <= 5)
        {
            try
            {
                Thread.sleep(50);
                new ThreadNotifyOrAll();
            }
            catch (InterruptedException e)
            {
            }
        }
    }
    
    private void notifyTest()
    {
        new Timer().schedule(new TimerTask()
        {
            
            @Override
            public void run()
            {
                synchronized (mBlock)
                {
                    if (isAll)
                    {
                        Log.log("----------------", "notifyAll()");
                        mBlock.notifyAll();
                    }
                    else
                    {
                        Log.log("----------------", "notify()");
                        mBlock.notify();
                    }
                    isAll = !isAll;
                }
            }
        }, 300, 300);
        
    }
    
    @Override
    public void run()
    {
        synchronized (mBlock)
        {
            try
            {
                while (true)
                {
                    Log.log(TAG, "Before wait");
                    mBlock.wait();
                    Log.log(TAG, "After  wait");
                }
            }
            catch (InterruptedException e)
            {
                Log.log(TAG, e.toString());
            }
        }
    }
}
