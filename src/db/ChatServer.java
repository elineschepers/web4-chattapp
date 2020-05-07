package db;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/comment")
// nu tcp connectie ipv. http
public class ChatServer {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());
    //hier worden alle clients die een connectie hebben geopend met server bijgehouden
    @OnOpen
    public void onOpen(Session session)
    {
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String text,Session session)
    {
        System.out.println(text);

        sendMessageToall(text);
    }

    @OnClose
    public void onClose(Session session)
    {
        System.out.println("session "+session.getId()+" has closed");
        sessions.remove(session);
    }

    private void sendMessageToall(String text)
    {
        System.out.println(sessions.size());
        for(Session s : sessions)
        {

            try {
                s.getBasicRemote().sendText(text);
            } catch (IOException exc)
            {
                exc.printStackTrace();
            }
        }
    }


}
