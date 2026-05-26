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
package org.mybatis.guice.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

/**
 * Provides the Druid DataSource.
 *
 * @author lazeyliu
 */
public class DruidDataSourceProvider implements Provider<DataSource> {

    DruidDataSource dataSource = new DruidDataSource();

    @Inject
    public void setDriverClassName(@Named("JDBC.driverClassName") final String driverClassName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject
    public void setUrl(@Named("JDBC.url") final String url) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject
    public void setUsername(@Named("JDBC.username") final String username) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject
    public void setPassword(@Named("JDBC.password") final String password) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setDefaultAutoCommit(@Named("JDBC.autoCommit") final boolean defaultAutoCommit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setDefaultReadOnly(@Named("JDBC.readOnly") final boolean defaultReadOnly) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setDefaultTransactionIsolation(@Named("JDBC.transactionIsolation") final int defaultTransactionIsolation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setDefaultCatalog(@Named("JDBC.catalog") final String defaultCatalog) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setMaxActive(@Named("JDBC.maxActive") final int maxActive) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setMinIdle(@Named("JDBC.minIdle") final int minIdle) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setInitialSize(@Named("JDBC.initialSize") final int initialSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setMaxWait(@Named("JDBC.maxWait") final long maxWait) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setTestOnBorrow(@Named("JDBC.testOnBorrow") final boolean testOnBorrow) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setTestOnReturn(@Named("JDBC.testOnReturn") final boolean testOnReturn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setTimeBetweenEvictionRunsMillis(@Named("JDBC.timeBetweenEvictionRunsMillis") final long timeBetweenEvictionRunsMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setMinEvictableIdleTimeMillis(@Named("JDBC.minEvictableIdleTimeMillis") final long minEvictableIdleTimeMillis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setTestWhileIdle(@Named("JDBC.testWhileIdle") final boolean testWhileIdle) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setValidationQuery(@Named("JDBC.validationQuery") final String validationQuery) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setValidationQueryTimeout(@Named("JDBC.validationQueryTimeout") final int validationQueryTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setAccessToUnderlyingConnectionAllowed(@Named("JDBC.accessToUnderlyingConnectionAllowed") final boolean accessToUnderlyingConnectionAllowed) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setRemoveAbandoned(@Named("JDBC.removeAbandoned") final boolean removeAbandoned) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setRemoveAbandonedTimeout(@Named("JDBC.removeAbandonedTimeout") final int removeAbandonedTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setLogAbandoned(@Named("JDBC.logAbandoned") final boolean logAbandoned) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setPoolPreparedStatements(@Named("JDBC.poolPreparedStatements") final boolean poolPreparedStatements) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setMaxOpenPreparedStatements(@Named("JDBC.maxOpenPreparedStatements") final int maxOpenPreparedStatements) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setConnectProperties(@Named("JDBC.connectProperties") final Properties connectionProperties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setConnectionProperties(@Named("JDBC.connectionProperties") final String connectionProperties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setFilters(@Named("JDBC.filters") final String filters) throws SQLException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setExceptionSorter(@Named("JDBC.exceptionSorter") final String exceptionSorter) throws SQLException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject(optional = true)
    public void setExceptionSorterClassName(@Named("JDBC.exceptionSorterClassName") final String exceptionSorterClassName) throws Exception {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DataSource get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
