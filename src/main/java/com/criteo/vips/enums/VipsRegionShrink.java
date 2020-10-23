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

public enum VipsRegionShrink {
    /**
     * VipsRegionShrink:
     * @VIPS_REGION_SHRINK_MEAN: use the average
     * @VIPS_REGION_SHRINK_MEDIAN: use the median
     * @VIPS_REGION_SHRINK_MODE: use the mode
     *
     * How to calculate the output pixels when shrinking a 2x2 region.
     */
    Mean(0),
    Median(1),
    Mode(2),
    Last(3);

    private int value;
    private static Map map = new HashMap<VipsRegionShrink, Integer>();

    private VipsRegionShrink(int i) {
      value = i;
    }

    static {
        for (VipsRegionShrink e : VipsRegionShrink.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsRegionShrink valueOf(int i) {
        return (VipsRegionShrink) map.get(i);
    }

    public int getValue() {
      return value;
    }
}
