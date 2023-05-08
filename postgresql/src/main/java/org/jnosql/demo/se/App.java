/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package org.jnosql.demo.se;


import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

import java.util.List;

public class App {


    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Airplane airplane = new Airplane("123", "Effective Java", 2002);
            Airplane airplane2 = new Airplane("1234", "Effective Java", 2019);
            Airplane airplane3 = new Airplane("1235", "Effective Java", 2022);
            Airport airport = container.select(Airport.class).get();
            airport.saveAll(List.of(airplane, airplane2, airplane3));
            List<Airplane> airplanes = airport.findByTitle(airplane.getTitle());
            System.out.println("The books: " + airplanes);
            System.out.println("The size: " + airplanes.size());
        }
        System.exit(0);
    }

    private App() {
    }
}
