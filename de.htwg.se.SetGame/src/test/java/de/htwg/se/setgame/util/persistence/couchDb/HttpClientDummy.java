package de.htwg.se.setgame.util.persistence.couchDb;

import org.ektorp.http.HttpClient;
import org.ektorp.http.HttpResponse;

import java.io.InputStream;

/**
 * @author Philipp Daniels
 */
public class HttpClientDummy implements HttpClient {

    @Override
    public HttpResponse get(String uri) {
        return null;
    }

    @Override
    public HttpResponse put(String uri, String content) {
        return null;
    }

    @Override
    public HttpResponse put(String uri) {
        return null;
    }

    @Override
    public HttpResponse put(String uri, InputStream data, String contentType, long contentLength) {
        return null;
    }

    @Override
    public HttpResponse post(String uri, String content) {
        return null;
    }

    @Override
    public HttpResponse post(String uri, InputStream content) {
        return null;
    }

    @Override
    public HttpResponse delete(String uri) {
        return null;
    }

    @Override
    public HttpResponse head(String uri) {
        return null;
    }

    @Override
    public HttpResponse getUncached(String uri) {
        return null;
    }

    @Override
    public HttpResponse postUncached(String uri, String content) {
        return null;
    }

    @Override
    public void shutdown() {

    }
}
