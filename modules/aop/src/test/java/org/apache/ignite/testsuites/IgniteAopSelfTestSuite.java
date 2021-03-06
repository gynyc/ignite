/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.testsuites;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;
import org.apache.ignite.gridify.BasicAopSelfTest;
import org.apache.ignite.gridify.GridifySetToXXXNonSpringAopSelfTest;
import org.apache.ignite.gridify.GridifySetToXXXSpringAopSelfTest;
import org.apache.ignite.gridify.NonSpringAopSelfTest;
import org.apache.ignite.gridify.SpringAopSelfTest;
import org.apache.ignite.testframework.GridTestUtils;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.test.gridify.ExternalNonSpringAopSelfTest;

import static org.apache.ignite.IgniteSystemProperties.IGNITE_OVERRIDE_MCAST_GRP;

/**
 * AOP test suite.
 */
@RunWith(AllTests.class)
public class IgniteAopSelfTestSuite {
    /**
     * @return AOP test suite.
     */
    public static TestSuite suite() {
        TestSuite suite = new TestSuite("Ignite AOP Test Suite");

        // Test configuration.
        suite.addTest(new JUnit4TestAdapter(BasicAopSelfTest.class));

        suite.addTest(new JUnit4TestAdapter(SpringAopSelfTest.class));
        suite.addTest(new JUnit4TestAdapter(NonSpringAopSelfTest.class));
        suite.addTest(new JUnit4TestAdapter(GridifySetToXXXSpringAopSelfTest.class));
        suite.addTest(new JUnit4TestAdapter(GridifySetToXXXNonSpringAopSelfTest.class));
        suite.addTest(new JUnit4TestAdapter(ExternalNonSpringAopSelfTest.class));

        // Examples
        System.setProperty(IGNITE_OVERRIDE_MCAST_GRP, GridTestUtils.getNextMulticastGroup(IgniteAopSelfTestSuite.class));

        return suite;
    }
}
