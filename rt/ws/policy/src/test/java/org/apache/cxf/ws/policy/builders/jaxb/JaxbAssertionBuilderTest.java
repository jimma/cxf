/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.cxf.ws.policy.builders.jaxb;

import java.io.InputStream;

import javax.xml.namespace.QName;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import junit.framework.TestCase;

import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.test.assertions.foo.FooType;
import org.apache.neethi.Assertion;

/**
 * 
 */
public class JaxbAssertionBuilderTest extends TestCase {
    
    public void testConstructors() throws Exception {        
        QName qn = new QName("http://cxf.apache.org/test/assertions/foo", "FooType");
        try {
            new JaxbAssertionBuilder("org.apache.cxf.test.assertions.foo.UnknownType", qn);
            fail("Expected ClassNotFoundException not thrown.");
        } catch (ClassNotFoundException ex) {
            // expected
        }
        assertNotNull(new JaxbAssertionBuilder(qn)); 
        assertNotNull(new JaxbAssertionBuilder("org.apache.cxf.test.assertions.foo.FooType", qn));   
        assertNotNull(new JaxbAssertionBuilder<FooType>(FooType.class, qn));
    }
    
    
    public void testGetKnownElements() throws Exception {
        QName qn = new QName("http://cxf.apache.org/test/assertions/foo", "FooType");
        JaxbAssertionBuilder<FooType> ab = new JaxbAssertionBuilder<FooType>(FooType.class, qn);
        assertNotNull(ab);
        assertEquals(1, ab.getKnownElements().size());
        assertSame(qn, ab.getKnownElements().iterator().next());
    }
    
    @SuppressWarnings("unchecked")
    public void testBuild() throws Exception {
        QName qn = new QName("http://cxf.apache.org/test/assertions/foo", "FooType");
        JaxbAssertionBuilder<FooType> ab = new JaxbAssertionBuilder<FooType>(FooType.class, qn);
        assertNotNull(ab);
        InputStream is = JaxbAssertionBuilderTest.class.getResourceAsStream("foo.xml");
        Document doc = DOMUtils.readXml(is);
        Element elem = (Element)doc.getDocumentElement()
            .getElementsByTagNameNS("http://cxf.apache.org/test/assertions/foo", "foo").item(0);
        Assertion a = ab.build(elem);
        JaxbAssertion<FooType> jba = (JaxbAssertion<FooType>)a;
        FooType foo = jba.getData();
        assertEquals("CXF", foo.getName());
        assertEquals(2, foo.getNumber().intValue());         
    }

}
