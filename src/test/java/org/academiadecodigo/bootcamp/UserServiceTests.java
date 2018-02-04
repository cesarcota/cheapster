package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.models.User;
import org.academiadecodigo.bootcamp.services.MockUserService;
import org.academiadecodigo.bootcamp.services.UserService;
import org.academiadecodigo.bootcamp.utils.Security;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static junit.framework.TestCase.*;



public class UserServiceTests {

    private UserService userService = new MockUserService();
    private User user1;
    private User user2;


    @Before
    public void setup(){
        user1 = new User();
        user1.setUserName("cesar");
        user1.setPassword(Security.getHash("cesar"));
        user1.setEmail("cesar@cesar.com");

        user2 = new User();
        user2.setUserName("luis");
        user2.setPassword(Security.getHash("luis"));
        user2.setEmail("luis@cesar.com");
    }

    @Test
    public void shouldNotAddANullUser(){
        userService.addUser(null);
        assertTrue(userService.findAllUsers().size() == 0);
    }
    @Test
    public void shouldAddAnewUserWithEmptyMap(){
        userService.addUser(user2);
        assertTrue(userService.findAllUsers().size() == 1);
    }

    @Test
    public void findByEmailShouldReturnSameUser(){
        userService.addUser(user1);
        User user = userService.findByEmail("cesar@cesar.com");
         assertTrue(user.equals(user));
    }

    @Test
    public void findAllShouldReturnAList(){
        assertTrue(userService.findAllUsers() instanceof List);
    }
    @Test
    public void findAllShouldReturnAListContainingAllRegisteredUsers(){
        userService.addUser(user1);
        userService.addUser(user2);

        assertTrue(userService.findAllUsers().size() == 2);
        assertTrue(userService.findAllUsers().contains(user1));
        assertTrue(userService.findAllUsers().contains(user2));
    }

    @Test
    public void removeUserShouldRemoveTheUserFromTheList(){
        userService.addUser(user1);
        userService.addUser(user2);

        assertTrue(userService.findAllUsers().size() == 2);
        userService.removeUser(user1);
        assertTrue(userService.findByEmail(user1.getEmail()) == null);
        assertTrue(userService.findAllUsers().size() == 1);
    }

    @Test
    public void shouldNotBePossibleToRemoveANullUser(){
        userService.addUser(user1);
        assertTrue(userService.findAllUsers().size() == 1);
        userService.removeUser(null);
        assertTrue(userService.findAllUsers().size() == 1);
    }


}
