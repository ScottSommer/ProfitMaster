package org.sommer.pm.data.service.specification;

import java.util.List;

import org.sommer.pm.data.domain.AuctionItem;

public interface AuctionItemService {
	public AuctionItem viewAuctionItem(Integer auctionItemId);
	public List<AuctionItem> listAuctionItems();
	public void createAuctionItem(AuctionItem auctionItem);
	public void updateAuctionItem(AuctionItem auctionItem);
}
