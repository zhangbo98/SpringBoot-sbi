package com.hp.serevice;


import com.hp.entity.User;
import com.hp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserBdyId(Long i) {
        return userMapper.selectByPrimaryKey(i);
    }

    /*删除*/
    @Transactional
    public void deleteUserBdyId(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /*查看所有*/
    public List<User> queryAllUser() {
        return  userMapper.selectAll();
    }

    /*添加*/
    public void saveUser(User user) {
        userMapper.insert(user);
    }
}
