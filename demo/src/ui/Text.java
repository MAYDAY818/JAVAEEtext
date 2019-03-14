package ui;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Customer;
import util.HibernateUtil;

public class Text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c1 = new Customer(2,"a",11);
		//打开session
		Session session = HibernateUtil.getSession();
		Transaction tr=session.beginTransaction();
		session.save(c1);
		tr.commit();
		session.close();

	}

}
