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

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.net.URL;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * RegDomain
 *
 */
public class RegDomain
{
    static final String EFFECTIVE_TLD_FILE = "/effectiveTLDs.xml";
    private HashMap<String, HashMap> tree;

    public RegDomain() throws IOException{
        URL url = getClass().getResource(EFFECTIVE_TLD_FILE);
        InputStream is = url.openStream();
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(is));
        tree = (HashMap)decoder.readObject();
    }

    public String getRegisteredDomain(String fqdn) {
        List<String> list = Arrays.asList(fqdn.split("\\."));
        LinkedList<String> parts = new LinkedList<String>(list);
        String result = findRegisteredDomain(parts, tree);
        return result;
    }

    private String findRegisteredDomain(LinkedList<String> parts,
                                        HashMap<String, HashMap> node){
        if(parts.size() == 0){
            return null;
        }
        String sub = parts.removeLast();
        String result = null;
        if(node.get("!") != null){
            return "";
        }else if(node.get(sub) != null){
            result = findRegisteredDomain(parts, node.get(sub));
        }else if(node.get("*") != null){
            result = findRegisteredDomain(parts, node.get("*"));
        }else{
            return sub;
        }
        if(result == null){
            return null;
        }else if (result.equals("")) {
            return sub;
        }else{
            return result + "." + sub;
        }
    }

    public static void main(String[] args) throws Exception {
        if(args.length < 1){
            System.err.println("Usage: java -jar regdom4j.jar <FQDN>");
            return;
        }
        RegDomain regdom = new RegDomain();
        System.out.println(regdom.getRegisteredDomain(args[0]));
        return;
    }
}
