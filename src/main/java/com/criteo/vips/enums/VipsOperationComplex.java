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

public enum VipsOperationComplex {
    /** 
     * VipsOperationComplex:
     * @VIPS_OPERATION_COMPLEX_POLAR: convert to polar coordinates
     * @VIPS_OPERATION_COMPLEX_RECT: convert to rectangular coordinates
     * @VIPS_OPERATION_COMPLEX_CONJ: complex conjugate
     *
     * See also: vips_complex().
     */
    Polar(0),
    Rect(1),
    Conj(2),
    Last(3);

    private unsigned int value;
    private static Map map = new HashMap<VipsOperationComplex, Integer>();

    private VipsOperationComplex(unsigned int i) {
      value = i;
    }

    static {
        for (VipsOperationComplex e : VipsOperationComplex.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsOperationComplex valueOf(unsigned int i) {
        return (VipsOperationComplex) map.get(i);
    }

    public unsigned int getValue() {
      return value;
    }
}
