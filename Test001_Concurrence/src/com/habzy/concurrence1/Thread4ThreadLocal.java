/*
 . * File name£ºThread4ThreadLocal.java
 . * Copyright£ºCopyright 2011-2013 Huawei Tech. Co. Ltd. All Rights Reserved.
 . * Description£º
 . * Author£ºhuangshan
 . * Change date£º2011-9-2
 . * Tracking form ID£º
 . * Change request ID£º
 . * Change content£º
 */
package com.habzy.concurrence1;

/**
 * One sentence description
 * Detailed description
 * @author Habzy
 * @version [version, 2011-9-2]
 * @see [relevant class/method]
 * @since [product/module version] 
 */
public class Thread4ThreadLocal extends ThreadLocal<Integer>
{
    /* (non-Javadoc)
     * @see java.lang.ThreadLocal#initialValue()
     */
    @Override
    protected Integer initialValue()
    {
        // TODO Auto-generated method stub
        return super.initialValue();
    }
    
    /* (non-Javadoc)
     * @see java.lang.ThreadLocal#remove()
     */
    @Override
    public void remove()
    {
        // TODO Auto-generated method stub
        super.remove();
    }
    
}
