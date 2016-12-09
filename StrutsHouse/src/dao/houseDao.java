package dao;

import java.util.List;

import entity.house;
import entity.houseTemp;
import entity.users;

public interface houseDao {
	/**
	 * 新增房屋
	 * @param dis
	 */
	int insert(house dis);
	/**
	 * 根据id查询房屋信息
	 * @param id
	 * @return
	 */
	house selectById(Long id);
	/**
	 * 根据id删除房屋信息
	 * @param id
	 * @return
	 */
	int deleteById(Long id);
	/**
	 *  修改房屋信息
	 * @return
	 */
	int update(house hous);
	/**
	 * 查询所有的房屋信息
	 * @return
	 */
	List<house> selectAll();
	/**
	 * 分页
	 * @param pageSize 页面大小
	 * @param pageIndex 页码
	 * @return
	 */
	List<house> selectPage(int pageSize,int pageIndex);
	/**
	 * 查询发布日期最近一个月
	 * @return
	 */
	List<house> selectMonth();
	/**
	 * 根据用户查询房屋信息
	 * @param users  用户 
	 * @return
	 */
	List<house> selectByUId(users userss);
	/**
	 * 页面选择查询
	 * @param houses
	 * @return
	 */
	List<house> selectByLike(houseTemp houses,int pageIndex);
	
	/**
	 * 页面选择的总页数
	 * @param houses
	 * @return
	 */
	int pageCount(houseTemp houses);
}
