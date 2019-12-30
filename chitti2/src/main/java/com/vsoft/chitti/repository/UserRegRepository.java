package com.vsoft.chitti.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vsoft.chitti.bean.UserReg;

@Repository
public interface UserRegRepository extends CrudRepository<UserReg, Integer> {

	public UserReg findByMobileAndPassword(String mobile,String password);
}
