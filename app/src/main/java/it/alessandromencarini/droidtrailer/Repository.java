package it.alessandromencarini.droidtrailer;

import java.util.List;
import it.alessandromencarini.droidtrailer.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import org.json.JSONException;
import org.json.JSONObject;
// KEEP INCLUDES END
/**
 * Entity mapped to table REPOSITORY.
 */
public class Repository {

    private Long id;
    private String fullName;
    private String url;
    private Long remoteId;
    private Boolean selected;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient RepositoryDao myDao;

    private List<PullRequest> pullRequestList;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Repository() {
    }

    public Repository(Long id) {
        this.id = id;
    }

    public Repository(Long id, String fullName, String url, Long remoteId, Boolean selected) {
        this.id = id;
        this.fullName = fullName;
        this.url = url;
        this.remoteId = remoteId;
        this.selected = selected;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRepositoryDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(Long remoteId) {
        this.remoteId = remoteId;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<PullRequest> getPullRequestList() {
        if (pullRequestList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PullRequestDao targetDao = daoSession.getPullRequestDao();
            List<PullRequest> pullRequestListNew = targetDao._queryRepository_PullRequestList(id);
            synchronized (this) {
                if(pullRequestList == null) {
                    pullRequestList = pullRequestListNew;
                }
            }
        }
        return pullRequestList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetPullRequestList() {
        pullRequestList = null;
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
    public Repository(JSONObject json) throws JSONException {
        fullName = json.getString("full_name");
        remoteId = json.getLong("id");
    }

    public Boolean getSelected() {
        return selected != null ? selected : false;
    }

    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass())
            return false;

        Repository otherRepository = (Repository)o;
        return remoteId.equals(otherRepository.getRemoteId());
    }

    public String getOwner() {
        return fullName.split("/")[0];
    }

    public String getName() {
        return fullName.split("/")[1];
    }
    // KEEP METHODS END

}