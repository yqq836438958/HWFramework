package com.android.server.rms.iaware.hiber.listener;

import com.android.server.rms.iaware.hiber.AppHibernateTask;
import com.android.server.rms.iaware.memory.data.content.AttrSegments;

abstract class AbsDataHandler {
    protected static final String TAG = "AppHiber_AbsDataHandler";
    protected AppHibernateTask mAppHibernateTask;

    protected abstract int reportData(long j, int i, AttrSegments attrSegments);

    protected AbsDataHandler() {
        this.mAppHibernateTask = AppHibernateTask.getInstance();
    }
}
