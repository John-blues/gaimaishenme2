package gai.maishenme.util;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import android.content.Context;
import android.widget.ImageView;
public class ImageWapper {

	Picasso picasso;
	private  ImageWapper(Context context) {
		picasso = Picasso.with(context);
	}
	public static ImageWapper with(Context context){
		return new ImageWapper(context);
	}

	public WapperCreator load(String url) {
		return new WapperCreator(picasso.load(url));
	}

	public WapperCreator load(int resId) {
		return new WapperCreator(picasso.load(resId));
	}
	public static class WapperCreator{
		RequestCreator creator;
		WapperCreator(RequestCreator creator){
			this.creator =creator;
		}
		public void into(ImageView view){
			creator.into(view);		
		}
	}
}
