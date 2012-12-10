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

    String regularDomains[][] = {
        /* Registerd Domain, FQDN */
        {"example.com", "example.com"},
        {"example.com", "www.example.com"},
        {"example.com", "www.sub.example.com"},
        {"example.co.jp", "example.co.jp"},
        {"example.co.jp", "www.example.co.jp"},
        {"example.co.jp", "www.sub.example.co.jp"},
        {"example.tokyo.jp", "example.tokyo.jp"},
        {"example.tokyo.jp", "www.example.tokyo.jp"},
        {"example.tokyo.jp", "www.sub.example.tokyo.jp"},
        {"example.shinagawa.tokyo.jp", "example.shinagawa.tokyo.jp"},
        {"example.shinagawa.tokyo.jp", "www.example.shinagawa.tokyo.jp"},
        {"example.shinagawa.tokyo.jp", "www.sub.example.shinagawa.tokyo.jp"},
        {"example.gs.oslo.no", "example.gs.oslo.no"},
        {"example.gs.oslo.no", "www.example.gs.oslo.no"},
        {"example.gs.oslo.no", "www.sub.example.gs.oslo.no"},
        {"example.random.sch.uk", "example.random.sch.uk"},
        {"example.random.sch.uk", "www.example.random.sch.uk"},
        {"example.random.sch.uk", "www.sub.example.random.sch.uk"},
    };

    String alreadyEffectiveTLDs[] = {
        "com",
        "co.jp",
        "tokyo.jp",
        "shinagawa.tokyo.jp",
        "gs.oslo.no",
        "random.sch.uk",
    };

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
     * Regular domain Test
     */
    public void testRegularDomains()
    {
        for(String pair[]: regularDomains){
            assertEquals(pair[0], regdom.getRegisteredDomain(pair[1]));
        }
    }

    /**
     * Already effective TLD test
     */
    public void testAlreadyEffectiveTLDs()
    {
        for(String domain: alreadyEffectiveTLDs){
            assertNull(regdom.getRegisteredDomain(domain));
        }
    }

}
