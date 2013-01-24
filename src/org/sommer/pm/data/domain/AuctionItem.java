package org.sommer.pm.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity(name="AuctionItem")
@Table(name="Auction")
//@Where(clause="DateDscd IS NULL")
//@Component
//@Scope("prototype")
public class AuctionItem implements Serializable {

	private Long item;
	private Long buyout;
	private Long bid;
	private String seller;
	private TimeLeft timeLeft;
	private Long quantity;
	
	@GeneratedValue
	@Id
	@Generated(GenerationTime.ALWAYS)
	@Column(name="ID")
	public Long getItem() {
		return item;
	}
	public void setItem(Long item) {
		this.item = item;
	}

	@Column(name="Buyout")
	public Long getBuyout() {
		return buyout;
	}
	public void setBuyout(Long buyout) {
		this.buyout = buyout;
	}

	@Column(name="Bid")
	public Long getBid() {
		return bid;
	}
	public void setBid(Long bid) {
		this.bid = bid;
	}
	
	@Column(name="Seller")
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	@Column(name="TimeLeft")
	public TimeLeft getTimeLeft() {
		return timeLeft;
	}
	public void setTimeLeft(TimeLeft timeLeft) {
		this.timeLeft = timeLeft;
	}
	
	@Column(name="Quantity")
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "AuctionItem [item=" + item + ", buyout=" + buyout + ", bid="
				+ bid + ", seller=" + seller + ", timeLeft=" + timeLeft
				+ ", quantity=" + quantity + "]";
	}
	
}