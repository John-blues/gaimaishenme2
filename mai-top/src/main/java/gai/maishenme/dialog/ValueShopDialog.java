package gai.maishenme.dialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import gai.maishenme.R;


public class ValueShopDialog extends Dialog {
	private ShopDialogListener listener;

	private TextView dialogTitleTxt;
	private TextView dialogContentTxt;
	private LinearLayout dialogContent;
	private Button previousBtn;
	private Button middleBtn;
	private Button nextBtn;
	private ImageView dialogImage;
	//title下方分隔线
	private ImageView dialogImageLine;
	//底端textview
	private  TextView finaltv;
	private Object tag;
	private Object contentDescription;
     
	public TextView getFinaltv() {
		finaltv.setVisibility(View.VISIBLE);
		return finaltv;
	}

	public void setFinaltv(TextView finaltv) {
		this.finaltv = finaltv;
	}

	public Object getTag() {
		return tag;
	}
   
	public void setTag(Object tag) {
		this.tag = tag;
	}

	public Object getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(Object contentDescription) {
		this.contentDescription = contentDescription;
	}

	public TextView getDialogTitleTxt() {
		dialogTitleTxt.setVisibility(View.VISIBLE);
		return dialogTitleTxt;
	}

	public TextView getDialogContentTxt() {
		
		return dialogContentTxt;
	}

	public LinearLayout getDialogContent() {
		dialogContent.setVisibility(View.VISIBLE);
		return dialogContent;
	}

	public Button getPreviousBtn() {
		previousBtn.setVisibility(View.VISIBLE);
		return previousBtn;
	}

	public Button getMiddleBtn() {
		middleBtn.setVisibility(View.VISIBLE);
		return middleBtn;
	}

	public Button getNextBtn() {
		nextBtn.setVisibility(View.VISIBLE);
		return nextBtn;
	}
	
	public ImageView getDialogImage() {
		dialogImage.setVisibility(View.VISIBLE);
		return dialogImage;
	}

	public ImageView getDialogImageLine() {
		dialogImageLine.setVisibility(View.VISIBLE);
		return dialogImageLine;
	}

	public void setDialogImageLine(ImageView dialogImageLine) {
		this.dialogImageLine = dialogImageLine;
	}

	public ValueShopDialog(Context context, ShopDialogListener listener) {
		super(context, R.style.myDialogTheme);
		this.listener = listener;
		this.setCancelable(false); 
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showdialog); 
		dialogTitleTxt = (TextView) findViewById(R.id.dialogTitleTxt);
		dialogContentTxt = (TextView) findViewById(R.id.dialogContentTxt);
		dialogContent = (LinearLayout) findViewById(R.id.dialogContent);
        //按钮上方分隔线
		dialogImage = (ImageView) findViewById(R.id.dialogImage);
		//title下方分隔线
		dialogImageLine=(ImageView) findViewById(R.id.dialog_line);
		//底端textview
		finaltv=(TextView) findViewById(R.id.final_tv);
		previousBtn = (Button) findViewById(R.id.previousBtn);
		previousBtn.setOnClickListener(clicked);

		middleBtn = (Button) findViewById(R.id.middleBtn);
		middleBtn.setOnClickListener(clicked);

		nextBtn = (Button) findViewById(R.id.nextBtn);
		nextBtn.setOnClickListener(clicked);
		this.setCanceledOnTouchOutside(false);
	}

	private Button.OnClickListener clicked = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.previousBtn:
				// 第一个按钮
				if (null != listener) {
					listener.OnPreviousButtonClicked(ValueShopDialog.this);
				}
				break;
			case R.id.middleBtn:
				// 中间按钮
				if (null != listener) {
					listener.OnMiddleButtonClicked(ValueShopDialog.this);
				}
				break;
			default:
				// 最后一个按钮
				ValueShopDialog.this.dismiss();
				if (null != listener) {
					listener.OnNextButtonClicked(ValueShopDialog.this);
				}
				break;
			}
		}
	};

	public interface ShopDialogListener {
		abstract void OnPreviousButtonClicked(ValueShopDialog dialog);

		abstract void OnMiddleButtonClicked(ValueShopDialog dialog);

		abstract void OnNextButtonClicked(ValueShopDialog dialog);
	}
 
}
