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

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class GenerateEffectiveTLDs{

    private static void buildSubdomain(HashMap<String, HashMap> node,
                                       LinkedList<String> parts){
        boolean isNotDomain = false;
        String sub = parts.removeLast();
        if (sub.startsWith("!")) {
            isNotDomain = true;
            sub = sub.substring(1);
        }
        HashMap<String, HashMap> child = node.get(sub);
        if(child == null){
            child = new HashMap<String, HashMap>();
            if(isNotDomain){
                child.put("!", new HashMap(0));
            }
            node.put(sub, child);
        }
        if(!isNotDomain && parts.size() > 0){
            buildSubdomain(child, parts);
        }
    }

    public static void main(String[] args) throws Exception{
        FileReader file = new FileReader(args[0]);
        BufferedReader buffer = new BufferedReader(file);
        HashMap<String, HashMap> tree = new HashMap<String, HashMap>();

        String line;
        while ((line = buffer.readLine()) != null) {
            if (line.startsWith("//")) {
                continue;
            }
            if (line.isEmpty()) {
                continue;
            }
            List<String> list = Arrays.asList(line.split("\\."));
            LinkedList<String> parts = new LinkedList<String>(list);
            buildSubdomain(tree, parts);
        }
        buffer.close();

        GenerateEffectiveTLDs obj = new GenerateEffectiveTLDs();
        //OutputStream os = new FileOutputStream("object.xml");
        XMLEncoder encoder= new XMLEncoder(new BufferedOutputStream(System.out));
        encoder.writeObject(tree);
        encoder.close();
    }
}
