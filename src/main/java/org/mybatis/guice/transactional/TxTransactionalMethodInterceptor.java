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

import static java.lang.String.format;
import jakarta.ejb.ApplicationException;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import jakarta.transaction.TransactionManager;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.transaction.xa.XAResource;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.mybatis.guice.transactional.Transactional.TxType;

/**
 * Method interceptor for {@link Transactional} annotation.
 */
public class TxTransactionalMethodInterceptor implements MethodInterceptor {

    /**
     * This class logger.
     */
    private final Log log = LogFactory.getLog(getClass());

    @Inject
    private TransactionManager manager;

    @Inject
    private Provider<XAResource> xaResourceProvider;

    private Map<TxType, TransactionAttributeStrategy> strategies = new HashMap<>();

    public TxTransactionalMethodInterceptor() {
        strategies.put(TxType.REQUIRED, new RequiredTransactionAttributeStrategy());
        strategies.put(TxType.REQUIRES_NEW, new RequiresNewTransactionAttributeStrategy());
        strategies.put(TxType.MANDATORY, new MandatoryTransactionAttributeStrategy());
        strategies.put(TxType.SUPPORTS, new SupportsTransactionAttributeStrategy());
        strategies.put(TxType.NEVER, new NeverTransactionAttributeStrategy());
    }

    private boolean isApplicationExceptionAvailable() {
        try {
            Class.forName("jakarta.ejb.ApplicationException");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private <A extends Annotation> A findAnnotation(Class<?> clazz, Class<A> annotationClass) {
        Class<?> current = clazz;
        A annotation = null;
        while (annotation == null && current != null) {
            annotation = current.getAnnotation(annotationClass);
            current = current.getSuperclass();
        }
        return annotation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
