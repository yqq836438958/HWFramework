package com.android.server.mtm.iaware.appmng.appclean;

import android.app.mtm.iaware.appmng.AppCleanParam;
import android.app.mtm.iaware.appmng.AppMngConstant;
import android.app.mtm.iaware.appmng.IAppCleanCallback;
import android.content.Context;
import android.os.RemoteException;
import android.rms.iaware.AwareLog;
import com.android.server.mtm.iaware.appmng.AwareProcessBlockInfo;
import com.android.server.mtm.iaware.appmng.AwareProcessInfo;
import com.android.server.mtm.iaware.appmng.DecisionMaker;
import com.android.server.mtm.taskstatus.ProcessCleaner;
import java.util.ArrayList;
import java.util.List;

public class ThermalClean extends CleanSource {
    private static final String TAG = "ThermalClean";
    private IAppCleanCallback mCallback;
    private Context mContext;
    private AppCleanParam mParam;

    public ThermalClean(AppCleanParam param, IAppCleanCallback callback, Context context) {
        this.mParam = param;
        this.mContext = context;
        this.mCallback = callback;
    }

    public void clean() {
        if (this.mParam != null) {
            List<String> pkgList = this.mParam.getStringList();
            List<Integer> userIdList = this.mParam.getIntList();
            if (!pkgList.isEmpty()) {
                if (pkgList.size() != userIdList.size()) {
                    AwareLog.e(TAG, "size of pkglist should same to userIdlist");
                    return;
                }
                ArrayList<AwareProcessInfo> proclist = new ArrayList<>();
                int size = pkgList.size();
                for (int i = 0; i < size; i++) {
                    String packageName = pkgList.get(i);
                    int userId = userIdList.get(i).intValue();
                    ArrayList<AwareProcessInfo> procInfo = AwareProcessInfo.getAwareProcInfosFromPackage(packageName, userId);
                    if (procInfo.isEmpty()) {
                        proclist.add(getDeadAwareProcInfo(packageName, userId));
                    } else {
                        proclist.addAll(procInfo);
                    }
                }
                List<AwareProcessBlockInfo> policy = mergeBlock(DecisionMaker.getInstance().decideAll(proclist, this.mParam.getLevel(), AppMngConstant.AppMngFeature.APP_CLEAN, AppMngConstant.AppCleanSource.THERMAL));
                if (policy == null || policy.isEmpty()) {
                    AwareLog.e(TAG, "policy is empty");
                    return;
                }
                int cleanCount = 0;
                for (AwareProcessBlockInfo block : policy) {
                    if (block != null) {
                        cleanCount += ProcessCleaner.getInstance(this.mContext).uniformClean(block, null, "Thermal");
                        AwareLog.i(TAG, "pkg = " + block.mPackageName + ", uid = " + block.mUid + ", policy = " + block.mCleanType + ", reason = " + block.mReason);
                        updateHistory(AppMngConstant.AppCleanSource.THERMAL, block);
                        uploadToBigData(AppMngConstant.AppCleanSource.THERMAL, block);
                    }
                }
                AppCleanParam result = new AppCleanParam.Builder(this.mParam.getSource()).timeStamp(this.mParam.getTimeStamp()).killedCount(cleanCount).build();
                if (this.mCallback != null) {
                    try {
                        this.mCallback.onCleanFinish(result);
                    } catch (RemoteException e) {
                        AwareLog.e(TAG, "RemoteExcption e = " + e);
                    }
                }
            }
        }
    }
}
