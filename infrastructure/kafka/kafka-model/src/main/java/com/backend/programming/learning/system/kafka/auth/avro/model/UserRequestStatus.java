/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.backend.programming.learning.system.kafka.auth.avro.model;
@org.apache.avro.specific.AvroGenerated
public enum UserRequestStatus implements org.apache.avro.generic.GenericEnumSymbol<UserRequestStatus> {
  CREATING, UPDATING, DELETING  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"UserRequestStatus\",\"namespace\":\"com.backend.programming.learning.system.kafka.auth.avro.model\",\"symbols\":[\"CREATING\",\"UPDATING\",\"DELETING\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
