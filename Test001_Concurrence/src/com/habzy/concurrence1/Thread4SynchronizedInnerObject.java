/*
 . * File name��Thread4SynchronizedInnerObject.java
 . * Copyright��Copyright 2011-2013 Huawei Tech. Co. Ltd. All Rights Reserved.
 . * Description��
 . * Author��huangshan
 . * Change date��2011-9-2
 . * Tracking form ID��
 . * Change request ID��
 . * Change content��
 */
package com.habzy.concurrence1;

import com.habzy.log.Log;

/**
 * One sentence description Detailed description
 * 
 * @author Habzy
 * @version [version, 2011-9-2]
 * @see [relevant class/method]
 * @since [product/module version]
 */
public class Thread4SynchronizedInnerObject extends Thread
{
    
    private static final String TAG = "Thread4SynchronizedInnerObject";
    
    private Object ob = new Object();
    
    public Thread4SynchronizedInnerObject()
    {
        new Thread()
        {
            public void run()
            {
                while (true)
                {
                    sync1();
                }
            }
        }.start();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run()
    {
        while(true)
        {
            sync2();
        }
    }
    
    private void sync1()
    {
        synchronized (ob)
        {
            Log.log(TAG, "sync1()");
            try
            {
                sleep(1000);
            }
            catch (InterruptedException e)
            {
            }
        }
    }
    
    private synchronized void sync2()
    {
        Log.log(TAG, "sync2()");
        try
        {
            sleep(1000);
        }
        catch (InterruptedException e)
        {
        }
    }
    
  
}
