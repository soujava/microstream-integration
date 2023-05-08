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

import static org.jnosql.demo.se.Airplane.builder;

public class App {


    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Airplane airplane = Airplane.id("1").model("777").year(1994).manufacturer("Boing");
            Airplane airplane2 = Airplane.id("2").model("767").year(1982).manufacturer("Boing");
            Airplane airplane3 = Airplane.id("3").model("747-8").year(2010).manufacturer("Boing");
            Airplane airplane4 = Airplane.id("4").model("E-175").year(2023).manufacturer("Embraer");
            Airplane airplane5 = Airplane.id("5").model("A319").year(1995).manufacturer("Airbus");
            Airport airport = container.select(Airport.class).get();
            airport.saveAll(List.of(airplane, airplane2, airplane3, airplane5, airplane5));
            List<Airplane> boings = airport.findByModel(airplane.getModel());
            System.out.println("The boings: " + boings);
            System.out.println("The boing models avialables: " + boings.size());
        }
        System.exit(0);
    }

    private App() {
    }
}
