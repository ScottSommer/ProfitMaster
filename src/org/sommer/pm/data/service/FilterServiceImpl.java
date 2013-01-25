package org.sommer.pm.data.service;

import java.util.Collection;
import java.util.List;

import org.sommer.pm.data.service.specification.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.sommer.common.filter.ValueFilter;

@Service
public class FilterServiceImpl implements FilterService {

	@Autowired private List<ValueFilter> valueFilters;

	@Override
	public Collection<ValueFilter> getValueFilters() {
		return valueFilters;
	}

}
