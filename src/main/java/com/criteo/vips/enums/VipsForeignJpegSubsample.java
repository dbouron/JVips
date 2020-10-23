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

public enum VipsForeignJpegSubsample {
    /**
     * VipsForeignJpegSubsample:
     * @VIPS_FOREIGN_JPEG_SUBSAMPLE_AUTO: default preset
     * @VIPS_FOREIGN_JPEG_SUBSAMPLE_ON: always perform subsampling
     * @VIPS_FOREIGN_JPEG_SUBSAMPLE_OFF: never perform subsampling
     *
     * Set jpeg subsampling mode.
     */
    Auto(0),
    On(1),
    Off(2),
    Last(3);

    private int value;
    private static Map map = new HashMap<VipsForeignJpegSubsample, Integer>();

    private VipsForeignJpegSubsample(int i) {
      value = i;
    }

    static {
        for (VipsForeignJpegSubsample e : VipsForeignJpegSubsample.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsForeignJpegSubsample valueOf(int i) {
        return (VipsForeignJpegSubsample) map.get(i);
    }

    public int getValue() {
      return value;
    }
}
