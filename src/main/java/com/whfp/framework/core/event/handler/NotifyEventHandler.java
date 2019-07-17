package com.whfp.framework.core.event.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.Subscribe;
import com.whfp.framework.core.event.EventAbstract;
import com.whfp.framework.core.event.entity.NotifyEventEntity;

public class NotifyEventHandler implements EventAbstract<NotifyEventEntity> {

	protected static final Logger logger = LoggerFactory.getLogger(NotifyEventHandler.class);
	
	@Subscribe 
	@Override
	public void handle(NotifyEventEntity event) {
		
		logger.debug("收到:"+event.toString());
	}

}
