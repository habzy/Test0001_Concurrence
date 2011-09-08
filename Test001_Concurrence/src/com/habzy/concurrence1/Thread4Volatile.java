/*
 . * File name£ºThreadVolatile.java
 . * Copyright£ºCopyright 2011-2013 Huawei Tech. Co. Ltd. All Rights Reserved.
 . * Description£º
 . * Author£ºhuangshan
 . * Change date£º2011-9-2
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
 * @version [version, 2011-9-2]
 * @see [relevant class/method]
 * @since [product/module version]
 */
public class Thread4Volatile extends Thread
{
    private static int index = 1;
    
    private String TAG = "ThreadVolatile" + (index++);
    
    private static int i = 0;
    
    private boolean mIsPrint = false;
    
    public Thread4Volatile(boolean isPrint)
    {
        mIsPrint = isPrint;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run()
    {
        if (mIsPrint)
        {
            while (true)
            {
                int j = getValue();
                if (j % 2 != 0)
                {
                    Log.log(TAG, "i=" + j);
                    
                    System.exit(0);
                }
            }
        }
        else
        {
            while (true)
            {
                addI();
            }
        }
    }
    
    private static int getValue()
    {
        return i;
    }
    
    private static void addI()
    {
//        i++;
//        i++;
        i = i + 2;
    }
}
