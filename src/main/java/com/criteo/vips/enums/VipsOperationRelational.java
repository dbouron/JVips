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

public enum VipsOperationRelational {
    /** 
     * VipsOperationRelational:
     * @VIPS_OPERATION_RELATIONAL_EQUAL: ==
     * @VIPS_OPERATION_RELATIONAL_NOTEQ: !=
     * @VIPS_OPERATION_RELATIONAL_LESS: <
     * @VIPS_OPERATION_RELATIONAL_LESSEQ: <=
     * @VIPS_OPERATION_RELATIONAL_MORE: >
     * @VIPS_OPERATION_RELATIONAL_MOREEQ: >=
     *
     * See also: vips_relational().
     */
    Equal(0),
    Noteq(1),
    Less(2),
    Lesseq(3),
    More(4),
    Moreeq(5),
    Last(6);

    private unsigned int value;
    private static Map map = new HashMap<VipsOperationRelational, Integer>();

    private VipsOperationRelational(unsigned int i) {
      value = i;
    }

    static {
        for (VipsOperationRelational e : VipsOperationRelational.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsOperationRelational valueOf(unsigned int i) {
        return (VipsOperationRelational) map.get(i);
    }

    public unsigned int getValue() {
      return value;
    }
}
