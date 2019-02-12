package club.pinea.pms.dao;

import club.pinea.pms.model.ApplyAddFriend;

public interface ApplyAddFriendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplyAddFriend record);

    int insertSelective(ApplyAddFriend record);

    ApplyAddFriend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplyAddFriend record);

    int updateByPrimaryKey(ApplyAddFriend record);
}