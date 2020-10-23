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

public enum VipsBBits {
    Byte(8),
    Short(16),
    Int(32),
    Float(32),
    Complex(64),
    Double(64),
    Dpcomplex(128);

    private unsigned int value;
    private static Map map = new HashMap<VipsBBits, Integer>();

    private VipsBBits(unsigned int i) {
      value = i;
    }

    static {
        for (VipsBBits e : VipsBBits.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsBBits valueOf(unsigned int i) {
        return (VipsBBits) map.get(i);
    }

    public unsigned int getValue() {
      return value;
    }
}
