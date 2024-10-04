package org.example.expert.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class PasswordEncoderTest {

    @InjectMocks
    private PasswordEncoder passwordEncoder;

    @Test
    void matches_메서드가_정상적으로_동작한다() {
        // given
        String rawPassword = "testPassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // when
        //matchesr가 (String rawPassword, String encodedPassword)순으로 정의되어있기 때문에 encodedPassword와 rawPassword의 순서를 바꿔야한다
        boolean matches = passwordEncoder.matches(encodedPassword, rawPassword);

        // then
        assertTrue(matches);
    }
}
