package com.company;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class manageStudent {
    private static SessionFactory ourSessionFactory;
    public static void main(String[] args) {

        try {
            Configuration configuration = new Configuration();
            ourSessionFactory = configuration.configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        //manageStudent ss = new manageStudent();
        /*Integer st1=ss.addStudent1("Mero", "Elec. Engineer", 4.00);
        Integer st2=ss.addStudent1("Selo", "Insaat", 2.3);
        Integer st3=ss.addStudent1("Alo", "Chemistry", 3.26);
        ss.updateStudent1(st2,3.14);
        //ss.deleteStudent1(st2);
        Integer te1 = ss.addTeacher1("Alper","CE",64372);
        Integer te2 = ss.addTeacher1("Murat","CS",64086);
        Integer te3 = ss.addTeacher1("Ali","CSSH",55116);
        //List<teacher> ta = new ArrayList<>();
        //ss.inserTlist(ta);
        //ss.put_teacher_list(ta,st1);
        ss.insert_and_put_all(st1);
        ss.list_gpa();*/
        //ss.view_student("Mero");
    }

    /*public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }*/

    public Integer addStudent1(String name,String major,double gpa){
            Session session = ourSessionFactory.openSession();
            Transaction tx = null;
            Integer s =null;
            try{
                tx=session.beginTransaction();
                student st = new student();
                st.setGpa(gpa);
                st.setMajor(major);
                st.setName(name);
                s=(Integer) session.save(st);
                tx.commit();
            } catch(HibernateException e){
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
            return s;
    }

    public void updateStudent1(Integer s,double gpa){
            Session session = ourSessionFactory.openSession();
            Transaction tx = null;
            try{
                tx=session.beginTransaction();
                student st = session.get(student.class,s);
                st.setGpa(gpa);
                session.update(st);
                tx.commit();
            } catch(HibernateException e){
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
    }

    public void deleteStudent1(Integer s){
            Session session = ourSessionFactory.openSession();
            Transaction tx = null;

            try{
                tx=session.beginTransaction();
                student st =session.get(student.class,s);
                session.delete(st);
                tx.commit();
            }catch(HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
    }

    public void listStudents1(){
        Session session =ourSessionFactory.openSession();
        Transaction t = null;

        try{
            t=session.beginTransaction();
            List st= session.createQuery("FROM student").list();
            for(Iterator iterator=st.iterator();iterator.hasNext();){
                student ss= (student)iterator.next();
                System.out.print("id: "+ss.getId());
                System.out.print("Name: "+ss.getName());
                System.out.print("gpa: "+ss.getGpa());
                System.out.println("major: "+ss.getMajor());
            }
            t.commit();
        }catch(HibernateException er){
                if(t!=null) t.rollback();
                er.printStackTrace();
        }finally{
            session.close();
        }
    }

    public void put_teacher_list(List<teacher> t, Integer d){
        Session ss = ourSessionFactory.openSession();
        Transaction tt = null;

        try{
            tt = ss.beginTransaction();
            student st = ss.get(student.class,d);
            st.setTs(t);
            tt.commit();
        }catch (HibernateException hb){
            if (tt!=null) tt.rollback();
            hb.printStackTrace();
        }finally {
            ss.close();
        }
    }

    public Integer addTeacher1(String name,String faculty,int no){
        Session s1 = ourSessionFactory.openSession();
        Transaction t1 = null;
        Integer t =null;
        try{
            t1=s1.beginTransaction();
            teacher te = new teacher();
            te.setCourseId(no);
            te.setFaculty(faculty);
            te.setName(name);
            t=(Integer) s1.save(te);
            t1.commit();
        } catch(HibernateException e){
            if (t1!=null) t1.rollback();
            e.printStackTrace();
        } finally {
            s1.close();
        }
        return t;
    }

    public void inserTlist(List<teacher> ta){
        Session session = ourSessionFactory.openSession();
        Transaction ts = null;
        try{
            ts=session.beginTransaction();
            List st= session.createQuery("FROM teacher").list();
            for(Iterator iterator=st.iterator();iterator.hasNext();){
                teacher ss= (teacher) iterator.next();
                ta.add(ss);
            }
        } catch (HibernateException e){
            if (ts!=null) ts.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void insert_and_put_all(Integer s){
        Session session = ourSessionFactory.openSession();
        Transaction ts = null;
        try{
            ts=session.beginTransaction();
            student st = session.get(student.class,s);
            List t = session.createQuery("FROM teacher").list();
            st.setTs(t);
            ts.commit();
        }catch(HibernateException e){
            if (ts!=null) ts.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void list_gpa(){
        Session ses = ourSessionFactory.openSession();
        Transaction t = null;

        try{
            t=ses.beginTransaction();
            List gpa =ses.createQuery("SELECT st.gpa FROM student st").list();
            for(Iterator iterator=gpa.iterator();iterator.hasNext();) {
                double g = (double) iterator.next();
                System.out.println("gpa: " + g);
            }
            t.commit();
        }catch(HibernateException e) {
            if (t!=null) t.rollback();
            e.printStackTrace();
        }finally{
            ses.close();
        }
    }

    public void view_student(String name){
        Session session = ourSessionFactory.openSession();
        Transaction ts = null;

        try{
            ts = session.beginTransaction();
            Query query = session.createQuery("from student st where st.name = :namer");
            query.setParameter("namer",name);
            student st =(student)query.list().get(0);
            System.out.println("id: "+st.getId());
            System.out.println("Name: "+st.getName());
            System.out.println("gpa: "+st.getGpa());
            System.out.println("major: "+st.getMajor());
            ts.commit();
        }catch(HibernateException h){
            if(ts!=null) ts.rollback();
            h.printStackTrace();
        }finally{
            session.close();
        }
    }
}
