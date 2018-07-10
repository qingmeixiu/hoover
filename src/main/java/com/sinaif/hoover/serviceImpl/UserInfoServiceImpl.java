package com.sinaif.hoover.serviceImpl;

import com.sinaif.hoover.mapper.UserInfoBeanMapper;
import com.sinaif.hoover.model.UserInfoBean;
import com.sinaif.hoover.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoBeanMapper userMapper;
	
	@Override
	public UserInfoBean query(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserInfoBean> selectList() {
		return userMapper.selectList();
	}

}
