import java.util.Calendar;
import java.util.Date;

import Control.Connect;

public class main {
	public static void main(String args[]) {
		try {
			Connect conn = new Connect();
			
	       Calendar ca = Calendar.getInstance();
	       
	       ca.set(2020, 7, 6);
	       
	       conn.themMatHang("Vở", "Dùng để viết", "Cây", "Việt Nam", "Thiên Long",ca.getTime());
	       conn.suaMatHang(12, "VởSach", "Dùng để viết", "Cây", "Việt Nam", "Thiên Long",ca.getTime());
	       conn.danhSachMatHang();
			
			
			
		}catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
