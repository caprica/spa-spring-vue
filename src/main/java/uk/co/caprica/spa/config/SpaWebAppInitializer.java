/*
 * This file is part of Spa.
 *
 * Copyright (C) 2019
 * Caprica Software Limited (capricasoftware.co.uk)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.caprica.spa.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Automatic initialisation class for our application.
 * <p>
 * This class is discovered at run-time by the servlet container and will bootstrap the application.
 * <p>
 * Some aspects of the application are initialised by the associated {@link SpaWebAppConfiguration} class.
 * <p>
 * Key features:
 * <ul>
 *     <li>The web application is mapped to the root "/" context</li>
 *     <li>All static resources are under the "/assets/" path</li>
 *     <li>A request for "index.html" will redirect to "/" for a nicer URL in the address bar</li>
 *     <li>All web-service API are under an "/api/" path</li>
 *     <li>A request for an unknown API will have a catch-all that maps to a BAD_REQUEST response</li>
 *     <li>Any other request, including deep-link requests, will map to the single page web application for client
 *         routing</li>
 * </ul>
 * The names for the path prefixes used here are arbitrary and can be changed to whatever you prefer.
 */
public class SpaWebAppInitializer implements WebApplicationInitializer {

    // Name for the servlet, does not really matter what it is
    private static final String SERVLET_NAME = "app";

    // Map the SpringMVC servlet to the default context root
    private static final String SERVLET_MAPPING = "/";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create an application context using our configuration class
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext);
        context.register(SpaWebAppConfiguration.class);
        context.refresh();

        // Create and register the SpringMVC dispatcher servlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet(SERVLET_NAME, servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping(SERVLET_MAPPING);
    }

}
