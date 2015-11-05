/*
 * JBoss, Home of Professional Open Source.
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */
package org.teiid.examples.app.customer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefaultExceptionHandler implements ExceptionMapper<Exception> {
    
    static Logger logger = Logger.getLogger(DefaultExceptionHandler.class.getName());
    
	@Override
	public Response toResponse(Exception e) {
		
		String status = "ERROR";
		if(e instanceof NotFoundException){
			status = "404";
		} else if(e instanceof InternalServerErrorException){
			status = "500";
		}
		
		String message = e.getMessage();
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String details = sw.toString();
		
		logger.log(Level.SEVERE, details);
		
		StringBuilder response = new StringBuilder("<error>");
        response.append("<code>" + status + "</code>");
        response.append("<message>" + message + "</message>");
        response.append("<details>" + details + "</details>");
        response.append("</error>");
        return Response.serverError().entity(response.toString()).type(MediaType.APPLICATION_XML).build();
	}

}
