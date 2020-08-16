package com.amit.sbmysql.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.amit.sbmysql.entities.MigrateTest;
import com.amit.sbmysql.repositories.MigrateTestRepository;

public class MigrateTestService {
	
	@Autowired
	MigrateTestRepository mtr;
	
	MigrateTest getMT(Long id) {
		return mtr.findById(id).get();
	}

}
