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

public enum VipsForeignWebpPreset {
    /**
     * VipsForeignWebpPreset:
     * @VIPS_FOREIGN_WEBP_PRESET_DEFAULT: default preset
     * @VIPS_FOREIGN_WEBP_PRESET_PICTURE: digital picture, like portrait, inner shot
     * @VIPS_FOREIGN_WEBP_PRESET_PHOTO: outdoor photograph, with natural lighting
     * @VIPS_FOREIGN_WEBP_PRESET_DRAWING: hand or line drawing, with high-contrast details
     * @VIPS_FOREIGN_WEBP_PRESET_ICON: small-sized colorful images
     * @VIPS_FOREIGN_WEBP_PRESET_TEXT: text-like
     *
     * Tune lossy encoder settings for different image types.
     */
    Default(0),
    Picture(1),
    Photo(2),
    Drawing(3),
    Icon(4),
    Text(5),
    Last(6);

    private int value;
    private static Map map = new HashMap<VipsForeignWebpPreset, Integer>();

    private VipsForeignWebpPreset(int i) {
      value = i;
    }

    static {
        for (VipsForeignWebpPreset e : VipsForeignWebpPreset.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsForeignWebpPreset valueOf(int i) {
        return (VipsForeignWebpPreset) map.get(i);
    }

    public int getValue() {
      return value;
    }
}
