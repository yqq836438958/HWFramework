package com.huawei.device.connectivitychrlog;

public class LogLong {
    private static final String LOG_TAG = "LogLong";
    private byte[] bytesValue = null;
    private int length = 8;
    private long value = 0;

    public long getValue() {
        return this.value;
    }

    public void setValue(long value2) {
        this.value = value2;
        this.bytesValue = ByteConvert.longToBytes(this.value);
    }

    public void setValue(int value2) {
        this.value = (long) value2;
        this.bytesValue = ByteConvert.longToBytes(this.value);
    }

    public void setByByteArray(byte[] src, int len, boolean bIsLittleEndian) {
        if (this.length != len) {
            ChrLog.chrLogE(LOG_TAG, false, "setByByteArray failed ,not support len = %{public}d", Integer.valueOf(len));
        }
        this.value = ByteConvert.littleEndianbytesToLong(src);
        this.bytesValue = ByteConvert.longToBytes(this.value);
        ChrLog.chrLogD(LOG_TAG, false, "setByByteArray value = %{public}s", String.valueOf(this.value));
    }

    public int getLength() {
        return this.length;
    }

    public byte[] toByteArray() {
        byte[] bArr = this.bytesValue;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return ByteConvert.longToBytes(this.value);
    }
}
