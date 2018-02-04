package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.models.Group;
import org.academiadecodigo.bootcamp.services.GroupService;
import org.academiadecodigo.bootcamp.services.MockGroupService;
import org.academiadecodigo.bootcamp.utils.Type;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.*;

public class GroupServicesTests {

    private GroupService groupService = new MockGroupService();
    private Group group1;
    private Group group2;
    private Group group3;

    @Before
    public void setup(){
        group1 = new Group();
        group1.setId(1);
        group1.setGroupName("group1");
        group1.setType(Type.BEER);

        group2 = new Group();
        group2.setId(2);
        group2.setGroupName("group2");
        group2.setType(Type.COFFEE);

        group3 = new Group();
        group3.setId(3);
        group3.setGroupName("group3");
        group3.setType(Type.MEALS);
    }

    @Test
    public void ShouldNotAddANullGroup(){
        assertTrue(groupService.findAllGroups().size() == 0);
        groupService.addGroup(null);
        assertTrue(groupService.findAllGroups().size() == 0);
    }

    @Test
    public void shouldAddAPreValidatedGroup(){
        assertTrue(groupService.findAllGroups().size() == 0);
        groupService.addGroup(group1);

        groupService.addGroup(group2);
        assertTrue(groupService.findAllGroups().size() == 2);
    }

    @Test
    public void returnedGroupFromFindAllShouldBeTheSameInsertedPreviously() {
        assertTrue(groupService.findAllGroups().size() == 0);
        groupService.addGroup(group1);
        groupService.addGroup(group2);
        assertTrue(groupService.findAllGroups().size() == 2);

        assertTrue(groupService.findById(group1.getId()).equals(group1));

        Group newGroupEqualToGroupOne = new Group();
        newGroupEqualToGroupOne.setId(1);
        newGroupEqualToGroupOne.setGroupName("group1");
        newGroupEqualToGroupOne.setType(Type.BEER);
        groupService.addGroup(newGroupEqualToGroupOne);

        assertFalse(!groupService.findById(group1.getId()).equals(newGroupEqualToGroupOne));
    }


    @Test
    public void findAllShouldReturnAList(){
        assertTrue(groupService.findAllGroups() instanceof List);
    }



    @Test
    public void shouldNotRemoveAnyUserIfGivenUserIsNotOnTheList(){
        groupService.addGroup(group1);
        groupService.addGroup(group2);
        assertTrue(groupService.findAllGroups().size() == 2);

        groupService.removeGroup(null);
        assertTrue(groupService.findAllGroups().size() == 2);

        groupService.removeGroup(group3);
        assertTrue(groupService.findAllGroups().size() == 2);
    }

    @Test
    public void shouldRemoveGroupIfGroupIsOnTheList(){
        groupService.addGroup(group1);
        groupService.addGroup(group2);
        assertTrue(groupService.findAllGroups().size() == 2);

        groupService.removeGroup(group2);
        assertTrue(groupService.findAllGroups().size() == 1);
        assertTrue(groupService.findById(group2.getId()) == null);

    }

    @Test
    public void findByIdShouldReturnANullGroupIfIstNotOnTheList(){
        groupService.addGroup(group1);
        groupService.addGroup(group2);

        assertTrue(groupService.findById(group3.getId()) == null);
    }

    @Test
    public void findByIdShouldReturnTheAskedGroup(){
        groupService.addGroup(group1);
        groupService.addGroup(group2);
        assertTrue(groupService.findAllGroups().size() == 2);

        assertTrue(groupService.findById(group1.getId()).equals(group1));
    }






}
