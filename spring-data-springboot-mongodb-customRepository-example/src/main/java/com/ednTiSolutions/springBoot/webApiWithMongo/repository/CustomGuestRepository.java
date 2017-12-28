package com.ednTiSolutions.springBoot.webApiWithMongo.repository;

import com.ednTiSolutions.springBoot.webApiWithMongo.model.Phone;

public interface CustomGuestRepository {
	
	int testUpdate(String docNumber, String name);
	int testUpdate(String docNumber, Phone phone);
	
}
