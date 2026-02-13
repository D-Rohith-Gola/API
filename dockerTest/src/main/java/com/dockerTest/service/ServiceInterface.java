package com.dockerTest.service;

import java.util.List;

import com.dockerTest.entity.DockerTestEntity;

public interface ServiceInterface {

	String createAccountService(DockerTestEntity dte);

	String viewAccountService(String email);

	String editAccountService(String email, DockerTestEntity dte);

	String deleteAccountService(String email);
	
	List<DockerTestEntity> getAllAccount();
}
