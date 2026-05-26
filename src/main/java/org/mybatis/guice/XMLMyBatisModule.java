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
package org.mybatis.guice;

import static org.apache.ibatis.io.Resources.getResourceAsReader;
import static org.mybatis.guice.Preconditions.checkArgument;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Properties;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeHandler;

/**
 * Easy to use helper Module that alleviates users to write the boilerplate google-guice bindings to create the
 * SqlSessionFactory, via XML configuration.
 */
public abstract class XMLMyBatisModule extends AbstractMyBatisModule {

    private static final String DEFAULT_CONFIG_RESOURCE = "mybatis-config.xml";

    private static final String DEFAULT_ENVIRONMENT_ID = null;

    private String classPathResource = DEFAULT_CONFIG_RESOURCE;

    private String environmentId = DEFAULT_ENVIRONMENT_ID;

    private Properties properties = new Properties();

    /**
     * Set the MyBatis configuration class path resource.
     *
     * @param classPathResource
     *          the MyBatis configuration class path resource
     */
    protected final void setClassPathResource(String classPathResource) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set the MyBatis configuration environment id.
     *
     * @param environmentId
     *          the MyBatis configuration environment id
     */
    protected final void setEnvironmentId(String environmentId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add the variables will be used to replace placeholders in the MyBatis configuration.
     *
     * @param properties
     *          the variables will be used to replace placeholders in the MyBatis configuration
     */
    protected final void addProperties(Properties properties) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final void internalConfigure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
