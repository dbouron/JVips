$license

package com.criteo.vips.enums;

import java.util.HashMap;
import java.util.Map;

public enum $name {
$comment$values;

    private $type value;
    private static Map map = new HashMap<$name, Integer>();

    private $name($type i) {
      value = i;
    }

    static {
        for ($name e : $name.values()) {
            map.put(e.value, e);
        }
    }

    public static $name valueOf($type i) {
        return ($name) map.get(i);
    }

    public $type getValue() {
      return value;
    }
}
