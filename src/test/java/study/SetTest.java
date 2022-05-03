package study;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set 크기확인")
    @Test
    void setSize(){

        System.out.println("numbers의 Size확인 " + numbers.size());
        assertEquals(3,numbers.size());
    }

    @DisplayName("Contain() 활용한 인자확인 > 중복된 코드사용")
    @Test
    void setContain(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("ParameterizedTest 활용")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void abc(int input){
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("CsvSoure를 활용")
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    void csvSourceContains(String input, String expected){
        boolean actualNum = numbers.contains(Integer.parseInt(input));
        System.out.println(actualNum);
        assertEquals(Boolean.parseBoolean(expected), actualNum);
    }
}
