package tn.esprit.spring;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.class)
@SpringBootTest
public class BlocServiceMockTest {

    @Mock
    private List<String> mockList;

    @BeforeEach
    void beforeEach() {
        // Example interaction with mock
        Mockito.reset(mockList);
    }

    @AfterEach
    void afterEach() {
        // Clean up after each test
    }

    @Order(1)
    @RepeatedTest(4)
    void test() {
        Mockito.when(mockList.size()).thenReturn(10);
        Assertions.assertEquals(10, mockList.size());
        Mockito.verify(mockList).size();
    }

    @Order(4)
    @Test
    void test2() {
        Mockito.when(mockList.isEmpty()).thenReturn(true);
        Assertions.assertTrue(mockList.isEmpty());
        Mockito.verify(mockList).isEmpty();
    }

    @Order(2)
    @Test
    void test3() {
        mockList.add("Hello");
        Mockito.verify(mockList).add("Hello");
    }

    @Order(3)
    @Test
    void test4() {
        Mockito.when(mockList.get(0)).thenReturn("World");
        Assertions.assertEquals("World", mockList.get(0));
        Mockito.verify(mockList).get(0);
    }
}
