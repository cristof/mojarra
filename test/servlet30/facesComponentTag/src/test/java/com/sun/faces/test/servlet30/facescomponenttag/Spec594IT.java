/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.faces.test.servlet30.facescomponenttag;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class Spec594IT {

    private String webUrl;
    private WebClient webClient;

    @Before
    public void setUp() {
        webUrl = System.getProperty("integration.url");
        webClient = new WebClient();
    }

    @After
    public void tearDown() {
        webClient.close();
    }

    @Test
    public void testFacesComponentTag() throws Exception {
        HtmlPage page = webClient.getPage(webUrl + "faces/index.xhtml");
        String pageXml = page.asXml();
        assertTrue(pageXml.matches("(?s).*<input\\s+id=\"tagNameExplicitlyDeclared\"\\s+type=\"text\"\\s+name=\"tagNameExplicitlyDeclared\"/>.*<input\\s+id=\"myTag\"\\s+type=\"text\"\\s+name=\"myTag\"/>.*"));
        assertTrue(pageXml.contains("jakarta.faces.ViewState"));
    }
}