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

import static com.google.inject.name.Names.named;
import static com.google.inject.util.Providers.guicify;
import static org.mybatis.guice.Preconditions.checkArgument;
import com.google.inject.Key;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import jakarta.inject.Provider;
import java.util.Collection;
import javax.sql.DataSource;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.guice.binder.AliasBinder;
import org.mybatis.guice.binder.TypeHandlerBinder;
import org.mybatis.guice.configuration.ConfigurationProvider;
import org.mybatis.guice.configuration.ConfigurationSettingListener;
import org.mybatis.guice.configuration.settings.AggressiveLazyLoadingConfigurationSetting;
import org.mybatis.guice.configuration.settings.AliasConfigurationSetting;
import org.mybatis.guice.configuration.settings.AutoMappingBehaviorConfigurationSetting;
import org.mybatis.guice.configuration.settings.CacheEnabledConfigurationSetting;
import org.mybatis.guice.configuration.settings.ConfigurationSetting;
import org.mybatis.guice.configuration.settings.DefaultExecutorTypeConfigurationSetting;
import org.mybatis.guice.configuration.settings.DefaultScriptingLanguageTypeConfigurationSetting;
import org.mybatis.guice.configuration.settings.DefaultStatementTimeoutConfigurationSetting;
import org.mybatis.guice.configuration.settings.InterceptorConfigurationSettingProvider;
import org.mybatis.guice.configuration.settings.JavaTypeAndHandlerConfigurationSettingProvider;
import org.mybatis.guice.configuration.settings.LazyLoadingEnabledConfigurationSetting;
import org.mybatis.guice.configuration.settings.LocalCacheScopeConfigurationSetting;
import org.mybatis.guice.configuration.settings.MapUnderscoreToCamelCaseConfigurationSetting;
import org.mybatis.guice.configuration.settings.MapperConfigurationSetting;
import org.mybatis.guice.configuration.settings.MultipleResultSetsEnabledConfigurationSetting;
import org.mybatis.guice.configuration.settings.ObjectFactoryConfigurationSetting;
import org.mybatis.guice.configuration.settings.ObjectWrapperFactoryConfigurationSetting;
import org.mybatis.guice.configuration.settings.TypeHandlerConfigurationSettingProvider;
import org.mybatis.guice.configuration.settings.UseColumnLabelConfigurationSetting;
import org.mybatis.guice.configuration.settings.UseGeneratedKeysConfigurationSetting;
import org.mybatis.guice.environment.EnvironmentProvider;
import org.mybatis.guice.provision.ConfigurationProviderProvisionListener;
import org.mybatis.guice.provision.KeyMatcher;
import org.mybatis.guice.session.SqlSessionFactoryProvider;
import org.mybatis.guice.type.TypeHandlerProvider;

/**
 * Easy to use helper Module that alleviates users to write the boilerplate google-guice bindings to create the
 * SqlSessionFactory.
 */
public abstract class MyBatisModule extends AbstractMyBatisModule {

    /**
     * The ObjectFactory class reference.
     */
    private Class<? extends ObjectFactory> objectFactoryType = DefaultObjectFactory.class;

    /**
     * The ObjectWrapperFactory class reference.
     */
    private Class<? extends ObjectWrapperFactory> objectWrapperFactoryType = DefaultObjectWrapperFactory.class;

    private Class<? extends LanguageDriver> defaultScriptingLanguageType = XMLLanguageDriver.class;

    /**
     * The SqlSessionFactory Provider class reference.
     */
    private Class<? extends Provider<? extends SqlSessionFactory>> sqlSessionFactoryProviderType = SqlSessionFactoryProvider.class;

    private Class<? extends Provider<? extends Configuration>> configurationProviderType = ConfigurationProvider.class;

