package com.github;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

/*
    Необходимо замокать nameService и протестировать userService.getUserName
    TODO
        Использовать аннотацию запуска проекта с использованием SpringJUnit4ClassRunner
        Использовать аннотацию SpringBootTest вместе с MocksApplication.class
        Добавить ссылка на UserService
        Добавить ссылку на NameService
        Написать функцию для тестирования userService которая мокает nameService и возвращает "Mock user name"
*/
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceUnitTest {

    @Mock
    private NameService nameService;
    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserName(){
        String userId = "3as";
        when(nameService.getUserName(eq("3as"))).thenReturn("Mock user name");

        assertEquals("Mock user name", userService.getUserName("3as"));
    }
}