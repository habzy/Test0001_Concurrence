/*
 . * File name£ºThread4InterruptOrInterrupted.java
 . * Copyright£ºCopyright 2011-2013 Huawei Tech. Co. Ltd. All Rights Reserved.
 . * Description£º
 . * Author£ºhuangshan
 . * Change date£º2011-9-5
 . * Tracking form ID£º
 . * Change request ID£º
 . * Change content£º
 */
package com.habzy.concurrence1;

import com.habzy.log.Log;

/**
 * One sentence description Detailed description
 * 
 * @author Habzy
 * @version [version, 2011-9-5]
 * @see [relevant class/method]
 * @since [product/module version]
 */
public class Thread4InterruptOrInterrupted extends Thread
{
    private static final String TAG = "Thread4InterruptOrInterrupted";
    
    /**
     * thread for sleep and for...
     */
    private Thread mForThread = new Thread()
    {
        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Thread#run()
         */
        @Override
        public void run()
        {
            while (!isInterrupted())
            {
                for (int i = 0; i < 1000; i++)
                {
                }
            }
            Log.log(TAG, "mForThread: Wake up from for..");
            Log.log(TAG, "mForThread isInterrupted: " + isInterrupted());
            Log.log(TAG, "mForThread isInterrupted: " + Thread.interrupted());
            Log.log(TAG, "mForThread isInterrupted: " + isInterrupted());
            Log.log(TAG, "mForThread isInterrupted: " + Thread.interrupted());
        }
    };
    
    private Thread mSleepThread = new Thread()
    {
        public void run()
        {
            while (!Thread.currentThread().isInterrupted())
            {
                try
                {
                    Log.log(TAG, "mSleepThread sleep!!");
                    sleep(100);
                }
                catch (InterruptedException e)
                {
                    Log.log(TAG, e.toString());
                    Log.log(TAG, "mSleepThread sleep isInterrupted " + "in catch: "
                            + isInterrupted());
                    break;
                }
            }
            Log.log(TAG, "mSleepThread sleep isInterrupted " + "outof catch: "
                    + isInterrupted());
        };
    };
    
    /**
     * thread for wait
     */
    Thread mWaitThread = new Thread()
    {
        @Override
        public void run()
        {
            synchronized (this)
            {
                
                try
                {
                    wait();
                }
                catch (InterruptedException e)
                {
                    Log.log(TAG, e.toString());
                    Log.log(TAG, "mWaitThread isInterrupted " + "in catch: "
                            + isInterrupted());
                }
                Log.log(TAG, "mWaitThread isInterrupted: " + "outof catch: "
                        + isInterrupted());
            }
        }
    };
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run()
    {
        testFor();
        testSleep();
        testWait();
    }

    private void testFor()
    {
        mForThread.start();
        //interrupt for...
        mForThread.interrupt();
    }
    
    private void testSleep()
    {
        mSleepThread.start();
        try
        {
            sleep(80);
        }
        catch (InterruptedException e1)
        {
            e1.printStackTrace();
        }
        //interrupt the sleep .
        mSleepThread.interrupt();
    }

    private void testWait()
    {
        mWaitThread.start();
        try
        {
            sleep(200);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        mWaitThread.interrupt();
        //Here sometimes is true, many times is false.
        Log.log(TAG,
                "Out mWaitThread isInterrupted: " + mWaitThread.isInterrupted());
    }
    
}
