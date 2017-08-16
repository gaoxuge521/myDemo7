package com.gxg.administrator.mydemo7.okhttp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.gxg.administrator.mydemo7.BaseApplication;
import com.gxg.administrator.mydemo7.pubuliuhead.MyPubuliuActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by lvliheng on 2017/8/16 at 9:26.
 */

public class HttpHelper {
  public static   String url = "https://github.com/gaoxuge521/myDemo7/blob/master/okhttp.json";
    private static HttpHelper httpHelper;
    private Context context;

    public static HttpHelper getInstance() {
        if (httpHelper == null) {
            httpHelper = new HttpHelper(BaseApplication.getInstance());
        }
        return httpHelper;
    }

    public HttpHelper(Context context) {
        this.context = context;
    }

    public void request(String url) {
        request(0, url, null, null);
    }

    public void request(String url, RequestBody requestBody) {
        request(1, url, requestBody, null);
    }

    public void request(String url, HttpCallBack callBack) {
        request(0, url, null, callBack);
    }

    public void request(String url, RequestBody requestBody, HttpCallBack callBack) {
        request(1, url, requestBody, callBack);
    }

    /**
     * 网络请求
     *
     * @param type        类型 0: GET; 1: POST; 2: DELETE
     * @param url         请求地址
     * @param requestBody 请求参数
     * @param callBack    回调方法
     */
    public void request(int type, final String url, RequestBody requestBody, final HttpCallBack callBack) {
        try {
            if (context != null) {
                Log.e("sss","→→→ " + url + " ←←←");
            }
            if (url.equals("")) {
                return;
            }
            X509TrustManager xtm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    X509Certificate[] x509Certificates = new X509Certificate[0];
                    return x509Certificates;
                }
            };
            SSLContext sslContext = null;
            try {
                sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, new TrustManager[]{xtm}, new SecureRandom());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            //创建okHttpClient对象age
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    //      .addInterceptor(interceptor)
//                    .cache(mCache)
                    .sslSocketFactory(sslContext.getSocketFactory())
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .hostnameVerifier(DO_NOT_VERIFY)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();

            //创建一个Request
            Request tempRequest = new Request.Builder()
                    .url(url)
                    .build();

            switch (type) {
                case 0:
                    tempRequest = new Request.Builder()
                            .url(url)
                            .build();
                    break;
                case 1:
                    if (requestBody != null) {
                        tempRequest = new Request.Builder()
                                .url(url)
                                .post(requestBody)
                                .build();
                    }
                    break;
                case 2:
                    if (requestBody != null) {
                        tempRequest = new Request.Builder()
                                .url(url)
                                .delete(requestBody)
                                .build();
                    }
                    break;
                default:
                    break;
            }
            final Request request = tempRequest;
            //new call
            Call call = okHttpClient.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("sss", "onFailure: "+e.getMessage() );
                    if (callBack != null) {
                        callBack.onFailure("网络异常"+e.getMessage());
                    }
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    int code = response.code();
                    String result = response.body().string();
                    Log.e("sss", "onResponse: "+code );
                    Log.e("sss", "onResponse: "+result );
                    if(code==200){
                        try {
                            JSONObject jsb = new JSONObject(result);
                            int state = jsb.getInt("state");
                            Log.e("sss", "onResponse: "+state );
                            if(state==0){
                                if(callBack!=null){
                                    callBack.onSuccess(result);
                                }
                            }else{
                                String msg = jsb.getString("msg");
                                if(callBack!=null){
                                    callBack.onError(msg);
                                }
                            }





                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("sss", "onResponse: "+e.getMessage() );
                            if(callBack!=null){
                                callBack.onError(e.getMessage());
                            }
                        }

                    }else if(code==403){
                        Intent intent = new Intent();
                        intent.setClass(context,MyPubuliuActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public interface HttpCallBack {
        void onSuccess(String result);

        void onFailure(String msg);

        void onError(String msg);
    }
}
