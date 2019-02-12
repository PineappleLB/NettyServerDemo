package club.pinea.pms.dao;

import club.pinea.pms.model.GroupRelation;

public interface GroupRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupRelation record);

    int insertSelective(GroupRelation record);

    GroupRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupRelation record);

    int updateByPrimaryKey(GroupRelation record);
}