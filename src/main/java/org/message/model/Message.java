package org.message.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message{

	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageId;
	
	@Column
	private String message;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User sender;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User receiver;
	
	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date sent;

	@Temporal(TemporalType.TIMESTAMP)
    private java.util.Date seen;

	public Message() {
		
	}
	
	public Message(int messageId, String message, User sender, User receiver, Date sent, Date seen) {
		this.messageId = messageId;
		this.message = message;
		this.sender = sender;
		this.receiver = receiver;
		this.sent = sent;
		this.seen = seen;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public java.util.Date getSent() {
		return sent;
	}

	public void setSent(java.util.Date sent) {
		this.sent = sent;
	}

	public java.util.Date getSeen() {
		return seen;
	}

	public void setSeen(java.util.Date seen) {
		this.seen = seen;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + ", sender=" + sender + ", receiver="
				+ receiver + ", sent=" + sent + ", seen=" + seen + "]";
	}
	
}
