/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.backend.programming.learning.system.kafka.auth.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class UserUpdateRequestAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5073056021239757721L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserUpdateRequestAvroModel\",\"namespace\":\"com.backend.programming.learning.system.kafka.auth.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"userId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"firstName\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"lastName\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"phone\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"address\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"avatarUrl\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"dob\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"},\"default\":0},{\"name\":\"updatedAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<UserUpdateRequestAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<UserUpdateRequestAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<UserUpdateRequestAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<UserUpdateRequestAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<UserUpdateRequestAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this UserUpdateRequestAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a UserUpdateRequestAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a UserUpdateRequestAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static UserUpdateRequestAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String id;
  private java.lang.String sagaId;
  private java.lang.String userId;
  private java.lang.String firstName;
  private java.lang.String lastName;
  private java.lang.String phone;
  private java.lang.String address;
  private java.lang.String avatarUrl;
  private java.time.Instant dob;
  private java.time.Instant updatedAt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public UserUpdateRequestAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param sagaId The new value for sagaId
   * @param userId The new value for userId
   * @param firstName The new value for firstName
   * @param lastName The new value for lastName
   * @param phone The new value for phone
   * @param address The new value for address
   * @param avatarUrl The new value for avatarUrl
   * @param dob The new value for dob
   * @param updatedAt The new value for updatedAt
   */
  public UserUpdateRequestAvroModel(java.lang.String id, java.lang.String sagaId, java.lang.String userId, java.lang.String firstName, java.lang.String lastName, java.lang.String phone, java.lang.String address, java.lang.String avatarUrl, java.time.Instant dob, java.time.Instant updatedAt) {
    this.id = id;
    this.sagaId = sagaId;
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.address = address;
    this.avatarUrl = avatarUrl;
    this.dob = dob.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.updatedAt = updatedAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return sagaId;
    case 2: return userId;
    case 3: return firstName;
    case 4: return lastName;
    case 5: return phone;
    case 6: return address;
    case 7: return avatarUrl;
    case 8: return dob;
    case 9: return updatedAt;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: sagaId = value$ != null ? value$.toString() : null; break;
    case 2: userId = value$ != null ? value$.toString() : null; break;
    case 3: firstName = value$ != null ? value$.toString() : null; break;
    case 4: lastName = value$ != null ? value$.toString() : null; break;
    case 5: phone = value$ != null ? value$.toString() : null; break;
    case 6: address = value$ != null ? value$.toString() : null; break;
    case 7: avatarUrl = value$ != null ? value$.toString() : null; break;
    case 8: dob = (java.time.Instant)value$; break;
    case 9: updatedAt = (java.time.Instant)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'sagaId' field.
   * @return The value of the 'sagaId' field.
   */
  public java.lang.String getSagaId() {
    return sagaId;
  }


  /**
   * Sets the value of the 'sagaId' field.
   * @param value the value to set.
   */
  public void setSagaId(java.lang.String value) {
    this.sagaId = value;
  }

  /**
   * Gets the value of the 'userId' field.
   * @return The value of the 'userId' field.
   */
  public java.lang.String getUserId() {
    return userId;
  }


  /**
   * Sets the value of the 'userId' field.
   * @param value the value to set.
   */
  public void setUserId(java.lang.String value) {
    this.userId = value;
  }

  /**
   * Gets the value of the 'firstName' field.
   * @return The value of the 'firstName' field.
   */
  public java.lang.String getFirstName() {
    return firstName;
  }


  /**
   * Sets the value of the 'firstName' field.
   * @param value the value to set.
   */
  public void setFirstName(java.lang.String value) {
    this.firstName = value;
  }

  /**
   * Gets the value of the 'lastName' field.
   * @return The value of the 'lastName' field.
   */
  public java.lang.String getLastName() {
    return lastName;
  }


  /**
   * Sets the value of the 'lastName' field.
   * @param value the value to set.
   */
  public void setLastName(java.lang.String value) {
    this.lastName = value;
  }

  /**
   * Gets the value of the 'phone' field.
   * @return The value of the 'phone' field.
   */
  public java.lang.String getPhone() {
    return phone;
  }


  /**
   * Sets the value of the 'phone' field.
   * @param value the value to set.
   */
  public void setPhone(java.lang.String value) {
    this.phone = value;
  }

  /**
   * Gets the value of the 'address' field.
   * @return The value of the 'address' field.
   */
  public java.lang.String getAddress() {
    return address;
  }


  /**
   * Sets the value of the 'address' field.
   * @param value the value to set.
   */
  public void setAddress(java.lang.String value) {
    this.address = value;
  }

  /**
   * Gets the value of the 'avatarUrl' field.
   * @return The value of the 'avatarUrl' field.
   */
  public java.lang.String getAvatarUrl() {
    return avatarUrl;
  }


  /**
   * Sets the value of the 'avatarUrl' field.
   * @param value the value to set.
   */
  public void setAvatarUrl(java.lang.String value) {
    this.avatarUrl = value;
  }

  /**
   * Gets the value of the 'dob' field.
   * @return The value of the 'dob' field.
   */
  public java.time.Instant getDob() {
    return dob;
  }


  /**
   * Sets the value of the 'dob' field.
   * @param value the value to set.
   */
  public void setDob(java.time.Instant value) {
    this.dob = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Gets the value of the 'updatedAt' field.
   * @return The value of the 'updatedAt' field.
   */
  public java.time.Instant getUpdatedAt() {
    return updatedAt;
  }


  /**
   * Sets the value of the 'updatedAt' field.
   * @param value the value to set.
   */
  public void setUpdatedAt(java.time.Instant value) {
    this.updatedAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Creates a new UserUpdateRequestAvroModel RecordBuilder.
   * @return A new UserUpdateRequestAvroModel RecordBuilder
   */
  public static com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder newBuilder() {
    return new com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder();
  }

  /**
   * Creates a new UserUpdateRequestAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new UserUpdateRequestAvroModel RecordBuilder
   */
  public static com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder newBuilder(com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder other) {
    if (other == null) {
      return new com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder();
    } else {
      return new com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new UserUpdateRequestAvroModel RecordBuilder by copying an existing UserUpdateRequestAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new UserUpdateRequestAvroModel RecordBuilder
   */
  public static com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder newBuilder(com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel other) {
    if (other == null) {
      return new com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder();
    } else {
      return new com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for UserUpdateRequestAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<UserUpdateRequestAvroModel>
    implements org.apache.avro.data.RecordBuilder<UserUpdateRequestAvroModel> {

    private java.lang.String id;
    private java.lang.String sagaId;
    private java.lang.String userId;
    private java.lang.String firstName;
    private java.lang.String lastName;
    private java.lang.String phone;
    private java.lang.String address;
    private java.lang.String avatarUrl;
    private java.time.Instant dob;
    private java.time.Instant updatedAt;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.userId)) {
        this.userId = data().deepCopy(fields()[2].schema(), other.userId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.firstName)) {
        this.firstName = data().deepCopy(fields()[3].schema(), other.firstName);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.lastName)) {
        this.lastName = data().deepCopy(fields()[4].schema(), other.lastName);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.phone)) {
        this.phone = data().deepCopy(fields()[5].schema(), other.phone);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.address)) {
        this.address = data().deepCopy(fields()[6].schema(), other.address);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.avatarUrl)) {
        this.avatarUrl = data().deepCopy(fields()[7].schema(), other.avatarUrl);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.dob)) {
        this.dob = data().deepCopy(fields()[8].schema(), other.dob);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.updatedAt)) {
        this.updatedAt = data().deepCopy(fields()[9].schema(), other.updatedAt);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
    }

    /**
     * Creates a Builder by copying an existing UserUpdateRequestAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.userId)) {
        this.userId = data().deepCopy(fields()[2].schema(), other.userId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.firstName)) {
        this.firstName = data().deepCopy(fields()[3].schema(), other.firstName);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.lastName)) {
        this.lastName = data().deepCopy(fields()[4].schema(), other.lastName);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.phone)) {
        this.phone = data().deepCopy(fields()[5].schema(), other.phone);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.address)) {
        this.address = data().deepCopy(fields()[6].schema(), other.address);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.avatarUrl)) {
        this.avatarUrl = data().deepCopy(fields()[7].schema(), other.avatarUrl);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.dob)) {
        this.dob = data().deepCopy(fields()[8].schema(), other.dob);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.updatedAt)) {
        this.updatedAt = data().deepCopy(fields()[9].schema(), other.updatedAt);
        fieldSetFlags()[9] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'sagaId' field.
      * @return The value.
      */
    public java.lang.String getSagaId() {
      return sagaId;
    }


    /**
      * Sets the value of the 'sagaId' field.
      * @param value The value of 'sagaId'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder setSagaId(java.lang.String value) {
      validate(fields()[1], value);
      this.sagaId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'sagaId' field has been set.
      * @return True if the 'sagaId' field has been set, false otherwise.
      */
    public boolean hasSagaId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'sagaId' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder clearSagaId() {
      sagaId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'userId' field.
      * @return The value.
      */
    public java.lang.String getUserId() {
      return userId;
    }


    /**
      * Sets the value of the 'userId' field.
      * @param value The value of 'userId'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder setUserId(java.lang.String value) {
      validate(fields()[2], value);
      this.userId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'userId' field has been set.
      * @return True if the 'userId' field has been set, false otherwise.
      */
    public boolean hasUserId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'userId' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder clearUserId() {
      userId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'firstName' field.
      * @return The value.
      */
    public java.lang.String getFirstName() {
      return firstName;
    }


    /**
      * Sets the value of the 'firstName' field.
      * @param value The value of 'firstName'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder setFirstName(java.lang.String value) {
      validate(fields()[3], value);
      this.firstName = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'firstName' field has been set.
      * @return True if the 'firstName' field has been set, false otherwise.
      */
    public boolean hasFirstName() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'firstName' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder clearFirstName() {
      firstName = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'lastName' field.
      * @return The value.
      */
    public java.lang.String getLastName() {
      return lastName;
    }


    /**
      * Sets the value of the 'lastName' field.
      * @param value The value of 'lastName'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder setLastName(java.lang.String value) {
      validate(fields()[4], value);
      this.lastName = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'lastName' field has been set.
      * @return True if the 'lastName' field has been set, false otherwise.
      */
    public boolean hasLastName() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'lastName' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder clearLastName() {
      lastName = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'phone' field.
      * @return The value.
      */
    public java.lang.String getPhone() {
      return phone;
    }


    /**
      * Sets the value of the 'phone' field.
      * @param value The value of 'phone'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder setPhone(java.lang.String value) {
      validate(fields()[5], value);
      this.phone = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'phone' field has been set.
      * @return True if the 'phone' field has been set, false otherwise.
      */
    public boolean hasPhone() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'phone' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder clearPhone() {
      phone = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'address' field.
      * @return The value.
      */
    public java.lang.String getAddress() {
      return address;
    }


    /**
      * Sets the value of the 'address' field.
      * @param value The value of 'address'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder setAddress(java.lang.String value) {
      validate(fields()[6], value);
      this.address = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'address' field has been set.
      * @return True if the 'address' field has been set, false otherwise.
      */
    public boolean hasAddress() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'address' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder clearAddress() {
      address = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'avatarUrl' field.
      * @return The value.
      */
    public java.lang.String getAvatarUrl() {
      return avatarUrl;
    }


    /**
      * Sets the value of the 'avatarUrl' field.
      * @param value The value of 'avatarUrl'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder setAvatarUrl(java.lang.String value) {
      validate(fields()[7], value);
      this.avatarUrl = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'avatarUrl' field has been set.
      * @return True if the 'avatarUrl' field has been set, false otherwise.
      */
    public boolean hasAvatarUrl() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'avatarUrl' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder clearAvatarUrl() {
      avatarUrl = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'dob' field.
      * @return The value.
      */
    public java.time.Instant getDob() {
      return dob;
    }


    /**
      * Sets the value of the 'dob' field.
      * @param value The value of 'dob'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder setDob(java.time.Instant value) {
      validate(fields()[8], value);
      this.dob = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'dob' field has been set.
      * @return True if the 'dob' field has been set, false otherwise.
      */
    public boolean hasDob() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'dob' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder clearDob() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'updatedAt' field.
      * @return The value.
      */
    public java.time.Instant getUpdatedAt() {
      return updatedAt;
    }


    /**
      * Sets the value of the 'updatedAt' field.
      * @param value The value of 'updatedAt'.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder setUpdatedAt(java.time.Instant value) {
      validate(fields()[9], value);
      this.updatedAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'updatedAt' field has been set.
      * @return True if the 'updatedAt' field has been set, false otherwise.
      */
    public boolean hasUpdatedAt() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'updatedAt' field.
      * @return This builder.
      */
    public com.backend.programming.learning.system.kafka.auth.avro.model.UserUpdateRequestAvroModel.Builder clearUpdatedAt() {
      fieldSetFlags()[9] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserUpdateRequestAvroModel build() {
      try {
        UserUpdateRequestAvroModel record = new UserUpdateRequestAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.sagaId = fieldSetFlags()[1] ? this.sagaId : (java.lang.String) defaultValue(fields()[1]);
        record.userId = fieldSetFlags()[2] ? this.userId : (java.lang.String) defaultValue(fields()[2]);
        record.firstName = fieldSetFlags()[3] ? this.firstName : (java.lang.String) defaultValue(fields()[3]);
        record.lastName = fieldSetFlags()[4] ? this.lastName : (java.lang.String) defaultValue(fields()[4]);
        record.phone = fieldSetFlags()[5] ? this.phone : (java.lang.String) defaultValue(fields()[5]);
        record.address = fieldSetFlags()[6] ? this.address : (java.lang.String) defaultValue(fields()[6]);
        record.avatarUrl = fieldSetFlags()[7] ? this.avatarUrl : (java.lang.String) defaultValue(fields()[7]);
        record.dob = fieldSetFlags()[8] ? this.dob : (java.time.Instant) defaultValue(fields()[8]);
        record.updatedAt = fieldSetFlags()[9] ? this.updatedAt : (java.time.Instant) defaultValue(fields()[9]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<UserUpdateRequestAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<UserUpdateRequestAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<UserUpdateRequestAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<UserUpdateRequestAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










