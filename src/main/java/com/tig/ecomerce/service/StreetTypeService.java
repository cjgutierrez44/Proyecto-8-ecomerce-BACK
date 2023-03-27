package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.StreetType;

public interface StreetTypeService {
	List<StreetType> getStreetTypes();
	StreetType saveStreetType(StreetType streetType);
}
