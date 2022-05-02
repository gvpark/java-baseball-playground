package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void split() {
        String[] actuals = "1,2".split(",");
        assertThat(actuals).contains(actuals[0],"1");
        assertThat(actuals).contains(actuals[1],"2");
        assertThat(actuals).containsExactly("1","2");

        actuals = "1".split(",");
        assertThat(actuals).containsExactly("1");
    }
    @Test
    void substring() {
        String str = "(1,2)".substring(1,4);
        assertThat(str).isEqualTo("1,2");
    }

    @DisplayName("assertThatThrownBy를 이용한 예외처리")
    @Test
    void charTest() {
        String str = "abc";
        int index = 5;

        assertThatThrownBy(() -> {
            char c = str.charAt(index);
            assertThat(c).isEqualTo('c');
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }

    @DisplayName("assertThatExceptionOfType를 이용한 예외처리")
    @Test
    void charTest2(){
        String str = "abd";
        int index = 5;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = str.charAt(index);
                    assertThat(c).isEqualTo('c');
                }).withMessageContaining("%d", index);
    }

}
