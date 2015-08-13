package org.ship.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ship.model.UserInfo;
import org.ship.service.IRoleInfoService;
import org.ship.service.IUserInfoService;
import org.ship.util.PageResults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/APIuser")
public class APIUserController {

	@Resource
	private IUserInfoService userInfoService;
	@Resource
	private IRoleInfoService roleInfoService;
	
	/**
	 * 例子:
	 * http://localhost:8080/ship_administration/APIuser/UpdateUserInfo.do?userId=2&address=湖南省天心区通用时代国际社区12栋402房
	 * 根据编号修改用户信息
	 * @param userInfo
	 * @return result["no data":"没有数据","success":"成功"]
	 */
	@RequestMapping( value = "/UpdateUserInfo", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> updateUserInfo(UserInfo userInfo){
		Map<String, Object> map = new HashMap<String, Object>();
		UserInfo updateUserInfo = userInfoService.queryById(userInfo.getUserId());
		if(updateUserInfo == null) {
			map.put("result", "no data");
		} else {
			if(userInfo.getUserName() != null){
				updateUserInfo.setUserName(userInfo.getUserName());
			}
			if(userInfo.getNickName() != null){
				updateUserInfo.setNickName(userInfo.getNickName());
			}
			if(userInfo.getUserIdcard() != null){
				updateUserInfo.setUserIdcard(userInfo.getUserIdcard());
			}
			if(userInfo.getUserImages() != null){
				updateUserInfo.setUserImages(userInfo.getUserImages());
			}
			if(userInfo.getAddress() != null){
				updateUserInfo.setAddress(userInfo.getAddress());
			}
			if(userInfo.getEmail() != null){
				updateUserInfo.setEmail(userInfo.getEmail());
			}
			if(userInfo.getTel() != null){
				updateUserInfo.setTel(userInfo.getTel());
			}
			if(userInfo.getQq() != null){
				updateUserInfo.setQq(userInfo.getQq());
			}
			if(userInfo.getPhone() != null){
				updateUserInfo.setPhone(userInfo.getPhone());
			}
			if(userInfo.getRoleId() != null){
				updateUserInfo.setRoleId(userInfo.getRoleId());
			}
			if(userInfo.getGender() != null){
				updateUserInfo.setGender(userInfo.getGender());
			}
			userInfoService.update(updateUserInfo);
			map.put("result", "success");
		}
		return map;
	}
	
	/**
	 * 新增用户
	 * 例子：http://localhost:8080/ship_administration/APIuser/AddUserInfo.do
	 * ?userName=testUser&roleId=1&userPwd=lk5115702&nickName=rabbits&gender=1
	 * @param userInfo
	 * @return result:["existing":"已存在","success":"成功"]
	 */
	@RequestMapping( value = "/AddUserInfo", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> addUserInfo(UserInfo userInfo){
		Map<String, Object> map = new HashMap<String, Object>();
		UserInfo addUserInfo = userInfoService.queryByUserName(userInfo.getUserName());
		if(addUserInfo != null){
			map.put("result", "existing");
		}else {
			userInfoService.save(userInfo);
			map.put("result", "success");
		}
		return map;
	}
	
	/**
	 * 根据编号查询用户详细信息
	 * @param userId:用户编号 
	 * @return result["no data":"没有数据","success":"成功"]
	 */
	@RequestMapping( value = "/QueryUserInfo", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> queryUserInfo(long userId){
		Map<String, Object> map = new HashMap<String, Object>();
		UserInfo userInfo = userInfoService.queryById(userId);
		if(userInfo == null){
			map.put("result", "no data");
		} else {
			map.put("userInfo", userInfo);
			map.put("result", "success");
		}
		return map;
	}
	
	/**
	 * 查询用户列表
	 * @param roleId 0：All
	 * @return pageCurrent:总条数
	 * @return userInfos:userInfo类的集合
	 */
	@RequestMapping( value = "QueryUserInfoList", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> queryUserInfoList(long roleId){
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserInfo> users = null;
		if(roleId == 0 ){
			users = userInfoService.qeuryAll();
			map.put("totalCount", users.size());
			map.put("userInfos", users);
		} else {
			users = userInfoService.queryByRoleId(roleId);
			map.put("totalCount", users.size());
			map.put("userInfos", users);
		}
		return map;
	}
	
	/**
	 * 查询用户列表（分页）
	 * @param page
	 * @return pageCount 总页数
	 * @return pageCurrent 当前页数
	 * @return totalCount 总条数
	 * @return userInfos userInfo类集合
	 */
	@RequestMapping( value = "/QueryUserInfoPage", produces="application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> queryUserInfoPage(PageResults<UserInfo> page, long roleId){
		Map<String, Object> map = new HashMap<String, Object>();
		PageResults<UserInfo> userPage = null;
		if(roleId == 0){
			userPage = userInfoService.findByPage(page.getNumPage());
		} else {
			userPage = userInfoService.findByPageAndRoleId(page.getNumPage(), roleId);
		}
		map.put("pageCount", userPage.getPageCount());
		map.put("pageCurrent", userPage.getCurrentPage());
		map.put("totalCount", userPage.getTotalCount());
		map.put("userInfos", userPage.getResults());
		return map;
	}
}
