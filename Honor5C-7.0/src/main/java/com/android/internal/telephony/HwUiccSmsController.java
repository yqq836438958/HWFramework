package com.android.internal.telephony;

import android.telephony.Rlog;

public class HwUiccSmsController extends UiccSmsController {
    private static final boolean DBG = false;
    private static final String LOG_TAG = "HwUiccSmsController";
    private static UiccSmsControllerUtils utils;

    static {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.android.internal.telephony.HwUiccSmsController.<clinit>():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: jadx.core.utils.exceptions.DecodeException:  in method: com.android.internal.telephony.HwUiccSmsController.<clinit>():void
	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:46)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:98)
	... 5 more
Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1197)
	at com.android.dx.io.OpcodeInfo.getFormat(OpcodeInfo.java:1212)
	at com.android.dx.io.instructions.DecodedInstruction.decode(DecodedInstruction.java:72)
	at jadx.core.dex.instructions.InsnDecoder.decodeInsns(InsnDecoder.java:43)
	... 6 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.telephony.HwUiccSmsController.<clinit>():void");
    }

    public HwUiccSmsController(Phone[] phone) {
        super(phone);
    }

    public String getSmscAddr() {
        return getSmscAddrForSubscriber((long) getPreferredSmsSubscription());
    }

    public String getSmscAddrForSubscriber(long subId) {
        IccSmsInterfaceManager iccSmsIntMgr = utils.getIccSmsInterfaceManager(this, (int) subId);
        if (iccSmsIntMgr != null) {
            return iccSmsIntMgr.getSmscAddr();
        }
        Rlog.e(LOG_TAG, "getSmscAddr iccSmsIntMgr is null for Subscription: " + subId);
        return null;
    }

    public boolean setSmscAddr(String smscAddr) {
        return setSmscAddrForSubscriber((long) getPreferredSmsSubscription(), smscAddr);
    }

    public boolean setSmscAddrForSubscriber(long subId, String smscAddr) {
        IccSmsInterfaceManager iccSmsIntMgr = utils.getIccSmsInterfaceManager(this, (int) subId);
        if (iccSmsIntMgr != null) {
            return iccSmsIntMgr.setSmscAddr(smscAddr);
        }
        Rlog.e(LOG_TAG, "setSmscAddr iccSmsIntMgr is null for Subscription: " + subId);
        return DBG;
    }
}
