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

package com.criteo.vips.enums;

import java.util.HashMap;
import java.util.Map;

public enum VipsForeignDzDepth {
    /**
     * VipsForeignDzDepth:
     * @VIPS_FOREIGN_DZ_DEPTH_ONEPIXEL: create layers down to 1x1 pixel
     * @VIPS_FOREIGN_DZ_DEPTH_ONETILE: create layers down to 1x1 tile
     * @VIPS_FOREIGN_DZ_DEPTH_ONE: only create a single layer
     *
     * How many pyramid layers to create.
     */
    Onepixel(0),
    Onetile(1),
    One(2),
    Last(3);

    private int value;
    private static Map map = new HashMap<VipsForeignDzDepth, Integer>();

    private VipsForeignDzDepth(int i) {
      value = i;
    }

    static {
        for (VipsForeignDzDepth e : VipsForeignDzDepth.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsForeignDzDepth valueOf(int i) {
        return (VipsForeignDzDepth) map.get(i);
    }

    public int getValue() {
      return value;
    }
}
