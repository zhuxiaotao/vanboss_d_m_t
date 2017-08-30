package cn.vanboss.modbus.drive;
import java.io.IOException;

public class Program {
	/*已上传至github上*/
	/*第一个版本v1.0(tag)*/
	/*第一个开发版分支*/
	/**modbus测试读写主程序
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		try {
			//创建两个modbus数据交互线程
			modbus_thread mt1 = new modbus_thread("192.168.200.142", 2);
			Thread t1 = new Thread(mt1, "modbus_142_2");
			//启动modbus数据交互线程
			t1.start();
		} catch (Exception e) {
			System.out.println("modbus驱动线程异常"+e.getMessage());
		}
	}
}
