package it.alessandromencarini.droidtrailer;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import it.alessandromencarini.droidtrailer.PullRequest;
import it.alessandromencarini.droidtrailer.Repository;
import it.alessandromencarini.droidtrailer.Comment;

import it.alessandromencarini.droidtrailer.PullRequestDao;
import it.alessandromencarini.droidtrailer.RepositoryDao;
import it.alessandromencarini.droidtrailer.CommentDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig pullRequestDaoConfig;
    private final DaoConfig repositoryDaoConfig;
    private final DaoConfig commentDaoConfig;

    private final PullRequestDao pullRequestDao;
    private final RepositoryDao repositoryDao;
    private final CommentDao commentDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        pullRequestDaoConfig = daoConfigMap.get(PullRequestDao.class).clone();
        pullRequestDaoConfig.initIdentityScope(type);

        repositoryDaoConfig = daoConfigMap.get(RepositoryDao.class).clone();
        repositoryDaoConfig.initIdentityScope(type);

        commentDaoConfig = daoConfigMap.get(CommentDao.class).clone();
        commentDaoConfig.initIdentityScope(type);

        pullRequestDao = new PullRequestDao(pullRequestDaoConfig, this);
        repositoryDao = new RepositoryDao(repositoryDaoConfig, this);
        commentDao = new CommentDao(commentDaoConfig, this);

        registerDao(PullRequest.class, pullRequestDao);
        registerDao(Repository.class, repositoryDao);
        registerDao(Comment.class, commentDao);
    }
    
    public void clear() {
        pullRequestDaoConfig.getIdentityScope().clear();
        repositoryDaoConfig.getIdentityScope().clear();
        commentDaoConfig.getIdentityScope().clear();
    }

    public PullRequestDao getPullRequestDao() {
        return pullRequestDao;
    }

    public RepositoryDao getRepositoryDao() {
        return repositoryDao;
    }

    public CommentDao getCommentDao() {
        return commentDao;
    }

}