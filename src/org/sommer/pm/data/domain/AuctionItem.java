package org.sommer.pm.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.sommer.pm.application.Util;

@Entity(name="AuctionItem")
@Table(name="Auction")
//@Where(clause="DateDscd IS NULL")
//@Component
//@Scope("prototype")
public class AuctionItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7443262119653998006L;
	
	private Long item;
	private Long buyout;
	private Long bid;
	
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
	@Override
	public String toString() {
		return "AuctionItem [item=" + item + ", buyout=" + Util.humaniseAmount(buyout) + ", bid="
				+ Util.humaniseAmount(bid) + "]";
	}

}