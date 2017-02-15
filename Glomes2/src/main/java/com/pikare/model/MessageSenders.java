package com.pikare.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="MessageSenders")
public class MessageSenders implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="senderID")
	String senderID;
	
	@Column 
	String repID;
	
	@Column
	String senderName;
	
	String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}


	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sender",orphanRemoval = true)
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	private List<MessageInfo> message = new ArrayList<MessageInfo>();
	

	public List<MessageInfo> getMessage() {
		return message;
	}

	public void setMessage(List<MessageInfo> message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenderID() {
		return senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public String getRepID() {
		return repID;
	}

	public void setRepID(String repID) {
		this.repID = repID;
	}

	

}
