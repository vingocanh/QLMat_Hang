package Control;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.MatHang;

public class Connect {
	public static SessionFactory sessionfactory = null;

	public Connect() {
		try {
			Configuration configuration = new Configuration();
			sessionfactory = configuration.configure().buildSessionFactory();
		}catch(Throwable ex) {
				ex.printStackTrace();
		}
		
	}
	
	public int themMatHang(String tenMH, String moTa, String chatLieu, String noiSX ,String hangSX, Date ngaySX) {
		Session session = sessionfactory.openSession();
		Transaction tx = null;
		int id = 0;
		try {
			tx = session.beginTransaction();
			MatHang matHang = new MatHang(tenMH, moTa, chatLieu, noiSX, hangSX, ngaySX);
			id =  (int) session.save(matHang);
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}

		} finally {
			session.close();
		}
		return id;
	}
	
	public void suaMatHang(int id, String tenMH, String moTa, String chatLieu, String noiSX ,String hangSX, Date ngaySX) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		try { 
			MatHang matHang = session.get(MatHang.class, id);
			matHang.setTenMH(tenMH);
			matHang.setMoTa(moTa);
			matHang.setChatLieu(chatLieu);
			matHang.setNoiSX(noiSX);
			matHang.setHangSX(hangSX);
			matHang.setNgaySX(ngaySX);
			session.update(matHang);
			
			tx.commit();
		}catch(HibernateException ex) {
			if(tx!=null) tx.rollback();
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
	}
	
	public void xoaMatHang(int id) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		try { 
			MatHang matHang = session.get(MatHang.class, id);
			session.delete(matHang);
			tx.commit();
		}catch(HibernateException ex) {
			if(tx!=null) tx.rollback();
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
	}
	
	public List<MatHang> danhSachMatHang() {
		List<MatHang> list = null;
		Session session = sessionfactory.openSession();
		
		try {
			 list = session.createQuery("From MatHang").list();
			 for(MatHang sv: list) {
				 System.out.println("ID: "+sv.getId());
				 System.out.println("Ten MH: "+sv.getTenMH());
				 System.out.println("Mo Ta: "+sv.getMoTa());
				 System.out.println("Chat Lieu: "+sv.getChatLieu());
				 System.out.println("Noi SX: "+sv.getNoiSX());
				 System.out.println("Ngay SX: "+sv.getNgaySX());
				 System.out.println("Hang SX: "+sv.getHangSX());
				 
			 }
		}catch(HibernateException ex) {
			
		}finally {
			session.close();
		}
		return list;
		
	}
}