    @Override
    final void internalConfigure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set the MyBatis configuration environment id.
     *
     * @param environmentId
     *          the MyBatis configuration environment id
     */
    protected final void environmentId(String environmentId) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Lazy loading enabled.
     *
     * @param lazyLoadingEnabled
     *          the lazy loading enabled
     */
    protected final void lazyLoadingEnabled(boolean lazyLoadingEnabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Aggressive lazy loading.
     *
     * @param aggressiveLazyLoading
     *          the aggressive lazy loading
     */
    protected final void aggressiveLazyLoading(boolean aggressiveLazyLoading) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Multiple result sets enabled.
     *
     * @deprecated this option has no effect
     *
     * @param multipleResultSetsEnabled
     *          the multiple result sets enabled
     */
    @Deprecated
    protected final void multipleResultSetsEnabled(boolean multipleResultSetsEnabled) {
        bindConfigurationSetting(new MultipleResultSetsEnabledConfigurationSetting(multipleResultSetsEnabled));
    }

    /**
     * Use generated keys.
     *
     * @param useGeneratedKeys
     *          the use generated keys
     */
    protected final void useGeneratedKeys(boolean useGeneratedKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Use column label.
     *
     * @param useColumnLabel
     *          the use column label
     */
    protected final void useColumnLabel(boolean useColumnLabel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Use cache enabled.
     *
     * @param useCacheEnabled
     *          the use cache enabled
     */
    protected final void useCacheEnabled(boolean useCacheEnabled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Use configuration provider.
     *
     * @param configurationProviderType
     *          provider for Configuration
     */
    protected final void useConfigurationProvider(Class<? extends Provider<? extends Configuration>> configurationProviderType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Use sql session factory provider.
     *
     * @param sqlSessionFactoryProvider
     *          provider for SqlSessionFactory
     */
    protected final void useSqlSessionFactoryProvider(Class<? extends Provider<? extends SqlSessionFactory>> sqlSessionFactoryProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Fail fast.
     *
     * @param failFast
     *          the fail fast
     */
    protected final void failFast(boolean failFast) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Maps underscores to camel case.
     *
     * @param mapUnderscoreToCamelCase
     *          Toggles this settings value.
     */
    protected final void mapUnderscoreToCamelCase(boolean mapUnderscoreToCamelCase) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * set default statement timeout.
     *
     * @param defaultStatementTimeout
     *          default statement timeout in seconds.
     */
    protected final void defaultStatementTimeout(Integer defaultStatementTimeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final void bindConfigurationSetting(final ConfigurationSetting configurationSetting) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final <P extends Provider<? extends ConfigurationSetting>> void bindConfigurationSettingProvider(P configurationSettingProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final void bindBoolean(String name, boolean value) {
        bindConstant().annotatedWith(named(name)).to(value);
    }

    /**
     * Executor type.
     *
     * @param executorType
     *          the executor type
     */
    protected final void executorType(ExecutorType executorType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Configures the local cache scope setting.
     *
     * @param localeCacheScope
     *          The cache scope to use.
     *
     * @since 3.4
     */
    protected final void localCacheScope(LocalCacheScope localeCacheScope) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Auto mapping behavior.
     *
     * @param autoMappingBehavior
     *          the auto mapping behavior
     */
    protected final void autoMappingBehavior(AutoMappingBehavior autoMappingBehavior) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set the DataSource Provider type has to be bound.
     *
     * @param dataSourceProviderType
     *          the DataSource Provider type
     */
    protected final void bindDataSourceProviderType(Class<? extends Provider<DataSource>> dataSourceProviderType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bind data source provider.
     *
     * @param dataSourceProvider
     *          the data source provider
     */
    protected final void bindDataSourceProvider(Provider<DataSource> dataSourceProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bind data source provider.
     *
     * @param dataSourceProvider
     *          the data source provider
     */
    protected final void bindDataSourceProvider(com.google.inject.Provider<DataSource> dataSourceProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bind database id provider.
     *
     * @param databaseIdProvider
     *          The DatabaseIdProvider class.
     */
    protected final void bindDatabaseIdProvider(Class<? extends DatabaseIdProvider> databaseIdProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bind database id provider.
     *
     * @param databaseIdProvider
     *          The DatabaseIdProvider instance.
     */
    protected final void bindDatabaseIdProvider(DatabaseIdProvider databaseIdProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set the TransactionFactory type has to be bound.
     *
     * @param transactionFactoryType
     *          the TransactionFactory type
     */
    protected final void bindTransactionFactoryType(Class<? extends TransactionFactory> transactionFactoryType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bind transaction factory.
     *
     * @param transactionFactoryProvider
     *          the transaction factory provider
     */
    protected final void bindTransactionFactory(Provider<TransactionFactory> transactionFactoryProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Bind transaction factory.
     *
     * @param transactionFactoryProvider
     *          the transaction factory provider
     */
    protected final void bindTransactionFactory(com.google.inject.Provider<TransactionFactory> transactionFactoryProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the ObjectFactory class.
     *
     * @param objectFactoryType
     *          the ObjectFactory type
     */
    protected final void bindObjectFactoryType(Class<? extends ObjectFactory> objectFactoryType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the ObjectWrapperFactory class.
     *
     * @param objectWrapperFactoryType
     *          the ObjectFactory type
     */
    protected final void bindObjectWrapperFactoryType(Class<? extends ObjectWrapperFactory> objectWrapperFactoryType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the default LanguageDriver class.
     * <p>
     * Due to current limitations in MyBatis, &#64;Inject cannot be used in LanguageDriver class.
     * </p>
     *
     * @param defaultScriptingLanguageType
     *          the default LanguageDriver type
     */
    protected final void bindDefaultScriptingLanguageType(Class<? extends LanguageDriver> defaultScriptingLanguageType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add a user defined binding.
     *
     * @param alias
     *          the string type alias
     *
     * @return the alias binder
     */
    protected final AliasBinder addAlias(final String alias) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adding simple aliases means that every specified class will be bound using the simple class name, i.e.
     * {@code com.acme.Foo} becomes {@code Foo}.
     *
     * @param type
     *          the specified types have to be bind
     */
    protected final void addSimpleAlias(final Class<?> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adding simple aliases means that every specified class will be bound using the simple class name, i.e.
     * {@code com.acme.Foo} becomes {@code Foo}.
     *
     * @param types
     *          the specified types have to be bind
     */
    protected final void addSimpleAliases(final Collection<Class<?>> types) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds all Classes in the given package as a simple alias. Adding simple aliases means that every specified class
     * will be bound using the simple class name, i.e. {@code com.acme.Foo} becomes {@code Foo}.
     *
     * @param packageName
     *          the specified package to search for classes to alias.
     * @param test
     *          a test to run against the objects found in the specified package
     */
    protected final void addSimpleAliases(final String packageName, final ResolverUtil.Test test) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds all Classes in the given package as a simple alias. Adding simple aliases means that every specified class
     * will be bound using the simple class name, i.e. {@code com.acme.Foo} becomes {@code Foo}.
     *
     * @param packageName
     *          the specified package to search for classes to alias
     */
    protected final void addSimpleAliases(final String packageName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Add a user defined Type Handler letting google-guice creating it.
     *
     * @param <T>
     *          the generic type
     * @param type
     *          the specified type has to be handled.
     *
     * @return the type handler binder
     */
    protected final <T> TypeHandlerBinder<T> handleType(final Class<T> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the user defined MyBatis type handler, letting google-guice creating it.
     *
     * @param handlerClass
     *          the handler type.
     */
    protected final void addTypeHandlerClass(final Class<? extends TypeHandler<?>> handlerClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the user defined MyBatis type handlers, letting google-guice creating it.
     *
     * @param handlersClasses
     *          the handler type.
     */
    protected final void addTypeHandlersClasses(Collection<Class<? extends TypeHandler<?>>> handlersClasses) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the user defined MyBatis type handlers in the given package, letting google-guice creating it.
     *
     * @param packageName
     *          the package where looking for type handlers.
     */
    protected final void addTypeHandlerClasses(String packageName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the user defined myBatis interceptor plugins type, letting google-guice creating it.
     *
     * @param interceptorClass
     *          The user defined MyBatis interceptor plugin type
     */
    protected final void addInterceptorClass(final Class<? extends Interceptor> interceptorClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the user defined MyBatis interceptors plugins types, letting google-guice creating them.
     *
     * @param interceptorsClasses
     *          the user defined MyBatis Interceptors plugins types
     */
    protected final void addInterceptorsClasses(Collection<Class<? extends Interceptor>> interceptorsClasses) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the user defined MyBatis interceptors plugins types in the given package, letting google-guice creating them.
     *
     * @param packageName
     *          the package where looking for Interceptors plugins types.
     */
    protected final void addInterceptorsClasses(String packageName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the user defined mapper classes.
     *
     * @param mapperClass
     *          the user defined mapper classes.
     */
    protected final void addMapperClass(Class<?> mapperClass) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the user defined mapper classes.
     *
     * @param mapperClasses
     *          the user defined mapper classes
     */
    protected final void addMapperClasses(Collection<Class<?>> mapperClasses) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the user defined mapper classes.
     *
     * @param packageName
     *          the specified package to search for mappers to add.
     */
    protected final void addMapperClasses(final String packageName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Adds the user defined mapper classes.
     *
     * @param packageName
     *          the specified package to search for mappers to add.
     * @param test
     *          a test to run against the objects found in the specified package.
     */
    protected final void addMapperClasses(final String packageName, final ResolverUtil.Test test) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
