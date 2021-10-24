package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestCrudApplicationTests {

	@Autowired
	UserService us ;
	
    @Test
	public void contextLoads() throws ParseException {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime date2 =currentTime.withDayOfMonth(25).withYear(2023).withMonth(12);
	
		System.out.println("******Exec******");
		User u = new User( "Mayssa"," Mayssa ", d , Role.INGENIEUR );
		User u1 = new User( "Ahlem"," Laajili ", d , Role.STUDENT );
		User u2 = new User( "Syrine"," Zahras", d , Role.STUDENT );
        //Add
		us.addUser(u);
       	us.addUser(u1);
       	us.addUser(u2);
       	//findbyid
	//	System.out.println("Retrieve"+us.retrieveUser(1L));
	//	us.updateUser(u);
		
		//findall
		List<User> users =new ArrayList<>();
		users=us.retrieveAllUsers();
			for(User user : users) {
		System.out.println("user+++"+user);
	}
			//delete
			//us.deleteUser(1L);
		//	us.deleteUser(2L);
			//update
			User u5= new User(9L,"testupdate"," testupdate", Role.TECHNICIEN ,d  );
             us.updateUser(u5);
		System.out.println("******Bye******");

    }

}
