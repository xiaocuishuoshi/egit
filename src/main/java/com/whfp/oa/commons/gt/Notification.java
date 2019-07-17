package com.whfp.oa.commons.gt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

public class Notification {
	public String taskid;
	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public Notification() {
	}
	
	public   boolean PushSingelLinkMsg(String cid,String title,String text,String url) throws Exception {//通知单个用户打开浏览器url
		boolean a=false;
		try {
			IGtPush push = new IGtPush(Lang.GTHOST, Lang.GTAPPKEY, Lang.GTAPPMSCR);
			boolean b=push.connect();
			LinkTemplate linkTemplate=new LinkTemplate();
			linkTemplate.setAppId(Lang.GTAPPID);
			linkTemplate.setAppkey(Lang.GTAPPKEY);
			linkTemplate.setTitle(title);
			linkTemplate.setText(text);
			linkTemplate.setIsRing(true);
			linkTemplate.setIsVibrate(true);
			linkTemplate.setIsClearable(true);
			linkTemplate.setUrl(url);
			//linkTemplate.setLogo("logo.png");
			SingleMessage message = new SingleMessage();
			message.setOffline(true);
			message.setOfflineExpireTime(24 * 3600 * 1000);
			message.setData(linkTemplate);
			message.setPushNetWorkType(0); 
			Target target = new Target();          
			target.setAppId(Lang.GTAPPID);       
			target.setClientId(cid);        //cid2    //String alias = "";  //target.setAlias(alias);       
			IPushResult ret = push.pushMessageToSingle(message, target); 
			try {
				String res=ret.getResponse().get("result").toString();
				if(res=="ok"){
					a=true;
				}else {
					a=false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				a=false;
			}
			a=true;
		} catch (IOException e) {
			e.printStackTrace();
			a=false;
		}
		return a;
	}
	public   boolean PushSingelNFMsg(String cid,String title,String text,String type){
		System.out.println(Lang.GTAPPKEY);
		final IGtPush push = new IGtPush(Lang.GTHOST, Lang.GTAPPKEY, Lang.GTAPPMSCR);
		// LinkTemplate template = linkTemplateDemo(); 
		TransmissionTemplate template = getTouchuanTemplate(title,type,text);//"broadExperience"
//		 LinkTemplate template = linkTemplateDemo();
		//NotificationTemplate template = NotificationTemplateDemo();
		// NotyPopLoadTemplate template = NotyPopLoadTemplateDemo();
		boolean a=false;
		ListMessage message = new ListMessage();

		message.setData(template);

		message.setOffline(true);
		message.setOfflineExpireTime(1000*3600*24);
		// message.setPushNetWorkType(1);

		List<Target> targets = new ArrayList<Target>();
		Target target = new Target();
		target.setAppId(Lang.GTAPPID);
		target.setClientId(cid);
//		 target.setAlias(Alias);
		targets.add(target);

		String taskId = push.getContentId(message, type+"_LIST");
		IPushResult ret = push.pushMessageToList(taskId, targets);
		try {
			System.out.println(ret.getResponse());
			String res=ret.getResponse().get("result").toString();
			if(res=="ok"){
				a=true;
			}else {
				a=false;
			}
			System.out.println(res);
		} catch (Exception e) {
			e.printStackTrace();
			a=false;
		}
		
		return a;
	}
	private static TransmissionTemplate getTouchuanTemplate(String title,String type,String text) {
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(Lang.GTAPPID);
		template.setAppkey(Lang.GTAPPKEY);
		
        template.setTransmissionContent(title);//这里的内容必须和SimpleAlertMsg中的内容一致
		template.setTransmissionType(2); 
		
		APNPayload payload = new APNPayload(); 
		payload.setBadge(0);
		payload.setContentAvailable(1);
		payload.setSound("default");
		payload.setCategory("$由客户端定义");
		payload.setAlertMsg(new APNPayload.SimpleAlertMsg(title));
		payload.addCustomMsg("push_custom_type",type );//"broadExperience"
		payload.addCustomMsg("payload", text);
		payload.addCustomMsg("push_custom_code", "201512010981");
		template.setAPNInfo(payload);
		
		return template;
	}
	public   boolean PushSingelNFMsg(String cid,String title,String text) throws Exception {//通知单个用户打开应用
		boolean a=false;
		try {
			IGtPush push = new IGtPush(Lang.GTHOST, Lang.GTAPPKEY, Lang.GTAPPMSCR);
			boolean b=push.connect();
			NotificationTemplate nfTemplate=new NotificationTemplate();
			nfTemplate.setAppId(Lang.GTAPPID);
			nfTemplate.setAppkey(Lang.GTAPPKEY);
			nfTemplate.setTitle(title);
			nfTemplate.setText(text);
			nfTemplate.setIsRing(true);
			nfTemplate.setIsVibrate(true);
			nfTemplate.setIsClearable(true);
			//nfTemplate.setTransmissionType(transmissionType);
			//nfTemplate.setLogoUrl("http://ask.dcloud.net.cn/uploads/avatar/000/00/00/16_avatar_mid.jpg");
			nfTemplate.setTransmissionType(1);    
			nfTemplate.setTransmissionContent("");
			SingleMessage message = new SingleMessage();
			message.setOffline(true);
			message.setOfflineExpireTime(24 * 3600 * 1000);
			message.setData(nfTemplate);
			message.setPushNetWorkType(0);
			Target target = new Target();          
			target.setAppId(Lang.GTAPPID);       
			target.setClientId(cid);        //cid2    //String alias = "";  //target.setAlias(alias); 
			
			IPushResult ret = push.pushMessageToSingle(message, target); 
			
			try {
				String res=ret.getResponse().get("result").toString(); 
				System.out.println(res);
				if(res.equals("ok")){
					a=true; 
					setTaskid(ret.getTaskId());
				}else {
					a=false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				a=false;
			}
			a=true;
		} catch (IOException e) {
			e.printStackTrace();
			a=false;
		}
		return a;
	}
	
	public   boolean PushListNFMsg(String [] cid,String title,String text) throws Exception {//通知列表用户打开应用
		boolean a=false;
		try {
			IGtPush push = new IGtPush(Lang.GTHOST, Lang.GTAPPKEY, Lang.GTAPPMSCR);
			boolean b=push.connect();
			NotificationTemplate nfTemplate=new NotificationTemplate();
			nfTemplate.setAppId(Lang.GTAPPID);
			nfTemplate.setAppkey(Lang.GTAPPKEY);
			nfTemplate.setTitle(title);
			nfTemplate.setText(text);
			nfTemplate.setIsRing(true);
			nfTemplate.setIsVibrate(true);
			nfTemplate.setIsClearable(true);
			//nfTemplate.setLogoUrl("http://ask.dcloud.net.cn/uploads/avatar/000/00/00/16_avatar_mid.jpg");
			nfTemplate.setTransmissionType(1);    
			nfTemplate.setTransmissionContent("");
			ListMessage message = new ListMessage();
			message.setOffline(true);
			message.setOfflineExpireTime(24 * 3600 * 1000);
			message.setData(nfTemplate);
			message.setPushNetWorkType(0);
			List targets = new ArrayList();
			for (int i = 0; i < cid.length; i++) {
				Target target = new Target();          
				target.setAppId(Lang.GTAPPID);       
				target.setClientId(cid[i]); 
				targets.add(target);
			}
			String taskId = push.getContentId(message);
			IPushResult ret = push.pushMessageToList(taskId, targets); 
			try {
				String res=ret.getResponse().get("result").toString();
				if(res.equals("ok")){
					a=true;
				}else {
					a=false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				a=false;
			}
			a=true;
		} catch (IOException e) {
			e.printStackTrace();
			a=false;
		}
		return a;
	}
	
	public   boolean PushListTMMsg(String [] cid,String title,String text) throws Exception {//透传消息
		boolean a=false;
		try {
			IGtPush push = new IGtPush(Lang.GTHOST, Lang.GTAPPKEY, Lang.GTAPPMSCR);
			boolean b=push.connect();
			TransmissionTemplate template = new TransmissionTemplate();
		    template.setAppId(Lang.GTAPPID);
		    template.setAppkey(Lang.GTAPPKEY);
		    // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
		    template.setTransmissionType(2); 
		    template.setTransmissionContent(title+text);
			ListMessage message = new ListMessage();
			message.setOffline(true);
			message.setOfflineExpireTime(24 * 3600 * 1000);
			message.setData(template); 
			List targets = new ArrayList();
			for (int i = 0; i < cid.length; i++) {
				Target target = new Target();          
				target.setAppId(Lang.GTAPPID);       
				target.setClientId(cid[i]); 
				targets.add(target);
			}
			String taskId = push.getContentId(message);
			IPushResult ret = push.pushMessageToList(taskId, targets); 
			try {
				String res=ret.getResponse().get("result").toString();
				System.out.println(res);
				if(res.equals("ok")){
					a=true;
				}else {
					a=false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				a=false;
			}
			a=true;
		} catch (IOException e) {
			e.printStackTrace();
			a=false;
		}
		return a;
	}
	public static LinkTemplate linkTemplate(String noticeTitle,String content) {
		LinkTemplate template = new LinkTemplate();
		// 设置APPID与APPKEY
		template.setAppId(Lang.GTAPPID);
		template.setAppkey(Lang.GTAPPKEY);
		// 设置通知栏标题与内容
		template.setTitle(noticeTitle);
		template.setText(content);
		// 配置通知栏图标
		//template.setLogo("icon.png");
		// 配置通知栏网络图标
		template.setLogoUrl("");
		// 设置通知是否响铃，震动，或者可清除
		template.setIsRing(true);
		template.setIsVibrate(true);
		template.setIsClearable(true);
		// 设置打开的网址地址
	  	template.setUrl("#");
		return template;
	}
	public boolean pushMsg(String CID,String noticeTitle,String content)throws Exception {
			boolean flag=false;
			IGtPush push = new IGtPush(Lang.GTHOST,Lang.GTAPPKEY,Lang.GTAPPMSCR); 
			push.connect(); 
			LinkTemplate template = linkTemplate(noticeTitle,content);
			SingleMessage message = new SingleMessage();
			message.setOffline(true);
	                //离线有效时间，单位为毫秒，可选
			message.setOfflineExpireTime(24 * 3600 * 1000);
			message.setData(template);
 
			Target target1 = new Target(); 

			target1.setAppId(Lang.GTAPPID);
			target1.setClientId(CID); 
			IPushResult ret = push.pushMessageToSingle(message, target1); 
			try {
				System.out.println(ret.getResponse());
				String res=ret.getResponse().get("result").toString();
				System.out.println(res);
				if(res.equals("ok")){
					flag=true;
				}else {
					flag=false;
				}
			} catch (Exception e) {
				e.printStackTrace();
				flag=false;
			}
			return flag;
		 
	}
	public static void main(String args[]){ 
		try {//64ec2c9561109ad1a49a0aa2cb63e5d9 
		//	new Notification().PushListTMMsg(cid, "快上网", "收到消息跟我说一下");//.PushSingelNFMsg("b2c49c12865519be9a9429c7cca8593b", "快上网", "张明杨，收到消息跟我说一下");
		//	new Notification().PushSingelLinkMsg("4a98fd96e9095da556a88dfad264375e", "快上网", "收到消息跟我说一下","http://www.baidu.com");
			//payload":"{title:\"Hello H5+ Test\",content:\"test content\",payload:{id:\"1234567890\"}}
		 	new Notification().pushMsg("20f520be68ba0fc556f7c353e198b931","越界警告","您已经超出您的活动区域，请速回！");
		   System.out.println(2);	//new Notification().PushSingelNFMsg("4a98fd96e9095da556a88dfad264375e",  "快上网施工预约提醒","{content:'张明杨，收到消息跟我说一下'}","QDTZ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 //ApnsUtils apns=new ApnsUtils();
	 
		//PushedNotification
	}
}
