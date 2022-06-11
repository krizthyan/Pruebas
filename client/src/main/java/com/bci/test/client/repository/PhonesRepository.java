package com.bci.test.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bci.test.client.entity.Phones;

@Repository
public interface PhonesRepository extends JpaRepository<Phones, Integer>{

}
