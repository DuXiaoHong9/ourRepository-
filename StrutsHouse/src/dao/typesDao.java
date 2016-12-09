package dao;

import java.util.List;

import entity.types;

public interface typesDao {
	/**
	 * 新增类型
	 * @param dis
	 */
	int insert(types dis);
	/**
	 * 根据id查询类型信息
	 * @param id
	 * @return
	 */
	types selectById(Short id);
	/**
	 * 根据id删除类型信息
	 * @param id
	 * @return
	 */
	int deleteById(Short id);
	/**
	 *  修改类型信息
	 * @return
	 */
	int update(types typ);
	/**
	 * 查询所有的类型信息
	 * @return
	 */
	List<types> selectAll();
}
