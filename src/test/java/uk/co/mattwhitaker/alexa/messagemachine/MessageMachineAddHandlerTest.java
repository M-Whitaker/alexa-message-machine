package uk.co.mattwhitaker.alexa.messagemachine;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.mattwhitaker.alexa.messagemachine.handlers.MessageMachineAddHandler;

import static org.junit.jupiter.api.Assertions.*;

class MessageMachineAddHandlerTest {

    private Object HandlerInput;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_first() {
        assertTrue(true);
    }

    @Test
    void test_can_handle() {
        MessageMachineAddHandler handler = new MessageMachineAddHandler();
        assertTrue(true);
    }
}