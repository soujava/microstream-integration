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
            Book book = new Book("123", "Effective Java", 2002);
            Book book2 = new Book("1234", "Effective Java", 2019);
            Book book3 = new Book("1235", "Effective Java", 2022);
            Library library = container.select(Library.class).get();
            library.saveAll(List.of(book, book2, book3));
            List<Book> books = library.findByTitle(book.getTitle());
            System.out.println("The books: " + books);
            System.out.println("The size: " + books.size());
        }
        System.exit(0);
    }

    private App() {
    }
}
