package uk.co.mattwhitaker.alexa.messagemachine.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static org.apache.logging.log4j.LogManager.getLogger;

public class MessageMachineAddHandler implements RequestHandler {
    private static final Logger logger = getLogger(MessageMachineAddHandler.class);
    private List<String> queueOfNotifications = new ArrayList<>();

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("add"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        logger.error("Received request: " + input.getRequestEnvelopeJson());
        IntentRequest intentRequest = (IntentRequest) input.getRequestEnvelope().getRequest();

        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        String item = slots.get("item").getValue();

        queueOfNotifications.add(item);
        String speechText = String.format("Your list is now: %s", this.queueOfNotifications.toString());
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Added New Notification", speechText)
                .build();
    }

}
