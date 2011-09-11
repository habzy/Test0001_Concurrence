package com.habzy.concurrence2;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.habzy.log.Log;

public class Thread4BlockingQueue extends Thread
{
    
    private static int index = 1;
    
    private final int mNo = index;
    
    //Will be wrong, for static just initialize once.
    //    private static final String TAG = "Thread4BlockingQueue" + index++;
    private final String TAG = "Thread4BlockingQueue" + index++;
    
    private static BlockingQueue<String> mQueue = new LinkedBlockingQueue<String>();
    
    private int mNumber = 1;
    
    @Override
    public void run()
    {
        Log.log(TAG, "run()" + mNo);
        Timer timer = new Timer();
        if (1 == mNo)
        {
            timer.schedule(new TimerTask()
            {
                
                @Override
                public void run()
                {
                    Log.log(TAG, "mNumber:" + mNumber);
                    mQueue.add("+" + mNumber++);
                    
                }
            }, 200, 200);
        }
        else
        {
            String mSt = "Begin:";
            while (true)
            {
                try
                {
                    mSt += "#new#";
                    mSt += mQueue.take();
                    int i = mQueue.size();
                    Log.log(TAG, "size:" + (i+1));
                    for (; i > 0; i--)
                    {
                        mSt += mQueue.take();
                    }
                    Log.log(TAG, mSt);
                }
                catch (InterruptedException e)
                {
                }
                
            }
        }
    }
}
