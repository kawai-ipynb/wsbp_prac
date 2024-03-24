package com.example.wsbp.page;

import com.example.wsbp.MySession;
import com.example.wsbp.repository.IChatRepository;
import com.example.wsbp.service.ChatService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("ChatPost")
public class ChatPostPage extends WebPage {
    @SpringBean
    private IChatRepository chatRepos;


    public ChatPostPage() {
        Form<Void> form = new Form<>("form");
        add(form);


        TextArea<String> messageInput = new TextArea<>("messageInput", Model.of(""));
        messageInput.setRequired(true);
        form.add(messageInput);

        form.add(new Button("submit") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                String message = messageInput.getModelObject();
                // メッセージをデータベースに保存する処理を追加
                // ここでIAuthServiceを使ってデータベースに保存するメソッドを呼び出す
                MySession session = MySession.get();
                String userName = session.getUserName();
                chatRepos.saveChatMessage(userName, message);
                // 投稿後はチャットページにリダイレクトするなどの処理を追加
                setResponsePage(ChatPage.class);
            }
        });
    }
}
