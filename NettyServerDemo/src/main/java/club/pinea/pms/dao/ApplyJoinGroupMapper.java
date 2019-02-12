package club.pinea.pms.dao;

import club.pinea.pms.model.ApplyJoinGroup;

public interface ApplyJoinGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplyJoinGroup record);

    int insertSelective(ApplyJoinGroup record);

    ApplyJoinGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplyJoinGroup record);

    int updateByPrimaryKey(ApplyJoinGroup record);
}