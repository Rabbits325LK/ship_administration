package org.ship.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.ship.api.model.ShipInfoModel;
import org.ship.model.Security;
import org.ship.model.ShipInfo;
import org.ship.model.ShipOperation;
import org.ship.model.ShipType;
import org.ship.model.UserInfo;
import org.ship.service.ISecurityService;
import org.ship.service.IShipInfoService;
import org.ship.service.IShipOperationService;
import org.ship.service.IShipTypeService;
import org.ship.service.IUserInfoService;
import org.ship.util.Base64Utils;
import org.ship.util.PageResults;
import org.ship.util.RSAUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/APIship")
public class APIShipController {

	@Resource
	private IShipInfoService shipInfoService;
	@Resource
	private IShipTypeService shipTypeService;
	@Resource
	private IUserInfoService userInfoService;
	@Resource
	private IShipOperationService shipOperationService;
	@Resource
	private ISecurityService securityService;
	
	@RequestMapping( value = "/RSAKey" , produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String,Object> RSAKey() throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		String userName = "rabbits325";
		Security security = securityService.queryById((long)1);
		byte[] data = userName.getBytes();
	    byte[] encodedData = RSAUtils.encryptByPublicKey(data, security.getPublicKey());
		map.put("key", Base64Utils.encode(encodedData));
		return map;
	}
	
