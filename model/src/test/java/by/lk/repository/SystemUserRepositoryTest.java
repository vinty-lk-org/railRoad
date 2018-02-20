package by.lk.repository;

import by.lk.config.RootConfig;
import by.lk.entity.Privilege;
import by.lk.entity.SystemUser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

public class SystemUserRepositoryTest extends CommonTest{

    private SystemUser id;

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Test
    public void findByEmailTest() {
        Privilege privilege = new Privilege();
        privilege.setId(1L);

        SystemUser systemUser = new SystemUser();
        systemUser.setNameUser("Виталий");
        systemUser.setFamilyUser("Ушаков");
        systemUser.setPasswordUser("1");
        systemUser.setEmail("vinty@i.ua");
        systemUser.setPrivilege(privilege);

        id = systemUserRepository.save(systemUser);
        SystemUser userFromDb = systemUserRepository.findOne(id.getId());
        Assert.assertEquals("Сравнение двух ID: ",id.getId(), userFromDb.getId());
    }

    @After
    public void finish() {
        systemUserRepository.delete(id);
        final SystemUser one = systemUserRepository.findOne(id.getId());
        assertNull(one);
    }
}