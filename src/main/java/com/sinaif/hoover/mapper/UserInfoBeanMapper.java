package com.sinaif.hoover.mapper;

import com.sinaif.hoover.model.UserInfoBean;

import java.util.List;

public interface UserInfoBeanMapper {
	
	UserInfoBean selectByPrimaryKey(Integer id);

	List<UserInfoBean> selectList();

}
