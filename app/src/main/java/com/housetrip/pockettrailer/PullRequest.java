package com.housetrip.pockettrailer;

import com.housetrip.pockettrailer.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
// KEEP INCLUDES END
/**
 * Entity mapped to table PULL_REQUEST.
 */
public class PullRequest {

    private Long id;
    private String title;
    private String author;
    private String state;
    private String url;
    private Integer number;
    private java.util.Date createdAt;
    private long repositoryId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient PullRequestDao myDao;

    private Repository repository;
    private Long repository__resolvedKey;


    // KEEP FIELDS - put your custom fields here

    public final static SimpleDateFormat GITHUB_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    private Boolean mMarkedForDestruction = false;
    // KEEP FIELDS END

    public PullRequest() {
    }

    public PullRequest(Long id) {
        this.id = id;
    }

    public PullRequest(Long id, String title, String author, String state, String url, Integer number, java.util.Date createdAt, long repositoryId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.state = state;
        this.url = url;
        this.number = number;
        this.createdAt = createdAt;
        this.repositoryId = repositoryId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPullRequestDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public java.util.Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.util.Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(long repositoryId) {
        this.repositoryId = repositoryId;
    }

    /** To-one relationship, resolved on first access. */
    public Repository getRepository() {
        long __key = this.repositoryId;
        if (repository__resolvedKey == null || !repository__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RepositoryDao targetDao = daoSession.getRepositoryDao();
            Repository repositoryNew = targetDao.load(__key);
            synchronized (this) {
                repository = repositoryNew;
            	repository__resolvedKey = __key;
            }
        }
        return repository;
    }

    public void setRepository(Repository repository) {
        if (repository == null) {
            throw new DaoException("To-one property 'repositoryId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.repository = repository;
            repositoryId = repository.getId();
            repository__resolvedKey = repositoryId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here

    public PullRequest(JSONObject json) throws JSONException {
        number = json.getInt("number");
        title = json.getString("title");
        author = json.getJSONObject("user").getString("login");
        url = json.getString("html_url");
        state = json.getString("state");
        createdAt = parseDate(json.getString("created_at"));
    }

    private Date parseDate(String string) {
        if (string.equals("null"))
            return null;

        try {
            return GITHUB_DATE_FORMAT.parse(string);
        } catch (ParseException e) {
            Log.e("PullRequest", "Could not parse date: ", e);
            return null;
        }
    }

    public Boolean getMarkedForDestruction() {
        return mMarkedForDestruction;
    }

    public void setMarkedForDestruction(Boolean markedForDestruction) {
        mMarkedForDestruction = markedForDestruction;
    }

    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass())
            return false;

        PullRequest otherPullRequest = (PullRequest)o;
        return number.equals(otherPullRequest.getNumber());
    }

    // KEEP METHODS END

}
