package Example;
import com.slack.api.Slack;
import com.slack.api.model.event.MessageEvent;
import com.slack.api.model.event.UserTypingEvent;
import com.slack.api.rtm.*;
import com.slack.api.rtm.message.*;

import javax.websocket.DeploymentException;
import java.io.IOException;

public class Example {

    RTMEventsDispatcher dispatcher = RTMEventsDispatcherFactory.getInstance();
    String botToken = Token.TOKEN;
    Slack slack = Slack.getInstance();
    // Initialize the client with a valid WSS URL
    RTMClient rtm = slack.rtmConnect(botToken);

    public Example() throws IOException {
    }

    public void run() throws DeploymentException, IOException {
        // Register a event handler runtime
        RTMEventHandler<MessageEvent> message = new RTMEventHandler<MessageEvent>() {
            @Override
            public void handle(MessageEvent event) {
                String txt  = event.getText();
                if(txt.matches("Hello")) {
                    String channelId = "C035W3Q5YQK";
                    String message = Message.builder().channel(channelId).text(":wave: Hi there!").build().toJSONString();
                    rtm.sendMessage(message);
                }
            }
        };
        // Establish a WebSocket connection and start subscribing Slack events
        rtm.connect();
        // Enable an event dispatcher
        rtm.addMessageHandler(dispatcher.toMessageHandler());
        dispatcher.register(message);
    }












}
