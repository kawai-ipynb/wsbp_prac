package com.example.wsbp.page;

import com.example.wsbp.data.ChatMessage;
import com.example.wsbp.service.ChatService;
import com.example.wsbp.service.IChatService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import java.time.format.DateTimeFormatter;
import java.util.List;

@MountPath("Chat")
public class ChatPage extends WebPage {

    @SpringBean
    private IChatService chatService;

    public ChatPage() {
        var chatMessages = Model.ofList(chatService.getAllChatMessages());        //List<ChatMessage> chatMessages = chatService.getAllChatMessages();

        var chatListView = new ListView<>("chatMessages", chatMessages) {
            @Override
            protected void populateItem(ListItem<ChatMessage> item) {
                var message = item.getModelObject();
                item.add(new Label("userName", Model.of(message.getUserName())));
                item.add(new Label("message", Model.of(message.getMessageBody())));
                item.add(new Label("createdAt", Model.of(message.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))));
            }
        };
        add(chatListView);
    }
}
