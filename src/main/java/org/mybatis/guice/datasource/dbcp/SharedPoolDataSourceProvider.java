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
package org.mybatis.guice.datasource.dbcp;

import jakarta.inject.Named;
import jakarta.inject.Provider;
import java.time.Duration;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;

/**
 * Provides the Apache commons-dbcp2 {@code SharedPoolDataSource}.
 */
public final class SharedPoolDataSourceProvider implements Provider<DataSource> {

    private final SharedPoolDataSource dataSource = new SharedPoolDataSource();

    @com.google.inject.Inject(optional = true)
    public void setConnectionPoolDataSource(ConnectionPoolDataSource cpds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDataSourceName(@Named("DBCP.name") String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDefaultAutoCommit(@Named("JDBC.autoCommit") boolean autoCommit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDefaultReadOnly(@Named("DBCP.defaultReadOnly") boolean defaultReadOnly) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDefaultTransactionIsolation(@Named("DBCP.defaultTransactionIsolation") int defaultTransactionIsolation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDescription(@Named("DBCP.description") String description) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setJndiEnvironment(@Named("DBCP.jndi.key") String key, @Named("DBCP.jndi.value") String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setLoginTimeout(@Named("JDBC.loginTimeout") int loginTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDefaultMinEvictableIdleTimeMillis(@Named("DBCP.defaultMinEvictableIdleTimeMillis") int defaultMinEvictableIdleTimeMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDefaultNumTestsPerEvictionRun(@Named("DBCP.defaultNumTestsPerEvictionRun") int defaultNumTestsPerEvictionRun) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setRollbackAfterValidation(@Named("DBCP.rollbackAfterValidation") boolean rollbackAfterValidation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDefaultTestOnBorrow(@Named("DBCP.defaultTestOnBorrow") boolean defaultTestOnBorrow) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDefaultTestOnReturn(@Named("DBCP.defaultTestOnReturn") boolean defaultTestOnReturn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDefaultTestWhileIdle(@Named("DBCP.defaultTestWhileIdle") boolean defaultTestWhileIdle) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDefaultTimeBetweenEvictionRunsMillis(@Named("DBCP.defaultTimeBetweenEvictionRunsMillis") int defaultTimeBetweenEvictionRunsMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setValidationQuery(@Named("DBCP.validationQuery") String validationQuery) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the default max total.
     *
     * @param defaultMaxTotal
     *          the new default max total
     */
    @com.google.inject.Inject(optional = true)
    public void setDefaultMaxTotal(@Named("DBCP.defaultMaxTotal") final int defaultMaxTotal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the default max idle.
     *
     * @param defaultMaxIdle
     *          the new default max idle
     */
    @com.google.inject.Inject(optional = true)
    public void setDefaultMaxIdle(@Named("DBCP.defaultMaxIdle") final int defaultMaxIdle) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the default max wait in milliseconds.
     *
     * @param defaultMaxWaitMillis
     *          the new default max wait in milliseconds
     */
    @com.google.inject.Inject(optional = true)
    public void setDefaultMaxWaitMillis(@Named("DBCP.defaultMaxWaitMillis") final int defaultMaxWaitMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DataSource get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
