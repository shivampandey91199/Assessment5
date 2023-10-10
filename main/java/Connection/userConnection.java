package Connection;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Model.userModel;
public class userConnection {
	public static Session getSession() {
		Session session = null;
		SessionFactory sf = null;
		Configuration cfg = null;
		Properties props = null;
		props = new Properties();
		props.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		props.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/advance");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.connection.username", "root");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hiberenate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		cfg = new Configuration();
		cfg.setProperties(props).addAnnotatedClass(userModel.class);
		sf = cfg.buildSessionFactory();
		session = sf.openSession();
		return session;
	}
}
