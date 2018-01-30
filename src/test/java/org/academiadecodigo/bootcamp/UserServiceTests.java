package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.models.User;
import org.academiadecodigo.bootcamp.services.MockUserService;
import org.academiadecodigo.bootcamp.services.UserService;
import org.academiadecodigo.bootcamp.utils.Security;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;



public class UserServiceTests {

    private UserService userService = new MockUserService();
    private User user1;
    private User user2;


    @Before
    public void setup(){
        user1 = new User();
        user1.setUserName("cesar");
        user1.setPassword(Security.getHash("cesar"));
        user1.setMail("cesar@cesar.com");

        user2 = new User();
        user2.setUserName("luis");
        user2.setPassword(Security.getHash("luis"));
        user2.setMail("luis@cesar.com");

        userService.addUser(user1);


    }

    @Test
    public void shouldNotAddANullUser(){
        userService.addUser(null);
        assertTrue(userService.findAllUsers().size() == 1);
    }
    @Test
    public void shouldAddAnewUserWithEmptyMap(){
        userService.addUser(user2);
        assertTrue(userService.findAllUsers().size() == 2);
    }

    @Test
    public void findByEmailShouldReturnSameUser(){
        User user = userService.findByEmail("cesar@cesar.com");
         assertTrue(user.equals(user));
    }

}
