package com.pikare.model;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class MessageInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String messageID;
	String messageTxt;


	String messageSide;
	
	@Column(name = "senderDate", columnDefinition="DATETIME")
	Timestamp senderDate = new Timestamp(Calendar.getInstance(new Locale("tr")).getTimeInMillis());
	

	
	
	
	public Timestamp getSenderDate() {
		return senderDate;
	}

	public void setSenderDate(Timestamp senderDate) {
		this.senderDate = senderDate;
	}

	public String getMessageSide() {
		return messageSide;
	}

	public void setMessageSide(String messageSide) {
		this.messageSide = messageSide;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "senderID",referencedColumnName = "senderID", nullable = false)
	@JsonIgnore
	private MessageSenders sender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getMessageTxt() {
		return messageTxt;
	}

	public void setMessageTxt(String messageTxt) {
		this.messageTxt = messageTxt;
	}

	public MessageSenders getSender() {
		return sender;
	}

	public void setSender(MessageSenders sender) {
		this.sender = sender;
	}
	
	
}
