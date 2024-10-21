package io.swagger.model.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Gets or Sets ListTypes
 */
public enum BatchTypes {
  GERMPLASM("germplasm"),
  LISTS("lists");

  private String value;

  BatchTypes(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BatchTypes fromValue(String text) {
    for (BatchTypes b : BatchTypes.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