	/**
	 * 根据编号修改船艇信息
	 * @param shipInfo
	 * @return result:["success":"成功","no data":"没有数据"]
	 */
	@RequestMapping( value = "/UpdateShipInfo", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> updateShipInfo(ShipInfo shipInfo){
		Map<String, Object> map = new HashMap<String, Object>();
		ShipInfo updateShipInfo = shipInfoService.getById(shipInfo.getShipId());
		if(updateShipInfo == null){
			map.put("result", "no data");
		} else {
			if(shipInfo.getShipName() != null){
				updateShipInfo.setShipName(shipInfo.getShipName());
			}
			if(shipInfo.getShipSize() != null){
				updateShipInfo.setShipSize(shipInfo.getShipSize());
			}
			if(shipInfo.getShipTypeCode() != null){
				updateShipInfo.setShipTypeCode(shipInfo.getShipTypeCode());
			}
			if(shipInfo.getShipImages() != null){
				updateShipInfo.setShipImages(shipInfo.getShipImages());
			}
			if(shipInfo.getShipCapacity() != null){
				updateShipInfo.setShipCapacity(shipInfo.getShipCapacity());
			}
			map.put("result", "success");
		}
		return map;
	}
	
	/**
	 * 根据编号删除船艇类型
	 * @param shipTypeCode
	 * @return result:["success":"成功","no data":"没有数据"]
	 */
	@RequestMapping( value = "/DeleteShipType", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> DeleteShipType(long shipTypeCode){
		Map<String, Object> map = new HashMap<String, Object>();
		ShipType delShipType = shipTypeService.queryByCode(shipTypeCode);
		if(delShipType == null){
			map.put("result", "no data");
		} else {
			shipTypeService.delete(delShipType);
			map.put("result", "success");
		}
		return map;
	}
	
	/**
	 * 根据编号跟新游艇类型
	 * @param shipType
	 * @return result:["success":"成功","no data":"没有数据"]
	 */
	@RequestMapping( value = "/UpdateShipType", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> updateShipType(ShipType shipType){
		Map<String, Object> map = new HashMap<String, Object>();
		ShipType updateShipType = shipTypeService.queryByCode(shipType.getShipTypeCode());
		if(updateShipType == null){
			map.put("result", "no data");
		} else {
			updateShipType.setShipTypeName(shipType.getShipTypeName());
			map.put("result", "success");
		}
		return map;
	}
	/**
	 * 根据编号查询类型
	 * @param shipTypeCode
	 * @return result:["success":"成功","no data":"没有数据"]
	 * @return shipType:Object类
	 */
	@RequestMapping( value = "/QueryShipType", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> queryShipType(long shipTypeCode){
		Map<String, Object> map = new HashMap<String, Object>();
		ShipType shipType = shipTypeService.queryByCode(shipTypeCode);
		if(shipType == null) {
			map.put("result", "no data");
		} else {
			map.put("result", "success");
			map.put("shipType", shipType);
		}
		return map;
	}
	
	/**
	 * 查询船艇类型列表
	 * @return totalCount:总条数
	 * @return shipTypes:shipType类集合
	 */
	@RequestMapping( value = "/QueryShipTypeList" , produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> queryShipTypeList(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ShipType> shipTypes = shipTypeService.queryByAll();
		map.put("totalCount", shipTypes.size());
		map.put("shipTypes", shipTypes);
		return map;
	}
	
	/**
	 * 添加船艇类型
	 * @param shipTypeName
	 * @return result:["success":"成功","existing":"已存在"]
	 */
	@RequestMapping( value = "/AddShipType", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> addShipType(String shipTypeName){
		Map<String, Object> map = new HashMap<String, Object>();
		ShipType shipType = shipTypeService.queryByName(shipTypeName);
		if(shipType == null){
			shipTypeService.save(shipType);
			map.put("result", "success");
		} else {
			map.put("result", "existing");
		}
		return map;
	}
	
	/**
	 * 根据ID处理成功预约的订单设为已执行
	 * @param shipOperationCode
	 * @return result:["no data":"没有数据","success":"成功"]
	 */
	@RequestMapping( value = "/UseOrderShipInfo", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> UseOrderShipInfo(long shipOperationCode){
		Map<String, Object> map = new HashMap<String, Object>();
		long shipState = 1;
		ShipOperation shipOperation = shipOperationService.queryByCodeAndState(shipOperationCode, shipState);
		if(shipOperation == null){
			map.put("result", "no data");
		} else {
			shipOperationService.updateStateUse(shipOperation);
			map.put("result", "success");
		}
		return map;
	}
	
	/**
	 * 批量处理过期申请成功的订单判断为已执行组件
	 * @return result:["no data":"没有数据","success":"成功"]
	 */
	@RequestMapping( value = "AutoUseOrderShipInfo", produces = "application/json;charset=UTF8")
	public @ResponseBody Map<String, Object> autoUseOrderShipInfo(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ShipOperation> shipOperations = shipOperationService.pastUseShipInfo();
		if(shipOperations.size() == 0){
			map.put("result", "no data");
		} else {
			for(ShipOperation shipOperation : shipOperations) {
				shipOperationService.updateStateUse(shipOperation);
			}
			map.put("result", "success");
		}
		return map;
	}
	
	/**
	 * 批量处理过期订单请求组件
	 * 
	 * @return result:["no data":"没有数据","success":"成功"]
	 */
	@RequestMapping(value = "/AutoInvalidOrderShipInfo", produces = "application/json;charset=UTF8")
	public @ResponseBody
	Map<String, Object> autoInvalidOrderShipInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ShipOperation> shipOperations = shipOperationService
				.pastOrderShipInfo();
		if (shipOperations.size() == 0) {
			map.put("result", "no data");
		} else {
			for (ShipOperation shipOperation : shipOperations) {
				shipOperationService.updateStateInvalid(shipOperation);
			}
			map.put("result", "success");
		}
		return map;
	}

	/**
	 * 根据预订单编号，手动作废订单
	 * 
	 * @param shipOperationCode
	 * @return result:["no data":"没有数据","success":"成功"]
	 */
	@RequestMapping(value = "/InvalidOrderShipInfo", produces = "application/json;charset=UTF8")
	public @ResponseBody
	Map<String, Object> InvalidOrderShipInfo(long shipOperationCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		ShipOperation shipOperation = shipOperationService
				.getByCode(shipOperationCode);
		if (shipOperation == null) {
			map.put("reslut", "no data");
		} else {
			shipOperationService.updateStateInvalid(shipOperation);
			map.put("result", "success");
		}
		return map;
	}

	/**
	 * 预订受理通过
	 * 
	 * @param shipOperationCode
	 * @return result ["error":"失败","success","成功"]
	 */
	@RequestMapping(value = "/PassOrderShipInfo", produces = "application/json;charset=UTF8")
	public @ResponseBody
	Map<String, Object> passOrderShipInfo(long shipOperationCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = shipOperationService
				.getByCodeforStateOrder(shipOperationCode);
		if (flag == false) {
			map.put("result", "error");
		} else {
			ShipOperation shipOperation = shipOperationService
					.getByCode(shipOperationCode);
			shipOperationService.updateStatePass(shipOperation);
			map.put("result", "success");
		}
		return map;
	}

	/**
	 * 查询申请预订信息列表（分页）
	 * 
	 * @param page
	 * @param state
	 *            1 预订 2已受理 3.已执行 4.已作废
	 * @return
	 */
	@RequestMapping(value = "/QueryOrderInfoPage", produces = "application/json;charset=UTF8")
	public @ResponseBody
	Map<String, Object> QueryOrderInfoPage(PageResults<ShipOperation> page,
			long state) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageResults<ShipOperation> orderPage = shipOperationService
				.queryOrderShipInfoState(page.getNumPage(), state);
		map.put("pageCount", orderPage.getPageCount());
		map.put("pageCurrent", orderPage.getCurrentPage());
		map.put("totalCount", orderPage.getTotalCount());
		List<ShipOperation> shipOperations = orderPage.getResults();
		map.put("orderPage", shipOperations);
		return map;
	}

	/**
	 * 查看申请预订信息列表
	 * 
	 * @param state
	 *            1 预订 2已受理 3.已执行 4.已作废
	 * @return
	 */
	@RequestMapping(value = "/QueryOrderInfoList", produces = "application/json;charset=UTF8")
	public @ResponseBody
	Map<String, Object> QueryOrderInfoList(long state) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ShipOperation> shipOperations = shipOperationService
				.queryByShipState(state);
		map.put("pageCurrent", shipOperations.size());
		map.put("shipOperations", shipOperations);
		return map;
	}

	/**
	 * 预约船艇 API：http://localhost:8080/ship_administration/APIuser/OrderShip.do?
	 * shipId=船艇编号&userId=用户编号&start=开始时间&end=结束时间
	 * 
	 * @param shipId
	 * @param userId
	 * @param start
	 * @param end
	 * @return
	 */
	@RequestMapping(value = "/OrderShip.do", produces = "application/json;charset=UTF8")
	public @ResponseBody
	Map<String, Object> OrderShip(long shipId, long userId, String start,
			String end) {
		Map<String, Object> map = new HashMap<String, Object>();
		ShipInfo ship = shipInfoService.getById(shipId);
		UserInfo user = userInfoService.queryById(userId);
		/* System.out.println("1111"); */
		if (ship == null) {
			map.put("result", "user:null");
			/* System.out.println("1112"); */
		} else if (user == null) {
			map.put("result", "ship:null");
			/* System.out.println("1113"); */
		} else {
			/* System.out.println("22111"); */
			java.sql.Timestamp stratime = new java.sql.Timestamp(
					System.currentTimeMillis());
			java.sql.Timestamp endtime = new java.sql.Timestamp(
					System.currentTimeMillis());
			java.sql.Timestamp nowtime = new java.sql.Timestamp(
					System.currentTimeMillis());
			stratime = Timestamp.valueOf(start);
			endtime = Timestamp.valueOf(end);

			if (nowtime.getTime() > stratime.getTime()) {
				/* System.out.println("不能预订过去。。。白痴！"); */
				map.put("result", "now > startime");
			} else if (endtime.getTime() < stratime.getTime()) {
				/* System.out.println("结束时间怎么可能比开始时间早，你是猪吗？"); */
				map.put("result", "endtime > startime");
			} else {
				ShipOperation so = new ShipOperation();
				so.setUserId(userId);
				so.setShipId(shipId);
				so.setShipState((long) 1);
				so.setStratime(stratime);
				so.setEndtime(endtime);
				boolean flag = shipOperationService.queryByShipTime(so);
				System.out.println(flag);
				if (flag == false) {
					shipOperationService.save(so);
					/* System.out.println("预约成功"); */
					map.put("result", "success");
				} else {
					/* System.out.println("该时间段已被预约"); */
					map.put("result", "existing");
				}
			}
		}
		return map;
	}

	/**
	 * 根据ID删除游艇信息
	 * 
	 * @param shipId
	 * @return
	 */
	@RequestMapping(value = "/DelShipInfo.do", produces = "application/json;charset=UTF8")
	public @ResponseBody
	Map<String, Object> delShipInfo(long shipId) {
		Map<String, Object> map = new HashMap<String, Object>();
		ShipInfo ship = shipInfoService.getById(shipId);
		if (ship != null) {
			shipInfoService.delete(ship);
			map.put("result", "success"); // 删除成功
		} else {
			map.put("result", "shipInfo:null"); // 删除失败，游艇信息不存在
		}
		return map;
	}

	/**
	 * 查询游艇信息列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/QueryShipInfoList.do", produces = "application/json;charset=UTF8")
	public @ResponseBody
	Map<String, Object> apiQueryShipInfoList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ShipInfo> ships = shipInfoService.queryByAll();
		List<ShipInfoModel> shipInfoModels = new ArrayList<ShipInfoModel>();
		for (ShipInfo ship : ships) {
			ShipInfoModel shipInfoModel = new ShipInfoModel();
			shipInfoModel.setShipId(ship.getShipId());
			shipInfoModel.setShipName(ship.getShipName());
			shipInfoModel.setShipSize(ship.getShipSize());
			shipInfoModel.setShipCapacity(ship.getShipCapacity());
			shipInfoModel.setShipType(shipTypeService.queryByCodeforName(ship
					.getShipTypeCode()));
			shipInfoModel.setShipImages(ship.getShipImages());
			shipInfoModels.add(shipInfoModel);
		}
		map.put("ships", shipInfoModels);
		map.put("totalCount", shipInfoModels.size());
		return map;
	}

	/**
	 * 根据ID查询游艇详细资料 例子:
	 * http://localhost:8080/ship_administrtaion/APIuser/QueryShipInfo
	 * .do?shipId=15
	 * 
	 * @param shipId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/QueryShipInfo.do", produces = "application/json;charset=UTF8")
	public @ResponseBody
	Map apiQuerySHipInfo(long shipId) {
		Map<String, Object> map = new HashMap<String, Object>();
		ShipInfo ship = shipInfoService.getById(shipId);
		ShipInfoModel shipInfoModel = new ShipInfoModel();
		shipInfoModel.setShipId(ship.getShipId());
		shipInfoModel.setShipName(ship.getShipName());
		shipInfoModel.setShipSize(ship.getShipSize());
		shipInfoModel.setShipCapacity(ship.getShipCapacity());
		shipInfoModel.setShipType(shipTypeService.queryByCodeforName(ship
				.getShipTypeCode()));
		shipInfoModel.setShipImages(ship.getShipImages());
		map.put("ship", shipInfoModel);
		return map;
	}

	/**
	 * 查询游艇资料
	 * 
	 * @param page
	 *            -Type:int numPage 查询第几页（默认1）
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/QueryShipInfoPage.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	Map apiQueryShipInfoPage(PageResults page) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageResults queryPage = shipInfoService.findByPage(page.getNumPage());
		int pageCount = queryPage.getPageCount(); // 总页数
		int pageCurrent = queryPage.getCurrentPage(); // 当前页
		int totalCount = queryPage.getTotalCount(); // 总条数
		map.put("pageCount", pageCount);
		map.put("pageCurrent", pageCurrent);
		map.put("totalCount", totalCount);
		List<ShipInfo> ships = queryPage.getResults();
		List<ShipInfoModel> shipInfoModels = new ArrayList<ShipInfoModel>();
		for (ShipInfo ship : ships) {
			ShipInfoModel shipInfoModel = new ShipInfoModel();
			shipInfoModel.setShipId(ship.getShipId());
			shipInfoModel.setShipName(ship.getShipName());
			shipInfoModel.setShipSize(ship.getShipSize());
			shipInfoModel.setShipCapacity(ship.getShipCapacity());
			shipInfoModel.setShipType(shipTypeService.queryByCodeforName(ship
					.getShipTypeCode()));
			shipInfoModel.setShipImages(ship.getShipImages());
			shipInfoModels.add(shipInfoModel);
		}
		map.put("ships", shipInfoModels);
		return map;
	}

	/**
	 * 新增游艇信息
	 * 例子：http://localhost:8080/ship_administrtaion/APIship/AddShipInfo.do
	 * ?shipName=山河智能&shipTypeCode=1&shipSize=43&shipCapacity=8
	 * 
	 * @param shipInfo
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/AddShipInfo.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	Map apiAddShipInfo(ShipInfo shipInfo) throws UnsupportedEncodingException {
		Map<String, String> map = new HashMap<String, String>();
		if (shipInfo != null) {
			if (shipInfo.getShipName().equals("")) {
				map.put("result", "shipName:null");
			} else if (shipInfo.getShipTypeCode() == 0) {
				map.put("result", "shipTypeCode:null");
			} else {
				ShipInfo ship = shipInfoService.queryByShipName(shipInfo
						.getShipName());
				if (ship != null) {
					map.put("result", shipInfo.getShipName() + ":existing");
				} else {
					shipInfoService.save(shipInfo);
					map.put("result", "success");
				}
			}
		} else {
			map.put("result", "error");
		}
		return map;
	}
}
