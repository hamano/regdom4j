/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright (C) 2012 Open Source Solution Technology Corporation
 * Copyright (C) 2012 HAMANO Tsukasa <hamano@osstech.co.jp>
 */

package jp.co.osstech.regdom4j;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class RegDomainTest
    extends TestCase
{
    private RegDomain regdom;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RegDomainTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RegDomainTest.class );
    }

    protected void setUp() throws Exception {
        super.setUp();
        this.regdom = new RegDomain();
    }

    /**
     * Rigourous Test :-)
     */
    public void testRegDomain()
    {
        assertTrue( true );
        assertEquals("example.com",
                     regdom.getRegisteredDomain("example.com"));
        assertEquals("example.com",
                     regdom.getRegisteredDomain("www.example.com"));
        assertEquals("example.co.jp",
                     regdom.getRegisteredDomain("www.example.co.jp"));
        assertEquals("example.shinagawa.tokyo.jp",
                     regdom.getRegisteredDomain("www.example.shinagawa.tokyo.jp"));
        assertEquals("example.gs.oslo.no",
                     regdom.getRegisteredDomain("www.example.gs.oslo.no"));
        assertEquals("example.example.uk",
                     regdom.getRegisteredDomain("www.example.example.uk"));
        assertEquals("example.example.sch.uk",
                     regdom.getRegisteredDomain("www.example.example.sch.uk"));
    }
}
