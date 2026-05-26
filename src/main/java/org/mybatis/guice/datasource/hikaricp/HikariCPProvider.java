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
package org.mybatis.guice.datasource.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.metrics.MetricsTrackerFactory;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import javax.sql.DataSource;

/**
 * Provides the HikariCP DataSource.
 * <p>
 * For additional information see configuration here
 * <a href="https://github.com/brettwooldridge/HikariCP">https://github.com/brettwooldridge/HikariCP</a>.
 */
public final class HikariCPProvider implements Provider<DataSource> {

    private final HikariConfig configuration = new HikariConfig();

    private Integer loginTimeout;

    @Override
    public DataSource get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setAllowPoolSuspension(@Named("hikaricp.allowPoolSuspension") boolean allowPoolSuspension) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setAutoCommit(@Named("hikaricp.autoCommit") boolean autoCommit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setCatalog(@Named("hikaricp.catalog") String catalog) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setConnectionInitSql(@Named("hikaricp.connectionInitSql") String connectionInitSql) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setConnectionTestQuery(@Named("hikaricp.connectionTestQuery") String connectionTestQuery) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the <code>connectionTimeout</code> HikariCP configuration property.
     *
     * @param connectionTimeoutMs
     *          the connection timeout in milliseconds
     */
    @com.google.inject.Inject(optional = true)
    public void setConnectionTimeout(@Named("hikaricp.connectionTimeoutMs") long connectionTimeoutMs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setDriverClassName(@Named("hikaricp.driverClassName") String driverClassName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setHealthCheckProperties(@Named("hikaricp.healthCheckProperties") Properties healthCheckProperties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setHealthCheckRegistry(@Named("hikaricp.healthCheckRegistry") Object healthCheckRegistry) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setIdleTimeout(@Named("hikaricp.idleTimeoutMs") long idleTimeoutMs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setInitializationFailTimeout(@Named("hikaricp.initializationFailTimeout") long initializationFailTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setIsolateInternalQueries(@Named("hikaricp.isolateInternalQueries") boolean isolateInternalQueries) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject
    public void setJdbcUrl(@Named("JDBC.url") String jdbcUrl) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setLeakDetectionThreshold(@Named("hikaricp.leakDetectionThresholdMs") long leakDetectionThresholdMs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setLoginTimeout(@Named("JDBC.loginTimeout") int loginTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setMaxLifetime(@Named("hikaricp.maxLifetimeMs") long maxLifetimeMs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setMaximumPoolSize(@Named("hikaricp.maxPoolSize") int maxPoolSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setMetricRegistry(@Named("hikaricp.metricRegistry") Object metricRegistry) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setMetricsTrackerFactory(@Named("hikaricp.metricsTrackerFactory") MetricsTrackerFactory metricsTrackerFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setMinimumIdle(@Named("hikaricp.minimumIdle") int minimumIdle) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject
    public void setPassword(@Named("JDBC.password") String password) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setPoolName(@Named("hikaricp.poolName") String poolName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setReadOnly(@Named("hikaricp.readOnly") boolean readOnly) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setRegisterMbeans(@Named("hikaricp.registerMbeans") boolean registerMbeans) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setScheduledExecutor(@Named("hikaricp.scheduledExecutorService") ScheduledExecutorService scheduledExecutorService) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setSchema(@Named("hikaricp.schema") String schema) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setThreadFactory(@Named("hikaricp.threadFactory") ThreadFactory threadFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setTransactionIsolation(@Named("hikaricp.transactionIsolation") String transactionIsolation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Inject
    public void setUsername(@Named("JDBC.username") String username) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @com.google.inject.Inject(optional = true)
    public void setValidationTimeout(@Named("hikaricp.validationTimeoutMs") long validationTimeoutMs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
