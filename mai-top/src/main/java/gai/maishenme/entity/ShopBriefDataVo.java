package gai.maishenme.entity;

import java.io.Serializable;
import java.util.List;

public class ShopBriefDataVo implements Serializable{
	/**
	 * "id": "3066157",
            "title": "YI 小蚁 智能行车记录仪198元",
            "img": "http://7bv7rb.com1.z0.glb.clouddn.com/be7993d88020a4ab1c40a9c5a8db5c31.jpg",
            "url": "http://zhufu.sinaapp.com/api/go.php?id=3066157",
            "source": "没得比",
            "mallname": "京东商城",
            "time": "5分钟",
            "detail": "神价格！双充版本今天降价到299（微信端298），叠加汽车用品299-100优惠券，199元。神价格！这里我买了第二年的只换不修，9.9，建议大家带上。\t\t\t..."
        },
	 */
	private int errno;

	private List<Data> data ;

	private String maxid;

	public void setErrno(int errno){
	this.errno = errno;
	}
	public int getErrno(){
	return this.errno;
	}
	public void setData(List<Data> data){
	this.data = data;
	}
	public List<Data> getData(){
	return this.data;
	}
	public void setMaxid(String maxid){
	this.maxid = maxid;
	}
	public String getMaxid(){
	return this.maxid;
	}
	public static class Data implements Serializable{
		private String id;
        //商品信息包括价格
		private String title;
        //商品URL
		private String img;
		//跳转信息
		private String url;
       //商品来源
		private String source;

		private String mallname;

		private String time;
        //商品描述
		private String detail;

		public void setId(String id){
		this.id = id;
		}
		public String getId(){
		return this.id;
		}
		public void setTitle(String title){
		this.title = title;
		}
		public String getTitle(){
		return this.title;
		}
		public void setImg(String img){
		this.img = img;
		}
		public String getImg(){
		return this.img;
		}
		public void setUrl(String url){
		this.url = url;
		}
		public String getUrl(){
		return this.url;
		}
		public void setSource(String source){
		this.source = source;
		}
		public String getSource(){
		return this.source;
		}
		public void setMallname(String mallname){
		this.mallname = mallname;
		}
		public String getMallname(){
		return this.mallname;
		}
		public void setTime(String time){
		this.time = time;
		}
		public String getTime(){
		return this.time;
		}
		public void setDetail(String detail){
		this.detail = detail;
		}
		public String getDetail(){
		return this.detail;
		}
	}
}
