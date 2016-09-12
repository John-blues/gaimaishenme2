package gai.maishenme.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import gai.maishenme.R;
import gai.maishenme.adapter.ShopBriefAdapter;
import gai.maishenme.config.Constants;
import gai.maishenme.controller.BaseHandler;
import gai.maishenme.controller.RequestCommant;
import gai.maishenme.entity.ShopBriefDataVo;
import gai.maishenme.entity.ShopBriefDataVo.Data;
import gai.maishenme.util.ShowErrorDialogUtil;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ShopListActivity extends gai.maishenme.base.BaseFragmentActivity {
	private PullToRefreshListView shopListView;
	private List<Data> records;
	ShopBriefAdapter shopListAdapter;
	int page=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shopdata_list_activity);
		initView();
		bindViews();
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		records.clear();
		page = 1;
		requestLfData();
	}

	private void requestLfData() {
		// TODO Auto-generated method stub

		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("v","1.3.1");
		hashmap.put("mallname","京东商城");
		hashmap.put("cate","");
		hashmap.put("page", String.valueOf(page));
		new RequestCommant().requestQueryShopList(new requetHandle(this), this,
				hashmap);
	}
	private class requetHandle extends BaseHandler {

		public requetHandle(Activity activity) {
			super(activity);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			ShopListActivity activity = (ShopListActivity) mActivity.get();
			if (msg.what == Constants.SHOPLISTTEST) {
				shopListView.onRefreshComplete();
				if (command.isSuccess) {
					if (null != command.resData) {
						Log.e("ShopListActivity=", "ShopListActivity:");
						Log.e("ShopListActivity=", command.resData+"");
						ShopBriefDataVo body = (ShopBriefDataVo) command.resData;
						List<Data> record = body.getData();
						records.addAll(record);
						if (records.size() <= 0) {
							Toast.makeText(activity, "no data", Toast.LENGTH_LONG).show();
						} 
						shopListAdapter.notifyDataSetChanged();
						page++;

					}
				} else {
					ShowErrorDialogUtil.showErrorDialog(
							ShopListActivity.this,
							(String) command.resData);
				}
			}else{
				showError((String)command.resData);
			}
		}
	}

	private void bindViews() {
		// TODO Auto-generated method stub
		shopListView.setMode(Mode.BOTH);
		shopListView.setAdapter(shopListAdapter);					
		ILoadingLayout startLabels = shopListView.getLoadingLayoutProxy(true,
				false);
		startLabels.setPullLabel("load...");
		startLabels.setRefreshingLabel("加载中...");
		startLabels.setReleaseLabel("释放更新...");

		ILoadingLayout endLabels = shopListView.getLoadingLayoutProxy(false,
				true);
		endLabels.setPullLabel("正在加载...");
		endLabels.setRefreshingLabel("加载中...");
		endLabels.setReleaseLabel("loading...");

		shopListView.setOnRefreshListener(
				new com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2<ListView>() {

					@Override
					public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
						records.clear();
						page = 1;
						requestLfData();

					}
					@Override
					public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

						shopListView.setMode(Mode.BOTH);
						requestLfData();
					}
				});
	}
	private void initView() {
		// TODO Auto-generated method stub
		shopListView=(PullToRefreshListView) findViewById(R.id.shop_data_list);
		records=new ArrayList<ShopBriefDataVo.Data>();
		shopListAdapter=new ShopBriefAdapter(ShopListActivity.this, records);
		shopListView.setAdapter(shopListAdapter);
	}
}
