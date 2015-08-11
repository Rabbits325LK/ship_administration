package org.ship.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ship.model.ShipInfo;
import org.ship.service.IShipInfoService;
import org.ship.service.IShipTypeService;
import org.ship.util.PageResults;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ShipSimulationTest {

	@Resource 
	private IShipInfoService shipInfoService;
	@Resource
	private IShipTypeService shipTypeService;
	/*@Resource 
	private IShipOperationService shipOperationService;*/
	
	/**
	 * 模拟对游艇信息及预定的实际操作
	 */
	
	/*
	 * 1.
	 * 添加一条游艇信息
	 * 船名：山河智能
	 * 大小：43尺
	 * 类型：游艇
	 * 载量：8人
	 * 图片：Null
	 */
	/*@Test
	public void addShipInfo(){
		ShipInfo shipInfo = new ShipInfo();
		shipInfo.setShipName("双湾游艇");
		shipInfo.setShipSize("55");
		
		*//**
		 * 默认表达 选择游艇类型
		 *//*
		ShipType shipType = shipTypeService.queryByCode((long)1);
		shipInfo.setShipTypeCode(shipType.getShipTypeCode());
		shipInfo.setShipCapacity("14");
		System.out.println("添加游艇信息表单完毕，点击提交");
		shipInfoService.save(shipInfo);
		System.out.println("提交完成");
	}*/
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	/*
	 * 2.
	 * 查询游艇列表（分页）
	 */
	@Test
	public void queryByPage(){
		//点击进入游艇列表 默认第一页
		PageResults page = new PageResults();
		List<ShipInfo> ships = shipInfoService.findByPage(page.getPageNo()).getResults();
		for(ShipInfo ship : ships){
			System.out.println(ship.getShipName());
		}
	}
}
