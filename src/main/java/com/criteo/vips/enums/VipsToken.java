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

public enum VipsToken {
    /** 
     * VipsToken:
     * @VIPS_TOKEN_LEFT: left bracket
     * @VIPS_TOKEN_RIGHT: right bracket
     * @VIPS_TOKEN_STRING: string constant
     * @VIPS_TOKEN_EQUALS: equals sign
     * @VIPS_TOKEN_COMMA: comma
     *
     * Tokens returned by the vips lexical analyzer, see vips__token_get(). This
     * is used to parse option strings for arguments. 
     *
     * Left and right brackets can be any of (, {, [, <.
     *
     * Strings may be in double quotes, and may contain escaped quote characters,
     * for example string, "string" and "str\"ing".
     *
     */
    Left(1),
    Right(2),
    String(3),
    Equals(4),
    Comma(5);

    private unsigned int value;
    private static Map map = new HashMap<VipsToken, Integer>();

    private VipsToken(unsigned int i) {
      value = i;
    }

    static {
        for (VipsToken e : VipsToken.values()) {
            map.put(e.value, e);
        }
    }

    public static VipsToken valueOf(unsigned int i) {
        return (VipsToken) map.get(i);
    }

    public unsigned int getValue() {
      return value;
    }
}
