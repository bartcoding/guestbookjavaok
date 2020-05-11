package be.intecbrussel.servlets.guestbook.dao;

import be.intecbrussel.servlets.guestbook.model.Message;

import java.util.List;

public interface MessageDao {
    List<Message> getAllMessages();
    void createMessage(Message message);
}
