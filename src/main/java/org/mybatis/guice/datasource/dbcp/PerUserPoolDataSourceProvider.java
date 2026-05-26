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
import java.util.Map;
import java.util.Map.Entry;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.datasources.PerUserPoolDataSource;

/**
 * Provides the Apache commons-dbcp2 {@code PerUserPoolDataSource}.
 */
public final class PerUserPoolDataSourceProvider implements Provider<DataSource> {

    private final PerUserPoolDataSource dataSource = new PerUserPoolDataSource();

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

    @com.google.inject.Inject(optional = true)
    public void setDefaultMaxTotal(@Named("DBCP.defaultMaxTotal") int defaultMaxTotal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDefaultMaxIdle(@Named("DBCP.defaultMaxIdle") int defaultMaxIdle) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDefaultMaxWaitMillis(@Named("DBCP.defaultMaxWaitMillis") int defaultMaxWaitMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the per user default auto commit.
     *
     * @param perUserDefaultAutoCommit
     *          the per user default auto commit
     */
    @com.google.inject.Inject(optional = true)
    public void setPerUserDefaultAutoCommit(@PerUserDefaultAutoCommit Map<String, Boolean> perUserDefaultAutoCommit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the per user default read only.
     *
     * @param perUserDefaultReadOnly
     *          the per user default read only
     */
    @com.google.inject.Inject(optional = true)
    public void setPerUserDefaultReadOnly(@PerUserDefaultReadOnly Map<String, Boolean> perUserDefaultReadOnly) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the per user default transaction isolation.
     *
     * @param perUserDefaultTransactionIsolation
     *          the per user default transaction isolation
     */
    @com.google.inject.Inject(optional = true)
    public void setPerUserDefaultTransactionIsolation(@PerUserDefaultTransactionIsolation Map<String, Integer> perUserDefaultTransactionIsolation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the per user max total.
     *
     * @param perUserMaxTotal
     *          the per user max total
     */
    @com.google.inject.Inject(optional = true)
    public void setPerUserMaxTotal(@PerUserMaxTotal Map<String, Integer> perUserMaxTotal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the per user max idle.
     *
     * @param perUserMaxIdle
     *          the per user max idle
     */
    @com.google.inject.Inject(optional = true)
    public void setPerUserMaxIdle(@PerUserMaxIdle Map<String, Integer> perUserMaxIdle) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the per user max wait in milliseconds.
     *
     * @param perUserMaxWaitMillis
     *          the per user max wait in milliseconds
     */
    @com.google.inject.Inject(optional = true)
    public void setPerUserMaxWaitMillis(@PerUserMaxWaitMillis Map<String, Long> perUserMaxWaitMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DataSource get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
