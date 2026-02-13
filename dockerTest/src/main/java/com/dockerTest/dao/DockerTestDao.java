package com.dockerTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dockerTest.entity.DockerTestEntity;

@Repository
public interface DockerTestDao extends JpaRepository<DockerTestEntity, String>{

}
