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

import static com.google.inject.matcher.Matchers.annotatedWith;
import static com.google.inject.matcher.Matchers.any;
import static com.google.inject.matcher.Matchers.not;
import static com.google.inject.name.Names.named;
import static com.google.inject.util.Providers.guicify;
import static org.mybatis.guice.Preconditions.checkArgument;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matcher;
import java.lang.reflect.Method;
import java.util.Set;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionManager;
import org.mybatis.guice.mappers.MapperProvider;
import org.mybatis.guice.session.SqlSessionManagerProvider;
import org.mybatis.guice.transactional.Transactional;
import org.mybatis.guice.transactional.TransactionalMethodInterceptor;

abstract class AbstractMyBatisModule extends AbstractModule {

    protected static final Matcher<Method> DECLARED_BY_OBJECT = method -> method.getDeclaringClass() == Object.class;

    protected static final Matcher<Method> SYNTHETIC = Method::isSynthetic;

    private ClassLoader resourcesClassLoader = getDefaultClassLoader();

    private ClassLoader driverClassLoader = getDefaultClassLoader();

    /**
     * Return a set of all classes contained in the given package.
     *
     * @param packageName
     *          the package has to be analyzed.
     *
     * @return a set of all classes contained in the given package.
     */
    protected static Set<Class<?>> getClasses(String packageName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Return a set of all classes contained in the given package that match with the given test requirement.
     *
     * @param test
     *          the class filter on the given package.
     * @param packageName
     *          the package has to be analyzed.
     *
     * @return a set of all classes contained in the given package.
     */
    protected static Set<Class<?>> getClasses(ResolverUtil.Test test, String packageName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected final void configure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * bind transactional interceptors.
     */
    protected void bindTransactionInterceptors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bind mapper.
     *
     * @param <T>
     *          the generic type
     * @param mapperType
     *          the mapper type
     */
    final <T> void bindMapper(Class<T> mapperType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Use resource class loader.
     *
     * @param resourceClassLoader
     *          the resource class loader
     *
     * @since 3.3
     */
    public void useResourceClassLoader(ClassLoader resourceClassLoader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the resource class loader.
     *
     * @return the resource class loader
     *
     * @since 3.3
     */
    protected final ClassLoader getResourceClassLoader() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Use jdbc driver class loader.
     *
     * @param driverClassLoader
     *          the driver class loader
     *
     * @since 3.3
     */
    public void useJdbcDriverClassLoader(ClassLoader driverClassLoader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets the default class loader.
     *
     * @return the default class loader
     *
     * @since 3.3
     */
    private ClassLoader getDefaultClassLoader() {
        return getClass().getClassLoader();
    }

    /**
     * Configures a {@link Binder} via the exposed methods.
     */
    abstract void internalConfigure();

    /**
     * Initialize.
     */
    protected abstract void initialize();
}
