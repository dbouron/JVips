/*
  Copyright (c) 2020 Criteo

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.criteo.vips;

import org.junit.Assert;
import org.junit.Test;

public class VipsInitTest {

    @Test
    public void TestVersion() {
        // Major
        Assert.assertEquals(8,  VipsInit.version(0));
        // Minor
        Assert.assertEquals(9,  VipsInit.version(1));
        // Micro
        Assert.assertEquals(0,  VipsInit.version(2));
    }
}