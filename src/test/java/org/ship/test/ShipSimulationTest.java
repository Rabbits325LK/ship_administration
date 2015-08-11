package org.ship.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ship.model.ShipInfo;
import org.ship.model.ShipOperation;
import org.ship.model.ShipType;
import org.ship.model.UserInfo;
import org.ship.service.IShipInfoService;
import org.ship.service.IShipOperationService;
import org.ship.service.IShipTypeService;
import org.ship.service.IUserInfoService;
import org.ship.util.PageResults;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-hibernate.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ShipSimulationTest {

	@Resource
	private IUserInfoService userInfoService;
	@Resource
	private IShipInfoService shipInfoService;
	@Resource
	private IShipTypeService shipTypeService;
	@Resource
	private IShipOperationService shipOperationService;

	/**
	 * 模拟对游艇信息及预定的实际操作
	 */

	/*
	 * 1. 添加一条游艇信息 船名：山河智能 大小：43尺 类型：游艇 载量：8人 图片：Null
	 */
	// @Test
	public void addShipInfo() {
		String shipName = "双湾游艇";
		ShipInfo ship = shipInfoService.queryByShipName(shipName);
		if (null != ship) {
			System.out.println(shipName + "已存在");
		} else {
			ShipInfo shipInfo = new ShipInfo();
			shipInfo.setShipName(shipName);
			shipInfo.setShipSize("55");
			/**
			 * 默认表达 选择游艇类型
			 */
			ShipType shipType = shipTypeService.queryByCode((long) 1);
			shipInfo.setShipTypeCode(shipType.getShipTypeCode());
			shipInfo.setShipCapacity("14");
			System.out.println("添加游艇信息表单完毕，点击提交");
			shipInfoService.save(shipInfo);
			System.out.println("提交完成");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	/*
	 * 2. 查询游艇列表（分页）
	 */
	// @Test
	public void queryByPage() {
		// 点击进入游艇列表 默认第一页
		PageResults page = new PageResults();
		List<ShipInfo> ships = shipInfoService.findByPage(page.getPageNo())
				.getResults();
		for (ShipInfo ship : ships) {
			System.out.println(ship.getShipName());
		}
	}

	/**
	 * 模拟点击列表中某条船艇查看信息信息
	 */
	// @Test
	public void queryById() {
		long shipId = 1;
		ShipInfo ship = shipInfoService.getById(shipId);
		System.out.println("船名：" + ship.getShipName());
		System.out.println("尺寸：" + ship.getShipSize());
		if (ship.getShipTypeCode() == 1) {
			System.out.println("类型：游艇");
		} else if (ship.getShipTypeCode() == 2) {
			System.out.println("类型：帆船");
		} else if (ship.getShipTypeCode() == 3) {
			System.out.println("类型：快艇");
		} else {
			System.out.println("类型：摩托艇");
		}
		System.out.println("载量：" + ship.getShipCapacity());
	}

	/**
	 * 模拟预订
	 * 
	 * @throws ParseException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void OrderShip() throws ParseException {
		// 模拟用户 rabbits325
		// 模拟预订船艇 荣超地产
		long userId = 1;
		long shipId = 1;
		/*
		 * state 1 预订 2已受理 3.已执行 4.已作废
		 */
		long shipState = 1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 小写的mm表示的是分钟
		sdf.setLenient(false);
		 String strat="2015-08-12 08:43:00"; 
		 String end ="2015-08-12 07:42:00";
		 
		//String strat = "2015-08-12 14:45:00";
		//String end = "2015-08-12 16:45:00";
		java.sql.Timestamp stratime = new java.sql.Timestamp(System.currentTimeMillis());
		java.sql.Timestamp endtime = new java.sql.Timestamp(System.currentTimeMillis());
		stratime.valueOf(strat);
		endtime.valueOf(end);
		
		ShipOperation so = new ShipOperation();
		so.setUserId(userId);
		so.setShipId(shipId);
		so.setShipState(shipState);
		so.setStratime(stratime);
		so.setEndtime(endtime);
		boolean flag = shipOperationService.queryByShipTime(so);
		System.out.println(flag);
		if (flag == false) {
			shipOperationService.save(so);
			System.out.println("预约成功");
		} else {
			System.out.println("该时间段已被预约");
		}
	}

	/**
	 * 模拟管理员查询预订船艇及进行受理操作
	 */
	//@Test
	public void queryOrderShipInfo() {
		/**
		 * 模拟查看列表
		 */
		System.out.println("现在管理员进入了游艇预订页面");
		PageResults<ShipOperation> page = new PageResults<ShipOperation>();
		List<ShipOperation> sos = shipOperationService.queryOrderShipInfo(
				page.getPageNo()).getResults();
		for(ShipOperation so : sos ){
			ShipInfo ship = shipInfoService.getById(so.getShipId());
			UserInfo user = userInfoService.queryById(so.getUserId());
			System.out.println("------------------------------------------");
			System.out.println(user.getUserName()+" 预订的 "+ship.getShipName()+"："+so.getEndtime()+" 到 "+so.getEndtime());
			System.out.println("__________________________________________");
		}
		/**
		 * 模拟受理操作
		 */
		System.out.println("对第一个进行受理操作");
		ShipOperation so = shipOperationService.getByCode((long)1);
		shipOperationService.updateStatePass(so);
		System.out.println("操作完成");
	}
}
