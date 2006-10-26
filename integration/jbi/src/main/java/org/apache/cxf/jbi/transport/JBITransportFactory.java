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


package org.apache.cxf.jbi.transport;

import java.io.IOException;

import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.transport.AbstractTransportFactory;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.ConduitInitiator;
import org.apache.cxf.transport.Destination;
import org.apache.cxf.transport.DestinationFactory;
import org.apache.cxf.ws.addressing.EndpointReferenceType;

public class JBITransportFactory extends AbstractTransportFactory implements ConduitInitiator,
    DestinationFactory {

    public Conduit getConduit(EndpointInfo targetInfo) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    public Conduit getConduit(EndpointInfo localInfo, EndpointReferenceType target) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    public Destination getDestination(EndpointInfo ei) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

}
