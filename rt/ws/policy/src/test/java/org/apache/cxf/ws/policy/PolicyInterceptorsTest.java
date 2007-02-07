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

package org.apache.cxf.ws.policy;

import java.util.Collections;

import junit.framework.TestCase;

import org.apache.cxf.Bus;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.InterceptorChain;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.transport.Conduit;
import org.easymock.classextension.EasyMock;
import org.easymock.classextension.IMocksControl;

/**
 * 
 */
public class PolicyInterceptorsTest extends TestCase {
    
    private IMocksControl control;
    private Message message;
    private BindingOperationInfo boi;
    private EndpointInfo ei;
    private Bus bus;
    private PolicyEngine pe;
    private Conduit conduit;
    
    
    public void setUp() {
        control = EasyMock.createNiceControl();
        bus = control.createMock(Bus.class);       
    } 
    
    public void testClientPolicyOutInterceptor() {
        ClientPolicyOutInterceptor interceptor = new ClientPolicyOutInterceptor();
        interceptor.setBus(bus);
       
        doTestBasics(interceptor);
        
        control.reset();
        setupMessage(true, true, true, true);
        Interceptor i = control.createMock(Interceptor.class);
        EasyMock.expect(pe.getClientOutInterceptors(boi, ei, conduit))
            .andReturn(CastUtils.cast(Collections.singletonList(i), Interceptor.class));
        InterceptorChain ic = control.createMock(InterceptorChain.class);
        EasyMock.expect(message.getInterceptorChain()).andReturn(ic);
        ic.add(i);
        EasyMock.expectLastCall();
        control.replay();
        interceptor.handleMessage(message);
        control.verify();        
    }
    
    public void testClientPolicyInInterceptor() {
        ClientPolicyInInterceptor interceptor = new ClientPolicyInInterceptor();
        interceptor.setBus(bus);
        
        doTestBasics(interceptor);
        
        control.reset();
        setupMessage(true, true, true, true);
        Interceptor i = control.createMock(Interceptor.class);
        EasyMock.expect(pe.getClientInInterceptors(boi, ei, conduit))
            .andReturn(CastUtils.cast(Collections.singletonList(i), Interceptor.class));
        InterceptorChain ic = control.createMock(InterceptorChain.class);
        EasyMock.expect(message.getInterceptorChain()).andReturn(ic);
        ic.add(i);
        EasyMock.expectLastCall();
        control.replay();
        interceptor.handleMessage(message);
        control.verify();        
    }
    
    public void testClientPolicyInFaultInterceptor() {
        ClientPolicyInFaultInterceptor interceptor = new ClientPolicyInFaultInterceptor();
        interceptor.setBus(bus);
        
        doTestBasics(interceptor);
        
        control.reset();
        setupMessage(true, true, true, true);
        Interceptor i = control.createMock(Interceptor.class);
        EasyMock.expect(pe.getClientInFaultInterceptors(boi, ei, conduit))
            .andReturn(CastUtils.cast(Collections.singletonList(i), Interceptor.class));
        InterceptorChain ic = control.createMock(InterceptorChain.class);
        EasyMock.expect(message.getInterceptorChain()).andReturn(ic);
        ic.add(i);
        EasyMock.expectLastCall();
        control.replay();
        interceptor.handleMessage(message);
        control.verify();        
    }
    
    private void doTestBasics(Interceptor<Message> interceptor) {
        setupMessage(false, false, false, false);
        control.replay();
        interceptor.handleMessage(message);
        control.verify();
        
        control.reset();
        setupMessage(true, false, false, false);
        control.replay();
        interceptor.handleMessage(message);
        control.verify();
        
        control.reset();
        setupMessage(true, true, false, false);
        control.replay();
        interceptor.handleMessage(message);
        control.verify();
            
        control.reset();
        setupMessage(true, true, true, false);
        control.replay();
        interceptor.handleMessage(message);
        control.verify();
    }
    
    void setupMessage(boolean setupRequestor, 
                      boolean setupOperation, 
                      boolean setupEndpoint, 
                      boolean setupEngine) {
        message = control.createMock(Message.class);
        EasyMock.expect(message.get(Message.REQUESTOR_ROLE))
            .andReturn(setupRequestor ? Boolean.TRUE : Boolean.FALSE);
        if (!setupRequestor) {
            return;
        }        

        if (null == boi) {
            boi = control.createMock(BindingOperationInfo.class);
        }
        EasyMock.expect(message.get(BindingOperationInfo.class)).andReturn(setupOperation ? boi : null);
        if (!setupOperation) {
            return;
        }
               
        if (null == ei) {
            ei = control.createMock(EndpointInfo.class);
        }
        EasyMock.expect(message.get(EndpointInfo.class)).andReturn(setupEndpoint ? ei : null);
        if (!setupEndpoint) {
            return;
        }
        if (null == pe) {
            pe = control.createMock(PolicyEngine.class);
        }
        EasyMock.expect(bus.getExtension(PolicyEngine.class)).andReturn(setupEngine ? pe : null);
        if (!setupEngine) {
            return;
        }
            
        if (null == conduit) {
            conduit = control.createMock(Conduit.class);
        }
        EasyMock.expect(message.getConduit()).andReturn(conduit);
      
    }
}
