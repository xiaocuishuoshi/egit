package com.whfp.framework.core.event;

import java.util.List;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.InitializingBean;

import com.google.common.eventbus.AsyncEventBus;

public class EventBusAdapter extends AsyncEventBus  implements InitializingBean {

	 	@SuppressWarnings("rawtypes")
	 	private List<EventAbstract> eventBusListener;
	 
	 	// 默认构造方法
	 	public EventBusAdapter (Executor executor, List<EventAbstract> eventBusListener) {
	 		super(executor);
	 		this.eventBusListener = eventBusListener;
	 	}
		/**
		private List<EventAbstract> eventBusListener;
		 
		public void setEventBusListener(List<EventAbstract> eventBusListener) {
		      this.eventBusListener = eventBusListener;
		}
		***/
	    @Override
	    public void afterPropertiesSet() throws Exception {
	        for(EventAbstract eventAbstract : eventBusListener){
	            this.register(eventAbstract);
	        }
	    }

}
