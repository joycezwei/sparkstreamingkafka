package com.st.zsjspark.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.zsjspark.model.Machine;
import com.st.zsjspark.model.Original;
import com.st.zsjspark.service.IKafkaProducerService;
import com.st.zsjspark.service.IMachineService;
import com.st.zsjspark.service.IOriginalService;

/**
 * 
 * 
 * @author hzl
 * @date Dec 16, 2016
 * 
 */
@Controller
@RequestMapping("/DataReController")
public class DataReController {

	@Resource
	private IOriginalService originalService;
	@Resource
	private IMachineService machineService;
	@Resource
	private IKafkaProducerService kafkaProducerService;
	public int flag = 1;

	@RequestMapping(value = "/addNew.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void insertNewRecord(Machine machine) {
		machine.setExtend1(1 + "");
		machineService.update(machine);
		Map<String, String> map = new HashMap<String, String>();
		map.put("groupId", machine.getExtend());
		map.put("machineCode", machine.getMachineCode());
		Original o = originalService.getData(map).get(0);
		o.setmachineCode(map.get("machineCode"));
		o.setKey(o.getKey().replace(o.getmachineCode(), map.get("machineCode")));
		o.setTime(System.currentTimeMillis());
		o.setId(null);
		originalService.insert(o);
	}

	@RequestMapping(value = "/datare.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void updateRecord(final Machine machine) {
		new Thread() {
			@Override
			public void run() {
				machine.setExtend1(2 + "");
				machineService.update(machine);
				Map<String, String> map = new HashMap<String, String>();
				map.put("groupId", machine.getExtend());
				map.put("machineCode", machine.getMachineCode());
				List<Original> olist = originalService.getData(map);
				String nowTime = "";
				long t = 0;
				long ot = 0;
				for (Original o : olist) {
					nowTime = System.currentTimeMillis() + "";
					// kafkaProducerService.sendMessage(
					// o.getKey().replace(o.getmachineCode(),
					// map.get("machineCode")),
					// messageForSend.toString());
					kafkaProducerService.sendMessage(
							o.getKey().replace(o.getmachineCode(),
									map.get("machineCode")),
							o.getKey().replace(o.getmachineCode(),
									map.get("machineCode"))
									+ o.getValue());
					t = o.getTime() - ot;
					if (ot != 0) {
						try {
							Thread.sleep(t);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					Map<String, String> mapMachine = new HashMap<String, String>();
					mapMachine.put("machineCode", machine.getMachineCode());
					mapMachine.put("extend1", "3");
					List<Machine> maclist = machineService
							.findByStatus(mapMachine);
					if (!maclist.isEmpty()) {
						flag = 0;
						String stopTopic = "Data_OPCServerId-1_MachineCode-"
								+ machine.getMachineCode()
								+ "_GroupName-realTime";
						String stopValue = "{" + "\"" + "Open_Mold_Number"
								+ "\"" + ":" + "0" + "," + "\"" + "OP_MODE"
								+ "\"" + ":" + "0" + "," + "\"" + "State"
								+ "\"" + ":" + "0" + "," + "\""
								+ "ShowCycleTime" + "\"" + ":" + "0" + ","
								+ "\"" + "ActCylicTime" + "\"" + ":" + "0"
								+ "," + "\"" + "sTotalMoldNumber" + "\"" + ":"
								+ "0" + "}";
						kafkaProducerService.sendMessage(stopTopic, stopTopic
								+ stopValue);
						break;
					}
					flag = 1;
					ot = o.getTime();
				}
				if (flag != 0) {
					machine.setExtend1(4 + "");
					machineService.update(machine);
				}
			}
		}.start();
	};

	@RequestMapping(value = "/stop.action", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void stop(Machine machine) {
		machine.setExtend1(3 + "");
		machineService.update(machine);
	}
}
