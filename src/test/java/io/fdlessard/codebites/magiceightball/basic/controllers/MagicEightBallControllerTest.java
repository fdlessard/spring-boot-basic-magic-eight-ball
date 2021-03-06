package io.fdlessard.codebites.magiceightball.basic.controllers;

import io.fdlessard.codebites.magiceightball.basic.domain.MagicEightBallAnswer;
import io.fdlessard.codebites.magiceightball.basic.services.MagicEightBallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class MagicEightBallControllerTest {

    @Mock
    private MagicEightBallService magicEightBallService;

    private MagicEightBallController magicEightBallController;

    @BeforeEach
    void beforeEach() {
        magicEightBallController = new MagicEightBallController(magicEightBallService);
    }

    @Test
    void isAlive() {
        assertEquals(MagicEightBallController.IS_ALIVE, magicEightBallController.isAlive());
    }

    @Test
    void shake() {

        MagicEightBallAnswer magicEightBallAnswer = new MagicEightBallAnswer(0, "message", "color");
        Mockito.when(magicEightBallService.shake()).thenReturn(magicEightBallAnswer);
        assertEquals(magicEightBallAnswer, magicEightBallController.shake());
    }

    @Test
    void getAll() {

        List<MagicEightBallAnswer> magicEightBallAnswers = Arrays.asList(
                new MagicEightBallAnswer(1, "message1", "color1"),
                new MagicEightBallAnswer(2, "message2", "color2")
        );

        Mockito.when(magicEightBallService.getAll()).thenReturn(magicEightBallAnswers);

        List<MagicEightBallAnswer> mebas = magicEightBallController.getAll();
        assertEquals(2, mebas.size());
        assertEquals(new MagicEightBallAnswer(1, "message1", "color1"), mebas.get(0));
        assertEquals(new MagicEightBallAnswer(2, "message2", "color2"), mebas.get(1));
    }
}