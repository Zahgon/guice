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
package org.mybatis.guice.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.sql.DataSource;

/**
 * Provides the C3P0 DataSource.
 */
public final class C3p0DataSourceProvider implements Provider<DataSource> {

    /**
     * The ComboPooledDataSource reference.
     */
    private final ComboPooledDataSource dataSource = new ComboPooledDataSource();

    private String username;

    private String password;

    /**
     * Creates a new ComboPooledDataSource using the needed parameter.
     *
     * @param driver
     *          The JDBC driver class.
     * @param url
     *          the database URL of the form <code>jdbc:subprotocol:subname</code>.
     */
    @Inject
    public C3p0DataSourceProvider(@Named("JDBC.driver") final String driver, @Named("JDBC.url") final String url) {
        try {
            dataSource.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            throw new RuntimeException("Impossible to initialize C3P0 Data Source with driver class '" + driver + "', see nested exceptions", e);
        }
        dataSource.setJdbcUrl(url);
    }

    /**
     * Sets the user.
     *
     * @param username
     *          the new user
     *
     * @since 3.3
     */
    @com.google.inject.Inject(optional = true)
    public void setUser(@Named("JDBC.username") final String username) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the password.
     *
     * @param password
     *          the new password
     *
     * @since 3.3
     */
    @com.google.inject.Inject(optional = true)
    public void setPassword(@Named("JDBC.password") final String password) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the acquire increment.
     *
     * @param acquireIncrement
     *          the new acquire increment
     */
    @com.google.inject.Inject(optional = true)
    public void setAcquireIncrement(@Named("c3p0.acquireIncrement") final int acquireIncrement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the acquire retry attempts.
     *
     * @param acquireRetryAttempts
     *          the new acquire retry attempts
     */
    @com.google.inject.Inject(optional = true)
    public void setAcquireRetryAttempts(@Named("c3p0.acquireRetryAttempts") final int acquireRetryAttempts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the acquire retry delay.
     *
     * @param acquireRetryDelay
     *          the new acquire retry delay
     */
    @com.google.inject.Inject(optional = true)
    public void setAcquireRetryDelay(@Named("c3p0.acquireRetryDelay") final int acquireRetryDelay) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the auto commit on close.
     *
     * @param autoCommit
     *          the new auto commit on close
     */
    @com.google.inject.Inject(optional = true)
    public void setAutoCommitOnClose(@Named("JDBC.autoCommit") final boolean autoCommit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the driver properties.
     *
     * @param driverProperties
     *          the new driver properties
     */
    @com.google.inject.Inject(optional = true)
    public void setDriverProperties(@Named("JDBC.driverProperties") final Properties driverProperties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the aautomatic test table.
     *
     * @param automaticTestTable
     *          the new aautomatic test table
     */
    @com.google.inject.Inject(optional = true)
    public void setAautomaticTestTable(@Named("c3p0.automaticTestTable") final String automaticTestTable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the break after acquire failure.
     *
     * @param breakAfterAcquireFailure
     *          the new break after acquire failure
     */
    @com.google.inject.Inject(optional = true)
    public void setBreakAfterAcquireFailure(@Named("c3p0.breakAfterAcquireFailure") final boolean breakAfterAcquireFailure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the checkout timeout.
     *
     * @param checkoutTimeout
     *          the new checkout timeout
     */
    @com.google.inject.Inject(optional = true)
    public void setCheckoutTimeout(@Named("c3p0.checkoutTimeout") final int checkoutTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the connection customizer class name.
     *
     * @param connectionCustomizerClassName
     *          the new connection customizer class name
     */
    @com.google.inject.Inject(optional = true)
    public void setConnectionCustomizerClassName(@Named("c3p0.connectionCustomizerClassName") final String connectionCustomizerClassName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the connection tester class name.
     *
     * @param connectionTesterClassName
     *          the new connection tester class name
     */
    @com.google.inject.Inject(optional = true)
    public void setConnectionTesterClassName(@Named("c3p0.connectionTesterClassName") final String connectionTesterClassName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the idle connection test period.
     *
     * @param idleConnectionTestPeriod
     *          the new idle connection test period
     */
    @com.google.inject.Inject(optional = true)
    public void setIdleConnectionTestPeriod(@Named("c3p0.idleConnectionTestPeriod") final int idleConnectionTestPeriod) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the initial pool size.
     *
     * @param initialPoolSize
     *          the new initial pool size
     */
    @com.google.inject.Inject(optional = true)
    public void setInitialPoolSize(@Named("c3p0.initialPoolSize") final int initialPoolSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the max administrative task time.
     *
     * @param maxAdministrativeTaskTime
     *          the new max administrative task time
     */
    @com.google.inject.Inject(optional = true)
    public void setMaxAdministrativeTaskTime(@Named("c3p0.maxAdministrativeTaskTime") final int maxAdministrativeTaskTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the max connection age.
     *
     * @param maxConnectionAge
     *          the new max connection age
     */
    @com.google.inject.Inject(optional = true)
    public void setMaxConnectionAge(@Named("c3p0.maxConnectionAge") final int maxConnectionAge) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the max idle time.
     *
     * @param maxIdleTime
     *          the new max idle time
     */
    @com.google.inject.Inject(optional = true)
    public void setMaxIdleTime(@Named("c3p0.maxIdleTime") final int maxIdleTime) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the max idle time excess connections.
     *
     * @param maxIdleTimeExcessConnections
     *          the new max idle time excess connections
     */
    @com.google.inject.Inject(optional = true)
    public void setMaxIdleTimeExcessConnections(@Named("c3p0.maxIdleTimeExcessConnections") final int maxIdleTimeExcessConnections) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the max pool size.
     *
     * @param maxPoolSize
     *          the new max pool size
     */
    @com.google.inject.Inject(optional = true)
    public void setMaxPoolSize(@Named("c3p0.maxPoolSize") final int maxPoolSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the max statements.
     *
     * @param maxStatements
     *          the new max statements
     */
    @com.google.inject.Inject(optional = true)
    public void setMaxStatements(@Named("c3p0.maxStatements") final int maxStatements) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the max statements per connection.
     *
     * @param maxStatementsPerConnection
     *          the new max statements per connection
     */
    @com.google.inject.Inject(optional = true)
    public void setMaxStatementsPerConnection(@Named("c3p0.maxStatementsPerConnection") final int maxStatementsPerConnection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the min pool size.
     *
     * @param minPoolSize
     *          the new min pool size
     */
    @com.google.inject.Inject(optional = true)
    public void setMinPoolSize(@Named("c3p0.minPoolSize") final int minPoolSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the preferred test query.
     *
     * @param preferredTestQuery
     *          the new preferred test query
     */
    @com.google.inject.Inject(optional = true)
    public void setPreferredTestQuery(@Named("c3p0.preferredTestQuery") final String preferredTestQuery) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the property cycle.
     *
     * @param propertyCycle
     *          the new property cycle
     */
    @com.google.inject.Inject(optional = true)
    public void setPropertyCycle(@Named("c3p0.propertyCycle") final int propertyCycle) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the test connection on checkin.
     *
     * @param testConnectionOnCheckin
     *          the new test connection on checkin
     */
    @com.google.inject.Inject(optional = true)
    public void setTestConnectionOnCheckin(@Named("c3p0.testConnectionOnCheckin") final boolean testConnectionOnCheckin) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the test connection on checkout.
     *
     * @param testConnectionOnCheckout
     *          the new test connection on checkout
     */
    @com.google.inject.Inject(optional = true)
    public void setTestConnectionOnCheckout(@Named("c3p0.testConnectionOnCheckout") final boolean testConnectionOnCheckout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the unreturned connection timeout.
     *
     * @param unreturnedConnectionTimeout
     *          the new unreturned connection timeout
     */
    @com.google.inject.Inject(optional = true)
    public void setUnreturnedConnectionTimeout(@Named("c3p0.unreturnedConnectionTimeout") final int unreturnedConnectionTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DataSource get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
