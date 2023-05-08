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
            Airplane airplane = new Airplane("1", "boeing 777", 1994);
            Airplane airplane2 = new Airplane("2", "E-175", 2023);
            Airplane airplane3 = new Airplane("3", "Airbus A319", 1995);
            Airport airport = container.select(Airport.class).get();
            airport.saveAll(List.of(airplane, airplane2, airplane3));
            List<Airplane> airplanes = airport.findByModel(airplane.getModel());
            System.out.println("The books: " + airplanes);
            System.out.println("The size: " + airplanes.size());
        }
        System.exit(0);
    }

    private App() {
    }
}
