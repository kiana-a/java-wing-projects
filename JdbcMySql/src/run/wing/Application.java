package run.wing;

import run.wing.model.dao.PersonDao;
import run.wing.model.dao.TaskDao;
import run.wing.model.to.Person;
import run.wing.model.to.Task;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by kiana on 12/26/17.
 */
public class Application {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
//        personDao.save(new Person("kiana","Ahmadi",19));
//        personDao.save(new Person("Mohammad","Karimian",24));
//        personDao.save(new Person("John","Doe",23));
//        personDao.save(new Person("Frashad","Ebrahimi",37));
//        personDao.save(new Person("Blah Blah","blah blah",30));
//        personDao.save(new Person("Dorsa","Najjari",29));
//        personDao.save(new Person("Akbar","Abdi",80));
//        personDao.save(new Person("abbas","Karimi",78));
//        personDao.save(new Person("Yasaman","karimi",20));
//        personDao.save(new Person("pouria","Nasseri",68));
//        personDao.save(new Person("Saber","Khosravi",31));
//        personDao.save(new Person("Mohammad Saber","Taherian",29));
//        personDao.save(new Person("Seyed Hani","Emam Jomeh",33));
//        personDao.save(new Person("Ali","Malek",25));
//        personDao.save(new Person("Ali","Haghighat Doost",24));
//        personDao.save(new Person("Jeff","Mousavi",24));
        //System.out.println(personDao.find(1));
//        System.out.println(personDao.findAll());
        // personDao.delete(new Person((int id = 1)));

//        personDao.tenLastPerson();
//    System.out.println(personDao.tenLastPerson());
//        System.out.println(personDao.findAll());
//
//        personDao.delete(5);
//        System.out.println(personDao.findAll());

//        Person person = personDao.find(1);
//        person.setAge(21);
//        personDao.update(person);

        //System.out.println(personDao.getPersonAgeAvg());

        //personDao.insertBatch();
//        System.out.println(personDao.getPersonCount());

        TaskDao taskDao = new TaskDao();
//        Person person = personDao.find(2);
////
//        Calendar startCalendar = new GregorianCalendar();
//        Calendar endCalendar = new GregorianCalendar();
//        startCalendar.set(2018, Calendar.JANUARY, 5, 11, 0);
//        endCalendar.set(2019, Calendar.JANUARY, 7, 22, 0);

//        Task task = new Task(
//                new Date(startCalendar.getTime().getTime()),
//                new Date(endCalendar.getTime().getTime()),
//                4, "mobillet", person);

//        taskDao.save(task);


//        startCalendar.set(2017, Calendar.JANUARY, 3, 10, 0);
//        endCalendar.set(2018, Calendar.JANUARY, 7, 22, 0);
//        Task task1 = new Task(
//                new Date(startCalendar.getTime().getTime()),
//                new Date(endCalendar.getTime().getTime()),
//                2, "Hamsaa", person);
//        taskDao.save(task1);

//        Task task2 = new Task(
//                new Date(startCalendar.getTime().getTime()),
//                new Date(endCalendar.getTime().getTime()),
//                3,"Mobillet", person
//        );
//        taskDao.save(task2);
//        System.out.println(taskDao.findByPersonId(1));
        //System.out.println(taskDao.findByPersonId(2));
        System.out.println(taskDao.findAllTasks());
    }
}
