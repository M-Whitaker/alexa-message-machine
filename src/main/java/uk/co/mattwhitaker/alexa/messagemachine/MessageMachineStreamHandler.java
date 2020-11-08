package uk.co.mattwhitaker.alexa.messagemachine;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import uk.co.mattwhitaker.alexa.messagemachine.handlers.*;

public class MessageMachineStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new MessageMachineIntentHandler(),
                        new MessageMachineAddHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler())
                // Add your skill id below
                .withSkillId(System.getenv("SKILL_ID"))
                .build();
    }

    public MessageMachineStreamHandler() {
        super(getSkill());
    }

}
