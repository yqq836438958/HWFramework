package com.huawei.networkit.grs.utils.ssl;

import android.content.Context;
import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class SecureSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    private static final String CLIENT_AGREEMENT = "TLS";
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
    private static final String[] UN_SAFE_ALGORITHMS = {"TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_RSA"};
    private static String[] safeEnableCiphers = null;
    private static volatile SecureSSLSocketFactory ssf = null;
    private Context mContext;
    private SSLContext sslContext = null;

    private SecureSSLSocketFactory(Context context, String trustFile) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.mContext = context;
        this.sslContext = SSLContext.getInstance(CLIENT_AGREEMENT);
        X509TrustManager tm = new SecureX509TrustManager(this.mContext, trustFile);
        this.sslContext.init(null, new X509TrustManager[]{tm}, null);
    }

    public static SecureSSLSocketFactory getInstance(Context context, String trustFile) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        if (ssf == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (ssf == null) {
                    ssf = new SecureSSLSocketFactory(context, trustFile);
                }
            }
        }
        return ssf;
    }

    private static void setEnableSafeCipherSuites(SSLSocket sslsock) {
        if (sslsock != null) {
            String[] enabledCiphers = sslsock.getEnabledCipherSuites();
            List<String> enabledCiphersList = new ArrayList<>();
            for (String cipherString : enabledCiphers) {
                boolean isUnSafeAlgorithm = false;
                String upperCaseStr = cipherString.toUpperCase(Locale.ENGLISH);
                String[] strArr = UN_SAFE_ALGORITHMS;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (upperCaseStr.contains(strArr[i].toUpperCase(Locale.ENGLISH))) {
                        isUnSafeAlgorithm = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (!isUnSafeAlgorithm) {
                    enabledCiphersList.add(cipherString);
                }
            }
            safeEnableCiphers = (String[]) enabledCiphersList.toArray(new String[enabledCiphersList.size()]);
            sslsock.setEnabledCipherSuites(safeEnableCiphers);
        }
    }

    private void setSocketOptions(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            setEnabledProtocols((SSLSocket) socket);
            setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    private void setEnabledProtocols(SSLSocket sslSocket) {
        if (sslSocket != null && Build.VERSION.SDK_INT >= 16) {
            sslSocket.setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
        }
    }

    public String[] getDefaultCipherSuites() {
        String[] strArr = safeEnableCiphers;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        Socket socket = this.sslContext.getSocketFactory().createSocket(host, port);
        setSocketOptions(socket);
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return createSocket(host.getHostAddress(), port);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
        return createSocket(host, port);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        return createSocket(address.getHostAddress(), port);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        Socket socket = this.sslContext.getSocketFactory().createSocket(s, host, port, autoClose);
        setSocketOptions(socket);
        return socket;
    }
}
