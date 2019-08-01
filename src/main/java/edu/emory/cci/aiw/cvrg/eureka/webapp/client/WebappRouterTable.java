package edu.emory.cci.aiw.cvrg.eureka.webapp.client;

/*-
 * #%L
 * Eureka WebApp
 * %%
 * Copyright (C) 2012 - 2017 Emory University
 * %%
 * This program is dual licensed under the Apache 2 and GPLv3 licenses.
 * 
 * Apache License, Version 2.0:
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * GNU General Public License version 3:
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */
import org.eurekaclinical.phenotype.client.EurekaClinicalPhenotypeClient;
import javax.inject.Inject;
import org.eurekaclinical.common.comm.clients.Route;
import org.eurekaclinical.common.comm.clients.RouterTable;
import org.eurekaclinical.common.comm.clients.RouterTableLoadException;
import org.eurekaclinical.eureka.client.EurekaClient;
import org.eurekaclinical.protempa.client.EurekaClinicalProtempaClient;
import org.eurekaclinical.registry.client.EurekaClinicalRegistryClient;
import org.eurekaclinical.user.client.EurekaClinicalUserClient;

/**
 *
 * @author Andrew Post
 */
public class WebappRouterTable implements RouterTable {

    private final EurekaClinicalUserClient userClient;
    private final EurekaClient servicesClient;
    private final EurekaClinicalProtempaClient etlClient;
    private final EurekaClinicalRegistryClient registryClient;
    private final EurekaClinicalPhenotypeClient phenotypeClient;

    @Inject
    public WebappRouterTable(EurekaClient inServices, EurekaClinicalUserClient inUserClient, EurekaClinicalProtempaClient inEtlClient, EurekaClinicalRegistryClient inRegistryClient,EurekaClinicalPhenotypeClient inPhenotypeClient) {
        this.servicesClient = inServices;
        this.userClient = inUserClient;
        this.etlClient = inEtlClient;
        this.registryClient = inRegistryClient;
        this.phenotypeClient = inPhenotypeClient;
    }

    @Override
    public Route[] load() throws RouterTableLoadException {
        return new Route[]{
            new Route("/users", "/api/protected/users", this.userClient),
            new Route("/roles", "/api/protected/roles", this.userClient),
            new Route("/appproperties", "/api/appproperties", this.servicesClient),
            new Route("/file", "/api/protected/file", this.etlClient),
            new Route("/output", "/api/protected/output", this.etlClient),
            new Route("/jobmodes", "/api/protected/jobmodes", this.etlClient),
            new Route("/components", "/api/protected/components", this.registryClient),
            new Route("/phenotypes", "/api/protected/phenotypes", this.phenotypeClient),
            new Route("/frequencytypes", "/api/protected/frequencytypes", this.phenotypeClient),
            new Route("/thresholdsops", "/api/protected/thresholdsops", this.phenotypeClient),
            new Route("/relationops", "/api/protected/relationops", this.phenotypeClient),
            new Route("/timeunits", "/api/protected/timeunits", this.phenotypeClient),
            new Route("/valuecomps", "/api/protected/valuecomps", this.phenotypeClient),
            new Route("/jobs", "/api/protected/jobs", this.etlClient),
            new Route("/destinations", "/api/protected/destinations", this.etlClient),
            new Route("/sourceconfigs", "/api/protected/sourceconfigs", this.etlClient),
            new Route("/concepts", "/api/protected/concepts", this.etlClient),
            new Route("/", "/api/protected/", this.servicesClient)
        };
    }
}
