import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;

/**
 * Created by anton on 07.05.17.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new AllRequestsServlet()),"/*");

        Server server = new Server(8080);
        server.setHandler(context);


        server.start();
        server.join();
    }
}
