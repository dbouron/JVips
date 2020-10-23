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

public enum VipsOperationComplex2 {
    /** 
     * VipsOperationComplex2:
     * @VIPS_OPERATION_COMPLEX2_CROSS_PHASE: convert to polar coordinates
     *
     * See also: vips_complex2().
     */
    CrossPhase(0),
    Last(1);

    private unsigned int value;
    private static Map map = new HashMap<VipsOperationComplex2, Integer>();

    private VipsOperationComplex2(unsigned int i) {
      value = i;
    }

    static {
        for (VipsOperationComplex2 e : VipsOperationComplex2.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsOperationComplex2 valueOf(unsigned int i) {
        return (VipsOperationComplex2) map.get(i);
    }

    public unsigned int getValue() {
      return value;
    }
}
