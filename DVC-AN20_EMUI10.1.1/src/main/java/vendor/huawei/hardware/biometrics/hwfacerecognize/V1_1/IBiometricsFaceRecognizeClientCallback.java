package vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1;

import android.hidl.base.V1_0.DebugInfo;
import android.hidl.base.V1_0.IBase;
import android.os.HidlSupport;
import android.os.HwBinder;
import android.os.HwBlob;
import android.os.HwParcel;
import android.os.IHwBinder;
import android.os.IHwInterface;
import android.os.NativeHandle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public interface IBiometricsFaceRecognizeClientCallback extends vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback {
    public static final String kInterfaceName = "vendor.huawei.hardware.biometrics.hwfacerecognize@1.1::IBiometricsFaceRecognizeClientCallback";

    @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
    IHwBinder asBinder();

    @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
    void debug(NativeHandle nativeHandle, ArrayList<String> arrayList) throws RemoteException;

    @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
    DebugInfo getDebugInfo() throws RemoteException;

    @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
    ArrayList<byte[]> getHashChain() throws RemoteException;

    @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
    ArrayList<String> interfaceChain() throws RemoteException;

    @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
    String interfaceDescriptor() throws RemoteException;

    @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
    boolean linkToDeath(IHwBinder.DeathRecipient deathRecipient, long j) throws RemoteException;

    @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
    void notifySyspropsChanged() throws RemoteException;

    @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient deathRecipient) throws RemoteException;

    static default IBiometricsFaceRecognizeClientCallback asInterface(IHwBinder binder) {
        if (binder == null) {
            return null;
        }
        IHwInterface iface = binder.queryLocalInterface(kInterfaceName);
        if (iface != null && (iface instanceof IBiometricsFaceRecognizeClientCallback)) {
            return (IBiometricsFaceRecognizeClientCallback) iface;
        }
        IBiometricsFaceRecognizeClientCallback proxy = new Proxy(binder);
        try {
            Iterator<String> it = proxy.interfaceChain().iterator();
            while (it.hasNext()) {
                if (it.next().equals(kInterfaceName)) {
                    return proxy;
                }
            }
        } catch (RemoteException e) {
        }
        return null;
    }

    static default IBiometricsFaceRecognizeClientCallback castFrom(IHwInterface iface) {
        if (iface == null) {
            return null;
        }
        return asInterface(iface.asBinder());
    }

    static default IBiometricsFaceRecognizeClientCallback getService(String serviceName, boolean retry) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName, retry));
    }

    static default IBiometricsFaceRecognizeClientCallback getService(boolean retry) throws RemoteException {
        return getService("default", retry);
    }

    static default IBiometricsFaceRecognizeClientCallback getService(String serviceName) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName));
    }

    static default IBiometricsFaceRecognizeClientCallback getService() throws RemoteException {
        return getService("default");
    }

    public static final class Proxy implements IBiometricsFaceRecognizeClientCallback {
        private IHwBinder mRemote;

        public Proxy(IHwBinder remote) {
            this.mRemote = (IHwBinder) Objects.requireNonNull(remote);
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            try {
                return interfaceDescriptor() + "@Proxy";
            } catch (RemoteException e) {
                return "[class or subclass of vendor.huawei.hardware.biometrics.hwfacerecognize@1.1::IBiometricsFaceRecognizeClientCallback]@Proxy";
            }
        }

        public final boolean equals(Object other) {
            return HidlSupport.interfacesEqual(this, other);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback
        public void onEnrollResult(int faceId, int userId, int errorCode) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
            _hidl_request.writeInt32(faceId);
            _hidl_request.writeInt32(userId);
            _hidl_request.writeInt32(errorCode);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(1, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback
        public void onEnrollAcquired(int acquiredInfo, int process) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
            _hidl_request.writeInt32(acquiredInfo);
            _hidl_request.writeInt32(process);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(2, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback
        public void onAuthenticationResult(int userId, int errorCode) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
            _hidl_request.writeInt32(userId);
            _hidl_request.writeInt32(errorCode);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(3, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback
        public void onAuthenticationAcquired(int acquiredInfo) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
            _hidl_request.writeInt32(acquiredInfo);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(4, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback
        public void onCancel(int cancelType) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
            _hidl_request.writeInt32(cancelType);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(5, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback
        public void onRemovedResult(int userId, int errorCode) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
            _hidl_request.writeInt32(userId);
            _hidl_request.writeInt32(errorCode);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(6, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback
        public void onInitResult(int errorCode) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
            _hidl_request.writeInt32(errorCode);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(7, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback
        public void onReleaseResult(int errorCode) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
            _hidl_request.writeInt32(errorCode);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(8, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public ArrayList<String> interfaceChain() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256067662, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                return _hidl_reply.readStringVector();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            _hidl_request.writeNativeHandle(fd);
            _hidl_request.writeStringVector(options);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256131655, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public String interfaceDescriptor() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256136003, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                return _hidl_reply.readString();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public ArrayList<byte[]> getHashChain() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256398152, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ArrayList<byte[]> _hidl_out_hashchain = new ArrayList<>();
                HwBlob _hidl_blob = _hidl_reply.readBuffer(16);
                int _hidl_vec_size = _hidl_blob.getInt32(8);
                HwBlob childBlob = _hidl_reply.readEmbeddedBuffer((long) (_hidl_vec_size * 32), _hidl_blob.handle(), 0, true);
                _hidl_out_hashchain.clear();
                for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
                    byte[] _hidl_vec_element = new byte[32];
                    childBlob.copyToInt8Array((long) (_hidl_index_0 * 32), _hidl_vec_element, 32);
                    _hidl_out_hashchain.add(_hidl_vec_element);
                }
                return _hidl_out_hashchain;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public void setHALInstrumentation() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256462420, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) throws RemoteException {
            return this.mRemote.linkToDeath(recipient, cookie);
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public void ping() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256921159, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public DebugInfo getDebugInfo() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(257049926, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                DebugInfo _hidl_out_info = new DebugInfo();
                _hidl_out_info.readFromParcel(_hidl_reply);
                return _hidl_out_info;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public void notifySyspropsChanged() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(257120595, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(recipient);
        }
    }

    public static abstract class Stub extends HwBinder implements IBiometricsFaceRecognizeClientCallback {
        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList<>(Arrays.asList(IBiometricsFaceRecognizeClientCallback.kInterfaceName, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName, IBase.kInterfaceName));
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> arrayList) {
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return IBiometricsFaceRecognizeClientCallback.kInterfaceName;
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList<>(Arrays.asList(new byte[]{-27, -59, 43, 72, 101, -106, 123, 98, -18, 112, 122, -37, 14, 121, -93, 12, -116, 87, 29, -9, -10, -15, -97, -104, 26, 93, -74, 53, 1, -49, 89, 78}, new byte[]{76, 78, -35, 67, 54, -32, -36, 65, -88, 18, 98, -48, 6, -40, -113, 116, 87, -82, -126, -103, -85, 72, 99, 44, 27, -84, 79, 56, -104, 117, -97, 51}, new byte[]{-20, Byte.MAX_VALUE, -41, -98, -48, 45, -6, -123, -68, 73, -108, 38, -83, -82, 62, -66, 35, -17, 5, 36, -13, -51, 105, 87, 19, -109, 36, -72, 59, 24, -54, 76}));
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) {
            return true;
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo info = new DebugInfo();
            info.pid = HidlSupport.getPidIfSharable();
            info.ptr = 0;
            info.arch = 0;
            return info;
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        @Override // vendor.huawei.hardware.biometrics.hwfacerecognize.V1_1.IBiometricsFaceRecognizeClientCallback, vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback, android.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) {
            return true;
        }

        public IHwInterface queryLocalInterface(String descriptor) {
            if (IBiometricsFaceRecognizeClientCallback.kInterfaceName.equals(descriptor)) {
                return this;
            }
            return null;
        }

        public void registerAsService(String serviceName) throws RemoteException {
            registerService(serviceName);
        }

        public String toString() {
            return interfaceDescriptor() + "@Stub";
        }

        public void onTransact(int _hidl_code, HwParcel _hidl_request, HwParcel _hidl_reply, int _hidl_flags) throws RemoteException {
            boolean _hidl_is_oneway = false;
            boolean _hidl_is_oneway2 = true;
            switch (_hidl_code) {
                case 1:
                    if ((_hidl_flags & 1) != 0) {
                        _hidl_is_oneway = true;
                    }
                    if (!_hidl_is_oneway) {
                        _hidl_reply.writeStatus(Integer.MIN_VALUE);
                        _hidl_reply.send();
                        return;
                    }
                    _hidl_request.enforceInterface(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
                    onEnrollResult(_hidl_request.readInt32(), _hidl_request.readInt32(), _hidl_request.readInt32());
                    return;
                case 2:
                    if ((_hidl_flags & 1) != 0) {
                        _hidl_is_oneway = true;
                    }
                    if (!_hidl_is_oneway) {
                        _hidl_reply.writeStatus(Integer.MIN_VALUE);
                        _hidl_reply.send();
                        return;
                    }
                    _hidl_request.enforceInterface(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
                    onEnrollAcquired(_hidl_request.readInt32(), _hidl_request.readInt32());
                    return;
                case 3:
                    if ((_hidl_flags & 1) != 0) {
                        _hidl_is_oneway = true;
                    }
                    if (!_hidl_is_oneway) {
                        _hidl_reply.writeStatus(Integer.MIN_VALUE);
                        _hidl_reply.send();
                        return;
                    }
                    _hidl_request.enforceInterface(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
                    onAuthenticationResult(_hidl_request.readInt32(), _hidl_request.readInt32());
                    return;
                case 4:
                    if ((_hidl_flags & 1) != 0) {
                        _hidl_is_oneway = true;
                    }
                    if (!_hidl_is_oneway) {
                        _hidl_reply.writeStatus(Integer.MIN_VALUE);
                        _hidl_reply.send();
                        return;
                    }
                    _hidl_request.enforceInterface(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
                    onAuthenticationAcquired(_hidl_request.readInt32());
                    return;
                case 5:
                    if ((_hidl_flags & 1) != 0) {
                        _hidl_is_oneway = true;
                    }
                    if (!_hidl_is_oneway) {
                        _hidl_reply.writeStatus(Integer.MIN_VALUE);
                        _hidl_reply.send();
                        return;
                    }
                    _hidl_request.enforceInterface(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
                    onCancel(_hidl_request.readInt32());
                    return;
                case 6:
                    if ((_hidl_flags & 1) != 0) {
                        _hidl_is_oneway = true;
                    }
                    if (!_hidl_is_oneway) {
                        _hidl_reply.writeStatus(Integer.MIN_VALUE);
                        _hidl_reply.send();
                        return;
                    }
                    _hidl_request.enforceInterface(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
                    onRemovedResult(_hidl_request.readInt32(), _hidl_request.readInt32());
                    return;
                case 7:
                    if ((_hidl_flags & 1) != 0) {
                        _hidl_is_oneway = true;
                    }
                    if (!_hidl_is_oneway) {
                        _hidl_reply.writeStatus(Integer.MIN_VALUE);
                        _hidl_reply.send();
                        return;
                    }
                    _hidl_request.enforceInterface(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
                    onInitResult(_hidl_request.readInt32());
                    return;
                case 8:
                    if ((_hidl_flags & 1) != 0) {
                        _hidl_is_oneway = true;
                    }
                    if (!_hidl_is_oneway) {
                        _hidl_reply.writeStatus(Integer.MIN_VALUE);
                        _hidl_reply.send();
                        return;
                    }
                    _hidl_request.enforceInterface(vendor.huawei.hardware.biometrics.hwfacerecognize.V1_0.IBiometricsFaceRecognizeClientCallback.kInterfaceName);
                    onReleaseResult(_hidl_request.readInt32());
                    return;
                default:
                    switch (_hidl_code) {
                        case 256067662:
                            if ((_hidl_flags & 1) == 0) {
                                _hidl_is_oneway2 = false;
                            }
                            if (_hidl_is_oneway2) {
                                _hidl_reply.writeStatus(Integer.MIN_VALUE);
                                _hidl_reply.send();
                                return;
                            }
                            _hidl_request.enforceInterface(IBase.kInterfaceName);
                            ArrayList<String> _hidl_out_descriptors = interfaceChain();
                            _hidl_reply.writeStatus(0);
                            _hidl_reply.writeStringVector(_hidl_out_descriptors);
                            _hidl_reply.send();
                            return;
                        case 256131655:
                            if ((_hidl_flags & 1) == 0) {
                                _hidl_is_oneway2 = false;
                            }
                            if (_hidl_is_oneway2) {
                                _hidl_reply.writeStatus(Integer.MIN_VALUE);
                                _hidl_reply.send();
                                return;
                            }
                            _hidl_request.enforceInterface(IBase.kInterfaceName);
                            debug(_hidl_request.readNativeHandle(), _hidl_request.readStringVector());
                            _hidl_reply.writeStatus(0);
                            _hidl_reply.send();
                            return;
                        case 256136003:
                            if ((_hidl_flags & 1) == 0) {
                                _hidl_is_oneway2 = false;
                            }
                            if (_hidl_is_oneway2) {
                                _hidl_reply.writeStatus(Integer.MIN_VALUE);
                                _hidl_reply.send();
                                return;
                            }
                            _hidl_request.enforceInterface(IBase.kInterfaceName);
                            String _hidl_out_descriptor = interfaceDescriptor();
                            _hidl_reply.writeStatus(0);
                            _hidl_reply.writeString(_hidl_out_descriptor);
                            _hidl_reply.send();
                            return;
                        case 256398152:
                            if ((_hidl_flags & 1) == 0) {
                                _hidl_is_oneway2 = false;
                            }
                            if (_hidl_is_oneway2) {
                                _hidl_reply.writeStatus(Integer.MIN_VALUE);
                                _hidl_reply.send();
                                return;
                            }
                            _hidl_request.enforceInterface(IBase.kInterfaceName);
                            ArrayList<byte[]> _hidl_out_hashchain = getHashChain();
                            _hidl_reply.writeStatus(0);
                            HwBlob _hidl_blob = new HwBlob(16);
                            int _hidl_vec_size = _hidl_out_hashchain.size();
                            _hidl_blob.putInt32(8, _hidl_vec_size);
                            _hidl_blob.putBool(12, false);
                            HwBlob childBlob = new HwBlob(_hidl_vec_size * 32);
                            for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
                                long _hidl_array_offset_1 = (long) (_hidl_index_0 * 32);
                                byte[] _hidl_array_item_1 = _hidl_out_hashchain.get(_hidl_index_0);
                                if (_hidl_array_item_1 == null || _hidl_array_item_1.length != 32) {
                                    throw new IllegalArgumentException("Array element is not of the expected length");
                                }
                                childBlob.putInt8Array(_hidl_array_offset_1, _hidl_array_item_1);
                            }
                            _hidl_blob.putBlob(0, childBlob);
                            _hidl_reply.writeBuffer(_hidl_blob);
                            _hidl_reply.send();
                            return;
                        case 256462420:
                            if ((_hidl_flags & 1) != 0) {
                                _hidl_is_oneway = true;
                            }
                            if (!_hidl_is_oneway) {
                                _hidl_reply.writeStatus(Integer.MIN_VALUE);
                                _hidl_reply.send();
                                return;
                            }
                            _hidl_request.enforceInterface(IBase.kInterfaceName);
                            setHALInstrumentation();
                            return;
                        case 256660548:
                            if ((_hidl_flags & 1) != 0) {
                                _hidl_is_oneway = true;
                            }
                            if (_hidl_is_oneway) {
                                _hidl_reply.writeStatus(Integer.MIN_VALUE);
                                _hidl_reply.send();
                                return;
                            }
                            return;
                        case 256921159:
                            if ((_hidl_flags & 1) == 0) {
                                _hidl_is_oneway2 = false;
                            }
                            if (_hidl_is_oneway2) {
                                _hidl_reply.writeStatus(Integer.MIN_VALUE);
                                _hidl_reply.send();
                                return;
                            }
                            _hidl_request.enforceInterface(IBase.kInterfaceName);
                            ping();
                            _hidl_reply.writeStatus(0);
                            _hidl_reply.send();
                            return;
                        case 257049926:
                            if ((_hidl_flags & 1) == 0) {
                                _hidl_is_oneway2 = false;
                            }
                            if (_hidl_is_oneway2) {
                                _hidl_reply.writeStatus(Integer.MIN_VALUE);
                                _hidl_reply.send();
                                return;
                            }
                            _hidl_request.enforceInterface(IBase.kInterfaceName);
                            DebugInfo _hidl_out_info = getDebugInfo();
                            _hidl_reply.writeStatus(0);
                            _hidl_out_info.writeToParcel(_hidl_reply);
                            _hidl_reply.send();
                            return;
                        case 257120595:
                            if ((_hidl_flags & 1) != 0) {
                                _hidl_is_oneway = true;
                            }
                            if (!_hidl_is_oneway) {
                                _hidl_reply.writeStatus(Integer.MIN_VALUE);
                                _hidl_reply.send();
                                return;
                            }
                            _hidl_request.enforceInterface(IBase.kInterfaceName);
                            notifySyspropsChanged();
                            return;
                        case 257250372:
                            if ((_hidl_flags & 1) != 0) {
                                _hidl_is_oneway = true;
                            }
                            if (_hidl_is_oneway) {
                                _hidl_reply.writeStatus(Integer.MIN_VALUE);
                                _hidl_reply.send();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
            }
        }
    }
}
