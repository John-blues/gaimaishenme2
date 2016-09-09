package gai.maishenme.util;


import gai.maishenme.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/** *****************************
 * @date ����ʱ�䣺2015��10��16�� ����3:41:59 
 * @author  ���ã��Զ���title������
 * @version 1.0 
 * @parameter  
 * @since 
 * @return  
 *********************************
 */
public class CustomTitleBar extends RelativeLayout{
	private ImageView leftBar;
	private TextView middleBar,rightBar;

	public CustomTitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public CustomTitleBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public void initViewBar(ViewGroup viewGroup){
		leftBar = (ImageView) viewGroup.findViewById(R.id.left_bar);
		middleBar = (TextView) viewGroup.findViewById(R.id.middle_bar);
		rightBar = (TextView) viewGroup.findViewById(R.id.right_bar);
	}

	//��ȡleftbar
	public ImageView getLeftBar(){
		return leftBar;

	}
	//Ϊmiddlebar��������
	public void setMiddleBar(String str){
		middleBar.setText(str);
	}
	//Ϊrightbar��������
	public void setRightBar(String str){
		rightBar.setVisibility(View.VISIBLE);
		rightBar.setText(str);
	}
	//��ȡrightbar
	public TextView getRightBar(){
		return rightBar;

	}
}
