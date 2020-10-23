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

public enum VipsForeignTiffCompression {
    /**
     * VipsForeignTiffCompression:
     * @VIPS_FOREIGN_TIFF_COMPRESSION_NONE: no compression
     * @VIPS_FOREIGN_TIFF_COMPRESSION_JPEG: jpeg compression
     * @VIPS_FOREIGN_TIFF_COMPRESSION_DEFLATE: deflate (zip) compression
     * @VIPS_FOREIGN_TIFF_COMPRESSION_PACKBITS: packbits compression
     * @VIPS_FOREIGN_TIFF_COMPRESSION_CCITTFAX4: fax4 compression
     * @VIPS_FOREIGN_TIFF_COMPRESSION_LZW: LZW compression
     * @VIPS_FOREIGN_TIFF_COMPRESSION_WEBP: WEBP compression
     * @VIPS_FOREIGN_TIFF_COMPRESSION_ZSTD: ZSTD compression
     *
     * The compression types supported by the tiff writer.
     *
     * Use @Q to set the jpeg compression level, default 75.
     *
     * Use @prediction to set the lzw or deflate prediction, default none.
     *
     * Use @lossless to set WEBP lossless compression.
     *
     * Use @level to set webp and zstd compression level.
     */
    None(0),
    Jpeg(1),
    Deflate(2),
    Packbits(3),
    Ccittfax4(4),
    Lzw(5),
    Webp(6),
    Zstd(7),
    Last(8);

    private int value;
    private static Map map = new HashMap<VipsForeignTiffCompression, Integer>();

    private VipsForeignTiffCompression(int i) {
      value = i;
    }

    static {
        for (VipsForeignTiffCompression e : VipsForeignTiffCompression.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsForeignTiffCompression valueOf(int i) {
        return (VipsForeignTiffCompression) map.get(i);
    }

    public int getValue() {
      return value;
    }
}
