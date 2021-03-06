/*
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
package org.jboss.gwt.elemento.sample.builder.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.sample.common.I18n;
import org.jboss.gwt.elemento.sample.common.TodoConstants;
import org.jboss.gwt.elemento.sample.common.TodoItemRepository;
import org.jboss.gwt.elemento.sample.common.TodoMessages;

public class Main implements EntryPoint {

    private static final TodoConstants CONSTANTS = GWT.create(TodoConstants.class);
    private static final TodoMessages MESSAGES = GWT.create(TodoMessages.class);

    @Override
    public void onModuleLoad() {
        I18n i18n = new I18n(CONSTANTS, MESSAGES);
        TodoItemRepository repository = new TodoItemRepository();
        ApplicationElement application = new ApplicationElement(repository, i18n);
        FooterElement footer = new FooterElement(i18n);

        Elements.body().add(application).add(footer);

        History.addValueChangeHandler(event -> application.filter(event.getValue()));
        History.fireCurrentHistoryState();
    }
}
