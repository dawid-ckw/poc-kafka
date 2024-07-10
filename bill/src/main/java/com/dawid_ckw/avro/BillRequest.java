/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.dawid_ckw.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class BillRequest extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8625187993568072236L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"BillRequest\",\"namespace\":\"com.dawid_ckw.avro\",\"fields\":[{\"name\":\"userId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"period\",\"type\":{\"type\":\"enum\",\"name\":\"PeriodType\",\"symbols\":[\"YEAR\",\"MONTH\",\"DAY\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<BillRequest> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<BillRequest> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<BillRequest> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<BillRequest> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<BillRequest> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this BillRequest to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a BillRequest from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a BillRequest instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static BillRequest fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String userId;
  private com.dawid_ckw.avro.PeriodType period;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public BillRequest() {}

  /**
   * All-args constructor.
   * @param userId The new value for userId
   * @param period The new value for period
   */
  public BillRequest(java.lang.String userId, com.dawid_ckw.avro.PeriodType period) {
    this.userId = userId;
    this.period = period;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return userId;
    case 1: return period;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: userId = value$ != null ? value$.toString() : null; break;
    case 1: period = (com.dawid_ckw.avro.PeriodType)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
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
   * Gets the value of the 'period' field.
   * @return The value of the 'period' field.
   */
  public com.dawid_ckw.avro.PeriodType getPeriod() {
    return period;
  }


  /**
   * Sets the value of the 'period' field.
   * @param value the value to set.
   */
  public void setPeriod(com.dawid_ckw.avro.PeriodType value) {
    this.period = value;
  }

  /**
   * Creates a new BillRequest RecordBuilder.
   * @return A new BillRequest RecordBuilder
   */
  public static com.dawid_ckw.avro.BillRequest.Builder newBuilder() {
    return new com.dawid_ckw.avro.BillRequest.Builder();
  }

  /**
   * Creates a new BillRequest RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new BillRequest RecordBuilder
   */
  public static com.dawid_ckw.avro.BillRequest.Builder newBuilder(com.dawid_ckw.avro.BillRequest.Builder other) {
    if (other == null) {
      return new com.dawid_ckw.avro.BillRequest.Builder();
    } else {
      return new com.dawid_ckw.avro.BillRequest.Builder(other);
    }
  }

  /**
   * Creates a new BillRequest RecordBuilder by copying an existing BillRequest instance.
   * @param other The existing instance to copy.
   * @return A new BillRequest RecordBuilder
   */
  public static com.dawid_ckw.avro.BillRequest.Builder newBuilder(com.dawid_ckw.avro.BillRequest other) {
    if (other == null) {
      return new com.dawid_ckw.avro.BillRequest.Builder();
    } else {
      return new com.dawid_ckw.avro.BillRequest.Builder(other);
    }
  }

  /**
   * RecordBuilder for BillRequest instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<BillRequest>
    implements org.apache.avro.data.RecordBuilder<BillRequest> {

    private java.lang.String userId;
    private com.dawid_ckw.avro.PeriodType period;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.dawid_ckw.avro.BillRequest.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.userId)) {
        this.userId = data().deepCopy(fields()[0].schema(), other.userId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.period)) {
        this.period = data().deepCopy(fields()[1].schema(), other.period);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing BillRequest instance
     * @param other The existing instance to copy.
     */
    private Builder(com.dawid_ckw.avro.BillRequest other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.userId)) {
        this.userId = data().deepCopy(fields()[0].schema(), other.userId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.period)) {
        this.period = data().deepCopy(fields()[1].schema(), other.period);
        fieldSetFlags()[1] = true;
      }
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
    public com.dawid_ckw.avro.BillRequest.Builder setUserId(java.lang.String value) {
      validate(fields()[0], value);
      this.userId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'userId' field has been set.
      * @return True if the 'userId' field has been set, false otherwise.
      */
    public boolean hasUserId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'userId' field.
      * @return This builder.
      */
    public com.dawid_ckw.avro.BillRequest.Builder clearUserId() {
      userId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'period' field.
      * @return The value.
      */
    public com.dawid_ckw.avro.PeriodType getPeriod() {
      return period;
    }


    /**
      * Sets the value of the 'period' field.
      * @param value The value of 'period'.
      * @return This builder.
      */
    public com.dawid_ckw.avro.BillRequest.Builder setPeriod(com.dawid_ckw.avro.PeriodType value) {
      validate(fields()[1], value);
      this.period = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'period' field has been set.
      * @return True if the 'period' field has been set, false otherwise.
      */
    public boolean hasPeriod() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'period' field.
      * @return This builder.
      */
    public com.dawid_ckw.avro.BillRequest.Builder clearPeriod() {
      period = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public BillRequest build() {
      try {
        BillRequest record = new BillRequest();
        record.userId = fieldSetFlags()[0] ? this.userId : (java.lang.String) defaultValue(fields()[0]);
        record.period = fieldSetFlags()[1] ? this.period : (com.dawid_ckw.avro.PeriodType) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<BillRequest>
    WRITER$ = (org.apache.avro.io.DatumWriter<BillRequest>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<BillRequest>
    READER$ = (org.apache.avro.io.DatumReader<BillRequest>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.userId);

    out.writeEnum(this.period.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.userId = in.readString();

      this.period = com.dawid_ckw.avro.PeriodType.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.userId = in.readString();
          break;

        case 1:
          this.period = com.dawid_ckw.avro.PeriodType.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










