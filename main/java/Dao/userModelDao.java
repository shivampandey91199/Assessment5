package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Connection.userConnection;
import Model.userModel;

public class userModelDao {

	public static void inserUser(userModel um) {
		Session session = new userConnection().getSession();
		Transaction tx = session.beginTransaction();
		session.save(um);
		tx.commit();
		session.close();
	}

	public static userModel loginUser(userModel um) {
		Session session = new userConnection().getSession();
		Transaction tx = session.beginTransaction();
		String hql = "from userModel u where u.email=:email and u.password=:password";
		Query query = session.createQuery(hql);
        query.setParameter("email",um.getEmail());
        query.setParameter("password",um.getPassword());
        List list=query.list();
        userModel umodel=(userModel)list.get(0);
        System.out.println("login");
        return umodel;
	}
	
	
	public static void updatePassword(userModel um, int id,String password) {
		Session session=new userConnection().getSession();
		Transaction tx=session.beginTransaction();
		String hql="update userModel u  set u.password=:password where u.id=:id";
		Query query=session.createQuery(hql);
		query.setParameter("password",password);
		query.setParameter("id",id);
		int result=query.executeUpdate();
		System.out.println("password updated...");
	}
	
	public static boolean checkEmail(String email) {
		boolean flag = false;
		Session session=new userConnection().getSession();
		Transaction tx=session.beginTransaction();
		String hql="from userModel u where u.email=:email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		List list=query.list();
	   userModel model =(userModel)list.get(0);
	    if(model !=null) {
	    	flag = true;
	    }
		return flag;
	}
}
