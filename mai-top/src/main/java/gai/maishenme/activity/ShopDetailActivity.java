package gai.maishenme.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import gai.maishenme.R;


public class ShopDetailActivity extends gai.maishenme.base.BaseFragmentActivity {
	WebView webView;
	String url;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.shopdetail_activity);
	webView=(WebView) findViewById(R.id.webview);
	webView.getSettings().setJavaScriptEnabled(true);
	webView.setWebViewClient(new  WebViewClient(){
		public void onReceivedSslError(WebView view, android.webkit.SslErrorHandler handler, android.net.http.SslError error) {
			handler.proceed();
		}
	});
	url=getIntent().getStringExtra("url");
	webView.loadUrl(url);
}
}
