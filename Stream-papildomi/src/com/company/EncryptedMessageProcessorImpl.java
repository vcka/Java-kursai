package com.company;

import java.util.function.Predicate;

public class EncryptedMessageProcessorImpl extends MessageProcessor {
    public EncryptedMessageProcessorImpl() {

        super(message -> MessageType.ENCRYPTED_TEXT_MESSAGE.equals(message.getType()));
    }

    @Override
    void sendMessages() {
        System.out.println("SENDIN ENCRYPTED MESSAGES!!!");
        messages.forEach(System.out::println);
        System.out.println("SENDING FINISHED");
    }
}
