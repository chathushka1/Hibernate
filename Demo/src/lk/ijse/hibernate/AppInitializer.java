package lk.ijse.hibernate;

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {

        //Method body is under construction hence
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Chathu");
        customer.setAddress("Galle");
        customer.setSalary(5000);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Kamal");
        customer2.setAddress("Galle");
        customer2.setSalary(6000);
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        session.save(customer2);
        transaction.commit();
        session.clear();
    }
}
