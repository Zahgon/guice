/*
 *    Copyright 2009-2026 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.guice.transactional;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.concurrent.ConcurrentHashMap;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionManager;

public class XASqlSessionManager implements XAResource {

    private static final Log log = LogFactory.getLog(XASqlSessionManager.class);

    public static final int NO_TX = 0;

    public static final int STARTED = 1;

    public static final int ENDED = 2;

    public static final int PREPARED = 3;

    private SqlSessionManager sqlSessionManager;

    private int transactionTimeout;

    private String id;

    private Xid xid;

    private int state = NO_TX;

    private static ConcurrentHashMap<GlobalKey, GlobalToken> globalTokens = new ConcurrentHashMap<>();

    public XASqlSessionManager(SqlSessionManager sqlSessionManager) {
        this.sqlSessionManager = sqlSessionManager;
        id = sqlSessionManager.getConfiguration().getEnvironment().getId();
    }

    public String getId() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int getState() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String xlatedState() {
        switch(state) {
            case NO_TX:
                return "NO_TX";
            case STARTED:
                return "STARTED";
            case ENDED:
                return "ENDED";
            case PREPARED:
                return "PREPARED";
            default:
                return "!invalid state (" + state + ")!";
        }
    }

    private String decodeXAResourceFlag(int flag) {
        switch(flag) {
            case XAResource.TMENDRSCAN:
                return "TMENDRSCAN";
            case XAResource.TMFAIL:
                return "TMFAIL";
            case XAResource.TMJOIN:
                return "TMJOIN";
            case XAResource.TMNOFLAGS:
                return "TMNOFLAGS";
            case XAResource.TMONEPHASE:
                return "TMONEPHASE";
            case XAResource.TMRESUME:
                return "TMRESUME";
            case XAResource.TMSTARTRSCAN:
                return "TMSTARTRSCAN";
            case XAResource.TMSUCCESS:
                return "TMSUCCESS";
            case XAResource.TMSUSPEND:
                return "TMSUSPEND";
            default:
                return "" + flag;
        }
    }

    @Override
    public int getTransactionTimeout() throws XAException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean setTransactionTimeout(int second) throws XAException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void forget(Xid xid) throws XAException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Xid[] recover(int flags) throws XAException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isSameRM(XAResource xares) throws XAException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void start(Xid xid, int flag) throws XAException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void end(Xid xid, int flag) throws XAException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int prepare(Xid xid) throws XAException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void commit(Xid xid, boolean onePhase) throws XAException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void rollback(Xid xid) throws XAException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void parentSuspend(Xid xid) {
        if (log.isDebugEnabled()) {
            log.debug(id + ": suspend parent session " + xid);
        }
        byte[] trId = xid.getGlobalTransactionId();
        GlobalKey key = new GlobalKey(trId);
        GlobalToken globalToken = globalTokens.get(key);
        if (globalToken == null) {
            if (log.isDebugEnabled()) {
                log.debug(id + ": add GlobalToken " + key);
            }
            globalTokens.put(key, globalToken = new GlobalToken());
        } else {
            if (log.isDebugEnabled()) {
                log.debug(id + ": present GlobalToken " + key);
            }
        }
        globalToken.parentSuspend(id, sqlSessionManager);
    }

    private void parentResume(Xid xid) {
        if (log.isDebugEnabled()) {
            log.debug(id + ": resume parent session " + xid);
        }
        byte[] trId = xid.getGlobalTransactionId();
        GlobalKey key = new GlobalKey(trId);
        GlobalToken globalToken = globalTokens.get(key);
        if (globalToken != null) {
            globalToken.parentResume(id, sqlSessionManager);
            if (globalToken.isEmpty()) {
                if (log.isDebugEnabled()) {
                    log.debug(id + ": remove GlobalToken " + key);
                }
                globalTokens.remove(key);
            } else {
                if (log.isDebugEnabled()) {
                    log.debug(id + ": not remove GlobalToken " + key);
                }
            }
        } else {
            if (log.isDebugEnabled()) {
                log.debug(id + ": not find GlobalToken " + key);
            }
        }
    }

    static class GlobalKey {

        final byte[] globalId;

        final int arrayHash;

        public GlobalKey(byte[] globalId) {
            this.globalId = globalId;
            this.arrayHash = Arrays.hashCode(globalId);
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class GlobalToken {

        private final Log log = LogFactory.getLog(getClass());

        IdentityHashMap<SqlSessionManager, Token> tokens = new IdentityHashMap<SqlSessionManager, XASqlSessionManager.Token>();

        public GlobalToken() {
        }

        void parentSuspend(String id, SqlSessionManager sqlSessionManager) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void parentResume(String id, SqlSessionManager sqlSessionManager) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean isEmpty() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static class Token {

        private final Log log = LogFactory.getLog(getClass());

        final SqlSessionManager sqlSessionManager;

        ThreadLocal<SqlSession> localSqlSession;

        SqlSession suspendedSqlSession;

        int count;

        @SuppressWarnings("unchecked")
        public Token(SqlSessionManager sqlSessionManager) {
            this.sqlSessionManager = sqlSessionManager;
            this.count = 0;
            try {
                Field field = SqlSessionManager.class.getDeclaredField("localSqlSession");
                field.setAccessible(true);
                localSqlSession = (ThreadLocal<SqlSession>) field.get(sqlSessionManager);
            } catch (Exception e) {
            }
        }

        boolean isFirst() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void parentSuspend(String id) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void parentResume(String id) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
