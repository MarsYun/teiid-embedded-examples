/*
 * Copyright Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags and
 * the COPYRIGHT.txt file distributed with this work.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.teiid.example;

import static org.teiid.example.JDBCUtils.execute;

import java.sql.Connection;

import org.teiid.resource.adapter.ws.WSManagedConnectionFactory;
import org.teiid.runtime.EmbeddedConfiguration;
import org.teiid.runtime.EmbeddedServer;
import org.teiid.translator.ws.WSExecutionFactory;

@SuppressWarnings("nls")
public class TeiidEmbeddedRestWebServiceDataSource {

	public static void main(String[] args) throws Exception {
		
		EmbeddedServer server = new EmbeddedServer();
		
		WSExecutionFactory factory = new WSExecutionFactory();
		factory.start();
		server.addTranslator("translator-rest", factory);
		
		WSManagedConnectionFactory managedconnectionFactory = new WSManagedConnectionFactory();
		server.addConnectionFactory("java:/CustomerRESTWebSvcSource", managedconnectionFactory.createConnectionFactory());

		server.start(new EmbeddedConfiguration());
    	
		server.deployVDB(TeiidEmbeddedRestWebServiceDataSource.class.getClassLoader().getResourceAsStream("restwebservice-vdb.xml"));
		
		Connection c = server.getDriver().connect("jdbc:teiid:restwebservice", null);
		
		execute(c, "EXEC getCustomer('http://localhost:8080/customer/customerList')", false);
		execute(c, "EXEC getAll('http://localhost:8080/customer/getAll')", false);
		execute(c, "EXEC getOne('http://localhost:8080/customer/getByNumber/161')", false);
		execute(c, "EXEC getOne('http://localhost:8080/customer/getByName/Technics%20Stores%20Inc.')", false);
		execute(c, "EXEC getOne('http://localhost:8080/customer/getByCity/Burlingame')", false);
		execute(c, "EXEC getOne('http://localhost:8080/customer/getByCountry/USA')", false);
		
		execute(c, "SELECT * FROM CustomersView", true);
		
		server.stop();
	}

}
