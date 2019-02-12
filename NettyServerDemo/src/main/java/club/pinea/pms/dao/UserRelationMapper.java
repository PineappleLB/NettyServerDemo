package club.pinea.pms.dao;

import club.pinea.pms.model.UserRelation;

public interface UserRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRelation record);

    int insertSelective(UserRelation record);

    UserRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRelation record);

    int updateByPrimaryKey(UserRelation record);
}