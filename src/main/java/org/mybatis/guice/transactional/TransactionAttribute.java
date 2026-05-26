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

import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.InvalidTransactionException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.Status;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;
import jakarta.transaction.TransactionManager;

public enum TransactionAttribute {

    MANDATORY {

        @Override
        public TransactionToken begin(TransactionManager man) throws SystemException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    NEVER {

        @Override
        public TransactionToken begin(TransactionManager man) throws SystemException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    NOTSUPPORTED {

        @Override
        public TransactionToken begin(TransactionManager man) throws SystemException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void finish(TransactionManager man, TransactionToken tranToken) throws SystemException, InvalidTransactionException, IllegalStateException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    REQUIRED {

        @Override
        public TransactionToken begin(TransactionManager man) throws SystemException, NotSupportedException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void finish(TransactionManager man, TransactionToken tranToken) throws SystemException, InvalidTransactionException, IllegalStateException, SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    REQUIRESNEW {

        @Override
        public TransactionToken begin(TransactionManager man) throws SystemException, NotSupportedException, InvalidTransactionException, IllegalStateException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void finish(TransactionManager man, TransactionToken tranToken) throws SystemException, InvalidTransactionException, IllegalStateException, SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ,
    SUPPORTS {

        @Override
        public TransactionToken begin(TransactionManager man) throws SystemException, NotSupportedException, InvalidTransactionException, IllegalStateException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
    ;

    public static TransactionAttribute fromValue(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public TransactionToken begin(TransactionManager man) throws SystemException, NotSupportedException, InvalidTransactionException, IllegalStateException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void finish(TransactionManager man, TransactionToken tranToken) throws SystemException, InvalidTransactionException, IllegalStateException, SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
