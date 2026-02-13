package com.dockerTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dockerTest.dao.DockerTestDao;
import com.dockerTest.entity.DockerTestEntity;

@Service
@Transactional
public class ServiceImpl implements ServiceInterface{

	@Autowired
	DockerTestDao dDao;
	
	@Override
	public String createAccountService(DockerTestEntity dte) {
		dDao.save(dte);
		return "account opened successfully";
	}

	@Override
	public String viewAccountService(String email) {
		dDao.findById(email);
		return "account viewed successfully";
	}

	@Override
	public String editAccountService(String email, DockerTestEntity dte) {
		if(dDao.findById(email).isPresent()) {
			dDao.save(dte);
		}
		return "account edited successfully";
	}

	@Override
	public String deleteAccountService(String email) {
		dDao.deleteById(email);
		return "account deleted successfully";
	}

	@Override
	@Cacheable(value = "DockerTestEntity")
	public List<DockerTestEntity> getAllAccount() {
		System.out.println("Fetching from mySQL...");
		return dDao.findAll();
	}
}
