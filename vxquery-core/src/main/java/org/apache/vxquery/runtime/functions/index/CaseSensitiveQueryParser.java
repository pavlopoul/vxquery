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
*/
package org.apache.vxquery.runtime.functions.index;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.FastCharStream;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;

import java.io.StringReader;

public class CaseSensitiveQueryParser extends QueryParser {

    public CaseSensitiveQueryParser(String f, Analyzer a) {
        super(new FastCharStream(new StringReader("")));
        init(f, a);
    }

    @Override
    protected Query getPrefixQuery(String field, String termStr) throws ParseException {
        if (!getAllowLeadingWildcard() && termStr.startsWith("*"))
            throw new ParseException("'*' not allowed as first character in PrefixQuery");
        Term t = new Term(field, termStr);
        return newPrefixQuery(t);
    }
}