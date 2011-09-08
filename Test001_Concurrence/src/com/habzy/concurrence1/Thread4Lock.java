/*
 . * File name£ºThreadFirst.java
 . * Copyright£ºCopyright 2011-2013 Huawei Tech. Co. Ltd. All Rights Reserved.
 . * Description£º
 . * Author£ºhuangshan
 . * Change date£º2011-9-2
 . * Tracking form ID£º
 . * Change request ID£º
 . * Change content£º
 */
package com.habzy.concurrence1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import com.habzy.log.Log;

/**
 * One sentence description Detailed description
 * 
 * @author Habzy
 * @version [version, 2011-9-2]
 * @see [relevant class/method]
 * @since [product/module version]
 */
public class Thread4Lock extends Thread
{
    private static int mIndex = 1;
    
    private int number = mIndex;
    
    private String TAG = "ThreadFirst" + mIndex++;
    
    private static ReentrantLock mLock = new ReentrantLock();
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        boolean isGotLock = false;
        if (number == 1)
        {
            mLock.lock();
            
            try
            {
                Log.log(TAG, "number:" + number);
                sleep(2000);
                Log.log(TAG, "after Sleep");
            }
            catch (Exception e)
            {
            }
            finally
            {
                mLock.unlock();
            }
        }
        else
        {
            try
            {
                Log.log(TAG, "Before Trying");
                //Can get lock.
                //           isGotLock = mLock.tryLock(3000, TimeUnit.MILLISECONDS);
                //Cann't get lock.
                isGotLock = mLock.tryLock(1000, TimeUnit.MILLISECONDS);
                
                Log.log(TAG, "After Trying");
            }
            catch (InterruptedException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            try
            {
                Log.log(TAG, "mLock.tryLock():" + isGotLock);
                sleep(2000);
                Log.log(TAG, "after Sleep");
            }
            catch (Exception e)
            {
            }
            finally
            {
                if (isGotLock)
                {
                    mLock.unlock();
                }
            }
        }
        
    }
    
}
