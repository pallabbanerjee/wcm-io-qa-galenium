/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2018 wcm.io
 * %%
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
 * #L%
 */
package io.wcm.qa.galenium.selectors;

import org.openqa.selenium.By;

import com.galenframework.specs.page.Locator;

class FixedValueSelector implements Selector {

  private By by;
  private String elementName;
  private Locator locator;
  private String string;

  public FixedValueSelector(Selector selector) {
    this(selector.elementName(), selector.asString(), selector.asBy(), selector.asLocator());
  }

  public FixedValueSelector(String elementName, String css, By by, Locator locator) {
    this.by = by;
    this.elementName = elementName;
    this.locator = locator;
    this.string = css;
  }

  @Override
  public By asBy() {
    return by;
  }

  @Override
  public Locator asLocator() {
    return locator;
  }

  @Override
  public String asString() {
    return string;
  }

  @Override
  public String elementName() {
    return elementName;
  }

}