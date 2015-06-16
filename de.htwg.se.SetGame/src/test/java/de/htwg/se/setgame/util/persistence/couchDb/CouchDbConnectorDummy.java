package de.htwg.se.setgame.util.persistence.couchDb;

import org.ektorp.*;
import org.ektorp.changes.ChangesCommand;
import org.ektorp.changes.ChangesFeed;
import org.ektorp.changes.DocumentChange;
import org.ektorp.http.HttpClient;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Philipp Daniels
 */
public class CouchDbConnectorDummy implements CouchDbConnector {

    @Override
    public void create(String s, Object o) {

    }

    @Override
    public void create(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public String delete(String s, String s1) {
        return null;
    }

    @Override
    public PurgeResult purge(Map<String, List<String>> map) {
        return null;
    }

    @Override
    public <T> T get(Class<T> aClass, String s) {
        return null;
    }

    @Override
    public <T> T get(Class<T> aClass, String s, Options options) {
        return null;
    }

    @Override
    public <T> T find(Class<T> aClass, String s) {
        return null;
    }

    @Override
    public <T> T find(Class<T> aClass, String s, Options options) {
        return null;
    }

    @Override
    public <T> T get(Class<T> aClass, String s, String s1) {
        return null;
    }

    @Override
    public <T> T getWithConflicts(Class<T> aClass, String s) {
        return null;
    }

    @Override
    public boolean contains(String s) {
        return false;
    }

    @Override
    public InputStream getAsStream(String s) {
        return null;
    }

    @Override
    public InputStream getAsStream(String s, String s1) {
        return null;
    }

    @Override
    public InputStream getAsStream(String s, Options options) {
        return null;
    }

    @Override
    public List<Revision> getRevisions(String s) {
        return null;
    }

    @Override
    public AttachmentInputStream getAttachment(String s, String s1) {
        return null;
    }

    @Override
    public AttachmentInputStream getAttachment(String s, String s1, String s2) {
        return null;
    }

    @Override
    public String createAttachment(String s, AttachmentInputStream attachmentInputStream) {
        return null;
    }

    @Override
    public String createAttachment(String s, String s1, AttachmentInputStream attachmentInputStream) {
        return null;
    }

    @Override
    public String deleteAttachment(String s, String s1, String s2) {
        return null;
    }

    @Override
    public List<String> getAllDocIds() {
        return null;
    }

    @Override
    public <T> List<T> queryView(ViewQuery viewQuery, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> Page<T> queryForPage(ViewQuery viewQuery, PageRequest pageRequest, Class<T> aClass) {
        return null;
    }

    @Override
    public ViewResult queryView(ViewQuery viewQuery) {
        return null;
    }

    @Override
    public StreamingViewResult queryForStreamingView(ViewQuery viewQuery) {
        return null;
    }

    @Override
    public InputStream queryForStream(ViewQuery viewQuery) {
        return null;
    }

    @Override
    public void createDatabaseIfNotExists() {

    }

    @Override
    public String getDatabaseName() {
        return null;
    }

    @Override
    public String path() {
        return null;
    }

    @Override
    public HttpClient getConnection() {
        return null;
    }

    @Override
    public DbInfo getDbInfo() {
        return null;
    }

    @Override
    public DesignDocInfo getDesignDocInfo(String s) {
        return null;
    }

    @Override
    public void compact() {

    }

    @Override
    public void compactViews(String s) {

    }

    @Override
    public void cleanupViews() {

    }

    @Override
    public int getRevisionLimit() {
        return 0;
    }

    @Override
    public void setRevisionLimit(int i) {

    }

    @Override
    public ReplicationStatus replicateFrom(String s) {
        return null;
    }

    @Override
    public ReplicationStatus replicateFrom(String s, Collection<String> collection) {
        return null;
    }

    @Override
    public ReplicationStatus replicateTo(String s) {
        return null;
    }

    @Override
    public ReplicationStatus replicateTo(String s, Collection<String> collection) {
        return null;
    }

    @Override
    public void addToBulkBuffer(Object o) {

    }

    @Override
    public List<DocumentOperationResult> flushBulkBuffer() {
        return null;
    }

    @Override
    public void clearBulkBuffer() {

    }

    @Override
    public List<DocumentOperationResult> executeBulk(InputStream inputStream) {
        return null;
    }

    @Override
    public List<DocumentOperationResult> executeAllOrNothing(InputStream inputStream) {
        return null;
    }

    @Override
    public List<DocumentOperationResult> executeBulk(Collection<?> collection) {
        return null;
    }

    @Override
    public List<DocumentOperationResult> executeAllOrNothing(Collection<?> collection) {
        return null;
    }

    @Override
    public List<DocumentChange> changes(ChangesCommand changesCommand) {
        return null;
    }

    @Override
    public StreamingChangesResult changesAsStream(ChangesCommand changesCommand) {
        return null;
    }

    @Override
    public ChangesFeed changesFeed(ChangesCommand changesCommand) {
        return null;
    }

    @Override
    public String callUpdateHandler(String s, String s1, String s2) {
        return null;
    }

    @Override
    public String callUpdateHandler(String s, String s1, String s2, Map<String, String> map) {
        return null;
    }

    @Override
    public <T> T callUpdateHandler(UpdateHandlerRequest updateHandlerRequest, Class<T> aClass) {
        return null;
    }

    @Override
    public String callUpdateHandler(UpdateHandlerRequest updateHandlerRequest) {
        return null;
    }

    @Override
    public void ensureFullCommit() {

    }
}
