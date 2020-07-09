$license

package com.criteo.vips.enums;

public enum $name implements IEnumValue {
$values;

    private int value;

    private $name(int i) {
      value = i;
    }

    @Override
    public int getValue() {
      return value;
    }
}