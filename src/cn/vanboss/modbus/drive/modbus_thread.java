package cn.vanboss.modbus.drive;
import java.util.Random;
/*modbus协议数据交互线程类*/
public class modbus_thread extends Thread {
	// modbus的ip地址 及id从站号
	private String ipset = "";
	private Integer idset = 0;
	// 构造方法给ip及id赋值
	public modbus_thread(String ip, Integer id) {
		ipset = ip;
		idset = id;
	}
	// modbus数据交互线程
	public void run() {
		// 给modbus驱动设置ip及id
		@SuppressWarnings("unused")
		MasterExample Master = new MasterExample(ipset, idset);
		while (true) {
			try {
				// AccessToModbus为读数据与写入数据的方法
				//Master.AccessToModbus();
				//modbus读取操作
				String readModbusstr = Master.readModbus(1, 10);
				System.out.println("读出数据为: "+readModbusstr);
				//modbus写入操作
				//make假数据操作
				//最多十个数据用&分割拼接到一起
				Random random = new Random();
				String str = new String();
				int nextInt=0;
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < 10; i++) {
					nextInt = random.nextInt(100);
					sb.append(str.valueOf(nextInt)+"&");
				}
				//去除最后一个&
				String substring = sb.toString().substring(0, sb.length()-1);
				//执行modbus写入操作
				Master.writeModbus(1,substring);
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("modbus驱动线程异常" + e.getMessage());
			}
		}
	}
}
