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

public enum VipsCombine {
    Max(0),
    Sum(1),
    Min(2),
    Last(3);

    private unsigned int value;
    private static Map map = new HashMap<VipsCombine, Integer>();

    private VipsCombine(unsigned int i) {
      value = i;
    }

    static {
        for (VipsCombine e : VipsCombine.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsCombine valueOf(unsigned int i) {
        return (VipsCombine) map.get(i);
    }

    public unsigned int getValue() {
      return value;
    }
}
