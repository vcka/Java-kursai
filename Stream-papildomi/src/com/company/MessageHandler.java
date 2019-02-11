package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MessageHandler {

    private List<MessageProcessor> processors;
    private List<Message> failedMessages = new ArrayList<>();

    public MessageHandler(List<MessageProcessor> processors) {
        this.processors = processors;
    }

    public void handleMessages(List<Message> messages) {
        messages.stream()
                .map(this::handleSingleMessage)
                .filter(failedMessage -> failedMessage.isPresent())
                .map(optiniol -> optiniol.get())
                .collect(Collectors.toList());
        processors
                .stream()
                .filter(MessageProcessor::anyMessagesToSend)
                .forEach(MessageProcessor::sendMessages);
    }

    private Optional<Message> handleSingleMessage(Message message) {
        for (MessageProcessor processor : processors) {
            if (processor.canHandle(message)) {
                processor.handle(message);
                return Optional.empty();
            }
        }
//        System.out.println("No processors found for message: " + message.toString());
        return Optional.of(message);
    }

    public List<MessageProcessor> getProcessors() {
        return processors;
    }

    public List<Message> getFailedMessages() {
        return failedMessages;
    }
}