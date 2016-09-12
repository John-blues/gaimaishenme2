package gai.maishenme.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import gai.maishenme.R;
import gai.maishenme.activity.ShopDetailActivity;
import gai.maishenme.entity.ShopBriefDataVo.Data;

import java.util.List;
public class ShopBriefAdapter extends BaseAdapter {

    private Context context;
    private List<gai.maishenme.entity.ShopBriefDataVo.Data> records;

    public ShopBriefAdapter(Context context, List<gai.maishenme.entity.ShopBriefDataVo.Data> records) {

        super();
        this.context = context;
        this.records = records;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if (records != null) {
            return records.size();
        } else {
            return 1;
        }

    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        if (records == null)
            return null;
        else if (position >= records.size())
            return null;
        else
            return records.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.shopdata_list_adapter, null);
            holder.title = (TextView) view.findViewById(R.id.shop_title);
            holder.detail = (TextView) view.findViewById(R.id.shop_detail);
            holder.mail = (TextView) view.findViewById(R.id.mail);
            holder.imageView = (ImageView) view.findViewById(R.id.lf_jpg);
            holder.shopUrl = (Button) view.findViewById(R.id.loadUrl);
            holder.time = (TextView) view.findViewById(R.id.time);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final Data data = records.get(position);
        //TODO if(time=0分钟){显示：刚刚更新};

        for (int i = 0; i < records.size(); i++) {
            holder.title.setText(data.getTitle());
            holder.detail.setText(data.getDetail());
            holder.mail.setText(data.getMallname());
            if (data.getTime().equals("0分钟")) {
                holder.time.setText("刚刚更新");
            } else {
                holder.time.setText(data.getTime() + "前更新");
            }
            gai.maishenme.util.ImageWapper.with(context).load(data.getImg()).into(holder.imageView);
            holder.shopUrl.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(context, ShopDetailActivity.class);
                    intent.putExtra("url", data.getUrl());
                    Log.e("shopUrl", data.getUrl() + "");
                    Log.e("Time", "before:" + data.getTime());
                    context.startActivity(intent);
                }
            });
//			ImageLoader.getInstance().displayImage(data.getSource(), holder.imageView, options);
        }
        return view;
    }

    private class ViewHolder {
        public TextView title, detail, mail;
        public ImageView imageView;
        public Button shopUrl;
        public TextView time;

    }
}
