package learn.java.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8090), 0);
        httpServer.createContext("/hi", new HiContextHandler());
        httpServer.start();
    }

    private static class HiContextHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String response = "Hi there!";
            httpExchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream responseBody = httpExchange.getResponseBody();
            responseBody.write(response.getBytes());
            responseBody.flush();
            responseBody.close();
        }
    }
}
