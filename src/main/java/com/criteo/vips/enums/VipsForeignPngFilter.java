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

public enum VipsForeignPngFilter {
    /**
     * VipsForeignPngFilter:
     * @VIPS_FOREIGN_PNG_FILTER_NONE: no filtering
     * @VIPS_FOREIGN_PNG_FILTER_SUB: difference to the left
     * @VIPS_FOREIGN_PNG_FILTER_UP: difference up
     * @VIPS_FOREIGN_PNG_FILTER_AVG: average of left and up
     * @VIPS_FOREIGN_PNG_FILTER_PAETH: pick best neighbor predictor automatically
     * @VIPS_FOREIGN_PNG_FILTER_ALL: adaptive
     *
     * http://www.w3.org/TR/PNG-Filters.html
     * The values mirror those of png.h in libpng.
     */
    None(8),
    Sub(16),
    Up(32),
    Avg(64),
    Paeth(128),
    All(248);

    private int value;
    private static Map map = new HashMap<VipsForeignPngFilter, Integer>();

    private VipsForeignPngFilter(int i) {
      value = i;
    }

    static {
        for (VipsForeignPngFilter e : VipsForeignPngFilter.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsForeignPngFilter valueOf(int i) {
        return (VipsForeignPngFilter) map.get(i);
    }

    public int getValue() {
      return value;
    }
}
