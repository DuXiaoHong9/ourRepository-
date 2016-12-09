package dao;

import java.util.List;

import entity.users;

public interface usersDao {
	/**
	 * 新增用户
	 * @param dis
	 */
	int insert(users user);
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	users selectById(Short id);
	/**
	 * 根据用户名查询用户信息
	 * @param id
	 * @return
	 */
	users selectByName(String name);
	/**
	 * 根据id删除用户信息
	 * @param id
	 * @return
	 */
	int deleteById(Short id);
	/**
	 *  修改用户信息
	 * @return
	 */
	int update(users id);
	/**
	 * 查询所有的用户信息
	 * @return
	 */
	List<users> selectAll();
	/**
	 * 分页
	 * @param pageSize 页面大小
	 * @param pageIndex 页码
	 * @return
	 */
	List<users> selectPage(int pageSize,int pageIndex);
	/**
	 * 登录
	 * @param id
	 * @return
	 */
	users selectByLogin(users user);
}
