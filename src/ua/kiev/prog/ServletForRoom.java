package ua.kiev.prog;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Room", urlPatterns = "/room")
public class ServletForRoom extends HttpServlet {
    private UserList userList = UserList.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String room = request.getParameter("room");

        userList.changeRoom(login, room);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
