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

public enum VipsForeignDzLayout {
    /**
     * VipsForeignDzLayout:
     * @VIPS_FOREIGN_DZ_LAYOUT_DZ: use DeepZoom directory layout
     * @VIPS_FOREIGN_DZ_LAYOUT_ZOOMIFY: use Zoomify directory layout
     * @VIPS_FOREIGN_DZ_LAYOUT_GOOGLE: use Google maps directory layout
     * @VIPS_FOREIGN_DZ_LAYOUT_IIIF: use IIIF directory layout
     *
     * What directory layout and metadata standard to use. 
     */
    Dz(0),
    Zoomify(1),
    Google(2),
    Iiif(3),
    Last(4);

    private unsigned int value;
    private static Map map = new HashMap<VipsForeignDzLayout, Integer>();

    private VipsForeignDzLayout(unsigned int i) {
      value = i;
    }

    static {
        for (VipsForeignDzLayout e : VipsForeignDzLayout.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsForeignDzLayout valueOf(unsigned int i) {
        return (VipsForeignDzLayout) map.get(i);
    }

    public unsigned int getValue() {
      return value;
    }
}
