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

public enum VipsSaveable {
    /** 
     * VipsSaveable:
     * @VIPS_SAVEABLE_MONO: 1 band (eg. CSV)
     * @VIPS_SAVEABLE_RGB: 1 or 3 bands (eg. PPM) 
     * @VIPS_SAVEABLE_RGBA: 1, 2, 3 or 4 bands (eg. PNG)
     * @VIPS_SAVEABLE_RGBA_ONLY: 3 or 4 bands (eg. WEBP)
     * @VIPS_SAVEABLE_RGB_CMYK: 1, 3 or 4 bands (eg. JPEG)
     * @VIPS_SAVEABLE_ANY: any number of bands (eg. TIFF)
     *
     * See also: #VipsForeignSave.
     */
    Mono(0),
    Rgb(1),
    Rgba(2),
    RgbaOnly(3),
    RgbCmyk(4),
    Any(5),
    Last(6);

    private unsigned int value;
    private static Map map = new HashMap<VipsSaveable, Integer>();

    private VipsSaveable(unsigned int i) {
      value = i;
    }

    static {
        for (VipsSaveable e : VipsSaveable.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsSaveable valueOf(unsigned int i) {
        return (VipsSaveable) map.get(i);
    }

    public unsigned int getValue() {
      return value;
    }
}
