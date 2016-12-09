package dao;

import java.util.List;

import entity.street;

public interface streetDao {
	/**
	 * 新增街道
	 * @param dis
	 */
	int insert(street dis);
	/**
	 * 根据id查询街道信息
	 * @param id
	 * @return
	 */
	street selectById(Short id);
	/**
	 * 根据id删除街道信息
	 * @param id
	 * @return
	 */
	int deleteById(Short id);
	/**
	 *  修改街道信息
	 * @return
	 */
	int update(street id);
	/**
	 * 查询所有的街道信息
	 * @return
	 */
	List<street> selectAll();
}
