package com.pikare.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pikare.model.MessageSenders;

public interface Message{
	
	List<MessageSenders> getAll();
	MessageSenders getBySenderID(String ID , String RepID);
	MessageSenders save(MessageSenders senders);
	boolean update(MessageSenders senders);
}
