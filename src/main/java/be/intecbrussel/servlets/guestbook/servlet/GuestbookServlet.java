package be.intecbrussel.servlets.guestbook.servlet;

import be.intecbrussel.servlets.guestbook.dao.MessageDao;
import be.intecbrussel.servlets.guestbook.dao.MessageDaoJDBCImpl;
import be.intecbrussel.servlets.guestbook.model.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/")
public class GuestbookServlet extends HttpServlet {

    private MessageDao messageDao;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        messageDao = new MessageDaoJDBCImpl("jdbc:mariadb://noelvaes.eu/StudentDB",
            "student","student123" );

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Message> messages = messageDao.getAllMessages();

        request.setAttribute("messages", messages);
        request.getRequestDispatcher("/WEB-INF/pages/guestbook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime dateTime = LocalDateTime.now();
        String name = req.getParameter("name");
        String message = req.getParameter("message");
        messageDao.createMessage(new Message(dateTime,name,message));
        resp.sendRedirect("");
    }

    @Override
    public void destroy() {
        ((MessageDaoJDBCImpl)messageDao).closeConnection();
    }
}
