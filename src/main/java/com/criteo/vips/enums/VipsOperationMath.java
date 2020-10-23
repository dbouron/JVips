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

public enum VipsOperationMath {
    /** 
     * VipsOperationMath:
     * @VIPS_OPERATION_MATH_SIN: sin(), angles in degrees
     * @VIPS_OPERATION_MATH_COS: cos(), angles in degrees
     * @VIPS_OPERATION_MATH_TAN: tan(), angles in degrees
     * @VIPS_OPERATION_MATH_ASIN: asin(), angles in degrees
     * @VIPS_OPERATION_MATH_ACOS: acos(), angles in degrees
     * @VIPS_OPERATION_MATH_ATAN: atan(), angles in degrees
     * @VIPS_OPERATION_MATH_LOG: log base e 
     * @VIPS_OPERATION_MATH_LOG10: log base 10 
     * @VIPS_OPERATION_MATH_EXP: e to the something
     * @VIPS_OPERATION_MATH_EXP10: 10 to the something
     *
     * See also: vips_math().
     */
    Sin(0),
    Cos(1),
    Tan(2),
    Asin(3),
    Acos(4),
    Atan(5),
    Log(6),
    Log10(7),
    Exp(8),
    Exp10(9),
    Last(10);

    private unsigned int value;
    private static Map map = new HashMap<VipsOperationMath, Integer>();

    private VipsOperationMath(unsigned int i) {
      value = i;
    }

    static {
        for (VipsOperationMath e : VipsOperationMath.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsOperationMath valueOf(unsigned int i) {
        return (VipsOperationMath) map.get(i);
    }

    public unsigned int getValue() {
      return value;
    }
}
