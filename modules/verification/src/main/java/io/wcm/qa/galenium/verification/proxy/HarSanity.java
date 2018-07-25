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
package io.wcm.qa.galenium.verification.proxy;

import java.util.List;

import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarResponse;

public class HarSanity extends HarStability {

  @Override
  protected boolean checkForEquality(List<HarEntry> oldList, List<HarEntry> newList) {
    if (super.checkForEquality(oldList, newList)) {
      getLogger().debug("Har is stable. Now checking sanity.");
      return checkSanity(newList);
    }
    return false;
  }

  private boolean checkSanity(List<HarEntry> newList) {
    if (newList.isEmpty()) {
      // we want samples
      return false;
    }
    for (HarEntry harEntry : newList) {
      HarResponse response = harEntry.getResponse();
      if (response.getStatus() == 0) {
        // zero status means request not finished
        getLogger().debug("found response with response status 0: " + response);
        return false;
      }
    }
    return true;
  }
}