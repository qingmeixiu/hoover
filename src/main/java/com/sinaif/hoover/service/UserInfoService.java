package com.sinaif.hoover.service;

import org.springframework.stereotype.Repository;

import com.sinaif.hoover.model.UserInfoBean;

import java.util.List;

@Repository
public interface UserInfoService {
	public UserInfoBean query(Integer id);

	List<UserInfoBean> selectList();

}
