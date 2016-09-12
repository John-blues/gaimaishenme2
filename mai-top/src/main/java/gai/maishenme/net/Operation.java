
package gai.maishenme.net;

import java.util.HashMap;
import gai.maishenme.R;
import gai.maishenme.config.Command;
import gai.maishenme.entity.BaseVo;
import gai.maishenme.entity.ShopBriefDataVo;
import gai.maishenme.util.JsonVoParser;
import android.os.Message;
public class Operation {
	private static final String SUCCESS = "1";
	@SuppressWarnings("unchecked")
	public Message executeLfTest(Command cmd) {
		HashMap<String, String> hashMap = (HashMap<String, String>) cmd.param;
		String jsonString = CallServer.getInstance().callServer(cmd.method,
				hashMap, cmd.context);
		Message msg = Message.obtain();
		msg.what = cmd.commandID;
		ShopBriefDataVo vo=JsonVoParser.getInstance().getLfTestBuyVo(jsonString);
		BaseVo baseVo = JsonVoParser.getInstance().getBasevo(jsonString);
		if ((null != jsonString) && !"".equals(jsonString) && vo != null) {
			/*if (SUCCESS.equals(vo.getErrno()==0)) {
				cmd.isSuccess = true;
				cmd.resData = vo;
			} else {
				cmd.stateCode = vo.getCode();
				cmd.resData = vo.getInfo();
				cmd.isSuccess = false;
			}*/
			if(vo.getErrno()==0){
				cmd.isSuccess = true;
				cmd.resData = vo;
			}
		} else {
			if (baseVo != null) {
				cmd.stateCode = baseVo.getCode();
				cmd.resData = baseVo.getInfo();
				cmd.isSuccess = false;
			} else {
				cmd.isSuccess = false;
				cmd.stateCode = "100001";
				cmd.resData = cmd.context
						.getString(R.string.the_network_is_dead);
			}
		}
		msg.obj = cmd;
		return msg; 
	}
}
