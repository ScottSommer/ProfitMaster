package org.sommer.pm.data.service;

import java.util.List;

import org.sommer.pm.data.dao.AuctionItemDao;
import org.sommer.pm.data.domain.AuctionItem;
import org.sommer.pm.data.service.specification.AuctionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuctionItemServiceImpl implements AuctionItemService {

	@Autowired AuctionItemDao AuctionItemDao;
	
	@Transactional
	public AuctionItem viewAuctionItem(Integer AuctionItemId) {
		return AuctionItemDao.viewAuctionItem(AuctionItemId);
	}

	@Transactional
	public List<AuctionItem> listAuctionItems() {
		return AuctionItemDao.listAuctionItems();
	}

	@Transactional
	public void createAuctionItem(AuctionItem AuctionItem) {
		AuctionItemDao.saveAuctionItem(AuctionItem);
	}

	@Transactional
	public void updateAuctionItem(AuctionItem AuctionItem) {
		AuctionItemDao.saveAuctionItem(AuctionItem);
	}

}
