package com.example.teamscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService( CONNECTIVITY_SERVICE );
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    class SendLoginData extends AsyncTask<Void, Void, Void> {
        WebView webView = (WebView) findViewById (R.id.webView);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {


            return null;
        }


        @Override
        protected void onPostExecute(Void result) {

            webView.getSettings().setAppCacheMaxSize( 50 * 1024 * 1024 ); // 5MB
            webView.getSettings().setAppCachePath( getApplicationContext().getCacheDir().getAbsolutePath() );
            webView.getSettings().setAllowFileAccess( true );
            webView.getSettings().setAppCacheEnabled( true );
            webView.getSettings().setJavaScriptEnabled( true );
            webView.getSettings().setDomStorageEnabled(true);

            webView.getSettings().setCacheMode( WebSettings.LOAD_DEFAULT );
            if ( !isNetworkAvailable() ) { // loading offline
                webView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
            }
            //webView.loadUrl("https://xn--80adsajtfqq.xn--c1abdmxeng9ge.xn--p1ai/");
            webView.loadUrl("https://quiz.vityazgroup.ru/");
//            WebSettings webSettings = webView.getSettings();
//            webSettings.setJavaScriptEnabled(true);
//            webSettings.setDomStorageEnabled (true);
//            webView.setWebViewClient(new WebViewClient(){
//                @Override
//                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                    // DO NOT CALL SUPER METHOD
//                    super.onReceivedSslError(view, handler, error);
//                }
//            });
//            webView.setWebChromeClient (new WebChromeClient());
////            webView.loadUrl("http://www.quiz.vityazgroup.ru/");
//            webView.loadUrl("http://192.168.1.18:3000/");
////            webView.getSettings().setAppCacheMaxSize(1024*1024*8);
//            webView.getSettings().setAppCachePath("android_asset/cache");

            //result_info.setText(resultString);
//            if(resultString != null) {
//                Toast toast = Toast.makeText(getApplicationContext(),  result_info.setText("1" +  e.getMessage());, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//            try {
//                JSONObject weather = new JSONObject(resultString);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//                result_info.setText("Температура: "+ weather.getJSONObject("main").getDouble("temp"));

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new SendLoginData().execute();

    }
}