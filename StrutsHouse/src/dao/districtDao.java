package dao;

import java.util.List;

import entity.district;

public interface districtDao {
	/**
	 * 新增区县
	 * @param dis
	 */
	int insert(district dis);
	/**
	 * 根据id查询区县信息
	 * @param id
	 * @return
	 */
	district selectById(Short id);
	/**
	 * 根据id删除区县信息
	 * @param id
	 * @return
	 */
	int deleteById(Short id);
	/**
	 *  修改区县信息
	 * @return
	 */
	int update(district id);
	/**
	 * 查询所有的区县信息
	 * @return
	 */
	List<district> selectAll();
	/**
	 * 分页
	 * @param pageSize 页面大小
	 * @param pageIndex 页码
	 * @return
	 */
	List<district> selectPage(int pageSize,int pageIndex);
}
